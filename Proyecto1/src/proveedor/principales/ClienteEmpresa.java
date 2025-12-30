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

    public String obtenerContratosCliente(){
        StringBuilder sb=new StringBuilder();
        for (Proveedor p:listaProveedores){
            sb.append("Proveedor: ").append(p.getNombre()).append("\n");
            for (Contrato c: p.getListaContratos()){
                if (c.isActivo()){
                    sb.append(c.toString()).append("\n");
                }
            }
        }
        if (sb.length() == 0) {
            return "   [Sin contratos activos]\n";
        }

        return sb.toString();
    }

    public void listarProveedores(){
        if (listaProveedores.isEmpty()) {
            System.out.println("No hay clientes en el sistema.");
            return;
        }

        StringBuilder sb=new StringBuilder();
        sb.append("\t----PROVEEDORES ASOCIADOS AL CLIENTE----\n");
        for (Proveedor p:listaProveedores){
            sb.append("Nombre: ").append(p.getNombre()).append(" - País: ").append(p.getPais()).append("\n");
        }
        System.out.println(sb.toString());
    }




}
