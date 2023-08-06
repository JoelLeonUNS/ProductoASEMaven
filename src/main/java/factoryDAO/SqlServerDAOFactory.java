package factoryDAO;

import DAO.HistoriaClinicaDAO;
import DAO.UsuarioDAO;
import DAO.MedicoDAO;
import DAO.ConsultaDAO;
import DAO.ExamenClinicoDAO;
import DAO.ExamenFisicoDAO;
import DAO.ExamenMedicoDAO;
import DAO.FamiliarDAO;
import DAO.PacienteDAO;
import conexiones.SqlServerConexion;
import sqlServerDAO.SqlServerConsultaDAO;
import sqlServerDAO.SqlServerHistoriaClinicaDAO;
import sqlServerDAO.SqlServerMedicoDAO;
import sqlServerDAO.SqlServerPacienteDAO;
import sqlServerDAO.SqlServerUsuarioDAO;

public class SqlServerDAOFactory extends DAOFactory {

    @Override
    public UsuarioDAO getUsuario() {
        SqlServerUsuarioDAO usuarioDAO = new SqlServerUsuarioDAO();
        usuarioDAO.setConector(SqlServerConexion.getInstance());
        return usuarioDAO;
    }

    @Override
    public MedicoDAO getMedico() {
        SqlServerMedicoDAO medicoDAO = new SqlServerMedicoDAO();
        medicoDAO.setConector(SqlServerConexion.getInstance());
        return medicoDAO;
    }

    @Override
    public PacienteDAO getPaciente() {
        SqlServerPacienteDAO pacienteDAO = new SqlServerPacienteDAO();
        pacienteDAO.setConector(SqlServerConexion.getInstance());
        return pacienteDAO;
    }

    @Override
    public FamiliarDAO getFamiliar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public HistoriaClinicaDAO getHistoriaClinica() {
        SqlServerHistoriaClinicaDAO historiaClinicaDAO = new SqlServerHistoriaClinicaDAO();
        historiaClinicaDAO.setConector(SqlServerConexion.getInstance());
        return historiaClinicaDAO;
    }

    @Override
    public ConsultaDAO getConsulta() {
        SqlServerConsultaDAO consultaDAO = new SqlServerConsultaDAO();
        consultaDAO.setConector(SqlServerConexion.getInstance());
        return consultaDAO;
    }

    @Override
    public ExamenFisicoDAO getExamenFisico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ExamenMedicoDAO getExamenMedico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ExamenClinicoDAO getExamenClinico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
