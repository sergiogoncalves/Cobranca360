package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segurancatb05_perfil_usuario database table.
 * 
 */
@Entity
@Table(name="segurancatb05_perfil_usuario")
@NamedQuery(name="Segurancatb05PerfilUsuario.findAll", query="SELECT s FROM Segurancatb05PerfilUsuario s")
public class Segurancatb05PerfilUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_perfil_usuario")
	private int codigoPerfilUsuario;

	//bi-directional many-to-one association to Segurancatb01Usuario
	@ManyToOne
	@JoinColumn(name="segurancatb01_usuario")
	private Segurancatb01Usuario segurancatb01UsuarioBean;

	//bi-directional many-to-one association to Segurancatb03Perfil
	@ManyToOne
	@JoinColumn(name="segurancatb03_codigo_perfil")
	private Segurancatb03Perfil segurancatb03Perfil;

	public Segurancatb05PerfilUsuario() {
	}

	public int getCodigoPerfilUsuario() {
		return this.codigoPerfilUsuario;
	}

	public void setCodigoPerfilUsuario(int codigoPerfilUsuario) {
		this.codigoPerfilUsuario = codigoPerfilUsuario;
	}

	public Segurancatb01Usuario getSegurancatb01UsuarioBean() {
		return this.segurancatb01UsuarioBean;
	}

	public void setSegurancatb01UsuarioBean(Segurancatb01Usuario segurancatb01UsuarioBean) {
		this.segurancatb01UsuarioBean = segurancatb01UsuarioBean;
	}

	public Segurancatb03Perfil getSegurancatb03Perfil() {
		return this.segurancatb03Perfil;
	}

	public void setSegurancatb03Perfil(Segurancatb03Perfil segurancatb03Perfil) {
		this.segurancatb03Perfil = segurancatb03Perfil;
	}

}