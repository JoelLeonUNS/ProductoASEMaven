
package vista;

import consultas.ConsultaMedica;
import historias.HistoriaClinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import presentador.PresentadorGeneral;

public class PanelExamen extends javax.swing.JPanel implements ActionListener, ListSelectionListener {

    private PresentadorGeneral pGeneral;
    private PanelExamenClinico pExamenClinico;
    private PanelExamenMedico pExamenMedico;
    private PanelExamenFisico pExamenFisico;
    
    private DefaultTableModel modelTablaBuscarHistoria = new DefaultTableModel();
    private DefaultTableModel modelTablaConsultas = new DefaultTableModel();
    private DefaultComboBoxModel comboBoxTipoExamen = new DefaultComboBoxModel();
    
    public PanelExamen(PresentadorGeneral p) {
        initComponents();
        crearEncabezadosTablaHistorias();
        crearEncabezadosTablaConsultas();
        this.pGeneral = p;
        this.pExamenClinico = new PanelExamenClinico();
        this.pExamenFisico = new PanelExamenFisico();
        this.pExamenMedico = new PanelExamenMedico();
        this.cmbBx_tipoExamen.addActionListener(this);
        this.jButtonBuscar.addActionListener(this);
        this.jButtonAñadirConsulta.addActionListener(this);
        this.jButtonGuardar.addActionListener(this);
        this.pExamenMedico.jButtonGuardarExamMedico.addActionListener(this);
        this.pExamenFisico.jButtonGuardarExamFisico.addActionListener(this);
        this.pExamenClinico.jButtonGuardarExamClinico.addActionListener(this);
        
        this.jTableHistorias.getSelectionModel().addListSelectionListener(this);
        this.jTableConsultas.getSelectionModel().addListSelectionListener(this);
        
        this.jButtonGuardar.setEnabled(false);
        pExamenMedico.jButtonGuardarExamMedico.setEnabled(false);
        pExamenFisico.jButtonGuardarExamFisico.setEnabled(false);
        pExamenClinico.jButtonGuardarExamClinico.setEnabled(false);
        setTxtFldsEditable(false);
        
        llenarComboBoxTipoExamen();
    }
    
    private void llenarComboBoxTipoExamen() {
        cmbBx_tipoExamen.addItem("Tipo de Examen");
        cmbBx_tipoExamen.addItem("Examen Médico");
        cmbBx_tipoExamen.addItem("Examen Físico");
        cmbBx_tipoExamen.addItem("Examen Clínico");
    }
    
    private void crearEncabezadosTablaHistorias(){
        modelTablaBuscarHistoria.addColumn("DNI");
        modelTablaBuscarHistoria.addColumn("Nombre");
        modelTablaBuscarHistoria.addColumn("Apellido");
    }
    
    private void crearEncabezadosTablaConsultas(){
        modelTablaConsultas.addColumn("N°");
        modelTablaConsultas.addColumn("Fecha");
        modelTablaConsultas.addColumn("Motivo");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistorias = new javax.swing.JTable();
        jButtonAñadirConsulta = new javax.swing.JButton();
        cmbBx_tipoExamen = new javax.swing.JComboBox<>();
        jButtonGuardar = new javax.swing.JButton();
        pnl_consultaExamenes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFldFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFldHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFldEdad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFldTiempoEferm = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtFldMotivo = new javax.swing.JTextArea();
        txtFldSueño = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFldSed = new javax.swing.JTextField();
        txtFldEstadoAnimo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFldApetito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pnl_baseTipoExamen = new javax.swing.JPanel();
        lbl_indicacionTipoHistoria = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableConsultas = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(250, 35));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(150, 35));
        add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 30, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(404, 250));

        jTableHistorias.setModel(modelTablaBuscarHistoria);
        jTableHistorias.setPreferredSize(new java.awt.Dimension(404, 300));
        jTableHistorias.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableHistorias);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 95, 404, 250));

        jButtonAñadirConsulta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAñadirConsulta.setText("Añadir consulta");
        jButtonAñadirConsulta.setPreferredSize(new java.awt.Dimension(163, 35));
        add(jButtonAñadirConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 30, -1, -1));

        cmbBx_tipoExamen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBx_tipoExamen.setModel(comboBoxTipoExamen);
        cmbBx_tipoExamen.setActionCommand("Tipo de Examen");
        cmbBx_tipoExamen.setPreferredSize(new java.awt.Dimension(200, 35));
        add(cmbBx_tipoExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 30, -1, -1));

        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setPreferredSize(new java.awt.Dimension(133, 35));
        add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1115, 30, -1, -1));

        pnl_consultaExamenes.setBackground(new java.awt.Color(217, 217, 217));
        pnl_consultaExamenes.setPreferredSize(new java.awt.Dimension(764, 500));
        pnl_consultaExamenes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Fecha");
        pnl_consultaExamenes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtFldFecha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldFecha.setPreferredSize(new java.awt.Dimension(180, 30));
        pnl_consultaExamenes.add(txtFldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 55, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Hora");
        pnl_consultaExamenes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 30, -1, -1));

        txtFldHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldHora.setPreferredSize(new java.awt.Dimension(120, 30));
        pnl_consultaExamenes.add(txtFldHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 55, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Edad");
        pnl_consultaExamenes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 30, -1, -1));

        txtFldEdad.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldEdad.setPreferredSize(new java.awt.Dimension(90, 30));
        pnl_consultaExamenes.add(txtFldEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 55, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Tiempo de enfermedad");
        pnl_consultaExamenes.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 30, -1, -1));

        txtFldTiempoEferm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldTiempoEferm.setPreferredSize(new java.awt.Dimension(234, 30));
        pnl_consultaExamenes.add(txtFldTiempoEferm, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 55, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Motivo");
        pnl_consultaExamenes.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 100, -1, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(234, 99));

        txtFldMotivo.setColumns(20);
        txtFldMotivo.setRows(5);
        txtFldMotivo.setPreferredSize(new java.awt.Dimension(232, 85));
        jScrollPane2.setViewportView(txtFldMotivo);

        pnl_consultaExamenes.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(488, 125, -1, -1));

        txtFldSueño.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldSueño.setPreferredSize(new java.awt.Dimension(205, 30));
        pnl_consultaExamenes.add(txtFldSueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 125, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Sueño");
        pnl_consultaExamenes.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Sed");
        pnl_consultaExamenes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 170, -1, -1));

        txtFldSed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldSed.setPreferredSize(new java.awt.Dimension(205, 30));
        pnl_consultaExamenes.add(txtFldSed, new org.netbeans.lib.awtextra.AbsoluteConstraints(259, 195, -1, -1));

        txtFldEstadoAnimo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldEstadoAnimo.setPreferredSize(new java.awt.Dimension(205, 30));
        pnl_consultaExamenes.add(txtFldEstadoAnimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Estado de ánimo");
        pnl_consultaExamenes.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtFldApetito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldApetito.setPreferredSize(new java.awt.Dimension(205, 30));
        pnl_consultaExamenes.add(txtFldApetito, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 125, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Apetito");
        pnl_consultaExamenes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        pnl_baseTipoExamen.setBackground(new java.awt.Color(200, 200, 200));
        pnl_baseTipoExamen.setPreferredSize(new java.awt.Dimension(764, 250));

        lbl_indicacionTipoHistoria.setBackground(new java.awt.Color(217, 217, 217));
        lbl_indicacionTipoHistoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_indicacionTipoHistoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_indicacionTipoHistoria.setText("<html>\n<h2>Seleccione un tipo de examen</h2>\n<ul>\n<li>Examen médico</li>\n<li>Examen físico</li>\n<li>Examen clínico</li>\n</ul>\n</html>");
        lbl_indicacionTipoHistoria.setToolTipText("");

        javax.swing.GroupLayout pnl_baseTipoExamenLayout = new javax.swing.GroupLayout(pnl_baseTipoExamen);
        pnl_baseTipoExamen.setLayout(pnl_baseTipoExamenLayout);
        pnl_baseTipoExamenLayout.setHorizontalGroup(
            pnl_baseTipoExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_indicacionTipoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnl_baseTipoExamenLayout.setVerticalGroup(
            pnl_baseTipoExamenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_indicacionTipoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnl_consultaExamenes.add(pnl_baseTipoExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 764, 250));

        add(pnl_consultaExamenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 95, -1, -1));

        jScrollPane3.setPreferredSize(new java.awt.Dimension(404, 230));

        jTableConsultas.setModel(modelTablaConsultas);
        jTableConsultas.setPreferredSize(new java.awt.Dimension(404, 230));
        jTableConsultas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableConsultas);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 404, 230));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBx_tipoExamen;
    private javax.swing.JButton jButtonAñadirConsulta;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableConsultas;
    private javax.swing.JTable jTableHistorias;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_indicacionTipoHistoria;
    private javax.swing.JPanel pnl_baseTipoExamen;
    private javax.swing.JPanel pnl_consultaExamenes;
    private javax.swing.JTextField txtFldApetito;
    private javax.swing.JTextField txtFldEdad;
    private javax.swing.JTextField txtFldEstadoAnimo;
    private javax.swing.JTextField txtFldFecha;
    private javax.swing.JTextField txtFldHora;
    private javax.swing.JTextArea txtFldMotivo;
    private javax.swing.JTextField txtFldSed;
    private javax.swing.JTextField txtFldSueño;
    private javax.swing.JTextField txtFldTiempoEferm;
    // End of variables declaration//GEN-END:variables

    public boolean isBusquedaDNI(){
        return this.jTextField1.getText().matches("[0-9]+");
    }
    
    public void mostrarTablaBuscarHistoria(ArrayList<HistoriaClinica> historiasClinicas) {
        modelTablaBuscarHistoria.setRowCount(0);
        for (HistoriaClinica historiaClinica : historiasClinicas) {
            addHistoriaClinica(historiaClinica);
        }
    }
    
    private void addHistoriaClinica(HistoriaClinica historiaClinica) {
        if(historiaClinica!=null){
            modelTablaBuscarHistoria.addRow(new Object[]{
            historiaClinica, // Guardar el objeto HistoriaClinica
            historiaClinica.getPaciente().getNombre(),
            historiaClinica.getPaciente().getApellido(),   
            });
        }
    }
    
    public String getInput(JTextField jtxfld){
        return jtxfld.getText();
    }
    
    public void setTxtFldsEditable(boolean b){
        this.txtFldFecha.setEditable(b);
        this.txtFldHora.setEditable(b);
        this.txtFldEdad.setEditable(b);
        this.txtFldTiempoEferm.setEditable(b);
        this.txtFldEstadoAnimo.setEditable(b);
        this.txtFldSueño.setEditable(b);
        this.txtFldSed.setEditable(b);
        this.txtFldApetito.setEditable(b);
        this.txtFldMotivo.setEditable(b);
    }
    
    public void limpiarCasillas(){
        this.txtFldFecha.setText("");
        this.txtFldHora.setText("");
        this.txtFldEdad.setText("");
        this.txtFldTiempoEferm.setText("");
        this.txtFldEstadoAnimo.setText("");
        this.txtFldSueño.setText("");
        this.txtFldSed.setText("");
        this.txtFldApetito.setText("");
        this.txtFldMotivo.setText("");
    }
    
    public void setDatosConsulta(){
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setFecha(LocalDate.parse(txtFldFecha.getText()));
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setHora(LocalTime.parse(txtFldHora.getText()));
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setEdad(Integer.parseInt(txtFldEdad.getText()));
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setTiempoEnfermedad(txtFldTiempoEferm.getText());
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setApetito(txtFldApetito.getText());
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setSueño(txtFldSueño.getText());
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setEstadoAnimo(txtFldEstadoAnimo.getText());
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setSed(txtFldSed.getText());
        pGeneral.getpExamen().getModeloConsulta().getConsulta().setMotivo(txtFldMotivo.getText());
    }
    
    public void setDatosExamenMedico(){
        pGeneral.getpExamen().setDatosExamenMedico(pExamenMedico.gettxtFldDiagnostico(), pExamenMedico.gettxtFldTratamiento(), pExamenMedico.gettxtFldExamAux(), pExamenMedico.gettxtFldObservacion());
    }
    
    public void setDatosExamenClinico(){
        pGeneral.getpExamen().setDatosExamenClinico(pExamenClinico.gettxtFldObservacion(), pExamenClinico.getjCheckBoxAPcard(), pExamenClinico.getjCheckBoxAPresp());
    }
    
    public void setDatosExamenFisico(){
        pGeneral.getpExamen().setDatosExamenFisico(pExamenFisico.gettxtFldTemperatura(), pExamenFisico.gettxtFldPA(), pExamenFisico.gettxtFldFR(), pExamenFisico.gettxtFldSPO2(), pExamenFisico.gettxtFldPeso(), pExamenFisico.gettxtFldTalla(), pExamenFisico.gettxtFldIMC(), pExamenFisico.gettxtFldFC(), pExamenFisico.gettxtFldPerAbdom());
    }

    public void resetearPanelMedico(){
        pExamenMedico.limpiarCasillas();
    }
    
    public void resetearPanelFisico(){
        pExamenFisico.limpiarCasillas();
    }
    
    public void resetearPanelClinico(){
        pExamenClinico.limpiarCasillas();
    }
    
    public void limpiarPanelCompleto(){
        limpiarCasillas();
        resetearPanelMedico();
        resetearPanelFisico();
        resetearPanelClinico();
    }
    
    public void setEditablePanel(boolean b){
        setTxtFldsEditable(b);
        pExamenMedico.setEditableFlds(b);
        pExamenFisico.setEditableFlds(b);
        pExamenClinico.setEditableFlds(b);
    }
    
    public void showMsg(String s){
        JOptionPane.showMessageDialog(null, s);
    }
    
    public void añadirConsultaAHistoria(){
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaClinica().agregarConsulta(pGeneral.getpExamen().getModeloConsulta().getConsulta());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Tipo de Examen" -> {
                switch (cmbBx_tipoExamen.getSelectedIndex()) {
                    case 1 -> {
                        pGeneral.getpExamen().cambiarTipoExamen(pnl_baseTipoExamen, pExamenMedico);
                        pGeneral.getpExamen().setTipoExamen("MEDICO");
                    }
                    case 2 -> {
                        pGeneral.getpExamen().cambiarTipoExamen(pnl_baseTipoExamen, pExamenFisico);
                        pGeneral.getpExamen().setTipoExamen("FISICO");
                    }
                    case 3 -> {
                        pGeneral.getpExamen().cambiarTipoExamen(pnl_baseTipoExamen, pExamenClinico);
                        pGeneral.getpExamen().setTipoExamen("CLINICO");
                    }
                }
            }
            case "Buscar"->{
                if(isBusquedaDNI()){  //VERIFICAR USO DEL PRESENTADOR HISTORIA CLINICA
                    modelTablaBuscarHistoria.setRowCount(0);
                    addHistoriaClinica(pGeneral.getpHistoriaClinica().buscarHistoriaClinicaDNI(getInput(jTextField1)));
                }else{
                    mostrarTablaBuscarHistoria(pGeneral.getpHistoriaClinica().buscarHistoriaClinicaCoincidente(getInput(jTextField1)));
                }
            }
            case "Añadir consulta"->{
                pGeneral.getpExamen().getModeloConsulta().setConsulta(new ConsultaMedica());
                limpiarPanelCompleto();
                setEditablePanel(true);
                //limpiarCasillas();
                //setTxtFldsEditable(true);
                this.jButtonGuardar.setEnabled(true);
                pExamenMedico.jButtonGuardarExamMedico.setEnabled(true);
                pExamenFisico.jButtonGuardarExamFisico.setEnabled(true);
                pExamenClinico.jButtonGuardarExamClinico.setEnabled(true);
            }
            case "Guardar"->{
                setDatosConsulta();
                añadirConsultaAHistoria();
                showMsg("Consulta añadida");
                limpiarPanelCompleto();
                setEditablePanel(false);
                //limpiarCasillas();
                this.jButtonGuardar.setEnabled(false);
            }
            
            case "Guardar Examen Medico"->{
                //pGeneral.getpExamen().iniciarExamen();
                setDatosExamenMedico();
                pGeneral.getpExamen().añadirExamenAConsulta();
                showMsg("Examen añadido");
                pExamenMedico.setEditableFlds(false);
                pExamenMedico.jButtonGuardarExamMedico.setEnabled(false);
                //resetearPanelMedico();
            }
            case "Guardar Examen Fisico"->{
                //pGeneral.getpExamen().iniciarExamen();
                setDatosExamenFisico();
                pGeneral.getpExamen().añadirExamenAConsulta();
                showMsg("Examen añadido");
                pExamenFisico.setEditableFlds(false);
                pExamenFisico.jButtonGuardarExamFisico.setEnabled(false);
                //resetearPanelFisico();
            }
            case "Guardar Examen Clinico"->{
                //pGeneral.getpExamen().iniciarExamen();
                setDatosExamenClinico();
                pGeneral.getpExamen().añadirExamenAConsulta();
                showMsg("Examen añadido");
                pExamenClinico.setEditableFlds(false);
                pExamenClinico.jButtonGuardarExamClinico.setEnabled(false);
                //resetearPanelClinico();
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
             if (e.getSource() == jTableHistorias.getSelectionModel()) {
                this.jButtonGuardar.setEnabled(false);
                int selectedRow = jTableHistorias.getSelectedRow();
                if (selectedRow != -1) {
                    pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().setHistoriaClinica((HistoriaClinica) jTableHistorias.getValueAt(selectedRow, 0));
                    pGeneral.getpExamen().setConsultasAHistoria();
                    //String dni = jTableHistorias.getValueAt(selectedRow, 0).toString();
                    mostrarConsultas(pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaClinica().getConsultasMedicas());
                }
             }else if(e.getSource() == jTableConsultas.getSelectionModel()){
                this.jButtonGuardar.setEnabled(false);
                int selectedRow = jTableConsultas.getSelectedRow();
                if (selectedRow != -1){
                    limpiarPanelCompleto();
                    int numConsulta = (Integer) jTableConsultas.getValueAt(selectedRow, 0);
                    pGeneral.getpExamen().getModeloConsulta().setConsulta(pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaClinica().getConsultasMedicas().get(numConsulta-1));
                    mostrarDatosConsulta();
                    mostrarDatosExamenes(pGeneral.getpExamen().getModeloConsulta().getConsulta());
                }
             }
            
        }
    }
    
    public void mostrarConsultas(ArrayList<ConsultaMedica> consultas){
        modelTablaConsultas.setRowCount(0);
        for (int i = 0; i < consultas.size(); i++) {
            addConsultaMedica(consultas.get(i), i+1);
        }
    }
    
    private void addConsultaMedica(ConsultaMedica consulta, int i) {  
        if(consulta!=null){
            modelTablaConsultas.addRow(new Object[]{
            i,
            consulta.getFecha(),
            consulta.getMotivo(),   
            });
        }
    }
    
    public void mostrarDatosConsulta(){
        txtFldFecha.setText(String.valueOf(pGeneral.getpExamen().getModeloConsulta().getConsulta().getFecha()));
        txtFldHora.setText(String.valueOf(pGeneral.getpExamen().getModeloConsulta().getConsulta().getHora()));
        txtFldEdad.setText(String.valueOf(pGeneral.getpExamen().getModeloConsulta().getConsulta().getEdad()));
        txtFldTiempoEferm.setText(String.valueOf(pGeneral.getpExamen().getModeloConsulta().getConsulta().getTiempoEnfermedad()));
        txtFldApetito.setText(pGeneral.getpExamen().getModeloConsulta().getConsulta().getApetito());
        txtFldSueño.setText(pGeneral.getpExamen().getModeloConsulta().getConsulta().getSueño());
        txtFldEstadoAnimo.setText(pGeneral.getpExamen().getModeloConsulta().getConsulta().getEstadoAnimo());
        txtFldSed.setText(pGeneral.getpExamen().getModeloConsulta().getConsulta().getSed());
        txtFldMotivo.setText(pGeneral.getpExamen().getModeloConsulta().getConsulta().getMotivo());
    }
    
    public void mostrarDatosExamenes(ConsultaMedica consulta){
        //pExamenMedico.settxtFldDiagnostico(pGeneral.getpExamen().getModeloConsulta().getConsulta().getExamenes().);
        for (int i = 0; i < consulta.getExamenes().size(); i++) {
            pGeneral.getpExamen().getModeloExamen().getTipoExamen(consulta.getExamenes().get(i));
            if(pGeneral.getpExamen().getModeloExamen().getExamenTmp().equals("MEDICO")){
                mostrarExamenMedico();
            }else if(pGeneral.getpExamen().getModeloExamen().getExamenTmp().equals("FISICO")){
                mostrarExamenFisico();
            }else if(pGeneral.getpExamen().getModeloExamen().getExamenTmp().equals("CLINICO")){
                mostrarExamenClinico();
            }
        }
    }
    
    public void mostrarExamenMedico(){
       pExamenMedico.settxtFldDiagnostico(pGeneral.getpExamen().getModeloExamen().getExamenMedicoTmp().getDiagnostico());
       pExamenMedico.settxtFldTratamiento(pGeneral.getpExamen().getModeloExamen().getExamenMedicoTmp().getTratamiento());
       pExamenMedico.settxtFldExamAux(pGeneral.getpExamen().getModeloExamen().getExamenMedicoTmp().getExamenesAux());
       pExamenMedico.settxtFldObservacion(pGeneral.getpExamen().getModeloExamen().getExamenMedicoTmp().getObservacion());
    }
    
    public void mostrarExamenFisico(){
        pExamenFisico.settxtFldFC(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getFC());
        pExamenFisico.settxtFldFR(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getFR());
        pExamenFisico.settxtFldIMC(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getIMC());
        pExamenFisico.settxtFldObservacion(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getObservacion());
        pExamenFisico.settxtFldPA(String.valueOf(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getPA()));
        pExamenFisico.settxtFldPerAbdom(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getPerimetroAbdominal());
        pExamenFisico.settxtFldPeso(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getPeso());
        pExamenFisico.settxtFldSPO2(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getSPO2());
        pExamenFisico.settxtFldTalla(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getTalla());
        pExamenFisico.settxtFldTemperatura(pGeneral.getpExamen().getModeloExamen().getExamenFisicoTmp().getTemperatura());
    }
    
    public void mostrarExamenClinico(){
        pExamenClinico.settxtFldObservacion(pGeneral.getpExamen().getModeloExamen().getExamenClinicoTmp().getObservacion());
        pExamenClinico.setjCheckBoxAPcard(pGeneral.getpExamen().getModeloExamen().getExamenClinicoTmp().isAPCardiovascular());
        pExamenClinico.setjCheckBoxAPresp(pGeneral.getpExamen().getModeloExamen().getExamenClinicoTmp().isAPRespiratorio());
    }
}
