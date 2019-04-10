/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import javax.swing.table.AbstractTableModel;
import restaurante.*;

/**
 *
 * @author davidmacar
 */
public class ModeloTablaPlatos extends AbstractTableModel{
    private java.util.List<Plato> pinchos;
    private java.util.List<Plato> entrantes;
    private java.util.List<Plato> primeros;
    private java.util.List<Plato> segundos;
    private java.util.List<Plato> postres;

    public ModeloTablaPlatos(){
        this.pinchos=new java.util.ArrayList<Plato>();
        this.entrantes=new java.util.ArrayList<Plato>();
        this.primeros=new java.util.ArrayList<Plato>();
        this.segundos=new java.util.ArrayList<Plato>();
        this.postres=new java.util.ArrayList<Plato>();
    }

    @Override
    public int getColumnCount (){
        return 5;
    }

    @Override
    public int getRowCount(int col){
        int ret = -1;
        switch(col){
            case 0 :
                ret = this.pinchos.size();
                break;
            case 1: 
                ret = this.entrantes.size();
                break;
            case 2:
                ret = this.primeros.size();
                break;
            case 3: 
                ret = this.segundos.size();
                break;
            case 4:
                ret = this.postres.size();
                break;
        }
        return ret;
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Pinchos"; break;
            case 1: nombre= "Entrantes"; break;
            case 2: nombre= "Primero"; break;
            case 3: nombre= "Segundo"; break;
            case 4: nombre= "Postre"; break;
        }
        return nombre;
    }

    @Override
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
            case 0: resultado= pinchos.get(row).getNumEjemplar(); break;
            case 1: resultado= entrantes.get(row).getLocalizador(); break;
            case 2: resultado= primeros.get(row).getAnoCompra();break;
            case 3: resultado= segundos.get(row).getAnoCompra();break;
            case 4: resultado= postres.get(row).getAnoCompra();break;

        }
            
        }
        return resultado;

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    /*@Override
    public void setValueAt(Object v, int row, int col){
        switch (col){
            case 1: ejemplares.get(row).setLocalizador((String) v); break;
            case 2: ejemplares.get(row).setAnoCompra((String) v);break;
        }
    }*/

    public void setFilas(java.util.List<Plato> platos){
        this.platos=platos;
        fireTableDataChanged();
    }

    public void nuevoPlato(Plato p){
        this.platos.add(p);
        fireTableRowsInserted(this.platos.size()-1, this.platos.size()-1);
    }

    /*public void borrarPlato(int plato){
        this.platos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }*/

    public java.util.List<Plato> getFilas(){
        return this.platos;
    }

    public Plato obtenerEjemplar(int i){
        return this.platos.get(i);
    }
}
