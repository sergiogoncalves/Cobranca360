package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
import br.com.helenamax.cobranca.model.Empresatb05PessoaEndereco;
import br.com.helenamax.cobranca.model.Empresatb06PessoaContato;
import br.com.helenamax.cobranca.model.Geraltb02TipoContato;
import br.com.helenamax.cobranca.service.Empresatb02PessoaSrv;
import br.com.helenamax.cobranca.service.Empresatb03PessoaFisicaSrv;
import br.com.helenamax.cobranca.service.Empresatb06PessoaContatoSrv;
import br.com.helenamax.cobranca.service.Geraltb02TipoContatoSrv;
import br.com.helenamax.cobranca.util.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ViewScoped
@Named
public class PessoaCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb02Pessoa empresatb02Pessoa;

    @Inject
    private Empresatb03PessoaFisica empresatb03PessoaFisica;

    @Inject
    private Empresatb03PessoaFisica empresatb03PessoaFisicaPesquisa;

    @Inject
    private Geraltb02TipoContatoSrv geraltb02TipoContatoSrv;

    @Inject
    private Empresatb06PessoaContato empresatb06PessoaContatoEscolhido;

    @Inject
    private Geraltb02TipoContato geraltb02TipoContatoEscolhido;

    @Inject
    private Empresatb06PessoaContatoSrv empresatb06PessoaContatoSrv;

    @Inject
    private Empresatb05PessoaEndereco empresatb05PessoaEndereco;

    @Inject
    private ParametroSessaoCtr parametroSessaoCtr;

    @Inject
    Empresatb02PessoaSrv empresatb02PessoaSrv;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private Empresatb03PessoaFisicaSrv empresatb03PessoaFisicaSrv;

    private List<Empresatb06PessoaContato> empresatb06PessoaContatoColl;

    private List<Empresatb03PessoaFisica> empresatb03PessoaFisicaColl;

    private List<Geraltb02TipoContato> geraltb02TipoContato;

    private List<Empresatb05PessoaEndereco> empresatb05PessoaEnderecoColl;

    private List<Empresatb02Pessoa> empresatb02PessoaColl;

    public void iniciarCadastro() {
        listarTipoContatos();

        if (empresatb02Pessoa.getPessoaCodigo() != 0) {
            empresatb03PessoaFisica = empresatb03PessoaFisicaSrv.listarPorPessoa(empresatb02Pessoa);

            empresatb06PessoaContatoColl = empresatb06PessoaContatoSrv.listarPorPessoa(empresatb02Pessoa);
        }

    }

    public void iniciarPrincipal() {
        empresatb03PessoaFisicaPesquisa.setEmpresatb02Pessoa(new Empresatb02Pessoa());
    }

    public void listarTipoContatos() {
        geraltb02TipoContato = geraltb02TipoContatoSrv.listar();
    }

    public Empresatb06PessoaContato buscarPessoaContatoByCodigo(int codigo) {
        return empresatb06PessoaContatoSrv.listarPorId(codigo);
    }

    private void instanciarUsuario() {

    }

    public void buscarPessoa() {
        try {

            instanciarUsuario();
            if (empresatb03PessoaFisicaColl == null) {
                empresatb03PessoaFisicaColl = new ArrayList<>();
            }

            empresatb03PessoaFisicaColl.clear();

            if (empresatb03PessoaFisicaPesquisa.getEmpresatb02Pessoa() == null) {
                getEmpresatb03PessoaFisicaPesquisa().setEmpresatb02Pessoa(new Empresatb02Pessoa());
            }

            getEmpresatb03PessoaFisicaPesquisa().getEmpresatb02Pessoa().setEmpresatb01Empresa(usuarioSessaoCtr.getEmpresatb01Empresa());
            empresatb03PessoaFisicaColl = empresatb03PessoaFisicaSrv.pesquisarFiltro(getEmpresatb03PessoaFisicaPesquisa());

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Resultados encontrados: ", String.valueOf(empresatb03PessoaFisicaColl.size())));

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void salvarContatos() {
        if (empresatb06PessoaContatoColl == null) {
            empresatb06PessoaContatoColl = new ArrayList<>();
        }
        if (empresatb06PessoaContatoEscolhido.getGeraltb02TipoContato() != null) {

            if (empresatb06PessoaContatoEscolhido.getCodigoPessoaContato() != 0) {
                for (Empresatb06PessoaContato vo : empresatb06PessoaContatoColl) {
                    if (vo.getCodigoPessoaContato() == empresatb06PessoaContatoEscolhido.getCodigoPessoaContato()) {
                        vo = empresatb06PessoaContatoEscolhido;
                    }
                }
            } else {

                empresatb06PessoaContatoEscolhido.setColunaAleatoria(StringUtil.retornaNumeroAlatorio());

                empresatb06PessoaContatoColl.add(empresatb06PessoaContatoEscolhido);
            }

            empresatb06PessoaContatoEscolhido = new Empresatb06PessoaContato();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no formulário:", "Selecione o tipo de contato"));
        }

    }

    public void alterarContato(SelectEvent event) {
        empresatb06PessoaContatoEscolhido = (Empresatb06PessoaContato) event.getObject();
        RequestContext.getCurrentInstance().update("dados:frmContato");
    }

    public void beforeExcluirParcela() {

        if (empresatb06PessoaContatoEscolhido.getColunaAleatoria() != 0) {
            RequestContext.getCurrentInstance().execute("PF('dlgExcluirContato').show();");
        }

    }

    public void salvarEnderecos() {

        if (empresatb05PessoaEnderecoColl == null) {
            empresatb05PessoaEnderecoColl = new ArrayList<>();
        }

        empresatb05PessoaEnderecoColl.add(empresatb05PessoaEndereco);

        empresatb05PessoaEndereco = new Empresatb05PessoaEndereco();
    }

    public void abrirBuscaPessoa() {
        try {
            RequestContext.getCurrentInstance().openDialog("pessoa-fisica-busca", parametroSessaoCtr.retornarParametrosTelaBuscaPessoa(), null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void salvarPessoa() {
        try {
            if (empresatb02Pessoa.getNome() == null || empresatb02Pessoa.getNome().equals("")) {
                throw new Exception("Nome obrigatório");
            }

            if (empresatb03PessoaFisica.getDocFederal() == null || empresatb03PessoaFisica.getDocFederal().equals("")) {
                throw new Exception("Nome obrigatório");
            }
            instanciarUsuario();

            getEmpresatb02Pessoa().setEmpresatb01Empresa(usuarioSessaoCtr.getEmpresatb01Empresa());

            getEmpresatb02Pessoa().setTipoPessoa("F");

            getEmpresatb02Pessoa().setEmpresatb05PessoaEnderecos(empresatb05PessoaEnderecoColl);

            getEmpresatb02Pessoa().setEmpresatb06PessoaContatos(empresatb06PessoaContatoColl);

            empresatb02PessoaSrv.salvarMerge(getEmpresatb02Pessoa(), empresatb03PessoaFisica);

            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar", e.getMessage()));
        }
    }
    
    public void mudarPrincipalContato(){
        empresatb06PessoaContatoEscolhido.setPrincipal(empresatb06PessoaContatoEscolhido.getPrincipal());
    }

    public void excluirContato() {

        int position = 0;
        int positionSelecionada = -1;

        for (Empresatb06PessoaContato vo : empresatb06PessoaContatoColl) {
            position++;
            if (vo.getColunaAleatoria() == empresatb06PessoaContatoEscolhido.getColunaAleatoria()) {
                positionSelecionada = position - 1;
            }
        }

        empresatb06PessoaContatoSrv.excluirContato(empresatb06PessoaContatoEscolhido);
        
        empresatb06PessoaContatoColl.remove(positionSelecionada);
    }

//-------------------------------------------------------------
    /**
     * @return the empresatb03PessoaFisica
     */
    public Empresatb03PessoaFisica getEmpresatb03PessoaFisica() {
        return empresatb03PessoaFisica;
    }

    /**
     * @return the empresatb06PessoaContatoColl
     */
    public List<Empresatb06PessoaContato> getEmpresatb06PessoaContatoColl() {
        return empresatb06PessoaContatoColl;
    }

    /**
     * @return the geraltb02TipoContato
     */
    public List<Geraltb02TipoContato> getGeraltb02TipoContato() {
        return geraltb02TipoContato;
    }

    /**
     * @return the empresatb03PessoaFisicaColl
     */
    public List<Empresatb03PessoaFisica> getEmpresatb03PessoaFisicaColl() {
        return empresatb03PessoaFisicaColl;
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
    public List<Empresatb05PessoaEndereco> getEmpresatb05PessoaEnderecoColl() {
        return empresatb05PessoaEnderecoColl;
    }

    /**
     * @param empresatb05PessoaEnderecoColl the empresatb05PessoaEnderecoColl to
     * set
     */
    public void setEmpresatb05PessoaEnderecoColl(List<Empresatb05PessoaEndereco> empresatb05PessoaEnderecoColl) {
        this.empresatb05PessoaEnderecoColl = empresatb05PessoaEnderecoColl;
    }

    /**
     * @return the empresatb02PessoaColl
     */
    public List<Empresatb02Pessoa> getEmpresatb02PessoaColl() {
        return empresatb02PessoaColl;
    }

    /**
     * @return the empresatb03PessoaFisicaPesquisa
     */
    public Empresatb03PessoaFisica getEmpresatb03PessoaFisicaPesquisa() {
        return empresatb03PessoaFisicaPesquisa;
    }

    /**
     * @param empresatb03PessoaFisicaPesquisa the
     * empresatb03PessoaFisicaPesquisa to set
     */
    public void setEmpresatb03PessoaFisicaPesquisa(Empresatb03PessoaFisica empresatb03PessoaFisicaPesquisa) {
        this.empresatb03PessoaFisicaPesquisa = empresatb03PessoaFisicaPesquisa;
    }

    /**
     * @return the empresatb02Pessoa
     */
    public Empresatb02Pessoa getEmpresatb02Pessoa() {
        return empresatb02Pessoa;
    }

    /**
     * @param empresatb02Pessoa the empresatb02Pessoa to set
     */
    public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
        this.empresatb02Pessoa = empresatb02Pessoa;
    }

}
