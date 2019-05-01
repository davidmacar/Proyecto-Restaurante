/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.ArrayList;

/**
 *
 * @author davidmacar
 */
public class GestionBebidas {
    private FachadaBaseDatos fbd;
    private FachadaGui fgui;
    
    public GestionBebidas(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }
    public java.util.List<Bebida> obtenerBebidasMesa(int mesa){
        return this.fbd.obtenerBebidasMesa(mesa);
    }
    public java.util.List<Bebida> obtenerBebidas(){
        return this.fbd.obtenerBebidas();
    }
    public ArrayList<Bebida> buscarBebidas(String bebida){
        return fbd.buscarBebidas(bebida);
    }
    public void eliminarBebidaMesa(Bebida b, Mesa m){
        fbd.eliminarBebidaMesa(b, m);
    }
    public void anadirBebidaMesa(Bebida b, Mesa m) {
        fbd.anadirBebidaMesa(b, m);
    }
    public int obtenerServicioBebida(Bebida bebida, Mesa m){   
        return fbd.obtenerServicioBebida(bebida, m);
    }
}
