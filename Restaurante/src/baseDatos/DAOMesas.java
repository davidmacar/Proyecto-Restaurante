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
}