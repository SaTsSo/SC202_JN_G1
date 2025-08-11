import javax.swing.JOptionPane;
/*
public class Reserva {
    private static int contadorReservas = 1;
    private final int idReserva;
    private Usuario usuario;
    private Horario horario;

    public Reserva(Usuario usuario, Horario horario) {
        this.idReserva = contadorReservas++;
        this.usuario = usuario;
        this.horario = horario;
    }

    public int getIdReserva() { return idReserva; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Horario getHorario() { return horario; }
    public void setHorario(Horario horario) { this.horario = horario; }

    public String mostrarReserva() {
        return "ID: " + idReserva + "\nUsuario: " + usuario.getNombre() + "\nHorario: " + horario.mostrarHorario();
    }

    public static void menuReservas(Reserva[] reservas, Usuario[] usuarios, Horario[] horarios) {
        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                "Menú Reservas\n" +
                "1. Crear reserva\n" +
                "2. Listar reservas\n" +
                "3. Salir\n" +
                "Elige opción:"
            );
            if (opcion == null) break;
            switch (opcion) {
                case "1": {
                    String listaUsuarios = "";
                    for (int i = 0; i < usuarios.length; i++) {
                        if (usuarios[i] != null && !usuarios[i].getNombre().equalsIgnoreCase("vacio")) {
                            listaUsuarios += i + ": " + usuarios[i].getNombre() + "\n";
                        }
                    }
                    if (listaUsuarios.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
                        break;
                    }
                    String entradaUsuario = JOptionPane.showInputDialog("Seleccione usuario por índice:\n" + listaUsuarios);
                    if (entradaUsuario == null) break;
                    int idxUsuario;
                    try {
                        idxUsuario = Integer.parseInt(entradaUsuario);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Índice inválido.");
                        break;
                    }
                    if (idxUsuario < 0 || idxUsuario >= usuarios.length || usuarios[idxUsuario] == null) {
                        JOptionPane.showMessageDialog(null, "Usuario no válido.");
                        break;
                    }

                    String listaHorarios = "";
                    for (int i = 0; i < horarios.length; i++) {
                        if (horarios[i] != null) {
                            listaHorarios += i + ": " + horarios[i].mostrarHorario() + "\n";
                        }
                    }
                    if (listaHorarios.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay horarios disponibles.");
                        break;
                    }
                    String entradaHorario = JOptionPane.showInputDialog("Seleccione horario por índice:\n" + listaHorarios);
                    if (entradaHorario == null) break;
                    int idxHorario;
                    try {
                        idxHorario = Integer.parseInt(entradaHorario);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Índice inválido.");
                        break;
                    }
                    if (idxHorario < 0 || idxHorario >= horarios.length || horarios[idxHorario] == null) {
                        JOptionPane.showMessageDialog(null, "Horario no válido.");
                        break;
                    }

                    boolean guardado = false;
                    for (int i = 0; i < reservas.length; i++) {
                        if (reservas[i] == null) {
                            reservas[i] = new Reserva(usuarios[idxUsuario], horarios[idxHorario]);
                            JOptionPane.showMessageDialog(null, "Reserva creada con éxito.");
                            guardado = true;
                            break;
                        }
                    }
                    if (!guardado) {
                        JOptionPane.showMessageDialog(null, "No hay espacio para más reservas.");
                    }
                    break;
                }
                case "2": {
                    String lista = "";
                    for (int i = 0; i < reservas.length; i++) {
                        if (reservas[i] != null) {
                            lista += (i + 1) + ". " + reservas[i].mostrarReserva() + "\n\n";
                        }
                    }
                    if (lista.isEmpty()) {
                        lista = "No hay reservas registradas.";
                    }
                    JOptionPane.showMessageDialog(null, lista);
                    break;
                }
                case "3":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}

*/