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
public class Bebida extends MateriaPrima {
    private float porcentaje_alcohol;
    
    public Bebida(String nombre, int cantidad, float precio, float porcentaje_alcohol){
        super(nombre, cantidad, precio);
        this.porcentaje_alcohol = porcentaje_alcohol;
    }

    public float getPorcentaje_alcohol() {
        return porcentaje_alcohol;
    }

    public void setPorcentaje_alcohol(float porcentaje_alcohol) {
        this.porcentaje_alcohol = porcentaje_alcohol;
    }
}
