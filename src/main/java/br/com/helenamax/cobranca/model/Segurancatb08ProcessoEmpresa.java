package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the segurancatb08_processo_empresa database table.
 * 
 */
@Entity
@Table(name="segurancatb08_processo_empresa")
@NamedQuery(name="Segurancatb08ProcessoEmpresa.findAll", query="SELECT s FROM Segurancatb08ProcessoEmpresa s")
public class Segurancatb08ProcessoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_proceso_empresa")
	private int codigoProcesoEmpresa;

	private Boolean bloqueio;

	@Column(name="flag_alterar")
	private Boolean flagAlterar;

	@Column(name="flag_consultar")
	private Boolean flagConsultar;

	@Column(name="flag_exclur")
	private Boolean flagExclur;

	@Column(name="flag_imprimir")
	private Boolean flagImprimir;

	@Column(name="flag_incluir")
	private Boolean flagIncluir;

	@Lob
	@Column(name="mensagem_bloqueio")
	private String mensagemBloqueio;

	//bi-directional many-to-one association to Segurancatb04PerfilProcesso
	@OneToMany(mappedBy="segurancatb08ProcessoEmpresa")
	private List<Segurancatb04PerfilProcesso> segurancatb04PerfilProcessos;

	//bi-directional many-to-one association to Segurancatb06UsuarioProcesso
	@OneToMany(mappedBy="segurancatb08ProcessoEmpresa")
	private List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessos;

	//bi-directional many-to-one association to Empresatb01Empresa
	@ManyToOne
	@JoinColumn(name="empresatb01_codigo_empresa")
	private Empresatb01Empresa empresatb01Empresa;

	//bi-directional many-to-one association to Segurancatb02Processo
	@ManyToOne
	@JoinColumn(name="segurancatb02_codigo_processo")
	private Segurancatb02Processo segurancatb02Processo;

	public Segurancatb08ProcessoEmpresa() {
	}

	public int getCodigoProcesoEmpresa() {
		return this.codigoProcesoEmpresa;
	}

	public void setCodigoProcesoEmpresa(int codigoProcesoEmpresa) {
		this.codigoProcesoEmpresa = codigoProcesoEmpresa;
	}

	public Boolean getBloqueio() {
		return this.bloqueio;
	}

	public void setBloqueio(Boolean bloqueio) {
		this.bloqueio = bloqueio;
	}

	public Boolean getFlagAlterar() {
		return this.flagAlterar;
	}

	public void setFlagAlterar(Boolean flagAlterar) {
		this.flagAlterar = flagAlterar;
	}

	public Boolean getFlagConsultar() {
		return this.flagConsultar;
	}

	public void setFlagConsultar(Boolean flagConsultar) {
		this.flagConsultar = flagConsultar;
	}

	public Boolean getFlagExclur() {
		return this.flagExclur;
	}

	public void setFlagExclur(Boolean flagExclur) {
		this.flagExclur = flagExclur;
	}

	public Boolean getFlagImprimir() {
		return this.flagImprimir;
	}

	public void setFlagImprimir(Boolean flagImprimir) {
		this.flagImprimir = flagImprimir;
	}

	public Boolean getFlagIncluir() {
		return this.flagIncluir;
	}

	public void setFlagIncluir(Boolean flagIncluir) {
		this.flagIncluir = flagIncluir;
	}

	public String getMensagemBloqueio() {
		return this.mensagemBloqueio;
	}

	public void setMensagemBloqueio(String mensagemBloqueio) {
		this.mensagemBloqueio = mensagemBloqueio;
	}

	public List<Segurancatb04PerfilProcesso> getSegurancatb04PerfilProcessos() {
		return this.segurancatb04PerfilProcessos;
	}

	public void setSegurancatb04PerfilProcessos(List<Segurancatb04PerfilProcesso> segurancatb04PerfilProcessos) {
		this.segurancatb04PerfilProcessos = segurancatb04PerfilProcessos;
	}

	public Segurancatb04PerfilProcesso addSegurancatb04PerfilProcesso(Segurancatb04PerfilProcesso segurancatb04PerfilProcesso) {
		getSegurancatb04PerfilProcessos().add(segurancatb04PerfilProcesso);
		segurancatb04PerfilProcesso.setSegurancatb08ProcessoEmpresa(this);

		return segurancatb04PerfilProcesso;
	}

	public Segurancatb04PerfilProcesso removeSegurancatb04PerfilProcesso(Segurancatb04PerfilProcesso segurancatb04PerfilProcesso) {
		getSegurancatb04PerfilProcessos().remove(segurancatb04PerfilProcesso);
		segurancatb04PerfilProcesso.setSegurancatb08ProcessoEmpresa(null);

		return segurancatb04PerfilProcesso;
	}

	public List<Segurancatb06UsuarioProcesso> getSegurancatb06UsuarioProcessos() {
		return this.segurancatb06UsuarioProcessos;
	}

	public void setSegurancatb06UsuarioProcessos(List<Segurancatb06UsuarioProcesso> segurancatb06UsuarioProcessos) {
		this.segurancatb06UsuarioProcessos = segurancatb06UsuarioProcessos;
	}

	public Segurancatb06UsuarioProcesso addSegurancatb06UsuarioProcesso(Segurancatb06UsuarioProcesso segurancatb06UsuarioProcesso) {
		getSegurancatb06UsuarioProcessos().add(segurancatb06UsuarioProcesso);
		segurancatb06UsuarioProcesso.setSegurancatb08ProcessoEmpresa(this);

		return segurancatb06UsuarioProcesso;
	}

	public Segurancatb06UsuarioProcesso removeSegurancatb06UsuarioProcesso(Segurancatb06UsuarioProcesso segurancatb06UsuarioProcesso) {
		getSegurancatb06UsuarioProcessos().remove(segurancatb06UsuarioProcesso);
		segurancatb06UsuarioProcesso.setSegurancatb08ProcessoEmpresa(null);

		return segurancatb06UsuarioProcesso;
	}

	public Empresatb01Empresa getEmpresatb01Empresa() {
		return this.empresatb01Empresa;
	}

	public void setEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
		this.empresatb01Empresa = empresatb01Empresa;
	}

	public Segurancatb02Processo getSegurancatb02Processo() {
		return this.segurancatb02Processo;
	}

	public void setSegurancatb02Processo(Segurancatb02Processo segurancatb02Processo) {
		this.segurancatb02Processo = segurancatb02Processo;
	}

}