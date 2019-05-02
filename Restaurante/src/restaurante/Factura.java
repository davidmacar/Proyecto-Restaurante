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
    private String cliente;
    private Calendar fecha;
    private Float precio;
    private int mesa;
    

    public Factura(int id, int venta, String cliente, Calendar fecha, Float precio, int mesa) {
        this.id = id;
        this.venta = venta;
        this.cliente = cliente;
        this.fecha = fecha;
        this.precio = precio;
        this.mesa = mesa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
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
