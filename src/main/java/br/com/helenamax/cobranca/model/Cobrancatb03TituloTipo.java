package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cobrancatb03_titulo_tipo database table.
 * 
 */
@Entity
@Table(name="cobrancatb03_titulo_tipo")
@NamedQuery(name="Cobrancatb03TituloTipo.findAll", query="SELECT c FROM Cobrancatb03TituloTipo c")
public class Cobrancatb03TituloTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_titulo_tipo")
	private int codigoTituloTipo;

	private String descricao;

	private String sigla;

	//bi-directional many-to-one association to Cobrancatb01Titulo
	@OneToMany(mappedBy="cobrancatb03TituloTipo")
	private List<Cobrancatb01Titulo> cobrancatb01Titulos;

	public Cobrancatb03TituloTipo() {
	}

	public int getCodigoTituloTipo() {
		return this.codigoTituloTipo;
	}

	public void setCodigoTituloTipo(int codigoTituloTipo) {
		this.codigoTituloTipo = codigoTituloTipo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cobrancatb01Titulo> getCobrancatb01Titulos() {
		return this.cobrancatb01Titulos;
	}

	public void setCobrancatb01Titulos(List<Cobrancatb01Titulo> cobrancatb01Titulos) {
		this.cobrancatb01Titulos = cobrancatb01Titulos;
	}

	public Cobrancatb01Titulo addCobrancatb01Titulo(Cobrancatb01Titulo cobrancatb01Titulo) {
		getCobrancatb01Titulos().add(cobrancatb01Titulo);
		cobrancatb01Titulo.setCobrancatb03TituloTipo(this);

		return cobrancatb01Titulo;
	}

	public Cobrancatb01Titulo removeCobrancatb01Titulo(Cobrancatb01Titulo cobrancatb01Titulo) {
		getCobrancatb01Titulos().remove(cobrancatb01Titulo);
		cobrancatb01Titulo.setCobrancatb03TituloTipo(null);

		return cobrancatb01Titulo;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigoTituloTipo;
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
        final Cobrancatb03TituloTipo other = (Cobrancatb03TituloTipo) obj;
        if (this.codigoTituloTipo != other.codigoTituloTipo) {
            return false;
        }
        return true;
    }
        
        

}