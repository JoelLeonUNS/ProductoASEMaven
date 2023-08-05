package pacientes;

import java.time.LocalDate;

public class Trabajador extends Paciente {

    private String areaTrabajo;
    private boolean docente;
    
    // Solo para valores por defecto.

    public Trabajador(String areaTrabajo, boolean docente, String dni, String nombre, String apellido, String sexo, LocalDate fechaNac, String lugarNac, String distrito, String departamento, String direccion, String telefono, String estadoCivil) {
        super(dni, nombre, apellido, sexo, fechaNac, lugarNac, distrito, departamento, direccion, telefono, estadoCivil);
        this.areaTrabajo = areaTrabajo;
        this.docente = docente;
        super.tipoPaciente = "TRABAJADOR";
    }
    
    public Trabajador() {
        super.tipoPaciente = "TRABAJADOR";
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public boolean isDocente() {
        return docente;
    }

    public void setDocente(boolean docente) {
        this.docente = docente;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nArea de Trabajo: " + areaTrabajo + "\nDocente: " + docente;
    }
}
