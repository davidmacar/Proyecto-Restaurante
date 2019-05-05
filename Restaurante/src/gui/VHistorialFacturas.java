/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import modelos.ModeloTablaClientes;
import modelos.ModeloTablaFacturas;
import restaurante.FachadaAplicacion;
import restaurante.Factura;

/**
 *
 * @author alumnogreibd
 */
public class VHistorialFacturas extends javax.swing.JDialog {
    
    private FachadaAplicacion fap;
    private VCamarero vcam;

    /**
     * Creates new form VFactura
     */
    public VHistorialFacturas(java.awt.Dialog parent, boolean modal, FachadaAplicacion fap) {
        super(parent, modal);
        this.vcam = (VCamarero) parent;
        this.fap = fap;
        initComponents();
        this.actualizarModelo();
    }

    private void actualizarModelo() {
        ModeloTablaFacturas mtf = (ModeloTablaFacturas) this.tablaFacturas.getModel();
        mtf.setFilas(fap.obtenerFacturas());
    }
    
    private void actualizarModelo(ArrayList<Factura> facturas) {
        ModeloTablaFacturas mtf = (ModeloTablaFacturas) this.tablaFacturas.getModel();
        mtf.setFilas(facturas);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarId = new javax.swing.JTextField();
        txtBuscarCliente = new javax.swing.JTextField();
        btnBuscarFactura = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        btnSalirFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Cliente");

        txtBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarIdActionPerformed(evt);
            }
        });

        btnBuscarFactura.setText("Buscar");
        btnBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFacturaActionPerformed(evt);
            }
        });

        tablaFacturas.setModel(new ModeloTablaFacturas());
        jScrollPane1.setViewportView(tablaFacturas);

        btnSalirFactura.setText("Salir");
        btnSalirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btnBuscarFactura))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(544, 544, 544)
                .addComponent(btnSalirFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarFactura))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalirFactura))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarIdActionPerformed

    private void btnBuscarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFacturaActionPerformed
        // TODO add your handling code here:
        ArrayList<Factura> facturas = new ArrayList();
        if(this.txtBuscarId.getText() != null && !this.txtBuscarId.getText().equals("")
                && this.txtBuscarCliente.getText() != null && !this.txtBuscarCliente.getText().equals("")){
            facturas = this.fap.obtenerFacturasIdCliente(txtBuscarId.getText(), this.txtBuscarCliente.getText());
        }
        else if(this.txtBuscarId.getText() != null && !this.txtBuscarId.getText().equals("")){
            facturas = this.fap.obtenerFacturasId(this.txtBuscarId.getText());
        }
        else if(this.txtBuscarCliente.getText() != null && !this.txtBuscarCliente.getText().equals("")){
            facturas = this.fap.obtenerFacturasCliente(this.txtBuscarCliente.getText());
        }
        else{
            facturas = (ArrayList) this.fap.obtenerFacturas();
        }
        this.actualizarModelo(facturas);

    }//GEN-LAST:event_btnBuscarFacturaActionPerformed

    private void btnSalirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirFacturaActionPerformed
        //this.setVisible(false);
    }//GEN-LAST:event_btnSalirFacturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarFactura;
    private javax.swing.JButton btnSalirFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JTextField txtBuscarCliente;
    private javax.swing.JTextField txtBuscarId;
    // End of variables declaration//GEN-END:variables
}
