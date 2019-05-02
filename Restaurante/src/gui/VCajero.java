/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import java.util.List;
import modelos.*;
import restaurante.*;
import java.util.Locale;

/**
 *
 * @author davidmacar
 */
public class VCajero extends javax.swing.JDialog {

    private FachadaAplicacion fap;
    private VCamarero vcam;
    private float precio;
    private Mesa mesa;
    
    public VCajero(java.awt.Dialog parent, boolean modal, FachadaAplicacion fap, Mesa mesa) {
        super(parent, modal);
        this.vcam = (VCamarero) parent;
        this.fap = fap;
        initComponents();
        vcam.actualizarMesas();
        this.mesa = mesa;
        aviso.setVisible(false);
        btnCobrar.setEnabled(false);
        this.mesa=mesa;
        
        this.precio = fap.precioMesa(mesa);
        txtMesa.setText(String.valueOf(mesa.getNum_mesa()));
        txtCantidad.setText(String.format("%.2f€",this.precio));
    }


    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCobrar = new javax.swing.JButton();
        labCantidad = new javax.swing.JLabel();
        txtEntregado = new javax.swing.JTextField();
        labEntregado = new javax.swing.JLabel();
        labCambio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        aviso = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JLabel();
        txtCambio = new javax.swing.JLabel();
        txtMesa = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCobrar.setText("Cobrar");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 100, 70));

        labCantidad.setText("Cantidad:");
        getContentPane().add(labCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));
        getContentPane().add(txtEntregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 50, -1));

        labEntregado.setText("Entregado");
        getContentPane().add(labEntregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        labCambio.setText("Cambio:");
        getContentPane().add(labCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel2.setText("Mesa nº:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        btnOk.setText("OK");
        btnOk.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        getContentPane().add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, 20));

        aviso.setBackground(new java.awt.Color(255, 255, 255));
        aviso.setForeground(new java.awt.Color(255, 0, 0));
        aviso.setText("Cantidad Insuficiente");
        getContentPane().add(aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 170, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 50, 10));
        getContentPane().add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 60, 10));
        getContentPane().add(txtMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 20, 10));

        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 131, 100, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        
        //fap.eliminaMesaCobrada(mesa);
        fap.cobrarMesa(mesa, "11111111A", precio);        
        vcam.actualizarMesas();
        this.setVisible(false);
        vcam.setVisible(true);
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
        float cambio = Float.parseFloat(txtEntregado.getText()) - this.precio;
        if(cambio>=0){
            aviso.setVisible(false);
            txtCambio.setText(String.format("%.2f€", cambio)); 
            btnCobrar.setEnabled(true);
        }
        else{
            aviso.setVisible(true);
            btnCobrar.setEnabled(false);
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        //this.fap.vistFactura(this, this.mesa);
    }//GEN-LAST:event_btnFacturarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aviso;
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labCambio;
    private javax.swing.JLabel labCantidad;
    private javax.swing.JLabel labEntregado;
    private javax.swing.JLabel txtCambio;
    private javax.swing.JLabel txtCantidad;
    private javax.swing.JTextField txtEntregado;
    private javax.swing.JLabel txtMesa;
    // End of variables declaration//GEN-END:variables
}
