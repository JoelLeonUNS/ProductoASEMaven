package presentador;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import modelo.ModeloInforme;



public class PresentadorInforme {

    private ModeloInforme mInforme;

    public PresentadorInforme() {
    }

    public void setModeloInforme(ModeloInforme mInforme) {
        this.mInforme = mInforme;
    }

    public void cambiarPanel(JPanel base, JPanel siguiente) {

        siguiente.setSize(766, 500);
        siguiente.setLocation(0, 0);
        base.removeAll();
        base.add(siguiente, BorderLayout.CENTER);
        base.revalidate();
        base.repaint();
    }

    public List<Object[]> obtenerInforme1() {
        return mInforme.obtenerInforme1();
    }
    public List<Object[]> obtenerInforme2() {
        return mInforme.obtenerInforme2();
    }
}
