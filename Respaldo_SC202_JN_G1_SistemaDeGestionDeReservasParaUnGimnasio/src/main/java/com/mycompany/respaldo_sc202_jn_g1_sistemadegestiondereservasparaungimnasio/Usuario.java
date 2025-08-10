/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.respaldo_sc202_jn_g1_sistemadegestiondereservasparaungimnasio;

/**
 *
 * @author samim
 */
public class Usuario {
    
    //Atributos
    private int id;
    private String nombre;
    private long cedula;
    private String nombreUsuario;
    private String contrasena;
    private String correo;
    private long telefono;
    private int edad;
    private double peso;
    private double altura;
    
    
    //Constructor completo mediante parametros
    public Usuario (int id,String nombre, long cedula, String nombreUsuario, String contrasena, String correo, long telefono, int edad, double peso, double altura){
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }
    
    
    //Encapsuladores - Getters / Setters
    public void setId (int id){this.id = id;}
    public int getId (){return id;}
    
    public void setNombre (String nombre){this.nombre = nombre;}
    public String getNombre (){return nombre;}
    
    public void setCedula (long cedula){this.cedula = cedula;}
    public long getCedula (){return cedula;}
    
    public void setNombreUsuario (String nombreUsuario){this.nombreUsuario = nombreUsuario;}
    public String getNombreUsuario (){return nombreUsuario;}
    
    public void setContrasena (String contrasena){this.contrasena = contrasena;}
    public String getContrasena (){return contrasena;}
    
    public void setCorreo (String correo){this.correo = correo;}
    public String getCorreo (){return correo;}
    
    public void setTelefono (long telefono){this.telefono = telefono;}
    public long getTelefono (){return telefono;}
    
    public void setEdad (int edad){this.edad = edad;}
    public int getEdad (){return edad;}
    
    public void setPeso (double peso){this.peso = peso;}
    public double getPeso (){return peso;}
    
    public void setAltura (double altura){this.altura = altura;}
    public double getAltura (){return altura;}
    
    
    //Metodos
    public String mostrarUsuario (){
        String usuario = "-----------------\nDatos del usuario\n-----------------\n\n";
        usuario += "Id: " + id + "\n";
        usuario += "Nombre: " + nombre + "\n";
        usuario += "Cedula: " + cedula + "\n";
        usuario += "Nombre de Usuario: " + nombreUsuario + "\n";
        usuario += "Contrasena: " + contrasena + "\n";
        usuario += "Correo: " + correo + "\n";
        usuario += "Telefono: " + telefono + "\n";
        usuario += "Edad: " + edad + "\n";
        usuario += "Peso: " + peso + "\n";
        usuario += "Altura: " + altura + "\n\n";
        
        return usuario;     
    }
}
