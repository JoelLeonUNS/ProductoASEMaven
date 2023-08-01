package vista;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import medicos.Medico;
import presentador.PresentadorGeneral;

/**
 *
 * @author PC1
 */
public class VistaInterfazAdmin extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    private PresentadorGeneral pGeneral;
    private DefaultTableModel modelTablaCuentas = new DefaultTableModel();

    public VistaInterfazAdmin(PresentadorGeneral p) {
        lookAndFeel();
        initComponents();
        crearEncabezadoTablaCuenta();
        this.pGeneral = p;
        this.jButton1.addActionListener(this);
        this.jButton2.addActionListener(this);
        this.jButton3.addActionListener(this);
        this.jButton4.addActionListener(this);
        this.jButton5.addActionListener(this);
        this.bttn_cerrarSesion.addActionListener(this);

        this.jButton3.setEnabled(false);
        this.jButton4.setEnabled(false);
        this.jButton5.setEnabled(false);

        this.jTable1.getSelectionModel().addListSelectionListener(this);

        setTxtFldsEditable(false);
    }

    public void iniciar() {
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(1280, 720);
        setVisible(true);// visualiza la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bttn_cerrarSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtFld_valorBuscado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_header.setBackground(new java.awt.Color(255, 255, 255));
        pnl_header.setPreferredSize(new java.awt.Dimension(600, 70));
        pnl_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Administrar Cuentas");
        pnl_header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 23, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setText("Bienvenido:");
        pnl_header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 23, -1, -1));

        bttn_cerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bttn_cerrarSesion.setText("Cerrar Sesión");
        bttn_cerrarSesion.setBorderPainted(false);
        bttn_cerrarSesion.setContentAreaFilled(false);
        bttn_cerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttn_cerrarSesion.setPreferredSize(new java.awt.Dimension(250, 70));
        pnl_header.add(bttn_cerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(995, 0, 225, 70));

        getContentPane().add(pnl_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1220, -1));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(modelTablaCuentas);
        jTable1.setPreferredSize(new java.awt.Dimension(404, 510));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 197, 400, 495));

        txtFld_valorBuscado.setPreferredSize(new java.awt.Dimension(250, 35));
        getContentPane().add(txtFld_valorBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setPreferredSize(new java.awt.Dimension(150, 35));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 130, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Crear Cuenta");
        jButton2.setPreferredSize(new java.awt.Dimension(150, 35));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 130, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Editar Cuenta");
        jButton3.setPreferredSize(new java.awt.Dimension(150, 35));
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 130, -1, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Desactivar Cuenta");
        jButton4.setPreferredSize(new java.awt.Dimension(150, 35));
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(873, 130, -1, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Guardar");
        jButton5.setPreferredSize(new java.awt.Dimension(150, 35));
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 130, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("DNI:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Apellidos:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Usuario:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Clave:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Datos Personales");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Cuenta de usuario");

        jTextField2.setPreferredSize(new java.awt.Dimension(350, 30));

        jTextField3.setPreferredSize(new java.awt.Dimension(350, 30));

        jTextField4.setPreferredSize(new java.awt.Dimension(350, 30));

        jTextField5.setPreferredSize(new java.awt.Dimension(350, 30));

        jTextField6.setPreferredSize(new java.awt.Dimension(350, 30));

        jTextField7.setPreferredSize(new java.awt.Dimension(350, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 197, -1, -1));

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel pnl_header;
    private javax.swing.JTextField txtFld_valorBuscado;
    // End of variables declaration//GEN-END:variables

    public String getInput(JTextField jtxfld) {
        return jtxfld.getText();
    }

    public void setTxtFldsEditable(boolean b) {
        this.jTextField2.setEditable(b);
        this.jTextField3.setEditable(b);
        this.jTextField4.setEditable(b);
        this.jTextField5.setEditable(b);
        this.jTextField6.setEditable(b);
        this.jTextField7.setEditable(b);
    }

    public void limpiarCasillas() {
        this.jTextField2.setText("");
        this.jTextField3.setText("");
        this.jTextField4.setText("");
        this.jTextField5.setText("");
        this.jTextField6.setText("");
        this.jTextField7.setText("");
    }

    public boolean isBusquedaDNI() {
        return this.txtFld_valorBuscado.getText().matches("[0-9]+");
    }

    public void mostrarTablaCuentas(ArrayList<Medico> medicos) {
        modelTablaCuentas.setRowCount(0);
        for (Medico medico : medicos) {
            addMedico(medico);
        }
    }

    private void addMedico(Medico medico) {
        if (medico != null) {
            modelTablaCuentas.addRow(new Object[]{
                medico, // Guardar el objeto Producto
                medico.getNombreMedico(),
                medico.getApellidoMedico(),});
        }
    }

    private void crearEncabezadoTablaCuenta() {
        modelTablaCuentas.addColumn("DNI");
        modelTablaCuentas.addColumn("Nombre");
        modelTablaCuentas.addColumn("Apellido");
    }

    private boolean camposllenos() {
        return !"".equals(getInput(jTextField2)) && !"".equals(getInput(jTextField3)) && !"".equals(getInput(jTextField4))
                && !"".equals(getInput(jTextField5)) && !"".equals(getInput(jTextField6)) && !"".equals(getInput(jTextField7));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Buscar" -> {
                if (isBusquedaDNI()) {
                    modelTablaCuentas.setRowCount(0);
                    addMedico(pGeneral.getpInterfazAdmin().buscarMedicoDNI(getInput(txtFld_valorBuscado)));
                } else {
                    mostrarTablaCuentas(pGeneral.getpInterfazAdmin().buscarMedicoCoincidente(getInput(txtFld_valorBuscado)));
                }
            }
            case "Crear Cuenta" -> {
                limpiarCasillas();
                setTxtFldsEditable(true);
                this.jButton5.setEnabled(true);
                pGeneral.getpInterfazAdmin().setTipoGuardado("CREAR");
            }
            case "Editar Cuenta" -> {
                setTxtFldsEditable(true);
                this.jButton5.setEnabled(true);
                pGeneral.getpInterfazAdmin().setTipoGuardado("EDITAR");
            }
            case "Desactivar Cuenta" -> {
                pGeneral.getpInterfazAdmin().desactivarCuenta();
                this.jButton4.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Cuenta Deshabilitada");
            }
            case "Guardar" -> {
                pGeneral.getpInterfazAdmin().setDatosMedico(getInput(jTextField2), getInput(jTextField3), getInput(jTextField4), getInput(jTextField5));
                pGeneral.getpInterfazAdmin().setDatosUsuario(getInput(jTextField6), getInput(jTextField7));
                if (pGeneral.getpInterfazAdmin().getTipoGuardado().equals("CREAR")) {
                    if (camposllenos()) {
                        //pGeneral.getpInterfazAdmin().nuevoMedico();
                        pGeneral.getpInterfazAdmin().registrar();
                        JOptionPane.showMessageDialog(null, "Usuario creado con exito..");
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe completar todos los campos.");
                    }

                } else if (pGeneral.getpInterfazAdmin().getTipoGuardado().equals("EDITAR")) {
                    pGeneral.getpInterfazAdmin().editar();
                }
                this.jButton5.setEnabled(false);
                setTxtFldsEditable(false);
            }
            case "Cerrar Sesión" -> {
                pGeneral.getpLogin().cerrarSesion(); //
                this.dispose();
                pGeneral.mostrarVistaLogin();
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            this.jButton3.setEnabled(true);
            this.jButton4.setEnabled(true);
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                String dni = jTable1.getValueAt(selectedRow, 0).toString();
                jTextField2.setText(pGeneral.getpInterfazAdmin().buscarMedicoDNI(dni).getDNI());
                jTextField3.setText(pGeneral.getpInterfazAdmin().buscarMedicoDNI(dni).getNombreMedico());
                jTextField4.setText(pGeneral.getpInterfazAdmin().buscarMedicoDNI(dni).getApellidoMedico());
                jTextField5.setText(pGeneral.getpInterfazAdmin().buscarMedicoDNI(dni).getTelefonoMedico());
                jTextField6.setText(pGeneral.getpInterfazAdmin().buscarMedicoDNI(dni).getUsuario().getUsuario());
                jTextField7.setText(pGeneral.getpInterfazAdmin().buscarMedicoDNI(dni).getUsuario().getClave());
            }
        }

    }
}
