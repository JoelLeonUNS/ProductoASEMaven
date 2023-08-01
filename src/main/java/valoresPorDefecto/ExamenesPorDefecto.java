/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package valoresPorDefecto;

import BaseDeDatos.ExamenDAO;
import examenesClinico.ExamenClinico;
import examenesFisico.ExamenFisico;
import examenesMedico.ExamenMedico;

/**
 *
 * @author ANGIE
 */
public class ExamenesPorDefecto {

    public static void poblar() {
        ExamenDAO eDAO = new ExamenDAO();

        ExamenClinico examen1 = new ExamenClinico(true, false);
        ExamenClinico examen2 = new ExamenClinico(false, true);
        ExamenClinico examen3 = new ExamenClinico(true, true);
        ExamenClinico examen4 = new ExamenClinico(false, false);
        ExamenFisico examen5 = new ExamenFisico(36.5, "120/80", 16, 98, 70, 170, 18.6, 80, 96);
        ExamenFisico examen6 = new ExamenFisico(37.2, "110/70", 18, 99, 72, 175, 18.9, 78, 83);
        ExamenFisico examen7 = new ExamenFisico(38.5, "130/85", 14, 97, 68, 168, 23.9, 75, 81);
        ExamenFisico examen8 = new ExamenFisico(35.4, "130/85", 17, 97, 65, 178, 22.5, 84, 97);
        ExamenFisico examen9 = new ExamenFisico(39.2, "130/85", 16, 97, 70, 163, 24.9, 76, 82);
        ExamenFisico examen10 = new ExamenFisico(36.8, "130/85", 14, 97, 68, 168, 25.6, 85, 100);
        ExamenMedico examen11 = new ExamenMedico("Gripe común", "Reposo y líquidos", "Hemograma completo, PCR");
        ExamenMedico examen12 = new ExamenMedico("Dolor abdominal", "Antiespasmódicos y dieta blanda", "Ecografía abdominal, Hemograma");
        ExamenMedico examen13 = new ExamenMedico("Hipertensión arterial", "Medicación antihipertensiva y cambios en el estilo de vida", "Electrocardiograma, Perfil lipídico");
        ExamenMedico examen14 = new ExamenMedico("Bronquitis aguda", "Inhaladores broncodilatadores y reposo", "Radiografía de tórax, Espirometría");
        ExamenMedico examen15 = new ExamenMedico("Estrés crónico", "Terapia psicológica y técnicas de relajación", "Perfil hormonal, Evaluación psicológica");
        ExamenMedico examen16 = new ExamenMedico("Dolor de espalda", "Fisioterapia y ejercicios de fortalecimiento", "Radiografía de columna, Resonancia magnética");
        ExamenMedico examen17 = new ExamenMedico("Trastornos del sueño", "Higiene del sueño y cambios en el estilo de vida", "Polisomnografía, Prueba de latencia múltiple del sueño");
        ExamenMedico examen18 = new ExamenMedico("Alergia respiratoria", "Antihistamínicos y evitar alérgenos", "Pruebas cutáneas de alergia, Conteo de eosinófilos");
        ExamenMedico examen19 = new ExamenMedico("Dermatitis atópica", "Hidratantes y corticosteroides tópicos", "Prueba de parche, Prueba de IgE específica");
        ExamenMedico examen20 = new ExamenMedico("Dolor de cabeza crónico", "Analgesia y cambios en el estilo de vida", "Resonancia magnética cerebral, Electroencefalograma");
        
        eDAO.create(examen1);
        eDAO.create(examen2);
        eDAO.create(examen3);
        eDAO.create(examen4);
        eDAO.create(examen5);
        eDAO.create(examen6);
        eDAO.create(examen7);
        eDAO.create(examen8);
        eDAO.create(examen9);
        eDAO.create(examen10);
        eDAO.create(examen11);
        eDAO.create(examen12);
        eDAO.create(examen13);
        eDAO.create(examen14);
        eDAO.create(examen15);
        eDAO.create(examen16);
        eDAO.create(examen17);
        eDAO.create(examen18);
        eDAO.create(examen19);
        eDAO.create(examen20);

    }
}
