package App;

import conexiones.SqlServerConexion;
import modelo.ModeloConsulta;
import modelo.ModeloExamen;
import modelo.ModeloHistoriaClinica;
import modelo.ModeloInforme;
import modelo.ModeloMedico;
import modelo.ModeloUsuario;
import presentador.PresentadorGeneral;
import valoresPorDefecto.ConsultasPorDefecto;
import valoresPorDefecto.ExamenesPorDefecto;
import valoresPorDefecto.HistoriasPorDefecto;
import valoresPorDefecto.MedicosPorDefecto;
import vista.VistaLogin;

public class GestionHistorial {

    public static void main(String[] args) {
        MedicosPorDefecto.poblar();
        ExamenesPorDefecto.poblar();
        ConsultasPorDefecto.poblar();
        HistoriasPorDefecto.poblar();
                
        ModeloHistoriaClinica mHistoriaClinica = new ModeloHistoriaClinica();
        
        PresentadorGeneral.getInstancia().setModeloPresentadorLogin(new ModeloUsuario());
        PresentadorGeneral.getInstancia().setModeloPresentadorInterfazAdmin(new ModeloMedico());
        PresentadorGeneral.getInstancia().setModeloPresentadorHistoriaClinica(mHistoriaClinica);
        PresentadorGeneral.getInstancia().setModeloPresentadorExamen(new ModeloExamen(), new ModeloConsulta(), mHistoriaClinica);
        PresentadorGeneral.getInstancia().setModeloPresentadorInforme(new ModeloInforme());
        
        SqlServerConexion.setDatos("localhost", "1433", "UnidadMedica", "sa", "castillo");        
        VistaLogin vLogin = new VistaLogin(PresentadorGeneral.getInstancia()); 
        vLogin.iniciar();
    }
}
