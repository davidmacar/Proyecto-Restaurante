/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;
import restaurante.Cliente;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaClientes extends AbstractTableModel{
    private java.util.List<Cliente> clientes;

    public ModeloTablaClientes(){
        this.clientes=new java.util.ArrayList<Cliente>();
    }

    public int getColumnCount (){
        return 5;
    }

    public int getRowCount(){
        return clientes.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "DNI"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre="Primer Apellido"; break;
            case 3: nombre="Segundo Apellido"; break;
            case 4: nombre= "eMail"; break;

        }
        return nombre;
    }
  

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.String.class; break;
            case 4: clase= java.lang.String.class; break;

        }
        return clase;
    }
 
    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    @Override
  public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
           case 0: resultado= clientes.get(row).getDni(); break;
            case 1: resultado= clientes.get(row).getNombre(); break;
            case 2: resultado=clientes.get(row).getApellido1();break;
            case 3: resultado=clientes.get(row).getApellido2(); break;
            case 4: resultado= clientes.get(row).geteMail(); break;

        }
        return resultado;
    }
}
    
       