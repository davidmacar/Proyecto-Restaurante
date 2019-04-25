/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tembebe file, choose Tools | Tembebes
 * and open the tembebe in the editor.
 */
package modelos;

import javax.swing.table.AbstractTableModel;
import restaurante.Bebida;
import java.util.*;
import restaurante.*;

/**
 *
 * @author davidmacar
 */
public class ModeloTablaBebidas extends AbstractTableModel{
    private java.util.List<Bebida> refrescos;
    private java.util.List<Bebida> vinos;
    private java.util.List<Bebida> cervezas;
    private java.util.List<Bebida> cocteles;
   
    
    public ModeloTablaBebidas(){
        this.refrescos=new java.util.ArrayList<Bebida>();
        this.vinos=new java.util.ArrayList<Bebida>();
        this.cervezas=new java.util.ArrayList<Bebida>();
        this.cocteles=new java.util.ArrayList<Bebida>();
    }

    @Override
    public int getColumnCount (){
        return 4;
    } 
    

    public int getRowCount(int col){
        int ret = -1;
        switch(col){
            case 0 :
                ret = this.refrescos.size();
                break;
            case 1: 
                ret = this.vinos.size();
                break;
            case 2:
                ret = this.cervezas.size();
                break;
            case 3: 
                ret = this.cocteles.size();
                break;
        }
        return ret;
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Refrescos"; break;
            case 1: nombre= "Vinos"; break;
            case 2: nombre= "Cervezas"; break;
            case 3: nombre= "Cocteles"; break;
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
                if(row <= refrescos.size()-1)
                    resultado= refrescos.get(row).getNombre(); 
                break;
            case 1: 
                if(row <= vinos.size()-1)
                    resultado= vinos.get(row).getNombre();
                break;
            case 2: 
                if(row <= cervezas.size()-1)
                    resultado= cervezas.get(row).getNombre();
                break;
            case 3: 
                if(row <= cocteles.size()-1)
                    resultado= cocteles.get(row).getNombre();
                break;

        }
            
        return resultado;
        }

    
    @Override
    public int getRowCount() {
        return Math.max(refrescos.size(), Math.max(vinos.size(), Math.max(cervezas.size(), cocteles.size())));
    }
    

    @Override
    public void setValueAt(Object v, int row, int col){
        switch (col){
            /*case 0: refrescos.get(row).setLocalizador((String) v); break;
            case 1: vinos.get(row).setAnoCompra((String) v);break;
            case 2: cervezas.get(row).setAnoCompra((String) v);break;
            case 3: cocteles.get(row).setAnoCompra((String) v);break;*/
        }
    }

    public void setFilas(java.util.List<Bebida> bebidas){
        for(Bebida beb : bebidas){
            if(beb.getTipo().equalsIgnoreCase("entrante"))
                this.refrescos.add(beb);
            else if(beb.getTipo().equalsIgnoreCase("primero"))
                this.vinos.add(beb);
            else if(beb.getTipo().equalsIgnoreCase("segundo"))
                this.cervezas.add(beb);
            else if(beb.getTipo().equalsIgnoreCase("postre"))
                this.cocteles.add(beb);
        }
        fireTableDataChanged();
    }

    public void nuevoBebida(Bebida p){
        //this.bebidas.add(p);
        //fireTableRowsInserted(this.bebidas.size()-1, this.bebidas.size()-1);
    }

    /*public void borrarBebida(int bebo){
        this.bebidas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }*/

    public java.util.List<Bebida> getFilas(){
        ArrayList<Bebida> bebidas = new ArrayList();
        return bebidas;
    }

    public Bebida obtenerBebida(int i){
        //return this.bebidas.get(i);
        return new Bebida();
    }
}
