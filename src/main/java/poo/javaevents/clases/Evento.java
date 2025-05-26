/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javaevents.clases;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author golde
 */
public class Evento implements Serializable {

    private String titulo;

    private String tipo; // concierto, deporte, musical, teatro

    private Direccion direccion;

    private ArrayList<LocalDateTime> fechasYHoras;

    private double precioEntrada;

    private String portada;

    private double calificacion;

    private ArrayList<Resenia> resenias;
    
    public Evento(String titulo, String tipo, Direccion direccion, ArrayList<LocalDateTime> fechasYHoras, double precioEntrada, String portada, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.fechasYHoras = fechasYHoras;
        this.precioEntrada = precioEntrada;
        this.portada = portada;
        this.calificacion = calificacion;
        this.resenias = new ArrayList<>();
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public ArrayList getFechasYHoras() {
        return fechasYHoras;
    }

    public void addFechaYHoras(ArrayList fechasYHoras) {
        this.fechasYHoras = fechasYHoras;
    }
    
    public void addFechaYHora(LocalDateTime horario) {
        this.fechasYHoras.add(horario);
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void addResenia(Resenia resenia) {
        this.resenias.add(resenia);
    }
    
    // Otros métodos

    /**
     * Método para agregar una reseña a la lista de reseñas de la propia clase.
     * 
     * @param evento
     * @param calificacion
     * @param descripccion 
     */
    public void escribirResenia(Evento evento, int calificacion, String descripccion) {
        Resenia r = new Resenia(evento, calificacion, descripccion); // Crear objeto de reseña
        
        resenias.add(r); // Añadir reseña a la lista
    }
}
