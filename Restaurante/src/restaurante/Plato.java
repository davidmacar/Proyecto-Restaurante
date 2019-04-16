/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
import java.util.*;
/**
 *
 * @author davidmacar
 */
public class Plato {
    //id_plato, apto_veganos, apto_celiacos, tipo, mesa, venta
    private int id_palto;
    private boolean apto_veganos;
    private boolean apto_celiacos;
    private String tipo;
    private Mesa mesa;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(int id_palto, boolean apto_veganos, boolean apto_celiacos, String tipo) {
        this.id_palto = id_palto;
        this.apto_veganos = apto_veganos;
        this.apto_celiacos = apto_celiacos;
        this.tipo = tipo;
        this.mesa = null;
    }
    public Plato(){
        this.id_palto = 0;
        this.apto_veganos = false;
        this.apto_celiacos = false;
        this.tipo = "";
        this.mesa = null;
    }

    public int getId_palto() {
        return id_palto;
    }

    public void setId_palto(int id_palto) {
        this.id_palto = id_palto;
    }

    public boolean isApto_veganos() {
        return apto_veganos;
    }

    public void setApto_veganos(boolean apto_veganos) {
        this.apto_veganos = apto_veganos;
    }

    public boolean isApto_celiacos() {
        return apto_celiacos;
    }

    public void setApto_celiacos(boolean apto_celiacos) {
        this.apto_celiacos = apto_celiacos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    
    
    
}
