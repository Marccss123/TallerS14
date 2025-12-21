package proveedor.principales;

import java.util.*;

public abstract class Proveedor {
    private String nombre;
    private String pais;
    private List<Contrato> listaContratos;

    public Proveedor(String nombre, String pais, String tipo) {
        this.nombre = nombre;
        this.pais = pais;
        listaContratos=new ArrayList<>();
    }

    public String getNombre() {return nombre;}
    public String getPais() {return pais;}
    public List<Contrato> getListaContratos() {return listaContratos;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPais(String pais) {this.pais = pais;}

    public void agregarContrato(double Precio, int duracionM){
        listaContratos.add(new Contrato(Precio,duracionM));
        System.out.println("Contrato agregado");
    }

    public abstract String tipoProveedor();

}
