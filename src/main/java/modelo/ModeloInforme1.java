/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import BaseDeDatos.HistoriaClinicaDAO;
import consultas.ConsultaMedica;
import examenes.Examen;
import examenesMedico.ExamenMedico;
import historias.HistoriaClinica;
import java.util.*;

/**
 *
 * @author ANGIE
 */
public class ModeloInforme1 {
    private ArrayList<HistoriaClinica> historiasClinicas;
    
    public ModeloInforme1() {
        cargarDatos();
    }
    
    public void cargarDatos() {
        // Lógica para obtener los datos de la base de datos u otra fuente de datos
        HistoriaClinicaDAO historiaClinicaDAO = new HistoriaClinicaDAO();
        historiasClinicas = historiaClinicaDAO.obtenerHistoriasClinicas();
    }
    
    public ArrayList<Object[]> obtenerDatosInforme() {
        ArrayList<Object[]> datosInforme = new ArrayList<>();
        
        for (HistoriaClinica historiaClinica : historiasClinicas) {
            for (ConsultaMedica consultaMedica : historiaClinica.getConsultasMedicas()) {
                for (Examen examen : consultaMedica.getExamenes()) {
                    if (examen instanceof ExamenMedico) {
                        ExamenMedico examenMedico = (ExamenMedico) examen;
                        Object[] rowData = {
                            historiaClinica.getPaciente().getNombre(),
                            historiaClinica.getPaciente().calcularEdad(),
                            historiaClinica.getPaciente().getSexo(),
                            examenMedico.getDiagnostico()
                        };
                        datosInforme.add(rowData);
                    }
                }
            }
        }
        
        return datosInforme;
    }
}
