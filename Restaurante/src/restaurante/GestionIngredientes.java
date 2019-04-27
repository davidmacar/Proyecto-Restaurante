/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author davidmacar
 */
public class GestionIngredientes {
     private FachadaBaseDatos fbd;
    private FachadaGui fgui;
    
    public GestionIngredientes(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }
}
