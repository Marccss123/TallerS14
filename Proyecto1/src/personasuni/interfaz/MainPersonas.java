package personasuni.interfaz;

import personasuni.excepciones.CedulaDuplicadaException;
import personasuni.util.Utilitario;
import java.util.Scanner;

public class MainPersonas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utilitario u = new Utilitario();

        int opc = 0;
        String nom, universidad, carrera, cedula, tesis, especialidad;
        int horas;

        do {
            try {
                u.menu();
                opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1:
                        u.listarTodos();
                        break;
                    case 2:
                        System.out.print("Nombre: "); nom = sc.nextLine();
                        System.out.print("Cédula: "); cedula = sc.nextLine();
                        System.out.print("Universidad: "); universidad = sc.nextLine();
                        System.out.print("Carrera: "); carrera = sc.nextLine();

                        try {
                            u.agregarAlumnoPregrado(nom, cedula, universidad, carrera);
                        } catch (CedulaDuplicadaException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Nombre: "); nom = sc.nextLine();
                        System.out.print("Cédula: "); cedula = sc.nextLine();
                        System.out.print("Universidad: "); universidad = sc.nextLine();
                        System.out.print("Tesis: "); tesis = sc.nextLine();

                        try {
                            u.agregarAlumnoMagister(nom, cedula, universidad, tesis);
                        } catch (CedulaDuplicadaException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Nombre: "); nom = sc.nextLine();
                        System.out.print("Cédula: "); cedula = sc.nextLine();
                        System.out.print("Especialidad: "); especialidad = sc.nextLine();

                        try {
                            System.out.print("Horas: "); horas = Integer.parseInt(sc.nextLine());
                            u.agregarProfesorHora(nom, cedula, especialidad, horas);
                        } catch (CedulaDuplicadaException e) {
                            System.out.println("Error: " + e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Las horas deben ser un número.");
                        }
                        break;
                    case 5: u.listarAlumnosPregrado(); break;
                    case 6: u.listarAlumnosMagister(); break;
                    case 7: u.listarProfesores(); break;
                    case 8: System.out.println("Saliendo..."); break;
                    default: System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un dato válido.");
                opc = 0;
            }
        } while (opc != 8);
    }
}