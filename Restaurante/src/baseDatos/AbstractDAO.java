/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import restaurante.FachadaAplicacion;

/**
 *
 * @author davidmacar
 */
public abstract class AbstractDAO {
   private restaurante.FachadaAplicacion fa;
   private java.sql.Connection conexion;

   
    protected java.sql.Connection getConexion(){
        return this.conexion;
    }
    
    protected void setConexion(java.sql.Connection conexion){
        this.conexion=conexion;
    }
   
   protected void setFachadaAplicacion(restaurante.FachadaAplicacion fa){
       this.fa=fa;
   }
   
   protected restaurante.FachadaAplicacion getFachadaAplicacion(){
       return fa;
   }
   
}
