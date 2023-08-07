package presentador;

import historias.HistoriaClinica;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Enfermedad;
import modelo.Escuela;
import modelo.ModeloFamiliar;
import modelo.ModeloHistoriaClinica;
import pacientes.Alumno;
import pacientes.Familiar;
import pacientes.Trabajador;

public class PresentadorHistoriaClinica {
    private ModeloHistoriaClinica modeloHistoriaClinica;
    private ModeloFamiliar modeloFamiliar;
    private String tipoHistoria;
    private String tipoGuardado;
    private boolean historiaEstudianteEditable = false;
    private boolean historiaTrabajadorEditable = false;
    
    public PresentadorHistoriaClinica() {    
    }

    public ModeloHistoriaClinica getModeloHistoriaClinica() {
        return modeloHistoriaClinica;
    }
    
    public void setModeloHistoriaClinica(ModeloHistoriaClinica mHistoriaClinica) {
        this.modeloHistoriaClinica = mHistoriaClinica;
    }

    public ModeloFamiliar getModeloFamiliar() {
        return modeloFamiliar;
    }
    
    public void setModeloFamiliar(ModeloFamiliar mFamiliar) {
        this.modeloFamiliar = mFamiliar;
    }
    
    public int getIdHistoriaClinica() {
        return modeloHistoriaClinica.getHistoriaClinica().getIdHistoriaClinica();
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.modeloHistoriaClinica.getHistoriaClinica().setIdHistoriaClinica(idHistoriaClinica);
    }
    
    public String getOtrosAntecedentesPatologicos() {
        return modeloHistoriaClinica.getHistoriaClinica().getOtrosAntecedentesPatologicos();
    }

    public void setOtrosAntecedentesPatologicos(String otrosAntecedentesPatologicos) {
        this.modeloHistoriaClinica.getHistoriaClinica().setOtrosAntecedentesPatologicos(otrosAntecedentesPatologicos);
    }
    
    public ArrayList<Enfermedad> getAntecedentesPatologicos() {
        return modeloHistoriaClinica.getHistoriaClinica().getAntecedentesPatologicos();
    }

    public void setAntecedentesPatologicos(ArrayList<Enfermedad> antecedentesPatologicos) {
        this.modeloHistoriaClinica.getHistoriaClinica().setAntecedentesPatologicos(antecedentesPatologicos);
    }
    
    public String getDni() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getDni();
    }
    
    public void setDni(String dni) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setDni(dni);
    }
    
    public String getNombre() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getNombre();
    }

    public void setNombre(String nombre) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setNombre(nombre);
    }

    public String getApellido() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getApellido();
    }

    public void setApellido(String apellido) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setApellido(apellido);
    }

    public String getSexo() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getSexo();
    }

    public void setSexo(String sexo) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setSexo(sexo);
    }

    public LocalDate getFechaNac() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getFechaNac();
    }

    public void setFechaNac(LocalDate fechaNac) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setFechaNac(fechaNac);
    }

    public String getLugarNac() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getLugarNac();
    }

    public void setLugarNac(String lugarNac) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setLugarNac(lugarNac);
    }

    public String getDistrito() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getDistrito();
    }

    public void setDistrito(String distrito) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setDistrito(distrito);
    }

    public String getDepartamento() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getDepartamento();
    }

    public void setDepartamento(String departamento) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setDepartamento(departamento);
    }

    public String getDireccion() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getDireccion();
    }

    public void setDireccion(String direccion) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setDireccion(direccion);
    }

    public String getTelefono() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getTelefono();
    }

    public void setTelefono(String telefono) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setTelefono(telefono);
    }

    public String getEstadoCivil() {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getEstadoCivil();
    }

    public void setEstadoCivil(String estadoCivil) {
        modeloHistoriaClinica.getHistoriaClinica().getPaciente().setEstadoCivil(estadoCivil);
    }
    
    // Estudiante
    
    public Escuela getEscuela() {
        return ((Alumno)modeloHistoriaClinica.getHistoriaClinica().getPaciente()).getEscuela();
    }

    public void setEscuela(Escuela escuela) {
        ((Alumno)modeloHistoriaClinica.getHistoriaClinica().getPaciente()).setEscuela(escuela);
    }
    
    // Trabajador
    public String getAreaTrabajo() {
        return ((Trabajador)modeloHistoriaClinica.getHistoriaClinica().getPaciente()).getAreaTrabajo();
    }

    public void setAreaTrabajo(String areaTrabajo) {
        ((Trabajador)modeloHistoriaClinica.getHistoriaClinica().getPaciente()).setAreaTrabajo(areaTrabajo);
    }

    public boolean isDocente() {
        return ((Trabajador)modeloHistoriaClinica.getHistoriaClinica().getPaciente()).isDocente();
    }

    public void setDocente(boolean docente) {
        ((Trabajador)modeloHistoriaClinica.getHistoriaClinica().getPaciente()).setDocente(docente);
    }
    
    // Familiar
    
    public String getNombreFamiliar() {
        return modeloFamiliar.getFamiliar().getNombreFamiliar();
    }

    public void setNombreFamiliar(String nombreFamiliar) {
        modeloFamiliar.getFamiliar().setNombreFamiliar(nombreFamiliar);
    }

    public String getParentesco() {
        return modeloFamiliar.getFamiliar().getParentesco();
    }

    public void setParentesco(String parentesco) {
        modeloFamiliar.getFamiliar().setParentesco(parentesco);
    }

    public String getDireccionFamiliar() {
        return modeloFamiliar.getFamiliar().getDireccionFamiliar();
    }

    public void setDireccionFamiliar(String direccionFamiliar) {
        modeloFamiliar.getFamiliar().setDireccionFamiliar(direccionFamiliar);
    }

    public String getTelefonoFamiliar() {
        return modeloFamiliar.getFamiliar().getTelefonoFamiliar();
    }

    public void setTelefonoFamiliar(String telefonoFamiliar) {
        modeloFamiliar.getFamiliar().setTelefonoFamiliar(telefonoFamiliar);
    }

    public String getAntecedentesPatologicosFamiliar() {
        return modeloFamiliar.getFamiliar().getAntecedentesPatologicos();
    }

    public void setAntecedentesPatologicosFamiliar(String antecedentesPatologicos) {
        modeloFamiliar.getFamiliar().setAntecedentesPatologicos(antecedentesPatologicos);
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
        return modeloHistoriaClinica.getHistoriasCoincidentes();
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
        modeloHistoriaClinica.registrarHistoriaClinica();
    }
    
    public void editarHistoriaClinica() {
        modeloHistoriaClinica.editarHistoriaClinica();
    }
    

    public void agregarFamiliar() {
        modeloHistoriaClinica.agregarFamiliar(modeloFamiliar.getFamiliar());
    }
    
    public Familiar getFamiliar(int indice) {
        return modeloHistoriaClinica.getHistoriaClinica().getPaciente().getFamiliares().get(indice);
    }
    
    public void agregarEnfermedad(Enfermedad enfermedad) {
        modeloHistoriaClinica.getHistoriaClinica().agregarAntecedentePatologico(enfermedad);
    }
    
    public void limpiarAntecedentesPatologicos() {
        modeloHistoriaClinica.getHistoriaClinica().getAntecedentesPatologicos().clear();
    }
}
