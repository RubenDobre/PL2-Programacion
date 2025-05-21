package poo.javaevents.clases;

import java.io.Serializable;
import java.time.LocalDate;

public class TarjetaCredito implements Serializable {
    
    // Atributos
    
    private String nombreTitular;

    private long numero;

    private LocalDate fechaCaducidad;
    
    // Constructor

    public TarjetaCredito(String nombreTitular, long numero, LocalDate fechaCaducidad) {
        this.nombreTitular = nombreTitular;
        this.numero = numero;
        this.fechaCaducidad = fechaCaducidad;
    }
    
    // Métodos get y set

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

}
