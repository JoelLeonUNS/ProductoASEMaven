/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import presentador.PresentadorGeneral;

/**
 *
 * @author PC1
 */
public class PanelInforme3 extends javax.swing.JPanel {

    private PresentadorGeneral pGeneral;
    private DefaultTableModel model;

    public PanelInforme3(PresentadorGeneral pGeneral) {
        initComponents();
        this.pGeneral = pGeneral;
        model = (DefaultTableModel) jTable1.getModel();
    }

    public JTable getTablaInformes3() {
        return jTable1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(766, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Nombre: Pacientes  atendidos en el servicio de medicina, por sexo según condición");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Archivo:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 30));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 57, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText(".pdf");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 60, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(706, 365));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Paciente", "Condición", "Sexo", "Cantidad", "%"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    public void cargarInformesEnTabla3(List<Object[]> informes) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Object[] informe : informes) {
            model.addRow(informe);
        }
    }

    String[] obtenerEncabezados() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int columnCount = model.getColumnCount();
        String[] headers = new String[columnCount];

        for (int i = 0; i < columnCount; i++) {
            headers[i] = model.getColumnName(i);
        }
        return headers;
    }

    public String obtenerNombreArchivo() {
        return jTextField1.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
