/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import java.sql.*;
import java.util.Calendar;
import restaurante.FachadaAplicacion;
import restaurante.Plato;
/**
 *
 * @author basesdatos
 */
public class DAOEmpleados extends AbstractDAO {

    public DAOEmpleados (Connection conexion, restaurante.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public boolean autenticar(String usuario, String password){
        Connection con;
        String dni="", pass="";
        PreparedStatement stmUsuario=null;
        String statement = "select dni, password " +
                            "from personal "+
                            "where dni = ?";
        ResultSet rsUsuarios;

        con=super.getConexion();

        try {
            stmUsuario =con.prepareStatement(statement);
            stmUsuario.setString(1, usuario);
            rsUsuarios=stmUsuario.executeQuery();
        if (rsUsuarios.next())
        {
            dni = rsUsuarios.getString("dni");
            pass = rsUsuarios.getString("password");
        }


        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              stmUsuario.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        if(password == pass)
            return true;
        else 
            return false;
    }
}