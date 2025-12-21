package proveedor.tipos;

import proveedor.principales.Proveedor;

//Tipo de proveedor: Representa proveedores de infraestructura en la nube
public class ProveedorCloud extends Proveedor {

    public ProveedorCloud(String nombre, String pais) {
        super(nombre, pais);
    }

    @Override
    public String tipoProveedor() {
        return "Proveedor Cloud";
    }
}
