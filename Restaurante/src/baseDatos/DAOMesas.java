/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import java.sql.*;
import java.util.Calendar;
import restaurante.FachadaAplicacion;
/**
 *
 * @author basesdatos
 */
public class DAOMesas extends AbstractDAO {

    public DAOMesas (Connection conexion, restaurante.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
}