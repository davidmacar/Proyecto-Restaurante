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
public class GestionMesas {
    private FachadaBaseDatos fbd;
    private FachadaGui fgui;
    
    public GestionMesas(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }
    
    public java.util.List<Mesa> obtenerMesas(){
        return this.fbd.obtenerMesas();
    }
    public Mesa obtenerMesa(int mesa){
        return this.fbd.obtenerMesa(mesa);
    }
}
