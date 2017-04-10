package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.dominio.DmnSituacaoAtivo;
import br.com.helenamax.cobranca.dominio.DmnSituacaoFinanceira;
import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Cobrancatb07Atendimento;
import br.com.helenamax.cobranca.model.Cobrancatb09AtendimentoAndamento;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Empresatb03PessoaFisica;
import br.com.helenamax.cobranca.model.Empresatb04PessoaJuridica;
import br.com.helenamax.cobranca.model.Empresatb06PessoaContato;
import br.com.helenamax.cobranca.model.Empresatb09EmpresaRegraRenegociacao;
import br.com.helenamax.cobranca.model.Renegociacaotb01Renegociacao;
import br.com.helenamax.cobranca.model.Renegociacaotb02RenegociacaoParcela;
import br.com.helenamax.cobranca.service.Cobrancatb02TituloParcelaSrv;
import br.com.helenamax.cobranca.service.Cobrancatb07AtendimentoSrv;
import br.com.helenamax.cobranca.service.Cobrancatb09AtendimentoAndamentoSrv;
import br.com.helenamax.cobranca.service.Empresatb02PessoaSrv;
import br.com.helenamax.cobranca.service.Empresatb06PessoaContatoSrv;
import br.com.helenamax.cobranca.service.Empresatb09EmpresaRegraRenegociacaoSrv;
import br.com.helenamax.cobranca.service.Renegociacaotb01RenegociacaoSrv;
import br.com.helenamax.cobranca.util.HorasUtils;
import br.com.helenamax.cobranca.util.Validador;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
public class RenegociacaoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private ParametroSessaoCtr parametroSessaoCtr;

    @Inject
    private Empresatb02Pessoa devedor;

    @Inject
    private Empresatb02PessoaSrv empresatb02PessoaSrv;

    @Inject
    private Cobrancatb02TituloParcelaSrv cobrancatb02TituloParcelaSrv;

    @Inject
    private Empresatb02Pessoa credorEscolhido;

    @Inject
    private Empresatb06PessoaContatoSrv empresatb06PessoaContatoSrv;

    @Inject
    private Empresatb09EmpresaRegraRenegociacao regraEscolhida;

    @Inject
    private Empresatb09EmpresaRegraRenegociacaoSrv empresatb09EmpresaRegraRenegociacaoSrv;

    @Inject
    private Renegociacaotb01RenegociacaoSrv renegociacaotb01RenegociacaoSrv;

    @Inject
    private Cobrancatb07AtendimentoSrv cobrancatb07AtendimentoSrv;

    @Inject
    private Cobrancatb09AtendimentoAndamentoSrv cobrancatb09AtendimentoAndamentoSrv;

    @Inject
    private Cobrancatb07Atendimento cobrancatb07Atendimento;

    private List<Empresatb06PessoaContato> empresatb06PessoaContatoColl;
    private List<Cobrancatb02TituloParcela> parcelasEmDebito;
    private List<Cobrancatb02TituloParcela> parcelasEscolhidas;
    private List<Empresatb02Pessoa> credores;
    private List<Empresatb09EmpresaRegraRenegociacao> regrasRenegociacao;
    private List<Renegociacaotb02RenegociacaoParcela> renegociacaotb02RenegociacaoParcelaColl;
    private List<Cobrancatb09AtendimentoAndamento> cobrancatb09AtendimentoAndamentoColl;
    private List<Cobrancatb07Atendimento> cobrancatb07AtendimentoColl;

    private String nomeDevedor;
    private String converterCNPJCPF = "cpfConverter";
    private String cpfCnpjDevedor;
    private String observacaoAtendimento;

    private Double jurosPercentagemCalculo;
    private Double jurosDinheiro;

    private Double descontoPercentagemCalculo;
    private Double descontoDinheiro;

    private Double honorariosPercentagemCalculo;
    private Double honorarioDinheiro;

    private Double multaPercentagemCalculo;
    private Double multaDinheiro;

    private Double moraPercentagemCalculo;
    private Double moraDinheiro;

    private Double valorParcelas;
    private Double valorTotalGeral;
    private Double juroMultaMoraDinheiro;

    private Double descontoPercentual;
    private Double honorarioPercentual;
    private Double encargosDinheiro;

    private Double valorEntradaDinheiro;
    private Double valorEntradaPercentual;

    private Double valorRestante;

    private int qtdeParcelas;

    private Date dataPrimeiraParcela;
    private Date dataEntrada;

    private boolean atendimentoIniciado = false;

    public void init() {
        if (parcelasEscolhidas == null) {
            parcelasEscolhidas = new ArrayList<>();
        }
        if (devedor.getPessoaCodigo() == 0) {
            //  abrirBuscaPessoa();
        }

    }

    public void abrirBuscaPessoa() {
        try {
            RequestContext.getCurrentInstance().openDialog("/pessoa/pessoa-fisica-busca", parametroSessaoCtr.retornarParametrosTelaBuscaPessoa(), null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onDevedorBuscaReturn(SelectEvent event) {
        try {
            if (event.getObject() != null) {

                setDevedor(((Empresatb03PessoaFisica) event.getObject()).getEmpresatb02Pessoa());

                if (event.getObject() instanceof Empresatb03PessoaFisica) {

                    getDevedor().setEmpresatb03PessoaFisica((Empresatb03PessoaFisica) event.getObject());

                    nomeDevedor = getDevedor().getNome();
                    converterCNPJCPF = "cpfConverter";
                    cpfCnpjDevedor = getDevedor().getEmpresatb03PessoaFisica().getDocFederal();
                }

                if (event.getObject() instanceof Empresatb04PessoaJuridica) {
                    getDevedor().setEmpresatb04PessoaJuridica((Empresatb04PessoaJuridica) event.getObject());

                    nomeDevedor = getDevedor().getEmpresatb04PessoaJuridica().getNomeFantasia();
                    converterCNPJCPF = "cnpjConverter";
                    cpfCnpjDevedor = getDevedor().getEmpresatb04PessoaJuridica().getCnpj();
                }
                listarCredores();
                listarParcelasEmDebito();
                listarRegraNegocio();
                buscarAtendimentoEmAberto();

                RequestContext.getCurrentInstance().update("frmParcelas");
                RequestContext.getCurrentInstance().update("frmDadosRenegociacao");
                RequestContext.getCurrentInstance().update("frmMenuTopo");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void onCredorChange() {
        listarParcelasEmDebito();
        listarRegraNegocio();
        zerarValores();
        buscarAtendimentoEmAberto();
        RequestContext.getCurrentInstance().update("frmParcelas");
        RequestContext.getCurrentInstance().update("frmDadosRenegociacao");

    }

    private void listarCredores() {
        setCredores(empresatb02PessoaSrv.buscarCredorPorDevedor(getDevedor()));

        if (credores.size() > 0) {
            credorEscolhido = credores.get(0);
        }
    }

    private void listarParcelasEmDebito() {
        if (parcelasEmDebito == null) {
            parcelasEmDebito = new ArrayList<>();
        }
        parcelasEmDebito.clear();
        List<Cobrancatb02TituloParcela> parcelaTemp = new ArrayList<>();
        parcelaTemp = cobrancatb02TituloParcelaSrv.buscarPorDevedorSituacao(devedor, parametroSessaoCtr.retornarSituacaoPorSigla(DmnSituacaoFinanceira.EM_ABERTO.toString()), credorEscolhido);

        for (Cobrancatb02TituloParcela vo : parcelaTemp) {
            if (vo.getDiasEmAtraso() > 0) {
                parcelasEmDebito.add(vo);
            }
        }
        parcelaTemp = null;
    }

    public void abrirContatos() {
        if (empresatb06PessoaContatoColl == null) {
            empresatb06PessoaContatoColl = new ArrayList<>();
        }

        empresatb06PessoaContatoColl.clear();

        if (devedor.getPessoaCodigo() != 0) {

            empresatb06PessoaContatoColl = empresatb06PessoaContatoSrv.listarPorPessoa(devedor);

            RequestContext.getCurrentInstance().execute("PF('dlgContatos').show();");
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção", "Selecione um devedor!"));
        }
    }

    public void calcularParcelas(boolean zerarValor) {

        try {

            if (!isAtendimentoIniciado()) {
                throw new Exception("Gentileza iniciar atendimento!");
            }

            // if (zerarValor) {
            zerarValores();
            // }

            for (Cobrancatb02TituloParcela vo : parcelasEscolhidas) {
                valorParcelas = valorParcelas + vo.getValorParcela().doubleValue();

                jurosPercentagemCalculo = 0d;
                jurosPercentagemCalculo = (regraEscolhida.getJuro().doubleValue() / 30) * vo.getDiasEmAtraso();  // regraEscolhida.getJuro().divide(new Double(30), 2, RoundingMode.CEILING).multiply(new Double(vo.getDiasEmAtraso()));
                jurosDinheiro = (jurosPercentagemCalculo / 100) * vo.getValorParcela().doubleValue();            //  jurosDinheiro.add(jurosPercentagemCalculo.divide(new Double(100), 2, RoundingMode.CEILING).multiply(vo.getValorParcela()));

                //multaPercentagemCalculo =  regraEscolhida.getMulta().divide(new Double(30), 2, RoundingMode.CEILING).multiply(new Double(vo.getDiasEmAtraso()));
                multaDinheiro = (regraEscolhida.getMulta().doubleValue() /100) * vo.getValorParcela().doubleValue();

                moraPercentagemCalculo = (regraEscolhida.getMora().doubleValue() / 30 ) * vo.getDiasEmAtraso(); //.divide(new Double(30), 2, RoundingMode.CEILING).multiply(new Double(vo.getDiasEmAtraso()));
                moraDinheiro = (moraPercentagemCalculo / 100) * vo.getValorParcela().doubleValue();// moraDinheiro.add(moraPercentagemCalculo.divide(new Double(100), 2, RoundingMode.CEILING).multiply(vo.getValorParcela()));

                valorTotalGeral = new Double(0);
                juroMultaMoraDinheiro = new Double(0);

                juroMultaMoraDinheiro = jurosDinheiro + multaDinheiro + moraDinheiro;// juroMultaMoraDinheiro.add(jurosDinheiro).add(multaDinheiro).add(moraDinheiro);

            }

            //Desconto em cima de juros+multa+mora
            descontoDinheiro = (descontoPercentual / 100) * juroMultaMoraDinheiro; //descontoDinheiro.add(descontoPercentual.divide(new Double(100), 2, RoundingMode.CEILING).multiply(juroMultaMoraDinheiro));

            Double jurosMenosDesconto = juroMultaMoraDinheiro - descontoDinheiro;

            honorarioDinheiro = (honorarioPercentual / 100) * valorParcelas;// honorarioPercentual.divide(new Double(100)).multiply(jurosMenosDesconto.add(valorParcelas));//. valorTotalGeral.add());

            encargosDinheiro = honorarioDinheiro + jurosMenosDesconto;

            valorTotalGeral = encargosDinheiro + valorParcelas;

            calcularValorEntradaDinheiro();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
        }

    }

    public void zerarValores() {
        valorParcelas = new Double(0);

        jurosPercentagemCalculo = new Double(0);
        jurosDinheiro = new Double(0);

        descontoPercentagemCalculo = new Double(0);
        descontoDinheiro = new Double(0);

        honorariosPercentagemCalculo = new Double(0);
        honorarioDinheiro = new Double(0);

        multaPercentagemCalculo = new Double(0);
        multaDinheiro = new Double(0);

        moraPercentagemCalculo = new Double(0);
        moraDinheiro = new Double(0);

        valorTotalGeral = new Double(0);

        juroMultaMoraDinheiro = new Double(0);

        descontoDinheiro = new Double(0);

        honorarioDinheiro = new Double(0);
        encargosDinheiro = new Double(0);
    }

    public void listarRegraNegocio() {
        try {
            if (regrasRenegociacao == null) {
                regrasRenegociacao = new ArrayList<>();
            }
            regrasRenegociacao.clear();
            regrasRenegociacao = empresatb09EmpresaRegraRenegociacaoSrv.listarPorEmpresaStatus(usuarioSessaoCtr.getEmpresatb01Empresa(), DmnSituacaoAtivo.ATIVO.getValor());

            if (regrasRenegociacao.size() == 1) {
                regraEscolhida = regrasRenegociacao.get(0);

                descontoPercentual = regraEscolhida.getDesconto().doubleValue();
                honorarioPercentual = regraEscolhida.getHonorarios().doubleValue();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void recalcularPorComponente(String nomeComponente) {

        if (nomeComponente.equals("honorarioPercentual")) {
            System.out.println("Valor: " + regraEscolhida.getHonorarios());
        }

        if (nomeComponente.equals("descontoDinheiro")) {
            calcularPercentualDesconto();
        }

        if (nomeComponente.equals("valorEntradaDinheiro")) {
            calcularValorEntradaDinheiro();
        }

        calcularParcelas(false);

        RequestContext.getCurrentInstance().execute("PF('statusDialog').hide();");

    }

    public void calcularValorEntradaDinheiro() {
        if (valorEntradaDinheiro == null) {
            valorEntradaDinheiro = new Double(0);
        }
        valorRestante = valorTotalGeral - valorEntradaDinheiro;
        Double valor01 = new Double(0);
        Double valor02 = new Double(0);

        valor01 = valorEntradaDinheiro * 100;
        valor02 = valor01 / valorTotalGeral;

        valorEntradaPercentual = valor02;

    }

    public void calcularPercentualDesconto() {
        Double valor01 = new Double(0);
        Double valor02 = new Double(0);

        valor01 = descontoDinheiro * 100;

        valor02 = valor01 / juroMultaMoraDinheiro;

        descontoPercentual = valor02;
    }

    public void gerarParcelas() {
        if (renegociacaotb02RenegociacaoParcelaColl == null) {
            renegociacaotb02RenegociacaoParcelaColl = new ArrayList<>();
        }

        renegociacaotb02RenegociacaoParcelaColl.clear();

        int i = 0;

        i = valorEntradaDinheiro.compareTo(new Double(0));

        if (i > 0) {

            Renegociacaotb02RenegociacaoParcela vo = new Renegociacaotb02RenegociacaoParcela();

            vo.setCobrancatb02TituloParcela(new Cobrancatb02TituloParcela());

            vo.getCobrancatb02TituloParcela().setDataVencimento(dataEntrada);

            vo.getCobrancatb02TituloParcela().setNumeroParcela(1);

            vo.getCobrancatb02TituloParcela().setValorParcela(new BigDecimal(valorEntradaDinheiro));

            renegociacaotb02RenegociacaoParcelaColl.add(vo);
        }

        i = 0;

        Double valorParcela = new Double(0);

        valorParcela = valorRestante / qtdeParcelas;

        for (int j = 0; j < qtdeParcelas; j++) {

            Renegociacaotb02RenegociacaoParcela vo = new Renegociacaotb02RenegociacaoParcela();
            vo.setCobrancatb02TituloParcela(new Cobrancatb02TituloParcela());

            vo.getCobrancatb02TituloParcela().setDataVencimento(HorasUtils.addMes(dataPrimeiraParcela, j));

            vo.getCobrancatb02TituloParcela().setNumeroParcela(j + 1);

            vo.getCobrancatb02TituloParcela().setValorParcela(new BigDecimal(valorParcela));

            renegociacaotb02RenegociacaoParcelaColl.add(vo);
        }

    }

    public void gravarNegociacao() {
        try {

            Renegociacaotb01Renegociacao negociacao = new Renegociacaotb01Renegociacao();

            negociacao.setNumeroParcelas(qtdeParcelas);

            negociacao.setValorAcordado(new BigDecimal(valorTotalGeral));

            negociacao.setValorDesconto(new BigDecimal(descontoDinheiro));

            negociacao.setValorHonorario(new BigDecimal(honorarioDinheiro));

            negociacao.setValorJuros(new BigDecimal(jurosDinheiro));

            negociacao.setValorMora(new BigDecimal(moraDinheiro));

            negociacao.setValorMulta(new BigDecimal(multaDinheiro));

            negociacao.setValorRenegociado(new BigDecimal(valorParcelas));

            negociacao.setDataRenegociacao(HorasUtils.retornarHoraAtual());

            negociacao.setRenegociacaotb02RenegociacaoParcelas(renegociacaotb02RenegociacaoParcelaColl);

            negociacao.setDevedor(devedor);

            negociacao.setCredor(credorEscolhido);

            negociacao.setCobrancatb07Atendimento(cobrancatb07Atendimento);

            renegociacaotb01RenegociacaoSrv.salvarPersist(negociacao, parcelasEscolhidas);
            
            finalizarAtendimento();

            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void iniciarAtendimento() {

        try {
            if (Validador.isObjectValido(devedor)) {
                if (devedor.getPessoaCodigo() == 0) {
                    throw new Exception("Selecionar o devedor");
                }
            }
            if (cobrancatb07Atendimento == null) {
                cobrancatb07Atendimento = new Cobrancatb07Atendimento();
            }
            if (cobrancatb09AtendimentoAndamentoColl == null) {
                cobrancatb09AtendimentoAndamentoColl = new ArrayList<>();
            }

            if (cobrancatb07Atendimento.getCodigoAtendimento() == 0) {
                cobrancatb07Atendimento.setCredor(credorEscolhido);
                cobrancatb07Atendimento.setDevedor(devedor);
                cobrancatb07Atendimento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("EA"));
                cobrancatb07Atendimento.setSegurancatb01Usuario(usuarioSessaoCtr.getSegurancatb01Usuario());
                cobrancatb07Atendimento.setDataAtendimento(HorasUtils.retornarHoraAtual());

                Cobrancatb09AtendimentoAndamento cobrancatb09AtendimentoAndamento = new Cobrancatb09AtendimentoAndamento();

                cobrancatb09AtendimentoAndamento.setCobrancatb07Atendimento(cobrancatb07Atendimento);
                cobrancatb09AtendimentoAndamento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("EA"));
                cobrancatb09AtendimentoAndamento.setDataInicio(HorasUtils.retornarHoraAtual());

                cobrancatb09AtendimentoAndamentoColl.add(cobrancatb09AtendimentoAndamento);

                cobrancatb07Atendimento.setCobrancatb09AtendimentoAndamentos(cobrancatb09AtendimentoAndamentoColl);

            } else //Finaliza o em pausa e coloca um em atendimento
             if (cobrancatb07Atendimento.getCobrancatb10AtendimentoSituacao().getSigla().equals("AP")) {

                    for (Cobrancatb09AtendimentoAndamento vo : cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos()) {
                        if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("AP") && vo.getDataFim() == null) {
                            vo.setDataFim(HorasUtils.retornarHoraAtual());
                        }
                    }
                    cobrancatb07Atendimento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("EA"));

                    Cobrancatb09AtendimentoAndamento emAtendimento = new Cobrancatb09AtendimentoAndamento();

                    emAtendimento.setCobrancatb07Atendimento(cobrancatb07Atendimento);
                    emAtendimento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("EA"));
                    emAtendimento.setDataInicio(HorasUtils.retornarHoraAtual());

                    cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos().add(emAtendimento);

                    atendimentoIniciado = true;
                } else if (cobrancatb07Atendimento.getCobrancatb10AtendimentoSituacao().getSigla().equals("EA")) {
                    int posicao = 0;
                    int posicaoRetirada = 0;

                    for (Cobrancatb09AtendimentoAndamento vo : cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos()) {
                        if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("EA") && vo.getDataFim() == null) {
                            posicaoRetirada = posicao;
                            cobrancatb09AtendimentoAndamentoSrv.remover(vo);
                        }
                        posicao++;
                    }
                    cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos().remove(posicaoRetirada);

                    Cobrancatb09AtendimentoAndamento andamento = new Cobrancatb09AtendimentoAndamento();

                    andamento.setCobrancatb07Atendimento(cobrancatb07Atendimento);
                    andamento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("EA"));
                    andamento.setDataInicio(HorasUtils.retornarHoraAtual());

                    cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos().add(andamento);
                }

            if (cobrancatb07Atendimento.getCodigoAtendimento() == 0) {
                cobrancatb07AtendimentoSrv.salvarPersist(cobrancatb07Atendimento);
            } else {
                cobrancatb07AtendimentoSrv.salvarMerge(cobrancatb07Atendimento);
            }

            setAtendimentoIniciado(true);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Atendimento iniciado"));
            RequestContext.getCurrentInstance().execute("PF('dlgAtendimentoAberto').hide();");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
        }

    }

    public void buscarAtendimentoEmAberto() {
        try {

            Cobrancatb07Atendimento vo = new Cobrancatb07Atendimento();
            vo.setDevedor(devedor);
            vo.setCredor(credorEscolhido);
            vo.setSegurancatb01Usuario(usuarioSessaoCtr.getSegurancatb01Usuario());
            vo.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("EA"));
            cobrancatb07Atendimento = cobrancatb07AtendimentoSrv.buscarAberto(vo);

            if (cobrancatb07Atendimento == null) {
                vo.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("AP"));
                cobrancatb07Atendimento = cobrancatb07AtendimentoSrv.buscarAberto(vo);
            }

            if (Validador.isObjectValido(cobrancatb07Atendimento)) {
                if (cobrancatb07Atendimento.getCodigoAtendimento() != 0) {
                    RequestContext.getCurrentInstance().execute("PF('dlgAtendimentoAberto').show();");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void finalizarAtendimento() {

        try {

            cobrancatb07Atendimento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("AF"));

            for (Cobrancatb09AtendimentoAndamento vo : cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos()) {
                if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("EA") && vo.getDataFim() == null) {
                    vo.setDataFim(HorasUtils.retornarHoraAtual());
                }
            }

            cobrancatb07AtendimentoSrv.salvarMerge(cobrancatb07Atendimento);

            limparTela();
            atendimentoIniciado = false; 
            RequestContext.getCurrentInstance().update("frmParcelas");
            RequestContext.getCurrentInstance().update("frmDadosRenegociacao");
            RequestContext.getCurrentInstance().update("frmMenuTopo");
            RequestContext.getCurrentInstance().update("frmGeradas");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Atendimento finalizado"));
            RequestContext.getCurrentInstance().execute("PF('dlgFinalizarAtendimento').hide();");

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
            RequestContext.getCurrentInstance().execute("PF('dlgFinalizarAtendimento').hide();");
        }

    }

    public void limparTela() {
        zerarValores();
        nomeDevedor = "";
        cpfCnpjDevedor = "";

        if (Validador.isObjectValido(credorEscolhido)) {
            credorEscolhido = null;
        }

        if (Validador.isListValida(credores)) {
            credores.clear();
        }

        if (Validador.isObjectValido(devedor)) {
            devedor = null;
        }

        if (Validador.isListValida(empresatb06PessoaContatoColl)) {
            empresatb06PessoaContatoColl.clear();
        }

        if (Validador.isListValida(parcelasEmDebito)) {
            parcelasEmDebito.clear();
        }

        if (Validador.isListValida(parcelasEscolhidas)) {
            parcelasEscolhidas.clear();
        }

        if (Validador.isListValida(credores)) {
            credores.clear();
        }

        if (Validador.isListValida(regrasRenegociacao)) {
            regrasRenegociacao.clear();
        }

        if (Validador.isListValida(renegociacaotb02RenegociacaoParcelaColl)) {
            renegociacaotb02RenegociacaoParcelaColl.clear();
        }

        if (Validador.isListValida(cobrancatb09AtendimentoAndamentoColl)) {
            cobrancatb09AtendimentoAndamentoColl.clear();
        }
    }

    public void pausarAtendimento() {

        try {

            cobrancatb07Atendimento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("AP"));

            for (Cobrancatb09AtendimentoAndamento vo : cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos()) {
                if (vo.getCobrancatb10AtendimentoSituacao().getSigla().equals("EA") && vo.getDataFim() == null) {
                    vo.setDataFim(HorasUtils.retornarHoraAtual());
                }
            }

            Cobrancatb09AtendimentoAndamento add = new Cobrancatb09AtendimentoAndamento();

            add.setCobrancatb07Atendimento(cobrancatb07Atendimento);
            add.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("AP"));

            add.setDataInicio(HorasUtils.retornarHoraAtual());

            cobrancatb07Atendimento.getCobrancatb09AtendimentoAndamentos().add(add);

            cobrancatb07AtendimentoSrv.salvarMerge(cobrancatb07Atendimento);

            limparTela();

            atendimentoIniciado = false;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Atendimento pausado"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
        }
    }

    public void invalidarAtendimento() {
        try {

            atendimentoIniciado = false;
            cobrancatb07Atendimento.setCobrancatb10AtendimentoSituacao(parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("AI"));
            cobrancatb07AtendimentoSrv.salvarMerge(cobrancatb07Atendimento);

            cobrancatb07Atendimento = null;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Atendimento invalidado"));
            RequestContext.getCurrentInstance().execute("PF('dlgAtendimentoAberto').hide();");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", e.getMessage()));
            RequestContext.getCurrentInstance().execute("PF('dlgAtendimentoAberto').hide();");
        }
    }

    public void buscarAtendimentosRealizados() {

        if (!Validador.isListValida(cobrancatb07AtendimentoColl)) {
            cobrancatb07AtendimentoColl = new ArrayList<>();
        }

        try {
            cobrancatb07AtendimentoColl = cobrancatb07AtendimentoSrv.buscarPorDevedorSituacao(devedor, credorEscolhido, parametroSessaoCtr.retornarAtendimentoSituacaoPorSigla("AF"));
            RequestContext.getCurrentInstance().execute("PF('dlgAtendimentoRealizados').show();");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void onRowAtendimentoClick(SelectEvent event) {
        observacaoAtendimento = ((Cobrancatb07Atendimento) event.getObject()).getObservacao();
    }

    // -------------------------------------------------------------------------------------------------
    public String getNomeDevedor() {
        return nomeDevedor;
    }

    public void setNomeDevedor(String nomeDevedor) {
        this.nomeDevedor = nomeDevedor;
    }

    public List<Empresatb02Pessoa> getCredores() {
        return credores;
    }

    public void setCredores(List<Empresatb02Pessoa> credores) {
        this.credores = credores;
    }

    public Empresatb02Pessoa getCredorEscolhido() {
        return credorEscolhido;
    }

    public void setCredorEscolhido(Empresatb02Pessoa credorEscolhido) {
        this.credorEscolhido = credorEscolhido;
    }

    public Empresatb02Pessoa getDevedor() {
        return devedor;
    }

    public void setDevedor(Empresatb02Pessoa devedor) {
        this.devedor = devedor;
    }

    public String getConverterCNPJCPF() {
        return converterCNPJCPF;
    }

    public void setConverterCNPJCPF(String converterCNPJCPF) {
        this.converterCNPJCPF = converterCNPJCPF;
    }

    public String getCpfCnpjDevedor() {
        return cpfCnpjDevedor;
    }

    public void setCpfCnpjDevedor(String cpfCnpjDevedor) {
        this.cpfCnpjDevedor = cpfCnpjDevedor;
    }

    public List<Cobrancatb02TituloParcela> getParcelasEmDebito() {
        return parcelasEmDebito;
    }

    public void setParcelasEmDebito(List<Cobrancatb02TituloParcela> parcelasEmDebito) {
        this.parcelasEmDebito = parcelasEmDebito;
    }

    public List<Cobrancatb02TituloParcela> getParcelasEscolhidas() {
        return parcelasEscolhidas;
    }

    public void setParcelasEscolhidas(List<Cobrancatb02TituloParcela> parcelasEscolhidas) {
        this.parcelasEscolhidas = parcelasEscolhidas;
    }

    public List<Empresatb06PessoaContato> getEmpresatb06PessoaContatoColl() {
        return empresatb06PessoaContatoColl;
    }

    public void setEmpresatb06PessoaContatoColl(List<Empresatb06PessoaContato> empresatb06PessoaContatoColl) {
        this.empresatb06PessoaContatoColl = empresatb06PessoaContatoColl;
    }

    public Double getValorParcelas() {
        return valorParcelas;
    }

    public void setValorParcelas(Double valorParcelas) {
        this.valorParcelas = valorParcelas;
    }

    public Double getJurosPercentagemCalculo() {
        return jurosPercentagemCalculo;
    }

    public void setJurosPercentagemCalculo(Double jurosPercentagemCalculo) {
        this.jurosPercentagemCalculo = jurosPercentagemCalculo;
    }

    public Double getJurosDinheiro() {
        return jurosDinheiro;
    }

    /**
     * @param jurosDinheiro the jurosDinheiro to set
     */
    public void setJurosDinheiro(Double jurosDinheiro) {
        this.jurosDinheiro = jurosDinheiro;
    }

    /**
     * @return the descontoPercentagemCalculo
     */
    public Double getDescontoPercentagemCalculo() {
        return descontoPercentagemCalculo;
    }

    /**
     * @param descontoPercentagemCalculo the descontoPercentagemCalculo to set
     */
    public void setDescontoPercentagemCalculo(Double descontoPercentagemCalculo) {
        this.descontoPercentagemCalculo = descontoPercentagemCalculo;
    }

    /**
     * @return the descontoDinheiro
     */
    public Double getDescontoDinheiro() {
        return descontoDinheiro;
    }

    /**
     * @param descontoDinheiro the descontoDinheiro to set
     */
    public void setDescontoDinheiro(Double descontoDinheiro) {
        this.descontoDinheiro = descontoDinheiro;
    }

    /**
     * @return the honorariosPercentagemCalculo
     */
    public Double getHonorariosPercentagemCalculo() {
        return honorariosPercentagemCalculo;
    }

    /**
     * @param honorariosPercentagemCalculo the honorariosPercentagemCalculo to
     * set
     */
    public void setHonorariosPercentagemCalculo(Double honorariosPercentagemCalculo) {
        this.honorariosPercentagemCalculo = honorariosPercentagemCalculo;
    }

    /**
     * @return the honorarioDinheiro
     */
    public Double getHonorarioDinheiro() {
        return honorarioDinheiro;
    }

    /**
     * @param honorarioDinheiro the honorarioDinheiro to set
     */
    public void setHonorarioDinheiro(Double honorarioDinheiro) {
        this.honorarioDinheiro = honorarioDinheiro;
    }

    /**
     * @return the multaPercentagemCalculo
     */
    public Double getMultaPercentagemCalculo() {
        return multaPercentagemCalculo;
    }

    /**
     * @param multaPercentagemCalculo the multaPercentagemCalculo to set
     */
    public void setMultaPercentagemCalculo(Double multaPercentagemCalculo) {
        this.multaPercentagemCalculo = multaPercentagemCalculo;
    }

    /**
     * @return the multaDinheiro
     */
    public Double getMultaDinheiro() {
        return multaDinheiro;
    }

    /**
     * @param multaDinheiro the multaDinheiro to set
     */
    public void setMultaDinheiro(Double multaDinheiro) {
        this.multaDinheiro = multaDinheiro;
    }

    /**
     * @return the moraPercentagemCalculo
     */
    public Double getMoraPercentagemCalculo() {
        return moraPercentagemCalculo;
    }

    /**
     * @param moraPercentagemCalculo the moraPercentagemCalculo to set
     */
    public void setMoraPercentagemCalculo(Double moraPercentagemCalculo) {
        this.moraPercentagemCalculo = moraPercentagemCalculo;
    }

    /**
     * @return the moraDinheiro
     */
    public Double getMoraDinheiro() {
        return moraDinheiro;
    }

    /**
     * @param moraDinheiro the moraDinheiro to set
     */
    public void setMoraDinheiro(Double moraDinheiro) {
        this.moraDinheiro = moraDinheiro;
    }

    /**
     * @return the regrasRenegociacao
     */
    public List<Empresatb09EmpresaRegraRenegociacao> getRegrasRenegociacao() {
        return regrasRenegociacao;
    }

    /**
     * @param regrasRenegociacao the regrasRenegociacao to set
     */
    public void setRegrasRenegociacao(List<Empresatb09EmpresaRegraRenegociacao> regrasRenegociacao) {
        this.regrasRenegociacao = regrasRenegociacao;
    }

    /**
     * @return the regraEscolhida
     */
    public Empresatb09EmpresaRegraRenegociacao getRegraEscolhida() {
        return regraEscolhida;
    }

    /**
     * @param regraEscolhida the regraEscolhida to set
     */
    public void setRegraEscolhida(Empresatb09EmpresaRegraRenegociacao regraEscolhida) {
        this.regraEscolhida = regraEscolhida;
    }

    /**
     * @return the valorTotalGeral
     */
    public Double getValorTotalGeral() {
        return valorTotalGeral;
    }

    /**
     * @param valorTotalGeral the valorTotalGeral to set
     */
    public void setValorTotalGeral(Double valorTotalGeral) {
        this.valorTotalGeral = valorTotalGeral;
    }

    /**
     * @return the juroMultaMoraDinheiro
     */
    public Double getJuroMultaMoraDinheiro() {
        return juroMultaMoraDinheiro;
    }

    /**
     * @param juroMultaMoraDinheiro the juroMultaMoraDinheiro to set
     */
    public void setJuroMultaMoraDinheiro(Double juroMultaMoraDinheiro) {
        this.juroMultaMoraDinheiro = juroMultaMoraDinheiro;
    }

    /**
     * @return the descontoPercentual
     */
    public Double getDescontoPercentual() {
        return descontoPercentual;
    }

    /**
     * @param descontoPercentual the descontoPercentual to set
     */
    public void setDescontoPercentual(Double descontoPercentual) {
        this.descontoPercentual = descontoPercentual;
    }

    /**
     * @return the honorarioPercentual
     */
    public Double getHonorarioPercentual() {
        return honorarioPercentual;
    }

    /**
     * @param honorarioPercentual the honorarioPercentual to set
     */
    public void setHonorarioPercentual(Double honorarioPercentual) {
        this.honorarioPercentual = honorarioPercentual;
    }

    /**
     * @return the encargosDinheiro
     */
    public Double getEncargosDinheiro() {
        return encargosDinheiro;
    }

    /**
     * @param encargosDinheiro the encargosDinheiro to set
     */
    public void setEncargosDinheiro(Double encargosDinheiro) {
        this.encargosDinheiro = encargosDinheiro;
    }

    /**
     * @return the valorEntradaDinheiro
     */
    public Double getValorEntradaDinheiro() {
        return valorEntradaDinheiro;
    }

    /**
     * @param valorEntradaDinheiro the valorEntradaDinheiro to set
     */
    public void setValorEntradaDinheiro(Double valorEntradaDinheiro) {
        this.valorEntradaDinheiro = valorEntradaDinheiro;
    }

    /**
     * @return the valorEntradaPercentual
     */
    public Double getValorEntradaPercentual() {
        return valorEntradaPercentual;
    }

    /**
     * @param valorEntradaPercentual the valorEntradaPercentual to set
     */
    public void setValorEntradaPercentual(Double valorEntradaPercentual) {
        this.valorEntradaPercentual = valorEntradaPercentual;
    }

    /**
     * @return the valorRestante
     */
    public Double getValorRestante() {
        return valorRestante;
    }

    /**
     * @param valorRestante the valorRestante to set
     */
    public void setValorRestante(Double valorRestante) {
        this.valorRestante = valorRestante;
    }

    /**
     * @return the qtdeParcelas
     */
    public int getQtdeParcelas() {
        return qtdeParcelas;
    }

    /**
     * @param qtdeParcelas the qtdeParcelas to set
     */
    public void setQtdeParcelas(int qtdeParcelas) {
        this.qtdeParcelas = qtdeParcelas;
    }

    /**
     * @return the dataPrimeiraParcela
     */
    public Date getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    /**
     * @param dataPrimeiraParcela the dataPrimeiraParcela to set
     */
    public void setDataPrimeiraParcela(Date dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    /**
     * @return the dataEntrada
     */
    public Date getDataEntrada() {
        return dataEntrada;
    }

    /**
     * @param dataEntrada the dataEntrada to set
     */
    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    /**
     * @return the renegociacaotb02RenegociacaoParcelaColl
     */
    public List<Renegociacaotb02RenegociacaoParcela> getRenegociacaotb02RenegociacaoParcelaColl() {
        return renegociacaotb02RenegociacaoParcelaColl;
    }

    /**
     * @param renegociacaotb02RenegociacaoParcelaColl the
     * renegociacaotb02RenegociacaoParcelaColl to set
     */
    public void setRenegociacaotb02RenegociacaoParcelaColl(List<Renegociacaotb02RenegociacaoParcela> renegociacaotb02RenegociacaoParcelaColl) {
        this.renegociacaotb02RenegociacaoParcelaColl = renegociacaotb02RenegociacaoParcelaColl;
    }

    /**
     * @return the atendimentoIniciado
     */
    public boolean isAtendimentoIniciado() {
        return atendimentoIniciado;
    }

    /**
     * @param atendimentoIniciado the atendimentoIniciado to set
     */
    public void setAtendimentoIniciado(boolean atendimentoIniciado) {
        this.atendimentoIniciado = atendimentoIniciado;
    }

    /**
     * @return the cobrancatb07Atendimento
     */
    public Cobrancatb07Atendimento getCobrancatb07Atendimento() {
        return cobrancatb07Atendimento;
    }

    /**
     * @param cobrancatb07Atendimento the cobrancatb07Atendimento to set
     */
    public void setCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
        this.cobrancatb07Atendimento = cobrancatb07Atendimento;
    }

    /**
     * @return the cobrancatb09AtendimentoAndamentoColl
     */
    public List<Cobrancatb09AtendimentoAndamento> getCobrancatb09AtendimentoAndamentoColl() {
        return cobrancatb09AtendimentoAndamentoColl;
    }

    /**
     * @param cobrancatb09AtendimentoAndamentoColl the
     * cobrancatb09AtendimentoAndamentoColl to set
     */
    public void setCobrancatb09AtendimentoAndamentoColl(List<Cobrancatb09AtendimentoAndamento> cobrancatb09AtendimentoAndamentoColl) {
        this.cobrancatb09AtendimentoAndamentoColl = cobrancatb09AtendimentoAndamentoColl;
    }

    /**
     * @return the cobrancatb07AtendimentoColl
     */
    public List<Cobrancatb07Atendimento> getCobrancatb07AtendimentoColl() {
        return cobrancatb07AtendimentoColl;
    }

    /**
     * @param cobrancatb07AtendimentoColl the cobrancatb07AtendimentoColl to set
     */
    public void setCobrancatb07AtendimentoColl(List<Cobrancatb07Atendimento> cobrancatb07AtendimentoColl) {
        this.cobrancatb07AtendimentoColl = cobrancatb07AtendimentoColl;
    }

    /**
     * @return the observacaoAtendimento
     */
    public String getObservacaoAtendimento() {
        return observacaoAtendimento;
    }

    /**
     * @param observacaoAtendimento the observacaoAtendimento to set
     */
    public void setObservacaoAtendimento(String observacaoAtendimento) {
        this.observacaoAtendimento = observacaoAtendimento;
    }

}
