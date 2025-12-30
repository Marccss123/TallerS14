package proveedor;

import autenticacion.Utilitario;
import jdk.jshell.execution.Util;
import proveedor.principales.Proveedor;

import java.util.InputMismatchException;
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

        do {
            try{
                u.menu();
                opc=Integer.parseInt(sc.nextLine());

                switch (opc){
                    case 1:{
                        System.out.println("----CREAR PROVEEDOR----");
                        System.out.println("Ingrese el nombre del Proveedor: ");
                        nombreProveedor=sc.nextLine();
                        System.out.println("Ingrese el país del proveedor: ");
                        pais=sc.nextLine();
                        System.out.println("Ingrese el tipo del proveedor (1 -> Cloud , 2 -> SaaS , 3 -> Pasarelas Pago)");
                        tipo=Integer.parseInt(sc.nextLine());

                        //Crear Proveedor
                        Proveedor nuevoProveedor= u.cr

                    }break;
                }

            }catch (InputMismatchException e){
                System.out.println("Error: Debe ingresar un numero.");
                u.menu();
                sc.nextLine();
                opc = 0;
            }
        }while(opc!=7);


    }

}
