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
    private int id_plato;
    private boolean apto_veganos;
    private boolean apto_celiacos;
    private String tipo;
    private String descripcion;
    private Mesa mesa;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(int id_plato, boolean apto_veganos, boolean apto_celiacos, String tipo, String descripcion) {
        this.id_plato = id_plato;
        this.apto_veganos = apto_veganos;
        this.apto_celiacos = apto_celiacos;
        this.tipo = tipo;
        this.mesa = null;
        this.descripcion = descripcion;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
    
    
}
