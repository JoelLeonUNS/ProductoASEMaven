package presentador;

import modelo.ModeloUsuario;

public class PresentadorLogin {
    private ModeloUsuario mUsuario;
    
    public PresentadorLogin() {   
    }
    
    public void setModelo(ModeloUsuario mUsuario) {
        this.mUsuario = mUsuario;
    }

    public void setDatosUsuario(String usuario, String clave) {
        mUsuario.getUsuario().setUsuario(usuario);
        mUsuario.getUsuario().setClave(clave);
    }

    public String getUsuarioRecordado() {
        if (mUsuario.getRecuerdoSesion() != null) return mUsuario.getRecuerdoSesion().split(";")[0];
        else return "";
    }

    public String getClaveRecordada() {
        if (mUsuario.getRecuerdoSesion() != null) return mUsuario.getRecuerdoSesion().split(";")[1];
        else return "";
    }
    
    public String getUsuarioRolBD() {
        return mUsuario.getUsuarioBD().getRol();
    }

    public void iniciarSesion() {
        mUsuario.iniciarSesion();
    }

    public void recordarSesion() {
        mUsuario.recordarSesion();
    }
    
    public void noRecordarSesion() {
        mUsuario.setRecuerdoSesion(null);
    }

    public boolean isRecordado() {
        mUsuario.setRecuerdoSesion(mUsuario.getUsuario().getUsuario() + ";" + mUsuario.getUsuario().getClave());
        return mUsuario.getCareTaker().isExiste(mUsuario.guardarSesion());
    }
    
    public void cerrarSesion() {
        try {
            mUsuario.cerrarSesion();
        } catch (Exception e) {
        }
    }
    
    public void resetNumeroIntentos() {
        mUsuario.resetNumeroIntentos();
    }

    public boolean isAcceso() {
        return mUsuario.isDatosValido() && mUsuario.getNumeroIntentos() < 3;
    }
    
    public boolean isHabilitado() {
        return mUsuario.isHabilitado();
    }

    public boolean isBloqueado() {
        return mUsuario.getNumeroIntentos() > 2;
    }

    public String showMensaje() {
        if (!mUsuario.isDatosValido()) {
            return "Datos incorrectos o usuario no encontrado.\nNro Intentos: " + mUsuario.getNumeroIntentos();
        } else {
            return "Inicio de Sesion exitoso.";
        }
    }
    
}
