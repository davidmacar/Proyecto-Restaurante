/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import gui.*;
import baseDatos.*;
import java.util.*;
import javax.swing.UIManager;

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
    GestionClientes gc;
    GestionFacturas gf;
    
    public FachadaAplicacion(){
        this.fbd = new FachadaBaseDatos(this);
        this.fgui = new FachadaGui(this);
        this.gp = new GestionPlatos(this.fgui, this.fbd);
        this.gb = new GestionBebidas(this.fgui, this.fbd);
        this.gm = new GestionMesas(this.fgui, this.fbd);
        this.ge = new GestionEmpleados(this.fgui, this.fbd);
        this.gf = new GestionFacturas(this.fgui, this.fbd);
        this.gc = new GestionClientes(this.fgui, this.fbd);
    }
    public static void main(String[] args) {
        FachadaAplicacion fa;
        
        try{
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception e){ System.err.println("Error cambiando el tema.");}
     
        fa = new FachadaAplicacion();
        fa.iniciaInterfaz();
    }
    
    public void iniciaInterfaz(){
        this.fgui.iniciaInterfaz();
    }
    public void vistaCamarero(Empleado camarero){
        this.fgui.vistaCamarero(camarero);
        
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
    public ArrayList<Plato> buscarPlatos(String plato){
        return gp.buscarPlatos(plato);
    }
    public ArrayList<Bebida> buscarBebidas(String bebida){
        return gb.buscarBebidas(bebida);
    }

    
    public float precioMesa(Mesa mesa){
        return gm.precioMesa(mesa);
    }
    
    public void vistaCajero(VCamarero vcam, Mesa mesa, Empleado emp) {
        this.fgui.vistaCajero(vcam, mesa, emp);
    }

    public void eliminarPlatoMesa(Plato p, Mesa m) {
        gp.eliminarPlatoMesa(p, m);
    }

    public void anadirPlatoMesa(Plato p, Mesa m) {
        gp.anadirPlatoMesa(p, m);
    }

    public void anadirBebidaMesa(Bebida b, Mesa m) {
        gb.anadirBebidaMesa(b, m);
    }
    public void eliminarBebidaMesa(Bebida b, Mesa m) {
        gb.eliminarBebidaMesa(b, m);
    }
    public int obtenerServicioPlato(Plato plato, Mesa m){   
        return gp.obtenerServicioPlato(plato, m);
    }
    public int obtenerServicioBebida(Bebida bebida, Mesa m){   
        return gb.obtenerServicioBebida(bebida, m);
    }

    public int cobrarMesa(Mesa mesa, String camarero, Float precio) {
        return gm.cobrarMesa(mesa, camarero , precio);
    }

    public void eliminaMesaCobrada(Mesa mesa) {
        gm.eliminarMesaCobrada(mesa);
    }

    public void vistaFactura(javax.swing.JDialog vcam) {
        this.fgui.vistaFactura(vcam);
    }
    
    /*public java.util.List<Factura> obtenerFacturas(int id, String cliente){
        return gf.obtenerFacturas(id, cliente);
    }*/
     
    public java.util.List<Factura> obtenerFacturas(){
        return gf.obtenerFacturas();
    }
    public void vistaFactura(javax.swing.JDialog ventana, int mesa, int servicio, float precio){
        this.fgui.vistaFactura(ventana, mesa, servicio, precio);
    }
    public String obtenerFechaActual(){
        return this.gf.obtenerFechaActual();
    }
    public String obtenerIdFactura(){
        return this.gf.obtenerIdFactura();
    }
    public void anadirFactura(Factura fact){
        this.gf.anadirFactura(fact);
    }
    public void anadirCliente(Cliente cli){
        this.gc.anadirCliente(cli);
    }
    
    public Cliente obtenerCliente(String dni){
        return this.gc.obtenerCliente(dni);
    }
    
    public ArrayList<Factura> obtenerFacturasIdCliente(String id, String cliente){
        return this.gf.obtenerFacturasIdCliente(id, cliente);
    }
    public ArrayList<Factura> obtenerFacturasCliente(String cliente){
        return this.gf.obtenerFacturasCliente(cliente);
    }
    public ArrayList<Factura> obtenerFacturasId(String id){
        return this.gf.obtenerFacturasId(id);
    }
    
    public void VElegirFactura(java.awt.Dialog parent, Factura factura) {
        this.fgui.VElegirFactura(parent, factura);
    }
    
}
