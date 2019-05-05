/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author davidmacar
 */
public class Bebida extends MateriaPrima{
    private int porcentaje_alcohol;
    private String tipo;
    private int servicio;
    
    public Bebida(int codigo, String nombre, float precio, int porcentaje_alcohol, String tipo){
        this.codigo = codigo;
        this.nombre = nombre;
        //this.cantidad = cantidad;
        this.precio = precio;
        this.porcentaje_alcohol = porcentaje_alcohol;
        this.tipo = tipo;
        this.servicio = 0;
    }
    
    public Bebida(){
        this.nombre = "";
        //this.cantidad = 0;
        this.precio = 0;
        this.porcentaje_alcohol = 0;
        this.tipo = "";
        this.servicio = 0;
    }

    public int getPorcentaje_alcohol() {
        return porcentaje_alcohol;
    }

    public void setPorcentaje_alcohol(int porcentaje_alcohol) {
        this.porcentaje_alcohol = porcentaje_alcohol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }
    
    
}
