package pacientes;

public class Alumno extends Paciente {

    private String escuela;

    
    
    // Solo para valores por defecto.
    public Alumno(String escuela, String DNI, String nombre, String apellido, String sexo, String fechaNac, String lugarNac, String distrito, String departamento, String direccion, String telefono, String estadoCivil) {
        super(DNI, nombre, apellido, sexo, fechaNac, lugarNac, distrito, departamento, direccion, telefono, estadoCivil);
        this.escuela = escuela;
        super.tipoPaciente = "ESTUDIANTE";
    }

    public Alumno() {
        super.tipoPaciente = "ESTUDIANTE";
    }
    
    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nEscuela: " + escuela;
    }
}
