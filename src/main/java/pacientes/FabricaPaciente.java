
package pacientes;

public class FabricaPaciente {
    
    public static Paciente crearPaciente (String tipo) throws Exception{
        Paciente paciente = null;
        switch(tipo){
            case "ALUMNO" -> {
                paciente = new Alumno();
            }
            case "TRABAJADOR" -> {
                paciente = new Trabajador();
            }
        }
        return paciente;
    }
}
