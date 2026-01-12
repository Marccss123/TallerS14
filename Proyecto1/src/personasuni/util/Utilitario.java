package personasuni.util;

import personasuni.individuos.*;
import java.util.ArrayList;
import java.util.List;
import personasuni.excepciones.CedulaDuplicadaException;

public class Utilitario {

    private List<Persona> listaPersonas;

    public Utilitario() {
        this.listaPersonas = new ArrayList<>();
    }

    public void agregarAlumnoPregrado(String nombre, String cedula, String universidad, String carrera) throws CedulaDuplicadaException {
        if (buscarPersona(cedula) == null) {
            listaPersonas.add(new AlumnoPregrado(nombre, cedula, universidad, carrera));
            System.out.println("Alumno de Pregrado agregado con éxito.");
        } else {
            throw new CedulaDuplicadaException("Ya existe una persona registrada con la cédula " + cedula);
        }
    }

    public void agregarAlumnoMagister(String nombre, String cedula, String universidad, String tesis) throws CedulaDuplicadaException{
        if (buscarPersona(cedula) == null) {
            listaPersonas.add(new AlumnoMagister(nombre, cedula, universidad, tesis));
            System.out.println("Alumno de Magíster agregado con éxito.");
        } else {
            throw new CedulaDuplicadaException("Ya existe una persona registrada con la cédula " + cedula);
        }
    }

    public void agregarProfesorHora(String nombre, String cedula, String especialidad, int horas) throws CedulaDuplicadaException {
        if (buscarPersona(cedula) == null) {
            listaPersonas.add(new ProfesorHora(nombre, cedula, especialidad, horas));
            System.out.println("Profesor por Hora agregado con éxito.");
        } else {
            throw new CedulaDuplicadaException("Ya existe una persona registrada con la cédula " + cedula);
        }
    }

    private Persona buscarPersona(String cedula) {
        for (Persona p : listaPersonas) {
            if (p.getCedula().equals(cedula)) {
                return p;
            }
        }
        return null;
    }

    public void listarAlumnosPregrado() {
        System.out.println("----- ALUMNOS DE PREGRADO -----");
        boolean hay = false;
        for (Persona p : listaPersonas) {
            if (p instanceof AlumnoPregrado) {
                System.out.println(p);
                hay = true;
            }
        }
        if (!hay) System.out.println("[No hay alumnos de pregrado registrados]");
    }

    public void listarAlumnosMagister() {
        System.out.println("----- ALUMNOS DE MAGÍSTER -----");
        boolean hay = false;
        for (Persona p : listaPersonas) {
            if (p instanceof AlumnoMagister) {
                System.out.println(p);
                hay = true;
            }
        }
        if (!hay) System.out.println("[No hay alumnos de magíster registrados]");
    }

    public void listarProfesores() {
        System.out.println("----- PROFESORES POR HORA -----");
        boolean hay = false;
        for (Persona p : listaPersonas) {
            if (p instanceof ProfesorHora) {
                ProfesorHora ph = (ProfesorHora) p;
                System.out.println(ph);
                System.out.println("Sueldo a pagar (20$/h): $" + (ph.getHoras() * 20));
                System.out.println("-------------------------");
                hay = true;
            }
        }
        if (!hay) System.out.println("[No hay profesores registrados]");
    }

    public void listarTodos() {
        System.out.println("----- LISTADO GENERAL -----");
        if (listaPersonas.isEmpty()) {
            System.out.println("[La lista está vacía]");
        } else {
            for (Persona p : listaPersonas) {
                System.out.println(p);
                System.out.println("-----------------");
            }
        }
    }

    public void menu() {
        System.out.println("\n--------------------- OPCIONES ---------------------");
        System.out.println("1.- Mostrar listado general (Todos)");
        System.out.println("2.- Ingresar Alumno pregrado");
        System.out.println("3.- Ingresar Alumno magister");
        System.out.println("4.- Ingresar Profesor hora");
        System.out.println("5.- Listar Alumnos Pregrado");
        System.out.println("6.- Listar Alumnos Magister");
        System.out.println("7.- Listar Profesores");
        System.out.println("8.- SALIR");
        System.out.print("INGRESE UNA OPCION: ");
    }
}