/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import consultas.ConsultaMedica;
import examenes.Examen;
import examenesMedico.ExamenMedico;
import historias.HistoriaClinica;
import java.util.*;
import pacientes.Paciente;
import sqlServerDAO.SqlServerHistoriaClinicaDAO;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ANGIE
 */
public class ModeloInforme {

    private SqlServerHistoriaClinicaDAO historiaClinicaDAO;

    public ModeloInforme() {
        this.historiaClinicaDAO = new SqlServerHistoriaClinicaDAO();
    }

    public List<Object[]> obtenerInformes() {
        List<Object[]> listaInformes = new ArrayList<>();
        try {
            List<HistoriaClinica> listaHistoriasClinicas = historiaClinicaDAO.listed();

            for (HistoriaClinica historiaClinica : listaHistoriasClinicas) {
                List<ConsultaMedica> consultas = historiaClinica.getConsultasMedicas();

                for (ConsultaMedica consulta : consultas) {
                    List<Examen> examenes = consulta.getExamenes();
                    for (Examen examen : examenes) {
                        if (examen instanceof ExamenMedico) {
                            ExamenMedico examenMedico = (ExamenMedico) examen;

                            // Obtener los datos del paciente relacionado con la historia clínica
                            Paciente paciente = historiaClinica.getPaciente();
                            String apellidoNombres = paciente.getApellido() + ", " + paciente.getNombre();
                            int edad = consulta.getEdad();
                            char genero = paciente.getSexo().charAt(0);
                            LocalDate localDate = consulta.getFecha();
                            Date fechaConsulta = Date.valueOf(localDate);

                            // Agregar los datos del informe al array
                            Object[] informe = new Object[5];
                            informe[0] = fechaConsulta;
                            informe[1] = examenMedico.getDiagnostico();
                            informe[2] = apellidoNombres;
                            informe[3] = edad;
                            informe[4] = genero;

                            listaInformes.add(informe);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listaInformes;
    }

}
