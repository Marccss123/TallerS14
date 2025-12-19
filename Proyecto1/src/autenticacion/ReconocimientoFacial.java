package autenticacion;

public class ReconocimientoFacial extends MetodoAuten {
    private String patronRostro;

    public ReconocimientoFacial(int lvlSeguridad, String patronRostro) {
        super(lvlSeguridad, "Reconocimiento Facial");
        this.patronRostro = patronRostro;
    }

    public String getPatronRostro() {
        return patronRostro;
    }

    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }

    @Override
    public String toString() {
        return super.toString()+"Patron rostro: "+getPatronRostro();
    }

    @Override
    public boolean autenticar(String dato) {
        if (patronRostro.contains(dato))
            return true;
        return false;
    }
}
