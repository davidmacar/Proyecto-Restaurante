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

    void eliminarPlatoMesa(Plato p, Mesa m) {
        fbd.eliminarPlatoMesa(p, m);
    }

    void anadirPlatoMesa(Plato p, Mesa m) {
        fbd.anadirPlatoMesa(p, m);
    }
    public int obtenerServicioPlato(Plato plato, Mesa m){   
        return fbd.obtenerServicioPlato(plato, m);
    }
    public int obtenerServicioBebida(Bebida bebida, Mesa m){   
        return fbd.obtenerServicioBebida(bebida, m);
    }
    
            
}
