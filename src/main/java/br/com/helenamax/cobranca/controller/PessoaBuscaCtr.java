package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
import br.com.helenamax.cobranca.model.Empresatb04PessoaJuridica;
import br.com.helenamax.cobranca.model.Empresatb05PessoaEndereco;
import br.com.helenamax.cobranca.model.Empresatb06PessoaContato;
import br.com.helenamax.cobranca.model.Geraltb02TipoContato;
import br.com.helenamax.cobranca.service.Empresatb03PessoaFisicaSrv;
import br.com.helenamax.cobranca.service.Empresatb04PessoaJuridicaSrv;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ViewScoped
@Named
public class PessoaBuscaCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private Empresatb02Pessoa empresatb02PessoaBusca;

    @Inject
    private Empresatb03PessoaFisica empresatb03PessoaFisica;

    @Inject
    private Empresatb04PessoaJuridica empresatb04PessoaJuridica;

    private List<Empresatb03PessoaFisica> empresatb03PessoaFisicaResultadoColl;

    private List<Empresatb04PessoaJuridica> empresatb04PessoaJuridicaResultadoColl;
    //--------------------------------------------
    @Inject
    private Empresatb06PessoaContato empresatb06PessoaContatoEscolhido;

    @Inject
    private Geraltb02TipoContato geraltb02TipoContatoEscolhido;

    @Inject
    private Empresatb05PessoaEndereco empresatb05PessoaEndereco;

    @Inject
    private Empresatb03PessoaFisicaSrv empresatb03PessoaFisicaSrv;

    @Inject
    private Empresatb04PessoaJuridicaSrv empresatb04PessoaJuridicaSrv;

    private Collection<Empresatb06PessoaContato> empresatb06PessoaContatoColl;

    private Collection<Geraltb02TipoContato> geraltb02TipoContato;

    private Collection<Empresatb05PessoaEndereco> empresatb05PessoaEnderecoColl;

    private Collection<Empresatb02Pessoa> empresatb02PessoaColl;

    private int qtdeResultado;

    private Object retorno;

    @PostConstruct
    public void init() {
        empresatb02PessoaBusca.setTipoPessoa("F");
        usuarioSessaoCtr.init();
    }

//-------------------------------------------------------------
    public static boolean isPostback() {
        return FacesContext.getCurrentInstance().isPostback();
    }

    public void cancelarSelecao() {
        RequestContext.getCurrentInstance().closeDialog(null);
    }
    
    public void retornarSelecao(){
        RequestContext.getCurrentInstance().closeDialog(retorno);
    }

    public void onRowSelect(SelectEvent event) {

        try {
            retorno = event.getObject();
        } catch (Exception ex) {

        }
    }

    public void buscarPessoa() {

        try {

            if (empresatb03PessoaFisicaResultadoColl != null) {
                empresatb03PessoaFisicaResultadoColl.clear();
            }

            if (empresatb04PessoaJuridicaResultadoColl != null) {
                empresatb04PessoaJuridicaResultadoColl.clear();
            }

            if (empresatb02PessoaBusca.getTipoPessoa().equals("F")) {

                if (empresatb03PessoaFisica.getEmpresatb02Pessoa() == null) {
                    empresatb03PessoaFisica.setEmpresatb02Pessoa(new Empresatb02Pessoa());
                }

                if (!empresatb02PessoaBusca.getCpfCnpj().equals("")) {
                    empresatb03PessoaFisica.setDocFederal(empresatb02PessoaBusca.getCpfCnpj());
                }

                if (!empresatb02PessoaBusca.getNome().equals("")) {

                    empresatb03PessoaFisica.getEmpresatb02Pessoa().setNome(empresatb02PessoaBusca.getNome());
                }

                empresatb03PessoaFisicaResultadoColl = empresatb03PessoaFisicaSrv.pesquisarFiltro(empresatb03PessoaFisica);

                qtdeResultado = empresatb03PessoaFisicaResultadoColl.size();
            }
            if (empresatb02PessoaBusca.getTipoPessoa().equals("J")) {

                if (!empresatb02PessoaBusca.getCpfCnpj().equals("")) {
                    empresatb04PessoaJuridica.setCnpj(empresatb02PessoaBusca.getCpfCnpj());
                }

                if (!empresatb02PessoaBusca.getNome().equals("")) {
                    empresatb04PessoaJuridica.setNomeFantasia(empresatb02PessoaBusca.getNome());
                }

                empresatb04PessoaJuridicaResultadoColl = empresatb04PessoaJuridicaSrv.pesquisarFiltro(empresatb04PessoaJuridica);
                qtdeResultado = empresatb04PessoaJuridicaResultadoColl.size();

            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    /**
     * @return the empresatb06PessoaContatoColl
     */
    public Collection<Empresatb06PessoaContato> getEmpresatb06PessoaContatoColl() {
        return empresatb06PessoaContatoColl;
    }

    /**
     * @return the geraltb02TipoContato
     */
    public Collection<Geraltb02TipoContato> getGeraltb02TipoContato() {
        return geraltb02TipoContato;
    }

    /**
     * @return the empresatb06PessoaContatoEscolhido
     */
    public Empresatb06PessoaContato getEmpresatb06PessoaContatoEscolhido() {
        return empresatb06PessoaContatoEscolhido;
    }

    /**
     * @param empresatb06PessoaContatoEscolhido the
     * empresatb06PessoaContatoEscolhido to set
     */
    public void setEmpresatb06PessoaContatoEscolhido(Empresatb06PessoaContato empresatb06PessoaContatoEscolhido) {
        this.empresatb06PessoaContatoEscolhido = empresatb06PessoaContatoEscolhido;
    }

    /**
     * @return the geraltb02TipoContatoEscolhido
     */
    public Geraltb02TipoContato getGeraltb02TipoContatoEscolhido() {
        return geraltb02TipoContatoEscolhido;
    }

    /**
     * @param geraltb02TipoContatoEscolhido the geraltb02TipoContatoEscolhido to
     * set
     */
    public void setGeraltb02TipoContatoEscolhido(Geraltb02TipoContato geraltb02TipoContatoEscolhido) {
        this.geraltb02TipoContatoEscolhido = geraltb02TipoContatoEscolhido;
    }

    /**
     * @return the empresatb05PessoaEndereco
     */
    public Empresatb05PessoaEndereco getEmpresatb05PessoaEndereco() {
        return empresatb05PessoaEndereco;
    }

    /**
     * @return the empresatb05PessoaEnderecoColl
     */
    public Collection<Empresatb05PessoaEndereco> getEmpresatb05PessoaEnderecoColl() {
        return empresatb05PessoaEnderecoColl;
    }

    /**
     * @param empresatb05PessoaEnderecoColl the empresatb05PessoaEnderecoColl to
     * set
     */
    public void setEmpresatb05PessoaEnderecoColl(Collection<Empresatb05PessoaEndereco> empresatb05PessoaEnderecoColl) {
        this.empresatb05PessoaEnderecoColl = empresatb05PessoaEnderecoColl;
    }

    /**
     * @return the empresatb02PessoaColl
     */
    public Collection<Empresatb02Pessoa> getEmpresatb02PessoaColl() {
        return empresatb02PessoaColl;
    }

    /**
     * @return the Empresatb02PessoaBusca
     */
    public Empresatb02Pessoa getEmpresatb02PessoaBusca() {
        return empresatb02PessoaBusca;
    }

    /**
     * @param Empresatb02PessoaBusca the Empresatb02PessoaBusca to set
     */
    public void setEmpresatb02PessoaBusca(Empresatb02Pessoa Empresatb02PessoaBusca) {
        this.empresatb02PessoaBusca = Empresatb02PessoaBusca;
    }

    /**
     * @return the empresatb03PessoaFisica
     */
    public Empresatb03PessoaFisica getEmpresatb03PessoaFisica() {
        return empresatb03PessoaFisica;
    }

    /**
     * @param empresatb03PessoaFisica the empresatb03PessoaFisica to set
     */
    public void setEmpresatb03PessoaFisica(Empresatb03PessoaFisica empresatb03PessoaFisica) {
        this.empresatb03PessoaFisica = empresatb03PessoaFisica;
    }

    /**
     * @return the empresatb03PessoaFisicaResultadoColl
     */
    public List<Empresatb03PessoaFisica> getEmpresatb03PessoaFisicaResultadoColl() {
        return empresatb03PessoaFisicaResultadoColl;
    }

    /**
     * @param empresatb03PessoaFisicaResultadoColl the
     * empresatb03PessoaFisicaResultadoColl to set
     */
    public void setEmpresatb03PessoaFisicaResultadoColl(List<Empresatb03PessoaFisica> empresatb03PessoaFisicaResultadoColl) {
        this.empresatb03PessoaFisicaResultadoColl = empresatb03PessoaFisicaResultadoColl;
    }

    /**
     * @return the empresatb04PessoaJuridica
     */
    public Empresatb04PessoaJuridica getEmpresatb04PessoaJuridica() {
        return empresatb04PessoaJuridica;
    }

    /**
     * @param empresatb04PessoaJuridica the empresatb04PessoaJuridica to set
     */
    public void setEmpresatb04PessoaJuridica(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
        this.empresatb04PessoaJuridica = empresatb04PessoaJuridica;
    }

    /**
     * @return the Empresatb04PessoaJuridicaResultadoColl
     */
    public List<Empresatb04PessoaJuridica> getEmpresatb04PessoaJuridicaResultadoColl() {
        return empresatb04PessoaJuridicaResultadoColl;
    }

    /**
     * @param Empresatb04PessoaJuridicaResultadoColl the
     * Empresatb04PessoaJuridicaResultadoColl to set
     */
    public void setEmpresatb04PessoaJuridicaResultadoColl(List<Empresatb04PessoaJuridica> Empresatb04PessoaJuridicaResultadoColl) {
        this.empresatb04PessoaJuridicaResultadoColl = Empresatb04PessoaJuridicaResultadoColl;
    }

    /**
     * @return the qtdeResultado
     */
    public int getQtdeResultado() {
        return qtdeResultado;
    }

    /**
     * @param qtdeResultado the qtdeResultado to set
     */
    public void setQtdeResultado(int qtdeResultado) {
        this.qtdeResultado = qtdeResultado;
    }

    /**
     * @return the retorno
     */
    public Object getRetorno() {
        return retorno;
    }

}
