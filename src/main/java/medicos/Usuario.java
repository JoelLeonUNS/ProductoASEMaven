
package medicos;

public class Usuario {
    private String usuario;
    private String clave;
    private boolean estado;
    private String rol;

    public Usuario() {
    }

    public Usuario(String usuario, String clave, boolean estado, String rol) {
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
