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
public class Mesa {
    private int num_mesa;
    private ArrayList<Plato> platos;
    private ArrayList<Bebida> bebidas;
    
    
    public Mesa(int num_mesa){
        this.num_mesa = num_mesa;
        this.platos = new ArrayList();
        this.bebidas = new ArrayList();
    }
    
    public Mesa(int num_mesa, ArrayList<Plato> platos, ArrayList<Bebida> bebidas){
        this.num_mesa = num_mesa;
        this.platos = platos;
        this.bebidas = bebidas;
    }
    
    public Mesa(){
        this.num_mesa = 0;
        this.platos = new ArrayList();
        this.bebidas = new ArrayList();
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }
    
    
    
    
}
