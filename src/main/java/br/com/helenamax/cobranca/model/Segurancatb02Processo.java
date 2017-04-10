package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the segurancatb02_processo database table.
 * 
 */
@Entity
@Table(name="segurancatb02_processo")
@NamedQuery(name="Segurancatb02Processo.findAll", query="SELECT s FROM Segurancatb02Processo s")
public class Segurancatb02Processo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo_processo")
	private int codigoProcesso;

	private String descricao;

	@Column(name="flag_menu")
	private Boolean flagMenu;

	private String icone;

	@Column(name="nome_processo")
	private String nomeProcesso;

	private String outcome;

	private String url;

	//bi-directional many-to-one association to Segurancatb02Processo
	@ManyToOne
	@JoinColumn(name="codigo_processo_pai")
	private Segurancatb02Processo segurancatb02ProcessoPai;

	//bi-directional many-to-one association to Segurancatb02Processo
	/*@OneToMany(mappedBy="segurancatb02Processo")
	private List<Segurancatb02Processo> segurancatb02Processos;

	//bi-directional many-to-one association to Segurancatb08ProcessoEmpresa
	@OneToMany(mappedBy="segurancatb02Processo")
	private List<Segurancatb08ProcessoEmpresa> segurancatb08ProcessoEmpresas;
*/
	public Segurancatb02Processo() {
	}

	public int getCodigoProcesso() {
		return this.codigoProcesso;
	}

	public void setCodigoProcesso(int codigoProcesso) {
		this.codigoProcesso = codigoProcesso;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getFlagMenu() {
		return this.flagMenu;
	}

	public void setFlagMenu(Boolean flagMenu) {
		this.flagMenu = flagMenu;
	}

	public String getIcone() {
		return this.icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getNomeProcesso() {
		return this.nomeProcesso;
	}

	public void setNomeProcesso(String nomeProcesso) {
		this.nomeProcesso = nomeProcesso;
	}

	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Segurancatb02Processo getSegurancatb02ProcessoPai() {
		return this.segurancatb02ProcessoPai;
	}

	public void setSegurancatb02ProcessoPai(Segurancatb02Processo segurancatb02Processo) {
		this.segurancatb02ProcessoPai = segurancatb02Processo;
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.codigoProcesso;
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
        final Segurancatb02Processo other = (Segurancatb02Processo) obj;
        if (this.codigoProcesso != other.codigoProcesso) {
            return false;
        }
        return true;
    }




}