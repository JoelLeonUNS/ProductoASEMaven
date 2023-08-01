
package BaseDeDatos;

import examenes.Examen;

/**
 *
 * @author USER
 */
public class ExamenDAO {
    
    public void create(Examen examen) {
        BD.getExamenes().put(BD.IdExamen(), examen);
        System.out.println("Examen creado. ");
    }
    
    public Examen read(int id) {
        return BD.getExamenes().get(id);
    }

    public void update(Examen examen, int id) {
        if (BD.getExamenes().containsKey(id)) {
            BD.getExamenes().put(id, examen);
            System.out.println("Examen actualizado. ");
        } else {
            System.out.println("No se puede actualizar el examen. ID no encontrado: " + id);
        }
    }

    public void delete(int id) {
        if (BD.getExamenes().containsKey(id)) {
            Examen examenEliminado = BD.getExamenes().remove(id);
            System.out.println("Examen eliminado. ");
        } else {
            System.out.println("No se puede eliminar el examen. ID no encontrado: " + id);
        }
    }
    
    public int count() { // antes decía cantidadMedicos
        return BD.getExamenes().size();
    }
}
