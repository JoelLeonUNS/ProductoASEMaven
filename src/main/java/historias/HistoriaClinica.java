package historias;

import consultas.ConsultaMedica;
import java.util.ArrayList;
import modelo.Enfermedad;
import pacientes.Paciente;

public class HistoriaClinica {
    
    private static int nroStaticHistoria;
    private int numeroHistoriaClinica;
    private Paciente paciente;
    private String otrosAntecedentesPatologicos;
    private ArrayList<Enfermedad> antecedentesPatologicos = new ArrayList<>();
    private ArrayList<ConsultaMedica> consultasMedicas = new ArrayList<>();

    public HistoriaClinica() {
    }

    // solo para los valores por defecto.
    public HistoriaClinica(Paciente paciente, String otrosAntecedentesPatologicos) {
        this.numeroHistoriaClinica = HistoriaClinica.masNroStaticHistoria();
        this.paciente = paciente;
        this.otrosAntecedentesPatologicos = otrosAntecedentesPatologicos;
    }

    public static int masNroStaticHistoria() {
        return ++nroStaticHistoria;
    }
    
    public static int getNroStaticHistoria() {
        return nroStaticHistoria;
    }

    public int getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getOtrosAntecedentesPatologicos() {
        return otrosAntecedentesPatologicos;
    }

    public void setOtrosAntecedentesPatologicos(String otrosAntecedentesPatologicos) {
        this.otrosAntecedentesPatologicos = otrosAntecedentesPatologicos;
    }

    public ArrayList<ConsultaMedica> getConsultasMedicas() {
        return consultasMedicas;
    }

    public void setConsultasMedicas(ArrayList<ConsultaMedica> consultasMedicas) {
        this.consultasMedicas = consultasMedicas;
    }

    public void agregarConsulta(ConsultaMedica consultaMedica) {
        consultasMedicas.add(consultaMedica);
    }

    public ArrayList<Enfermedad> getAntecedentesPatologicos() {
        return antecedentesPatologicos;
    }
   
    public void agregarAntecedentePatologico(Enfermedad enfermedad) {
        antecedentesPatologicos.add(enfermedad);
    }

    public void agregarAntecedentesPatologicos(ArrayList<Enfermedad> enfermedades) {
        antecedentesPatologicos.addAll(enfermedades);
    }

    @Override
    public String toString() {
        return this.paciente.getDNI();
    }
}
