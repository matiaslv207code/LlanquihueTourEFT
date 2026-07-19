package cl.duoc.llanquihuetour.model;

import cl.duoc.llanquihuetour.interfaces.Registrable;
import model.Direccion;
import model.Rut;

public abstract class Persona implements Registrable {
    private String nombre;
    private Rut rut;
    private Direccion direccion;

    // constructor base para inicializar los datos heredables de una persona
    public Persona(String nombre, Rut rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
    }

    // getters y setters para mantener el encapsulamiento de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        // retorna la representacion en texto de los datos de la persona
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", rut=" + rut +
                ", direccion=" + direccion +
                '}';
    }
}