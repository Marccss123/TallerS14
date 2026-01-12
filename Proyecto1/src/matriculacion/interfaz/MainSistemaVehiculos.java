package matriculacion.interfaz;



import matriculacion.excepciones.PropietarioNoEncontradoException;
import matriculacion.excepciones.PropietarioYaExisteException;
import matriculacion.util.Utilitario;
import matriculacion.negocio.Propietario;
import matriculacion.negocio.Vehiculo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainSistemaVehiculos {
    public static void main(String[] args) {
        Utilitario u = new Utilitario();
        Scanner sc = new Scanner(System.in);

        String marca, modelo;
        int anio;
        String traccion;
        String tipo;

        //Propietario
        String cedula, nombre, telefono;

        //Moto
        double altura;
        String arranque;

        int opc;

        do {
            try {
                u.menu();
                opc = Integer.parseInt(sc.nextLine());
                switch (opc) {
                    case 1: {
                        try {
                            System.out.println("Ingrese cedula: ");
                            cedula = sc.nextLine();
                            System.out.println("Ingrese su nombre: ");
                            nombre = sc.nextLine();
                            System.out.println("Ingrese su telefono: ");
                            telefono = sc.nextLine();

                            u.agregarPropietario(cedula, nombre, telefono);
                            System.out.println("¡Propietario agregado exitosamente!");
                        }catch (PropietarioYaExisteException e){
                            System.out.println("Error: " + e.getMessage());
                        }
                    }break;
                    case 2: {
                        System.out.println("Escriba la cedula del propietario al que le va a asignar un Auto: ");
                        cedula = sc.nextLine();

                        try {
                            Propietario p = u.buscarPropietario(cedula);

                            if (p == null) {
                                throw new PropietarioNoEncontradoException("El propietario con cédula " + cedula + " no existe.");
                            }
                                System.out.println("Ingrese marca: ");
                                marca = sc.nextLine();
                                System.out.println("Ingree modelo: ");
                                modelo = sc.nextLine();
                                System.out.println("Ingrese Tipo: ");
                                tipo = sc.nextLine();
                                System.out.println("Ingrese traccion: ");
                                traccion = sc.nextLine();
                                System.out.println("Ingrese anio: ");
                                anio = Integer.parseInt(sc.nextLine());

                                u.agregarAuto(marca, modelo, anio, p, traccion, tipo);
                        }catch (PropietarioNoEncontradoException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                    case 3: {
                        System.out.println("Escriba la cedula del propietario al que le va a asignar una moto: ");
                        cedula = sc.nextLine();

                        try {
                            Propietario p = u.buscarPropietario(cedula);

                            if (p == null) {
                                throw new PropietarioNoEncontradoException("El propietario con cédula " + cedula + " no existe.");
                            }
                            System.out.println("Ingrese marca: ");
                            marca = sc.nextLine();
                            System.out.println("Ingrese modelo: ");
                            modelo = sc.nextLine();
                            System.out.println("Ingrese año: ");
                            anio = Integer.parseInt(sc.nextLine());
                            System.out.println("Ingrese altura: ");
                            altura = Double.parseDouble(sc.nextLine());
                            System.out.println("Ingrese arranque: ");
                            arranque = sc.nextLine();

                            u.agregarMoto(marca, modelo, anio, p, altura, arranque);
                        }catch (PropietarioNoEncontradoException e){
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                    case 4: {
                        System.out.println("Ingrese la marca de vehiculos que quiere buscar: ");
                        marca = sc.nextLine();
                        List<Vehiculo> lista = u.buscarVehiciuloMarca(marca);
                        System.out.println(lista);
                    }
                    break;
                    case 5: {
                        System.out.println(u.listarVehiculos());
                    }
                    break;
                    case 6: {
                        System.out.println(u.listaPropietarios());
                    }
                    break;
                    case 7: {
                        System.out.println(u.listarAutomoviles());
                    }
                    break;
                    case 8: {
                        System.out.print("Ingrese la marca de moto a buscar: ");
                        marca = sc.nextLine();
                        System.out.println(u.listarNombreAnioArranqueMotoXMarca(marca));
                    }
                    break;
                    case 9: {
                        System.out.println("Escriba la cedula: ");
                        cedula = sc.nextLine();
                        System.out.println("Marca: ");
                        marca = sc.nextLine();
                        System.out.println("Año: ");
                        anio = Integer.parseInt(sc.nextLine());

                        int valor = u.matricular(cedula, marca, anio);
                        if (valor != -1) {
                            System.out.println("Valor " + valor + "\nMatriculado");
                        } else {
                            System.out.println("Se ha producido un error");
                        }
                    }
                    break;
                    case 10: {
                        System.out.println("Saliendo del sistema...");
                    }
                    break;
                    default: {
                        System.out.println("Opcion Invalida. Ingrese Nuevamente");
                    }
                }
            }catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido. Intenta de nuevo.");
                opc = 0;
            }
        } while (opc!=10);
    }
}
