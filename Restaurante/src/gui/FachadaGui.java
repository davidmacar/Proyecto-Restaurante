/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.*;
import restaurante.*;

/**
 *
 * @author davidmacar
 *   
 */
public class FachadaGui {
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
        VCamarero vcam = new VCamarero(this.vac, true, this.fap);
        vcam.setVisible(true);
        this.vac.setVisible(false);
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


    
    
}
