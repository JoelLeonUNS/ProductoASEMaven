
package BaseDeDatos;

import medicos.Medico;

public class MedicoDAO {
    
    public void create(Medico medico) {
        BD.getMedicos().put(BD.IdMedico(), medico);
        System.out.println("Medico creado: " + medico.getApellidoMedico()+ " | " + medico.getNombreMedico());
    }
    
    public Medico read(int id) {
        return BD.getMedicos().get(id);
    }

    public void update(Medico medico, int id) {
        if (BD.getMedicos().containsKey(id)) {
            BD.getMedicos().put(id, medico);
            System.out.println("Medico actualizado: " + medico.getApellidoMedico()+" "+medico.getNombreMedico());
        } else {
            System.out.println("No se puede actualizar el médico. ID no encontrado: " + id);
        }
    }

    public void delete(int id) {
        if (BD.getMedicos().containsKey(id)) {
            Medico medicoEliminado = BD.getMedicos().remove(id);
            System.out.println("Médico eliminado: " + medicoEliminado.getApellidoMedico()+" "+medicoEliminado.getNombreMedico());
        } else {
            System.out.println("No se puede eliminar el médico. ID no encontrado: " + id);
        }
    }
    
    public int count() { // antes decía cantidadMedicos
        return BD.getMedicos().size();
    }
}
