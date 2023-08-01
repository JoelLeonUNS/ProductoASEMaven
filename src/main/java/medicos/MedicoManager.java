package medicos;

import BaseDeDatos.BD;
import java.util.Scanner;

public class MedicoManager {

    Scanner scanner = new Scanner(System.in);

//    public Medico buscar(String usuario, String clave) {
//        Medico medicoEncontrado = BD.consultarMedico(usuario, clave);
//
//        if (medicoEncontrado != null) {
//            System.out.println("\nMedico encontrado:");
//            System.out.println("Nombre: " + medicoEncontrado.getNombreMedico());
//            System.out.println("Apellido: " + medicoEncontrado.getApellidoMedico());
//            System.out.println("Telefono: " + medicoEncontrado.getTelefonoMedico());
//            System.out.println("DNI: " + medicoEncontrado.getDNI());
//        } else {
//            System.out.println("Medico no encontrado.");
//        }
//        return medicoEncontrado;
//    }
//
//    public Medico registrar() {
//        Medico nuevoMedico = new Medico();
//        nuevoMedico.setEstado(true);
//        setDatosMedico(nuevoMedico);
//        BD.insertMedico(nuevoMedico);
//        return nuevoMedico;
//
//    }
//
//    private void setDatosMedico(Medico medico) {
//        System.out.print("Usuario: ");
//        medico.setUsuario(scanner.next());
//        System.out.print("Clave: ");
//        medico.setClave(scanner.next());
//        System.out.print("Nombre: ");
//        scanner.next();
//        medico.setNombreMedico(scanner.nextLine());
//        System.out.print("Apellido: ");
//        medico.setApellidoMedico(scanner.nextLine());
//        System.out.print("Telefono: ");
//        medico.setTelefonoMedico(scanner.nextLine());
//        System.out.print("DNI: ");
//        medico.setDNI(scanner.nextLine());
//    }
//
//    public void editar(Medico medico) {
//        int opcion = opcionesEditar();
//
//        switch (opcion) {
//            case 1 -> {
//                System.out.print("Nuevo usuario: ");
//                medico.setUsuario(scanner.nextLine());
//            }
//            case 2 -> {
//                System.out.print("Nueva clave: ");
//                medico.setClave(scanner.nextLine());
//            }
//            case 3 -> {
//                System.out.print("Nuevo nombre: ");
//                medico.setNombreMedico(scanner.nextLine());
//            }
//            case 4 -> {
//                System.out.print("Nuevo apellido: ");
//                medico.setApellidoMedico(scanner.nextLine());
//            }
//            case 5 -> {
//                System.out.print("Nuevo telefono: ");
//                medico.setTelefonoMedico(scanner.nextLine());
//            }
//            case 6 -> {
//                System.out.print("Nuevo DNI: ");
//                medico.setDNI(scanner.nextLine());
//            }
//            default -> {
//                System.out.println("Opcion invalida.");
//                return;
//            }
//        }
//
//        System.out.println("Atributo editado correctamente.");
//    }
//
//    public void darDeBaja(Medico medico) {
//        medico.setEstado(false);
//        System.out.println("Medico dado de baja con exito");
//    }
//
//    private int opcionesEditar() {
//        System.out.println("Selecciona el atributo a editar:");
//        System.out.println("1. Usuario");
//        System.out.println("2. Clave");
//        System.out.println("3. Nombre");
//        System.out.println("4. Apellido");
//        System.out.println("5. Telefono");
//        System.out.println("6. DNI");
//        return scanner.nextInt();
//    }
}
