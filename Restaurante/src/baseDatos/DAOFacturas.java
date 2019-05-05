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
    
    public java.util.List<Factura> obtenerFacturas() {
        java.util.List<Factura> resultado = new java.util.ArrayList<Factura>();
        Connection con;
        PreparedStatement stmFacturas = null;
        ResultSet rsFacturas;

        con = super.getConexion();

        try {
            stmFacturas = con.prepareStatement("select f.id_factura, a.id_venta, f.cliente, f.fecha, a.precio, a.mesa "
                                                + "from facturas as f, atender as a "
                                                + "where f.id_factura = a.factura");
            rsFacturas = stmFacturas.executeQuery();
            while (rsFacturas.next()) {
                Factura factura = new Factura(rsFacturas.getInt("id_factura"), rsFacturas.getInt("id_venta"),
                        rsFacturas.getString("cliente"), rsFacturas.getString("fecha"), rsFacturas.getFloat("precio"), rsFacturas.getInt("mesa"));
                resultado.add(factura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ;
        } finally {
            try {
                stmFacturas.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        return resultado;
    } 
    
    public ArrayList<Factura> obtenerFacturasIdCliente(String id, String cliente) {
        ArrayList<Factura> resultado = new ArrayList();
        Connection con;
        PreparedStatement stmFacturas = null;
        String statement = "select f.id_factura, a.id_venta, f.cliente, f.fecha, a.precio, a.mesa "
                + "from facturas as f, atender as a "
                + "where f.id_factura = ? and f.id_factura = a.factura "
                + "and f.cliente = ?";
        ResultSet rsFacturas;

        con = super.getConexion();

        try {
            stmFacturas = con.prepareStatement(statement);
            stmFacturas.setInt(1, Integer.parseInt(id));
            stmFacturas.setString(2, cliente);
            rsFacturas = stmFacturas.executeQuery();
            while (rsFacturas.next()) {
                resultado.add(new Factura(rsFacturas.getInt("id_factura"), rsFacturas.getInt("id_venta"),
                        rsFacturas.getString("cliente"), rsFacturas.getDate("fecha").toString(), rsFacturas.getFloat("precio"), rsFacturas.getInt("mesa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ;
        } finally {
            try {
                stmFacturas.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }
    
    public ArrayList<Factura> obtenerFacturasCliente(String cliente) {
        Connection con;
        ArrayList<Factura> facturas = new ArrayList();
        PreparedStatement stmFactura = null;

            String statement = "select f.id_factura, a.id_venta, f.cliente, f.fecha, a.precio, a.mesa "
                + "from facturas as f, atender as a "
                + "where f.id_factura = a.factura "
                + "and f.cliente = ?";
        ResultSet rsFactura;

        con = super.getConexion();

        try {
            stmFactura = con.prepareStatement(statement);
            stmFactura.setString(1, cliente);
            rsFactura = stmFactura.executeQuery();
            while (rsFactura.next()) {
                facturas.add(new Factura(rsFactura.getInt("id_factura"), rsFactura.getInt("id_venta"),
                        rsFactura.getString("cliente"), rsFactura.getDate("fecha").toString(), rsFactura.getFloat("precio"), rsFactura.getInt("mesa")));
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
            }
        }
        return facturas;
    }
    
    public ArrayList<Factura> obtenerFacturasId(String id) {
        Connection con;
        ArrayList<Factura> facturas = new ArrayList();
        PreparedStatement stmFactura = null;

        String statement = "select f.id_factura, a.id_venta, f.cliente, f.fecha, a.precio, a.mesa "
                + "from facturas as f, atender as a "
                + "where f.id_factura = ? and f.id_factura = a.factura ";
        ResultSet rsFactura;

        con = super.getConexion();

        try {
            stmFactura = con.prepareStatement(statement);
            stmFactura.setInt(1, Integer.parseInt(id));
            rsFactura = stmFactura.executeQuery();
            while (rsFactura.next()) {
                facturas.add(new Factura(rsFactura.getInt("id_factura"), rsFactura.getInt("id_venta"),
                        rsFactura.getString("cliente"), rsFactura.getDate("fecha").toString(), rsFactura.getFloat("precio"), rsFactura.getInt("mesa")));
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
            }
        }
        return facturas;
    }
    
    public String obtenerFechaActual() {
        Connection con;
        String fecha = null;
        PreparedStatement stmFactura = null;
        String statement = "select NOW()::timestamp ";
        ResultSet rsFactura;

        con = super.getConexion();

        try {
            stmFactura = con.prepareStatement(statement);
            rsFactura = stmFactura.executeQuery();
            if (rsFactura.next()) {
                fecha = rsFactura.getDate("now").toString();
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
            }
        }
        return fecha;
    }
    
    public String obtenerIdFactura() {
        Connection con;
        String id = null;
        PreparedStatement stmFactura = null;
        String statement = "select max(id_factura) from facturas ";
        ResultSet rsFactura;

        con = super.getConexion();

        try {
            stmFactura = con.prepareStatement(statement);
            rsFactura = stmFactura.executeQuery();
            if (rsFactura.next()) {
                id = String.valueOf(rsFactura.getInt("max") + 1);
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
            }
        }
        return id;
    }
    
    public void anadirFactura(Factura fac) {
        Connection con;
        PreparedStatement stmFactura = null;
        PreparedStatement stmAtender = null;
        int id = -1;
        String statement = "insert into facturas(cliente, fecha) "
                            + "values (?, NOW()::timestamp) "
                            + "returning id_factura";

        con = super.getConexion();

        try {
            stmFactura = con.prepareStatement(statement);
            stmFactura.setString(1, fac.getCliente());
            ResultSet rsId = stmFactura.executeQuery();
            if (rsId.next()) {
                id = rsId.getInt("id_factura");
            }
            try{
                statement = "UPDATE atender "
                        + "SET factura = ? "
                        + "WHERE id_venta = ?";
                stmFactura = con.prepareStatement(statement);
                stmFactura.setInt(1, id);
                stmFactura.setInt(2, fac.getVenta());
                stmFactura.executeUpdate();
            }
            catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            } 
            finally {
                try {
                    if (stmAtender != null) {
                        stmAtender.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Imposible cerrar cursores");
                    System.out.println("");
                }
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
    }

}
