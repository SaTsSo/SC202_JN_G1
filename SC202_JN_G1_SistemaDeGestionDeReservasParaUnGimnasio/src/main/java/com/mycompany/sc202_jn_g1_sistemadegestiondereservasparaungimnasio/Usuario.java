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
    private boolean activo = true;


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
    
    public boolean isActivo() {
    return activo;
    }
    
    public void setActivo (boolean activo) {
    this.activo = activo;
    }

    private static boolean strEq (String a, String b) {
        if (a == null || b == null) return a == b;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) !=b.charAt(i)) return false;
        return true;
     }
    
    private static char toLower(char c) {
    return (c>='A'&&c<='Z')?(char)(c+32):c;}
    private static boolean strEqIgnoreCase(String a, String b){
        if (a == null || b == null) return a == b;
        if (a.length() != b.length()) return false;
        for (int i=0;i<a.length();i++) if (toLower(a.charAt(i))!=toLower(b.charAt(i))) return false;
        return true;
    }
    
    private static boolean esVacio(Usuario u) {
        if (u == null) return true;
        boolean cedulaVacia = strEq(u.cedula, "1");
        boolean nombreVacio = strEqIgnoreCase(u.nombre, "vacio");
        return cedulaVacia && nombreVacio;
    }

    public static int buscarPorCedula(Usuario[] bd, String ced) {
        if (bd == null || ced == null) return -1;
        for (int i=0;i<bd.length;i++) {
            if (bd[i]!=null && !esVacio(bd[i]) && strEq(bd[i].cedula, ced)) return i;
        }
        return -1;
    }
    
    public static int buscarPorCorreo(Usuario[] bd, String email) {
        if (bd == null || email == null) return -1;
        for (int i=0;i<bd.length;i++) {
            if (bd[i]!=null && !esVacio(bd[i]) && strEqIgnoreCase(bd[i].correo, email)) return i;
        }
        return -1;
    }
    
    public static boolean registrar(Usuario[] bd, Usuario nuevo) {
        if (bd == null || nuevo == null) return false;
        if (buscarPorCedula(bd, nuevo.cedula) != -1) return false;
        if (buscarPorCorreo(bd, nuevo.correo) != -1) return false;

        for (int i=0;i<bd.length;i++) {
            if (bd[i] == null || esVacio(bd[i])) { bd[i] = nuevo; return true; }
        }
        return false;
    }
    
    public static boolean editarPorCedula(Usuario[] bd, String cedulaClave,
                                          String nuevoNombre, Double nuevoPeso,
                                          String nuevoTelefono, String nuevoCorreo,
                                          String nuevaContrasena,
                                          Boolean nuevoActivo) {
        if (bd == null || cedulaClave == null) return false;
        int idx = buscarPorCedula(bd, cedulaClave);
        if (idx == -1) return false;

        if (nuevoCorreo != null) {
            for (int i=0;i<bd.length;i++){
                if (i==idx || bd[i]==null || esVacio(bd[i])) continue;
                if (strEqIgnoreCase(bd[i].correo, nuevoCorreo)) return false;
            }
            bd[idx].correo = nuevoCorreo;
        }
        
         if (nuevoNombre != null)      bd[idx].nombre = nuevoNombre;
        if (nuevoPeso != null)        bd[idx].peso = nuevoPeso.doubleValue();
        if (nuevoTelefono != null)    bd[idx].telefono = nuevoTelefono;
        if (nuevaContrasena != null)  bd[idx].contrasena = nuevaContrasena;
        if (nuevoActivo != null)      bd[idx].activo = nuevoActivo.booleanValue();
        return true;
    }
    
    public static Usuario login(Usuario[] bd, String usuario, String pass) {
        if (bd == null || usuario == null || pass == null) return null;
        for (int i=0;i<bd.length;i++) {
            Usuario u = bd[i];
            if (u == null || esVacio(u) || !u.activo) continue;
            boolean idOk = strEq(u.cedula, usuario) || strEqIgnoreCase(u.correo, usuario);
            if (idOk && strEq(u.contrasena, pass)) return u;
        }
        return null;
    }
    
    public String resumen() {
        return "Ced: " + cedula + " | Nom: " + nombre + " | Tel: " + telefono +
               " | Correo: " + correo + " | Activo: " + activo;
    }
} 
