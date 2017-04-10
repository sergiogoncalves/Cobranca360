package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segurancatb07_usuario_cobra_empresa database table.
 * 
 */
@Entity
@Table(name="segurancatb07_usuario_cobra_empresa")
@NamedQuery(name="Segurancatb07UsuarioCobraEmpresa.findAll", query="SELECT s FROM Segurancatb07UsuarioCobraEmpresa s")
public class Segurancatb07UsuarioCobraEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_usuario_cobra_empresa")
	private int codigoUsuarioCobraEmpresa;

	@Column(name="situacao_ativo")
	private byte situacaoAtivo;

	//bi-directional many-to-one association to Empresatb01Empresa
	@ManyToOne
	@JoinColumn(name="empresatb01_codigo_empresa")
	private Empresatb01Empresa empresatb01Empresa;

	//bi-directional many-to-one association to Segurancatb01Usuario
	@ManyToOne
	@JoinColumn(name="segurancatb01_codigo_usuario")
	private Segurancatb01Usuario segurancatb01Usuario;

	public Segurancatb07UsuarioCobraEmpresa() {
	}

	public int getCodigoUsuarioCobraEmpresa() {
		return this.codigoUsuarioCobraEmpresa;
	}

	public void setCodigoUsuarioCobraEmpresa(int codigoUsuarioCobraEmpresa) {
		this.codigoUsuarioCobraEmpresa = codigoUsuarioCobraEmpresa;
	}

	public byte getSituacaoAtivo() {
		return this.situacaoAtivo;
	}

	public void setSituacaoAtivo(byte situacaoAtivo) {
		this.situacaoAtivo = situacaoAtivo;
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

}