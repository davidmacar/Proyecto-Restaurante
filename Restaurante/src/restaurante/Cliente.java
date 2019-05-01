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
public class Cliente {
    
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String eMail;
    private int numero_tlf;

    public Cliente(String dni, String nombre, String apellido1, String apellido2, String eMail, int numero_tlf) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.eMail = eMail;
        this.numero_tlf = numero_tlf;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNumero_tlf() {
        return numero_tlf;
    }

    public void setNumero_tlf(int numero_tlf) {
        this.numero_tlf = numero_tlf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
}