package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the empresatb06_pessoa_contato database table.
 *
 */
@Entity
@Table(name = "empresatb06_pessoa_contato")
@NamedQuery(name = "Empresatb06PessoaContato.findAll", query = "SELECT e FROM Empresatb06PessoaContato e")
public class Empresatb06PessoaContato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pessoa_contato")
    private int codigoPessoaContato;

    private String descricao;

    private boolean principal;

    //bi-directional many-to-one association to Empresatb02Pessoa
    @ManyToOne
    @JoinColumn(name = "empresatb02_codigo_pessoa")
    private Empresatb02Pessoa empresatb02Pessoa;

    //bi-directional many-to-one association to Geraltb02TipoContato
    @ManyToOne
    @JoinColumn(name = "geraltb02_codigo_tipo_contato")
    private Geraltb02TipoContato geraltb02TipoContato;

    @Transient
    private int colunaAleatoria;

    public Empresatb06PessoaContato() {
    }

    public int getCodigoPessoaContato() {
        return this.codigoPessoaContato;
    }

    public void setCodigoPessoaContato(int codigoPessoaContato) {
        this.codigoPessoaContato = codigoPessoaContato;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Empresatb02Pessoa getEmpresatb02Pessoa() {
        return this.empresatb02Pessoa;
    }

    public void setEmpresatb02Pessoa(Empresatb02Pessoa empresatb02Pessoa) {
        this.empresatb02Pessoa = empresatb02Pessoa;
    }

    public Geraltb02TipoContato getGeraltb02TipoContato() {
        return this.geraltb02TipoContato;
    }

    public void setGeraltb02TipoContato(Geraltb02TipoContato geraltb02TipoContato) {
        this.geraltb02TipoContato = geraltb02TipoContato;
    }

    /**
     * @return the principal
     */
    public boolean getPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    /**
     * @return the colunaAleatoria
     */
    public int getColunaAleatoria() {
        return colunaAleatoria;
    }

    /**
     * @param colunaAleatoria the colunaAleatoria to set
     */
    public void setColunaAleatoria(int colunaAleatoria) {
        this.colunaAleatoria = colunaAleatoria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigoPessoaContato;
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
        final Empresatb06PessoaContato other = (Empresatb06PessoaContato) obj;
        if (this.codigoPessoaContato != other.codigoPessoaContato) {
            return false;
        }
        return true;
    }

    @PostLoad
    public void setarAleatorio() {
        setColunaAleatoria(getCodigoPessoaContato());
    }

}
