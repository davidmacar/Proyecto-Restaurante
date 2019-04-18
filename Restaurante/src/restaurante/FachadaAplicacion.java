/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import gui.*;
import baseDatos.*;
import java.util.List;


/**
 *
 * @author davidmacar
 */
public class FachadaAplicacion {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    GestionPlatos gp;
    
    public FachadaAplicacion(){
        this.fbd = new FachadaBaseDatos(this);
        this.fgui = new FachadaGui(this);
        gp = new GestionPlatos(this.fgui, this.fbd);
    }
    
    public static void main(String[] args) {
        FachadaAplicacion fa;
        fa = new FachadaAplicacion();
        fa.iniciaInterfaz();
    }
    
    public void iniciaInterfaz(){
        this.fgui.iniciaInterfaz();
    }
    
    public List<Plato> obtenerPlatos(){
        List<Plato> ret = gp.obtenerPlatos();
        return ret;
    }
    
    public void vistaCamarero(){
        this.fgui.vistaCamarero();   
    }
    
}
 //autenticación no es autentificación XD
