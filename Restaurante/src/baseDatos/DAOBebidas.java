/*
 * To change this template, choose Tools | Templates
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
public class DAOBebidas extends AbstractDAO {

    public DAOBebidas(Connection conexion, restaurante.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Bebida> obtenerBebidas() {
        List<Bebida> resultado = new ArrayList<Bebida>();
        Connection con;
        PreparedStatement stmBebidas = null;
        String statement = "select b.nombre, b.tipo, b.porcentaje_alcohol, mp.cantidad, mp.precio "
                + "from bebidas as b, materias_primas as mp "
                + "where b.nombre = mp.nombre ";
        ResultSet rsBebidas;

        con = super.getConexion();

        try {
            stmBebidas = con.prepareStatement(statement);
            rsBebidas = stmBebidas.executeQuery();
            while (rsBebidas.next()) {
                Bebida ej = new Bebida(rsBebidas.getString("nombre"), rsBebidas.getInt("cantidad"),
                        rsBebidas.getFloat("precio"), rsBebidas.getInt("porcentaje_alcohol"),
                        rsBebidas.getString("tipo"));
                resultado.add(ej);
            }

        } catch (SQLException e) {
            e.printStackTrace();;
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBebidas.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        return resultado;
    }

    public List<Bebida> obtenerBebidasMesa(int mesa) {
        List<Bebida> resultado = new ArrayList<Bebida>();
        Connection con;
        PreparedStatement stmBebidas = null;
        String statement = "select b.nombre, m.cantidad, m.precio, b.porcentaje_alcohol, b.tipo, t.servicio_bebida  "
                + "from tenerbebida as t, bebidas as b, materias_primas as m "
                + "where t.bebida = b.nombre and t.bebida = m.nombre "
                + "and t.mesa = ?";
        ResultSet rsBebidas;

        con = super.getConexion();

        try {
            stmBebidas = con.prepareStatement(statement);
            stmBebidas.setInt(1, mesa);
            rsBebidas = stmBebidas.executeQuery();
            while (rsBebidas.next()) {
                Bebida ej = new Bebida(rsBebidas.getString("nombre"), rsBebidas.getInt("cantidad"),
                        rsBebidas.getFloat("precio"), rsBebidas.getInt("porcentaje_alcohol"),
                        rsBebidas.getString("tipo"));
                ej.setServicio(rsBebidas.getInt("servicio_bebida"));
                resultado.add(ej);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBebidas.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        return resultado;
    }

    public ArrayList<Bebida> buscarBebidas(String bebida) {
        ArrayList<Bebida> resultado = new ArrayList();
        Connection con;
        PreparedStatement stmBebidas = null;
        String statement = "select b.nombre, b.tipo, b.porcentaje_alcohol, mp.cantidad, mp.precio "
                + "from bebidas as b, materias_primas as mp "
                + "where b.nombre = mp.nombre and "
                + "lower(b.nombre) like lower(?) and lower(mp.nombre) like lower(?)";
        ResultSet rsBebidas;

        con = super.getConexion();

        try {
            stmBebidas = con.prepareStatement(statement);
            stmBebidas.setString(1, new String("%" + bebida + "%"));
            stmBebidas.setString(2, new String("%" + bebida + "%"));
            rsBebidas = stmBebidas.executeQuery();
            while (rsBebidas.next()) {
                Bebida ej = new Bebida(rsBebidas.getString("nombre"), rsBebidas.getInt("cantidad"),
                        rsBebidas.getFloat("precio"), rsBebidas.getInt("porcentaje_alcohol"),
                        rsBebidas.getString("tipo"));
                resultado.add(ej);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBebidas.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        return resultado;
    }

    void anadirBebidaMesa(Bebida b, Mesa m) {
        Connection con;
        PreparedStatement stmBebidas = null;

        con = super.getConexion();

        try {
            stmBebidas = con.prepareStatement("insert into tenerbebida (mesa, bebida) values (?, ?)");
            stmBebidas.setInt(1, m.getNum_mesa());
            stmBebidas.setString(2, b.getNombre());
            stmBebidas.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBebidas.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    void eliminarBebidaMesa(Bebida b, Mesa m) {
        Connection con;
        PreparedStatement stmBebidas = null;

        con = super.getConexion();

        try {
            stmBebidas = con.prepareStatement("delete from tenerbebida " +
                                            "where mesa=? and servicio_bebida=?");
            
            stmBebidas.setInt(1, m.getNum_mesa());
            stmBebidas.setInt(2, b.getServicio());
            stmBebidas.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBebidas.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        b.setServicio(-1);
    }
    
    public int obtenerServicioBebida(Bebida bebida, Mesa m) {
        int resultado = -1;
        Connection con;
        PreparedStatement stmBebidas = null;
        String statement = "select servicio_bebida " 
                            + "from tenerbebida "
                            + "where bebida = ?  and mesa=?";
        ResultSet rsBebidas;

        con = super.getConexion();

        try {
            stmBebidas = con.prepareStatement(statement);
            stmBebidas.setString(1, bebida.getNombre());
            stmBebidas.setInt(2, m.getNum_mesa());
            rsBebidas = stmBebidas.executeQuery();
            if (rsBebidas.next()) {
                resultado = rsBebidas.getInt("servicio_bebida");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            //this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmBebidas.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Imposible cerrar cursores");
                System.out.println("");
            }
        }
        return resultado;
    }
}
