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
import java.util.ArrayList;
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
        java.util.List<Plato> resultado=new java.util.ArrayList<Plato>();
        Connection con;
        PreparedStatement stmPlatos=null;
        String statement = "select nombre, apto_veganos, apto_celiacos, tipo, descripcion " +
                            "from platos";
        ResultSet rsPlatos;

        con=super.getConexion();

        try {
        stmPlatos =con.prepareStatement(statement);
        rsPlatos=stmPlatos.executeQuery();
        while (rsPlatos.next())
        {
            Plato ej = new Plato(rsPlatos.getString("nombre"), rsPlatos.getBoolean("apto_veganos"), 
                                    rsPlatos.getBoolean("apto_celiacos"), rsPlatos.getString("tipo"),
                                    rsPlatos.getString("descripcion"));
            resultado.add(ej);
        }


        } catch (SQLException e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmPlatos.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        return resultado;
    }
    
    public java.util.List<Plato> obtenerPlatosMesa(int mesa){      
        java.util.List<Plato> resultado=new java.util.ArrayList<Plato>();
        Connection con;
        PreparedStatement stmPlatos=null;
        String statement = "select p.nombre, p.apto_veganos, p.apto_celiacos, p.tipo, p.descripcion " +
                            "from tenerplato as t, platos as p " +
                            "where t.plato = p.nombre and t.mesa = ?";
        ResultSet rsPlatos;

        con=super.getConexion();

        try {
        stmPlatos =con.prepareStatement(statement);
        stmPlatos.setInt(1,mesa);
        rsPlatos=stmPlatos.executeQuery();
        while (rsPlatos.next())
        {
            Plato ej = new Plato(rsPlatos.getString("nombre"), rsPlatos.getBoolean("apto_veganos"), 
                                    rsPlatos.getBoolean("apto_celiacos"), rsPlatos.getString("tipo"),
                                    rsPlatos.getString("descripcion"));
            resultado.add(ej);
        }


        } catch (SQLException e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmPlatos.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        return resultado;
    }
    
    public ArrayList<Plato> buscarPlatos(String plato){      
        ArrayList<Plato> resultado=new java.util.ArrayList<Plato>();
        Connection con;
        PreparedStatement stmPlatos=null;
        String statement = "select nombre, apto_veganos, apto_celiacos, tipo, descripcion " +
                            "from platos " + 
                            "where lower(nombre) like lower(?)";
        ResultSet rsPlatos;

        con=super.getConexion();

        try {
        stmPlatos =con.prepareStatement(statement);
        stmPlatos.setString(1, new String("%" + plato + "%"));
        rsPlatos=stmPlatos.executeQuery();
        while (rsPlatos.next())
        {
            Plato ej = new Plato(rsPlatos.getString("nombre"), rsPlatos.getBoolean("apto_veganos"), 
                                    rsPlatos.getBoolean("apto_celiacos"), rsPlatos.getString("tipo"),
                                    rsPlatos.getString("descripcion"));
            resultado.add(ej);
        }


        } catch (SQLException e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmPlatos.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        return resultado;
    }

    void eliminarPlatoMesa(Plato p, Mesa m) {
        Connection con;
        PreparedStatement stmPlatos = null;

        con = super.getConexion();

        try {
            stmPlatos = con.prepareStatement("delete from tenerplato " +
                                            "where mesa=? and servicio_plato=?");
            stmPlatos.setInt(1, m.getNum_mesa());
            stmPlatos.setInt(2, p.getServicio());
            stmPlatos.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
           // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlatos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        p.setServicio(-1);
    }

    void anadirPlatoMesa(Plato p, Mesa m) {
       Connection con;
        PreparedStatement stmPlatos = null;

        con = super.getConexion();

        try {
            stmPlatos = con.prepareStatement("insert into tenerplato (mesa, plato) values ('?', '?');");
            stmPlatos.setInt(1, m.getNum_mesa());
            stmPlatos.setString(2, p.getId_plato());
            stmPlatos.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
           // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPlatos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
}
