package model;

public class Cliente extends cl.duoc.llanquihuetour.model.Persona {
    private String email;
    private String nivelFidelidad;

    // constructor de cliente que invoca los atributos de la clase padre persona
    public Cliente(String nombre, Rut rut, Direccion direccion, String email, String nivelFidelidad) {
        super(nombre, rut, direccion);
        this.email = email;
        this.nivelFidelidad = nivelFidelidad;
    }

    public String getEmail() { return email; }
    public String getNivelFidelidad() { return nivelFidelidad; }

    @Override
    public void registrar() {
        // simula el registro del cliente en la consola
        System.out.println("Registrando cliente " + getNombre() + " en la base de datos.");
    }

    @Override
    public void mostrarDatos() {
        // despliega los atributos heredados de persona y los propios de cliente
        System.out.println("RUT: " + getRut());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Email: " + getEmail());
        System.out.println("Nivel Fidelidad: " + getNivelFidelidad());
    }
}