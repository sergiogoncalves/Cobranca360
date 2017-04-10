package br.com.helenamax.cobranca.controller;

import br.com.helenamax.cobranca.model.Empresatb01Empresa;
import br.com.helenamax.cobranca.service.Empresatb01EmpresaSrv;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

@ViewScoped
@Named
public class EmpresaCtr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Empresatb01Empresa empresatb01Empresa;

    @Inject
    private Empresatb01EmpresaSrv empresatb01EmpresaSrv;

    private List<Empresatb01Empresa> empresatb01EmpresaColl;

    public void buscarEmpresas() {
        try {
            if (empresatb01EmpresaColl == null) {
                if (FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("CodgEmpresa") == null) {
                    empresatb01EmpresaColl = empresatb01EmpresaSrv.listar();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void salvarEmpresa() {
        String msgErro = "";
        try {
            if (empresatb01Empresa.getCodigoEmpresa() == 0) {
                Empresatb01Empresa temp = empresatb01EmpresaSrv.listarPorCnpj(empresatb01Empresa.getCnpj());

                if (temp != null) {
                    throw new Exception("Cnpj já utilizado");
                    //Throw new e = "Cnpj já utilizado";
                }
            }
            empresatb01EmpresaSrv.salvarMerge(empresatb01Empresa);
            RequestContext.getCurrentInstance().execute("PF('dlgResultado').show();");
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro no formulário", e.getMessage()));
        }

    }

    public void resetForm() {
        this.empresatb01Empresa = new Empresatb01Empresa();
    }

    //----------------------------------------------------------------------------------------------------------------------
    /**
     * @return the empresatb01Empresa
     */
    public Empresatb01Empresa getEmpresatb01Empresa() {
        return empresatb01Empresa;
    }

    /**
     * @param empresatb01Empresa the empresatb01Empresa to set
     */
    public void setEmpresatb01Empresa(Empresatb01Empresa empresatb01Empresa) {
        this.empresatb01Empresa = empresatb01Empresa;
    }

    /**
     * @return the empresatb01EmpresaColl
     */
    public List<Empresatb01Empresa> getEmpresatb01EmpresaColl() {
        return empresatb01EmpresaColl;
    }
}
