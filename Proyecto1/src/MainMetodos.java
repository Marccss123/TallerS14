import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMetodos {
    public static void main(String[] args) {

        //Empleado
        String cedula;
        String nombre;

        //Metodo rostro
        String patronRostro;

        //Metodo huella
        String patronHuella;

        //Metodo token
        String token;

        //otros

        int lvlSeguridad;
        String tipo;

        int opc=0;
        Utilitario u=new Utilitario();
        Scanner sc=new Scanner(System.in);

        do {
            u.menu();
            opc=Integer.parseInt(sc.nextLine());

            switch (opc){
                case 1:{
                    System.out.println("Ingrese la cedula del empledo que deseea agregar: ");
                    cedula=sc.nextLine();
                    int indiceEm= u.buscarEmpleado(cedula);

                    if (indiceEm==-1){
                        System.out.println("Ingrese el nombre: ");
                        nombre= sc.nextLine();
                        u.agregarEmpleado(cedula,nombre);
                    }else {
                        System.out.println("Empleado ya existe");
                    }
                }break;
                case 2:{
                    System.out.println("Ingrese la cedula del empleado al que le quiere añadir el token");
                    cedula=sc.nextLine();
                    int indiceEm= u.buscarEmpleado(cedula);

                    if (indiceEm!=-1) {
                        System.out.println("Ingrese el toke: ");
                        token = sc.nextLine();
                        System.out.println("Ingrese el nivel de seguridad de su metodo: ");
                        lvlSeguridad = Integer.parseInt(sc.nextLine());
                        u.agregarAutenticacionToken(cedula, token, lvlSeguridad);
                    }else {
                        System.out.println("No existe Empleado con esa cedula");
                    }
                }break;
                case 3:{
                    System.out.println("Ingrese la cedula del empleado al que le quiere añadir el rostro");
                    cedula = sc.nextLine();
                    int indiceEm= u.buscarEmpleado(cedula);

                    if (indiceEm==-1) {
                        System.out.println("Ingrese el patron del rostro: ");
                        patronRostro = sc.nextLine();
                        System.out.println("Ingrese el nivel de seguridad de su metodo: ");
                        lvlSeguridad = Integer.parseInt(sc.nextLine());
                        u.agregarAutenticacionToken(cedula, patronRostro, lvlSeguridad);
                    }else {
                        System.out.println("No existe Empleado con esa cedula");
                    }
                }break;
                case 4:{
                    System.out.println("Ingrese la cedula del empleado al que le quiere añadir una huella");
                    cedula = sc.nextLine();
                    int indiceEm= u.buscarEmpleado(cedula);

                    if (indiceEm==-1) {
                        System.out.println("Ingrese el patron de la huella: ");
                        patronHuella = sc.nextLine();
                        System.out.println("Ingrese el nivel de seguridad de su metodo: ");
                        lvlSeguridad = Integer.parseInt(sc.nextLine());
                        u.agregarAutenticacionToken(cedula, patronHuella, lvlSeguridad);
                    }else {
                        System.out.println("No existe Empleado con esa cedula");
                    }
                }break;
                case 5:{
                    System.out.println(u.mostrarDatosEmpleados());
                }break;
                case 6:{
                    System.out.println("Ingrese la cedula del empleado que quiere buscar: ");
                    cedula=sc.nextLine();

                    int indiceEm= u.buscarEmpleado(cedula);

                    if (indiceEm!=-1) {
                        System.out.println(u.getListaEmpleados().get(indiceEm).toString());
                    }else {
                        System.out.println("No existe Empleado con esa cedula");
                    }
                }break;
                case 7:{
                    System.out.println("Ingrese una cedula para buscar los metodos de autenticacion del empleado: ");
                    cedula = sc.nextLine();
                    int indiceEm= u.buscarEmpleado(cedula);
                    int total=u.cantidadMetodos(cedula);

                    if (indiceEm!=-1){
                        System.out.println("El empleado "+u.getListaEmpleados().get(indiceEm).getNombre()+" tiene "+
                                total+" metodos de autenticacion registrados");
                    }else {
                        System.out.println("Empleado no existe.");
                    }
                }break;
                case 8:{

                }
            }
        }while (opc!=0);
    }
}
