package BaseDeDatos;

import historias.HistoriaClinica;
import java.util.ArrayList;

/**
 *
 * @author ANGIE
 */
public class HistoriaClinicaDAO {

    public void create(HistoriaClinica historiaClinica) {
        BD.getHistoria().put(BD.IdHistoriaClinica(), historiaClinica);
        System.out.println("Historia clínica creada.");
    }

    public HistoriaClinica read(int id) {
        return BD.getHistoria().get(id);
    }

    public void update(HistoriaClinica historiaClinica, int id) {
        if (BD.getHistoria().containsKey(id)) {
            BD.getHistoria().put(id, historiaClinica);
            System.out.println("Historia clínica actualizada.");
        } else {
            System.out.println("No se puede actualizar la historia clínica. ID no encontrado: " + id);
        }
    }

    public void delete(int id) {
        if (BD.getHistoria().containsKey(id)) {
            HistoriaClinica historiaClinicaEliminada = BD.getHistoria().remove(id);
            System.out.println("Historia clínica eliminada.");
        } else {
            System.out.println("No se puede eliminar la historia clínica. ID no encontrado: " + id);
        }
    }

    public int count() {
        return BD.getHistoria().size();
    }

    public ArrayList<HistoriaClinica> obtenerHistoriasClinicas() {
        ArrayList<HistoriaClinica> historiasClinicas = new ArrayList<>();

        for (HistoriaClinica historiaClinica : BD.getHistoria().values()) {
            historiasClinicas.add(historiaClinica);
        }

        return historiasClinicas;
    }

}
