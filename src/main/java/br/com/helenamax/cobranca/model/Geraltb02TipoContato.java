package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the geraltb02_tipo_contato database table.
 *
 */
@Entity
@Table(name = "geraltb02_tipo_contato")
@NamedQuery(name = "Geraltb02TipoContato.findAll", query = "SELECT g FROM Geraltb02TipoContato g")
public class Geraltb02TipoContato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_tipo_contato")
    private int codigoTipoContato;

    private String descricao;

    //bi-directional many-to-one association to Empresatb06PessoaContato
    @OneToMany(mappedBy = "geraltb02TipoContato")
    private List<Empresatb06PessoaContato> empresatb06PessoaContatos;

    public Geraltb02TipoContato() {
    }

    public int getCodigoTipoContato() {
        return this.codigoTipoContato;
    }

    public void setCodigoTipoContato(int codigoTipoContato) {
        this.codigoTipoContato = codigoTipoContato;
    }

    public List<Empresatb06PessoaContato> getEmpresatb06PessoaContatos() {
        return this.empresatb06PessoaContatos;
    }

    public void setEmpresatb06PessoaContatos(List<Empresatb06PessoaContato> empresatb06PessoaContatos) {
        this.empresatb06PessoaContatos = empresatb06PessoaContatos;
    }

    public Empresatb06PessoaContato addEmpresatb06PessoaContato(Empresatb06PessoaContato empresatb06PessoaContato) {
        getEmpresatb06PessoaContatos().add(empresatb06PessoaContato);
        empresatb06PessoaContato.setGeraltb02TipoContato(this);

        return empresatb06PessoaContato;
    }

    public Empresatb06PessoaContato removeEmpresatb06PessoaContato(Empresatb06PessoaContato empresatb06PessoaContato) {
        getEmpresatb06PessoaContatos().remove(empresatb06PessoaContato);
        empresatb06PessoaContato.setGeraltb02TipoContato(null);

        return empresatb06PessoaContato;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigoTipoContato;
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
        final Geraltb02TipoContato other = (Geraltb02TipoContato) obj;
        if (this.codigoTipoContato != other.codigoTipoContato) {
            return false;
        }
        return true;
    }

}
