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

    private String tipo;

    private Direccion direccion;

    private ArrayList<LocalDateTime> fechasYHoras;

    private double precioEntrada;

    private String portada;

    private double calificacion;

    public Evento(String titulo, String tipo, Direccion direccion, ArrayList<LocalDateTime> fechasYHoras, double precioEntrada, String portada, double calificacion) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.fechasYHoras = fechasYHoras;
        this.precioEntrada = precioEntrada;
        this.portada = portada;
        this.calificacion = calificacion;
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

    public void addFechaYHora(ArrayList fechasYHoras) {
        this.fechasYHoras = fechasYHoras;
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

    
}
