/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import restaurante.Bebida;
import restaurante.FachadaAplicacion;
import restaurante.Mesa;
import restaurante.Plato;
/**
 *
 * @author basesdatos
 */
public class DAOMesas extends AbstractDAO {

    public DAOMesas (Connection conexion, restaurante.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Mesa> obtenerMesas(){
        java.util.List<Mesa> resultado=new java.util.ArrayList<Mesa>();
        Connection con;
        PreparedStatement stmMesas=null;
        String statement = "select *" +
                            "from mesas";
        ResultSet rsMesas;

        con=super.getConexion();

        try {
        stmMesas =con.prepareStatement(statement);
        rsMesas=stmMesas.executeQuery();
        while (rsMesas.next())
        {
            Mesa ej = new Mesa(rsMesas.getInt("num_mesa"));
            resultado.add(ej);
        }


        } catch (SQLException e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmMesas.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        return resultado;
    }
    public Mesa obtenerMesa(int numMesa, List<Plato> platos, List<Bebida> bebidas){
        Mesa mesa = new Mesa(numMesa, (ArrayList) platos, (ArrayList) bebidas);
        return mesa;
    }
    
    public float precioMesa(Mesa mesa){
        float resultado=0;
        Connection con;
        PreparedStatement stmPrecio=null;

        ResultSet rsPrecio;

        con=super.getConexion();

        try {
        stmPrecio=con.prepareStatement( "SELECT sum(round(precio,2)) " +
                                        "FROM( " +
                                        "SELECT m.num_mesa, mp.nombre, mp.precio " +
                                        "FROM mesas m, tenerbebida tb, materias_primas mp " +
                                        "WHERE m.num_mesa=tb.mesa AND tb.bebida = mp.nombre " +
                                        "UNION " +
                                        "SELECT m.num_mesa, mp.nombre, mp.precio " +
                                        "FROM mesas m, tenerplato tp, ingrediente_forma_plato ifp, materias_primas mp " +
                                        "WHERE m.num_mesa=tp.mesa AND tp.plato = ifp.plato AND ifp.ingrediente= mp.nombre) as t " +
                                        "WHERE t.num_mesa = ?");
        stmPrecio.setInt(1, mesa.getNum_mesa());
        rsPrecio=stmPrecio.executeQuery();
        if (rsPrecio.next())
        {
            resultado = rsPrecio.getFloat("sum");
            
        }


        } catch (SQLException e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmPrecio.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        return resultado;
    }
    
    public void cobrarMesa(Mesa mesa, String camarero, Float precio){
        Connection con;
        PreparedStatement stmInsertar=null;
        PreparedStatement stmBorrarBebida=null;
        PreparedStatement stmBorrarPlato=null;

        con=super.getConexion();

        try {
        stmInsertar=con.prepareStatement( "INSERT INTO atender(mesa, camarero, id_venta, fecha_venta, precio) " +
                                        "VALUES (?, ?, nextval('controla_secuencia_idVenta'), NOW(), ?)");
        stmInsertar.setInt(1, mesa.getNum_mesa());
        stmInsertar.setString(2, camarero);
        stmInsertar.setFloat(3, precio);
        stmInsertar.executeUpdate();
        
        } catch (SQLException e){
            e.printStackTrace();;
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmInsertar.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        
        
        try {
            stmBorrarPlato = con.prepareStatement("delete from tenerplato " +
                                            "where mesa=?");
            stmBorrarPlato.setInt(1, mesa.getNum_mesa());
            stmBorrarPlato.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBorrarPlato.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        
        
        try {
            stmBorrarBebida = con.prepareStatement("delete from tenerbebida " +
                                            "where mesa=?");
            stmBorrarBebida.setInt(1, mesa.getNum_mesa());
            stmBorrarBebida.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBorrarBebida.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    void eliminarMesaCobrada( Mesa m) {
        Connection con;
        PreparedStatement stmMesa = null;

        con = super.getConexion();

        try {
            stmMesa = con.prepareStatement("delete from tenerplato " +
                                            "where mesa=?");
            
            stmMesa.setInt(1, m.getNum_mesa());
            
            stmMesa.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMesa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        try {
            stmMesa = con.prepareStatement("delete from tenerbebida " +
                                            "where mesa=?");
            
            stmMesa.setInt(1, m.getNum_mesa());
            
            stmMesa.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmMesa.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
