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

/**
 *
 * @author davidmacar
 */
public class VCajero extends javax.swing.JDialog {

    FachadaAplicacion fap;
    VCamarero vcam;
    Mesa mesa;
    
//    public VCajero(java.awt.Frame parent, boolean modal, FachadaAplicacion fap) {
//        super(parent, modal);
//        //this.vcam = (VCamarero) parent;
//        this.fap = fap;
//        initComponents();
//        vcam.actualizarMesas();
//    }

    VCajero(VCamarero vcam, boolean b, FachadaAplicacion fap, Mesa mesa) {
        this.fap = fap;
        initComponents();
        vcam.actualizarMesas();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMesas = new javax.swing.JList<String>();
        labCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtEntregado = new javax.swing.JTextField();
        labEntregado = new javax.swing.JLabel();
        labCambio = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCobrar.setText("Cobrar");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 100, 47));

        jLabel1.setText("Mesas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 17, -1, -1));

        listMesas.setModel(new ModeloListaStrings());
        listMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMesasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listMesas);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 48, 130, 240));

        labCantidad.setText("Cantidad");
        getContentPane().add(labCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 70, -1));
        getContentPane().add(txtEntregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 70, -1));

        labEntregado.setText("Entregado");
        getContentPane().add(labEntregado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        labCambio.setText("Cambio");
        getContentPane().add(labCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, -1, -1));
        getContentPane().add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        if(this.listMesas.isSelectionEmpty()){
            return;
        }
        //fap.obtenerPlatos();
        
        vcam.actualizarMesas();
        
        this.setVisible(false);
        vcam.setVisible(true);
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void listMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMesasMouseClicked
        Mesa mesa = fap.obtenerMesa(Integer.parseInt(this.listMesas.getSelectedValue()));
        //txtCantidad.setText(fap.precioMesa(mesa).toString);
    }//GEN-LAST:event_listMesasMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCobrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labCambio;
    private javax.swing.JLabel labCantidad;
    private javax.swing.JLabel labEntregado;
    private javax.swing.JList<String> listMesas;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtEntregado;
    // End of variables declaration//GEN-END:variables
}
