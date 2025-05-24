/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo.javaevents.clases;

import java.util.ArrayList;

/**
 *
 * @author golde
 */
public class Buscador {

    public static ArrayList buscarPorCiudad(String ciudad) {
        // Método que busca los eventos que se dan en la ciudad introducida
        
        // Crear una lista para añadir los eventos encontrados
        ArrayList<Evento> eventosEncontrados = new ArrayList<>();
        
        // Iterar sobre la lista de eventos y ver en cuales coincide la ciudad
        for (Evento e: Datos.eventos) {
            if (e.getDireccion().getCiudad().toLowerCase().contains(ciudad.toLowerCase())) {
                eventosEncontrados.add(e);
            }
        }
        
        // Devolver la lista con los eventos encontrados
        return eventosEncontrados;
    }
    
    public static ArrayList buscarPorTipo(String tipo) {
        // Método que busca los eventos por el tipo introducido
        
        // Crear una lista para aladir los eventos encontrados
        ArrayList<Evento> eventosEncontrados = new ArrayList<>();
        
        // Ver cuales tienen el tipo introducido
        for (Evento e: Datos.eventos) {
            if (e.getTipo().toLowerCase().contains(tipo.toLowerCase())) {
                eventosEncontrados.add(e);
            }
        }
        
        // Devolver el resultado
        return eventosEncontrados;
    }
    
    public static ArrayList buscarPorTitulo(String titulo) {
        // Método que busca los eventos en base al título introducido
        
        // Crear una lista para los eventos encontrados
        ArrayList<Evento> eventosEncontrados = new ArrayList<>();
        
        // Ver cuales coinciden con el titulo introducido
        for (Evento e: Datos.eventos) {
            if (e.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                eventosEncontrados.add(e);
            }
        }
        
        // Devolver el resultado
        return eventosEncontrados;
    }
    
}
