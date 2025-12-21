package proveedor.principales;

import java.util.*;
public class ClienteEmpresa {

    private String nombre;
    private List<Proveedor> listaProveedores=new ArrayList<>();

    public ClienteEmpresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {return nombre;}
    public List<Proveedor> getListaProveedores() {return listaProveedores;}

    public void agregarProveedor(Proveedor pro){listaProveedores.add(pro);}

    public boolean verificarProveedor(String tipo){
        for (Proveedor p:listaProveedores){
            if (p.tipoProveedor().equalsIgnoreCase(tipo)){
                return true;
            }
        }
        return false;
    }

    public void imprimirContratosCliente(){
        for (Proveedor p:listaProveedores){
            System.out.println("Proveedor: "+p.getNombre());
            for (Contrato c: p.getListaContratos()){
                if (c.isActivo()){
                    System.out.println(c);
                }
            }
        }
    }




}
