/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

/**
 *
 * @author davidmacar
 */
public abstract class AbstractDAO {
    private restaurante.FachadaAplicacion fa;
    private java.sql.Connection conexion;
   
    public java.sql.Connection getConexion(){
        return this.conexion;
    }
    
    public void setConexion(java.sql.Connection conexion){
        this.conexion=conexion;
    }
   
    public void setFachadaAplicacion(restaurante.FachadaAplicacion fa){
       this.fa=fa;
    }
   
    public restaurante.FachadaAplicacion getFachadaAplicacion(){
       return fa;
    }
}
