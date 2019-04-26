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
public class VCamarero extends javax.swing.JDialog {

    FachadaAplicacion fap;
    VAutenticacion vaut;
    
    public VCamarero(java.awt.Frame parent, boolean modal, FachadaAplicacion fap) {
        super(parent, modal);
        this.vaut = (VAutenticacion) parent;
        this.fap = fap;
        initComponents();
        ModeloTablaPlatos mtp = new ModeloTablaPlatos();
        this.actualizarMesas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMenu = new javax.swing.JButton();
        btnCobrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPlatos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMesas = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listBebidas = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        btnMenu.setText("VER MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnCobrar.setText("Cobrar");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Mesas");

        jLabel2.setText("Platos");

        jLabel3.setText("Bebidas");

        listPlatos.setModel(new ModeloListaStrings());
        listPlatos.setToolTipText("");
        jScrollPane1.setViewportView(listPlatos);

        listMesas.setModel(new ModeloListaStrings());
        listMesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMesasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listMesas);

        listBebidas.setModel(new ModeloListaStrings());
        jScrollPane4.setViewportView(listBebidas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel2)
                        .addGap(211, 211, 211)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenu)
                    .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
       
        fap.vistaMenu(this, Integer.parseInt(this.listMesas.getSelectedValue()));
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        fap.obtenerPlatos();
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void listMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMesasMouseClicked
        this.actualizarPlatos();
        this.actualizarBebidas();
    }//GEN-LAST:event_listMesasMouseClicked
    
    public void actualizarMesas(){
        List<Mesa> mesas;
        mesas = fap.obtenerMesas();
        int a;
        List<String> strMesas = new ArrayList();
        for(Mesa mesa : mesas){
           strMesas.add(String.valueOf(mesa.getNum_mesa()));
        }
        
        ModeloListaStrings mls;
        mls = (ModeloListaStrings) this.listMesas.getModel();
        mls.setElementos(strMesas);
    }
    public void actualizarPlatos(){
        List<Plato> platos;
        platos = fap.obtenerPlatosMesa(Integer.parseInt(this.listMesas.getSelectedValue()));
        ArrayList<String> strPlatos = new ArrayList();
        for(Plato plato : platos){
            strPlatos.add(plato.getNombre());
        }
        ModeloListaStrings mls;
        mls = (ModeloListaStrings) this.listPlatos.getModel();
        mls.setElementos(strPlatos);
    }
    public void actualizarBebidas(){
        List<Bebida> bebidas;
        bebidas = fap.obtenerBebidasMesa(Integer.parseInt(this.listMesas.getSelectedValue()));
        ArrayList<String> strPlatos = new ArrayList();
        for(Bebida bebida : bebidas){
            strPlatos.add(bebida.getNombre());
        }
        ModeloListaStrings mls;
        mls = (ModeloListaStrings) this.listBebidas.getModel();
        mls.setElementos(strPlatos);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listBebidas;
    private javax.swing.JList<String> listMesas;
    private javax.swing.JList<String> listPlatos;
    // End of variables declaration//GEN-END:variables
}
