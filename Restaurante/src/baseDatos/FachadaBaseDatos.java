/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import restaurante.*;

/**
 *
 * @author davidmacar
 */
public class FachadaBaseDatos {
    private FachadaAplicacion fap;
    private java.sql.Connection conexion;
    private DAOPlatos daoPlatos;
    private DAOBebidas daoBebidas;
    private DAOEmpleados daoEmpleados;
    private DAOIngredientes daoIngredientes;
    private DAOMesas daoMesas;
    private DAOClientes daoClientes;
    private DAOFacturas daoFacturas;
    
    public FachadaBaseDatos(FachadaAplicacion fap){
        this.fap=fap;
        Properties configuracion = new Properties();
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);

        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            //fap.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            //fap.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            //fap.muestraExcepcion(e.getMessage());
        }
        this.daoPlatos = new DAOPlatos(this.conexion, this.fap);
        this.daoEmpleados = new DAOEmpleados(this.conexion, this.fap);
        this.daoMesas = new DAOMesas(this.conexion, this.fap);
        this.daoBebidas = new DAOBebidas(this.conexion, this.fap);
        this.daoFacturas = new DAOFacturas(this.conexion, this.fap);
        this.daoClientes = new DAOClientes(this.conexion, this.fap);
    }
    
    public java.util.List<Plato> obtenerPlatos(){
        return this.daoPlatos.obtenerPlatos();
    }
    public boolean autenticar(String usuario, String password){
        return this.daoEmpleados.autenticar(usuario, password);
    }
    public Empleado obtenerCamarero(String dni){
        return this.daoEmpleados.obtenerCamarero(dni);
    }
    public java.util.List<Mesa> obtenerMesas(){
        return this.daoMesas.obtenerMesas();
    }
    public java.util.List<Plato> obtenerPlatosMesa(int mesa){
        return daoPlatos.obtenerPlatosMesa(mesa);
    }
    public java.util.List<Bebida> obtenerBebidasMesa(int mesa){
        return daoBebidas.obtenerBebidasMesa(mesa);
    }
    public Mesa obtenerMesa(int mesa){
        return daoMesas.obtenerMesa(mesa, this.obtenerPlatosMesa(mesa), this.obtenerBebidasMesa(mesa));
    }
    public java.util.List<Bebida> obtenerBebidas(){
        return daoBebidas.obtenerBebidas();
    }
    
    
    public float precioMesa(Mesa mesa){
        return daoMesas.precioMesa(mesa);
    }
    public ArrayList<Plato> buscarPlatos(String plato){
        return daoPlatos.buscarPlatos(plato);
    }
    public ArrayList<Bebida> buscarBebidas(String bebida){
        return daoBebidas.buscarBebidas(bebida);
    }

    public void eliminarPlatoMesa(Plato p, Mesa m) {
        daoPlatos.eliminarPlatoMesa(p, m);
    }

    public void anadirPlatoMesa(Plato p, Mesa m) {
        daoPlatos.anadirPlatoMesa(p, m);
    }

    public void anadirBebidaMesa(Bebida b, Mesa m) {
        daoBebidas.anadirBebidaMesa(b, m);
    }
    
    public void eliminarBebidaMesa(Bebida b, Mesa m){
        daoBebidas.eliminarBebidaMesa(b, m);
    }
    public int obtenerServicioPlato(Plato plato, Mesa m){   
        return daoPlatos.obtenerServicioPlato(plato, m);
    }
    public int obtenerServicioBebida(Bebida bebida, Mesa m){   
        return daoBebidas.obtenerServicioBebida(bebida, m);
    }
    
    public int cobrarMesa(Mesa mesa, String camarero, Float precio) {
        return daoMesas.cobrarMesa(mesa, camarero , precio);
    }

    public void eliminarMesaCobrada(Mesa mesa) {
        daoMesas.eliminarMesaCobrada(mesa);
    }


    public List<Factura> obtenerFacturas(int id, String cliente) {
        return daoFacturas.obtenerFacturas(id, cliente);
    }

    public List<Factura> obtenerFacturas() {
        return daoFacturas.obtenerFacturas();
    }
    public String obtenerFechaActual(){
        return this.daoFacturas.obtenerFechaActual();
    }
    public String obtenerIdFactura(){
        return this.daoFacturas.obtenerIdFactura();
    }
    public void anadirFactura(Factura fact){
        //this.daoFacturas.anadirFactura(fact);
    }
    public void anadirCliente(Cliente cli){
        //this.daoClientes.anadirCliente(cli);
    }
    
    public Cliente obtenerCliente(String dni){
        return this.daoClientes.obtenerCliente(dni);
    }

}
