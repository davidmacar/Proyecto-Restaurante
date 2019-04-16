/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import gui.*;
import baseDatos.*;
import java.util.*;

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
        
    }
    public static void main(String[] args) {
        FachadaAplicacion fa;
        fa = new FachadaAplicacion();
    }
    
    public List<Plato> obtenerPlatos(){
        List<Plato> ret = fbd.obtenerPlatos();
        System.out.println("Hola");
        return ret;
    }
    
}
 //autenticación no es autentificación XD
