/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante.vistas;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyectorestaurante.AccesoAdatos.MesaData;
import proyectorestaurante.AccesoAdatos.PedidoData;
import proyectorestaurante.AccesoAdatos.ProductoData;
import proyectorestaurante.entidades.Mesa;
import proyectorestaurante.entidades.Pedido;
import proyectorestaurante.entidades.Producto;

/**
 *
 * @author pc
 */
public class PedidosEstado extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    /**
     * Creates new form PedidosEstado
     */
    private MesaData mesa = new MesaData();
    private PedidoData pedidoData = new PedidoData();
    private ProductoData productoData = new ProductoData();
    private Mesa mesa1 = new Mesa();
    private ArrayList<Mesa> listaMesas;
    private ArrayList<Pedido> listaPedidos;
    private LocalDate fechaPedido = LocalDate.now();

    public PedidosEstado() {
        initComponents();
        jCfecha.setDate(Date.valueOf(LocalDate.now()));
        armarCabecera();
        cargarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jCfecha = new com.toedter.calendar.JDateChooser();
        buscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estado del Pedido");

        entregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectorestaurante/recursos/editar.png"))); // NOI18N
        entregar.setText("Entregar");
        entregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entregarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectorestaurante/recursos/eliminar_1.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        combo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mesa:");

        tabla.setBackground(new java.awt.Color(255, 153, 102));
        tabla.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectorestaurante/recursos/lupa_1.png"))); // NOI18N
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectorestaurante/recursos/pedido-en-linea.png"))); // NOI18N
        jLabel3.setText("Gestion de Pedidos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(entregar)
                        .addGap(46, 46, 46)
                        .addComponent(eliminar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jCfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buscar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jCfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addComponent(buscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entregar)
                    .addComponent(eliminar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entregarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                Pedido pedido = pedidoData.buscarPedidoCodigo((int) modelo.getValueAt(fila, 0));
                if (pedido != null) {
                    if (pedido.isEstado() == false) {
                        pedido.setEstado(true);
                        pedidoData.modificarPedido(pedido);
                        borrarFilas();
                        armarTabla(fechaPedido);
                    } else {
                        JOptionPane.showMessageDialog(this, "Seleccione un pedido pendiente.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pedido no encontrado.");

            }
        } catch (Exception ex) {
         
            JOptionPane.showMessageDialog(null, "Error al entregar el pedido: " + ex.getMessage());
            //TIRA ERROR : NULL
        }


    }//GEN-LAST:event_entregarActionPerformed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        try {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                Pedido pedido = pedidoData.buscarPedidoCodigo((int) modelo.getValueAt(fila, 0));
                if (pedido.isEstado() == false) {
                    stock(pedido);
                    pedidoData.eliminarPedido(pedido.getIdPedido());
                    borrarFilas();
                    armarTabla(fechaPedido);
                } else {
                    JOptionPane.showMessageDialog(this, "Seleccione un pedido pendiente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una fila de la tabla.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el pedido: " + ex.getMessage());
        }

    }//GEN-LAST:event_eliminarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        try {
            mesa1 = (Mesa) combo.getSelectedItem();
            if (mesa != null) {
                LocalDate fechaPedido = jCfecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                borrarFilas();
                armarTabla(fechaPedido);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una mesa.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar pedidos: " + ex.getMessage());
        }
    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<Object> combo;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton entregar;
    private com.toedter.calendar.JDateChooser jCfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    private void cargarCombo() {
        listaMesas = (ArrayList<Mesa>) mesa.listarMesas();
        for (Mesa m : listaMesas) {
            combo.addItem(m);
        }
    }

    private void armarCabecera() {
        ArrayList<Object> columnas = new ArrayList<>();
        modelo.addColumn("Id Pedido");
        modelo.addColumn("Fecha");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio unidad");
        modelo.addColumn("Total");
        modelo.addColumn("Estado");
        tabla.setModel(modelo);
    }

    private void borrarFilas() {
        int filas = tabla.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            modelo.removeRow(f);
        }

    }

    private String Estado(Pedido pedido) {
        String estado;
        if (pedido.isEstado() == true) {
            if (pedido.isEstadoPago() == true) {
                estado = "Pago";
            } else {
                estado = "Entregado";
            }
        } else {
            estado = "Pendiente";
        }
        return estado;
    }

    private void armarTabla(LocalDate fecha) {
        listaPedidos = (ArrayList<Pedido>) pedidoData.BuscarPedidosEntreHora(mesa1.getIdMesa(), LocalTime.of(06, 00), LocalTime.of(23, 00), fecha);
        for (Pedido pedido : listaPedidos) {
            Producto producto = productoData.buscarProductoporId(pedido.getIdProducto());
            String nombre = producto.getNombreProducto();
            int precio = producto.getPrecio();
            modelo.addRow(new Object[]{pedido.getIdPedido(), pedido.getFechaPedido(), nombre, pedido.getCantidadProducto(), precio, precio * pedido.getCantidadProducto(), Estado(pedido)});
        }
    }

    private void stock(Pedido pe) {
        Producto producto = productoData.buscarProductoporId(pe.getIdProducto());
        producto.setStock(producto.getStock() + pe.getCantidadProducto());
        productoData.modificarProducto(producto);
    }
}
