package model;

public class Guia extends cl.duoc.llanquihuetour.model.Persona {
    private String idiomaEspecialidad;
    private double tarifaPorDia;

    // constructor de guia que invoca los atributos de la clase padre persona
    public Guia(String nombre, Rut rut, Direccion direccion, String idiomaEspecialidad, double tarifaPorDia) {
        super(nombre, rut, direccion);
        this.idiomaEspecialidad = idiomaEspecialidad;
        this.tarifaPorDia = tarifaPorDia;
    }

    // getters y setters para los atributos propios del guia
    public String getIdiomaEspecialidad() {
        return idiomaEspecialidad;
    }

    public void setIdiomaEspecialidad(String idiomaEspecialidad) {
        this.idiomaEspecialidad = idiomaEspecialidad;
    }

    public double getTarifaPorDia() {
        return tarifaPorDia;
    }

    public void setTarifaPorDia(double tarifaPorDia) {
        this.tarifaPorDia = tarifaPorDia;
    }

    @Override
    public void registrar() {
        // simula el registro del guia turistico en la consola
        System.out.println("Registrando guía turístico: " + getNombre());
    }

    @Override
    public void mostrarDatos() {
        // despliega los atributos heredados de persona y los propios de guia
        System.out.println("RUT: " + getRut());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Idioma Especialidad: " + idiomaEspecialidad);
        System.out.println("Tarifa por Día: $" + tarifaPorDia);
    }
}