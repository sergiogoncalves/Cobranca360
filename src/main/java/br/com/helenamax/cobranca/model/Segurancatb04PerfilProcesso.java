package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segurancatb04_perfil_processos database table.
 * 
 */
@Entity
@Table(name="segurancatb04_perfil_processos")
@NamedQuery(name="Segurancatb04PerfilProcesso.findAll", query="SELECT s FROM Segurancatb04PerfilProcesso s")
public class Segurancatb04PerfilProcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_perfil_processo")
	private int codigoPerfilProcesso;

	@Column(name="flg_alterar")
	private byte flgAlterar;

	@Column(name="flg_consulta")
	private byte flgConsulta;

	@Column(name="flg_excluir")
	private byte flgExcluir;

	@Column(name="flg_imprimir")
	private byte flgImprimir;

	@Column(name="flg_incluir")
	private byte flgIncluir;

	//bi-directional many-to-one association to Segurancatb03Perfil
	@ManyToOne
	@JoinColumn(name="segurancatb03_codigo_perfil")
	private Segurancatb03Perfil segurancatb03Perfil;

	//bi-directional many-to-one association to Segurancatb08ProcessoEmpresa
	@ManyToOne
	@JoinColumn(name="segurantatb08_codigo_proceso_empresa")
	private Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresa;

	public Segurancatb04PerfilProcesso() {
	}

	public int getCodigoPerfilProcesso() {
		return this.codigoPerfilProcesso;
	}

	public void setCodigoPerfilProcesso(int codigoPerfilProcesso) {
		this.codigoPerfilProcesso = codigoPerfilProcesso;
	}

	public byte getFlgAlterar() {
		return this.flgAlterar;
	}

	public void setFlgAlterar(byte flgAlterar) {
		this.flgAlterar = flgAlterar;
	}

	public byte getFlgConsulta() {
		return this.flgConsulta;
	}

	public void setFlgConsulta(byte flgConsulta) {
		this.flgConsulta = flgConsulta;
	}

	public byte getFlgExcluir() {
		return this.flgExcluir;
	}

	public void setFlgExcluir(byte flgExcluir) {
		this.flgExcluir = flgExcluir;
	}

	public byte getFlgImprimir() {
		return this.flgImprimir;
	}

	public void setFlgImprimir(byte flgImprimir) {
		this.flgImprimir = flgImprimir;
	}

	public byte getFlgIncluir() {
		return this.flgIncluir;
	}

	public void setFlgIncluir(byte flgIncluir) {
		this.flgIncluir = flgIncluir;
	}

	public Segurancatb03Perfil getSegurancatb03Perfil() {
		return this.segurancatb03Perfil;
	}

	public void setSegurancatb03Perfil(Segurancatb03Perfil segurancatb03Perfil) {
		this.segurancatb03Perfil = segurancatb03Perfil;
	}

	public Segurancatb08ProcessoEmpresa getSegurancatb08ProcessoEmpresa() {
		return this.segurancatb08ProcessoEmpresa;
	}

	public void setSegurancatb08ProcessoEmpresa(Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresa) {
		this.segurancatb08ProcessoEmpresa = segurancatb08ProcessoEmpresa;
	}

}