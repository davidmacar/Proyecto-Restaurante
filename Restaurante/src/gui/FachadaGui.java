/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import restaurante.*;

/**
 *
 * @author davidmacar
 *   
 */
public class FachadaGui extends IOException{
    FachadaAplicacion fap;
    VAutenticacion vac;
    
    public FachadaGui(FachadaAplicacion fap){
        this.fap = fap;
        this.vac = new VAutenticacion(fap);
    }
    
    public void iniciaInterfaz(){
        this.vac.setVisible(true);
    }
    public void vistaCamarero(){
        try {
            VCamarero vcam = new VCamarero(this.vac, true, this.fap);
            vcam.setVisible(true);
            this.vac.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(FachadaGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void vistaMenu(VCamarero vcam, Mesa mesa){
        VMenu vmen = new VMenu(vcam, true, this.fap, mesa);
        vmen.setVisible(true);
    }
    public void vistaProducto(javax.swing.JDialog ventana, Object obj){
        VProducto vprod = new VProducto(ventana, true, fap, obj);
        vprod.setVisible(true);
    }
    
    

    public void vistaCajero(VCamarero vcam, Mesa mesa) {
        VCajero vcaj = new VCajero(vcam, true, this.fap, mesa);
        vcaj.setVisible(true);
    }

    public void vistaFactura(VCamarero vcam) {
        VHistorialFacturas vhistfact = new VHistorialFacturas(vcam, true, this.fap);
        vhistfact.setVisible(true);
    }
}
