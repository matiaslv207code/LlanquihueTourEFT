package model;

import cl.duoc.llanquihuetour.exception.RutInvalidoException;

public class Rut {
    private int numero;
    private char dv;

    // constructor que valida el rut lanza excepcion si falla
    public Rut(int numero, char dv) throws RutInvalidoException {
        if (!validarRut(numero, dv)) {
            throw new RutInvalidoException("El RUT " + numero + "-" + dv + " no es válido.");
        }
        this.numero = numero;
        this.dv = dv;
    }

    // algoritmo matemático estándar para validar el digito verificador
    private boolean validarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        char dvCalculado = (char) (s != 0 ? s + 47 : 75);
        return Character.toUpperCase(dv) == dvCalculado;
    }

    // getters para obtener los componentes del rut por separado
    public int getNumero() { return numero; }
    public char getDv() { return dv; }

    @Override
    public String toString() {
        // une el numero y el digito con un guion
        return numero + "-" + dv;
    }
}