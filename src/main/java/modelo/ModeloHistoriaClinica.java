package modelo;

import factoryDAO.DAOFactory;
import factoryDAO.SqlServerDAOFactory;
import historias.HistoriaClinica;
import java.util.ArrayList;
import java.util.List;
import pacientes.Familiar;
import pacientes.Paciente;

public class ModeloHistoriaClinica {

    private final DAOFactory dao;
    private HistoriaClinica historiaClinica;
    private ArrayList<Integer> idHistorias;

    public ModeloHistoriaClinica() {
        this.historiaClinica = new HistoriaClinica();
        this.historiaClinica.setPaciente(new Paciente());
        this.dao = new SqlServerDAOFactory(); // o MySql
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public HistoriaClinica buscarHistoriaClinicaDNI(String dni) {
        for (HistoriaClinica historia : (List<HistoriaClinica>) dao.getHistoriaClinica().listed()) {
            if (historia.getPaciente().getDni().equals(dni)) {
                return historia;
            }
        }
        return null;
    }

    public void buscarHistoriaCoincidente(String cadena) {
        idHistorias = new ArrayList<>();
        for (HistoriaClinica historia : (List<HistoriaClinica>) dao.getHistoriaClinica().listed()) {
            if (historia.getPaciente().getNombre().toUpperCase().contains(cadena.toUpperCase()) || historia.getPaciente().getApellido().toUpperCase().contains(cadena.toUpperCase())) {
                idHistorias.add(historia.getIdHistoriaClinica());
            }
        }
    }

    public ArrayList<HistoriaClinica> getHistoriasCoincidentes() {
        ArrayList<HistoriaClinica> historiaClinicas = new ArrayList<>();
        for (Integer idHistoria : idHistorias) {
            historiaClinicas.add((HistoriaClinica) dao.getHistoriaClinica().read(idHistoria));
        }
        return historiaClinicas;
    }

    public void registrarHistoriaClinica() {
        historiaClinica.setIdHistoriaClinica(dao.getHistoriaClinica().lastId() + 1);
        dao.getHistoriaClinica().create(historiaClinica);
    }

    public void editarHistoriaClinica() {
        dao.getHistoriaClinica().update(historiaClinica);
    }

    public void agregarFamiliar(Familiar familiar) {
        Integer indiceFamiliar = null;
        for (Familiar familiarExiste : historiaClinica.getPaciente().getFamiliares()) {
            if (familiarExiste.getParentesco().equalsIgnoreCase(familiar.getParentesco())) {
                indiceFamiliar = historiaClinica.getPaciente().getFamiliares().indexOf(familiarExiste);
                break;
            }
        }
        if (indiceFamiliar != null) {
            historiaClinica.getPaciente().getFamiliares().set(indiceFamiliar, familiar);
        } else {
            historiaClinica.getPaciente().agregarFamiliar(familiar);
        }
    }
    
    public void agregarEnfermedad(Enfermedad enfermedad) {
        
    }
    
}

/*
    public Alumno getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Alumno estudiante) {
        this.estudiante = estudiante;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Familiar getFamiliar() {
        return familiar;
    }
    
    public void setFamiliar(String nombreFamiliar, String parentesco, String direccionFamiliar, String telefonoFamiliar, String antecedentesPatologicos) {
        this.familiar = new Familiar(nombreFamiliar, parentesco, direccionFamiliar, telefonoFamiliar, antecedentesPatologicos);
    }

    public Familiar getFamiliaresEstudiante(int indice) {
        try {
            return familiaresEstudiante.get(indice);
        } catch (Exception e) {
            return null;
        }
        
    }

    public Familiar getFamiliaresTrabajador(int indice) {
        try {
        return familiaresTrabajador.get(indice);
        } catch (Exception e) {
            return null;
        }
    }

    public void addFamiliaresEstudiante(int indice, Familiar familiar) {
        familiaresEstudiante.put(indice, familiar);
    }

    public void addFamiliaresTrabajador(int indice, Familiar familiar) {
        familiaresTrabajador.put(indice, familiar);
    }
    
    public void agregarAntecedentePatologico(Enfermedad enfermedad) {
        this.antecedentesPatologicos.add(enfermedad);
    }
    
    public void limpiarAntecedentesPatologicos() {
        this.antecedentesPatologicos.clear();
    }*/