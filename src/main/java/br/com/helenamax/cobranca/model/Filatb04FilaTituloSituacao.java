package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the filatb04_fila_titulo_situacao database table.
 *
 */
@Entity
@Table(name = "filatb04_fila_titulo_situacao")
@NamedQuery(name = "Filatb04FilaTituloSituacao.findAll", query = "SELECT f FROM Filatb04FilaTituloSituacao f")
public class Filatb04FilaTituloSituacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_fila_titulo_situacao")
    private int codigoFilaTituloSituacao;

    private String descricao;

    private String sigla;

    //bi-directional many-to-one association to Filatb03FilaDevedor
    @OneToMany(mappedBy = "filatb04FilaTituloSituacao")
    private List<Filatb03FilaDevedor> filatb03FilaDevedors;

    public Filatb04FilaTituloSituacao() {
    }

    public int getCodigoFilaTituloSituacao() {
        return this.codigoFilaTituloSituacao;
    }

    public void setCodigoFilaTituloSituacao(int codigoFilaTituloSituacao) {
        this.codigoFilaTituloSituacao = codigoFilaTituloSituacao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Filatb03FilaDevedor> getFilatb03FilaDevedors() {
        return this.filatb03FilaDevedors;
    }

    public void setFilatb03FilaDevedors(List<Filatb03FilaDevedor> filatb03FilaDevedors) {
        this.filatb03FilaDevedors = filatb03FilaDevedors;
    }

    public Filatb03FilaDevedor addFilatb03FilaDevedor(Filatb03FilaDevedor filatb03FilaDevedor) {
        getFilatb03FilaDevedors().add(filatb03FilaDevedor);
        filatb03FilaDevedor.setFilatb04FilaTituloSituacao(this);

        return filatb03FilaDevedor;
    }

    public Filatb03FilaDevedor removeFilatb03FilaDevedor(Filatb03FilaDevedor filatb03FilaDevedor) {
        getFilatb03FilaDevedors().remove(filatb03FilaDevedor);
        filatb03FilaDevedor.setFilatb04FilaTituloSituacao(null);

        return filatb03FilaDevedor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
