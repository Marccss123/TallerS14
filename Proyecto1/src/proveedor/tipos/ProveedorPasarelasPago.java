package proveedor.tipos;

//Representa proveedores de servicios de pago digital

import proveedor.principales.Proveedor;

public class ProveedorPasarelasPago extends Proveedor {
    public ProveedorPasarelasPago(String nombre, String pais) {
        super(nombre, pais);
    }

    @Override
    public String tipoProveedor(){
        return "Proveedor Pasarelas Pago";
    }
}
