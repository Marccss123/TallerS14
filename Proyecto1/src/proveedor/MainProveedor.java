package proveedor;

import jdk.jshell.execution.Util;
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
        boolean activo;

        //Proveedor-Atributos
        String nombreProveedor;
        String pais;
        int tipo;

        //Cliente-Atributos
        String nombreCliente;

        //Menu
        int opc;
        Scanner sc=new Scanner(System.in);
        Utilitario u=new Utilitario();
        List<Proveedor> catalogoProveedores=new ArrayList<>();

        do {
            try{
                u.menu();
                opc=Integer.parseInt(sc.nextLine());

                switch (opc){
                    case 1:{
                        System.out.println("----CREAR PROVEEDOR----");
                        System.out.print("Ingrese el nombre del Proveedor: ");
                        nombreProveedor=sc.nextLine();
                        System.out.print("Ingrese el país del proveedor: ");
                        pais=sc.nextLine();
                        System.out.print("Ingrese el tipo del proveedor (1 -> Cloud , 2 -> SaaS , 3 -> Pasarelas Pago)");
                        tipo=Integer.parseInt(sc.nextLine());

                        //Crear Proveedor
                        Proveedor nuevoProveedor=u.crearProveedor(nombreProveedor,pais, tipo);
                        //Añadimos el proveedor a una lista general (catálogo) de proveedores de los que luego podremos escojer para asociar
                        if (nuevoProveedor != null) {
                            catalogoProveedores.add(nuevoProveedor);
                            System.out.println("Éxito: Se ha creado un " + nuevoProveedor.tipoProveedor());
                        }
                    }break;
                    case 2:{
                        System.out.println("----CREAR NUEVO CLIENTE----");
                        System.out.print("Escriba un nombre para el nuevo cliente: ");
                        nombreCliente=sc.nextLine();

                        //Crear cliente
                        u.crearCliente(nombreCliente);
                    }break;
                    case 3:{
                        System.out.println("----ASOCIAR PROVEEDOR A CLIENTE");
                        System.out.print("Escriba el nombre del cliente que desea asociar a un proveedor: ");
                        nombreCliente=sc.nextLine();
                        System.out.print("Escribe el nombre del proveedor para asociar al cliente: ");
                        nombreProveedor=sc.nextLine();
                        Proveedor unProveedor=buscarProveedor(catalogoProveedores, nombreProveedor);
                        if (unProveedor!=null){
                            //Asociar
                            u.asociarProveedorCliente(nombreCliente,unProveedor);
                        }else {
                            System.out.println("Error: No se encontró el proveedor '" + nombreProveedor + "' en el catálogo.");
                        }
                    }break;
                    case 4:{
                        System.out.println("----CREAR CONTRATOS----");
                        System.out.print("Escriba el nombre de un cliente para buscar sus proveedores: ");
                        nombreCliente=sc.nextLine();

                        ClienteEmpresa unaEmpresa=u.buscarCliente(nombreCliente);
                        if (unaEmpresa!=null){
                            unaEmpresa.listarProveedores();
                            System.out.print("Escriba el nombre del proveedor con el que quiere generar un contrato: ");
                            nombreProveedor=sc.nextLine();


                        }
                    }
                }

            }catch (InputMismatchException e){
                System.out.println("Error: Debe ingresar un numero.");
                u.menu();
                sc.nextLine();
                opc = 0;
            }
        }while(opc!=7);


    }

    public static Proveedor buscarProveedor(List<Proveedor> catalogoProveedores, String nombre){
        for(Proveedor p:catalogoProveedores){
            if (p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

}
