/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.swing.table.AbstractTableModel;
import restaurante.Plato;
import java.util.*;
import restaurante.*;

/**
 *
 * @author davidmacar
 */
public class ModeloTablaPlatos extends AbstractTableModel{
    private java.util.List<Plato> entrantes;
    private java.util.List<Plato> primeros;
    private java.util.List<Plato> segundos;
    private java.util.List<Plato> postres;
   
    
    public ModeloTablaPlatos(){
        this.entrantes=new java.util.ArrayList<Plato>();
        this.primeros=new java.util.ArrayList<Plato>();
        this.segundos=new java.util.ArrayList<Plato>();
        this.postres=new java.util.ArrayList<Plato>();
    }

    @Override
    public int getColumnCount (){
        return 4;
    } 
    

    public int getRowCount(int col){
        int ret = -1;
        switch(col){
            case 0 :
                ret = this.entrantes.size();
                break;
            case 1: 
                ret = this.primeros.size();
                break;
            case 2:
                ret = this.segundos.size();
                break;
            case 3: 
                ret = this.postres.size();
                break;
        }
        return ret;
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Entrantes"; break;
            case 1: nombre= "Primero"; break;
            case 2: nombre= "Segundo"; break;
            case 3: nombre= "Postre"; break;
        }
        return nombre;
    }

    //@Override
    public Class getColumnClass(){
        Class clase= java.lang.String.class;
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
       return false;
    }

    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;
        boolean alfa = false;
        switch(col){
            case 0: 
                if(row <= entrantes.size()-1)
                    resultado= entrantes.get(row).getNombre(); 
                break;
            case 1: 
                if(row <= primeros.size()-1)
                    resultado= primeros.get(row).getNombre();
                break;
            case 2: 
                if(row <= segundos.size()-1)
                    resultado= segundos.get(row).getNombre();
                break;
            case 3: 
                if(row <= postres.size()-1)
                    resultado= postres.get(row).getNombre();
                break;

        }
            
        return resultado;
        }

    
    @Override
    public int getRowCount() {
        return Math.max(entrantes.size(), Math.max(primeros.size(), Math.max(segundos.size(), postres.size())));
    }
    

    @Override
    public void setValueAt(Object v, int row, int col){
        switch (col){
            /*case 0: entrantes.get(row).setLocalizador((String) v); break;
            case 1: primeros.get(row).setAnoCompra((String) v);break;
            case 2: segundos.get(row).setAnoCompra((String) v);break;
            case 3: postres.get(row).setAnoCompra((String) v);break;*/
        }
    }

    public void setFilas(java.util.List<Plato> platos){
        this.entrantes.clear();
        this.postres.clear();
        this.primeros.clear();
        this.segundos.clear();
        for(Plato plat : platos){
            if(plat.getTipo().equalsIgnoreCase("entrante"))
                this.entrantes.add(plat);
            else if(plat.getTipo().equalsIgnoreCase("primero"))
                this.primeros.add(plat);
            else if(plat.getTipo().equalsIgnoreCase("segundo"))
                this.segundos.add(plat);
            else if(plat.getTipo().equalsIgnoreCase("postre"))
                this.postres.add(plat);
        }
        fireTableDataChanged();
    }

    public void nuevoPlato(Plato p){
        //this.platos.add(p);
        //fireTableRowsInserted(this.platos.size()-1, this.platos.size()-1);
    }

    /*public void borrarPlato(int plato){
        this.platos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }*/

    public java.util.List<Plato> getFilas(){
        ArrayList<Plato> platos = new ArrayList();
        return platos;
    }

    public Plato obtenerPlato(int col, int row){
        ArrayList<Plato> aux = null;
        Plato ret;
        switch(col){
            case 0:
                aux = (ArrayList) this.entrantes;
                break;
            case 1:
                aux = (ArrayList) this.primeros;
                break;
            case 2: 
                aux = (ArrayList) this.segundos;
                break;
            case 3: 
                aux = (ArrayList) this.postres;
                break;
        }
       ret = aux.get(row);
       return ret;
    }

  
}
