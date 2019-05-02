/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import gui.VCamarero;

/**
 *
 * @author davidmacar
 */
public class GestionClientes {
    private FachadaBaseDatos fbd;
    private FachadaGui fgui;
    
    public GestionClientes(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }

}
