package modelo;

import consultas.ConsultaMedica;

public class ModeloConsulta {

    private ConsultaMedica consulta;
    private int idConsulta;

    public ModeloConsulta() {
        this.consulta = new ConsultaMedica();
    }

    public void setDatosConsulta(String fecha, String hora, int edad, int tiempoEnfermedad, String apetito, String sueño, String sed, String estadoAnimo, String motivo) {
        consulta.setFecha(fecha);
        consulta.setHora(hora);
        consulta.setEdad(edad);
        consulta.setTiempoEnfermedad(tiempoEnfermedad);
        consulta.setApetito(apetito);
        consulta.setSueño(sueño);
        consulta.setEstadoAnimo(estadoAnimo);
        consulta.setSed(sed);
        consulta.setMotivo(motivo);
    }

    public ConsultaMedica getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaMedica consulta) {
        this.consulta = consulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
    
    public void tipoExamen(ConsultaMedica consulta){
        
    }

}
