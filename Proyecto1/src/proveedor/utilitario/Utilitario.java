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



    public ProveedorSaaS crearProveedorSaaS( String nombre, String pais){
        ProveedorSaaS ps= new ProveedorSaaS(nombre,pais);
        return ps;
    }

    public ProveedorCloud crearProveedorCloud( String nombre, String pais){
        ProveedorCloud pc= new ProveedorCloud(nombre,pais);
        return pc;
    }

    public ProveedorPasarelasPago crearProveedorPP( String nombre, String pais){
        ProveedorPasarelasPago pp= new ProveedorPasarelasPago(nombre,pais);
        return pp;
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

    public void crearContratosProveedorCliente(String nombreCliente, String nombreProveedor, double precio, int duracioMeses){
        for (ClienteEmpresa ce:listaClientesEmpresas){
            if (ce.getNombre().equalsIgnoreCase(nombreCliente)){
                if (ce.getListaProveedores().isEmpty()){
                    System.out.println("No existen proveedores asociados con el cliente "+nombreCliente);
                }else {
                    for (Proveedor p: ce.getListaProveedores()){
                        if (p.getNombre().equalsIgnoreCase(nombreProveedor)){
                            p.agregarContrato(precio,duracioMeses);
                        }
                    }
                }
            }
        }
    }


}
