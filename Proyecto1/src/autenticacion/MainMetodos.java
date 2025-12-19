package autenticacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMetodos {
    public static void main(String[] args) {

        String cedula;
        String nombre;
        String patronRostro;
        String patronHuella;
        String token;
        int lvlSeguridad;
        String tipo;

        int opc = 0;
        Utilitario u = new Utilitario();
        Scanner sc = new Scanner(System.in);

        do {
            try {
                u.menu();
                opc = Integer.parseInt(sc.nextLine());

                if (opc != 1 && opc != 13 && u.getListaEmpleados().isEmpty()) {
                    System.out.println("Error: No hay empleados registrados en el sistema. Registre uno primero.");
                    continue;
                }

                switch (opc) {
                    case 1: {
                        System.out.println("Ingrese la cedula del empledo que deseea agregar: ");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);

                        if (indiceEm == -1) {
                            System.out.println("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            u.agregarEmpleado(cedula, nombre);
                        } else {
                            System.out.println("Empleado ya existe");
                        }
                    }
                    break;
                    case 2: {
                        System.out.println("Ingrese la cedula del empleado al que le quiere añadir el token");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);

                        if (indiceEm != -1) {
                            System.out.println("Ingrese el token: ");
                            token = sc.nextLine();
                            System.out.println("Ingrese el nivel de seguridad de su metodo: ");
                            lvlSeguridad = Integer.parseInt(sc.nextLine());
                            u.agregarAutenticacionToken(cedula, token, lvlSeguridad);
                        } else {
                            System.out.println("No existe Empleado con esa cedula");
                        }
                    }
                    break;
                    case 3: {
                        System.out.println("Ingrese la cedula del empleado al que le quiere añadir el rostro");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);

                        if (indiceEm != -1) {
                            System.out.println("Ingrese el patron del rostro: ");
                            patronRostro = sc.nextLine();
                            System.out.println("Ingrese el nivel de seguridad de su metodo: ");
                            lvlSeguridad = Integer.parseInt(sc.nextLine());
                            u.agregarAutenticacionRostro(cedula, patronRostro, lvlSeguridad);
                        } else {
                            System.out.println("No existe Empleado con esa cedula");
                        }
                    }
                    break;
                    case 4: {
                        System.out.println("Ingrese la cedula del empleado al que le quiere añadir una huella");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);

                        if (indiceEm != -1) {
                            System.out.println("Ingrese el patron de la huella: ");
                            patronHuella = sc.nextLine();
                            System.out.println("Ingrese el nivel de seguridad de su metodo: ");
                            lvlSeguridad = Integer.parseInt(sc.nextLine());
                            u.agregarAutenticacionHuella(cedula, patronHuella, lvlSeguridad);
                        } else {
                            System.out.println("No existe Empleado con esa cedula");
                        }
                    }
                    break;
                    case 5: {
                        System.out.println(u.mostrarDatosEmpleados());
                    }
                    break;
                    case 6: {
                        System.out.println("Ingrese la cedula del empleado que quiere buscar: ");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);

                        if (indiceEm != -1) {
                            System.out.println(u.getListaEmpleados().get(indiceEm).toString());
                        } else {
                            System.out.println("No existe Empleado con esa cedula");
                        }
                    }
                    break;
                    case 7: {
                        System.out.println("Ingrese una cedula para buscar los metodos de autenticacion del empleado: ");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);
                        int total = u.cantidadMetodos(cedula);

                        if (indiceEm != -1) {
                            System.out.println("El empleado " + u.getListaEmpleados().get(indiceEm).getNombre() + " tiene " +
                                    total + " metodos de autenticacion registrados");
                        } else {
                            System.out.println("Empleado no existe.");
                        }
                    }
                    break;
                    case 8: {
                        System.out.println("Ingrese una cedula para buscar la cantidad de huellas del empleado: ");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);
                        int total = u.cantidadAutenticacionHuella(cedula);

                        if (indiceEm != -1) {
                            System.out.println("El empleado " + u.getListaEmpleados().get(indiceEm).getNombre() + " tiene " +
                                    total + " huellas registradas");
                        } else {
                            System.out.println("Empleado no existe.");
                        }
                    }
                    break;
                    case 9: {
                        System.out.println("Ingrese una cedula para buscar la cantidad de tokens del empleado: ");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);
                        int total = u.cantidadAutenticacionToken(cedula);

                        if (indiceEm != -1) {
                            System.out.println("El empleado " + u.getListaEmpleados().get(indiceEm).getNombre() + " tiene " +
                                    total + " tokens registrados");
                        } else {
                            System.out.println("Empleado no existe.");
                        }
                    }
                    break;
                    case 10: {
                        System.out.println("Ingrese una cedula para buscar si el empleado ha registrado o no, un rostro : ");
                        cedula = sc.nextLine();
                        int indiceEm = u.buscarEmpleado(cedula);
                        int total = u.cantidadAutenticacionRostro(cedula);

                        if (indiceEm != -1) {
                            System.out.println("El empleado " + u.getListaEmpleados().get(indiceEm).getNombre() + " tiene " +
                                    total + " rostro/s registrado/s");
                        } else {
                            System.out.println("Empleado no existe.");
                        }
                    }
                    break;
                    case 11: {
                        System.out.println("Ingrese la cédula del empleado:");
                        cedula = sc.nextLine();
                        int indice = u.buscarEmpleado(cedula);

                        if (indice != -1) {
                            System.out.println("Ingrese el nivel de seguridad mínimo (Umbral):");
                            int umbral = Integer.parseInt(sc.nextLine());
                            String resultado = u.autenticacionMayorSeguridad(cedula, umbral);

                            System.out.println("Métodos con seguridad superior a " + umbral + ":");
                            if (resultado.isEmpty()) {
                                System.out.println("   [Ninguno cumple con ese nivel]");
                            } else {
                                System.out.println(resultado);
                            }
                        } else {
                            System.out.println("Error: Empleado no encontrado.");
                        }
                    }
                    break;
                    case 12: {
                        System.out.println("--- SISTEMA DE AUTENTICACIÓN ---");
                        System.out.println("Ingrese la cédula del usuario:");
                        cedula = sc.nextLine();
                        int indice = u.buscarEmpleado(cedula);

                        if (indice != -1) {
                            System.out.println("¿Qué método usará? (Escriba: 'Huella Digital', 'Reconocimiento Facial' o 'Token')");
                            tipo = sc.nextLine();
                            System.out.println("Ingrese el dato (Patrón, Huella o Token):");
                            String dato = sc.nextLine();

                            String respuesta = u.autenticarUtil(tipo, dato, cedula);
                            System.out.println("Resultado: " + respuesta);
                        } else {
                            System.out.println("Error: Esa cédula no está registrada en el sistema.");
                        }
                    }
                    break;
                    case 13: {
                        System.out.println("Saliendo del programa...");
                    }
                    break;
                    default: {
                        System.out.println("Opcion invalida. Por favor ingrese un numero del 1 al 13.");
                    }
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Error: Debe ingresar un numero valido.");
                opc = 0;
            }
        } while (opc != 13);
    }
}