package presentador;

import modelo.ModeloConsulta;
import modelo.ModeloExamen;
import modelo.ModeloFamiliar;
import modelo.ModeloHistoriaClinica;
import modelo.ModeloInforme;
import modelo.ModeloMedico;
import modelo.ModeloUsuario;
import vista.VistaInterfazAdmin;
import vista.VistaLogin;
import vista.VistaInterfazMedico;

public class PresentadorGeneral {
    private PresentadorLogin pLogin;   
    private PresentadorInterfazAdmin pInterfazAdmin;
    
    private PresentadorInterfazMedico pInterfazMedico;
        private PresentadorHistoriaClinica pHistoriaClinica;
        private PresentadorExamen pExamen;
        private PresentadorInforme pInforme;
        
    private static PresentadorGeneral pGeneral;

    public PresentadorGeneral() {
        pLogin = new PresentadorLogin();
        pInterfazAdmin = new PresentadorInterfazAdmin();
        pInterfazMedico = new PresentadorInterfazMedico();
        pHistoriaClinica = new PresentadorHistoriaClinica();
        pExamen = new PresentadorExamen();
        pInforme= new PresentadorInforme();
    }
    
    public static PresentadorGeneral getInstancia() {
        if (pGeneral == null) {
            return pGeneral = new PresentadorGeneral();
        } else {
            return pGeneral;
        }
    }
    
    public void mostrarVistaInterfazMedico() {
        VistaInterfazMedico vistaInterfazMedico = new VistaInterfazMedico(PresentadorGeneral.getInstancia());
        vistaInterfazMedico.iniciar();
    }
    
    public void mostrarVistaInterfazAdmin() {
        VistaInterfazAdmin vistaAdmin = new VistaInterfazAdmin(PresentadorGeneral.getInstancia());
        vistaAdmin.iniciar();
    }
    
    public void mostrarVistaLogin() {
        VistaLogin vistaLogin = new VistaLogin(PresentadorGeneral.getInstancia());
        vistaLogin.iniciar();
    }
    
    
    //
    public void setModeloPresentadorLogin(ModeloUsuario mUsuario) {
        pLogin.setModelo(mUsuario);
    }
    
    public void setModeloPresentadorInterfazAdmin(ModeloMedico mMedico) {
        pInterfazAdmin.setModelo(mMedico);
    }

    public void setModeloPresentadorHistoriaClinica(ModeloHistoriaClinica mHistoriClinica, ModeloFamiliar mFamiliar) {
        pHistoriaClinica.setModeloHistoriaClinica(mHistoriClinica);
        pHistoriaClinica.setModeloFamiliar(mFamiliar);
    }
    
    public void setModeloPresentadorExamen(ModeloExamen mExamen, ModeloConsulta mConsulta, ModeloHistoriaClinica mHistoriClinica) {
        pExamen.setModeloConsulta(mConsulta);
        pExamen.setModeloExamen(mExamen);
        pExamen.setModeloHistoriaClinica(mHistoriClinica);
    }
    
    public void setModeloPresentadorInforme(ModeloInforme mInforme){
        pInforme.setModeloInforme(mInforme);
    }
    
    
    
    //

    
    public PresentadorLogin getpLogin() {
        return pLogin;
    }

    public PresentadorInterfazMedico getpInterfazMedico() {
        return pInterfazMedico;
    }

    public PresentadorHistoriaClinica getpHistoriaClinica() {
        return pHistoriaClinica;
    }

    public PresentadorExamen getpExamen() {
        return pExamen;
    }

    public PresentadorInterfazAdmin getpInterfazAdmin() {
        return pInterfazAdmin;
    }

    public void setpExamen(PresentadorExamen pExamen) {
        this.pExamen = pExamen;
    }

    public PresentadorInforme getpInforme() {
        return pInforme;
    }

    public void setpInforme(PresentadorInforme pInforme) {
        this.pInforme = pInforme;
    }
    
}
