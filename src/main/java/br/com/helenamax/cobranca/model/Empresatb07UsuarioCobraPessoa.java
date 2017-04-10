package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresatb07_usuario_cobra_pessoa database table.
 * 
 */
@Entity
@Table(name="empresatb07_usuario_cobra_pessoa")
@NamedQuery(name="Empresatb07UsuarioCobraPessoa.findAll", query="SELECT e FROM Empresatb07UsuarioCobraPessoa e")
public class Empresatb07UsuarioCobraPessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_usuario_cobra_pessoa")
	private int codigoUsuarioCobraPessoa;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="empresatb01_codigo_pessoa")
	private Empresatb02Pessoa empresatb02Pessoa;

	//bi-directional many-to-one association to Segurancatb01Usuario
	@ManyToOne
	@JoinColumn(name="segurancatb01_codigo_usuario")
	private Segurancatb01Usuario segurancatb01Usuario;

	public Empresatb07UsuarioCobraPessoa() {
	}

	public int getCodigoUsuarioCobraPessoa() {
		return this.codigoUsuarioCobraPessoa;
	}

	public void setCodigoUsuarioCobraPessoa(int codigoUsuarioCobraPessoa) {
		this.codigoUsuarioCobraPessoa = codigoUsuarioCobraPessoa;
	}

	public Empresatb02Pessoa getEmpresatb02Pessoa() {
		return this.empresatb02Pessoa;
	}

	public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
		this.empresatb02Pessoa = empresatb02Pessoa;
	}

	public Segurancatb01Usuario getSegurancatb01Usuario() {
		return this.segurancatb01Usuario;
	}

	public void setSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
		this.segurancatb01Usuario = segurancatb01Usuario;
	}

}