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
import java.util.ArrayList;
import java.util.Calendar;
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

    public java.util.List<Factura> obtenerFacturas() {
        return this.fbd.obtenerFacturas();
    }
    public String obtenerFechaActual(){
        return this.fbd.obtenerFechaActual();
    }
    public String obtenerIdFactura(){
        return this.fbd.obtenerIdFactura();
    }
    public void anadirFactura(Factura fact){
        this.fbd.anadirFactura(fact);
    }
    public ArrayList<Factura> obtenerFacturasIdCliente(String id, String cliente){
        return this.fbd.obtenerFacturasIdCliente(id, cliente);
    }
    public ArrayList<Factura> obtenerFacturasCliente(String cliente){
        return this.fbd.obtenerFacturasCliente(cliente);
    }
    public ArrayList<Factura> obtenerFacturasId(String id){
        return this.fbd.obtenerFacturasId(id);
    }
    

}
