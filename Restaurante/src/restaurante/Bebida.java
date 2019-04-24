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
    
    public Bebida(){
        this.nombre = "";
        this.cantidad = 0;
        this.precio = 0;
        this.porcentaje_alcohol = 0;
    }

    public int getPorcentaje_alcohol() {
        return porcentaje_alcohol;
    }

    public void setPorcentaje_alcohol(int porcentaje_alcohol) {
        this.porcentaje_alcohol = porcentaje_alcohol;
    }
    
    
}
