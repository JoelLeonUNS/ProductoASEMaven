package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class HistoriaClinicaEnfermedadDAO<T> {

    public Connection conector;
    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    public abstract T create(int id, T obj);

    public abstract T delete(int id, T obj);

    public abstract T update(int id, T obj);

    public abstract T read(int id, int idSec);

    public abstract List<T> listed(int id);

    public abstract boolean exeUpdate() throws SQLException;
    
    public Connection getConector() {
        return conector;
    }

    public void setConector(Connection conector) {
        this.conector = conector;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
}