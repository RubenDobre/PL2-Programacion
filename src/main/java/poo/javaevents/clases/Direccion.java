package poo.javaevents.clases;

import java.io.Serializable;

public class Direccion implements Serializable {

    // Atributos
    
    private String calle;

    private int numero;

    private String ciudad;

    private int codPostal;

    // Constructor
    
    public Direccion(String calle, int numero, String ciudad, int codPostal) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.codPostal = codPostal;
    }

    // Métodos get y set
    
    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    
}
