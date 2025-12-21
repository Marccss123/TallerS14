package proveedor.tipos;

//Representa proveedores de software como servicio

import proveedor.principales.Proveedor;

public class ProveedorSaaS extends Proveedor {
    public ProveedorSaaS(String nombre, String pais) {
        super(nombre, pais);
    }

    @Override
    public String tipoProveedor() {
        return "Proveedor SaaS";
    }
}
