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
public class Empleado {
    //dni, salario, numero_tlf, fecha_entrada, fecha_salida, nombre, apellido1, apellido2, eMail
    private String dni;
    private float salario;
    private String numero_tlf;
    private String fecha_entrada;
    private String fecha_salida;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String eMail;

    public Empleado(String dni, float salario, String numero_tlf, String fecha_entrada, String fecha_salida, String nombre, String apellido1, String apellido2, String eMail) {
        this.dni = dni;
        this.salario = salario;
        this.numero_tlf = numero_tlf;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.eMail = eMail;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getNumero_tlf() {
        return numero_tlf;
    }

    public void setNumero_tlf(String numero_tlf) {
        this.numero_tlf = numero_tlf;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
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
