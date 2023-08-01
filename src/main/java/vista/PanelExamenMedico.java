package vista;


public class PanelExamenMedico extends javax.swing.JPanel {

    public PanelExamenMedico() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFldExamAux = new javax.swing.JTextField();
        txtFldObservacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFldDiagnostico = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtFldTratamiento = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButtonGuardarExamMedico = new javax.swing.JButton();

        setBackground(new java.awt.Color(217, 217, 217));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(764, 250));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Diagnóstico");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 45, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tratamiento");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 45, -1, -1));

        txtFldExamAux.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldExamAux.setPreferredSize(new java.awt.Dimension(260, 30));
        add(txtFldExamAux, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 195, -1, -1));

        txtFldObservacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFldObservacion.setPreferredSize(new java.awt.Dimension(260, 30));
        add(txtFldObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 195, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Examenes Auxiliares");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Observación");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 170, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(331, 90));

        txtFldDiagnostico.setColumns(20);
        txtFldDiagnostico.setRows(5);
        txtFldDiagnostico.setPreferredSize(new java.awt.Dimension(331, 80));
        jScrollPane1.setViewportView(txtFldDiagnostico);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(331, 90));

        txtFldTratamiento.setColumns(20);
        txtFldTratamiento.setRows(5);
        txtFldTratamiento.setPreferredSize(new java.awt.Dimension(331, 75));
        jScrollPane2.setViewportView(txtFldTratamiento);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Examen Médico");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 10, -1, -1));

        jButtonGuardarExamMedico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonGuardarExamMedico.setText("Guardar");
        jButtonGuardarExamMedico.setActionCommand("Guardar Examen Medico");
        jButtonGuardarExamMedico.setPreferredSize(new java.awt.Dimension(122, 30));
        add(jButtonGuardarExamMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 195, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonGuardarExamMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtFldDiagnostico;
    private javax.swing.JTextField txtFldExamAux;
    private javax.swing.JTextField txtFldObservacion;
    private javax.swing.JTextArea txtFldTratamiento;
    // End of variables declaration//GEN-END:variables

    public String gettxtFldDiagnostico() {
        return txtFldDiagnostico.getText();
    }

    public void settxtFldDiagnostico(String jTextArea1) {
        this.txtFldDiagnostico.setText(jTextArea1);
    }

    public String gettxtFldTratamiento() {
        return txtFldTratamiento.getText();
    }

    public void settxtFldTratamiento(String jTextArea2) {
        this.txtFldTratamiento.setText(jTextArea2);
    }

    public String gettxtFldExamAux() {
        return txtFldExamAux.getText();
    }

    public void settxtFldExamAux(String jTextField6) {
        this.txtFldExamAux.setText(jTextField6);
    }

    public String gettxtFldObservacion() {
        return txtFldObservacion.getText();
    }

    public void settxtFldObservacion(String jTextField8) {
        this.txtFldObservacion.setText(jTextField8);
    }    
    
    public void limpiarCasillas(){
        this.txtFldDiagnostico.setText("");
        this.txtFldTratamiento.setText("");
        this.txtFldExamAux.setText("");
        this.txtFldObservacion.setText("");
    }
    
    public void setEditableFlds(boolean b){
        this.txtFldDiagnostico.setEditable(b);
        this.txtFldTratamiento.setEditable(b);
        this.txtFldExamAux.setEditable(b);
        this.txtFldObservacion.setEditable(b);
    }
}
