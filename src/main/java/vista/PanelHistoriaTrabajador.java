package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Enfermedad;
import pacientes.Trabajador;
import presentador.PresentadorGeneral;

public class PanelHistoriaTrabajador extends javax.swing.JPanel implements ActionListener{

    private PresentadorGeneral pGeneral;   
    private JCheckBox[] checkBoxes;
    ButtonGroup buttonGroupSexo = new ButtonGroup();
    ButtonGroup buttonGroupDocente = new ButtonGroup();
    private DefaultComboBoxModel comboBoxEstaoCivil = new DefaultComboBoxModel();
    private DefaultComboBoxModel comboBoxParentesco = new DefaultComboBoxModel();

    public PanelHistoriaTrabajador(PresentadorGeneral pGeneral) {
        initComponents();
        this.pGeneral = pGeneral;
        checkBoxes = arrayCheckBox();
        buttonGroupSexo.add(rdBttn_m);
        buttonGroupSexo.add(rdBttn_f);
        buttonGroupDocente.add(rdBttn_no);
        buttonGroupDocente.add(rdBttn_si);
        pGeneral.getpHistoriaClinica().setTipoHistoria("TRABAJADOR");
        pGeneral.getpHistoriaClinica().setHistoriaEditable(false);

        cmbBx_parentesco.addActionListener(this);
        bttn_guardarFamiliar.addActionListener(this);
        setEnableBotones();
    }
    
    public String getInputText(JTextField txtFld) {
        return txtFld.getText();
    }

    public void setInputText(JTextField txtFld, String cadena) {
        txtFld.setText(cadena);
    }

    public String getInputTextAr(JTextArea txtAr) {
        return txtAr.getText();
    }

    public void setInputTextAr(JTextArea txtAr, String cadena) {
        txtAr.setText(cadena);
    }

    public String getComboBoxText(JComboBox cmbBx) {
        return (String) cmbBx.getSelectedItem();
    }
    
    public String getRadioButtonSexo() {
        return (rdBttn_m.isSelected() ? rdBttn_m.getText() : "F");
    }
    
    public boolean getRadioButtonDocente() {
        return rdBttn_si.isSelected();
    }
    
    
    private JCheckBox[] arrayCheckBox() {
        JCheckBox[] chckBxs = {
            jCheckBox1,jCheckBox2,jCheckBox3,jCheckBox4,jCheckBox5,jCheckBox6,
            jCheckBox7, jCheckBox8, jCheckBox9, jCheckBox10, jCheckBox11, jCheckBox12,
            jCheckBox13, jCheckBox14, jCheckBox15, jCheckBox16, jCheckBox17, jCheckBox18,
            jCheckBox19, jCheckBox20, jCheckBox21, jCheckBox22, jCheckBox23, jCheckBox24
        };
        return chckBxs;
    }

    public void setEnableBotones() {
        txtFld_apellidos.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_nombres.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        rdBttn_m.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        rdBttn_f.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_fechaNac.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_lugarNac.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_distrito.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_departamento.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_direccion.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_areaTrabajo.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_telefono.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        rdBttn_no.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        rdBttn_si.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        cmbBx_estadoCivil.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        jCheckBox1.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        }
        cmbBx_parentesco.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_nombreFamiliar.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_direccionFamiliar.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtAr_antecedentes.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        txtFld_telefonoFamiliar.setEditable(pGeneral.getpHistoriaClinica().isHistoriaEditable());
        bttn_guardarFamiliar.setEnabled(pGeneral.getpHistoriaClinica().isHistoriaEditable());
    }
    
    public void guardarEnfermedades() {
        int i = 0;
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                pGeneral.getpHistoriaClinica().agregarEnfermedad(Enfermedad.values()[i]);
            }
            i++;
        }
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaClinicaTrabajador().setOtrosAntecedentesPatologicos(getInputText(txtFld_otros));
    }
    
    public void guardarPaciente() {
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getEstudiante().setDNI(getInputText(txtFld_dni));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setApellido(getInputText(txtFld_apellidos));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setNombre(getInputText(txtFld_nombres));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setTelefono(getInputText(txtFld_telefono));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setSexo(getRadioButtonSexo());
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setFechaNac(getInputText(txtFld_fechaNac));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setLugarNac(getInputText(txtFld_lugarNac));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setDistrito(getInputText(txtFld_distrito));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setDepartamento(getInputText(txtFld_departamento));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setDireccion(getInputText(txtFld_direccion));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setAreaTrabajo(getInputText(txtFld_areaTrabajo));
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setDocente(getRadioButtonDocente());
        pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getTrabajador().setEstadoCivil(getComboBoxText(cmbBx_estadoCivil));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int intParentesco = cmbBx_parentesco.getSelectedIndex();
        switch (e.getActionCommand()) {
            case "Guardar" -> {
                pGeneral.getpHistoriaClinica().setDatosFamiliar(getInputText(txtFld_nombreFamiliar), getComboBoxText(cmbBx_parentesco), getInputText(txtFld_direccionFamiliar), getInputText(txtFld_telefonoFamiliar), getInputTextAr(txtAr_antecedentes));
                switch (intParentesco) {
                    case 0 -> { // Padre
                        pGeneral.getpHistoriaClinica().agregarFamiliar(0);
                    }
                    case 1 -> { // Madre
                        pGeneral.getpHistoriaClinica().agregarFamiliar(1);
                    }
                    case 2 -> { // Hermano(a)
                        pGeneral.getpHistoriaClinica().agregarFamiliar(2);
                    }
                }
            }
            case "Parentesco" -> {
                switch (intParentesco) {
                    case 0 -> { // Padre
                        mostrarFamiliar(0);
                    }
                    case 1 -> { // Madre
                        mostrarFamiliar(1);
                    }
                    case 2 -> { // Hermano(a)
                        mostrarFamiliar(2);
                    }
                }
            }
        }
    }
    
    public void mostrarFamiliar(int indice) {
        setInputText(txtFld_nombreFamiliar, pGeneral.getpHistoriaClinica().getFamiliar(indice) == null ? "" : pGeneral.getpHistoriaClinica().getFamiliar(indice).getNombreFamiliar());
        setInputText(txtFld_direccionFamiliar, pGeneral.getpHistoriaClinica().getFamiliar(indice)  == null ? "" : pGeneral.getpHistoriaClinica().getFamiliar(indice).getDireccionFamiliar());
        setInputText(txtFld_telefonoFamiliar, pGeneral.getpHistoriaClinica().getFamiliar(indice)  == null ? "" : pGeneral.getpHistoriaClinica().getFamiliar(indice).getTelefonoFamiliar());
        setInputTextAr(txtAr_antecedentes, pGeneral.getpHistoriaClinica().getFamiliar(indice)  == null ? "" : pGeneral.getpHistoriaClinica().getFamiliar(indice).getAntecedentesPatologicos());
    }
    
    public void mostrarHistoriaClinicaTrabajador() {
        int indiceCheck = 0;
        int indiceEnf = 0;
        lbl_nroHistoriaClinica.setText("Historia Clínica: N° " + pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getNumeroHistoriaClinica());
        setInputText(txtFld_dni, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getDNI());
        setInputText(txtFld_apellidos, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getApellido());
        setInputText(txtFld_nombres, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getNombre());
        setInputText(txtFld_telefono, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getTelefono());
        rdBttn_m.setSelected(pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getSexo().equals("M"));
        rdBttn_f.setSelected(pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getSexo().equals("M"));
        setInputText(txtFld_fechaNac, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getFechaNac());
        setInputText(txtFld_lugarNac, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getLugarNac());
        setInputText(txtFld_distrito, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getDistrito());
        setInputText(txtFld_departamento, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getDepartamento());
        setInputText(txtFld_direccion, pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getDireccion());
        setInputText(txtFld_areaTrabajo, ((Trabajador) pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente()).getAreaTrabajo());
        rdBttn_si.setSelected(((Trabajador) pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente()).isDocente());
        rdBttn_no.setSelected(!((Trabajador) pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente()).isDocente());
        cmbBx_estadoCivil.setSelectedItem(pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getPaciente().getEstadoCivil());
        
        try {
            for (JCheckBox checkBox : checkBoxes) {
            checkBox.setSelected((pGeneral.getpHistoriaClinica().getModeloHistoriaClinica().getHistoriaSeleccionada().getAntecedentesPatologicos().get(indiceEnf).getIdEnfermedad() - 1) == indiceCheck);
            if (checkBox.isSelected()) {
                indiceEnf++;
            }
            indiceCheck++;
        }
        } catch (Exception e) {
        }
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_nroHistoriaClinica = new javax.swing.JLabel();
        lbl_condicionPaciente = new javax.swing.JLabel();
        lbl_sexo = new javax.swing.JLabel();
        txtFld_apellidos = new javax.swing.JTextField();
        lbl_departamento = new javax.swing.JLabel();
        txtFld_fechaNac = new javax.swing.JTextField();
        lbl_estadoCivil = new javax.swing.JLabel();
        txtFld_direccion = new javax.swing.JTextField();
        lbl_antecedentesFamiliares = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        lbl_otros = new javax.swing.JLabel();
        txtFld_otros = new javax.swing.JTextField();
        lbl_apellidos = new javax.swing.JLabel();
        txtFld_nombres = new javax.swing.JTextField();
        lbl_nombres = new javax.swing.JLabel();
        lbl_fechaNac = new javax.swing.JLabel();
        txtFld_lugarNac = new javax.swing.JTextField();
        txtFld_distrito = new javax.swing.JTextField();
        txtFld_departamento = new javax.swing.JTextField();
        lbl_lugarNac = new javax.swing.JLabel();
        lbl_distrito = new javax.swing.JLabel();
        txtFld_areaTrabajo = new javax.swing.JTextField();
        cmbBx_estadoCivil = new javax.swing.JComboBox<>();
        lbl_nombreFamiliar = new javax.swing.JLabel();
        lbl_areaTrabajo = new javax.swing.JLabel();
        txtFld_telefono = new javax.swing.JTextField();
        jCheckBox9 = new javax.swing.JCheckBox();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jCheckBox24 = new javax.swing.JCheckBox();
        lbl_antecedentesPatologicos = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        lbl_telefonoFamiliar = new javax.swing.JLabel();
        cmbBx_parentesco = new javax.swing.JComboBox<>();
        lbl_parentesco = new javax.swing.JLabel();
        lbl_direccionFamiliar = new javax.swing.JLabel();
        lbl_antecedentes = new javax.swing.JLabel();
        txtFld_nombreFamiliar = new javax.swing.JTextField();
        txtFld_direccionFamiliar = new javax.swing.JTextField();
        txtFld_telefonoFamiliar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAr_antecedentes = new javax.swing.JTextArea();
        bttn_guardarFamiliar = new javax.swing.JButton();
        lbl_docente = new javax.swing.JLabel();
        lbl_telefono = new javax.swing.JLabel();
        rdBttn_m = new javax.swing.JRadioButton();
        rdBttn_f = new javax.swing.JRadioButton();
        rdBttn_no = new javax.swing.JRadioButton();
        rdBttn_si = new javax.swing.JRadioButton();
        txtFld_dni = new javax.swing.JTextField();
        lbl_dni = new javax.swing.JLabel();

        setBackground(new java.awt.Color(217, 217, 217));
        setMinimumSize(new java.awt.Dimension(775, 495));
        setPreferredSize(new java.awt.Dimension(755, 495));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nroHistoriaClinica.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nroHistoriaClinica.setText("Historia Clínica: N° 000000001");
        add(lbl_nroHistoriaClinica, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 20, -1, -1));

        lbl_condicionPaciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_condicionPaciente.setText("Condición: Trabajador");
        add(lbl_condicionPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        lbl_sexo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_sexo.setText("Sexo");
        add(lbl_sexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, -1, -1));

        txtFld_apellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_apellidos.setPreferredSize(new java.awt.Dimension(300, 30));
        add(txtFld_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 71, 210, -1));

        lbl_departamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_departamento.setText("Departamento");
        add(lbl_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 105, -1, -1));

        txtFld_fechaNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_fechaNac.setPreferredSize(new java.awt.Dimension(150, 30));
        add(txtFld_fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 125, -1, -1));

        lbl_estadoCivil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_estadoCivil.setText("Estado Civil");
        add(lbl_estadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 160, -1, -1));

        txtFld_direccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_direccion.setPreferredSize(new java.awt.Dimension(300, 30));
        add(txtFld_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 180, 270, -1));

        lbl_antecedentesFamiliares.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_antecedentesFamiliares.setText("Antecedentes Familiares");
        add(lbl_antecedentesFamiliares, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 225, -1, -1));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox1.setText("Sarampión");
        add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 250, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox2.setText("Varicela");
        add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 272, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox3.setText("Tifoidea");
        add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 294, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox4.setText("Hepatitis");
        add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 316, -1, -1));

        jCheckBox5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox5.setText("Gonorrea");
        add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 338, -1, -1));

        jCheckBox6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox6.setText("Sífilis");
        add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 360, -1, -1));

        jCheckBox7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox7.setText("Tuberculosis");
        add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 382, -1, -1));

        jCheckBox8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox8.setText("Neumonía");
        add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 404, -1, -1));

        lbl_otros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_otros.setText("Otros");
        add(lbl_otros, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 440, -1, -1));

        txtFld_otros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_otros.setPreferredSize(new java.awt.Dimension(315, 30));
        add(txtFld_otros, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, -1, -1));

        lbl_apellidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_apellidos.setText("Apellidos");
        add(lbl_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 50, -1, -1));

        txtFld_nombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_nombres.setPreferredSize(new java.awt.Dimension(230, 30));
        add(txtFld_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 71, 180, -1));

        lbl_nombres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_nombres.setText("Nombres");
        add(lbl_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 50, -1, -1));

        lbl_fechaNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_fechaNac.setText("Fecha nac.");
        add(lbl_fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 105, -1, -1));

        txtFld_lugarNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_lugarNac.setPreferredSize(new java.awt.Dimension(210, 30));
        add(txtFld_lugarNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 125, -1, -1));

        txtFld_distrito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_distrito.setPreferredSize(new java.awt.Dimension(165, 30));
        add(txtFld_distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 125, -1, -1));

        txtFld_departamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_departamento.setPreferredSize(new java.awt.Dimension(165, 30));
        add(txtFld_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 125, -1, -1));

        lbl_lugarNac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_lugarNac.setText("Lugar nac.");
        add(lbl_lugarNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 105, -1, -1));

        lbl_distrito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_distrito.setText("Distrito");
        add(lbl_distrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 105, -1, -1));

        txtFld_areaTrabajo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_areaTrabajo.setPreferredSize(new java.awt.Dimension(195, 30));
        add(txtFld_areaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 180, 220, -1));

        cmbBx_estadoCivil.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBx_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Soltero", "Casado", "Viudo", "Divorciado" }));
        cmbBx_estadoCivil.setPreferredSize(new java.awt.Dimension(120, 30));
        add(cmbBx_estadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 180, -1, -1));

        lbl_nombreFamiliar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_nombreFamiliar.setText("Nombre");
        add(lbl_nombreFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 255, -1, -1));

        lbl_areaTrabajo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_areaTrabajo.setText("Área de trabajo");
        add(lbl_areaTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 160, -1, -1));

        txtFld_telefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_telefono.setPreferredSize(new java.awt.Dimension(195, 30));
        add(txtFld_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 70, 110, -1));

        jCheckBox9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox9.setText("Faringitis");
        add(jCheckBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jCheckBox10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox10.setText("Amigdalitis");
        add(jCheckBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 272, -1, -1));

        jCheckBox11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox11.setText("Cólera");
        add(jCheckBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 294, -1, -1));

        jCheckBox12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox12.setText("Parásitos");
        add(jCheckBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 316, -1, -1));

        jCheckBox13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox13.setText("Alergias");
        add(jCheckBox13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 338, -1, -1));

        jCheckBox14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox14.setText("Anemia");
        add(jCheckBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        jCheckBox15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox15.setText("Fracturas");
        add(jCheckBox15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 382, -1, -1));

        jCheckBox16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox16.setText("Operaciones");
        add(jCheckBox16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 404, -1, -1));

        jCheckBox17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox17.setText("Miopía");
        add(jCheckBox17, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 250, -1, -1));

        jCheckBox18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox18.setText("Hipertensión Art.");
        add(jCheckBox18, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 272, -1, -1));

        jCheckBox19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox19.setText("Soplo Cardiaco");
        add(jCheckBox19, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 294, -1, -1));

        jCheckBox20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox20.setText("Insuficiencia Urin.");
        add(jCheckBox20, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 316, -1, -1));

        jCheckBox21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox21.setText("Quiste Ovario");
        add(jCheckBox21, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 338, -1, -1));

        jCheckBox22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox22.setText("Desmayos");
        add(jCheckBox22, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 360, -1, -1));

        jCheckBox23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox23.setText("Hongos piel, uña");
        add(jCheckBox23, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 382, -1, -1));

        jCheckBox24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox24.setText("Transf. Sanguínea");
        add(jCheckBox24, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 404, -1, -1));

        lbl_antecedentesPatologicos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_antecedentesPatologicos.setText("Antecedentes Patológicos");
        add(lbl_antecedentesPatologicos, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 225, -1, -1));

        lbl_direccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_direccion.setText("Dirección");
        add(lbl_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 160, -1, -1));

        lbl_telefonoFamiliar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_telefonoFamiliar.setText("Teléfono");
        add(lbl_telefonoFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 375, -1, -1));

        cmbBx_parentesco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbBx_parentesco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Padre", "Madre", "Hermano" }));
        cmbBx_parentesco.setPreferredSize(new java.awt.Dimension(120, 30));
        add(cmbBx_parentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 275, -1, -1));

        lbl_parentesco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_parentesco.setText("Parentesco");
        add(lbl_parentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 255, -1, -1));

        lbl_direccionFamiliar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_direccionFamiliar.setText("Dirección");
        add(lbl_direccionFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 315, -1, -1));

        lbl_antecedentes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_antecedentes.setText("Antecedentes");
        add(lbl_antecedentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 375, -1, -1));

        txtFld_nombreFamiliar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_nombreFamiliar.setPreferredSize(new java.awt.Dimension(200, 30));
        add(txtFld_nombreFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 275, -1, -1));

        txtFld_direccionFamiliar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_direccionFamiliar.setPreferredSize(new java.awt.Dimension(335, 30));
        add(txtFld_direccionFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 335, -1, -1));

        txtFld_telefonoFamiliar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_telefonoFamiliar.setPreferredSize(new java.awt.Dimension(130, 30));
        add(txtFld_telefonoFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 395, -1, -1));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(190, 75));

        txtAr_antecedentes.setColumns(20);
        txtAr_antecedentes.setRows(5);
        jScrollPane2.setViewportView(txtAr_antecedentes);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 395, -1, -1));

        bttn_guardarFamiliar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttn_guardarFamiliar.setText("Guardar");
        bttn_guardarFamiliar.setPreferredSize(new java.awt.Dimension(130, 30));
        add(bttn_guardarFamiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        lbl_docente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_docente.setText("Docente");
        add(lbl_docente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        lbl_telefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_telefono.setText("Teléfono");
        add(lbl_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 50, -1, -1));

        rdBttn_m.setText("M");
        add(rdBttn_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 75, -1, -1));

        rdBttn_f.setText("F");
        add(rdBttn_f, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 75, -1, -1));

        rdBttn_no.setText("No");
        add(rdBttn_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 185, -1, -1));

        rdBttn_si.setText("Sí");
        add(rdBttn_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 185, -1, -1));

        txtFld_dni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFld_dni.setPreferredSize(new java.awt.Dimension(195, 30));
        add(txtFld_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 70, 110, -1));

        lbl_dni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_dni.setText("DNI");
        add(lbl_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttn_guardarFamiliar;
    private javax.swing.JComboBox<String> cmbBx_estadoCivil;
    private javax.swing.JComboBox<String> cmbBx_parentesco;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_antecedentes;
    private javax.swing.JLabel lbl_antecedentesFamiliares;
    private javax.swing.JLabel lbl_antecedentesPatologicos;
    private javax.swing.JLabel lbl_apellidos;
    private javax.swing.JLabel lbl_areaTrabajo;
    private javax.swing.JLabel lbl_condicionPaciente;
    private javax.swing.JLabel lbl_departamento;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_direccionFamiliar;
    private javax.swing.JLabel lbl_distrito;
    private javax.swing.JLabel lbl_dni;
    private javax.swing.JLabel lbl_docente;
    private javax.swing.JLabel lbl_estadoCivil;
    private javax.swing.JLabel lbl_fechaNac;
    private javax.swing.JLabel lbl_lugarNac;
    private javax.swing.JLabel lbl_nombreFamiliar;
    private javax.swing.JLabel lbl_nombres;
    private javax.swing.JLabel lbl_nroHistoriaClinica;
    private javax.swing.JLabel lbl_otros;
    private javax.swing.JLabel lbl_parentesco;
    private javax.swing.JLabel lbl_sexo;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JLabel lbl_telefonoFamiliar;
    private javax.swing.JRadioButton rdBttn_f;
    private javax.swing.JRadioButton rdBttn_m;
    private javax.swing.JRadioButton rdBttn_no;
    private javax.swing.JRadioButton rdBttn_si;
    private javax.swing.JTextArea txtAr_antecedentes;
    private javax.swing.JTextField txtFld_apellidos;
    private javax.swing.JTextField txtFld_areaTrabajo;
    private javax.swing.JTextField txtFld_departamento;
    private javax.swing.JTextField txtFld_direccion;
    private javax.swing.JTextField txtFld_direccionFamiliar;
    private javax.swing.JTextField txtFld_distrito;
    private javax.swing.JTextField txtFld_dni;
    private javax.swing.JTextField txtFld_fechaNac;
    private javax.swing.JTextField txtFld_lugarNac;
    private javax.swing.JTextField txtFld_nombreFamiliar;
    private javax.swing.JTextField txtFld_nombres;
    private javax.swing.JTextField txtFld_otros;
    private javax.swing.JTextField txtFld_telefono;
    private javax.swing.JTextField txtFld_telefonoFamiliar;
    // End of variables declaration//GEN-END:variables
}
