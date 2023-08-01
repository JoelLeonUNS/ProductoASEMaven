package presentador;

import historias.HistoriaClinica;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Enfermedad;
import modelo.ModeloHistoriaClinica;
import pacientes.Familiar;

public class PresentadorHistoriaClinica {
    private ModeloHistoriaClinica modeloHistoriaClinica;
    private String tipoHistoria;
    private String tipoGuardado;
    private boolean historiaEstudianteEditable = false;
    private boolean historiaTrabajadorEditable = false;
    
    public PresentadorHistoriaClinica() {    
    }

    public ModeloHistoriaClinica getModeloHistoriaClinica() {
        return modeloHistoriaClinica;
    }
    
    public void setModelo(ModeloHistoriaClinica mHistoriaClinica) {
        this.modeloHistoriaClinica = mHistoriaClinica;
    }
        
    public void cambiarTipoHistoriaClinica(JPanel base, JPanel siguiente) {
        siguiente.setSize(775, 495);
        siguiente.setLocation(0, 0);
        base.removeAll();
        base.add(siguiente, BorderLayout.CENTER);
        base.revalidate();
        base.repaint();
    }
    
    public HistoriaClinica buscarHistoriaClinicaDNI(String dni){
        return modeloHistoriaClinica.buscarHistoriaClinicaDNI(dni);
    }
    
    public ArrayList<HistoriaClinica> buscarHistoriaClinicaCoincidente(String cadena){
        modeloHistoriaClinica.buscarHistoriaCoincidente(cadena);
        return modeloHistoriaClinica.getHistoriasCoincidentesBD();
    }

    public void setHistoriaEditable(boolean editable) {
        switch (tipoHistoria) {
            case "ESTUDIANTE" -> {
                this.historiaEstudianteEditable = editable;
            }
            case "TRABAJADOR" -> {
                this.historiaTrabajadorEditable = editable;
            }   
        }
    }

    public boolean isHistoriaEditable() {
        switch (tipoHistoria) {
            case "ESTUDIANTE" -> {
                return this.historiaEstudianteEditable;
            }
            case "TRABAJADOR" -> {
                return this.historiaTrabajadorEditable;
            }   
        }
        return false;
    }

    public String getTipoHistoria() {
        return tipoHistoria;
    }

    public void setTipoHistoria(String tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public String getTipoGuardado() {
        return tipoGuardado;
    }

    public void setTipoGuardado(String tipoGuardado) {
        this.tipoGuardado = tipoGuardado;
    }
    
    public void registrarHistoriaClinica() {
        switch (tipoHistoria) {
            case "ESTUDIANTE" -> {
                modeloHistoriaClinica.registrarHistoriaEstudiante();
            }
            case "TRABAJADOR" -> {
                modeloHistoriaClinica.registrarHistoriaTrabajador();
            }   
        }
    }
    
    public void editarHistoriaClinica() {
        switch (tipoHistoria) {
            case "ESTUDIANTE" -> {
                modeloHistoriaClinica.editarHistoriaEstudiante();
            }
            case "TRABAJADOR" -> {
                modeloHistoriaClinica.editarHistoriaTrabajador();
            }   
        }
    }
    
    public void setDatosFamiliar(String nombreFamiliar, String parentesco, String direccionFamiliar, String telefonoFamiliar, String antecedentesPatologicos) {
        modeloHistoriaClinica.setFamiliar(nombreFamiliar, parentesco, direccionFamiliar, telefonoFamiliar, antecedentesPatologicos);
    }
    
    public void agregarFamiliar(int indice) {
        switch (tipoHistoria) {
            case "ESTUDIANTE" -> {
                modeloHistoriaClinica.addFamiliaresEstudiante(indice, modeloHistoriaClinica.getFamiliar());
            }
            case "TRABAJADOR" -> {
                modeloHistoriaClinica.addFamiliaresTrabajador(indice, modeloHistoriaClinica.getFamiliar());
            }   
        }
    }
    
    public Familiar getFamiliar(int indice) {
        switch (tipoHistoria) {
            case "ESTUDIANTE" -> {
                return modeloHistoriaClinica.getFamiliaresEstudiante(indice);
            }
            case "TRABAJADOR" -> {
                return modeloHistoriaClinica.getFamiliaresTrabajador(indice);
            }   
        }
        return null;
    }
    
    public void agregarEnfermedad(Enfermedad enfermedad) {
        modeloHistoriaClinica.agregarAntecedentePatologico(enfermedad);
    }
    
    public void limpiarAntecedentesPatologicos() {
        modeloHistoriaClinica.limpiarAntecedentesPatologicos();
    }
}
