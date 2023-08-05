package pacientes;

import java.time.LocalDate;
import modelo.Escuela;

public class Alumno extends Paciente {

    private Escuela escuela;

    
    
    // Solo para valores por defecto.
    public Alumno(Escuela escuela, String dni, String nombre, String apellido, String sexo, LocalDate fechaNac, String lugarNac, String distrito, String departamento, String direccion, String telefono, String estadoCivil) {
        super(dni, nombre, apellido, sexo, fechaNac, lugarNac, distrito, departamento, direccion, telefono, estadoCivil);
        this.escuela = escuela;
        super.tipoPaciente = "ESTUDIANTE";
    }

    public Alumno() {
        super.tipoPaciente = "ESTUDIANTE";
    }
    
    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nEscuela: " + escuela;
    }
}
