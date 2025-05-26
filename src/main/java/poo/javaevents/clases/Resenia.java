/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javaevents.clases;

import java.io.Serializable;

/**
 *
 * @author golde
 */
public class Resenia implements Serializable {

    // Atributos
    
    private Evento evento;
    private int calificacion;
    private String descripcion;

    // Constructor
    
    public Resenia(Evento evento, int calificacion, String comentario) {
        this.evento = evento;
        this.calificacion = calificacion;
        this.descripcion = comentario;
    }

    // Métodos get y set
    
    public Evento getEvento() {
        return evento;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getComentario() {
        return descripcion;
    }

    
    public void setUsuario(Evento evento) {
        this.evento = evento;
    }

    public void setComentario(String comentario) {
        this.descripcion = comentario;
    }
    
    // Otros métodos
    
    /**
    * Método para agregar una calificación al evento. Si la calificación está 
    * fuera de rango, el método da error.
    * 
    * @param calificacion
    * @throws IllegalArgumentException
    */
    public void setCalificacion(int calificacion) throws IllegalArgumentException {
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificacion debe estar entre  0 y 5");
        }
        this.calificacion = calificacion;
    }

}
