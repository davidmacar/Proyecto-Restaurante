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
        this.txtError.setVisible(false);
        this.actualizarModelo();
    }
    private void actualizarModelo() {
        this.mesa.setBebidas((ArrayList<Bebida>)this.fap.obtenerBebidasMesa(this.mesa.getNum_mesa()));
        this.mesa.setPlatos((ArrayList<Plato>)this.fap.obtenerPlatosMesa(this.mesa.getNum_mesa()));
        
        ModeloTablaBebidas mtb = (ModeloTablaBebidas) this.tablaBebidas.getModel();
        ModeloTablaPlatos mtp = (ModeloTablaPlatos) this.tablaPlatos.getModel();
        ModeloListaStrings mls = (ModeloListaStrings) this.listPedido.getModel();
        mtb.setFilas(fap.obtenerBebidas());
        mtp.setFilas(fap.obtenerPlatos());
        ArrayList<String> pedido = new ArrayList();
        for(Plato p : fap.obtenerPlatosMesa(this.mesa.getNum_mesa())){
            pedido.add(p.getNombre());
        }
        for(Bebida b : fap.obtenerBebidasMesa(this.mesa.getNum_mesa())){
            pedido.add(b.getNombre());
        }       
        mls.setElementos(pedido);
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
        btnAnadir = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtError = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listPedido = new javax.swing.JList<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaPlatos.setModel(new ModeloTablaPlatos());
        tablaPlatos.setCellSelectionEnabled(true);
        tablaPlatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPlatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPlatos);

        panelAlimentos.addTab("Platos", jScrollPane1);

        tablaBebidas.setModel(new ModeloTablaBebidas());
        tablaBebidas.setCellSelectionEnabled(true);
        tablaBebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBebidasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBebidas);

        panelAlimentos.addTab("Bebidas", jScrollPane2);

        getContentPane().add(panelAlimentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 679, 267));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 15, -1, 30));

        btnInfo.setText("Informacion");
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        getContentPane().add(btnInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 322, -1, -1));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 287, 20));

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 99, -1));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 130, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, -1, -1));

        jLabel1.setText("Pedido mesa");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(772, 31, -1, -1));

        txtError.setForeground(new java.awt.Color(255, 0, 0));
        txtError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtError.setText("<html>Selecciona un alimento</html>");
        txtError.setAutoscrolls(true);
        txtError.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtError, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 190, 30));

        listPedido.setModel(new ModeloListaStrings());
        listPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPedidoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listPedido);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 64, 239, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed

        
        switch(this.panelAlimentos.getSelectedIndex()){
            case 0://Platos
                if(this.tablaPlatos.getSelectedColumn() == -1){
                    this.txtError.setVisible(true);
                    return;
                }
                Plato plato = ((ModeloTablaPlatos)this.tablaPlatos.getModel()).obtenerPlato(
                                this.tablaPlatos.getSelectedColumn(), this.tablaPlatos.getSelectedRow());
                this.fap.vistaProducto(this, plato);
                break;
            case 1://Bebidas
                if(this.tablaBebidas.getSelectedColumn() == -1){
                    this.txtError.setVisible(true);
                    return;
                }
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(this.listPedido.getSelectedIndex() == -1){
            this.txtError.setVisible(true);
            return;
        }
        String aux = this.listPedido.getSelectedValue();
        boolean plat = false;
        for(Plato p : mesa.getPlatos()){
            if(p.getNombre().toLowerCase().equals(aux.toLowerCase()))
                plat = true;
        }
        if(plat){
            Plato plato = null;
            for(Plato p : mesa.getPlatos()){
                if(p.getNombre().toLowerCase().equals(aux.toLowerCase())){
                     plato = p;
                }
            }
            fap.eliminarPlatoMesa(plato, this.mesa);
        }
        else{
            Bebida bebida = null;
            for(Bebida b : mesa.getBebidas()){
                if(b.getNombre().toLowerCase().equals(aux.toLowerCase()))
                    bebida = b;
            }
            fap.eliminarBebidaMesa(bebida, this.mesa);
        }
        this.actualizarModelo();
        
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    
    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
         ModeloTablaPlatos mtp = (ModeloTablaPlatos) this.tablaPlatos.getModel();
         ModeloTablaBebidas mtb = (ModeloTablaBebidas) this.tablaBebidas.getModel();
        if(this.tablaPlatos.isShowing()){
            if(this.tablaPlatos.getSelectedRow()>=0){
                mtp = (ModeloTablaPlatos) this.tablaPlatos.getModel();
                Plato p = mtp.obtenerPlato(this.tablaPlatos.getSelectedColumn(),this.tablaPlatos.getSelectedRow()); 
                Mesa m = this.mesa;
                fap.anadirPlatoMesa(p, m);
                p.setServicio(this.fap.obtenerServicioPlato(p, m));
            }
            else 
                this.txtError.setVisible(true);
        }
        
        if(this.tablaBebidas.isShowing()){
            if(this.tablaBebidas.getSelectedRow()>=0){
                mtb = (ModeloTablaBebidas) this.tablaBebidas.getModel();
                Bebida b =mtb.obtenerBebida(this.tablaBebidas.getSelectedColumn(), this.tablaBebidas.getSelectedRow()); 
                Mesa m = this.mesa;
                fap.anadirBebidaMesa(b, m);
                b.setServicio(this.fap.obtenerServicioBebida(b, m));
            }
            else 
               this.txtError.setVisible(true); 
        }
        
        this.actualizarModelo();
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void tablaPlatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPlatosMouseClicked
        this.txtError.setVisible(false);
    }//GEN-LAST:event_tablaPlatosMouseClicked

    private void tablaBebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBebidasMouseClicked
        this.txtError.setVisible(false);
    }//GEN-LAST:event_tablaBebidasMouseClicked

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        ((VCamarero)this.getParent()).actualizarMesas();
        ((VCamarero)this.getParent()).actualizarPlatos();
        ((VCamarero)this.getParent()).actualizarBebidas();
        this.dispose();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void listPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPedidoMouseClicked
        this.txtError.setVisible(false);
    }//GEN-LAST:event_listPedidoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInfo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listPedido;
    private javax.swing.JTabbedPane panelAlimentos;
    private javax.swing.JTable tablaBebidas;
    private javax.swing.JTable tablaPlatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JLabel txtError;
    // End of variables declaration//GEN-END:variables
}
