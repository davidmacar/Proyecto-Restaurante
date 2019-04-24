/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;
import restaurante.Empleado;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaCamareros extends AbstractTableModel{
    private java.util.List<Empleado> camareros;

    public ModeloTablaCamareros(){
        this.camareros=new java.util.ArrayList<Empleado>();
    }

    public int getColumnCount (){
        return 9;
    }

    public int getRowCount(){
        return camareros.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "dni"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre="Apellido1"; break;
            case 3: nombre="Apellidos2"; break;
            case 4: nombre= "e-mail"; break;
            case 5: nombre= "Numero Telefono"; break;
            case 6: nombre="Fecha Entrada"; break;
            case 7: nombre="Fecha Salida"; break;
            case 8: nombre="Salario"; break;
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
            case 5: clase= java.lang.String.class; break;
            case 6: clase= java.lang.String.class; break;
            case 7: clase=java.lang.String.class; break;
            case 8: clase=java.lang.Float.class; break;
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
           case 0: resultado= camareros.get(row).getDni(); break;
            case 1: resultado= camareros.get(row).getNombre(); break;
            case 2: resultado=camareros.get(row).getApellido1();break;
            case 3: resultado=camareros.get(row).getApellido2(); break;
            case 4: resultado= camareros.get(row).geteMail(); break;
            case 5: resultado= camareros.get(row).getNumero_tlf(); break;
            case 6: resultado=camareros.get(row).getFecha_entrada();break;
            case 7: resultado=camareros.get(row).getFecha_salida(); break;
            case 8: resultado= camareros.get(row).getSalario(); break;
        }
        return resultado;
    }
}
    
       
      
       
       
//    public void setFilas(java.util.List<Empleado> usuarios){
//        this.camareros=camareros;
//        fireTableDataChanged();
//    }
//
//    public Empleado obtenerEmpleado(int i){
//        return this.camareros.get(i);
//    }


