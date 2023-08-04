package sqlServerDAO;

import DAO.MedicoDAO;
import factoryDAO.DAOFactory;
import factoryDAO.SqlServerDAOFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import medicos.Medico;
import medicos.Usuario;

public class SqlServerMedicoDAO extends MedicoDAO<Medico> {

    @Override
    public Medico create(Medico obj) {
        try {
            setSql("INSERT INTO Medico (idMedico, idUsuario, dni, apellido, nombre, telefono) VALUES (?, ?, ?, ?, ?, ?)");
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, obj.getIdMedico());
            getPs().setInt(2, obj.getUsuario().getIdUsuario());
            getPs().setString(3, obj.getDNI());
            getPs().setString(4, obj.getApellidoMedico());
            getPs().setString(5, obj.getNombreMedico());
            getPs().setString(6, obj.getTelefonoMedico());

            if (!exeUpdate()) {
                obj = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    @Override
    public Medico delete(Medico obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medico update(Medico obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medico read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Medico> listed() {
        List<Medico> listaMedicos = new ArrayList<>();
        try {
            setSql("SELECT * FROM Medico");
            setPs(getConector().prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Medico medico = new Medico();
                medico.setIdMedico(getRs().getInt("idMedico"));
                
                DAOFactory dao = new SqlServerDAOFactory();
                medico.setUsuario((Usuario) dao.getUsuario().read(getRs().getInt("idUsuario")));
                
                medico.setDNI(getRs().getString("dni"));
                medico.setApellidoMedico(getRs().getString("apellido"));
                medico.setNombreMedico(getRs().getString("nombre"));
                medico.setTelefonoMedico(getRs().getString("telefono"));

                listaMedicos.add(medico);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaMedicos;
    }

    @Override
    public boolean exeUpdate() throws SQLException {
        boolean exito;
        try {
            getPs().executeUpdate();
            getConector().commit();
            exito = true;
            System.out.println("Transacción exitosa");
        } catch (SQLException ex) {
            getConector().rollback();
            exito = false;
            System.out.println("Transacciónn NO exitosa");
        } finally {
            if (getPs() != null) {
                getPs().close();
            }
        }
        return exito;
    }

}
