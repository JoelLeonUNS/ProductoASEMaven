package modelo;

import BaseDeDatos.UsuarioDAO;
import medicos.Usuario;

public class ModeloUsuario {
    
    private final Usuario usuario;
    private int numeroIntentos;
    private boolean datosValido = false;
    private int idUsuario;
    private final CareTaker careTaker = new CareTaker();
    private String recuerdoSesion; // usuario;clave

    public ModeloUsuario() {
        usuario = new Usuario();
    }

    public Usuario getUsuarioBD() {
        UsuarioDAO uDAO = new UsuarioDAO();     
        return uDAO.read(idUsuario);
    }
 
    public Usuario getUsuario() {
        return usuario;
    }

    public CareTaker getCareTaker() {
        return careTaker;
    }

    public int getNumeroIntentos() {
        return numeroIntentos;
    }

    public String getRecuerdoSesion() {
        return recuerdoSesion;
    }
 
    public void setRecuerdoSesion(String recuerdoSesion) {
        this.recuerdoSesion = recuerdoSesion;
    }
    
    public void resetNumeroIntentos() {
        numeroIntentos = 0;
    }

    public boolean isDatosValido() {
        return datosValido;
    }
    
    public boolean isHabilitado() {
        return getUsuarioBD().isEstado();
    }

    public void iniciarSesion() {
        UsuarioDAO uDAO = new UsuarioDAO();
        for (int i = 0; i < uDAO.count(); i++) {
            if (uDAO.read(i).getUsuario().equals(usuario.getUsuario())
                && uDAO.read(i).getClave().equals(usuario.getClave())) {
                datosValido = true;
                idUsuario = i;
                break;
            } else {
                datosValido = false;
            }
        }
        if (!datosValido) numeroIntentos++;
    }
    
    public void recordarSesion() {
        careTaker.agregar(guardarSesion());
    }
    
    public void cerrarSesion() {
        restaurarSesion(careTaker.getUltimo());
    }
    
    public Memento guardarSesion() {
        return new Memento(recuerdoSesion);
    }
    
    public void restaurarSesion(Memento m) {
        recuerdoSesion = m.getEstado();
    }
}
