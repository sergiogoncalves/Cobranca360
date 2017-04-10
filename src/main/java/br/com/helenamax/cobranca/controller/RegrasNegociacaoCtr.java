package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Empresatb09EmpresaRegraRenegociacao;
import br.com.helenamax.cobranca.service.Empresatb09EmpresaRegraRenegociacaoSrv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ViewScoped
@Named
public class RegrasNegociacaoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb09EmpresaRegraRenegociacaoSrv empresatb09EmpresaRegraRenegociacaoSrv;

    @Inject
    private Empresatb09EmpresaRegraRenegociacao regraRenegociacaoEscolhida;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    private List<Empresatb09EmpresaRegraRenegociacao> regraRenegociacaoColl;

    public void init() {
        listarRegras();
    }

    public void gravarRegra() {
        try {
            empresatb09EmpresaRegraRenegociacaoSrv.salvarMerge(regraRenegociacaoEscolhida);
            

            listarRegras();
            
            regraRenegociacaoEscolhida = null;
            regraRenegociacaoEscolhida = new Empresatb09EmpresaRegraRenegociacao();
            
            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");
            
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void mudarRegraPrincipal() {
       regraRenegociacaoEscolhida.setAtivo(regraRenegociacaoEscolhida.getAtivo());
    }

    public void listarRegras() {
        if (regraRenegociacaoColl == null) {
            regraRenegociacaoColl = new ArrayList<>();
        }
        regraRenegociacaoColl = empresatb09EmpresaRegraRenegociacaoSrv.listarPorEmpresa(usuarioSessaoCtr.getEmpresatb01Empresa());
    }

    
    public void mudarRegras(SelectEvent event){
        regraRenegociacaoEscolhida = (Empresatb09EmpresaRegraRenegociacao) event.getObject();
    }
    
    /**
     * @return the RegraRenegociacaoEscolhida
     */
    public Empresatb09EmpresaRegraRenegociacao getRegraRenegociacaoEscolhida() {
        return regraRenegociacaoEscolhida;
    }

    public void setRegraRenegociacaoEscolhida(Empresatb09EmpresaRegraRenegociacao regraRenegociacaoEscolhida) {
        this.regraRenegociacaoEscolhida = regraRenegociacaoEscolhida;
    }
    
    

    /**
     * @return the regraRenegociacaoColl
     */
    public List<Empresatb09EmpresaRegraRenegociacao> getRegraRenegociacaoColl() {
        return regraRenegociacaoColl;
    }

    /**
     * @param regraRenegociacaoColl the regraRenegociacaoColl to set
     */
    public void setRegraRenegociacaoColl(List<Empresatb09EmpresaRegraRenegociacao> regraRenegociacaoColl) {
        this.regraRenegociacaoColl = regraRenegociacaoColl;
    }

}
