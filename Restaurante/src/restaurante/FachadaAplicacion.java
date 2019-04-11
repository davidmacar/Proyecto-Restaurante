/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import gui.*;
import baseDatos.*;

/**
 *
 * @author davidmacar
 */
public class FachadaAplicacion {
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
    public FachadaAplicacion(){
        this.fgui = new FachadaGui(this);
        this.fbd = new FachadaBaseDatos(this);
        
    }
    public static void main(String[] args) {
        VAutenticacion va = new VAutenticacion();
        va.setVisible(true);
    }
    //hola mundo!
    que onda way que pasa
            aqui 
}
 //autenticación no es autentificación XD
