package model;

public class Direccion {
    private String calle;
    private int numero;
    private String comuna;

    // constructor para inicializar los datos de la direccion
    public Direccion(String calle, int numero, String comuna) {
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
    }

    // getters para acceder a los atributos privados de la direccion
    public String getCalle() { return calle; }
    public int getNumero() { return numero; }
    public String getComuna() { return comuna; }

    @Override
    public String toString() {
        // retorna la direccion formateada como texto plano
        return calle + " #" + numero + ", " + comuna;
    }
}