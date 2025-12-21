package proveedor.principales;

public class Contrato {
    private double precio;
    private int duracionEnMeses;
    private boolean activo;

    public Contrato(double precio, int duracionEnMeses) {
        this.precio = precio;
        this.duracionEnMeses = duracionEnMeses;
        this.activo=true;
    }

    public double getPrecio() {return precio;}
    public int getDuracionEnMeses() {return duracionEnMeses;}

    //Get solo regresa el estado
    public boolean isActivo() {return activo;}

    //Metodo para cancelar el contrato
    public void cancelarContrato() {this.activo = false;}

    //Metodos
    public String estaActivo(){
        if (activo){
            return "Contrato Activo";
        }
        return "Contrato inactivo";
    }

    @Override
    public String toString() {
        return "Precio: "+getPrecio()+" - Duracion: "+getDuracionEnMeses();
    }
}
