package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Segurancatb02Processo;
import br.com.helenamax.cobranca.model.Segurancatb06UsuarioProcesso;
import br.com.helenamax.cobranca.service.Segurancatb06UsuarioProcessoSrv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@SessionScoped
@Named
public class MenuCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    private List<Segurancatb02Processo> processos;

    private MenuModel menu = new DefaultMenuModel();

    private List<Object> submenu;

    private boolean menuAtualizado = false;

    @Inject
    private Segurancatb06UsuarioProcessoSrv segurancatb06UsuarioProcessoSrv;

    private List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessoColl;

    public MenuCtr() {

    }

    @PostConstruct
    public void init() {

        montarMenu();
    }

    public void montarMenu() {
        // if (!isMenuAtualizado()) {

        if (submenu == null) {
            submenu = new ArrayList<>();
        }

        if (processos == null) {
            processos = new ArrayList<>();
        }

        submenu.clear();
        menu.getElements().clear();

        listarPermissoes();

        for (Segurancatb06UsuarioProcesso processo : segurancatb06UsuarioProcessoColl) {
            if (processo.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo().getFlagMenu() == true
                    && processo.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo().getSegurancatb02ProcessoPai() == null) {

                if (processo.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo().getUrl() != null
                        && !processo.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo().getUrl().equals("")) {
                    submenu.add(retornarMenuItem(processo.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo()));
                } else {
                    submenu.add(retornarSubmenu(processo.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo()));
                }

            }
        }

        for (Object voSubmenu : submenu) {
            if (voSubmenu instanceof DefaultMenuItem) {
                menu.addElement((DefaultMenuItem) voSubmenu);
            } else {

                for (Segurancatb06UsuarioProcesso voProcesso : segurancatb06UsuarioProcessoColl) {

                    if (voProcesso.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo().getFlagMenu() == true
                            && voProcesso.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo().getSegurancatb02ProcessoPai() != null
                            && voProcesso.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo().getSegurancatb02ProcessoPai().getCodigoProcesso() == Integer.parseInt(((DefaultSubMenu) voSubmenu).getId())) {

                        ((DefaultSubMenu) voSubmenu).addElement(retornarMenuItem(voProcesso.getSegurancatb08ProcessoEmpresa().getSegurancatb02Processo()));
                    }
                }
                menu.addElement((DefaultSubMenu) voSubmenu);
            }

        }

        menuAtualizado = true;
        
        RequestContext.getCurrentInstance().update("frmMenuTopBar");
    }

    public DefaultSubMenu retornarSubmenu(Segurancatb02Processo processo) {

        DefaultSubMenu retorno = new DefaultSubMenu(processo.getDescricao());

        retorno.setId(String.valueOf(processo.getCodigoProcesso()));

        retorno.setStyleClass("FontLatoBold Fs14 Black Opac80 ui-sticky");

        if (processo.getIcone() != null) {
            retorno.setIcon("fa " + processo.getIcone() + " Fs15 Blue");
        }

        return retorno;
    }

    public DefaultMenuItem retornarMenuItem(Segurancatb02Processo processo) {
        DefaultMenuItem retorno = new DefaultMenuItem(processo.getDescricao());

        if (processo.getUrl() != null) {
            retorno.setUrl(processo.getUrl());
        }

        if (processo.getIcone() != null) {
            retorno.setIcon("fa " + processo.getIcone() + " Fs15 Navy");
        }
        
        retorno.setStyleClass("FontLatoBold Fs14 Black Opac80 ui-sticky");

        return retorno;
    }

    public void listarPermissoes() {
        if (getSegurancatb06UsuarioProcessoColl() == null) {
            segurancatb06UsuarioProcessoColl = new ArrayList<>();
        }
        getSegurancatb06UsuarioProcessoColl().clear();

        setSegurancatb06UsuarioProcessoColl(segurancatb06UsuarioProcessoSrv.listarPorUsuario());
    }
//------------------------------------------------------------------

    public MenuModel getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(MenuModel menu) {
        this.menu = menu;
    }

    /**
     * @return the menuAtualizado
     */
    public boolean isMenuAtualizado() {
        return menuAtualizado;
    }

    /**
     * @param menuAtualizado the menuAtualizado to set
     */
    public void setMenuAtualizado(boolean menuAtualizado) {
        this.menuAtualizado = menuAtualizado;
    }

    /**
     * @return the segurancatb06UsuarioProcessoColl
     */
    public List<Segurancatb06UsuarioProcesso> getSegurancatb06UsuarioProcessoColl() {
        return segurancatb06UsuarioProcessoColl;
    }

    /**
     * @param segurancatb06UsuarioProcessoColl the
     * segurancatb06UsuarioProcessoColl to set
     */
    public void setSegurancatb06UsuarioProcessoColl(List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessoColl) {
        this.segurancatb06UsuarioProcessoColl = segurancatb06UsuarioProcessoColl;
    }

}
