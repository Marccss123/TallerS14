package autenticacion;

public class HuellaDigital extends MetodoAuten {
    private String patronHuella;

    public HuellaDigital(int lvlSeguridad, String patronHuella) {
        super(lvlSeguridad, "Huella Digital");
        this.patronHuella = patronHuella;
    }

    public String getPatronHuella() {return patronHuella;}
    public void setPatronHuella(String patronHuella) {this.patronHuella = patronHuella;}

    @Override
    public String toString() {
        return super.toString()+"\nPatron Huella: "+getPatronHuella();
    }

    @Override
    public boolean autenticar(String dato) {
        if (patronHuella.contains(dato))
            return true;
        return false;
    }
}