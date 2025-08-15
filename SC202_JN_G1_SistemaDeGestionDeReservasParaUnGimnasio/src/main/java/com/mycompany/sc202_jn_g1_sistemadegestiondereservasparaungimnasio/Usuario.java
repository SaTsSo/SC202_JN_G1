/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc202_jn_g1_sistemadegestiondereservasparaungimnasio;
import javax.swing.JOptionPane;

/**
 *
 * @author XPC
 */
public class Usuario {
    //Atributos
    private String cedula;
    private String nombre;
    private double peso;
    private String telefono;
    private String correo;
    private String contrasena;
    private int edad;
    private boolean activo = true;

    // Constructores
    public Usuario(String cedula, String nombre, double peso, String telefono, String correo, String contrasena, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.peso = peso;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.edad = edad;
    }
    //Getters-Setters
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
    
    public boolean isActivo() {
    return activo;
    }
    
    public void setActivo (boolean activo) {
    this.activo = activo;
    }
    //Metodo que detecta si un elemento es vacio
    
    private static boolean esVacio(Usuario u) {
        return u != null
            && "1".equals(u.getCedula())
            && u.getNombre() != null
            && u.getNombre().equalsIgnoreCase("vacio");
    }
    //Metodo para verificar si existe la cedula del usuario
    
    public static boolean existeCedula(Usuario[] usuarios, String cedula) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getCedula().equals(cedula)) {
                return true;
            }
        } //Si no exite retorna false
        return false;
    }
    
    // Metodo verificar si existe correo
    public static boolean existeCorreo(Usuario[] usuarios, String correo) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] != null && usuarios[i].getCorreo().equalsIgnoreCase(correo)) {
                return true;
            }
        }
        return false;
    }
    
    // Metodo para registrar usuario en el primer espacio libre
    public static boolean registrar(Usuario[] usuarios, Usuario nuevo) {
        if (existeCedula(usuarios, nuevo.getCedula())) return false;
        if (existeCorreo(usuarios, nuevo.getCorreo())) return false;

        for (int i = 0; i < usuarios.length; i++) {
        boolean slotVacio = (usuarios[i] != null) &&
                            usuarios[i].getCedula().equals("1") &&
                            usuarios[i].getNombre() != null &&
                            usuarios[i].getNombre().equals("vacio");

        if (usuarios[i] == null || slotVacio) {
            usuarios[i] = nuevo;
            return true;
        }
    }
    return false; // Sin espacio
}
        // Metodo que edita por cedula 
    public static boolean editar(Usuario[] usuarios, String cedula,
                                 String nuevoNombre, Double nuevoPeso,
                                 String nuevoTelefono, String nuevoCorreo,
                                 String nuevaContrasena, Integer nuevaEdad,
                                 Boolean nuevoActivo) {
        for (int i = 0; i < usuarios.length; i++) {
            Usuario u = usuarios[i];
            if (u != null && u.getCedula().equals(cedula)) {
                
               // Si piden cambiar correo, validamos que no exista en otro usuario

                if (nuevoCorreo != null && !nuevoCorreo.equalsIgnoreCase(u.getCorreo())) {
                    if (existeCorreo(usuarios, nuevoCorreo)) return false;
                    u.setCorreo(nuevoCorreo);
                }

                if (nuevoNombre != null) u.setNombre(nuevoNombre);
                if (nuevoPeso   != null && nuevoPeso.doubleValue() > 0) u.setPeso(nuevoPeso.doubleValue());
                if (nuevoTelefono != null) u.setTelefono(nuevoTelefono);
                if (nuevaContrasena != null) u.setContrasena(nuevaContrasena);
                if (nuevaEdad != null && nuevaEdad.intValue() >= 0) u.setEdad(nuevaEdad.intValue());
                if (nuevoActivo != null) u.setActivo(nuevoActivo.booleanValue());

                return true;
            }
        }
        return false; // no se encontró la cédula
    }
    
    // Metodo para loguearse / Acepta cedula o correo + contrasena
    public static boolean login(Usuario[] usuarios, String usuario, String pass) {
        for (int i = 0; i < usuarios.length; i++) {
            Usuario u = usuarios[i];
            if (u != null && u.isActivo()) {
                boolean usuarioOk = u.getCedula().equals(usuario) || u.getCorreo().equalsIgnoreCase(usuario);
                boolean passOk = u.getContrasena().equals(pass);
                if (usuarioOk && passOk) return true;
            }
        }
        return false;
    }
    
    public String resumen() {
        return "Cédula: " + cedula + " | Nombre: " + nombre + " | Tel: " + telefono +
               " | Correo: " + correo + " | Peso: " + peso + " | Edad: " + edad +
               " | Activo: " + activo;
    }
}
