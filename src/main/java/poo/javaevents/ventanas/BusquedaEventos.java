/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package poo.javaevents.ventanas;

import java.awt.Font;
import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import poo.javaevents.clases.Buscador;
import poo.javaevents.clases.Cliente;
import poo.javaevents.clases.Datos;
import poo.javaevents.clases.Direccion;
import poo.javaevents.clases.Evento;

/**
 *
 * @author golde
 */
public class BusquedaEventos extends javax.swing.JFrame {

    /**
     * Creates new form BusquedaEventos
     */
    public BusquedaEventos() {
        initComponents();
        
        // Ajustar el tamaño de la foto del botón de buscar
        
        String ruta = "/imagenes/lupa.png";
        
        ImageIcon icono = new ImageIcon(getClass().getResource(ruta)); // Obtener icono
        Image imagenOriginal = icono.getImage(); // Obtener su imagen
        Image imagenEscalada = imagenOriginal.getScaledInstance(20, 20, Image.SCALE_SMOOTH); // Escalar
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada); // Volver a transformar a icono
        botonBuscar.setIcon(iconoEscalado);
        
        // Hacer lo mismo para el botón de perfil del usuario
        
        ruta = "/imagenes/perfil1.png";
        
        icono = new ImageIcon(getClass().getResource(ruta)); // Obtener icono
        imagenOriginal = icono.getImage(); // Obtener su imagen
        imagenEscalada = imagenOriginal.getScaledInstance(35, 35, Image.SCALE_REPLICATE); // Escalar
        iconoEscalado = new ImageIcon(imagenEscalada); // Volver a transformar a icono
        botonPerfil.setIcon(iconoEscalado);
        
        // Imagen del botón de reservas
        
        ruta = "/imagenes/reserva.png";
        
        icono = new ImageIcon(getClass().getResource(ruta)); // Obtener icono
        imagenOriginal = icono.getImage(); // Obtener su imagen
        imagenEscalada = imagenOriginal.getScaledInstance(35, 35, Image.SCALE_REPLICATE); // Escalar
        iconoEscalado = new ImageIcon(imagenEscalada); // Volver a transformar a icono
        botonReserva.setIcon(iconoEscalado);

        Datos.eventos.add(new Evento(
                "Concierto de Coldplay",
                "Concierto",
                new Direccion("Av. Música", 123, "Madrid", 28013),
                new ArrayList<>(List.of(
                        LocalDateTime.of(2025, 6, 20, 21, 0),
                        LocalDateTime.of(2025, 6, 21, 21, 0)
                )),
                75.50,
                "/imagenes/coldplay.jpg",
                4.8
        ));

        Datos.eventos.add(new Evento(
                "Final de la Champions",
                "Deporte",
                new Direccion("Estadio Nacional", 1, "Barcelona", 8002),
                new ArrayList<>(List.of(
                        LocalDateTime.of(2025, 5, 30, 20, 45)
                )),
                120.00,
                "/recursos/champions.png",
                4.9
        ));

        Datos.eventos.add(new Evento(
                "Musical El Rey León",
                "Musical",
                new Direccion("Gran Vía", 45, "Madrid", 28013),
                new ArrayList<>(List.of(
                        LocalDateTime.of(2025, 7, 5, 19, 30),
                        LocalDateTime.of(2025, 7, 6, 19, 30),
                        LocalDateTime.of(2025, 7, 7, 19, 30)
                )),
                55.00,
                "/recursos/reyLeon.png",
                4.7
        ));

        Datos.eventos.add(new Evento(
                "Teatro Hamlet",
                "Teatro",
                new Direccion("Calle Teatro Clásico", 8, "Sevilla", 41001),
                new ArrayList<>(List.of(
                        LocalDateTime.of(2025, 6, 15, 20, 0),
                        LocalDateTime.of(2025, 6, 16, 20, 0)
                )),
                30.00,
                "/recursos/hamlet.png",
                4.2
        ));

        Datos.eventos.add(new Evento(
                "Festival Primavera Sound",
                "Concierto",
                new Direccion("Parc del Fòrum", 1, "Barcelona", 8019),
                new ArrayList<>(List.of(
                        LocalDateTime.of(2025, 6, 3, 16, 0),
                        LocalDateTime.of(2025, 6, 4, 16, 0),
                        LocalDateTime.of(2025, 6, 5, 16, 0)
                )),
                95.00,
                "/recursos/primaveraSound.png",
                4.5
        ));

        Datos.eventos.add(new Evento(
                "Partido NBA Europe",
                "Deporte",
                new Direccion("WiZink Center", 1, "Madrid", 28009),
                new ArrayList<>(List.of(
                        LocalDateTime.of(2025, 10, 10, 20, 0),
                        LocalDateTime.of(2025, 10, 11, 20, 0)
                )),
                110.00,
                "/recursos/nbaEurope.png",
                4.6
        ));

        // Crear un modelo DefaultTableModel con celdas no editables
        
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Título", "Tipo", "Ciudad"}, 0 // Títulos de cada columna y número inicial de filas
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Ninguna celda editable
            }
        };

        // Aplicar el modelo a la tabla creada
        tablaEventos.setModel(modelo);
        
        // Hacer que se pueda elejir solo una fila a la vez
        tablaEventos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tablaEventos.setShowGrid(false);
        
        // Hacer las filas más altas y la fuente más grande
        tablaEventos.setRowHeight(30);
        tablaEventos.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        // Añadir todos los eventos de la lista de Datos.eventos a la tabla
        for (Evento e : Datos.eventos) {
            Object[] fila = {
                e.getTitulo(),
                e.getTipo(),
                e.getDireccion().getCiudad()
            };

            modelo.addRow(fila);
        }
        
        // Copiar la lista de todos los eventos a eventosEncontrados por si el
        // usuario no utiliza ningún filtro ni hace ninguna búsqueda
        eventosEncontrados = (ArrayList<Evento>) Datos.eventos.clone();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JavaEvents = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEventos = new javax.swing.JTable();
        campoBuscador = new javax.swing.JTextField();
        etiquetaBuscarPor = new javax.swing.JLabel();
        tipoBusqueda = new javax.swing.JComboBox<>();
        botonBuscar = new javax.swing.JButton();
        etiquetaFiltro = new javax.swing.JLabel();
        botonDetalles = new javax.swing.JButton();
        botonPerfil = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonReserva = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JavaEvents.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        JavaEvents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JavaEvents.setText("JavaEvents");

        tablaEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Tipo", "Ciudad"
            }
        ));
        jScrollPane1.setViewportView(tablaEventos);

        etiquetaBuscarPor.setText("Buscar por:");

        tipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Título", "Tipo", "Ciudad" }));
        tipoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoBusquedaActionPerformed(evt);
            }
        });

        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        etiquetaFiltro.setText("Flitro: Ninguno");

        botonDetalles.setText("Ver detalles");
        botonDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetallesActionPerformed(evt);
            }
        });

        botonPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPerfilActionPerformed(evt);
            }
        });

        jLabel1.setText("Ver perfil");

        botonReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReservaActionPerformed(evt);
            }
        });

        jLabel3.setText("Ver reservas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campoBuscador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(etiquetaBuscarPor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(160, 160, 160))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaFiltro)
                            .addComponent(botonDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JavaEvents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JavaEvents)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiquetaBuscarPor)
                        .addComponent(tipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(etiquetaFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonDetalles)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método que busca dentro de los eventos guardados aquellos que contienen
     * el texto introducido por el usuario. La búsqueda se hace en el atributo
     * de título, tipo o ciudad (dentro de dirección) del evento, dependiendo
     * del filtro que el usuario elija.
     * 
     * @param evt 
     */
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // Obtener el modelo de la tabla y borrar todas las filas
        DefaultTableModel modelo = ((DefaultTableModel) tablaEventos.getModel());
        modelo.setRowCount(0);

        // Obtener el filtro aplicado
        String filtro = tipoBusqueda.getSelectedItem().toString();

        // Borrar la lista de eventosEncontrados para llenarla con los nuevos
        eventosEncontrados.clear();

        // Añadir los eventos encontrados
        switch (filtro) {
            case "Título":
                eventosEncontrados = Buscador.buscarPorTitulo(campoBuscador.getText());
                etiquetaFiltro.setText("Filtro: Título");
                break;

            case "Tipo":
                eventosEncontrados = Buscador.buscarPorTipo(campoBuscador.getText());
                etiquetaFiltro.setText("Filtro: Tipo");
                break;

            case "Ciudad":
                eventosEncontrados = Buscador.buscarPorCiudad(campoBuscador.getText());
                etiquetaFiltro.setText("Filtro: Ciudad");
                break;
        }

        // Añadir de nuevo los eventos a la tabla
        for (Evento e : eventosEncontrados) {
            Object[] fila = {
                e.getTitulo(),
                e.getTipo(),
                e.getDireccion().getCiudad()
            };

            modelo.addRow(fila);

        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoBusquedaActionPerformed

    /**
     * Método que crea y abre una ventana con los detalles del evento que el
     * usuario tiene seleccionado al pulsar sobre el botón "Ver detalles".
     * Despúes, ajusta ciertas etiquetas de la ventana para coincidir con la
     * información del evento.
     * 
     * @param evt 
     */
    private void botonDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetallesActionPerformed
        // Obtener el modelo de la tabla
        DefaultTableModel modelo = ((DefaultTableModel) tablaEventos.getModel());

        // Ver cual es el evento que tiene elejido el usuario
        int filaElejida = tablaEventos.getSelectedRow(); // Fila seleccionada
        eventoElejido = eventosEncontrados.get(filaElejida);

        // Crear una ventana que muestre los detalles del evento
        DetallesEvento detallesEvento = new DetallesEvento();
        detallesEvento.setLocationRelativeTo(this);
        detallesEvento.setVisible(true);

        // Modificar los atributos de la ventana para que correspondan a los
        // elementos del evento seleccionado
        detallesEvento.setEtiquetaTitulo(eventoElejido.getTitulo());

        detallesEvento.setEtiquetaTipoEvento(eventoElejido.getTipo());

        String calle = eventoElejido.getDireccion().getCalle();
        int numero = eventoElejido.getDireccion().getNumero();
        String ciudad = eventoElejido.getDireccion().getCiudad();
        int codPostal = eventoElejido.getDireccion().getCodPostal();
        detallesEvento.setEtiquetaAtributosDireccion("Calle: " + calle + ", "
                + numero + ". " + "Ciudad: " + ciudad + ", " + codPostal);

        detallesEvento.setHorarios(eventoElejido.getFechasYHoras());

        detallesEvento.setPrecio(eventoElejido.getPrecioEntrada());

        try {
            detallesEvento.setImagen(eventoElejido.getPortada());
        } catch (Exception e) {
            System.out.println("Imagen no encontrada");
            detallesEvento.imagenNoEncontrada();
        }

        detallesEvento.setEventoElejido(eventoElejido);
        
        detallesEvento.setCliente(clienteActual);
    }//GEN-LAST:event_botonDetallesActionPerformed

    private void botonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPerfilActionPerformed
        Perfil perfil = new Perfil();
        perfil.setCliente(clienteActual);
        perfil.modificarDatos();
        perfil.setVisible(true);
    }//GEN-LAST:event_botonPerfilActionPerformed

    private void botonReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonReservaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusquedaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusquedaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusquedaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusquedaEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BusquedaEventos().setVisible(true);
            }
        });
    }

    public Evento getEventoElejido() {
        return eventoElejido;
    }
    
    public void setCliente(Cliente cliente) {
        this.clienteActual = cliente;
    }

    private ArrayList<Evento> eventosEncontrados;
    private Evento eventoElejido;
    private Cliente clienteActual;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JavaEvents;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonDetalles;
    private javax.swing.JButton botonPerfil;
    private javax.swing.JButton botonReserva;
    private javax.swing.JTextField campoBuscador;
    private javax.swing.JLabel etiquetaBuscarPor;
    private javax.swing.JLabel etiquetaFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEventos;
    private javax.swing.JComboBox<String> tipoBusqueda;
    // End of variables declaration//GEN-END:variables
}
