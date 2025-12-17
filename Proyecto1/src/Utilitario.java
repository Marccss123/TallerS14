import java.util.ArrayList;
import java.util.List;

public class    Utilitario {
    private List<Empleado> listaEmpleados;

    public Utilitario() {
        listaEmpleados = new ArrayList<>();
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void agregarEmpleado(String cedula, String nombre) {
        int indice = buscarEmpleado(cedula);
        if (indice == -1) {
            listaEmpleados.add(new Empleado(cedula, nombre));
        } else {
            System.out.printf("Empleado con la cedula %s ya existe", cedula);
        }
    }

    public int buscarEmpleado(String cedula) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getCedula().equals(cedula)) {
                return i;
            }
        }
        return -1;
    }

    public void agregarAutenticacionHuella(String cedula, String huella, int lvlsSeguridad) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            listaEmpleados.get(indice).adicionarAutenticacion(new HuellaDigital(lvlsSeguridad, huella));
        } else {
            System.out.println("El empleado no existe");
        }
    }

    public void agregarAutenticacionToken(String cedula, String token, int lvlsSeguridad) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            listaEmpleados.get(indice).adicionarAutenticacion(new TokenSeguridad(lvlsSeguridad, token));
        } else {
            System.out.println("El empleado no existe");
        }
    }

    public void agregarAutenticacionRostro(String cedula, String patronRostro, int lvlsSeguridad) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            if (cantidadAutenticacionRostro(cedula)==0){
               // if (listaEmpleados.get(indice).cantidadRegistroRostro()==0)
                listaEmpleados.get(indice).adicionarAutenticacion(new ReconocimientoFacial(lvlsSeguridad, patronRostro));
            }
        } else {
            System.out.println("El empleado no existe");
        }
    }

    public int cantidadAutenticacionHuella(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            return listaEmpleados.get(indice).cantidadRegistroHuella();
        } else {
            System.out.println("Empleado no existe");
            return -1;
        }
    }

    public int cantidadAutenticacionToken(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            return listaEmpleados.get(indice).cantidadRegistroToken();
        } else {
            System.out.println("Empleado no existe");
            return -1;
        }
    }

    public int cantidadAutenticacionRostro(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            return listaEmpleados.get(indice).cantidadRegistroRostro();
        } else {
            System.out.println("Empleado no existe");
            return -1;
        }
    }

    public int cantidadMetodos(String cedula) {
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            return listaEmpleados.get(indice).getAutenticaciones().size();
        } else {
            System.out.println("Empleado no existe");
            return -1;
        }
    }



    public String autenticacionMayorSeguridad(String cedula,int nivel){
        int indice = buscarEmpleado(cedula);
        if (indice != -1) {
            return listaEmpleados.get(indice).seguridadMayorUmbral(nivel);
        } else {
            System.out.println("Empleado no existe");
            return null;
        }
    }

    public String autenticarUtil(String tipo, String dato, String cedula){
        int indice=buscarEmpleado(cedula);
        if (indice!=-1){
            boolean b= listaEmpleados.get(indice).autenticar(dato, tipo);
            if (b){
                return "Acceso concedido";
            }else{
                return "Acceso denegado";
            }
        }else {
            return "Empleado ya existe";
        }
    }

    public void menu(){
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Agregar token seguridad");
            System.out.println("3. Agregar reconocimiento facial");
            System.out.println("4. Agregar huella digital");
            System.out.println("5. Mostrar datos de empleados (todos)");
            System.out.println("6. Buscar empleado y mostrar datos");
            System.out.println("7. Total métodos autenticación empleado");
            System.out.println("8. Total métodos huella empleado");
            System.out.println("9. Total métodos token empleado");
            System.out.println("10. Total métodos facial empleado");
            System.out.println("11. Métodos mayor a umbral de empleado");
            System.out.println("12. Autenticar empleado");
            System.out.println("14. Salir");
    }

    public String mostrarDatosEmpleados(){
        StringBuilder sb =new StringBuilder();

        for(Empleado eM: listaEmpleados){
            sb.append(eM);
            sb.append("\n");
        }return sb.toString();
    }


}
