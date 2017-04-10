package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the filatb02_fila_usuario database table.
 * 
 */
@Entity
@Table(name="filatb02_fila_usuario")
@NamedQuery(name="Filatb02FilaUsuario.findAll", query="SELECT f FROM Filatb02FilaUsuario f")
public class Filatb02FilaUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_fila_usuario")
	private int codigoFilaUsuario;

	private Boolean ativo;

	//bi-directional many-to-one association to Filatb01Fila
	@ManyToOne
	@JoinColumn(name="filatb01_codigo_fila")
	private Filatb01Fila filatb01Fila;

	//bi-directional many-to-one association to Segurancatb01Usuario
	@ManyToOne
	@JoinColumn(name="segurancatb01_codigo_usuario")
	private Segurancatb01Usuario segurancatb01Usuario;

	public Filatb02FilaUsuario() {
	}

	public int getCodigoFilaUsuario() {
		return this.codigoFilaUsuario;
	}

	public void setCodigoFilaUsuario(int codigoFilaUsuario) {
		this.codigoFilaUsuario = codigoFilaUsuario;
	}

	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Filatb01Fila getFilatb01Fila() {
		return this.filatb01Fila;
	}

	public void setFilatb01Fila(Filatb01Fila filatb01Fila) {
		this.filatb01Fila = filatb01Fila;
	}

	public Segurancatb01Usuario getSegurancatb01Usuario() {
		return this.segurancatb01Usuario;
	}

	public void setSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
		this.segurancatb01Usuario = segurancatb01Usuario;
	}

}