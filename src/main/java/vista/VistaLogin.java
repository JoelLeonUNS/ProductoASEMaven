package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import presentador.PresentadorGeneral;

public class VistaLogin extends javax.swing.JFrame implements ActionListener, KeyListener {

    private PresentadorGeneral pGeneral;

    public VistaLogin(PresentadorGeneral pGeneral) {
        this.pGeneral = pGeneral;
        lookAndFeel();
        initComponents();
        this.bttn_iniciarSesion.addActionListener(this);
        this.psswrdFld_clave.addKeyListener(this);
    }

    public void iniciar() {
        pack();
        setCampos();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);// visualiza la ventana
    }

    public void setCampos() {
        txtFld_usuario.setText(pGeneral.getpLogin().getUsuarioRecordado());
        psswrdFld_clave.setText(pGeneral.getpLogin().getClaveRecordada());
        pGeneral.getpLogin().resetNumeroIntentos(); // nro intentos = 0
    }

    public String getUsuario() {
        return txtFld_usuario.getText();
    }

    public String getClave() {
        return String.copyValueOf(psswrdFld_clave.getPassword());
    }

    public void mensaje(String salida) {
        JOptionPane.showMessageDialog(null, salida);
    }
    
    public void actionIniciarSesion() {
        pGeneral.getpLogin().setDatosUsuario(this.getUsuario(), this.getClave());
        pGeneral.getpLogin().iniciarSesion();
        mensaje(pGeneral.getpLogin().showMensaje());
        if (pGeneral.getpLogin().isAcceso()) {
            if (pGeneral.getpLogin().isRecordado()) {
                pGeneral.getpLogin().recordarSesion(); // lo recuerda de nuevo
            } else {
                if (chckBox_recordarSesion.isSelected()) {
                    pGeneral.getpLogin().recordarSesion();
                } else {
                    pGeneral.getpLogin().noRecordarSesion();
                }
            }
            if (pGeneral.getpLogin().isHabilitado()) {
                this.dispose();
                if (pGeneral.getpLogin().getRol().equals("Admin")) {
                    pGeneral.mostrarVistaInterfazAdmin();
                } else {
                    pGeneral.mostrarVistaInterfazMedico();
                } 
            } else {
                mensaje("Lo siento, su cuenta se\nencuentra inhabilitada.");
            }
        }
        if (pGeneral.getpLogin().isBloqueado()) {
            bttn_iniciarSesion.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        actionIniciarSesion();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            actionIniciarSesion();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_header = new javax.swing.JPanel();
        lbl_unsLogo = new javax.swing.JLabel();
        lbl_unidadMedica = new javax.swing.JLabel();
        pnl_login = new javax.swing.JPanel();
        lbl_fotoSesion = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        txtFld_usuario = new javax.swing.JTextField();
        lbl_clave = new javax.swing.JLabel();
        bttn_iniciarSesion = new javax.swing.JButton();
        psswrdFld_clave = new javax.swing.JPasswordField();
        chckBox_recordarSesion = new javax.swing.JCheckBox();
        lbl_foto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_header.setBackground(new java.awt.Color(255, 255, 255));
        pnl_header.setPreferredSize(new java.awt.Dimension(1220, 70));
        pnl_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_unsLogo.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\OneDrive\\ESTUDIO\\UNS\\6° Ciclo\\ARQUITECTURA DE SOFTWARE EMPRESARIAL\\Semana 06\\GestionHistorial\\src\\imagenes\\Mi proyecto.png")); // NOI18N
        pnl_header.add(lbl_unsLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 13, 110, 45));

        lbl_unidadMedica.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_unidadMedica.setText("Unidad Médica");
        pnl_header.add(lbl_unidadMedica, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 22, -1, -1));

        getContentPane().add(pnl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1220, 70));

        pnl_login.setBackground(new java.awt.Color(255, 255, 255));
        pnl_login.setPreferredSize(new java.awt.Dimension(450, 540));
        pnl_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_fotoSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fotoSesion.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\OneDrive\\ESTUDIO\\UNS\\6° Ciclo\\ARQUITECTURA DE SOFTWARE EMPRESARIAL\\Semana 06\\GestionHistorial\\src\\imagenes\\usuario.png")); // NOI18N
        pnl_login.add(lbl_fotoSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 310, 150));

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_usuario.setText("Usuario");
        pnl_login.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));

        txtFld_usuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_usuario.setPreferredSize(new java.awt.Dimension(71, 30));
        pnl_login.add(txtFld_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 310, 30));

        lbl_clave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_clave.setText("Clave");
        pnl_login.add(lbl_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        bttn_iniciarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttn_iniciarSesion.setText("INICIAR SESIÓN");
        bttn_iniciarSesion.setPreferredSize(new java.awt.Dimension(75, 35));
        pnl_login.add(bttn_iniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 310, 40));

        psswrdFld_clave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        psswrdFld_clave.setPreferredSize(new java.awt.Dimension(90, 30));
        pnl_login.add(psswrdFld_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 310, 30));

        chckBox_recordarSesion.setText("Recordar sesión");
        pnl_login.add(chckBox_recordarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        getContentPane().add(pnl_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 130, 450, 540));

        lbl_foto.setIcon(new javax.swing.ImageIcon("C:\\Users\\USUARIO\\OneDrive\\ESTUDIO\\UNS\\6° Ciclo\\ARQUITECTURA DE SOFTWARE EMPRESARIAL\\Semana 06\\GestionHistorial\\src\\imagenes\\unidadMedica.jpg")); // NOI18N
        getContentPane().add(lbl_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 700, 540));

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
    private javax.swing.JButton bttn_iniciarSesion;
    private javax.swing.JCheckBox chckBox_recordarSesion;
    private javax.swing.JLabel lbl_clave;
    private javax.swing.JLabel lbl_foto;
    private javax.swing.JLabel lbl_fotoSesion;
    private javax.swing.JLabel lbl_unidadMedica;
    private javax.swing.JLabel lbl_unsLogo;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JPasswordField psswrdFld_clave;
    private javax.swing.JTextField txtFld_usuario;
    // End of variables declaration//GEN-END:variables
}
