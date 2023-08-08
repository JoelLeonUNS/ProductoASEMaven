package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import presentador.PresentadorGeneral;

public class PanelInforme extends javax.swing.JPanel implements ActionListener {

    private PresentadorGeneral pGeneral;
    private PanelInforme1 pInforme1;
    private PanelInforme2 pInforme2;
    private PanelInforme3 pInforme3;
    private PanelInforme4 pInforme4;
    private PanelInforme5 pInforme5;

    private DefaultTableModel modelTablaInforme = new DefaultTableModel();
    private DefaultComboBoxModel comboBoxTipoInforme = new DefaultComboBoxModel();

    public PanelInforme(PresentadorGeneral p) {
        initComponents();
        this.pGeneral = p;
        pInforme1 = new PanelInforme1(pGeneral);
        pInforme2 = new PanelInforme2();
        pInforme3 = new PanelInforme3();
        pInforme4 = new PanelInforme4();
        pInforme5 = new PanelInforme5();
        llenarComboBoxTipoInforme();
        CmbBx_tipoInforme.addActionListener(this);
        //pInforme1.cargarDatosEnTabla();
    }

    private void llenarComboBoxTipoInforme() {
        comboBoxTipoInforme.removeAllElements();
        comboBoxTipoInforme.addElement("Atenciones Realizadas");
        comboBoxTipoInforme.addElement("Alumnos de Pregraso segun escuela");
        comboBoxTipoInforme.addElement("Pacientes segun el sexo");
        comboBoxTipoInforme.addElement("Triaje de signos vitales de los pacientes");
        comboBoxTipoInforme.addElement("Triaje de medida de los pacientes");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Buscar" -> {

            }
            case "Generar Informe" -> {
                String tipoInforme = (String) CmbBx_tipoInforme.getSelectedItem();
                switch (tipoInforme) {
                    case "Atenciones Realizadas" -> {
                        List<Object[]> informes = pGeneral.getpInforme().obtenerInforme1();
                        pInforme1.cargarInformesEnTabla(informes);
                        pGeneral.getpInforme().cambiarPanel(Pnl_tipoInforme, pInforme1);
                    }
                    case "Alumnos de Pregraso segun escuela" -> {
                        pGeneral.getpInforme().cambiarPanel(Pnl_tipoInforme, pInforme2);
                    }
                    case "Pacientes segun el sexo" -> {
                        pGeneral.getpInforme().cambiarPanel(Pnl_tipoInforme, pInforme3);
                    }
                    case "Triaje de signos vitales de los pacientes" -> {
                        pGeneral.getpInforme().cambiarPanel(Pnl_tipoInforme, pInforme4);
                    }
                    case "Triaje de medida de los pacientes" -> {
                        pGeneral.getpInforme().cambiarPanel(Pnl_tipoInforme, pInforme5);
                    }
                    default -> {
                    }
                }

            }
            case "Filtrar Tiempo" -> {

            }
            case "Descargar PDF" -> {

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CmbBx_tipoInforme = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        Pnl_tipoInforme = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(250, 35));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setPreferredSize(new java.awt.Dimension(150, 35));
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 30, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(404, 500));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Historia"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, -1, -1));

        CmbBx_tipoInforme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CmbBx_tipoInforme.setModel(comboBoxTipoInforme);
        CmbBx_tipoInforme.setActionCommand("Generar Informe");
        CmbBx_tipoInforme.setPreferredSize(new java.awt.Dimension(215, 35));
        add(CmbBx_tipoInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 30, 300, -1));

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ultimas 24 horas", "Último mes", "Último semestre", "Último año", "Personalizado" }));
        jComboBox2.setActionCommand("Filtrar Tiempo");
        jComboBox2.setPreferredSize(new java.awt.Dimension(215, 35));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Descargar PDF");
        jButton2.setPreferredSize(new java.awt.Dimension(133, 35));
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1117, 30, -1, -1));

        Pnl_tipoInforme.setBackground(new java.awt.Color(204, 204, 204));
        Pnl_tipoInforme.setPreferredSize(new java.awt.Dimension(766, 500));

        javax.swing.GroupLayout Pnl_tipoInformeLayout = new javax.swing.GroupLayout(Pnl_tipoInforme);
        Pnl_tipoInforme.setLayout(Pnl_tipoInformeLayout);
        Pnl_tipoInformeLayout.setHorizontalGroup(
            Pnl_tipoInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        Pnl_tipoInformeLayout.setVerticalGroup(
            Pnl_tipoInformeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        add(Pnl_tipoInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 95, 766, 500));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CmbBx_tipoInforme;
    private javax.swing.JPanel Pnl_tipoInforme;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
