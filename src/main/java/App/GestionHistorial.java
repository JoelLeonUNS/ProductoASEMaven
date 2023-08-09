package App;

import conexiones.SqlServerConexion;
import modelo.ModeloConsulta;
import modelo.ModeloExamen;
import modelo.ModeloFamiliar;
import modelo.ModeloHistoriaClinica;
import modelo.ModeloInforme;
import modelo.ModeloMedico;
import modelo.ModeloUsuario;
import presentador.PresentadorGeneral;
import vista.VistaLogin;

public class GestionHistorial {

    public static void main(String[] args) {
        ModeloHistoriaClinica mHistoriaClinica = new ModeloHistoriaClinica();
        ModeloFamiliar mFamiliar = new ModeloFamiliar();
        
        PresentadorGeneral.getInstancia().setModeloPresentadorLogin(new ModeloUsuario());
        PresentadorGeneral.getInstancia().setModeloPresentadorInterfazAdmin(new ModeloMedico());
        PresentadorGeneral.getInstancia().setModeloPresentadorHistoriaClinica(mHistoriaClinica, mFamiliar);
        PresentadorGeneral.getInstancia().setModeloPresentadorExamen(new ModeloExamen(), new ModeloConsulta(), mHistoriaClinica);
        PresentadorGeneral.getInstancia().setModeloPresentadorInforme(new ModeloInforme());
        
        //SqlServerConexion.setDatos("localhost", "1433", "UnidadMedica", "sa", "castillo");   
        SqlServerConexion.setDatos("localhost", "1433", "UnidadMedica", "sa", "sql270399");   
        VistaLogin vLogin = new VistaLogin(PresentadorGeneral.getInstancia()); 
        vLogin.iniciar();
    }
}
