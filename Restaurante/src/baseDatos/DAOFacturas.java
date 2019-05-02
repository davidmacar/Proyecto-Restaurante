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
import restaurante.Factura;
import restaurante.FachadaAplicacion;

/**
 *
 * @author basesdatos
 */
public class DAOFacturas extends AbstractDAO {

    public DAOFacturas(Connection conexion, restaurante.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Factura obtenerClientes(int id_factura, int cliente) {
        Connection con;
        Factura factura = null;
        PreparedStatement stmFactura = null;
        String statement = "select id_factura, venta, cliente, fecha, precio  "
                + "from facturas as f, clientes as c"
                + "where f.cliente = c.dni"
                + "where f.id_factura = ? and f.cliente = ? ";
        ResultSet rsFactura;

        con = super.getConexion();

        try {
            stmFactura = con.prepareStatement(statement);
            stmFactura.setInt(1, id_factura);
            stmFactura.setString(2, cliente);
            rsFactura = stmFactura.executeQuery();
            if (rsFactura.next()) {
                factura = new Factura(rsFactura.getInt("id_factura"),
                        rsFactura.getInt("venta"), rsFactura.getString("cliente"),
                        rsFactura.getString("fecha"), rsFactura.getFloat("precio");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmFactura != null) {
                    stmFactura.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        System.out.println(factura.toString());
        return factura;
    }

  
}
