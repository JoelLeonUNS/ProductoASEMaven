package sqlServerDAO;

import DAO.ConsultaDAO;
import factoryDAO.DAOFactory;
import factoryDAO.SqlServerDAOFactory;
import historias.HistoriaClinica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pacientes.Paciente;

public class SqlServerHistoriaClinicaDAO extends ConsultaDAO<HistoriaClinica> {

    @Override
    public HistoriaClinica create(HistoriaClinica obj) {
        try {
            setSql("INSERT INTO HistoriaClinica (idHistoriaClinica, idPaciente, otrosAntecedentes) VALUES (?, ?, ?)");
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, obj.getIdHistoriaClinica());
            getPs().setInt(2, obj.getPaciente().getIdPaciente());
            getPs().setString(3, obj.getOtrosAntecedentesPatologicos());

            if (!exeUpdate()) obj = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    @Override
    public HistoriaClinica delete(HistoriaClinica obj) {
        try {
            setSql("DELETE FROM HistoriaClinica WHERE idHistoriaClinica = ?");
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, obj.getIdHistoriaClinica());

            if (!exeUpdate()) obj = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    @Override
    public HistoriaClinica update(HistoriaClinica obj) {
        try {
            setSql("UPDATE HistoriaClinica SET idPaciente = ?, otrosAntecedentes = ? WHERE idHistoriaClinica = ?");
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, obj.getPaciente().getIdPaciente());
            getPs().setString(2, obj.getOtrosAntecedentesPatologicos());
            getPs().setInt(3, obj.getIdHistoriaClinica());

            if (!exeUpdate()) obj = null;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    @Override
    public HistoriaClinica read(int idHistoriaClinica) {
        setSql("SELECT * FROM HistoriaClinica WHERE idHistoriaClinica = ?");
        HistoriaClinica historiaClinica = null;
        try {
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, idHistoriaClinica);
            setRs(getPs().executeQuery());

            if (getRs().next()) {
                historiaClinica = new HistoriaClinica();
                historiaClinica.setIdHistoriaClinica(getRs().getInt("idHistoriaClinica"));

                DAOFactory dao = new SqlServerDAOFactory();
                historiaClinica.setPaciente((Paciente) dao.getPaciente().read(getRs().getInt("idPaciente")));
                historiaClinica.setOtrosAntecedentesPatologicos(getRs().getString("otrosAntecedentes"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return historiaClinica;
    }

    @Override
    public List<HistoriaClinica> listed() {
        List<HistoriaClinica> listaHistoriasClinicas = new ArrayList<>();
        try {
            setSql("SELECT * FROM HistoriaClinica");
            setPs(getConector().prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                HistoriaClinica historiaClinica = new HistoriaClinica();
                historiaClinica.setIdHistoriaClinica(getRs().getInt("idHistoriaClinica"));
                
                DAOFactory dao = new SqlServerDAOFactory();
                historiaClinica.setPaciente((Paciente) dao.getPaciente().read(getRs().getInt("idPaciente")));
                historiaClinica.setOtrosAntecedentesPatologicos(getRs().getString("otrosAntecedentes"));

                listaHistoriasClinicas.add(historiaClinica);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaHistoriasClinicas;
    }
    
    public int lastId() {
        int lastId = 0;
        try {
            setSql("SELECT TOP 1 idHistoriaClinica FROM HistoriaClinica ORDER BY idHistoriaClinica DESC");
            setPs(getConector().prepareStatement(getSql()));
            setRs(getPs().executeQuery());
            if (getRs().next()) {
                lastId = getRs().getInt("idHistoriaClinica");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lastId;
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