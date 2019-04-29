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
    private String nombre;
    private boolean apto_veganos;
    private boolean apto_celiacos;
    private String tipo;
    private String descripcion;
    private Mesa mesa;
    private ArrayList<Ingrediente> ingredientes;
    private int servicio;
    
    public Plato(String nombre, boolean apto_veganos, boolean apto_celiacos, String tipo, String descripcion) {
        this.nombre = nombre;
        this.apto_veganos = apto_veganos;
        this.apto_celiacos = apto_celiacos;
        this.tipo = tipo;
        this.mesa = null;
        this.descripcion = descripcion;
        this.servicio = 0;
    }
    public Plato(){
        this.nombre = "";
        this.apto_veganos = false;
        this.apto_celiacos = false;
        this.tipo = "";
        this.descripcion ="";
        this.mesa = null;
        this.nombre = "";
        this.servicio = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }
    
    
    
    
    
    
}
