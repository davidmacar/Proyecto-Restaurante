/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import gui.VCamarero;
import gui.VHistorialFacturas;
import java.util.List;

/**
 *
 * @author davidmacar
 */
public class GestionFacturas {
    private FachadaBaseDatos fbd;
    private FachadaGui fgui;
    
    public GestionFacturas(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }

    List<Factura> obtenerFacturas() {
        return this.fbd.obtenerFacturas();
    }

}
