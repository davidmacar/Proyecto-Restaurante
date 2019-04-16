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
 */
public class FachadaGui {
    FachadaAplicacion fap;
    VAutenticacion vac;
    
    public FachadaGui(FachadaAplicacion fap){
        this.fap = fap;
        
        this.vac = new VAutenticacion(fap);
        fap.obtenerPlatos();
        vac.setVisible(true);
    }
    
}
