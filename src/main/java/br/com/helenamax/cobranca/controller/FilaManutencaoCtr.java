/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Cobrancatb01Titulo;
import br.com.helenamax.cobranca.model.Cobrancatb02TituloParcela;
import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.model.Empresatb02Pessoa;
import br.com.helenamax.cobranca.model.Filatb01Fila;
import br.com.helenamax.cobranca.model.Filatb02FilaUsuario;
import br.com.helenamax.cobranca.model.Filatb03FilaDevedor;
import br.com.helenamax.cobranca.model.Filatb04FilaTituloSituacao;
import br.com.helenamax.cobranca.model.Segurancatb01Usuario;
import br.com.helenamax.cobranca.service.Cobrancatb01TituloSrv;
import br.com.helenamax.cobranca.service.Cobrancatb02TituloParcelaSrv;
import br.com.helenamax.cobranca.service.Filatb01FilaSrv;
import br.com.helenamax.cobranca.service.Segurancatb01UsuarioSrv;
import br.com.helenamax.cobranca.util.Validador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

@ViewScoped
@Named
public class FilaManutencaoCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioSessaoCtr usuarioSessaoCtr;

    @Inject
    private Empresatb01Empresa empresaCredora;

    @Inject
    private Cobrancatb01TituloSrv cobrancatb01TituloSrv;

    @Inject
    private Segurancatb01UsuarioSrv segurancatb01UsuarioSrv;

    @Inject
    private Cobrancatb02TituloParcelaSrv cobrancatb02TituloParcelaSrv;

    @Inject
    private Filatb01FilaSrv filatb01FilaSrv;

    @Inject
    private ParametroSessaoCtr parametroSessaoCtr;

    private int diasEmAtrasoInicio;
    private int diasEmAtrasoFim;

    private Double valorTituloInicio;
    private Double valorTituloFim;

    private Date dataVencimentoInicio;
    private Date dataVencimentoFim;

    private Filatb01Fila filatb01Fila;
    private List<Cobrancatb01Titulo> titulosAEscolher;
    private List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelas;
    private List<Empresatb02Pessoa> devedoresColl;
    private List<Empresatb02Pessoa> devedoresEscolhidos;
    private List<Segurancatb01Usuario> usuariosColl = new ArrayList<>();
    private List<Segurancatb01Usuario> usuariosEscolhidosColl = new ArrayList<>();
    private List<Segurancatb01Usuario> usuariosEscolhidosUtilizados = new ArrayList<>();

    public void init() {
        try {
            usuariosEscolhidosColl = new ArrayList<>();
            empresaCredora = usuarioSessaoCtr.getEmpresatb01Empresa();

            listarUsuarios();

        } catch (Exception e) {
        }
    }

    public void listarUsuarios() {
        try {
            usuariosColl = segurancatb01UsuarioSrv.listarPorEmpresa();

        } catch (Exception e) {
        }
    }

    public void buscarTitulo() {
        try {
            if (!Validador.isListValida(titulosAEscolher)) {
                titulosAEscolher = Validador.iniciarList();
            }

            if (!Validador.isListValida(devedoresColl)) {
                devedoresColl = Validador.iniciarList();
            }

            if (!Validador.isListValida(cobrancatb02TituloParcelas)) {
                cobrancatb02TituloParcelas = Validador.iniciarList();
            }
            titulosAEscolher.clear();
            devedoresColl.clear();
            cobrancatb02TituloParcelas.clear();

            if (diasEmAtrasoInicio != 0 || diasEmAtrasoFim != 0) {
                if (diasEmAtrasoInicio > diasEmAtrasoFim) {
                    throw new Exception("Dia da atraso inicial maior que o final.");
                }
            }

            titulosAEscolher = cobrancatb01TituloSrv.listarPorParametro(diasEmAtrasoInicio, diasEmAtrasoFim, valorTituloInicio, valorTituloFim);

            boolean inserir = true;

            for (Cobrancatb01Titulo cobrancatb01Titulo : titulosAEscolher) {
                inserir = true;

                if (devedoresColl.size() == 0) {
                    devedoresColl.add(cobrancatb01Titulo.getEmpresatb02PessoaDevedor());
                    continue;
                }

                for (Empresatb02Pessoa pessoa : devedoresColl) {
                    if (pessoa.equals(cobrancatb01Titulo.getEmpresatb02PessoaDevedor())) {
                        inserir = false;
                    }
                }
                if (inserir) {
                    devedoresColl.add(cobrancatb01Titulo.getEmpresatb02PessoaDevedor());
                }
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
        }
    }

    public void onRowTituloPrincipalSelect(SelectEvent event) {

        try {
            Empresatb02Pessoa pessoa = (Empresatb02Pessoa) event.getObject();
            List<Cobrancatb02TituloParcela> temp = new ArrayList<>();
            boolean inserir = true;

            if (!Validador.isListValida(cobrancatb02TituloParcelas)) {
                cobrancatb02TituloParcelas = Validador.iniciarList();
            }
            cobrancatb02TituloParcelas.clear();

            for (Cobrancatb01Titulo cobrancatb01Titulo : titulosAEscolher) {

                temp.clear();

                if (cobrancatb01Titulo.getEmpresatb02PessoaDevedor().equals(pessoa)) {
                    temp = cobrancatb02TituloParcelaSrv.listarPorTitulo(cobrancatb01Titulo);
                }
                for (Cobrancatb02TituloParcela parcelaInsert : temp) {

                    inserir = true;

                    if (parcelaInsert.getDiasEmAtraso() > 0) {

                        for (Cobrancatb02TituloParcela igual : cobrancatb02TituloParcelas) {
                            if (igual.equals(parcelaInsert)) {
                                inserir = false;
                            }
                        }
                    } else {
                        inserir = false;
                    }

                    if (inserir) {
                        cobrancatb02TituloParcelas.add(parcelaInsert);
                    }
                }

            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
        }
    }

    public void adicionarDevedor(Empresatb02Pessoa pessoa) {
        try {

            boolean inserir = true;

            if (!Validador.isObjectValido(filatb01Fila)) {
                filatb01Fila = new Filatb01Fila();
            }

            if (filatb01Fila.getFilatb03FilaDevedors() == null) {
                filatb01Fila.setFilatb03FilaDevedors(Validador.iniciarList());
            }

            if (!Validador.isListValida(devedoresEscolhidos)) {
                devedoresEscolhidos = Validador.iniciarList();
            }

            for (Filatb03FilaDevedor pessoaAdd : filatb01Fila.getFilatb03FilaDevedors()) {
                if (pessoaAdd.getDevedor().equals(pessoa)) {
                    inserir = false;
                }
            }
            if (inserir) {

                Filatb03FilaDevedor vo = new Filatb03FilaDevedor();
                vo.setDevedor(pessoa);
                filatb01Fila.getFilatb03FilaDevedors().add(vo);

                devedoresEscolhidos.add(pessoa);

            }

        } catch (Exception e) {
        }
    }

    public void adicionarTodos() {
        boolean inserir = true;

        if (!Validador.isListValida(devedoresEscolhidos)) {
            devedoresEscolhidos = Validador.iniciarList();
        }
        if (!Validador.isObjectValido(filatb01Fila)) {
            filatb01Fila = new Filatb01Fila();
        }

        if (filatb01Fila.getFilatb03FilaDevedors() == null) {
            filatb01Fila.setFilatb03FilaDevedors(Validador.iniciarList());
        }

        for (Empresatb02Pessoa pessoaAdd : devedoresColl) {

            for (Filatb03FilaDevedor pessoaAdd2 : filatb01Fila.getFilatb03FilaDevedors()) {
                if (pessoaAdd2.getDevedor().equals(pessoaAdd)) {
                    inserir = false;
                }
            }

            if (inserir) {
                Filatb03FilaDevedor vo = new Filatb03FilaDevedor();

                vo.setDevedor(pessoaAdd);

                filatb01Fila.getFilatb03FilaDevedors().add(vo);
                devedoresEscolhidos.add(pessoaAdd);
            }
        }
    }

    public void salvarFila() {
        try {
            if (filatb01Fila != null && filatb01Fila.getCodigoFila() != 0) {
                filatb01FilaSrv.salvarMerge(filatb01Fila);
            } else {
                Filatb04FilaTituloSituacao filatb04FilaTituloSituacao = parametroSessaoCtr.retornarSituacaoFilaPorSigla("NA");

                for (Filatb03FilaDevedor vo : filatb01Fila.getFilatb03FilaDevedors()) {

                    vo.setFilatb04FilaTituloSituacao(filatb04FilaTituloSituacao);
                }
                filatb01FilaSrv.salvarPersist(filatb01Fila);
            }
            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao gravar:", e.getMessage()));
        }
    }

    public void addUsuario() {
        if (filatb01Fila == null) {
            filatb01Fila = new Filatb01Fila();
        }
        if (filatb01Fila.getFilatb02FilaUsuarios() == null) {
            filatb01Fila.setFilatb02FilaUsuarios(new ArrayList<Filatb02FilaUsuario>());
        }

        boolean inserir;

        for (Segurancatb01Usuario vo : usuariosEscolhidosColl) {

            inserir = true;

            for (Filatb02FilaUsuario voDentro : filatb01Fila.getFilatb02FilaUsuarios()) {
                if (vo.equals(voDentro.getSegurancatb01Usuario())) {
                    inserir = false;
                }
            }
            if (inserir) {
                Filatb02FilaUsuario voInsert = new Filatb02FilaUsuario();
                voInsert.setSegurancatb01Usuario(vo);

                filatb01Fila.getFilatb02FilaUsuarios().add(voInsert);
            }
        }

        usuariosEscolhidosColl.clear();
    }

    public void removerDevedor(Filatb03FilaDevedor vo) {
        try {
            if (!Validador.isObjectValido(filatb01Fila)) {
                filatb01Fila = new Filatb01Fila();
            }

            if (filatb01Fila.getFilatb03FilaDevedors() == null) {
                filatb01Fila.setFilatb03FilaDevedors(Validador.iniciarList());
            }

            filatb01Fila.getFilatb03FilaDevedors().remove(vo);

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
        }
    }

    public Empresatb01Empresa getEmpresaCredora() {
        return empresaCredora;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Usuário alterado:", ((Filatb02FilaUsuario) event.getObject()).getSegurancatb01Usuario().getNomeUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void setEmpresaCredora(Empresatb01Empresa empresaCredora) {
        this.empresaCredora = empresaCredora;
    }

    /**
     * @return the diasEmAtrasoInicio
     */
    public int getDiasEmAtrasoInicio() {
        return diasEmAtrasoInicio;
    }

    /**
     * @param diasEmAtrasoInicio the diasEmAtrasoInicio to set
     */
    public void setDiasEmAtrasoInicio(int diasEmAtrasoInicio) {
        this.diasEmAtrasoInicio = diasEmAtrasoInicio;
    }

    /**
     * @return the diasEmAtrasoFim
     */
    public int getDiasEmAtrasoFim() {
        return diasEmAtrasoFim;
    }

    /**
     * @param diasEmAtrasoFim the diasEmAtrasoFim to set
     */
    public void setDiasEmAtrasoFim(int diasEmAtrasoFim) {
        this.diasEmAtrasoFim = diasEmAtrasoFim;
    }

    /**
     * @return the valorTituloInicio
     */
    public Double getValorTituloInicio() {
        return valorTituloInicio;
    }

    /**
     * @param valorTituloInicio the valorTituloInicio to set
     */
    public void setValorTituloInicio(Double valorTituloInicio) {
        this.valorTituloInicio = valorTituloInicio;
    }

    /**
     * @return the valorTituloFim
     */
    public Double getValorTituloFim() {
        return valorTituloFim;
    }

    /**
     * @param valorTituloFim the valorTituloFim to set
     */
    public void setValorTituloFim(Double valorTituloFim) {
        this.valorTituloFim = valorTituloFim;
    }

    /**
     * @return the dataVencimentoInicio
     */
    public Date getDataVencimentoInicio() {
        return dataVencimentoInicio;
    }

    /**
     * @param dataVencimentoInicio the dataVencimentoInicio to set
     */
    public void setDataVencimentoInicio(Date dataVencimentoInicio) {
        this.dataVencimentoInicio = dataVencimentoInicio;
    }

    /**
     * @return the dataVencimentoFim
     */
    public Date getDataVencimentoFim() {
        return dataVencimentoFim;
    }

    /**
     * @param dataVencimentoFim the dataVencimentoFim to set
     */
    public void setDataVencimentoFim(Date dataVencimentoFim) {
        this.dataVencimentoFim = dataVencimentoFim;
    }

    /**
     * @return the titulosAEscolher
     */
    public List<Cobrancatb01Titulo> getTitulosAEscolher() {
        return titulosAEscolher;
    }

    /**
     * @param titulosAEscolher the titulosAEscolher to set
     */
    public void setTitulosAEscolher(List<Cobrancatb01Titulo> titulosAEscolher) {
        this.titulosAEscolher = titulosAEscolher;
    }

    /**
     * @return the cobrancatb02TituloParcelas
     */
    public List<Cobrancatb02TituloParcela> getCobrancatb02TituloParcelas() {
        return cobrancatb02TituloParcelas;
    }

    /**
     * @param cobrancatb02TituloParcelas the cobrancatb02TituloParcelas to set
     */
    public void setCobrancatb02TituloParcelas(List<Cobrancatb02TituloParcela> cobrancatb02TituloParcelas) {
        this.cobrancatb02TituloParcelas = cobrancatb02TituloParcelas;
    }

    /**
     * @return the devedoresColl
     */
    public List<Empresatb02Pessoa> getDevedoresColl() {
        return devedoresColl;
    }

    /**
     * @param devedoresColl the devedoresColl to set
     */
    public void setDevedoresColl(List<Empresatb02Pessoa> devedoresColl) {
        this.devedoresColl = devedoresColl;
    }

    /**
     * @return the devedoresEscolhidos
     */
    public List<Empresatb02Pessoa> getDevedoresEscolhidos() {
        return devedoresEscolhidos;
    }

    /**
     * @param devedoresEscolhidos the devedoresEscolhidos to set
     */
    public void setDevedoresEscolhidos(List<Empresatb02Pessoa> devedoresEscolhidos) {
        this.devedoresEscolhidos = devedoresEscolhidos;
    }

    /**
     * @return the usuariosColl
     */
    public List<Segurancatb01Usuario> getUsuariosColl() {
        return usuariosColl;
    }

    /**
     * @param usuariosColl the usuariosColl to set
     */
    public void setUsuariosColl(List<Segurancatb01Usuario> usuariosColl) {
        this.usuariosColl = usuariosColl;
    }

    /**
     * @return the usuariosEscolhidosColl
     */
    public List<Segurancatb01Usuario> getUsuariosEscolhidosColl() {
        return usuariosEscolhidosColl;
    }

    /**
     * @param usuariosEscolhidosColl the usuariosEscolhidosColl to set
     */
    public void setUsuariosEscolhidosColl(List<Segurancatb01Usuario> usuariosEscolhidosColl) {
        this.usuariosEscolhidosColl = usuariosEscolhidosColl;
    }

    /**
     * @return the filatb01Fila
     */
    public Filatb01Fila getFilatb01Fila() {
        return filatb01Fila;
    }

    /**
     * @param filatb01Fila the filatb01Fila to set
     */
    public void setFilatb01Fila(Filatb01Fila filatb01Fila) {
        this.filatb01Fila = filatb01Fila;
    }

    /**
     * @return the usuariosEscolhidosUtilizados
     */
    public List<Segurancatb01Usuario> getUsuariosEscolhidosUtilizados() {
        return usuariosEscolhidosUtilizados;
    }

    /**
     * @param usuariosEscolhidosUtilizados the usuariosEscolhidosUtilizados to
     * set
     */
    public void setUsuariosEscolhidosUtilizados(List<Segurancatb01Usuario> usuariosEscolhidosUtilizados) {
        this.usuariosEscolhidosUtilizados = usuariosEscolhidosUtilizados;
    }

}
