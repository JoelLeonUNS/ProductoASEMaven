package vista;

import historias.HistoriaClinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import presentador.PresentadorGeneral;

public class PanelHistoriaClinica extends javax.swing.JPanel implements ActionListener, ListSelectionListener {

    private final PresentadorGeneral pg;
    private PanelHistoriaEstudiante pHistoriaEstudiante;
    private PanelHistoriaTrabajador pHistoriaTrabajador;

    private DefaultTableModel modelTablaBuscarHistoria = new DefaultTableModel();
    private DefaultComboBoxModel<String> comboBoxNuevaHistoria = new DefaultComboBoxModel<>();

    public PanelHistoriaClinica(PresentadorGeneral pg) {
        initComponents();
        this.pg = pg;
        pHistoriaEstudiante = new PanelHistoriaEstudiante(pg);
        pHistoriaTrabajador = new PanelHistoriaTrabajador(pg);
        llenarComboBoxNuevaHistoria();
        crearEncabezadoTablaBuscarHistoria();

        bttn_nuevaHistoria.addActionListener(this);
        cmbBx_tipoHistoria.addActionListener(this);
        bttn_buscar.addActionListener(this);
        bttn_editarHistoria.addActionListener(this);
        bttn_guardar.addActionListener(this);
        tbl_busquedaHistoria.getSelectionModel().addListSelectionListener(this);

        bttn_guardar.setEnabled(false);
        bttn_editarHistoria.setEnabled(false);

        mostrarTablaBuscarHistoria(pg.getpHistoriaClinica().buscarHistoriaClinicaCoincidente(getInputText(txtFld_valorBuscado)));
    }

    public String getInputText(JTextField txtFld) {
        return txtFld.getText();
    }

    public void setEnableBotones(boolean b) {
        pHistoriaEstudiante.setEnableBotones(b);
        pHistoriaTrabajador.setEnableBotones(b);
    }

    private void llenarComboBoxNuevaHistoria() {
        comboBoxNuevaHistoria.addElement("Nueva Historia");
        comboBoxNuevaHistoria.addElement("Estudiante");
        comboBoxNuevaHistoria.addElement("Trabajador");
    }

    private void crearEncabezadoTablaBuscarHistoria() {
        modelTablaBuscarHistoria.addColumn("DNI");
        modelTablaBuscarHistoria.addColumn("Nombre");
        modelTablaBuscarHistoria.addColumn("Apellido");
    }

    public boolean isBusquedaDNI() {
        return this.txtFld_valorBuscado.getText().matches("[0-9]+");
    }

    public final void mostrarTablaBuscarHistoria(ArrayList<HistoriaClinica> historiasClinicas) {
        modelTablaBuscarHistoria.setRowCount(0);
        for (HistoriaClinica historiaClinica : historiasClinicas) {
            addHistoriaClinica(historiaClinica);
        }
    }

    private void addHistoriaClinica(HistoriaClinica historiaClinica) {
        if (historiaClinica != null) {
            modelTablaBuscarHistoria.addRow(new Object[]{
                historiaClinica, // Guardar el objeto HistoriaClinica
                historiaClinica.getPaciente().getNombre(),
                historiaClinica.getPaciente().getApellido(),});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Buscar" -> {
                if (isBusquedaDNI()) {
                    modelTablaBuscarHistoria.setRowCount(0);
                    addHistoriaClinica(pg.getpHistoriaClinica().buscarHistoriaClinicaDNI(getInputText(txtFld_valorBuscado)));
                } else {
                    mostrarTablaBuscarHistoria(pg.getpHistoriaClinica().buscarHistoriaClinicaCoincidente(getInputText(txtFld_valorBuscado)));
                }
            }
            case "Nueva Historia" -> {
                bttn_guardar.setEnabled(true);
                setEnableBotones(true);
                pHistoriaEstudiante.mostrarNextIdHistoriaClinica();
                pHistoriaTrabajador.mostrarNextIdHistoriaClinica();
                pg.getpHistoriaClinica().resetIncIdFamiliar();
                pg.getpHistoriaClinica().setTipoGuardado("NUEVO");
                String tipoHistoria = (String) cmbBx_tipoHistoria.getSelectedItem();
                switch (tipoHistoria) {
                    case "Estudiante" -> {
                        pg.getpHistoriaClinica().resetModeloHistoriaClinica("Alumno");
                        pg.getpHistoriaClinica().cambiarTipoHistoriaClinica(pnl_baseHistoriaClinica, pHistoriaEstudiante);
                    }
                    case "Trabajador" -> {
                        pg.getpHistoriaClinica().resetModeloHistoriaClinica("Trabajador");
                        pg.getpHistoriaClinica().cambiarTipoHistoriaClinica(pnl_baseHistoriaClinica, pHistoriaTrabajador);
                    }
                }
            }
            case "Tipo Historia" -> {

            }
            case "Editar Historia" -> {
                bttn_guardar.setEnabled(true);
                setEnableBotones(true);
                pg.getpHistoriaClinica().resetIncIdFamiliar();
                pg.getpHistoriaClinica().setTipoGuardado("EDITAR");
            }
            case "Guardar Historia" -> {
                pg.getpHistoriaClinica().limpiarAntecedentesPatologicos();
                guardarDatosPaciente();
                switch (pg.getpHistoriaClinica().getTipoGuardado()) {
                    case "NUEVO" -> {
                        pg.getpHistoriaClinica().registrarHistoriaClinica();
                    }
                    case "EDITAR" -> {
                        pg.getpHistoriaClinica().editarHistoriaClinica();
                    }
                }
                pg.getpHistoriaClinica().limpiarAntecedentesPatologicos();
                pg.getpHistoriaClinica().resetModeloHistoriaClinica("Paciente");
                bttn_guardar.setEnabled(false);
                bttn_editarHistoria.setEnabled(false);
                setEnableBotones(false);
                mostrarTablaBuscarHistoria(pg.getpHistoriaClinica().buscarHistoriaClinicaCoincidente(getInputText(txtFld_valorBuscado)));
            }
        }
    }

    public void guardarDatosPaciente() {
        String tipoHistoria = (String) cmbBx_tipoHistoria.getSelectedItem();
        switch (tipoHistoria) {
            case "Estudiante" -> {
                pHistoriaEstudiante.guardarEnfermedades();
                pHistoriaEstudiante.guardarPaciente();
            }
            case "Trabajador" -> {
                pHistoriaTrabajador.guardarEnfermedades();
                pHistoriaTrabajador.guardarPaciente();
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        boolean descarte = true;
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tbl_busquedaHistoria.getSelectedRow();
            if (selectedRow != -1) {
                if ((bttn_editarHistoria.isEnabled() && bttn_guardar.isEnabled()) || (bttn_nuevaHistoria.isEnabled() && bttn_guardar.isEnabled())) {
                    descarte = (0 == JOptionPane.showConfirmDialog(null, "¿Desea descartar la edición?"));
                }
                if (descarte) {
                    pg.getpHistoriaClinica().setHistoriaClinica((HistoriaClinica) tbl_busquedaHistoria.getValueAt(selectedRow, 0));
                    bttn_guardar.setEnabled(false);
                    bttn_editarHistoria.setEnabled(true);
                    setEnableBotones(false);
                    if (pg.getpHistoriaClinica().getTipoPaciente().equals("Alumno")) {
                        cmbBx_tipoHistoria.setSelectedIndex(1);
                        pg.getpHistoriaClinica().cambiarTipoHistoriaClinica(pnl_baseHistoriaClinica, pHistoriaEstudiante);
                        pHistoriaEstudiante.mostrarHistoriaClinicaEstudiante();
                        pHistoriaEstudiante.mostrarFamiliar();
                    } else {
                        cmbBx_tipoHistoria.setSelectedIndex(2);
                        pg.getpHistoriaClinica().cambiarTipoHistoriaClinica(pnl_baseHistoriaClinica, pHistoriaTrabajador);
                        pHistoriaTrabajador.mostrarHistoriaClinicaTrabajador();
                        pHistoriaTrabajador.mostrarFamiliar();
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFld_valorBuscado = new javax.swing.JTextField();
        bttn_buscar = new javax.swing.JButton();
        scrll_tablaBusqueda = new javax.swing.JScrollPane();
        tbl_busquedaHistoria = new javax.swing.JTable();
        cmbBx_tipoHistoria = new javax.swing.JComboBox<>();
        bttn_editarHistoria = new javax.swing.JButton();
        bttn_guardar = new javax.swing.JButton();
        pnl_baseHistoriaClinica = new javax.swing.JPanel();
        lbl_indicacionTipoHistoria = new javax.swing.JLabel();
        bttn_nuevaHistoria = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFld_valorBuscado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_valorBuscado.setPreferredSize(new java.awt.Dimension(250, 35));
        add(txtFld_valorBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, -1));

        bttn_buscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttn_buscar.setText("Buscar");
        bttn_buscar.setPreferredSize(new java.awt.Dimension(150, 35));
        add(bttn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 130, 35));

        tbl_busquedaHistoria.setModel(modelTablaBuscarHistoria);
        tbl_busquedaHistoria.setPreferredSize(new java.awt.Dimension(400, 495));
        tbl_busquedaHistoria.getTableHeader().setReorderingAllowed(false);
        scrll_tablaBusqueda.setViewportView(tbl_busquedaHistoria);

        add(scrll_tablaBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 400, 495));

        cmbBx_tipoHistoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBx_tipoHistoria.setModel(comboBoxNuevaHistoria);
        cmbBx_tipoHistoria.setActionCommand("Tipo Historia");
        cmbBx_tipoHistoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbBx_tipoHistoria.setPreferredSize(new java.awt.Dimension(215, 35));
        add(cmbBx_tipoHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 180, -1));

        bttn_editarHistoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttn_editarHistoria.setText("Editar Historia");
        bttn_editarHistoria.setPreferredSize(new java.awt.Dimension(163, 35));
        add(bttn_editarHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 150, -1));

        bttn_guardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttn_guardar.setText("Guardar");
        bttn_guardar.setActionCommand("Guardar Historia");
        bttn_guardar.setPreferredSize(new java.awt.Dimension(133, 35));
        add(bttn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 30, -1, -1));

        pnl_baseHistoriaClinica.setBackground(new java.awt.Color(204, 204, 204));
        pnl_baseHistoriaClinica.setPreferredSize(new java.awt.Dimension(775, 495));

        lbl_indicacionTipoHistoria.setBackground(new java.awt.Color(217, 217, 217));
        lbl_indicacionTipoHistoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_indicacionTipoHistoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_indicacionTipoHistoria.setText("<html>\n<h2>Seleccione un nuevo tipo de historia</h2>\n<ul>\n<li>Historia para Estudiantes</li>\n<li>Historia para Trabajadores</li>\n</ul>\n</html>");
        lbl_indicacionTipoHistoria.setToolTipText("");

        javax.swing.GroupLayout pnl_baseHistoriaClinicaLayout = new javax.swing.GroupLayout(pnl_baseHistoriaClinica);
        pnl_baseHistoriaClinica.setLayout(pnl_baseHistoriaClinicaLayout);
        pnl_baseHistoriaClinicaLayout.setHorizontalGroup(
            pnl_baseHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_indicacionTipoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnl_baseHistoriaClinicaLayout.setVerticalGroup(
            pnl_baseHistoriaClinicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_indicacionTipoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        add(pnl_baseHistoriaClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 95, 775, 495));

        bttn_nuevaHistoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttn_nuevaHistoria.setText("Nueva Historia");
        add(bttn_nuevaHistoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 30, 150, 35));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttn_buscar;
    private javax.swing.JButton bttn_editarHistoria;
    private javax.swing.JButton bttn_guardar;
    public javax.swing.JButton bttn_nuevaHistoria;
    private javax.swing.JComboBox<String> cmbBx_tipoHistoria;
    private javax.swing.JLabel lbl_indicacionTipoHistoria;
    private javax.swing.JPanel pnl_baseHistoriaClinica;
    private javax.swing.JScrollPane scrll_tablaBusqueda;
    private javax.swing.JTable tbl_busquedaHistoria;
    private javax.swing.JTextField txtFld_valorBuscado;
    // End of variables declaration//GEN-END:variables
}
