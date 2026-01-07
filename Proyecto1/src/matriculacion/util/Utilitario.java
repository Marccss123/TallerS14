package matriculacion.util;

import matriculacion.negocio.Auto;
import matriculacion.negocio.Moto;
import matriculacion.negocio.Propietario;
import matriculacion.negocio.Vehiculo;

import java.util.*;

//Creacion de listas necesarias para la aplicacion
public class Utilitario {
    private List<Propietario> propietarios;
    private List<Vehiculo> vehiculos;

    //NO tiene constructor por parametros, es por defectp (inicializa las listas)
    public Utilitario (){
        propietarios = new ArrayList<>();
        vehiculos = new ArrayList<>();
    }

    //Requerimientos aca - Metodos para guardar datos
    public void agregarPropietario(String cedula, String nombre, String telefono){
        Propietario pr = buscarPropietario(cedula);
        if(pr == null){
            propietarios.add(new Propietario(cedula, nombre, telefono));
        }
        else {
            System.out.println("El propietario ya existe");
        }
    }

    //Metodo para devolver datos - Busqueda por parametro
    public Propietario buscarPropietario (String cedula){
        for (Propietario p: propietarios) {
            if (p.getCedula().equals(cedula)){
                return p; //Si lo encontro, devuelve el objeto
            }
        }
        return null; //En caso de que no haya encontrado
    }

    public void agregarAuto(String marca, String modelo, int anio, Propietario duenio, String traccion, String tipo){
        vehiculos.add(new Auto(marca, modelo, anio, duenio,traccion,tipo));
    }
    public void agregarMoto(String marca, String modelo, int anio, Propietario duenio, double altura, String arranque){
        vehiculos.add(new Moto(marca, modelo, anio, duenio, altura, arranque));
    }

    public List<Vehiculo> buscarVehiciuloMarca(String marca){
        List<Vehiculo> buscar = new ArrayList<>();
        for (Vehiculo v: vehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca)){
                buscar.add(v);
            }
        }
        return buscar;//devuelve la lista
    }

    //metodo q muestra de todos los vehiculos (listas)
    public String listarVehiculos(){
        String aux = "";
        for(int i = 0; i < vehiculos.size(); i++){
            aux += vehiculos.get(i);
            aux += "\n";

        }return aux;
    }

    public String listarNombreAnioArranqueMotoXMarca(String marca){
        StringBuilder sb = new StringBuilder();
        sb.append("----LISTA----\n");
        for(int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getMarca().equalsIgnoreCase(marca)) {
                if (vehiculos.get(i) instanceof Moto){
                    Moto m = (Moto) vehiculos.get(i); //For normal - Casting (Cosas que solo estan en una clase se hace Casting)
                    sb.append("Nombre: " + m.getDuenio().getNombre()).append("Anio: ").append(m.getAnio()).append("Arranque: ").append(m.getArranque()).append("\n");
                }
            }
        }
        return sb.toString(); //sb es un OBJETO
    }

    public String listarAutomoviles(){
        StringBuilder sb = new StringBuilder();
        sb.append("----LISTA DE AUTOMOVILES----\n");
        for (Vehiculo v: vehiculos){
            if (v instanceof  Auto){
                Auto a = (Auto) v;
                sb.append(a);
                sb.append("\n").append("--------");
            }
        } return sb.toString();
    }

    public String listaPropietarios(){
        StringBuilder sb =new StringBuilder();
        sb.append("----LISTA DE PROPIETARIOS----\n");
        for(int i = 0; i < propietarios.size(); i++){
            sb.append(propietarios.get(i).toString());
            sb.append("\n").append("--------");
        }return sb.toString();
    }

    public int matricular(String cedula,String marca, int anio){
        for (Vehiculo v: vehiculos){
            if (v.getMarca().equalsIgnoreCase(marca)&& v.getDuenio().getCedula().equals(cedula) && v.getAnio()==anio){
                return v.matricula();
            }
        }
        return -1;
    }




    public void menu(){
        System.out.println("1. Agregar Propietario");
        System.out.println("2. Asignar Propietario a Auto");
        System.out.println("3. Asignar Propietario a Moto");
        System.out.println("4. Buscar Vehiculos por Marca");
        System.out.println("5. Listar Vehiiculos");
        System.out.println("6. Listar Propietarios");
        System.out.println("7. Listar Automoviles");
        System.out.println("8. Listar Motos por Marca");
        System.out.println("9. Matricular");
        System.out.println("10. Salir");
    }
}
