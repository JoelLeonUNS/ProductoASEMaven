package vista;


public class PanelExamenClinico extends javax.swing.JPanel {

    public PanelExamenClinico() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCheckBoxAPcard = new javax.swing.JCheckBox();
        jCheckBoxAPresp = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtFldObservacion = new javax.swing.JTextArea();
        jButtonGuardarExamClinico = new javax.swing.JButton();

        setBackground(new java.awt.Color(217, 217, 217));
        setPreferredSize(new java.awt.Dimension(764, 250));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Examen Clínico");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 10, -1, -1));

        jCheckBoxAPcard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxAPcard.setText("AP Cardiovascular");
        add(jCheckBoxAPcard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jCheckBoxAPresp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxAPresp.setText("AP Respiratorio");
        add(jCheckBoxAPresp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Observación");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(280, 86));

        txtFldObservacion.setColumns(20);
        txtFldObservacion.setRows(5);
        jScrollPane1.setViewportView(txtFldObservacion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jButtonGuardarExamClinico.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonGuardarExamClinico.setText("Guardar");
        jButtonGuardarExamClinico.setActionCommand("Guardar Examen Clinico");
        jButtonGuardarExamClinico.setPreferredSize(new java.awt.Dimension(122, 30));
        add(jButtonGuardarExamClinico, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonGuardarExamClinico;
    private javax.swing.JCheckBox jCheckBoxAPcard;
    private javax.swing.JCheckBox jCheckBoxAPresp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtFldObservacion;
    // End of variables declaration//GEN-END:variables

    public boolean getjCheckBoxAPcard() {
        return jCheckBoxAPcard.isSelected();
    }

    public void setjCheckBoxAPcard(boolean jCheckBox1) {
        this.jCheckBoxAPcard.setSelected(jCheckBox1);
    }

    public boolean getjCheckBoxAPresp() {
        return jCheckBoxAPresp.isSelected();
    }

    public void setjCheckBoxAPresp(boolean jCheckBox2) {
        this.jCheckBoxAPresp.setSelected(jCheckBox2);
    }

    public String gettxtFldObservacion() {
        return txtFldObservacion.getText();
    }

    public void settxtFldObservacion(String jTextArea1) {
        this.txtFldObservacion.setText(jTextArea1);
    }
    
    public void limpiarCasillas(){
        this.txtFldObservacion.setText("");
        this.jCheckBoxAPcard.setSelected(false);
        this.jCheckBoxAPresp.setSelected(false);
    }

    public void setEditableFlds(boolean b){
        this.txtFldObservacion.setEditable(b);
        this.jCheckBoxAPcard.setEnabled(b);
        this.jCheckBoxAPresp.setEnabled(b);
    }
}
