package poo.javaevents.clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Datos {

    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Evento> eventos = new ArrayList<>();
    
    // Métodos para guardar los datos de los ArrayList
    
    public static void guardarClientes() {
        try {
            FileOutputStream fos = new FileOutputStream("clientes.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void guardarEventos() {
        try {
            FileOutputStream fos = new FileOutputStream("eventos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(eventos);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error al guardar eventos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Métodos para cargar o guardar todo a la vez
    public static void guardarTodo() {
        guardarClientes();
        guardarEventos();
    }

    public static void cargarTodo() {
        cargarClientes();
        cargarEventos();
    }
    
    // Métodos para cargar los datos serializados
    
    public static void cargarClientes() {
        try {
            FileInputStream fis = new FileInputStream("clientes.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            clientes = (ArrayList<Cliente>) ois.readObject();
            fis.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo clientes.dat no encontrado. "
                    + "No se han podido cargar los datos");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el archivo clientes.dat: " 
                    + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void cargarEventos() {
        try {
            FileInputStream fis = new FileInputStream("eventos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            eventos = (ArrayList<Evento>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo eventos.dat no encontrado, se iniciará vacío.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar eventos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
