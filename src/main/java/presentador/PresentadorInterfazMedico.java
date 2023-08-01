package presentador;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import modelo.ModeloHistoriaClinica;

public class PresentadorInterfazMedico {
    private ModeloHistoriaClinica modeloHistoriaClinica;
    
    public PresentadorInterfazMedico() {
        
    }
    
    public void setModelo(ModeloHistoriaClinica mHistoriaClinica) {
        this.modeloHistoriaClinica = mHistoriaClinica;
    }
    
    public void cambiarPanel(JPanel base, JPanel siguiente) {
        siguiente.setSize(1280, 620);
        siguiente.setLocation(0, 0);
        base.removeAll();
        base.add(siguiente, BorderLayout.CENTER);
        base.revalidate();
        base.repaint();
    }  
}
