
package presentador;

import java.util.ArrayList;
import medicos.Medico;
import modelo.ModeloMedico;

public class PresentadorInterfazAdmin {
    private ModeloMedico modelo;
    private String tipoGuardado;

    public PresentadorInterfazAdmin() {
       
    }
    
    public void setModelo(ModeloMedico modelo) {
         this.modelo = modelo;
    }

    public String getTipoGuardado() {
        return tipoGuardado;
    }

    public void setTipoGuardado(String tipoGuardado) {
        this.tipoGuardado = tipoGuardado;
    }
    
    public void setDatosMedico(String dni, String nombre, String apellidos, String telefono){
        modelo.setDatosMedico(dni, nombre, apellidos, telefono);
    }
    
    public void setDatosUsuario(String usuario, String clave){
        modelo.setDatosUsuario(usuario, clave);
    }
    
    public Medico buscarMedicoDNI(String dni){
        return modelo.buscarMedicoDNI(dni);
    }
    
    public ArrayList<Medico> buscarMedicoCoincidente(String cadena){
        modelo.buscarMedicoCoincidente(cadena);
        return modelo.getMedicosCoincidentesBD();
    }
    
    public void registrar(){
        modelo.registrar();
    }
    
    public void editar(){
        modelo.editar();
    }
    
    public void desactivarCuenta(){
        modelo.darDeBaja();
    }
    
    
    public void nuevoMedico() {
        modelo.setMedico(new Medico());
    }
}
