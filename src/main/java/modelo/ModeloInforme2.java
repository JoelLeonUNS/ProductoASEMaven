/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import BaseDeDatos.HistoriaClinicaDAO;
import historias.HistoriaClinica;
import java.util.*;
import pacientes.Alumno;

/**
 *
 * @author ANGIE
 */
public class ModeloInforme2 {

    public ArrayList<Object[]> obtenerDatosInforme() {
        HistoriaClinicaDAO historiaClinicaDAO = new HistoriaClinicaDAO();
        ArrayList<HistoriaClinica> historiasCoincidentes = historiaClinicaDAO.obtenerHistoriasClinicas();

        ArrayList<Object[]> datosInforme = new ArrayList<>();
        int totalAlumnos = 0;
        HashMap<String, Integer> contadorCarreras = new HashMap<>();

        for (HistoriaClinica historiaClinica : historiasCoincidentes) {
            // Verificar si el paciente es un alumno
            if (historiaClinica.getPaciente() instanceof Alumno) {
                Alumno alumno = (Alumno) historiaClinica.getPaciente();

                String carrera = alumno.getEscuela().getNombre();
                String sexo = alumno.getSexo();

                contadorCarreras.put(carrera, contadorCarreras.getOrDefault(carrera, 0) + 1);

                // Incrementar el total de alumnos
                totalAlumnos++;
            }
        }

        for (String carrera : contadorCarreras.keySet()) {
            int cantidad = contadorCarreras.get(carrera);
            double porcentaje = (cantidad / (double) totalAlumnos) * 100;

            Object[] rowData = {
                carrera,
                "Alumno",
                cantidad,
                String.format("%.2f%%", porcentaje)
            };
            datosInforme.add(rowData);
        }

        return datosInforme;
    }
}
