package autenticacion.negocio;

public abstract class MetodoAuten {
        private int lvlSeguridad;
        private String tipo;

        public MetodoAuten(int lvlSeguridad, String tipo) {
            this.lvlSeguridad = lvlSeguridad;
            this.tipo=tipo;
        }

        public int getLvlSeguridad() {return lvlSeguridad;}
        public void setLvlSeguridad(int lvlSeguridad) {this.lvlSeguridad = lvlSeguridad;}
        public String getTipo() {return tipo;}
        public void setTipo(String tipo) {this.tipo = tipo;}

        @Override
        public String toString() {
            return "Nivel de seguridad: "+getLvlSeguridad()+"\nTipo: "+getTipo();
        }

        public abstract boolean autenticar(String dato);
    }
