package presentador;

import examenes.Examen;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import modelo.ModeloConsulta;
import modelo.ModeloExamen;
import modelo.ModeloHistoriaClinica;

public class PresentadorExamen {
    private ModeloExamen modeloExamen = new ModeloExamen();
    private ModeloConsulta modeloConsulta = new ModeloConsulta();
    private ModeloHistoriaClinica modeloHistoriaClinica = new ModeloHistoriaClinica();

    public PresentadorExamen() {
    }
    
    public void cambiarTipoExamen(JPanel base, JPanel siguiente) {
        siguiente.setSize(764, 250);
        siguiente.setLocation(0, 0);
        base.removeAll();
        base.add(siguiente, BorderLayout.CENTER);
        base.revalidate();
        base.repaint();
    }

    public ModeloExamen getModeloExamen() {
        return modeloExamen;
    }

    public void setModeloExamen(ModeloExamen modeloExamen) {
        this.modeloExamen = modeloExamen;
    }

    public ModeloConsulta getModeloConsulta() {
        return modeloConsulta;
    }

    public void setModeloConsulta(ModeloConsulta modeloConsulta) {
        this.modeloConsulta = modeloConsulta;
    }

    public ModeloHistoriaClinica getModeloHistoriaClinica() {
        return modeloHistoriaClinica;
    }

    public void setModeloHistoriaClinica(ModeloHistoriaClinica modeloHistoriaClinica) {
        this.modeloHistoriaClinica = modeloHistoriaClinica;
    }
    
    public void setTipoExamen(String tipoExamen){
        modeloExamen.setTipoExamen(tipoExamen);
    }
    
    public void setDatosExamenMedico(String diagnostico, String tratamiento, String examAux, String observacion){
        modeloExamen.setDatosExamenMedico(diagnostico, tratamiento, examAux, observacion);
    }
    
    public void setDatosExamenClinico(String observacion, boolean apCardio, boolean apRespiratorio){
        modeloExamen.setDatosExamenClinico(observacion, apCardio, apRespiratorio);
    }
    
    public void setDatosExamenFisico(double temp, String PA, double FR, double SPO2, double peso, double talla, double IMC, double FC, double perAbdominal){
        modeloExamen.setDatosExamenFisico(temp, PA, FR, SPO2, peso, talla, IMC, FC, perAbdominal);
    }
    
    public void setDatosConculta(String fecha, String hora, int edad, int tiempoEnfermedad, String apetito, String sueño, String sed, String estadoAnimo, String motivo){
        modeloConsulta.setDatosConsulta(fecha, hora, edad, tiempoEnfermedad, apetito, sueño, sed, estadoAnimo, motivo);
    }
    
    public void añadirExamenAConsulta(){
        modeloConsulta.getConsulta().agregarExamen(modeloExamen.getExamen());
    }
    
    public void iniciarExamen(){
        modeloExamen.setExamen(new Examen());
    }
    
}
