
package BaseDeDatos;

import medicos.Usuario;

public class UsuarioDAO {
    
    public void create(Usuario usuario) {
        BD.getUsuarios().put(BD.IdUsuario(), usuario);
        System.out.println("Usuario creado: " + usuario.getUsuario() + " | " + usuario.getRol()+ " | " + usuario.getClave());
    }
    
    public Usuario read(int id) {
        return BD.getUsuarios().get(id);
    }

    public void update(Usuario usuario, int id) {
        if (BD.getUsuarios().containsKey(id)) {
            BD.getUsuarios().put(id, usuario);
            System.out.println("Usuario actualizado: " + usuario.getUsuario()+ " " + usuario.getRol());
        } else {
            System.out.println("No se puede actualizar el usuario. ID no encontrado: " + id);
        }
    }

    public void delete(int id) {
        if (BD.getUsuarios().containsKey(id)) {
            Usuario usuarioEliminado = BD.getUsuarios().remove(id);
            System.out.println("Médico eliminado: " + usuarioEliminado.getUsuario()+" "+usuarioEliminado.getRol());
        } else {
            System.out.println("No se puede eliminar el usuario. ID no encontrado: " + id);
        }
    }
    
    public int count() { 
        return BD.getUsuarios().size();
    }
}
