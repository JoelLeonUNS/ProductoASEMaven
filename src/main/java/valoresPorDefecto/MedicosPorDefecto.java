package valoresPorDefecto;

import BaseDeDatos.MedicoDAO;
import BaseDeDatos.UsuarioDAO;
import medicos.Medico;
import medicos.Usuario;

public class MedicosPorDefecto {

    public static void poblar() {

        UsuarioDAO uDAO = new UsuarioDAO();
        MedicoDAO mDAO = new MedicoDAO();
        uDAO.create(new Usuario("Joel", "123", true, "User"));
        uDAO.create(new Usuario("Angie", "123", true, "User"));
        uDAO.create(new Usuario("Abner", "123", true, "Admin"));
        uDAO.create(new Usuario("Alex", "123", true, "Admin"));

        mDAO.create(new Medico("Leon", "Joel", "960181410", "73944739", uDAO.read(0)));
        mDAO.create(new Medico("Mariana", "Lopez", "987654321", "12345678", uDAO.read(1)));
        mDAO.create(new Medico("Fernando", "González", "976543210", "87654321", uDAO.read(2)));
    }

}
