package poo.javaevents.clases;

import java.io.Serializable;

abstract class Persona implements Serializable {

    // Atributos

    protected String correoElectronico;

    protected String clave;

    // Constructor

    public Persona(String correoElectronico, String clave) {
        this.correoElectronico = correoElectronico;
        this.clave = clave;
    }

    // Métodos get y set

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    
}