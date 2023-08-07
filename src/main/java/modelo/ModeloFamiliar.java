package modelo;

import factoryDAO.DAOFactory;
import factoryDAO.SqlServerDAOFactory;
import pacientes.Familiar;

public class ModeloFamiliar {
    private DAOFactory dao;
    private Familiar familiar;

    public ModeloFamiliar() {
        this.familiar = new Familiar();
        this.dao = new SqlServerDAOFactory(); // o MySql
    }

    public Familiar getFamiliar() {
        return familiar;
    }

    public void setFamiliar(Familiar familiar) {
        this.familiar = familiar;
    }
    
}
