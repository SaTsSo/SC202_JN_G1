package com.mycompany.proyectoo;
public class reserva {
    private static int contadorReservas = 1;
    private int idReserva;
    private Usuario usuario;
    private horario horario;

    public reserva(Usuario usuario, horario horario) {
        this.idReserva = contadorReservas++;
        this.usuario = usuario;
        this.horario = horario;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuArio usuario) {
        this.usuario = usuario;
    }

    public horario getHorario() {
        return horario;
    }

    public void setHorario(horario horario) {
        this.horario = horario;
    }

    public String mostrarReserva() {
        return "ID: " + idReserva + "\nUsuario: " + usuario.getNombre() + "\nHorario: " + horario.mostrarHorario();
    }
