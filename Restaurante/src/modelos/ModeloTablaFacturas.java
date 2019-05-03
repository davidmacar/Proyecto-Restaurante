/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tembebe file, choose Tools | Tembebes
 * and open the tembebe in the editor.
 */
package modelos;

import javax.swing.table.AbstractTableModel;
import restaurante.Factura;
import java.util.*;
import restaurante.*;

/**
 *
 * @author davidmacar
 */
public class ModeloTablaFacturas extends AbstractTableModel{
    private java.util.List<Factura> facturas;
   
    
    public ModeloTablaFacturas(){
        this.facturas=new java.util.ArrayList<Factura>();
        
    }

    @Override
    public int getColumnCount (){
        return 5;
    } 
    
    @Override
    public int getRowCount() {
        return facturas.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "ID Factura"; break;
            case 1: nombre= "Venta"; break;
            case 2: nombre= "Cliente"; break;
            case 3: nombre= "Fecha"; break;
            case 4: nombre= "Precio"; break;
        }
        return nombre;
    }

    //@Override
    public Class getColumnClass(int col){
        Class nombre=null;
        switch (col){
        case 0: nombre= java.lang.Integer.class; break;
        case 1: nombre= java.lang.Integer.class; break;
        case 2: nombre= java.lang.String.class; break;
        case 3: nombre= java.lang.String.class; break;
        case 4: nombre= java.lang.Float.class; break;
        }
        return nombre;
    }

    @Override
    public boolean isCellEditable(int row, int col){
       return false;
    }

    @Override
    public Object getValueAt(int row, int col){
        
        Object clase=null;

        switch (col){
            case 0: clase= facturas.get(row).getId(); break;
            case 1: clase= facturas.get(row).getVenta(); break;
            case 2: clase= facturas.get(row).getCliente(); break;
            case 3: clase= facturas.get(row).getFecha(); break;
            case 4: clase= facturas.get(row).getPrecio(); break;
            
        }
        return clase;
    }

    public void setFilas(java.util.List<Factura> facturas) {
    this.facturas = facturas;
    fireTableDataChanged();
    }

    

 

}
