package examenes;


public class Examen {
    private String observacion;

    public Examen() {
    }
    
    // solo para los valores por defecto.
    public Examen(String observacion) {
        this.observacion = observacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
}
