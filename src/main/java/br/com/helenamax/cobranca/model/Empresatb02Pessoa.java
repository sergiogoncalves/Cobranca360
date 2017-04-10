package br.com.helenamax.cobranca.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresatb02_pessoa database table.
 * 
 */
@Entity
@Table(name="empresatb02_pessoa")
@NamedQuery(name="Empresatb02Pessoa.findAll", query="SELECT e FROM Empresatb02Pessoa e")
public class Empresatb02Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pessoa_codigo")
	private int pessoaCodigo;

	private String nome;

	@Column(name="tipo_pessoa")
	private String tipoPessoa;
        
        @Transient
        private String cpfCnpj;
        
        @Transient
        private Empresatb03PessoaFisica empresatb03PessoaFisica;
        
        @Transient
        private Empresatb04PessoaJuridica empresatb04PessoaJuridica;

	//bi-directional many-to-one association to Cobrancatb01Titulo
	@OneToMany(mappedBy="empresatb02PessoaCredor")
	private List<Cobrancatb01Titulo> cobrancatb01Titulos1;

	//bi-directional many-to-one association to Cobrancatb01Titulo
	@OneToMany(mappedBy="empresatb02PessoaDevedor")
	private List<Cobrancatb01Titulo> cobrancatb01Titulos2;

	//bi-directional many-to-one association to Empresatb01Empresa
	@ManyToOne
	@JoinColumn(name="empresatb01_codigo_empresa")
	private Empresatb01Empresa empresatb01Empresa;

	//bi-directional many-to-one association to Empresatb03PessoaFisica
	@OneToMany(mappedBy="empresatb02Pessoa")
	private List<Empresatb03PessoaFisica> empresatb03PessoaFisicas;

	//bi-directional many-to-one association to Empresatb04PessoaJuridica
	@OneToMany(mappedBy="empresatb02Pessoa")
	private List<Empresatb04PessoaJuridica> empresatb04PessoaJuridicas;

	//bi-directional many-to-one association to Empresatb05PessoaEndereco
	@OneToMany(mappedBy="empresatb02Pessoa")
	private List<Empresatb05PessoaEndereco> empresatb05PessoaEnderecos;

	//bi-directional many-to-one association to Empresatb06PessoaContato
	@OneToMany(mappedBy="empresatb02Pessoa")
	private List<Empresatb06PessoaContato> empresatb06PessoaContatos;

	//bi-directional many-to-one association to Empresatb07UsuarioCobraPessoa
	@OneToMany(mappedBy="empresatb02Pessoa")
	private List<Empresatb07UsuarioCobraPessoa> empresatb07UsuarioCobraPessoas;

	//bi-directional many-to-one association to Segurancatb01Usuario
	@OneToMany(mappedBy="empresatb02Pessoa")
	private List<Segurancatb01Usuario> segurancatb01Usuarios;

	//bi-directional many-to-one association to Empresatb10PessoaResponsavel
	@OneToMany(mappedBy="empresatb02Pessoa1")
	private List<Empresatb10PessoaResponsavel> empresatb10PessoaResponsavels1;

	//bi-directional many-to-one association to Empresatb10PessoaResponsavel
	@OneToMany(mappedBy="empresatb02Pessoa2")
	private List<Empresatb10PessoaResponsavel> empresatb10PessoaResponsavels2;

	public Empresatb02Pessoa() {
	}

	public int getPessoaCodigo() {
		return this.pessoaCodigo;
	}

	public void setPessoaCodigo(int pessoaCodigo) {
		this.pessoaCodigo = pessoaCodigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Cobrancatb01Titulo> getCobrancatb01Titulos1() {
		return this.cobrancatb01Titulos1;
	}

	public void setCobrancatb01Titulos1(List<Cobrancatb01Titulo> cobrancatb01Titulos1) {
		this.cobrancatb01Titulos1 = cobrancatb01Titulos1;
	}

	public Cobrancatb01Titulo addCobrancatb01Titulos1(Cobrancatb01Titulo cobrancatb01Titulos1) {
		getCobrancatb01Titulos1().add(cobrancatb01Titulos1);
		cobrancatb01Titulos1.setEmpresatb02PessoaCredor(this);

		return cobrancatb01Titulos1;
	}

	public Cobrancatb01Titulo removeCobrancatb01Titulos1(Cobrancatb01Titulo cobrancatb01Titulos1) {
		getCobrancatb01Titulos1().remove(cobrancatb01Titulos1);
		cobrancatb01Titulos1.setEmpresatb02PessoaCredor(null);

		return cobrancatb01Titulos1;
	}

	public List<Cobrancatb01Titulo> getCobrancatb01Titulos2() {
		return this.cobrancatb01Titulos2;
	}

	public void setCobrancatb01Titulos2(List<Cobrancatb01Titulo> cobrancatb01Titulos2) {
		this.cobrancatb01Titulos2 = cobrancatb01Titulos2;
	}

	public Cobrancatb01Titulo addCobrancatb01Titulos2(Cobrancatb01Titulo cobrancatb01Titulos2) {
		getCobrancatb01Titulos2().add(cobrancatb01Titulos2);
		cobrancatb01Titulos2.setEmpresatb02PessoaDevedor(this);

		return cobrancatb01Titulos2;
	}

	public Cobrancatb01Titulo removeCobrancatb01Titulos2(Cobrancatb01Titulo cobrancatb01Titulos2) {
		getCobrancatb01Titulos2().remove(cobrancatb01Titulos2);
		cobrancatb01Titulos2.setEmpresatb02PessoaDevedor(null);

		return cobrancatb01Titulos2;
	}

	public Empresatb01Empresa getEmpresatb01Empresa() {
		return this.empresatb01Empresa;
	}

	public void setEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
		this.empresatb01Empresa = empresatb01Empresa;
	}

	public List<Empresatb03PessoaFisica> getEmpresatb03PessoaFisicas() {
		return this.empresatb03PessoaFisicas;
	}

	public void setEmpresatb03PessoaFisicas(List<Empresatb03PessoaFisica> empresatb03PessoaFisicas) {
		this.empresatb03PessoaFisicas = empresatb03PessoaFisicas;
	}

	public Empresatb03PessoaFisica addEmpresatb03PessoaFisica(Empresatb03PessoaFisica empresatb03PessoaFisica) {
		getEmpresatb03PessoaFisicas().add(empresatb03PessoaFisica);
		empresatb03PessoaFisica.setEmpresatb02Pessoa(this);

		return empresatb03PessoaFisica;
	}

	public Empresatb03PessoaFisica removeEmpresatb03PessoaFisica(Empresatb03PessoaFisica empresatb03PessoaFisica) {
		getEmpresatb03PessoaFisicas().remove(empresatb03PessoaFisica);
		empresatb03PessoaFisica.setEmpresatb02Pessoa(null);

		return empresatb03PessoaFisica;
	}

	public List<Empresatb04PessoaJuridica> getEmpresatb04PessoaJuridicas() {
		return this.empresatb04PessoaJuridicas;
	}

	public void setEmpresatb04PessoaJuridicas(List<Empresatb04PessoaJuridica> empresatb04PessoaJuridicas) {
		this.empresatb04PessoaJuridicas = empresatb04PessoaJuridicas;
	}

	public Empresatb04PessoaJuridica addEmpresatb04PessoaJuridica(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
		getEmpresatb04PessoaJuridicas().add(empresatb04PessoaJuridica);
		empresatb04PessoaJuridica.setEmpresatb02Pessoa(this);

		return empresatb04PessoaJuridica;
	}

	public Empresatb04PessoaJuridica removeEmpresatb04PessoaJuridica(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
		getEmpresatb04PessoaJuridicas().remove(empresatb04PessoaJuridica);
		empresatb04PessoaJuridica.setEmpresatb02Pessoa(null);

		return empresatb04PessoaJuridica;
	}

	public List<Empresatb05PessoaEndereco> getEmpresatb05PessoaEnderecos() {
		return this.empresatb05PessoaEnderecos;
	}

	public void setEmpresatb05PessoaEnderecos(List<Empresatb05PessoaEndereco> empresatb05PessoaEnderecos) {
		this.empresatb05PessoaEnderecos = empresatb05PessoaEnderecos;
	}

	public Empresatb05PessoaEndereco addEmpresatb05PessoaEndereco(Empresatb05PessoaEndereco empresatb05PessoaEndereco) {
		getEmpresatb05PessoaEnderecos().add(empresatb05PessoaEndereco);
		empresatb05PessoaEndereco.setEmpresatb02Pessoa(this);

		return empresatb05PessoaEndereco;
	}

	public Empresatb05PessoaEndereco removeEmpresatb05PessoaEndereco(Empresatb05PessoaEndereco empresatb05PessoaEndereco) {
		getEmpresatb05PessoaEnderecos().remove(empresatb05PessoaEndereco);
		empresatb05PessoaEndereco.setEmpresatb02Pessoa(null);

		return empresatb05PessoaEndereco;
	}

	public List<Empresatb06PessoaContato> getEmpresatb06PessoaContatos() {
		return this.empresatb06PessoaContatos;
	}

	public void setEmpresatb06PessoaContatos(List<Empresatb06PessoaContato> empresatb06PessoaContatos) {
		this.empresatb06PessoaContatos = empresatb06PessoaContatos;
	}

	public Empresatb06PessoaContato addEmpresatb06PessoaContato(Empresatb06PessoaContato empresatb06PessoaContato) {
		getEmpresatb06PessoaContatos().add(empresatb06PessoaContato);
		empresatb06PessoaContato.setEmpresatb02Pessoa(this);

		return empresatb06PessoaContato;
	}

	public Empresatb06PessoaContato removeEmpresatb06PessoaContato(Empresatb06PessoaContato empresatb06PessoaContato) {
		getEmpresatb06PessoaContatos().remove(empresatb06PessoaContato);
		empresatb06PessoaContato.setEmpresatb02Pessoa(null);

		return empresatb06PessoaContato;
	}

	public List<Empresatb07UsuarioCobraPessoa> getEmpresatb07UsuarioCobraPessoas() {
		return this.empresatb07UsuarioCobraPessoas;
	}

	public void setEmpresatb07UsuarioCobraPessoas(List<Empresatb07UsuarioCobraPessoa> empresatb07UsuarioCobraPessoas) {
		this.empresatb07UsuarioCobraPessoas = empresatb07UsuarioCobraPessoas;
	}

	public Empresatb07UsuarioCobraPessoa addEmpresatb07UsuarioCobraPessoa(Empresatb07UsuarioCobraPessoa empresatb07UsuarioCobraPessoa) {
		getEmpresatb07UsuarioCobraPessoas().add(empresatb07UsuarioCobraPessoa);
		empresatb07UsuarioCobraPessoa.setEmpresatb02Pessoa(this);

		return empresatb07UsuarioCobraPessoa;
	}

	public Empresatb07UsuarioCobraPessoa removeEmpresatb07UsuarioCobraPessoa(Empresatb07UsuarioCobraPessoa empresatb07UsuarioCobraPessoa) {
		getEmpresatb07UsuarioCobraPessoas().remove(empresatb07UsuarioCobraPessoa);
		empresatb07UsuarioCobraPessoa.setEmpresatb02Pessoa(null);

		return empresatb07UsuarioCobraPessoa;
	}


	public List<Segurancatb01Usuario> getSegurancatb01Usuarios() {
		return this.segurancatb01Usuarios;
	}

	public void setSegurancatb01Usuarios(List<Segurancatb01Usuario> segurancatb01Usuarios) {
		this.segurancatb01Usuarios = segurancatb01Usuarios;
	}

	public Segurancatb01Usuario addSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
		getSegurancatb01Usuarios().add(segurancatb01Usuario);
		segurancatb01Usuario.setEmpresatb02Pessoa(this);

		return segurancatb01Usuario;
	}

	public Segurancatb01Usuario removeSegurancatb01Usuario(Segurancatb01Usuario segurancatb01Usuario) {
		getSegurancatb01Usuarios().remove(segurancatb01Usuario);
		segurancatb01Usuario.setEmpresatb02Pessoa(null);

		return segurancatb01Usuario;
	}

	public List<Empresatb10PessoaResponsavel> getEmpresatb10PessoaResponsavels1() {
		return this.empresatb10PessoaResponsavels1;
	}

	public void setEmpresatb10PessoaResponsavels1(List<Empresatb10PessoaResponsavel> empresatb10PessoaResponsavels1) {
		this.empresatb10PessoaResponsavels1 = empresatb10PessoaResponsavels1;
	}

	public Empresatb10PessoaResponsavel addEmpresatb10PessoaResponsavels1(Empresatb10PessoaResponsavel empresatb10PessoaResponsavels1) {
		getEmpresatb10PessoaResponsavels1().add(empresatb10PessoaResponsavels1);
		empresatb10PessoaResponsavels1.setEmpresatb02Pessoa1(this);

		return empresatb10PessoaResponsavels1;
	}

	public Empresatb10PessoaResponsavel removeEmpresatb10PessoaResponsavels1(Empresatb10PessoaResponsavel empresatb10PessoaResponsavels1) {
		getEmpresatb10PessoaResponsavels1().remove(empresatb10PessoaResponsavels1);
		empresatb10PessoaResponsavels1.setEmpresatb02Pessoa1(null);

		return empresatb10PessoaResponsavels1;
	}

	public List<Empresatb10PessoaResponsavel> getEmpresatb10PessoaResponsavels2() {
		return this.empresatb10PessoaResponsavels2;
	}

	public void setEmpresatb10PessoaResponsavels2(List<Empresatb10PessoaResponsavel> empresatb10PessoaResponsavels2) {
		this.empresatb10PessoaResponsavels2 = empresatb10PessoaResponsavels2;
	}

	public Empresatb10PessoaResponsavel addEmpresatb10PessoaResponsavels2(Empresatb10PessoaResponsavel empresatb10PessoaResponsavels2) {
		getEmpresatb10PessoaResponsavels2().add(empresatb10PessoaResponsavels2);
		empresatb10PessoaResponsavels2.setEmpresatb02Pessoa2(this);

		return empresatb10PessoaResponsavels2;
	}

	public Empresatb10PessoaResponsavel removeEmpresatb10PessoaResponsavels2(Empresatb10PessoaResponsavel empresatb10PessoaResponsavels2) {
		getEmpresatb10PessoaResponsavels2().remove(empresatb10PessoaResponsavels2);
		empresatb10PessoaResponsavels2.setEmpresatb02Pessoa2(null);

		return empresatb10PessoaResponsavels2;
	}

    /**
     * @return the cpfCnpj
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * @param cpfCnpj the cpfCnpj to set
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.pessoaCodigo;
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
        final Empresatb02Pessoa other = (Empresatb02Pessoa) obj;
        if (this.pessoaCodigo != other.pessoaCodigo) {
            return false;
        }
        return true;
    }

    /**
     * @return the empresatb03PessoaFisica
     */
    public Empresatb03PessoaFisica getEmpresatb03PessoaFisica() {
        return empresatb03PessoaFisica;
    }

    /**
     * @param empresatb03PessoaFisica the empresatb03PessoaFisica to set
     */
    public void setEmpresatb03PessoaFisica(Empresatb03PessoaFisica empresatb03PessoaFisica) {
        this.empresatb03PessoaFisica = empresatb03PessoaFisica;
    }

    /**
     * @return the empresatb04PessoaJuridica
     */
    public Empresatb04PessoaJuridica getEmpresatb04PessoaJuridica() {
        return empresatb04PessoaJuridica;
    }

    /**
     * @param empresatb04PessoaJuridica the empresatb04PessoaJuridica to set
     */
    public void setEmpresatb04PessoaJuridica(Empresatb04PessoaJuridica empresatb04PessoaJuridica) {
        this.empresatb04PessoaJuridica = empresatb04PessoaJuridica;
    }
    
    

}