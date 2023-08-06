package valoresPorDefecto;

import BaseDeDatos.ConsultaDAO;
import BaseDeDatos.ExamenDAO;
import BaseDeDatos.HistoriaClinicaDAO;
import BaseDeDatos.MedicoDAO;
import consultas.ConsultaMedica;

/**
 *
 * @author ANGIE
 */
public class ConsultasPorDefecto {

    public static void poblar() {
        MedicoDAO mDAO = new MedicoDAO();
        ConsultaDAO cDAO = new ConsultaDAO();
        HistoriaClinicaDAO hDAO = new HistoriaClinicaDAO();
        ExamenDAO eDAO = new ExamenDAO();

//        ConsultaMedica consulta1 = new ConsultaMedica("01/01/2023", "10:00", 20, "Consulta de rutina", 0, "Normal", "Normal", "Normal", "Bueno", mDAO.read(1));
//        ConsultaMedica consulta2 = new ConsultaMedica("02/01/2023", "11:00", 21, "Dolor de cabeza", 2, "Normal", "Normal", "Normal", "Regular", mDAO.read(2));
//        ConsultaMedica consulta3 = new ConsultaMedica("03/01/2023", "09:30", 22, "Fiebre alta", 5, "Disminuido", "Normal", "Normal", "Mal", mDAO.read(0));
//        ConsultaMedica consulta4 = new ConsultaMedica("04/01/2023", "14:15", 18, "Consulta de seguimiento", 1, "Normal", "Normal", "Normal", "Bueno", mDAO.read(1));
//        ConsultaMedica consulta5 = new ConsultaMedica("05/01/2023", "16:45", 20, "Dolor abdominal", 3, "Normal", "Disminuido", "Normal", "Regular", mDAO.read(2));
//        ConsultaMedica consulta6 = new ConsultaMedica("06/01/2023", "08:30", 17, "Examen de rutina", 0, "Normal", "Normal", "Normal", "Bueno", mDAO.read(0));
//        ConsultaMedica consulta7 = new ConsultaMedica("07/01/2023", "13:30", 23, "Dolor en las articulaciones", 4, "Normal", "Normal", "Normal", "Regular", mDAO.read(2));
//        ConsultaMedica consulta8 = new ConsultaMedica("08/01/2023", "10:45", 19, "Dolor de garganta", 2, "Disminuido", "Normal", "Normal", "Mal", mDAO.read(1));
//        ConsultaMedica consulta9 = new ConsultaMedica("09/01/2023", "15:20", 18, "Consulta de rutina", 0, "Normal", "Normal", "Normal", "Bueno", mDAO.read(0));
//        ConsultaMedica consulta10 = new ConsultaMedica("10/01/2023", "11:30", 24, "Presión arterial alta", 1, "Normal", "Normal", "Normal", "Regular", mDAO.read(0));
//        ConsultaMedica consulta11 = new ConsultaMedica("15/11/2023", "09:00", 25, "Dolor de espalda", 3, "Disminuido", "Normal", "Normal", "Regular", mDAO.read(1));
//        ConsultaMedica consulta12 = new ConsultaMedica("20/12/2023", "14:30", 22, "Mareos frecuentes", 2, "Normal", "Normal", "Normal", "Bueno", mDAO.read(2));
//        ConsultaMedica consulta13 = new ConsultaMedica("25/01/2023", "11:45", 19, "Problemas digestivos", 4, "Normal", "Normal", "Normal", "Regular", mDAO.read(0));
//        ConsultaMedica consulta14 = new ConsultaMedica("02/02/2023", "16:15", 21, "Dolor en los ojos", 1, "Normal", "Disminuido", "Normal", "Mal", mDAO.read(1));
//        ConsultaMedica consulta15 = new ConsultaMedica("10/03/2023", "08:30", 27, "Dificultad para respirar", 5, "Disminuido", "Normal", "Normal", "Bueno", mDAO.read(0));
//        ConsultaMedica consulta16 = new ConsultaMedica("18/04/2023", "12:30", 24, "Picazón en la piel", 3, "Normal", "Normal", "Normal", "Regular", mDAO.read(2));
//        ConsultaMedica consulta17 = new ConsultaMedica("25/05/2023", "15:45", 26, "Molestias estomacales", 2, "Normal", "Normal", "Normal", "Bueno", mDAO.read(1));
//        ConsultaMedica consulta18 = new ConsultaMedica("03/06/2023", "10:30", 23, "Fatiga crónica", 4, "Disminuido", "Normal", "Normal", "Mal", mDAO.read(2));
//        ConsultaMedica consulta19 = new ConsultaMedica("11/07/2023", "14:00", 20, "Dolor de articulaciones", 1, "Normal", "Disminuido", "Normal", "Regular", mDAO.read(0));
//        ConsultaMedica consulta20 = new ConsultaMedica("19/08/2023", "11:15", 28, "Dolor de pecho", 5, "Disminuido", "Normal", "Normal", "Bueno", mDAO.read(2));
//
//        consulta1.agregarExamen(eDAO.read(0));
//        consulta2.agregarExamen(eDAO.read(1));
//        consulta3.agregarExamen(eDAO.read(2));
//        consulta4.agregarExamen(eDAO.read(3));
//        consulta5.agregarExamen(eDAO.read(4));
//        consulta6.agregarExamen(eDAO.read(5));
//        consulta7.agregarExamen(eDAO.read(6));
//        consulta8.agregarExamen(eDAO.read(7));
//        consulta9.agregarExamen(eDAO.read(8));
//        consulta10.agregarExamen(eDAO.read(9));
//        consulta11.agregarExamen(eDAO.read(10));
//        consulta12.agregarExamen(eDAO.read(11));
//        consulta13.agregarExamen(eDAO.read(12));
//        consulta14.agregarExamen(eDAO.read(13));
//        consulta15.agregarExamen(eDAO.read(14));
//        consulta16.agregarExamen(eDAO.read(15));
//        consulta17.agregarExamen(eDAO.read(16));
//        consulta18.agregarExamen(eDAO.read(17));
//        consulta19.agregarExamen(eDAO.read(18));
//        consulta20.agregarExamen(eDAO.read(19)); 
//        //CREAR CONSULTAS
//        cDAO.create(consulta1);
//        cDAO.create(consulta2);
//        cDAO.create(consulta3);
//        cDAO.create(consulta4);
//        cDAO.create(consulta5);
//        cDAO.create(consulta6);
//        cDAO.create(consulta7);
//        cDAO.create(consulta8);
//        cDAO.create(consulta9);
//        cDAO.create(consulta10);
//        cDAO.create(consulta11);
//        cDAO.create(consulta12);
//        cDAO.create(consulta13);
//        cDAO.create(consulta14);
//        cDAO.create(consulta15);
//        cDAO.create(consulta16);
//        cDAO.create(consulta17);
//        cDAO.create(consulta18);
//        cDAO.create(consulta19);
//        cDAO.create(consulta20);

    }
}
