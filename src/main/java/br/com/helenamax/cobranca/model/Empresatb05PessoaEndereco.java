package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresatb05_pessoa_endereco database table.
 * 
 */
@Entity
@Table(name="empresatb05_pessoa_endereco")
@NamedQuery(name="Empresatb05PessoaEndereco.findAll", query="SELECT e FROM Empresatb05PessoaEndereco e")
public class Empresatb05PessoaEndereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_pessoa_endereco")
	private int codigoPessoaEndereco;

	private String bairro;

	private String cep;

	private String cidade;

	private String complemento;

	private String endereco;

	private String estado;

	@Column(name="flg_principal")
	private String flgPrincipal;

	private String numero;

	//bi-directional many-to-one association to Empresatb02Pessoa
	@ManyToOne
	@JoinColumn(name="empresatb02_codigo_pessoa")
	private Empresatb02Pessoa empresatb02Pessoa;

	public Empresatb05PessoaEndereco() {
	}

	public int getCodigoPessoaEndereco() {
		return this.codigoPessoaEndereco;
	}

	public void setCodigoPessoaEndereco(int codigoPessoaEndereco) {
		this.codigoPessoaEndereco = codigoPessoaEndereco;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFlgPrincipal() {
		return this.flgPrincipal;
	}

	public void setFlgPrincipal(String flgPrincipal) {
		this.flgPrincipal = flgPrincipal;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Empresatb02Pessoa getEmpresatb02Pessoa() {
		return this.empresatb02Pessoa;
	}

	public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
		this.empresatb02Pessoa = empresatb02Pessoa;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigoPessoaEndereco;
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
        final Empresatb05PessoaEndereco other = (Empresatb05PessoaEndereco) obj;
        if (this.codigoPessoaEndereco != other.codigoPessoaEndereco) {
            return false;
        }
        return true;
    }
        
        

}