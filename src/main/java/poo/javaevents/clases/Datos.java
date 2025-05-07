package poo.javaevents.clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Datos {

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    
    static {
        Direccion d1 = new Direccion("calle", 1, "Madrid", 00000);
        LocalDate f1 = LocalDate.of(2028, 3, 27);
        TarjetaCredito t1 = new TarjetaCredito("Javi", 1234123412341234L, f1);
    
        Cliente cliente1 = new Cliente("Javi", "test@gmail.com", "1234", 611111111, d1, t1, false);
        
        clientes.add(cliente1);
    }
    
}
