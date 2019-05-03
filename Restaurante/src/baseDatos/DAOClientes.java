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
import restaurante.Cliente;
import restaurante.FachadaAplicacion;

/**
 *
 * @author basesdatos
 */
public class DAOClientes extends AbstractDAO {

    public DAOClientes(Connection conexion, restaurante.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public void anadirCliente(Cliente cli) {
        Connection con;
        PreparedStatement stmCliente = null;
        String statement = "insert into cliente "
                            + "values ?, ?, ?, ?, ?, ?";

        con = super.getConexion();

        try {
            stmCliente = con.prepareStatement(statement);
            stmCliente.setString(1, cli.getDni());
            stmCliente.setString(2, cli.getNombre());
            stmCliente.setString(3, cli.getApellido1());
            stmCliente.setString(4, cli.getApellido2());
            stmCliente.setString(5, cli.geteMail());
            stmCliente.setString(6, cli.getDireccion());
            stmCliente.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmCliente != null) {
                    stmCliente.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
    }
/*
    public Cliente obtenerClientes(String ID, String nombre) {
        Connection con;
        Cliente empleado = null;
        PreparedStatement stmEmpleado = null;
        String statement = "select dni,nombre, apellido_1, apellido_2, e_mail, numero_tlf  "
                + "from personal "
                + "where dni = ? and dni in (select dni from camarero) ";
        ResultSet rsEmpleado;

        con = super.getConexion();

        try {
            stmEmpleado = con.prepareStatement(statement);
            //stmEmpleado.setString(1, dni);
            rsEmpleado = stmEmpleado.executeQuery();
            if (rsEmpleado.next()) {
                cliente = new Cliente(rsEmpleado.getString("dni"),
                        rsEmpleado.getString("numero_tlf"), rsEmpleado.getString("fecha_entrada"),
                        rsEmpleado.getString("fecha_salida"), rsEmpleado.getString("nombre"),
                        rsEmpleado.getString("apellido_1"), rsEmpleado.getString("apellido_2"), rsEmpleado.getString("e_mail"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEmpleado != null) {
                    stmEmpleado.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        System.out.println(cliente.toString());
        return cliente;
    }
    
    
    
    public void anadirCliente(Cliente cli){
        Connection con;
        PreparedStatement stmInsert=null;
        con=super.getConexion();

        try {
        stmInsert=con.prepareStatement("insert into clientes "+
                                      "values (?,?,?,?,?,?)");
        stmInsert.setString(1, cli.getDni());
        stmInsert.setString(2, cli.getNombre());
        stmInsert.setString(3, cli.getApellido1());
        stmInsert.setString(4, cli.getApellido2());
        stmInsert.setString(5, cli.geteMail());
        stmInsert.setString(6, cli.getDireccion());
        stmInsert.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmInsert.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    */
    
    public Cliente obtenerCliente(String dni){
        Connection con;
        Cliente cliente = null;
        PreparedStatement stmEmpleado = null;
        String statement = "select * "
                + "from clientes "
                + "where dni = ? ";
        ResultSet rsEmpleado;

        con = super.getConexion();

        try {
            stmEmpleado = con.prepareStatement(statement);
            stmEmpleado.setString(1, dni);
            rsEmpleado = stmEmpleado.executeQuery();
            if (rsEmpleado.next()) {
                cliente = new Cliente(rsEmpleado.getString("dni"), rsEmpleado.getString("nombre"),
                        rsEmpleado.getString("apellido_1"), rsEmpleado.getString("apellido_2"), rsEmpleado.getString("e_mail"), 
                        rsEmpleado.getString("direccion"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEmpleado != null) {
                    stmEmpleado.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        System.out.println(cliente.toString());
        return cliente;
    }
}
