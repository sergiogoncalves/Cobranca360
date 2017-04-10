package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the empresatb03_pessoa_fisica database table.
 *
 */
@Entity
@Table(name = "empresatb03_pessoa_fisica")
@NamedQuery(name = "Empresatb03PessoaFisica.findAll", query = "SELECT e FROM Empresatb03PessoaFisica e")
public class Empresatb03PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_fisica_codigo")
    private int pessoaFisicaCodigo;

    private int cargo;

    @Column(name = "certificado_militar")
    private String certificadoMilitar;

    private int clero;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro")
    private Date dataCadastro;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "doc_federal")
    private String docFederal;

    @Column(name = "estado_civil")
    private int estadoCivil;

    private short etnia;

    @Column(name = "flg_serasa")
    private String flgSerasa;

    private int nacionalidade;

    private int naturalidade;

    @Column(name = "nome_conjuge")
    private String nomeConjuge;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "nome_pai")
    private String nomePai;

    private String rg;

    @Column(name = "rg_data_emissao")
    private String rgDataEmissao;

    @Column(name = "rg_orgao_emissor")
    private String rgOrgaoEmissor;

    @Column(name = "rg_uf")
    private String rgUf;

    private String sexo;

    @Column(name = "titulo_eleitor")
    private String tituloEleitor;

    //bi-directional many-to-one association to Empresatb02Pessoa
    @ManyToOne
    @JoinColumn(name = "empresatb02_codigo_pessoa")
    private Empresatb02Pessoa empresatb02Pessoa;

    public Empresatb03PessoaFisica() {
    }

    public int getPessoaFisicaCodigo() {
        return this.pessoaFisicaCodigo;
    }

    public void setPessoaFisicaCodigo(int pessoaFisicaCodigo) {
        this.pessoaFisicaCodigo = pessoaFisicaCodigo;
    }

    public int getCargo() {
        return this.cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public String getCertificadoMilitar() {
        return this.certificadoMilitar;
    }

    public void setCertificadoMilitar(String certificadoMilitar) {
        this.certificadoMilitar = certificadoMilitar;
    }

    public int getClero() {
        return this.clero;
    }

    public void setClero(int clero) {
        this.clero = clero;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocFederal() {
        return this.docFederal;
    }

    public void setDocFederal(String docFederal) {
        this.docFederal = docFederal;
    }

    public int getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public short getEtnia() {
        return this.etnia;
    }

    public void setEtnia(short etnia) {
        this.etnia = etnia;
    }

    public String getFlgSerasa() {
        return this.flgSerasa;
    }

    public void setFlgSerasa(String flgSerasa) {
        this.flgSerasa = flgSerasa;
    }

    public int getNacionalidade() {
        return this.nacionalidade;
    }

    public void setNacionalidade(int nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getNaturalidade() {
        return this.naturalidade;
    }

    public void setNaturalidade(int naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNomeConjuge() {
        return this.nomeConjuge;
    }

    public void setNomeConjuge(String nomeConjuge) {
        this.nomeConjuge = nomeConjuge;
    }

    public String getNomeMae() {
        return this.nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return this.nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRgDataEmissao() {
        return this.rgDataEmissao;
    }

    public void setRgDataEmissao(String rgDataEmissao) {
        this.rgDataEmissao = rgDataEmissao;
    }

    public String getRgOrgaoEmissor() {
        return this.rgOrgaoEmissor;
    }

    public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
        this.rgOrgaoEmissor = rgOrgaoEmissor;
    }

    public String getRgUf() {
        return this.rgUf;
    }

    public void setRgUf(String rgUf) {
        this.rgUf = rgUf;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTituloEleitor() {
        return this.tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public Empresatb02Pessoa getEmpresatb02Pessoa() {
        return this.empresatb02Pessoa;
    }

    public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
        this.empresatb02Pessoa = empresatb02Pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.pessoaFisicaCodigo;
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
        final Empresatb03PessoaFisica other = (Empresatb03PessoaFisica) obj;
        if (this.pessoaFisicaCodigo != other.pessoaFisicaCodigo) {
            return false;
        }
        return true;
    }

}
