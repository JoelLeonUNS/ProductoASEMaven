package factoryDAO;

import BaseDeDatos.HistoriaClinicaDAO;
import DAO.UsuarioDAO;
import DAO.MedicoDAO;
import DAO.ConsultaDAO;
import DAO.ExamenClinicoDAO;
import DAO.ExamenFisicoDAO;
import DAO.ExamenMedicoDAO;
import DAO.FamiliarDAO;
import DAO.PacienteDAO;
import conexiones.SqlServerConexion;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PacienteDAO getPaciente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public FamiliarDAO getFamiliar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HistoriaClinicaDAO getHistoriaClinica() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ConsultaDAO getConsulta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
