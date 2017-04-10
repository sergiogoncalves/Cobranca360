package br.com.helenamax.cobranca.model;

import br.com.helenamax.cobranca.util.HorasUtils;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "filatb01_fila")
@NamedQuery(name = "Filatb01Fila.findAll", query = "SELECT f FROM Filatb01Fila f")
public class Filatb01Fila implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_fila")
    private int codigoFila;

    private Boolean ativo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_criacao")
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_fim")
    private Date dataFim;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inicio")
    private Date dataInicio;

    @Lob
    private String descricao;

    //bi-directional many-to-one association to Cobrancatb07Atendimento
    @OneToMany(mappedBy = "filatb01Fila")
    private List<Cobrancatb07Atendimento> cobrancatb07Atendimentos;

    //bi-directional many-to-one association to Empresatb01Empresa
    @ManyToOne
    @JoinColumn(name = "empresatb01_codigo_empresa")
    private Empresatb01Empresa empresatb01Empresa;

    //bi-directional many-to-one association to Segurancatb01Usuario
    @ManyToOne
    @JoinColumn(name = "segurancatb01_codigo_usuario_criacao")
    private Segurancatb01Usuario segurancatb01Usuario;

    //bi-directional many-to-one association to Filatb02FilaUsuario
    @OneToMany(mappedBy = "filatb01Fila")
    private List<Filatb02FilaUsuario> filatb02FilaUsuarios;

    //bi-directional many-to-one association to Filatb03FilaDevedor
    @OneToMany(mappedBy = "filatb01Fila")
    private List<Filatb03FilaDevedor> filatb03FilaDevedors;

    public Filatb01Fila() {
    }

    public int getCodigoFila() {
        return this.codigoFila;
    }

    public void setCodigoFila(int codigoFila) {
        this.codigoFila = codigoFila;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cobrancatb07Atendimento> getCobrancatb07Atendimentos() {
        return this.cobrancatb07Atendimentos;
    }

    public void setCobrancatb07Atendimentos(List<Cobrancatb07Atendimento> cobrancatb07Atendimentos) {
        this.cobrancatb07Atendimentos = cobrancatb07Atendimentos;
    }

    public Cobrancatb07Atendimento addCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
        getCobrancatb07Atendimentos().add(cobrancatb07Atendimento);
        cobrancatb07Atendimento.setFilatb01Fila(this);

        return cobrancatb07Atendimento;
    }

    public Cobrancatb07Atendimento removeCobrancatb07Atendimento(Cobrancatb07Atendimento cobrancatb07Atendimento) {
        getCobrancatb07Atendimentos().remove(cobrancatb07Atendimento);
        cobrancatb07Atendimento.setFilatb01Fila(null);

        return cobrancatb07Atendimento;
    }

    public Empresatb01Empresa getEmpresatb01Empresa() {
        return this.empresatb01Empresa;
    }

    public void setEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
        this.empresatb01Empresa = empresatb01Empresa;
    }

    public Segurancatb01Usuario getSegurancatb01Usuario() {
        return this.segurancatb01Usuario;
    }

    public void setSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
        this.segurancatb01Usuario = segurancatb01Usuario;
    }

    public List<Filatb02FilaUsuario> getFilatb02FilaUsuarios() {
        return this.filatb02FilaUsuarios;
    }

    public void setFilatb02FilaUsuarios(List<Filatb02FilaUsuario> filatb02FilaUsuarios) {
        this.filatb02FilaUsuarios = filatb02FilaUsuarios;
    }

    public Filatb02FilaUsuario addFilatb02FilaUsuario(Filatb02FilaUsuario filatb02FilaUsuario) {
        getFilatb02FilaUsuarios().add(filatb02FilaUsuario);
        filatb02FilaUsuario.setFilatb01Fila(this);

        return filatb02FilaUsuario;
    }

    public Filatb02FilaUsuario removeFilatb02FilaUsuario(Filatb02FilaUsuario filatb02FilaUsuario) {
        getFilatb02FilaUsuarios().remove(filatb02FilaUsuario);
        filatb02FilaUsuario.setFilatb01Fila(null);

        return filatb02FilaUsuario;
    }

    public List<Filatb03FilaDevedor> getFilatb03FilaDevedors() {
        return this.filatb03FilaDevedors;
    }

    public void setFilatb03FilaDevedors(List<Filatb03FilaDevedor> filatb03FilaDevedors) {
        this.filatb03FilaDevedors = filatb03FilaDevedors;
    }

    public Filatb03FilaDevedor addFilatb03FilaDevedor(Filatb03FilaDevedor filatb03FilaDevedor) {
        getFilatb03FilaDevedors().add(filatb03FilaDevedor);
        filatb03FilaDevedor.setFilatb01Fila(this);

        return filatb03FilaDevedor;
    }

    public Filatb03FilaDevedor removeFilatb03FilaDevedor(Filatb03FilaDevedor filatb03FilaDevedor) {
        getFilatb03FilaDevedors().remove(filatb03FilaDevedor);
        filatb03FilaDevedor.setFilatb01Fila(null);

        return filatb03FilaDevedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codigoFila;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Filatb01Fila other = (Filatb01Fila) obj;
        if (this.codigoFila != other.codigoFila) {
            return false;
        }
        return true;
    }

    @PrePersist
    public void atualizaHoras() {
        setDataCriacao(HorasUtils.retornarHoraAtual());
    }

}
