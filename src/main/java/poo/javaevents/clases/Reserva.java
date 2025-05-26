/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javaevents.clases;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author golde
 */
public class Reserva implements Serializable {

    // Atributos
    
    private Cliente cliente;

    private Evento evento;

    private int numeroEntradas;

    private double precioEntrada;

    private double precioTotal;

    private LocalDateTime fechaReservada;

    // Constructor
    
    public Reserva(Cliente cliente, Evento evento, int numeroEntradas, double precioEntrada, LocalDateTime fechaReservada) {
        this.cliente = cliente;
        this.evento = evento;
        this.numeroEntradas = numeroEntradas;
        this.precioEntrada = precioEntrada;
        this.precioTotal = this.precioEntrada * this.numeroEntradas;
        this.fechaReservada = fechaReservada;
    }

    // Métodos get y set
    
    public LocalDateTime getFechaReservada() {
        return fechaReservada;
    }

    public void setFechaReservada(LocalDateTime fechaReservada) {
        this.fechaReservada = fechaReservada;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
        this.precioTotal = this.precioEntrada * this.numeroEntradas;
    }

    public int getNumeroEntradas() {
        return numeroEntradas;
    }

    public void setNumeroEntradas(int numeroEntradas) {
        this.numeroEntradas = numeroEntradas;
        this.precioTotal = this.precioEntrada * this.numeroEntradas;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
}
