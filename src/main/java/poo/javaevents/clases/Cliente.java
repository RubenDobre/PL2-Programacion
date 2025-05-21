package poo.javaevents.clases;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

    // Atributos
    
    private String nombre;

    private int telefono;

    private Direccion direccion;

    private TarjetaCredito tarjetaCredito;
    
    private boolean VIP;

    // Constructor
    
    public Cliente(String nombre, String correoElectronico, String clave,
            int telefono, Direccion direccion, TarjetaCredito tarjetaCredito,
            boolean VIP) {
        super(correoElectronico, clave);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.VIP = VIP;
    }

    // Métodos get y set
    
    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public TarjetaCredito getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getTeléfono() {
        return telefono;
    }

    public void setTeléfono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    
}
