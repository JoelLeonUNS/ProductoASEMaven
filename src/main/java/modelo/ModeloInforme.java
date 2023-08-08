/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import consultas.ConsultaMedica;
import examenes.Examen;
import examenesMedico.ExamenMedico;
import factoryDAO.DAOFactory;
import factoryDAO.SqlServerDAOFactory;
import historias.HistoriaClinica;
import java.util.*;
import pacientes.Paciente;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ANGIE
 */
public class ModeloInforme {

    private  DAOFactory dao;
    private ModeloConsulta mConsulta;

    public ModeloInforme() {
        this.dao = new SqlServerDAOFactory();
        this.mConsulta = new ModeloConsulta();
    }



public List<Object[]> obtenerInforme1() {
    List<Object[]> datosInforme1 = new ArrayList<>();

    for (HistoriaClinica historia : (List<HistoriaClinica>) dao.getHistoriaClinica().listed()) {
        int idPaciente = historia.getPaciente().getIdPaciente();
        Paciente paciente = (Paciente) dao.getPaciente().read(idPaciente);
        List<ConsultaMedica> consultas = mConsulta.obtenerConsultas(idPaciente);
        
        for (ConsultaMedica consulta : consultas) {
            List<ExamenMedico> examenes = (List<ExamenMedico>)dao.getExamenMedico().listed();
            for (Examen examen : examenes) {
                if (examen instanceof ExamenMedico) {
                    ExamenMedico examenMedico = (ExamenMedico) examen;

                if (examenMedico.getIdConsulta() == consulta.getIdConsulta()) {
                    // Obtener los datos que deseas para cada paciente y su consulta/examen
                    Object[] datos = new Object[6]; // Puedes ajustar el tamaño según la cantidad de datos que quieras obtener

                    datos[0] = consulta.getFecha();
                    datos[1] = paciente.getApellido() + " " + paciente.getNombre();
                    datos[2] = consulta.getEdad();
                    datos[3] = paciente.getSexo();
                    datos[4] = examenMedico.getDiagnostico();
                    
                    datosInforme1.add(datos);
                }
                }
            }
        }
    }

    return datosInforme1;
}


}
