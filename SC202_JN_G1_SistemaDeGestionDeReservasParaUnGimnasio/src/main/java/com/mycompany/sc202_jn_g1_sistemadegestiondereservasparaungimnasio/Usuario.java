/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

/**
 *
 * @author XPC
 */
public class Usuario {
    private String cedula;
    private String nombre;
    private double peso;
    private String telefono;
    private String correo;
    private String contrasena;
    private int edad;


    public Usuario(String cedula, String nombre, double peso, String telefono, String correo, String contrasena, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.peso = peso;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public void registrar() {
        System.out.println("Usuario registrado: " + nombre);
    }

    public void editar() {
        System.out.println("Usuario editado: " + nombre);
    }

    public boolean login(String correo, String contrasena) {
    if (this.correo == correo && this.contrasena == contrasena) {
        System.out.println("Login exitoso");
        return true;
    } else {
        System.out.println("Login fallido");
        return false;
    }
}
}    

