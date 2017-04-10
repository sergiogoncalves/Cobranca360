package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the segurancatb03_perfil database table.
 * 
 */
@Entity
@Table(name="segurancatb03_perfil")
@NamedQuery(name="Segurancatb03Perfil.findAll", query="SELECT s FROM Segurancatb03Perfil s")
public class Segurancatb03Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_perfil")
	private int codigoPerfil;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inclusao")
	private Date dataInclusao;

	@Column(name="flg_ativo")
	private byte flgAtivo;

	@Column(name="nome_perfil")
	private String nomePerfil;

	//bi-directional many-to-one association to Empresatb01Empresa
	@ManyToOne
	@JoinColumn(name="empresatb01_codigo_empresa")
	private Empresatb01Empresa empresatb01Empresa;

	//bi-directional many-to-one association to Segurancatb04PerfilProcesso
	@OneToMany(mappedBy="segurancatb03Perfil")
	private List<Segurancatb04PerfilProcesso> segurancatb04PerfilProcessos;

	//bi-directional many-to-one association to Segurancatb05PerfilUsuario
	@OneToMany(mappedBy="segurancatb03Perfil")
	private List<Segurancatb05PerfilUsuario> segurancatb05PerfilUsuarios;

	public Segurancatb03Perfil() {
	}

	public int getCodigoPerfil() {
		return this.codigoPerfil;
	}

	public void setCodigoPerfil(int codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public byte getFlgAtivo() {
		return this.flgAtivo;
	}

	public void setFlgAtivo(byte flgAtivo) {
		this.flgAtivo = flgAtivo;
	}

	public String getNomePerfil() {
		return this.nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public Empresatb01Empresa getEmpresatb01Empresa() {
		return this.empresatb01Empresa;
	}

	public void setEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
		this.empresatb01Empresa = empresatb01Empresa;
	}

	public List<Segurancatb04PerfilProcesso> getSegurancatb04PerfilProcessos() {
		return this.segurancatb04PerfilProcessos;
	}

	public void setSegurancatb04PerfilProcessos(List<Segurancatb04PerfilProcesso> segurancatb04PerfilProcessos) {
		this.segurancatb04PerfilProcessos = segurancatb04PerfilProcessos;
	}

	public Segurancatb04PerfilProcesso addSegurancatb04PerfilProcesso(Segurancatb04PerfilProcesso segurancatb04PerfilProcesso) {
		getSegurancatb04PerfilProcessos().add(segurancatb04PerfilProcesso);
		segurancatb04PerfilProcesso.setSegurancatb03Perfil(this);

		return segurancatb04PerfilProcesso;
	}

	public Segurancatb04PerfilProcesso removeSegurancatb04PerfilProcesso(Segurancatb04PerfilProcesso segurancatb04PerfilProcesso) {
		getSegurancatb04PerfilProcessos().remove(segurancatb04PerfilProcesso);
		segurancatb04PerfilProcesso.setSegurancatb03Perfil(null);

		return segurancatb04PerfilProcesso;
	}

	public List<Segurancatb05PerfilUsuario> getSegurancatb05PerfilUsuarios() {
		return this.segurancatb05PerfilUsuarios;
	}

	public void setSegurancatb05PerfilUsuarios(List<Segurancatb05PerfilUsuario> segurancatb05PerfilUsuarios) {
		this.segurancatb05PerfilUsuarios = segurancatb05PerfilUsuarios;
	}

	public Segurancatb05PerfilUsuario addSegurancatb05PerfilUsuario(Segurancatb05PerfilUsuario segurancatb05PerfilUsuario) {
		getSegurancatb05PerfilUsuarios().add(segurancatb05PerfilUsuario);
		segurancatb05PerfilUsuario.setSegurancatb03Perfil(this);

		return segurancatb05PerfilUsuario;
	}

	public Segurancatb05PerfilUsuario removeSegurancatb05PerfilUsuario(Segurancatb05PerfilUsuario segurancatb05PerfilUsuario) {
		getSegurancatb05PerfilUsuarios().remove(segurancatb05PerfilUsuario);
		segurancatb05PerfilUsuario.setSegurancatb03Perfil(null);

		return segurancatb05PerfilUsuario;
	}

}