/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import modelos.*;
import restaurante.*;

/**
 *
 * @author davidmacar
 */
public class VCamarero extends javax.swing.JDialog {

    FachadaAplicacion fap;
    VAutenticacion vaut;
    
    public VCamarero(java.awt.Frame parent, boolean modal, FachadaAplicacion fap) throws IOException {
        super(parent, modal);
        this.vaut = (VAutenticacion) parent;
        this.fap = fap;
        initComponents();
        this.txtError.setVisible(false);
        ModeloTablaPlatos mtp = new ModeloTablaPlatos();
        this.actualizarMesas();
        
        ImageIcon image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Imagenes/menu.png")));
        Image img = image.getImage();
        Image img2 = img.getScaledInstance(this.btnMenu.getWidth() - 15, this.btnMenu.getHeight() - 20, Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(img2);
        this.btnMenu.setIcon(i);
        
        ImageIcon image2 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../Imagenes/cobrar.png")));
        Image img3 = image2.getImage();
        Image img4 = img3.getScaledInstance(this.btnCobrar.getWidth() - 15, this.btnCobrar.getHeight() - 20, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(img4);
        this.btnCobrar.setIcon(i2);
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
        txtError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

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

        txtError.setForeground(new java.awt.Color(255, 0, 0));
        txtError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtError.setText("<html>Selecciona una mesa primero</html>");
        txtError.setAutoscrolls(true);
        txtError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel2)
                        .addGap(296, 296, 296)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(311, 311, 311)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        if(this.listMesas.isSelectionEmpty()){
            this.txtError.setVisible(true);
            return;
        }
        Mesa mesa = fap.obtenerMesa(Integer.parseInt(this.listMesas.getSelectedValue()));
        for(Plato p : mesa.getPlatos()){
            
            p.setServicio(this.fap.obtenerServicioPlato(p, mesa));
        }
        for(Bebida b : mesa.getBebidas()){
            b.setServicio(this.fap.obtenerServicioBebida(b, mesa));
        }
        fap.vistaMenu(this, mesa);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        if(this.listMesas.isSelectionEmpty()){
            this.txtError.setVisible(true);
            return;
        }
        Mesa mesa = fap.obtenerMesa(Integer.parseInt(this.listMesas.getSelectedValue()));
        fap.vistaCajero(this, mesa);
       
        listMesas.setSelectedIndex(0);
        actualizarPlatos();
        actualizarBebidas();
        
        
        
        
        
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void listMesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMesasMouseClicked
        this.txtError.setVisible(false);
        this.actualizarPlatos();
        this.actualizarBebidas();
    }//GEN-LAST:event_listMesasMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        exit(0);
        //this.getParent().setVisible(true);
    }//GEN-LAST:event_formWindowClosed
    
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
    private javax.swing.JLabel txtError;
    // End of variables declaration//GEN-END:variables
}
