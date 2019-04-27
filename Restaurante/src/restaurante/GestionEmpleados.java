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
public class GestionEmpleados {
    private FachadaBaseDatos fbd;
    private FachadaGui fgui;
    
    public GestionEmpleados(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fbd = fbd;
        this.fgui = fgui;
    }
    
    public void vistaCamarero(){
        this.fgui.vistaCamarero();
        
    }
    public void vistaMenu(VCamarero vcam, Mesa mesa){
        this.fgui.vistaMenu(vcam, mesa);
    }
    public Empleado obtenerCamarero(String dni){
        return this.fbd.obtenerCamarero(dni);
    }
    public boolean autenticar(String usuario, String password){
        return this.fbd.autenticar(usuario, password);
    }
}
