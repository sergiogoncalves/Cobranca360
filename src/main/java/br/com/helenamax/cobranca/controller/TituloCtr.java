/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.dominio.DmnSituacaoFinanceira;
import br.com.helenamax.cobranca.model.Cobrancatb01Titulo;
import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Cobrancatb05TituloParcelaCheque;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
import br.com.helenamax.cobranca.model.Empresatb04PessoaJuridica;
import br.com.helenamax.cobranca.model.Geraltb01SituacaoFinanceira;
import br.com.helenamax.cobranca.service.Cobrancatb01TituloSrv;
import br.com.helenamax.cobranca.service.Cobrancatb02TituloParcelaSrv;
import br.com.helenamax.cobranca.service.Cobrancatb05TituloParcelaChequeSrv;
import br.com.helenamax.cobranca.service.Empresatb03PessoaFisicaSrv;
import br.com.helenamax.cobranca.service.Empresatb04PessoaJuridicaSrv;
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

/**
 *
 * @author 005712431
 */
@Named
@ViewScoped
public class TituloCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ParametroSessaoCtr parametroSessaoCtr;

    @Inject
    private Empresatb03PessoaFisica credorFisica;

    @Inject
    private Empresatb04PessoaJuridica credorJuridica;

    @Inject
    private Empresatb03PessoaFisica devedorFisica;

    @Inject
    private Empresatb04PessoaJuridica devedorJuridica;

    @Inject
    private Cobrancatb01Titulo cobrancatb01Titulo;

    @Inject
    private Cobrancatb02TituloParcela cobrancatb02TituloParcela;

    @Inject
    private Cobrancatb05TituloParcelaCheque cobrancatb05TituloParcelaCheque;

    @Inject
    private ComponentesCtr componentesCtr;

    @Inject
    private Cobrancatb01TituloSrv cobrancatb01TituloSrv;

    @Inject
    private Cobrancatb02TituloParcelaSrv cobrancatb02TituloParcelaSrv;

    @Inject
    private Empresatb03PessoaFisicaSrv empresatb03PessoaFisicaSrv;

    @Inject
    private Empresatb04PessoaJuridicaSrv empresatb04PessoaJuridicaSrv;

    @Inject
    private Cobrancatb05TituloParcelaChequeSrv cobrancatb05TituloParcelaChequeSrv;
    
    @Inject
    private Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira;

    private List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelaCadastroColl;

    private List<Cobrancatb01Titulo> cobrancatb01TituloColl;

    private List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelaColl;

    private String nomeCredor;
    private String nomeDevedor;
    private String cpfDevedor;
    private boolean tituloRegrasProprias = true;

    public void init() {
        try {
            componentesCtr.ListarCobrancatb03TituloTipo();
            tituloRegrasProprias = true;
            buscarSituacao();

            if (cobrancatb01Titulo.getCodigoTitulo() != 0) {

                if (cobrancatb01Titulo.getEmpresatb02PessoaDevedor().getTipoPessoa().equals("F")) {
                    devedorFisica = empresatb03PessoaFisicaSrv.listarPorId(cobrancatb01Titulo.getEmpresatb02PessoaDevedor().getPessoaCodigo());
                    nomeDevedor = devedorFisica.getEmpresatb02Pessoa().getNome();
                    cpfDevedor = devedorFisica.getDocFederal();
                } else {
                    devedorJuridica = empresatb04PessoaJuridicaSrv.listarPorId(cobrancatb01Titulo.getEmpresatb02PessoaDevedor().getPessoaCodigo());
                    nomeDevedor = devedorJuridica.getEmpresatb02Pessoa().getNome();
                }

                if (cobrancatb01Titulo.getEmpresatb02PessoaCredor().getTipoPessoa().equals("F")) {
                    credorFisica = empresatb03PessoaFisicaSrv.listarPorId(cobrancatb01Titulo.getEmpresatb02PessoaCredor().getPessoaCodigo());
                    nomeCredor = credorFisica.getEmpresatb02Pessoa().getNome();
                } else {

                    credorJuridica = empresatb04PessoaJuridicaSrv.listarPorId(cobrancatb01Titulo.getEmpresatb02PessoaCredor().getPessoaCodigo());
                    nomeCredor = credorJuridica.getEmpresatb02Pessoa().getNome();

                }

                cobrancatb02TituloParcelaCadastroColl = cobrancatb02TituloParcelaSrv.listarPorTitulo(cobrancatb01Titulo);

                cobrancatb05TituloParcelaChequeSrv.inserirCheques(cobrancatb02TituloParcelaCadastroColl);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void buscarSituacao(){
        if (geraltb01SituacaoFinanceira.getCodigoSituacao() == 0) {
            geraltb01SituacaoFinanceira = parametroSessaoCtr.retornarSituacaoPorSigla(DmnSituacaoFinanceira.EM_ABERTO.toString());
        }
    }

    public void abrirBuscaPessoa() {
        try {
            RequestContext.getCurrentInstance().openDialog("/pessoa/pessoa-fisica-busca", parametroSessaoCtr.retornarParametrosTelaBuscaPessoa(), null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onCredorBuscaReturn(SelectEvent event) {
        try {
            if (event.getObject() != null) {
                if (event.getObject() instanceof Empresatb03PessoaFisica) {
                    credorFisica = (Empresatb03PessoaFisica) event.getObject();
                    nomeCredor = credorFisica.getEmpresatb02Pessoa().getNome();
                    cobrancatb01Titulo.setEmpresatb02PessoaCredor(credorFisica.getEmpresatb02Pessoa());

                }

                if (event.getObject() instanceof Empresatb04PessoaJuridica) {
                    credorJuridica = (Empresatb04PessoaJuridica) event.getObject();
                    nomeCredor = credorJuridica.getNomeFantasia();
                    cobrancatb01Titulo.setEmpresatb02PessoaCredor(credorJuridica.getEmpresatb02Pessoa());

                }
            }
        } catch (Exception e) {
        }
    }

    public void onDevedorBuscaReturn(SelectEvent event) {
        try {
            if (event.getObject() != null) {
                if (event.getObject() instanceof Empresatb03PessoaFisica) {
                    devedorFisica = (Empresatb03PessoaFisica) event.getObject();
                    nomeDevedor = devedorFisica.getEmpresatb02Pessoa().getNome();
                    cpfDevedor = devedorFisica.getDocFederal();

                    cobrancatb01Titulo.setEmpresatb02PessoaDevedor(devedorFisica.getEmpresatb02Pessoa());

                }

                if (event.getObject() instanceof Empresatb04PessoaJuridica) {
                    devedorJuridica = (Empresatb04PessoaJuridica) event.getObject();
                    nomeDevedor = devedorJuridica.getNomeFantasia();
                    cpfDevedor = devedorJuridica.getCnpj();

                    cobrancatb01Titulo.setEmpresatb02PessoaDevedor(devedorJuridica.getEmpresatb02Pessoa());
                }
            }
        } catch (Exception e) {
        }
    }

    public void onPrincipaBuscaReturn(SelectEvent event) {
        try {
            if (event.getObject() != null) {

                if (cobrancatb02TituloParcelaColl != null) {
                    cobrancatb02TituloParcelaColl.clear();
                }

                if (event.getObject() instanceof Empresatb03PessoaFisica) {
                    devedorFisica = (Empresatb03PessoaFisica) event.getObject();
                    nomeDevedor = devedorFisica.getEmpresatb02Pessoa().getNome();
                    cpfDevedor = devedorFisica.getDocFederal();

                    cobrancatb01Titulo.setEmpresatb02PessoaDevedor(devedorFisica.getEmpresatb02Pessoa());

                    cobrancatb01TituloColl = cobrancatb01TituloSrv.listarPorPessoa(devedorFisica.getEmpresatb02Pessoa());

                }

                if (event.getObject() instanceof Empresatb04PessoaJuridica) {
                    devedorJuridica = (Empresatb04PessoaJuridica) event.getObject();
                    nomeDevedor = devedorJuridica.getNomeFantasia();
                    cpfDevedor = devedorJuridica.getCnpj();

                    cobrancatb01Titulo.setEmpresatb02PessoaDevedor(devedorJuridica.getEmpresatb02Pessoa());
                }
            }
        } catch (Exception e) {
        }

    }

    public void mudarRegrasProprias() {
        tituloRegrasProprias = !tituloRegrasProprias;
    }

    public void limparForm() {
        cobrancatb01Titulo = null;
        cobrancatb01Titulo = new Cobrancatb01Titulo();
        cobrancatb02TituloParcelaCadastroColl.clear();

        cobrancatb02TituloParcelaCadastroColl = null;

        cobrancatb02TituloParcelaCadastroColl = new ArrayList<>();

        nomeCredor = "";
        nomeDevedor = "";
        cpfDevedor = "";
    }

    public void adicionarParcela() {

        instanciarObjetos();
        if (cobrancatb02TituloParcela.getColunaAleatoria() == 0) {
            cobrancatb02TituloParcela.setColunaAleatoria(StringUtil.retornaNumeroAlatorio());

            cobrancatb02TituloParcela.setCobrancatb05TituloParcelaCheque(cobrancatb05TituloParcelaCheque);

            cobrancatb02TituloParcela.setGeraltb01SituacaoFinanceira(geraltb01SituacaoFinanceira);
            
            cobrancatb02TituloParcelaCadastroColl.add(cobrancatb02TituloParcela);
        } else {
            for (Cobrancatb02TituloParcela vo : cobrancatb02TituloParcelaCadastroColl) {
                if (vo.getColunaAleatoria() == cobrancatb02TituloParcela.getColunaAleatoria()) {
                    vo = getCobrancatb02TituloParcela();
                }

            }
        }

        cobrancatb02TituloParcela = null;
        cobrancatb02TituloParcela = new Cobrancatb02TituloParcela();

        cobrancatb05TituloParcelaCheque = null;
        cobrancatb05TituloParcelaCheque = new Cobrancatb05TituloParcelaCheque();
    }

    public void beforeExcluirParcela() {

        if (cobrancatb02TituloParcela.getColunaAleatoria() != 0) {
            RequestContext.getCurrentInstance().execute("PF('dlgExcluir').show();");
        }

    }

    public void excluirParcela() {

        int position = 0;
        int positionSelecionada = -1;

        for (Cobrancatb02TituloParcela vo : cobrancatb02TituloParcelaCadastroColl) {
            position++;
            if (vo.getColunaAleatoria() == cobrancatb02TituloParcela.getColunaAleatoria()) {
                positionSelecionada = position - 1;
            }
        }

        cobrancatb02TituloParcelaSrv.remover(cobrancatb02TituloParcelaCadastroColl.get(positionSelecionada));

        cobrancatb02TituloParcelaCadastroColl.remove(positionSelecionada);
    }

    public void instanciarObjetos() {
        if (cobrancatb02TituloParcelaCadastroColl == null) {
            cobrancatb02TituloParcelaCadastroColl = new ArrayList<>();
        }
    }

    public void onRowSelect(SelectEvent event) {
        try {
            cobrancatb02TituloParcela = (Cobrancatb02TituloParcela) event.getObject();
            
            if (cobrancatb02TituloParcela.getCobrancatb05TituloParcelaCheque() != null) {
                cobrancatb05TituloParcelaCheque = cobrancatb02TituloParcela.getCobrancatb05TituloParcelaCheque();
            }
            
        } catch (Exception ex) {

        }
    }

    public void gravarTitulo() {
        try {

            if (cobrancatb01Titulo.getCodigoTitulo() == 0) {
                Geraltb01SituacaoFinanceira sitFinanceira = new Geraltb01SituacaoFinanceira();

                
                cobrancatb01Titulo.setGeraltb01SituacaoFinanceira(geraltb01SituacaoFinanceira);
            }
            cobrancatb01TituloSrv.salvar(cobrancatb01Titulo, cobrancatb02TituloParcelaCadastroColl);

            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar", e.getMessage()));
        }
    }

    public void onRowTituloPrincipalSelect(SelectEvent event) {
        try {
            cobrancatb02TituloParcelaColl = cobrancatb02TituloParcelaSrv.listarPorTitulo((Cobrancatb01Titulo) event.getObject());
        } catch (Exception e) {
        }
    }

    /**
     * @return the credorFisica
     */
    public Empresatb03PessoaFisica getCredorFisica() {
        return credorFisica;
    }

    /**
     * @return the credorJuridica
     */
    public Empresatb04PessoaJuridica getCredorJuridica() {
        return credorJuridica;
    }

    /**
     * @return the devedorFisica
     */
    public Empresatb03PessoaFisica getDevedorFisica() {
        return devedorFisica;
    }

    /**
     * @return the devedorJuridica
     */
    public Empresatb04PessoaJuridica getDevedorJuridica() {
        return devedorJuridica;
    }

    /**
     * @return the nomeCredor
     */
    public String getNomeCredor() {
        return nomeCredor;
    }

    /**
     * @param nomeCredor the nomeCredor to set
     */
    public void setNomeCredor(String nomeCredor) {
        this.nomeCredor = nomeCredor;
    }

    /**
     * @return the nomeDevedor
     */
    public String getNomeDevedor() {
        return nomeDevedor;
    }

    /**
     * @param nomeDevedor the nomeDevedor to set
     */
    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    /**
     * @return the cpfDevedor
     */
    public String getCpfDevedor() {
        return cpfDevedor;
    }

    /**
     * @param cpfDevedor the cpfDevedor to set
     */
    public void setCpfDevedor(String cpfDevedor) {
        this.cpfDevedor = cpfDevedor;
    }

    /**
     * @return the cobrancatb01Titulo
     */
    public Cobrancatb01Titulo getCobrancatb01Titulo() {
        return cobrancatb01Titulo;
    }

    /**
     * @param cobrancatb01Titulo the cobrancatb01Titulo to set
     */
    public void setCobrancatb01Titulo(Cobrancatb01Titulo cobrancatb01Titulo) {
        this.cobrancatb01Titulo = cobrancatb01Titulo;
    }

    /**
     * @return the tituloRegrasProprias
     */
    public boolean isTituloRegrasProprias() {
        return tituloRegrasProprias;
    }

    /**
     * @param tituloRegrasProprias the tituloRegrasProprias to set
     */
    public void setTituloRegrasProprias(boolean tituloRegrasProprias) {
        this.tituloRegrasProprias = tituloRegrasProprias;
    }

    /**
     * @return the cobrancatb01TituloColl
     */
    public List<Cobrancatb01Titulo> getCobrancatb01TituloColl() {
        return cobrancatb01TituloColl;
    }

    /**
     * @param cobrancatb01TituloColl the cobrancatb01TituloColl to set
     */
    public void setCobrancatb01TituloColl(List<Cobrancatb01Titulo> cobrancatb01TituloColl) {
        this.cobrancatb01TituloColl = cobrancatb01TituloColl;
    }

    /**
     * @return the cobrancatb02TituloParcela
     */
    public List<Cobrancatb02TituloParcela> getCobrancatb02TituloParcelaColl() {
        return cobrancatb02TituloParcelaColl;
    }

    /**
     * @param cobrancatb02TituloParcela the cobrancatb02TituloParcela to set
     */
    public void setCobrancatb02TituloParcelaColl(List<Cobrancatb02TituloParcela> cobrancatb02TituloParcela) {
        this.cobrancatb02TituloParcelaColl = cobrancatb02TituloParcela;
    }

    /**
     * @return the Cobrancatb02TituloParcelaCadastroColl
     */
    public List<Cobrancatb02TituloParcela> getCobrancatb02TituloParcelaCadastroColl() {
        return cobrancatb02TituloParcelaCadastroColl;
    }

    /**
     * @param Cobrancatb02TituloParcelaCadastroColl the
     * Cobrancatb02TituloParcelaCadastroColl to set
     */
    public void setCobrancatb02TituloParcelaCadastroColl(List<Cobrancatb02TituloParcela> Cobrancatb02TituloParcelaCadastroColl) {
        this.cobrancatb02TituloParcelaCadastroColl = Cobrancatb02TituloParcelaCadastroColl;
    }

    /**
     * @return the cobrancatb02TituloParcela
     */
    public Cobrancatb02TituloParcela getCobrancatb02TituloParcela() {
        return cobrancatb02TituloParcela;
    }

    /**
     * @param cobrancatb02TituloParcela the cobrancatb02TituloParcela to set
     */
    public void setCobrancatb02TituloParcela(Cobrancatb02TituloParcela cobrancatb02TituloParcela) {
        this.cobrancatb02TituloParcela = cobrancatb02TituloParcela;
    }

    /**
     * @return the cobrancatb05TituloParcelaCheque
     */
    public Cobrancatb05TituloParcelaCheque getCobrancatb05TituloParcelaCheque() {
        return cobrancatb05TituloParcelaCheque;
    }

    /**
     * @param cobrancatb05TituloParcelaCheque the
     * cobrancatb05TituloParcelaCheque to set
     */
    public void setCobrancatb05TituloParcelaCheque(Cobrancatb05TituloParcelaCheque cobrancatb05TituloParcelaCheque) {
        this.cobrancatb05TituloParcelaCheque = cobrancatb05TituloParcelaCheque;
    }

    /**
     * @return the geraltb01SituacaoFinanceira
     */
    public Geraltb01SituacaoFinanceira getGeraltb01SituacaoFinanceira() {
        return geraltb01SituacaoFinanceira;
    }

    /**
     * @param geraltb01SituacaoFinanceira the geraltb01SituacaoFinanceira to set
     */
    public void setGeraltb01SituacaoFinanceira(Geraltb01SituacaoFinanceira geraltb01SituacaoFinanceira) {
        this.geraltb01SituacaoFinanceira = geraltb01SituacaoFinanceira;
    }

}
