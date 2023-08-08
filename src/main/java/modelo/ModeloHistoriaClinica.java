package modelo;

import factoryDAO.DAOFactory;
import factoryDAO.SqlServerDAOFactory;
import historias.HistoriaClinica;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pacientes.Familiar;
import pacientes.Paciente;

public class ModeloHistoriaClinica {

    private final DAOFactory dao;
    private HistoriaClinica historiaClinica;
    private ArrayList<Integer> idHistorias;

    public ModeloHistoriaClinica() {
        resetModelo();
        this.dao = new SqlServerDAOFactory(); // o MySql
    }
    
    public final void resetModelo() {
        this.historiaClinica = new HistoriaClinica();
        this.historiaClinica.setPaciente(new Paciente());
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
        for (Map.Entry<Integer, Familiar> familiarExiste : historiaClinica.getPaciente().getFamiliares().entrySet()) {
           if (familiarExiste.getValue().getParentesco().equalsIgnoreCase(familiar.getParentesco())) {
                indiceFamiliar = familiarExiste.getKey();
                break;
            }          
        }
  
        historiaClinica.getPaciente().agregarFamiliar(indiceFamiliar, familiar); // actualizar o agregar
    }
    
    public Familiar getParentescoFamiliar(String parentesco) {
        for (Map.Entry<Integer, Familiar> familiarExiste : historiaClinica.getPaciente().getFamiliares().entrySet()) {
           if (familiarExiste.getValue().getParentesco().equalsIgnoreCase(parentesco)) {
                return familiarExiste.getValue();
            }          
        }
        return null;
    }
    
}