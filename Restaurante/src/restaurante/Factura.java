/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.Calendar;

/**
 *
 * @author alumnogreibd
 */
public class Factura {
    
    private int id;
    private int venta;
    private int cliente;
    private Calendar fecha;
    private Float precio;
    

    public Factura(int id, int venta, int cliente, Calendar fecha, Float precio) {
        this.id = id;
        this.venta = venta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    
    public Float getPrecio(){
        return precio = precio;
    }
    
    public void setPrecio(Float precio){
        this.precio = precio;
    }
    
}
