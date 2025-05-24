/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javaevents.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author golde
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Direccion d = new Direccion("Callosa", 2, "Guadalajara", 19005);

            LocalDate f = LocalDate.now();
            DateTimeFormatter fc = DateTimeFormatter.ofPattern("MM/yyyy");

            TarjetaCredito t = new TarjetaCredito("Juan", 1234123412341234l, f);

            Cliente c = new Cliente("Juan", "juan@gmail.com", "12345678", 611111111,
            d, t, false);

            ArrayList<LocalDateTime> fechasYHoras = new ArrayList<>();
            LocalDateTime fh = LocalDateTime.now();
            fechasYHoras.add(fh);

            Evento e = new Evento("Fiesta de Juan", "concierto", d, fechasYHoras,
            199.99, "", 5);

            Reserva r = new Reserva(c, e, 3, 200, fh);

            Factura.crearFactura(r);
    } catch (Exception e) {
        System.err.println("Error en el método main: " + e.getMessage());
        e.printStackTrace();
        }
    }
}
