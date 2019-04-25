/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import java.sql.*;
import java.util.Calendar;
import restaurante.Empleado;
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
        boolean correcto = false;
        String dni="", pass="";
        PreparedStatement stmUsuario=null;
        String statement = "select dni, contrasena " +
                            "from personal "+
                            "where dni = ? and contrasena = ?";
        ResultSet rsUsuarios;

        con=super.getConexion();

        try {
            stmUsuario =con.prepareStatement(statement);
            stmUsuario.setString(1, usuario);
            stmUsuario.setString(2, password);
            rsUsuarios=stmUsuario.executeQuery();
        if (rsUsuarios.next())
            correcto = true;


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
        return correcto;
    }
    public Empleado obtenerCamarero(String dni){
        Connection con;
        Empleado empleado=null;
        PreparedStatement stmEmpleado=null;
        String statement = "select dni, salario, numero_tlf, fecha_entrada, fecha_salida, nombre, apellido_1, apellido_2, e_mail " +
"from personal " +
"where dni = ? and dni in (select dni from camarero) ";
        ResultSet rsEmpleado;

        con=super.getConexion();

        try {
            stmEmpleado =con.prepareStatement(statement);
            stmEmpleado.setString(1, dni);
            rsEmpleado=stmEmpleado.executeQuery();
        if (rsEmpleado.next())
            empleado = new Empleado(rsEmpleado.getString("dni"), rsEmpleado.getFloat("salario"), 
                    rsEmpleado.getString("dni"), rsEmpleado.getString("fecha_entrada"),
                    rsEmpleado.getString("fecha_salida"), rsEmpleado.getString("nombre"), 
                    rsEmpleado.getString("apellido_1"), rsEmpleado.getString("apellido_2"), rsEmpleado.getString("e_mail"));


        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              if(stmEmpleado != null)
                stmEmpleado.close();
          } 
          catch (SQLException e){
              e.printStackTrace();
              System.out.println("Imposible cerrar cursores");
              System.out.println("");
          }
        }
        System.out.println(empleado.toString());
        return empleado;
    }
}