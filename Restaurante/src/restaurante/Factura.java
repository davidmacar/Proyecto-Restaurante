/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;


/**
 *
 * @author alumnogreibd
 */
public class Factura {
    
    private int id;
    private int venta;
    private String cliente;
    private String fecha;
    private Float precio;
    

    public Factura(int venta, String cliente, String fecha, Float precio) {
        this.id = 0;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    public Float getPrecio(){
        return precio = precio;
    }
    
    public void setPrecio(Float precio){
        this.precio = precio;
    }
    
}
