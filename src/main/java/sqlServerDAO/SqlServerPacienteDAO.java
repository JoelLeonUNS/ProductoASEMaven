package sqlServerDAO;

import DAO.PacienteDAO;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.Escuela;
import pacientes.Alumno;
import pacientes.Paciente;
import pacientes.Trabajador;

public class SqlServerPacienteDAO extends PacienteDAO<Paciente> {

    @Override
    public Paciente create(Paciente obj) {
        try {
            setSql("INSERT INTO Paciente (idPaciente, dni, nombre, apellido, fechaNacimiento, lugarNacimiento, distrito, departamento, direccion, telefono, estadoCivil, tipoPaciente, idEscuela, areaTrabajo, docente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, obj.getIdPaciente());
            getPs().setString(2, obj.getDni());
            getPs().setString(3, obj.getNombre());
            getPs().setString(4, obj.getApellido());
            getPs().setDate(5, Date.valueOf(obj.getFechaNac()));
            getPs().setString(6, obj.getLugarNac());
            getPs().setString(7, obj.getDistrito());
            getPs().setString(8, obj.getDepartamento());
            getPs().setString(9, obj.getDireccion());
            getPs().setString(10, obj.getTelefono());
            getPs().setString(11, obj.getEstadoCivil());
            getPs().setString(12, obj.getTipoPaciente());
            
            if (obj instanceof Alumno alumno) {
                getPs().setInt(13, (alumno.getEscuela().getIdEscuela()));
                getPs().setNull(14, java.sql.Types.VARCHAR);
                getPs().setNull(15, java.sql.Types.BOOLEAN);
            }
            if (obj instanceof Trabajador trabajador) {
                getPs().setNull(13, java.sql.Types.INTEGER);
                getPs().setString(14, trabajador.getAreaTrabajo());
                getPs().setBoolean(15, trabajador.isDocente());
            }
            if (!exeUpdate()) {
                obj = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return obj;
    }

    @Override
    public Paciente delete(Paciente obj) {
        try {
            setSql("DELETE FROM Paciente WHERE idPaciente = ?");
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, obj.getIdPaciente());

            if (!exeUpdate()) {
                obj = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    @Override
    public Paciente update(Paciente obj) {
        try {
            setSql("UPDATE Paciente SET dni = ?, nombre = ?, apellido = ?, fechaNacimiento = ?, lugarNacimiento = ?, "
                    + "distrito = ?, departamento = ?, direccion = ?, telefono = ?, estadoCivil = ?, tipoPaciente = ?, "
                    + "idEscuela = ?, areaTrabajo = ?, docente = ? WHERE idPaciente = ?");
            setPs(getConector().prepareStatement(getSql()));

            // Set the values for the prepared statement
            getPs().setString(1, obj.getDni());
            getPs().setString(2, obj.getNombre());
            getPs().setString(3, obj.getApellido());
            getPs().setDate(4, Date.valueOf(obj.getFechaNac()));
            getPs().setString(5, obj.getLugarNac());
            getPs().setString(6, obj.getDistrito());
            getPs().setString(7, obj.getDepartamento());
            getPs().setString(8, obj.getDireccion());
            getPs().setString(9, obj.getTelefono());
            getPs().setString(10, obj.getEstadoCivil());
            getPs().setString(11, obj.getTipoPaciente());
            
            if (obj instanceof Alumno alumno) {
                getPs().setInt(13, (alumno.getEscuela().getIdEscuela()));
                getPs().setNull(14, java.sql.Types.VARCHAR);
                getPs().setNull(15, java.sql.Types.BOOLEAN);
            }
            if (obj instanceof Trabajador trabajador) {
                getPs().setNull(13, java.sql.Types.INTEGER);
                getPs().setString(14, trabajador.getAreaTrabajo());
                getPs().setBoolean(15, trabajador.isDocente());
            }

            if (!exeUpdate()) {
                obj = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return obj;
    }

    @Override
    public Paciente read(int id) {
        setSql("SELECT * FROM Paciente WHERE idPaciente = ?");
        Paciente paciente = null;
        try {
            setPs(getConector().prepareStatement(getSql()));
            getPs().setInt(1, id);
            setRs(getPs().executeQuery());

            if (getRs().next()) {
                switch (getRs().getString("tipoPaciente")) {
                    case "Alumno" -> {
                        paciente = new Alumno();
                        ((Alumno) paciente).setEscuela(Escuela.getPorId(getRs().getInt("idEscuela")));
                    }
                    case "Trabajador" -> {
                        paciente = new Trabajador();
                        ((Trabajador) paciente).setAreaTrabajo(getRs().getString("areaTrabajo"));
                        ((Trabajador) paciente).setDocente(getRs().getBoolean("docente"));
                    }
                }
                if (paciente != null) {
                    paciente.setIdPaciente(getRs().getInt("idPaciente"));
                    paciente.setDni(getRs().getString("dni"));
                    paciente.setNombre(getRs().getString("nombre"));
                    paciente.setApellido(getRs().getString("apellido"));
                    paciente.setFechaNac(getRs().getDate("fechaNacimiento").toLocalDate());
                    paciente.setLugarNac(getRs().getString("lugarNacimiento"));
                    paciente.setDistrito(getRs().getString("distrito"));
                    paciente.setDepartamento(getRs().getString("departamento"));
                    paciente.setDireccion(getRs().getString("direccion"));
                    paciente.setTelefono(getRs().getString("telefono"));
                    paciente.setEstadoCivil(getRs().getString("estadoCivil"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return paciente;
    }

    @Override
    public List<Paciente> listed() {
        List<Paciente> listaPacientes = new ArrayList<>();
        try {
            setSql("SELECT * FROM Paciente");
            setPs(getConector().prepareStatement(getSql()));
            setRs(getPs().executeQuery());

            while (getRs().next()) {
                Paciente paciente = null;
                switch (getRs().getString("tipoPaciente")) {
                    case "Alumno" -> {
                        paciente = new Alumno();
                        ((Alumno) paciente).setEscuela(Escuela.getPorId(getRs().getInt("idEscuela")));
                    }
                    case "Trabajador" -> {
                        paciente = new Trabajador();
                        ((Trabajador) paciente).setAreaTrabajo(getRs().getString("areaTrabajo"));
                        ((Trabajador) paciente).setDocente(getRs().getBoolean("docente"));
                    }
                    default -> {
                    }
                }
                if (paciente != null) {
                    paciente.setIdPaciente(getRs().getInt("idPaciente"));
                    paciente.setDni(getRs().getString("dni"));
                    paciente.setNombre(getRs().getString("nombre"));
                    paciente.setApellido(getRs().getString("apellido"));
                    paciente.setFechaNac(getRs().getDate("fechaNacimiento").toLocalDate());
                    paciente.setLugarNac(getRs().getString("lugarNacimiento"));
                    paciente.setDistrito(getRs().getString("distrito"));
                    paciente.setDepartamento(getRs().getString("departamento"));
                    paciente.setDireccion(getRs().getString("direccion"));
                    paciente.setTelefono(getRs().getString("telefono"));
                    paciente.setEstadoCivil(getRs().getString("estadoCivil"));

                    listaPacientes.add(paciente);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaPacientes;
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
