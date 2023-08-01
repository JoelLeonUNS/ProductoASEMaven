package presentador;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import modelo.ModeloInforme1;
import modelo.ModeloInforme2;
import vista.PanelInforme1;
import vista.PanelInforme2;

public class PresentadorInforme {

    private ModeloInforme1 modeloInforme1;
    private ModeloInforme2 modeloInforme2;
    private PanelInforme1 panelInforme1;
    private PanelInforme2 panelInforme2;

    public PresentadorInforme() {
        modeloInforme1 = new ModeloInforme1();
        modeloInforme2 = new ModeloInforme2();
    }

    public void mostrarInforme1() {
        DefaultTableModel model = (DefaultTableModel) panelInforme1.getTablaInformes1().getModel();
        model.setRowCount(0);

        ArrayList<Object[]> datosInforme = modeloInforme1.obtenerDatosInforme();

        for (Object[] rowData : datosInforme) {
            model.addRow(rowData);
        }

        panelInforme1.getTablaInformes1().repaint();
    }

    public void mostrarInforme2() {
        DefaultTableModel model = (DefaultTableModel) panelInforme2.getTablaInformes().getModel();
        model.setRowCount(0);

        ArrayList<Object[]> datosInforme = modeloInforme2.obtenerDatosInforme();

        for (Object[] rowData : datosInforme) {
            model.addRow(rowData);
        }

        panelInforme2.getTablaInformes().repaint();
    }

    public void mostrarInforme3() {

    }

    public void setPanelInforme1(PanelInforme1 panelInforme1) {
        this.panelInforme1 = panelInforme1;
    }

    public void setPanelInforme2(PanelInforme2 panelInforme2) {
        this.panelInforme2 = panelInforme2;
    }
    
     public void cambiarPanel(JPanel base, JPanel siguiente) {
        siguiente.setSize(766, 500);
        siguiente.setLocation(0, 0);
        base.removeAll();
        base.add(siguiente, BorderLayout.CENTER);
        base.revalidate();
        base.repaint();
    }  
}
