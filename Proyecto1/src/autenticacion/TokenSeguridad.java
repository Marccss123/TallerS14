package autenticacion;

public class TokenSeguridad extends MetodoAuten {
    private String token;

    public TokenSeguridad(int lvlSeguridad, String token) {
        super(lvlSeguridad, "Token");
        this.token = token;
    }


    public void setToken(String token) {this.token = token;}

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean autenticar(String dato) {
        if(token.equals(dato))
            return true;
        return false;
    }
}
