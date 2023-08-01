/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDeDatos;

import consultas.ConsultaMedica;

/**
 *
 * @author ANGIE
 */
public class ConsultaDAO {
    
    public void create(ConsultaMedica consulta) {
        BD.getConsulta().put(BD.IdConsulta(), consulta);
        System.out.println("Consulta creada.");
    }
    
    public ConsultaMedica read(int id) {
        return BD.getConsulta().get(id);
    }

    public void update(ConsultaMedica consulta, int id) {
        if (BD.getConsulta().containsKey(id)) {
            BD.getConsulta().put(id, consulta);
            System.out.println("Consulta actualizada.");
        } else {
            System.out.println("No se puede actualizar la consulta. ID no encontrado: " + id);
        }
    }

    public void delete(int id) {
        if (BD.getConsulta().containsKey(id)) {
            ConsultaMedica consultaEliminada = BD.getConsulta().remove(id);
            System.out.println("Consulta eliminada.");
        } else {
            System.out.println("No se puede eliminar la consulta. ID no encontrado: " + id);
        }
    }
    
    public int count() {
        return BD.getConsulta().size();
    }
}
