package proveedor.utilitario;
import proveedor.principales.ClienteEmpresa;
import proveedor.principales.Proveedor;
import proveedor.tipos.ProveedorCloud;
import proveedor.tipos.ProveedorPasarelasPago;
import proveedor.tipos.ProveedorSaaS;

import java.util.*;

public class Utilitario {
    List<ClienteEmpresa> listaClientesEmpresas;
    //Constructor
    public Utilitario() {listaClientesEmpresas=new ArrayList<>();}
    //Get lista
    public List<ClienteEmpresa> getListaClientesEmpresas() {return listaClientesEmpresas;}
    /////////////////////////////////

    public void crearCliente(String nombre){
        ClienteEmpresa nuevoCliente= buscarCliente(nombre);

        if (nuevoCliente==null){
            listaClientesEmpresas.add(new ClienteEmpresa(nombre));
            System.out.println("Cliente "+nombre+" creado exitosamente!");
        }else{
            System.out.println("Cliente ya existe");
        }
    }

    public ClienteEmpresa buscarCliente(String nombre){
        for (ClienteEmpresa ce:listaClientesEmpresas){
            if (ce.getNombre().equalsIgnoreCase(nombre)){
                return ce;
            }
        }
        return null;
    }


    public Proveedor crearProveedor(String nombre, String pais, int tipo) {
        Proveedor nuevoP = null;

        switch (tipo) {
            case 1:
                nuevoP = new ProveedorCloud(nombre, pais);
                break;
            case 2:
                nuevoP = new ProveedorSaaS(nombre, pais);
                break;
            case 3:
                nuevoP = new ProveedorPasarelasPago(nombre, pais);
                break;
            default:
                System.out.println("Error: Tipo de proveedor no válido.");
                break;
        }
        return nuevoP;
    }

    public void asociarProveedorCliente(String nombre, Proveedor cualquierP){
        ClienteEmpresa ce=buscarCliente(nombre);

        if (ce!=null){
            ce.agregarProveedor(cualquierP);
            System.out.println("Proveedor agregado al cliente "+nombre);
        }else {
            System.out.println("Cliente no existe.");
        }
    }

    //Metodo para crear contratos solo a Clientes que tengan asociado un proveedor
    public void crearContratosProveedorCliente(String nombreCliente, String nombreProveedor, double precio, int duracioMeses){
        ClienteEmpresa ce= buscarCliente(nombreCliente);
        if (ce!=null){
            if (ce.getListaProveedores().isEmpty()){
                System.out.println("No existen proveedores asociados con el cliente "+nombreCliente);
            }else {
                Proveedor p=recorrerProveedores(ce,nombreProveedor);
                if (p!=null){
                    p.agregarContrato(precio,duracioMeses);
                }
                else{
                    System.out.println("No se encontro el proveedor "+nombreProveedor);
                }
            }
        }
    }

    //Metodo auxiliar para encontrar el proveedor asociado con el cliente y agregarle un contrato posteriormente
    public Proveedor recorrerProveedores(ClienteEmpresa ce, String nombreP){
            for(Proveedor p:ce.getListaProveedores()){
                if (p.getNombre().equalsIgnoreCase(nombreP)){
                    return p;
                }
            }
            return null;
    }

    public void listarContratosActivos(){
        if (listaClientesEmpresas.isEmpty()) {
            System.out.println("No hay clientes en el sistema.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Total de contratos Activos en el Sistema\n");
        for (ClienteEmpresa ce : listaClientesEmpresas) {
            sb.append("CLIENTE: ").append(ce.getNombre()).append("\n");
            sb.append(ce.obtenerContratosCliente());
        }
        System.out.println(sb.toString());
    }


    public void menu(){
        System.out.println("-----MENU-----");
        System.out.println("1. Crear Proveedor");
        System.out.println("2. Crear Cliente");
        System.out.println("3. Asociar proveedores a los clientes");
        System.out.println("4. Crear contratos entre proveedores y clientes");
        System.out.println("5. Verificar si un cliente posee proveedores de un tipo determinado");
        System.out.println("6. Listar todos los contratos activos del sistema");
        System.out.println("7. Salir");
        System.out.print("Ingresar opción: ");
    }


}
