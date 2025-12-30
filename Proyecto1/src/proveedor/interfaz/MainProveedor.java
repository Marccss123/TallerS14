package proveedor.interfaz;

import proveedor.principales.ClienteEmpresa;
import proveedor.principales.Proveedor;
import proveedor.utilitario.Utilitario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainProveedor {
    public static void main(String[] args) {
        //Contrato-Atributos
        double precio;
        int duracionEnMeses;

        //Proveedor-Atributos
        String nombreProveedor;
        String pais;
        int tipo;

        //Cliente-Atributos
        String nombreCliente;

        //Menu
        int opc;
        Scanner sc = new Scanner(System.in);
        Utilitario u = new Utilitario();
        List<Proveedor> catalogoProveedores = new ArrayList<>();

        do {
            try {
                u.menu();
                opc = Integer.parseInt(sc.nextLine());

                switch (opc) {
                    case 1: {
                        System.out.println("----CREAR PROVEEDOR----");
                        System.out.print("Ingrese el nombre del Proveedor: ");
                        nombreProveedor = sc.nextLine();
                        System.out.print("Ingrese el país del proveedor: ");
                        pais = sc.nextLine();
                        System.out.print("Ingrese el tipo del proveedor (1.Cloud , 2.SaaS , 3.Pasarelas Pago): ");
                        tipo = Integer.parseInt(sc.nextLine());

                        //Crear Proveedor
                        Proveedor nuevoProveedor = u.crearProveedor(nombreProveedor, pais, tipo);

                        //Añadimos el proveedor a una lista general (catálogo)
                        if (nuevoProveedor != null) {
                            catalogoProveedores.add(nuevoProveedor);
                            System.out.println("Éxito: Se ha creado un " + nuevoProveedor.tipoProveedor());
                        }
                    }
                    break;

                    case 2: {
                        System.out.println("----CREAR NUEVO CLIENTE----");
                        System.out.print("Escriba un nombre para el nuevo cliente: ");
                        nombreCliente = sc.nextLine();

                        //Crear cliente
                        u.crearCliente(nombreCliente);
                    }
                    break;

                    case 3: {
                        if (u.getListaClientesEmpresas().isEmpty()) {
                            System.out.println("Error: No hay clientes en el sistema. Cree uno primero.");
                            break;
                        }

                        System.out.println("----ASOCIAR PROVEEDOR A CLIENTE----");
                        ClienteEmpresa clienteSeleccionado = null;

                        //Buscamos cliente con validacion
                        while (clienteSeleccionado == null) {
                            System.out.print("Escriba el nombre del cliente que desea asociar (o 'salir'): ");
                            nombreCliente = sc.nextLine();
                            if (nombreCliente.equalsIgnoreCase("salir")) break;

                            clienteSeleccionado = u.buscarCliente(nombreCliente);
                            if (clienteSeleccionado == null) {
                                System.out.println("Cliente no encontrado. Intente de nuevo.");
                            }
                        }

                        if (clienteSeleccionado != null) {
                            Proveedor proveedorSeleccionado = null;
                            //Buscamos proveedor con validacion
                            while (proveedorSeleccionado == null) {
                                System.out.print("Escribe el nombre del proveedor para asociar (o 'salir'): ");
                                nombreProveedor = sc.nextLine();
                                if (nombreProveedor.equalsIgnoreCase("salir")) break;

                                proveedorSeleccionado = buscarProveedor(catalogoProveedores, nombreProveedor);
                                if (proveedorSeleccionado == null) {
                                    System.out.println("Proveedor no encontrado en el catálogo. Intente de nuevo.");
                                }
                            }

                            //Asociar
                            if (proveedorSeleccionado != null) {
                                u.asociarProveedorCliente(clienteSeleccionado.getNombre(), proveedorSeleccionado);
                            }
                        }
                    }
                    break;

                    case 4: {
                        if (u.getListaClientesEmpresas().isEmpty()) {
                            System.out.println("Error: No hay clientes en el sistema.");
                            break;
                        }

                        System.out.println("----CREAR CONTRATOS----");
                        System.out.print("Escriba el nombre de un cliente para buscar sus proveedores: ");
                        nombreCliente = sc.nextLine();

                        //Buscamos cliente
                        ClienteEmpresa unaEmpresa = u.buscarCliente(nombreCliente);

                        if (unaEmpresa != null) {
                            unaEmpresa.listarProveedores();
                            System.out.print("Escriba el nombre del proveedor con el que quiere generar un contrato: ");
                            nombreProveedor = sc.nextLine();

                            //Validamos si el proveedor existe en el cliente
                            Proveedor existeProveedor = u.recorrerProveedores(unaEmpresa, nombreProveedor);

                            if (existeProveedor != null) {
                                System.out.print("Escriba la duración del contrato en meses: ");
                                duracionEnMeses = Integer.parseInt(sc.nextLine());
                                System.out.print("Ingrese el monto a pagar por el contrato: ");
                                precio = Double.parseDouble(sc.nextLine());

                                //Creamos el contrato
                                existeProveedor.agregarContrato(precio, duracionEnMeses);
                            } else {
                                System.out.println("Error: El proveedor no está asociado a este cliente.");
                            }
                        } else {
                            System.out.println("Error: Cliente no encontrado.");
                        }
                    }
                    break;

                    case 5: {
                        if (u.getListaClientesEmpresas().isEmpty()) {
                            System.out.println("Error: No hay clientes en el sistema.");
                            break;
                        }

                        System.out.println("----BUSCAR PROVEEDORES SEGÚN SU TIPO----");
                        System.out.print("Escriba el nombre del cliente: ");
                        nombreCliente = sc.nextLine();

                        //Buscamos cliente
                        ClienteEmpresa clienteEncontrado = u.buscarCliente(nombreCliente);

                        if (clienteEncontrado != null) {
                            //Pedimos el tipo
                            System.out.println("Seleccione el tipo de proveedor:");
                            System.out.println("1. Cloud");
                            System.out.println("2. SaaS");
                            System.out.println("3. Pasarelas de Pago");
                            System.out.print("Opción: ");
                            tipo = Integer.parseInt(sc.nextLine());

                            String tipoString = "";
                            switch (tipo) {
                                case 1: tipoString = "Proveedor Cloud"; break;
                                case 2: tipoString = "Proveedor SaaS"; break;
                                case 3: tipoString = "Proveedor Pasarelas Pago"; break;
                                default: System.out.println("Opción no válida"); break;
                            }

                            if (!tipoString.isEmpty()) {
                                boolean tieneTipo = clienteEncontrado.verificarProveedor(tipoString);
                                if (tieneTipo) {
                                    System.out.println("El cliente SÍ tiene proveedores de tipo " + tipoString);
                                } else {
                                    System.out.println("El cliente NO tiene proveedores de tipo " + tipoString);
                                }
                            }
                        } else {
                            System.out.println("Cliente no encontrado.");
                        }
                    }
                    break;

                    case 6: {
                        u.listarContratosActivos();
                    }
                    break;

                    case 7: {
                        System.out.println("Saliendo del programa...");
                    }
                    break;

                    default: {
                        System.out.println("Opción inválida.");
                    }
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                opc = 0;
            }
        } while (opc != 7);
    }

    public static Proveedor buscarProveedor(List<Proveedor> catalogoProveedores, String nombre) {
        for (Proveedor p : catalogoProveedores) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}