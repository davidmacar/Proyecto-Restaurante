/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    }
    
    public java.util.List<Plato> obtenerPlatos(){
        return this.daoPlatos.obtenerPlatos();
    }
}
