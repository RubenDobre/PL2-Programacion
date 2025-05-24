/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javaevents.clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author golde
 */
public class Factura {

    public static void crearFactura(Reserva reserva) {
        
        String nombreFactura = ("factura " + reserva.getCliente().getNombre() +
                " " + reserva.getEvento().getTitulo() + ".txt");
        
        try {
            PrintWriter salida = new PrintWriter(new BufferedWriter(
                    new FileWriter("facturas/" + nombreFactura)));
            
            salida.println("FACTURA\n\n");
            
            DateTimeFormatter fecha 
                    = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter hora 
                    = DateTimeFormatter.ofPattern("HH:mm");
            salida.println("FECHA Y HORA DE RESERVA\n");
            salida.println("Fecha: " + 
                    reserva.getFechaReservada().format(fecha));
            salida.println("Hora: " +
                    reserva.getFechaReservada().format(hora) + "\n\n");
            
            salida.println("DATOS DEL CLIENTE\n");
            salida.println("Nombre: " + reserva.getCliente().getNombre());
            salida.println("Correo electrónico: " +
                    reserva.getCliente().getCorreoElectronico());
            salida.println("Teléfono: " + reserva.getCliente().getTelefono() +
                    "\n\n");
            
            salida.println("FACTURAR A\n");
            salida.println("Calle: " +
                    reserva.getCliente().getDireccion().getCalle() + ", " +
                    reserva.getCliente().getDireccion().getNumero());
            salida.println("Ciudad" +
                    reserva.getCliente().getDireccion().getCiudad());
            salida.println("Código postal: " +
                    reserva.getCliente().getDireccion().getCodPostal() + "\n\n");
            
            salida.println("DESCRIPCIÓN\n");
            salida.println("Entrada para: " + reserva.getEvento().getTitulo());
            salida.println("Unidades adquiridas: " +
                    reserva.getNumeroEntradas() + "\n\n");
            
            salida.println("TOTAL (EUR)  " + reserva.getPrecioTotal() + "€");
            
            System.out.println("Factura generada.");
        } catch (IOException ioe) {
            System.out.println("Error al generar la factura: " + ioe.getMessage());
        }
    }
    
}
