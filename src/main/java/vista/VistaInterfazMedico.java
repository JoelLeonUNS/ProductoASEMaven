package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import presentador.PresentadorGeneral;

public class VistaInterfazMedico extends javax.swing.JFrame implements ActionListener {
    
    private PresentadorGeneral pg;
    private PanelHistoriaClinica pHistorialMedico;
    private PanelExamen pExamen;
    private PanelInforme pInforme;
    
    public VistaInterfazMedico(PresentadorGeneral pGeneral) {
        this.pg = pGeneral;
        pExamen = new PanelExamen(pGeneral);
        pHistorialMedico = new PanelHistoriaClinica(pGeneral);
        pInforme = new PanelInforme(pGeneral);
        lookAndFeel();
        initComponents();
        addActionListenerBotones();
        pGeneral.getpInterfazMedico().cambiarPanel(pnl_medico, pHistorialMedico); // primera ventana
    }
    
    public void iniciar() {
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);// visualiza la ventana
        setDatosMedico();
    }
    
    public void setDatosMedico() {
        lbl_nombreApellido.setText("Bienvenido(a): " + pg.getpLogin().getUsuario());
    }
    
    private void addActionListenerBotones() {
        this.bttn_historiasClinicas.addActionListener(this);
        this.bttn_examenes.addActionListener(this);
        this.bttn_informes.addActionListener(this);
        this.bttn_cerrarSesion.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "HISTORIAS CLINICAS" -> {
                pg.getpInterfazMedico().cambiarPanel(pnl_medico, pHistorialMedico);
            }
            case "EXAMENES" -> {
                pg.getpInterfazMedico().cambiarPanel(pnl_medico, pExamen);
            }
            case "INFORMES" -> {
                pg.getpInterfazMedico().cambiarPanel(pnl_medico, pInforme);
            }
            case "CERRAR SESIÓN" -> {
                pg.getpLogin().cerrarSesion();
                this.dispose();
                pg.mostrarVistaLogin();
            }
        }
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_medico = new javax.swing.JPanel();
        pnl_headerTop = new javax.swing.JPanel();
        pnl_header = new javax.swing.JPanel();
        lbl_nombreApellido = new javax.swing.JLabel();
        bttn_historiasClinicas = new javax.swing.JButton();
        bttn_examenes = new javax.swing.JButton();
        bttn_informes = new javax.swing.JButton();
        bttn_cerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_medico.setBackground(new java.awt.Color(255, 255, 255));
        pnl_medico.setPreferredSize(new java.awt.Dimension(1280, 620));

        javax.swing.GroupLayout pnl_medicoLayout = new javax.swing.GroupLayout(pnl_medico);
        pnl_medico.setLayout(pnl_medicoLayout);
        pnl_medicoLayout.setHorizontalGroup(
            pnl_medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        pnl_medicoLayout.setVerticalGroup(
            pnl_medicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        getContentPane().add(pnl_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1280, 620));

        pnl_headerTop.setBackground(new java.awt.Color(255, 255, 255));
        pnl_headerTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_header.setBackground(new java.awt.Color(217, 217, 217));
        pnl_header.setPreferredSize(new java.awt.Dimension(265, 70));
        pnl_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nombreApellido.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbl_nombreApellido.setText("Bienvenido:");
        pnl_header.add(lbl_nombreApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        bttn_historiasClinicas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttn_historiasClinicas.setText("Historias Clínicas");
        bttn_historiasClinicas.setActionCommand("HISTORIAS CLINICAS");
        bttn_historiasClinicas.setBorderPainted(false);
        bttn_historiasClinicas.setContentAreaFilled(false);
        bttn_historiasClinicas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttn_historiasClinicas.setPreferredSize(new java.awt.Dimension(185, 70));
        pnl_header.add(bttn_historiasClinicas, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 0, -1, -1));

        bttn_examenes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttn_examenes.setText("Exámenes");
        bttn_examenes.setActionCommand("EXAMENES");
        bttn_examenes.setBorderPainted(false);
        bttn_examenes.setContentAreaFilled(false);
        bttn_examenes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttn_examenes.setPreferredSize(new java.awt.Dimension(185, 70));
        pnl_header.add(bttn_examenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        bttn_informes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttn_informes.setText("Informes");
        bttn_informes.setActionCommand("INFORMES");
        bttn_informes.setBorderPainted(false);
        bttn_informes.setContentAreaFilled(false);
        bttn_informes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttn_informes.setPreferredSize(new java.awt.Dimension(185, 70));
        pnl_header.add(bttn_informes, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 0, -1, -1));

        bttn_cerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttn_cerrarSesion.setText("Cerrar Sesión");
        bttn_cerrarSesion.setActionCommand("CERRAR SESIÓN");
        bttn_cerrarSesion.setBorderPainted(false);
        bttn_cerrarSesion.setContentAreaFilled(false);
        bttn_cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttn_cerrarSesion.setPreferredSize(new java.awt.Dimension(250, 70));
        pnl_header.add(bttn_cerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, -1));

        pnl_headerTop.add(pnl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1220, 70));

        getContentPane().add(pnl_headerTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void lookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttn_cerrarSesion;
    private javax.swing.JButton bttn_examenes;
    private javax.swing.JButton bttn_historiasClinicas;
    private javax.swing.JButton bttn_informes;
    private javax.swing.JLabel lbl_nombreApellido;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_headerTop;
    private javax.swing.JPanel pnl_medico;
    // End of variables declaration//GEN-END:variables

    
}
