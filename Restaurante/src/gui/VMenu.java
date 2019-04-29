/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import modelos.*;
import restaurante.Bebida;
import restaurante.FachadaAplicacion;
import restaurante.Mesa;
import restaurante.Plato;




/**
 *
 * @author davidmacar
 */
public class VMenu extends javax.swing.JDialog {

    FachadaAplicacion fap;
    VCamarero vcam;
    Mesa mesa;
    
    public VMenu(java.awt.Dialog parent, boolean modal,FachadaAplicacion fap, Mesa mesa) {
        super(parent,modal);
        this.vcam = (VCamarero) parent;
        this.fap = fap;
        this.mesa = mesa;
        initComponents();
        this.actualizarModelo();
    }
    private void actualizarModelo() {

        ModeloTablaBebidas mtb = (ModeloTablaBebidas) tablaBebidas.getModel();
        ModeloTablaPlatos mtp = (ModeloTablaPlatos) this.tablaPlatos.getModel();
        mtb.setFilas(fap.obtenerBebidas());
        mtp.setFilas(fap.obtenerPlatos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAlimentos = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBebidas = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnInfo = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaPlatos.setModel(new ModeloTablaPlatos());
        jScrollPane1.setViewportView(tablaPlatos);

        panelAlimentos.addTab("Platos", jScrollPane1);

        tablaBebidas.setModel(new ModeloTablaBebidas());
        jScrollPane2.setViewportView(tablaBebidas);

        panelAlimentos.addTab("Bebidas", jScrollPane2);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnInfo.setText("Informacion");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInfo)
                .addGap(93, 93, 93)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAlimentos, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnAnadir)
                    .addComponent(btnConfirmar)
                    .addComponent(btnInfo)
                    .addComponent(btnEliminar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed

        
        switch(this.panelAlimentos.getSelectedIndex()){
            case 0://Platos
                Plato plato = ((ModeloTablaPlatos)this.tablaPlatos.getModel()).obtenerPlato(
                                this.tablaPlatos.getSelectedColumn(), this.tablaPlatos.getSelectedRow());
                this.fap.vistaProducto(this, plato);
                break;
            case 1://Bebidas
                Bebida bebida = ((ModeloTablaBebidas)this.tablaBebidas.getModel()).obtenerBebida(
                                this.tablaBebidas.getSelectedColumn(), this.tablaBebidas.getSelectedRow());
                this.fap.vistaProducto(this, bebida);
                break;
        }
        
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ModeloTablaBebidas mtb = (ModeloTablaBebidas) this.tablaBebidas.getModel();
        ModeloTablaPlatos mtp = (ModeloTablaPlatos) this.tablaPlatos.getModel();
        ArrayList<Bebida> bebidas;
        ArrayList<Plato> platos;
        platos = this.fap.buscarPlatos(this.txtBuscar.getText());
        bebidas = this.fap.buscarBebidas(this.txtBuscar.getText());
        mtb.setFilas(bebidas);
        mtp.setFilas(platos);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        this.setVisible(false);
        vcam.setVisible(true);
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        ModeloTablaPlatos mtp = (ModeloTablaPlatos) this.tablaPlatos.getModel();
        if(tablaPlatos.getSelectedRow()>=0){
            mtp = (ModeloTablaPlatos) tablaPlatos.getModel();
           //Plato p = mtp.obtenerPlato(tablaPlatos.getSelectedRow());
           fap.eliminarPlato(p);
    }//GEN-LAST:event_btnEliminarActionPerformed
    }
    
    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // TODO add your handling code here:
         ModeloTablaPlatos mtp = (ModeloTablaPlatos) this.tablaPlatos.getModel();
        if(tablaPlatos.getSelectedRow()>=0){
            mtp = (ModeloTablaPlatos) tablaPlatos.getModel();
           //Plato p = mtp.obtenerPlato(tablaPlatos.getSelectedRow());
           fap.anadirPlato(p);
    }    
    }//GEN-LAST:event_btnAnadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane panelAlimentos;
    private javax.swing.JTable tablaBebidas;
    private javax.swing.JTable tablaPlatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
