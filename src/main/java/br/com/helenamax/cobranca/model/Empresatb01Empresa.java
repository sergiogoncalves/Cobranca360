package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the empresatb01_empresa database table.
 * 
 */
@Entity
@Table(name="empresatb01_empresa")
@NamedQuery(name="Empresatb01Empresa.findAll", query="SELECT e FROM Empresatb01Empresa e")
public class Empresatb01Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_empresa")
	private int codigoEmpresa;

	private String cnpj;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	private Date dataCadastro;

	@Column(name="inscricao_estadual")
	private String inscricaoEstadual;

	@Column(name="nome_fantasia")
	private String nomeFantasia;

	//bi-directional many-to-one association to Empresatb01Empresa
	@ManyToOne
	@JoinColumn(name="codigo_empresa_pai")
	private Empresatb01Empresa empresatb01Empresa;

	//bi-directional many-to-one association to Empresatb01Empresa
	@OneToMany(mappedBy="empresatb01Empresa")
	private List<Empresatb01Empresa> empresatb01Empresas;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@OneToMany(mappedBy="empresatb01Empresa")
	private List<Empresatb02Pessoa> empresatb02Pessoas;

	//bi-directional many-to-one association to Segurancatb07UsuarioCobraEmpresa
	@OneToMany(mappedBy="empresatb01Empresa")
	private List<Segurancatb07UsuarioCobraEmpresa> segurancatb07UsuarioCobraEmpresas;

	public Empresatb01Empresa() {
	}

	public int getCodigoEmpresa() {
		return this.codigoEmpresa;
	}

	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getInscricaoEstadual() {
		return this.inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Empresatb01Empresa getEmpresatb01Empresa() {
		return this.empresatb01Empresa;
	}

	public void setEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
		this.empresatb01Empresa = empresatb01Empresa;
	}

	public List<Empresatb01Empresa> getEmpresatb01Empresas() {
		return this.empresatb01Empresas;
	}

	public void setEmpresatb01Empresas(List<Empresatb01Empresa> empresatb01Empresas) {
		this.empresatb01Empresas = empresatb01Empresas;
	}

	public Empresatb01Empresa addEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
		getEmpresatb01Empresas().add(empresatb01Empresa);
		empresatb01Empresa.setEmpresatb01Empresa(this);

		return empresatb01Empresa;
	}

	public Empresatb01Empresa removeEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
		getEmpresatb01Empresas().remove(empresatb01Empresa);
		empresatb01Empresa.setEmpresatb01Empresa(null);

		return empresatb01Empresa;
	}

	public List<Empresatb02Pessoa> getEmpresatb02Pessoas() {
		return this.empresatb02Pessoas;
	}

	public void setEmpresatb02Pessoas(List<Empresatb02Pessoa> empresatb02Pessoas) {
		this.empresatb02Pessoas = empresatb02Pessoas;
	}

	public Empresatb02Pessoa addEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
		getEmpresatb02Pessoas().add(empresatb02Pessoa);
		empresatb02Pessoa.setEmpresatb01Empresa(this);

		return empresatb02Pessoa;
	}

	public Empresatb02Pessoa removeEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
		getEmpresatb02Pessoas().remove(empresatb02Pessoa);
		empresatb02Pessoa.setEmpresatb01Empresa(null);

		return empresatb02Pessoa;
	}

	public List<Segurancatb07UsuarioCobraEmpresa> getSegurancatb07UsuarioCobraEmpresas() {
		return this.segurancatb07UsuarioCobraEmpresas;
	}

	public void setSegurancatb07UsuarioCobraEmpresas(List<Segurancatb07UsuarioCobraEmpresa> segurancatb07UsuarioCobraEmpresas) {
		this.segurancatb07UsuarioCobraEmpresas = segurancatb07UsuarioCobraEmpresas;
	}

	public Segurancatb07UsuarioCobraEmpresa addSegurancatb07UsuarioCobraEmpresa(Segurancatb07UsuarioCobraEmpresa segurancatb07UsuarioCobraEmpresa) {
		getSegurancatb07UsuarioCobraEmpresas().add(segurancatb07UsuarioCobraEmpresa);
		segurancatb07UsuarioCobraEmpresa.setEmpresatb01Empresa(this);

		return segurancatb07UsuarioCobraEmpresa;
	}

	public Segurancatb07UsuarioCobraEmpresa removeSegurancatb07UsuarioCobraEmpresa(Segurancatb07UsuarioCobraEmpresa segurancatb07UsuarioCobraEmpresa) {
		getSegurancatb07UsuarioCobraEmpresas().remove(segurancatb07UsuarioCobraEmpresa);
		segurancatb07UsuarioCobraEmpresa.setEmpresatb01Empresa(null);

		return segurancatb07UsuarioCobraEmpresa;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigoEmpresa;
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
        final Empresatb01Empresa other = (Empresatb01Empresa) obj;
        if (this.codigoEmpresa != other.codigoEmpresa) {
            return false;
        }
        return true;
    }
        
        

}