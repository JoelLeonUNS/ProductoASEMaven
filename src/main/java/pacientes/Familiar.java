package pacientes;

public class Familiar {
    private String nombreFamiliar;
    private String parentesco;
    private String direccionFamiliar;
    private String telefonoFamiliar;
    private String antecedentesPatologicos;

    
    // solo para poblar
    public Familiar(String nombreFamiliar, String parentesco, String direccionFamiliar, String telefonoFamiliar, String antecedentesPatologicos) {
        this.nombreFamiliar = nombreFamiliar;
        this.parentesco = parentesco;
        this.direccionFamiliar = direccionFamiliar;
        this.telefonoFamiliar = telefonoFamiliar;
        this.antecedentesPatologicos = antecedentesPatologicos;
    }

    public Familiar() {
    }

    public String getNombreFamiliar() {
        return nombreFamiliar;
    }

    public void setNombreFamiliar(String nombreFamiliar) {
        this.nombreFamiliar = nombreFamiliar;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDireccionFamiliar() {
        return direccionFamiliar;
    }

    public void setDireccionFamiliar(String direccionFamiliar) {
        this.direccionFamiliar = direccionFamiliar;
    }

    public String getTelefonoFamiliar() {
        return telefonoFamiliar;
    }

    public void setTelefonoFamiliar(String telefonoFamiliar) {
        this.telefonoFamiliar = telefonoFamiliar;
    }

    public String getAntecedentesPatologicos() {
        return antecedentesPatologicos;
    }

    public void setAntecedentesPatologicos(String antecedentesPatologicos) {
        this.antecedentesPatologicos = antecedentesPatologicos;
    }
    
    
    
}
