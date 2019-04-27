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
    GestionBebidas gb;
    GestionMesas gm;
    GestionEmpleados ge;
    
    public FachadaAplicacion(){
        this.fbd = new FachadaBaseDatos(this);
        this.fgui = new FachadaGui(this);
        this.gp = new GestionPlatos(this.fgui, this.fbd);
        this.gb = new GestionBebidas(this.fgui, this.fbd);
        this.gm = new GestionMesas(this.fgui, this.fbd);
        this.ge = new GestionEmpleados(this.fgui, this.fbd);
    }
    public static void main(String[] args) {
        FachadaAplicacion fa;
        fa = new FachadaAplicacion();
        fa.iniciaInterfaz();
    }
    
    public void iniciaInterfaz(){
        this.fgui.iniciaInterfaz();
    }
    public void vistaCamarero(){
        this.fgui.vistaCamarero();
        
    }
    public void vistaMenu(VCamarero vcam, Mesa mesa){
        this.fgui.vistaMenu(vcam, mesa);
    }
    public void vistaProducto(javax.swing.JDialog ventana, Object obj){
        this.fgui.vistaProducto(ventana, obj);
    }

    public boolean autenticar(String usuario, String password){
        return this.ge.autenticar(usuario, password);
    }
    public List<Plato> obtenerPlatos(){
        List<Plato> ret = gp.obtenerPlatos();
        return ret;
    }
    public Empleado obtenerCamarero(String dni){
        return ge.obtenerCamarero(dni);
    }
    public java.util.List<Mesa> obtenerMesas(){
        return gm.obtenerMesas();
    }
    public java.util.List<Plato> obtenerPlatosMesa(int mesa){
        return gp.obtenerPlatosMesa(mesa);
    }
    public java.util.List<Bebida> obtenerBebidasMesa(int mesa){
        return gb.obtenerBebidasMesa(mesa);
    }
    public Mesa obtenerMesa(int mesa){
        return gm.obtenerMesa(mesa);
    }
    public java.util.List<Bebida> obtenerBebidas(){
        return gb.obtenerBebidas();
    }
    
    //public fap.precioMesa(mesa)
    
}
