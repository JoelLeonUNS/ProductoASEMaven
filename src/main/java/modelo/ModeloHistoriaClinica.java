package modelo;

import BaseDeDatos.HistoriaClinicaDAO;
import factoryDAO.DAOFactory;
import factoryDAO.SqlServerDAOFactory;
import historias.HistoriaClinica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pacientes.Alumno;
import pacientes.Familiar;
import pacientes.Trabajador;

public class ModeloHistoriaClinica {
    private final DAOFactory dao;
    private int idHistoriaClinica;
    private HistoriaClinica historiaSeleccionada;
    private ArrayList<Integer> idHistorias;
    private HistoriaClinica historiaClinicaEstudiante;
    private HistoriaClinica historiaClinicaTrabajador;
    private Alumno estudiante;
    private Trabajador trabajador;
    private Familiar familiar;
    private Map<Integer, Familiar> familiaresEstudiante;
    private Map<Integer, Familiar> familiaresTrabajador;
    private ArrayList<Enfermedad> antecedentesPatologicos;

    public ModeloHistoriaClinica() {
        this.historiaClinicaEstudiante = new HistoriaClinica();
        this.historiaClinicaTrabajador = new HistoriaClinica();
        this.estudiante = new Alumno();
        this.trabajador = new Trabajador();
        this.familiar = new Familiar();
        this.familiaresEstudiante = new HashMap<>();
        this.familiaresTrabajador = new HashMap<>();
        this.antecedentesPatologicos = new ArrayList<>();
        this.dao = new SqlServerDAOFactory(); // o MySql
    }
    
    public HistoriaClinica buscarHistoriaClinicaDNI(String dni){
        for (HistoriaClinica historiaClinica: (List<HistoriaClinica>)dao.getHistoriaClinica().listed()) {
            if (historiaClinica.getPaciente().getDni().equals(dni)) {
                idHistoriaClinica = historiaClinica.getIdHistoriaClinica();
                return historiaClinica;
            } 
        }
        return null;
    }
    
    public void buscarHistoriaCoincidente(String cadena) {
        idHistorias = new ArrayList<>();
        for (HistoriaClinica historiaClinica: (List<HistoriaClinica>)dao.getHistoriaClinica().listed()) {
            if (historiaClinica.getPaciente().getNombre().toUpperCase().contains(cadena.toUpperCase()) || historiaClinica.getPaciente().getApellido().toUpperCase().contains(cadena.toUpperCase())) {
                idHistorias.add(historiaClinica.getIdHistoriaClinica());
            } 
        }
    }
    
    public ArrayList<HistoriaClinica> getHistoriasCoincidentes() {
        ArrayList<HistoriaClinica> historiaClinicas = new ArrayList<>();
        for (Integer idHistoria : idHistorias) {
            historiaClinicas.add((HistoriaClinica)dao.getHistoriaClinica().read(idHistoria));
        }
        return historiaClinicas;
    }

    public void registrarHistoriaEstudiante() {
        HistoriaClinicaDAO hcDAO = new HistoriaClinicaDAO();
        estudiante.setFamiliares(new ArrayList<>(familiaresEstudiante.values()));
        historiaClinicaEstudiante.setPaciente(estudiante);
        historiaClinicaEstudiante.agregarAntecedentesPatologicos(antecedentesPatologicos);
        HistoriaClinica.masNroStaticHistoria();
        historiaClinicaEstudiante.setIdHistoriaClinica(HistoriaClinica.getNroStaticHistoria());
        hcDAO.create(historiaClinicaEstudiante);
    }
    
    public void editarHistoriaEstudiante() {
        HistoriaClinicaDAO hcDAO = new HistoriaClinicaDAO();
        estudiante.setFamiliares(new ArrayList<>(familiaresEstudiante.values()));
        historiaClinicaEstudiante.setPaciente(estudiante);
        historiaClinicaEstudiante.agregarAntecedentesPatologicos(antecedentesPatologicos);
        hcDAO.update(historiaClinicaEstudiante, getIdHistoriaBD());
    }
    
    public void registrarHistoriaTrabajador() {
        HistoriaClinicaDAO hcDAO = new HistoriaClinicaDAO();
        trabajador.setFamiliares(new ArrayList<>(familiaresTrabajador.values()));
        historiaClinicaTrabajador.setPaciente(trabajador);
        historiaClinicaTrabajador.agregarAntecedentesPatologicos(antecedentesPatologicos);
        HistoriaClinica.masNroStaticHistoria();
        historiaClinicaTrabajador.setIdHistoriaClinica(HistoriaClinica.getNroStaticHistoria());
        hcDAO.create(historiaClinicaTrabajador);
    }
    
    public void editarHistoriaTrabajador() {
        HistoriaClinicaDAO hcDAO = new HistoriaClinicaDAO();
        trabajador.setFamiliares(new ArrayList<>(familiaresTrabajador.values()));
        historiaClinicaTrabajador.setPaciente(trabajador);
        historiaClinicaTrabajador.agregarAntecedentesPatologicos(antecedentesPatologicos);
        hcDAO.update(historiaClinicaTrabajador, getIdHistoriaBD());
    }
    
    public int getIdHistoriaBD() {
        HistoriaClinicaDAO hcDAO = new HistoriaClinicaDAO();  
        for (int i = 0; i < hcDAO.count(); i++) {
            if (hcDAO.read(i).equals(historiaSeleccionada)) {
                return i;
            }
        }
        return 0;
    }

    public HistoriaClinica getHistoriaSeleccionada() {
        return historiaSeleccionada;
    }

    public void setHistoriaSeleccionada(HistoriaClinica historiaSeleccionada) {
        this.historiaSeleccionada = historiaSeleccionada;
    }

    public HistoriaClinica getHistoriaClinicaEstudiante() {
        return historiaClinicaEstudiante;
    }

    public void setHistoriaClinicaEstudiante(HistoriaClinica historiaClinicaEstudiante) {
        this.historiaClinicaEstudiante = historiaClinicaEstudiante;
    }

    public HistoriaClinica getHistoriaClinicaTrabajador() {
        return historiaClinicaTrabajador;
    }

    public void setHistoriaClinicaTrabajador(HistoriaClinica historiaClinicaTrabajador) {
        this.historiaClinicaTrabajador = historiaClinicaTrabajador;
    }

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
    }
}
