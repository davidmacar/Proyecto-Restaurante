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
        super(parent,modal);
        //this.vcam = (VCamarero) parent;
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
        getContentPane().setLayout(null);

        jLabel1.setText("ID:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(31, 21, 28, 25);

        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(235, 26, 50, 15);

        txtBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscarId);
        txtBuscarId.setBounds(71, 24, 146, 19);
        getContentPane().add(txtBuscarCliente);
        txtBuscarCliente.setBounds(303, 24, 146, 19);

        btnBuscarFactura.setText("Buscar");
        btnBuscarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFacturaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarFactura);
        btnBuscarFactura.setBounds(556, 21, 82, 25);

        tablaFacturas.setModel(new ModeloTablaFacturas());
        jScrollPane1.setViewportView(tablaFacturas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(12, 52, 626, 282);

        btnSalirFactura.setText("Salir");
        btnSalirFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirFacturaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalirFactura);
        btnSalirFactura.setBounds(572, 352, 66, 25);

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
        
        /*actualizarModelo();
        if (mtf.getRowCount() > 0) {
            tablaFacturas.setRowSelectionInterval(0, 0);

        }*/

    }//GEN-LAST:event_btnBuscarFacturaActionPerformed
/**/
    private void btnSalirFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirFacturaActionPerformed
        this.setVisible(false);
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
