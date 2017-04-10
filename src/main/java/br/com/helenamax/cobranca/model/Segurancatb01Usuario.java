package br.com.helenamax.cobranca.model;

import br.com.helenamax.cobranca.util.HorasUtils;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the segurancatb01_usuario database table.
 *
 */
@Entity
@Table(name = "segurancatb01_usuario")
@NamedQuery(name = "Segurancatb01Usuario.findAll", query = "SELECT s FROM Segurancatb01Usuario s")
public class Segurancatb01Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private int codigoUsuario;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim")
    private Date dataFim;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio")
    private Date dataInicio;

    private String login;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    private String senha;
    
    @Column(name = "situacao_ativo")
    private String situacaoAtivo;

    //bi-directional many-to-one association to Empresatb07UsuarioCobraPessoa
    @OneToMany(mappedBy = "segurancatb01Usuario")
    private List<Empresatb07UsuarioCobraPessoa> empresatb07UsuarioCobraPessoas;

    //bi-directional many-to-one association to Filatb02FilaUsuario
    @OneToMany(mappedBy = "segurancatb01Usuario")
    private List<Filatb02FilaUsuario> filatb02FilaUsuarios;

    //bi-directional many-to-one association to Empresatb02Pessoa
    @ManyToOne
    @JoinColumn(name = "empresatb02_codigo_pessoa")
    private Empresatb02Pessoa empresatb02Pessoa;

    //bi-directional many-to-one association to Segurancatb05PerfilUsuario
    @OneToMany(mappedBy = "segurancatb01UsuarioBean")
    private List<Segurancatb05PerfilUsuario> segurancatb05PerfilUsuarios;

    //bi-directional many-to-one association to Segurancatb06UsuarioProcesso
    @OneToMany(mappedBy = "segurancatb01Usuario")
    private List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessos;

    //bi-directional many-to-one association to Segurancatb07UsuarioCobraEmpresa
    @OneToMany(mappedBy = "segurancatb01Usuario")
    private List<Segurancatb07UsuarioCobraEmpresa> segurancatb07UsuarioCobraEmpresas;

    public Segurancatb01Usuario() {
    }

    public int getCodigoUsuario() {
        return this.codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInclusao() {
        return this.dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Empresatb07UsuarioCobraPessoa> getEmpresatb07UsuarioCobraPessoas() {
        return this.empresatb07UsuarioCobraPessoas;
    }

    public void setEmpresatb07UsuarioCobraPessoas(List<Empresatb07UsuarioCobraPessoa> empresatb07UsuarioCobraPessoas) {
        this.empresatb07UsuarioCobraPessoas = empresatb07UsuarioCobraPessoas;
    }

    public Empresatb07UsuarioCobraPessoa addEmpresatb07UsuarioCobraPessoa(Empresatb07UsuarioCobraPessoa empresatb07UsuarioCobraPessoa) {
        getEmpresatb07UsuarioCobraPessoas().add(empresatb07UsuarioCobraPessoa);
        empresatb07UsuarioCobraPessoa.setSegurancatb01Usuario(this);

        return empresatb07UsuarioCobraPessoa;
    }

    public Empresatb07UsuarioCobraPessoa removeEmpresatb07UsuarioCobraPessoa(Empresatb07UsuarioCobraPessoa empresatb07UsuarioCobraPessoa) {
        getEmpresatb07UsuarioCobraPessoas().remove(empresatb07UsuarioCobraPessoa);
        empresatb07UsuarioCobraPessoa.setSegurancatb01Usuario(null);

        return empresatb07UsuarioCobraPessoa;
    }

    public List<Filatb02FilaUsuario> getFilatb02FilaUsuarios() {
        return this.filatb02FilaUsuarios;
    }

    public void setFilatb02FilaUsuarios(List<Filatb02FilaUsuario> filatb02FilaUsuarios) {
        this.filatb02FilaUsuarios = filatb02FilaUsuarios;
    }

    public Filatb02FilaUsuario addFilatb02FilaUsuario(Filatb02FilaUsuario filatb02FilaUsuario) {
        getFilatb02FilaUsuarios().add(filatb02FilaUsuario);
        filatb02FilaUsuario.setSegurancatb01Usuario(this);

        return filatb02FilaUsuario;
    }

    public Filatb02FilaUsuario removeFilatb02FilaUsuario(Filatb02FilaUsuario filatb02FilaUsuario) {
        getFilatb02FilaUsuarios().remove(filatb02FilaUsuario);
        filatb02FilaUsuario.setSegurancatb01Usuario(null);

        return filatb02FilaUsuario;
    }

    public Empresatb02Pessoa getEmpresatb02Pessoa() {
        return this.empresatb02Pessoa;
    }

    public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
        this.empresatb02Pessoa = empresatb02Pessoa;
    }

    public List<Segurancatb05PerfilUsuario> getSegurancatb05PerfilUsuarios() {
        return this.segurancatb05PerfilUsuarios;
    }

    public void setSegurancatb05PerfilUsuarios(List<Segurancatb05PerfilUsuario> segurancatb05PerfilUsuarios) {
        this.segurancatb05PerfilUsuarios = segurancatb05PerfilUsuarios;
    }

    public Segurancatb05PerfilUsuario addSegurancatb05PerfilUsuario(Segurancatb05PerfilUsuario segurancatb05PerfilUsuario) {
        getSegurancatb05PerfilUsuarios().add(segurancatb05PerfilUsuario);
        segurancatb05PerfilUsuario.setSegurancatb01UsuarioBean(this);

        return segurancatb05PerfilUsuario;
    }

    public Segurancatb05PerfilUsuario removeSegurancatb05PerfilUsuario(Segurancatb05PerfilUsuario segurancatb05PerfilUsuario) {
        getSegurancatb05PerfilUsuarios().remove(segurancatb05PerfilUsuario);
        segurancatb05PerfilUsuario.setSegurancatb01UsuarioBean(null);

        return segurancatb05PerfilUsuario;
    }

    public List<Segurancatb06UsuarioProcesso> getSegurancatb06UsuarioProcessos() {
        return this.segurancatb06UsuarioProcessos;
    }

    public void setSegurancatb06UsuarioProcessos(List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessos) {
        this.segurancatb06UsuarioProcessos = segurancatb06UsuarioProcessos;
    }

    public Segurancatb06UsuarioProcesso addSegurancatb06UsuarioProcesso(Segurancatb06UsuarioProcesso segurancatb06UsuarioProcesso) {
        getSegurancatb06UsuarioProcessos().add(segurancatb06UsuarioProcesso);
        segurancatb06UsuarioProcesso.setSegurancatb01Usuario(this);

        return segurancatb06UsuarioProcesso;
    }

    public Segurancatb06UsuarioProcesso removeSegurancatb06UsuarioProcesso(Segurancatb06UsuarioProcesso segurancatb06UsuarioProcesso) {
        getSegurancatb06UsuarioProcessos().remove(segurancatb06UsuarioProcesso);
        segurancatb06UsuarioProcesso.setSegurancatb01Usuario(null);

        return segurancatb06UsuarioProcesso;
    }

    public List<Segurancatb07UsuarioCobraEmpresa> getSegurancatb07UsuarioCobraEmpresas() {
        return this.segurancatb07UsuarioCobraEmpresas;
    }

    public void setSegurancatb07UsuarioCobraEmpresas(List<Segurancatb07UsuarioCobraEmpresa> segurancatb07UsuarioCobraEmpresas) {
        this.segurancatb07UsuarioCobraEmpresas = segurancatb07UsuarioCobraEmpresas;
    }

    public Segurancatb07UsuarioCobraEmpresa addSegurancatb07UsuarioCobraEmpresa(Segurancatb07UsuarioCobraEmpresa segurancatb07UsuarioCobraEmpresa) {
        getSegurancatb07UsuarioCobraEmpresas().add(segurancatb07UsuarioCobraEmpresa);
        segurancatb07UsuarioCobraEmpresa.setSegurancatb01Usuario(this);

        return segurancatb07UsuarioCobraEmpresa;
    }

    public Segurancatb07UsuarioCobraEmpresa removeSegurancatb07UsuarioCobraEmpresa(Segurancatb07UsuarioCobraEmpresa segurancatb07UsuarioCobraEmpresa) {
        getSegurancatb07UsuarioCobraEmpresas().remove(segurancatb07UsuarioCobraEmpresa);
        segurancatb07UsuarioCobraEmpresa.setSegurancatb01Usuario(null);

        return segurancatb07UsuarioCobraEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.codigoUsuario;
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
        final Segurancatb01Usuario other = (Segurancatb01Usuario) obj;
        if (this.codigoUsuario != other.codigoUsuario) {
            return false;
        }
        return true;
    }

    @PrePersist
    public void atualizaHoras() {
        setDataInclusao(HorasUtils.retornarHoraAtual());
    }

    /**
     * @return the situacaoAtivo
     */
    public String getSituacaoAtivo() {
        return situacaoAtivo;
    }

    /**
     * @param situacaoAtivo the situacaoAtivo to set
     */
    public void setSituacaoAtivo(String situacaoAtivo) {
        this.situacaoAtivo = situacaoAtivo;
    }

}
