/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import restaurante.*;

/**
 *
 * @author davidmacar
 */
public class DAOPlatos extends AbstractDAO{
    public DAOPlatos (Connection conexion, restaurante.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Plato> obtenerPlatos(){
        java.util.List<Plato> resultado=new java.util.ArrayList<>();
        Connection con = super.getConexion();
        PreparedStatement stmPlatos=null;
        ResultSet rsPlatos;
        
        String statement = "select id_plato, apto_veganos, apto_celiacos, tipo, descripcion " +
                           "from platos";

        try {
            stmPlatos = con.prepareStatement(statement);
            rsPlatos=stmPlatos.executeQuery();
            
            while (rsPlatos.next()){
                Plato ej = new Plato(rsPlatos.getInt("id_plato"), rsPlatos.getBoolean("apto_veganos"), 
                                        rsPlatos.getBoolean("apto_celiacos"), rsPlatos.getString("tipo"),
                                        rsPlatos.getString("descripcion"));
                resultado.add(ej);
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
        finally{
            try {
                if(stmPlatos != null) stmPlatos.close();
            }
            catch (SQLException e){
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
}
