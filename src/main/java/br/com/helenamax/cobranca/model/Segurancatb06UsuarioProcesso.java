package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segurancatb06_usuario_processo database table.
 * 
 */
@Entity
@Table(name="segurancatb06_usuario_processo")
@NamedQuery(name="Segurancatb06UsuarioProcesso.findAll", query="SELECT s FROM Segurancatb06UsuarioProcesso s")
public class Segurancatb06UsuarioProcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_usuario_processo")
	private int codigoUsuarioProcesso;

	@Column(name="flg_alterar")
	private Boolean flgAlterar;

	@Column(name="flg_consultar")
	private Boolean flgConsultar;

	@Column(name="flg_excluir")
	private Boolean flgExcluir;

	@Column(name="flg_imprimir")
	private Boolean flgImprimir;

	@Column(name="flg_incluir")
	private Boolean flgIncluir;

	//bi-directional many-to-one association to Segurancatb01Usuario
	@ManyToOne
	@JoinColumn(name="segurancatb01_codigo_usuario")
	private Segurancatb01Usuario segurancatb01Usuario;

	//bi-directional many-to-one association to Segurancatb08ProcessoEmpresa
	@ManyToOne
	@JoinColumn(name="segurancatb08_codigo_processo_empresa")
	private Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresa;

	public Segurancatb06UsuarioProcesso() {
	}

	public int getCodigoUsuarioProcesso() {
		return this.codigoUsuarioProcesso;
	}

	public void setCodigoUsuarioProcesso(int codigoUsuarioProcesso) {
		this.codigoUsuarioProcesso = codigoUsuarioProcesso;
	}

	public Boolean getFlgAlterar() {
		return this.flgAlterar;
	}

	public void setFlgAlterar(Boolean flgAlterar) {
		this.flgAlterar = flgAlterar;
	}

	public Boolean getFlgConsultar() {
		return this.flgConsultar;
	}

	public void setFlgConsultar(Boolean flgConsultar) {
		this.flgConsultar = flgConsultar;
	}

	public Boolean getFlgExcluir() {
		return this.flgExcluir;
	}

	public void setFlgExcluir(Boolean flgExcluir) {
		this.flgExcluir = flgExcluir;
	}

	public Boolean getFlgImprimir() {
		return this.flgImprimir;
	}

	public void setFlgImprimir(Boolean flgImprimir) {
		this.flgImprimir = flgImprimir;
	}

	public Boolean getFlgIncluir() {
		return this.flgIncluir;
	}

	public void setFlgIncluir(Boolean flgIncluir) {
		this.flgIncluir = flgIncluir;
	}

	public Segurancatb01Usuario getSegurancatb01Usuario() {
		return this.segurancatb01Usuario;
	}

	public void setSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
		this.segurancatb01Usuario = segurancatb01Usuario;
	}

	public Segurancatb08ProcessoEmpresa getSegurancatb08ProcessoEmpresa() {
		return this.segurancatb08ProcessoEmpresa;
	}

	public void setSegurancatb08ProcessoEmpresa(Segurancatb08ProcessoEmpresa segurancatb08ProcessoEmpresa) {
		this.segurancatb08ProcessoEmpresa = segurancatb08ProcessoEmpresa;
	}

}