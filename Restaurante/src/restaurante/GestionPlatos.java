/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.*;

/**
 *
 * @author davidmacar
 */
public class GestionPlatos {
    private FachadaBaseDatos fbd;
    private FachadaGui fgui;
    
    public GestionPlatos(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }
    
    public List<Plato> obtenerPlatos(){
        return this.fbd.obtenerPlatos();
    }
    
    public java.util.List<Plato> obtenerPlatosMesa(int mesa){
        return this.fbd.obtenerPlatosMesa(mesa);
    }
    public ArrayList<Plato> buscarPlatos(String plato){
        return fbd.buscarPlatos(plato);
    }
    
            
}
