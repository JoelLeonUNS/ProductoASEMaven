package presentador;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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

    public List<Object[]> obtenerInformes() {
        return mInforme.obtenerInformes();
    }

}
