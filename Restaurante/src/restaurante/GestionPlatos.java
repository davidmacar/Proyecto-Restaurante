/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.List;

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
        List<Plato> platos = fbd.obtenerPlatos();
        return platos;
    }
            
}
