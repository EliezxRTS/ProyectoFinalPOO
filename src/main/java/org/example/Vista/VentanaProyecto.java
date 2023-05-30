package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaProyecto extends JFrame {
    private GridLayout gridLayout;
    private JPanel panel01; //Formulario
    private JLabel lblPrincipal01;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblEdad;
    private JTextField txtEdad;
    private JLabel lblNacionalidad;
    private JTextField txtNacionalidad;
    private JLabel lblEspecialidad;
    private JTextField txtEspecialidad;
    private JLabel lblFotoURL;
    private JTextField txtFotoURL;
    private JButton btnAgregar;
    private JPanel panel02; //Tabla de DB
    private JLabel lblPrincipal02;
    private JButton btnCargarDatos;
    private JTable tblNadador;
    private JScrollPane scrollPane;
    private JPanel panel03; //Imagen del registro
    private JLabel lblPrincipal03;
    private JPanel panel04; //Update & Delete
    private JLabel lblPrincipal04;
    private JLabel lblUpdate;
    private JTextField txtUpdate;
    private JButton btnUpdate;
    private JLabel lblDelete;
    private JTextField txtDelete;
    private JComboBox<String> cmbUpdate;
    private JButton btnDelete;

    public VentanaProyecto(String title) throws HeadlessException {
        super(title);
        this.setSize(1200,800);
        gridLayout = new GridLayout(2,2);
        this.getContentPane().setLayout(gridLayout);

        //Panel01
        panel01 = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        panel01.setBackground(new Color(210, 141, 210, 255));

            lblPrincipal01 = new JLabel("Ingresa aqui los datos para el nuevo registro");
            constraints.fill = GridBagConstraints.HORIZONTAL; //Establece que se ocupe el espacio restante horizontal si se reescala
            constraints.weightx = 0.5; //Establece un factor de menor relacion de tamaño para la columna
            constraints.gridwidth = 1; //Establece la cantidad de columnas que ocupa el componente
            constraints.gridx = 1; //Posicion en el lugar de las columnas
            constraints.gridy = 0; //Posicion en el lugar de las filas
            constraints.insets = new Insets(10,10,10,10); //Establece un margen alrededor del componente
            panel01.add(lblPrincipal01,constraints);

            //Campos de Nombre
            lblNombre = new JLabel("Nombre:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(lblNombre,constraints);
            txtNombre = new JTextField(25);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.8;
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(txtNombre,constraints);

            //Campos de Edad
            lblEdad = new JLabel("Edad:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(lblEdad,constraints);
            txtEdad = new JTextField(25);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.8;
            constraints.gridx = 1;
            constraints.gridy = 2;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(txtEdad,constraints);

            //Campos de Nacionalidad
            lblNacionalidad = new JLabel("Nacionalidad:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(lblNacionalidad,constraints);
            txtNacionalidad = new JTextField(25);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.8;
            constraints.gridx = 1;
            constraints.gridy = 3;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(txtNacionalidad,constraints);

            //Campos de Especialidad
            lblEspecialidad = new JLabel("Especialidad");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(lblEspecialidad,constraints);
            txtEspecialidad = new JTextField(25);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.8;
            constraints.gridx = 1;
            constraints.gridy = 4;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(txtEspecialidad,constraints);

            //Campos de Imagen
            lblFotoURL = new JLabel("URL Foto:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 5;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(lblFotoURL,constraints);
            txtFotoURL = new JTextField(25);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.8;
            constraints.gridx = 1;
            constraints.gridy = 5;
            constraints.insets = new Insets(10,10,10,10);
            panel01.add(txtFotoURL,constraints);

            //Boton Agregar
            btnAgregar = new JButton("Agregar");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.5;
            constraints.gridwidth = 2;
            constraints.gridx = 0;
            constraints.gridy = 6;
            constraints.insets = new Insets(10,30,10,30);
            panel01.add(btnAgregar,constraints);

        //Panel02
        panel02 = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        panel02.setBackground(new Color(206, 154, 118));

            lblPrincipal02 = new JLabel("Tabla con los registros de la DB actual");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.5;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.insets = new Insets(10,30,10,30);
            panel02.add(lblPrincipal02,constraints);

            //Tabla
            tblNadador = new JTable();
            scrollPane = new JScrollPane(tblNadador);
            constraints.fill = GridBagConstraints.BOTH;
            constraints.weightx = 0.5;
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.insets = new Insets(10,30,10,30);
            panel02.add(scrollPane,constraints);

            //Boton LeerDB
            btnCargarDatos = new JButton("Cargar datos desde el registro");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.5;
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.insets = new Insets(10,30,10,30);
            panel02.add(btnCargarDatos,constraints);


        //Panel03
        panel03 = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        panel03.setBackground(new Color(122, 185, 175));


        //Panel04
        panel04 = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();
        panel04.setBackground(new Color(161, 142, 199));

            lblPrincipal04 = new JLabel("Borrar o Actualizar");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 1;
            constraints.gridwidth = 1;
            constraints.gridx = 2;
            constraints.gridy = 0;
            constraints.insets = new Insets(10,30,10,30);
            panel04.add(lblPrincipal04,constraints);

            //Campos de Borrar
            lblDelete = new JLabel("Borrar registro en id:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.1;
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(lblDelete,constraints);
            txtDelete = new JTextField(5);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.35;
            constraints.gridx = 2;
            constraints.gridy = 1;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(txtDelete,constraints);
            btnDelete = new JButton("BORRAR");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.35;
            constraints.gridx = 3;
            constraints.gridy = 1;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(btnDelete,constraints);

            //Campos Actualizar
            lblUpdate = new JLabel("Actualizar registro en id:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 2;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(lblUpdate,constraints);
            txtUpdate = new JTextField(5);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 1;
            constraints.gridy = 2;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(txtUpdate,constraints);
            lblUpdate = new JLabel("En el campo:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 2;
            constraints.gridy = 2;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(lblUpdate,constraints);
            String[] elementos = {"Nombre","Edad","Nacionalidad","Especialidad","FotoURL"};
            cmbUpdate = new JComboBox<>(elementos);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 3;
            constraints.gridy = 2;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(cmbUpdate,constraints);
            lblUpdate = new JLabel("Sustituir por:");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 0;
            constraints.gridy = 3;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(lblUpdate,constraints);
            txtUpdate = new JTextField(15);
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 1;
            constraints.gridy = 3;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(txtUpdate,constraints);
            btnUpdate = new JButton("Actualizar");
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 0.2;
            constraints.gridx = 3;
            constraints.gridy = 3;
            constraints.insets = new Insets(10,10,10,10);
            panel04.add(btnUpdate,constraints);

        this.getContentPane().add(panel01,0);
        this.getContentPane().add(panel02,1);
        this.getContentPane().add(panel03,2);
        this.getContentPane().add(panel04,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public GridLayout getGridLayout() {
        return gridLayout;
    }

    public void setGridLayout(GridLayout gridLayout) {
        this.gridLayout = gridLayout;
    }

    public JPanel getPanel01() {
        return panel01;
    }

    public void setPanel01(JPanel panel01) {
        this.panel01 = panel01;
    }

    public JLabel getLblPrincipal01() {
        return lblPrincipal01;
    }

    public void setLblPrincipal01(JLabel lblPrincipal01) {
        this.lblPrincipal01 = lblPrincipal01;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JLabel getLblEdad() {
        return lblEdad;
    }

    public void setLblEdad(JLabel lblEdad) {
        this.lblEdad = lblEdad;
    }

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public void setTxtEdad(JTextField txtEdad) {
        this.txtEdad = txtEdad;
    }

    public JLabel getLblNacionalidad() {
        return lblNacionalidad;
    }

    public void setLblNacionalidad(JLabel lblNacionalidad) {
        this.lblNacionalidad = lblNacionalidad;
    }

    public JTextField getTxtNacionalidad() {
        return txtNacionalidad;
    }

    public void setTxtNacionalidad(JTextField txtNacionalidad) {
        this.txtNacionalidad = txtNacionalidad;
    }

    public JLabel getLblEspecialidad() {
        return lblEspecialidad;
    }

    public void setLblEspecialidad(JLabel lblEspecialidad) {
        this.lblEspecialidad = lblEspecialidad;
    }

    public JTextField getTxtEspecialidad() {
        return txtEspecialidad;
    }

    public void setTxtEspecialidad(JTextField txtEspecialidad) {
        this.txtEspecialidad = txtEspecialidad;
    }

    public JLabel getLblFotoURL() {
        return lblFotoURL;
    }

    public void setLblFotoURL(JLabel lblFotoURL) {
        this.lblFotoURL = lblFotoURL;
    }

    public JTextField getTxtFotoURL() {
        return txtFotoURL;
    }

    public void setTxtFotoURL(JTextField txtFotoURL) {
        this.txtFotoURL = txtFotoURL;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JPanel getPanel02() {
        return panel02;
    }

    public void setPanel02(JPanel panel02) {
        this.panel02 = panel02;
    }

    public JLabel getLblPrincipal02() {
        return lblPrincipal02;
    }

    public void setLblPrincipal02(JLabel lblPrincipal02) {
        this.lblPrincipal02 = lblPrincipal02;
    }

    public JButton getBtnCargarDatos() {
        return btnCargarDatos;
    }

    public void setBtnCargarDatos(JButton btnCargarDatos) {
        this.btnCargarDatos = btnCargarDatos;
    }

    public JTable getTblNadador() {
        return tblNadador;
    }

    public void setTblNadador(JTable tblNadador) {
        this.tblNadador = tblNadador;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JPanel getPanel03() {
        return panel03;
    }

    public void setPanel03(JPanel panel03) {
        this.panel03 = panel03;
    }

    public JLabel getLblPrincipal03() {
        return lblPrincipal03;
    }

    public void setLblPrincipal03(JLabel lblPrincipal03) {
        this.lblPrincipal03 = lblPrincipal03;
    }

    public JPanel getPanel04() {
        return panel04;
    }

    public void setPanel04(JPanel panel04) {
        this.panel04 = panel04;
    }

    public JLabel getLblPrincipal04() {
        return lblPrincipal04;
    }

    public void setLblPrincipal04(JLabel lblPrincipal04) {
        this.lblPrincipal04 = lblPrincipal04;
    }

    public JLabel getLblUpdate() {
        return lblUpdate;
    }

    public void setLblUpdate(JLabel lblUpdate) {
        this.lblUpdate = lblUpdate;
    }

    public JTextField getTxtUpdate() {
        return txtUpdate;
    }

    public void setTxtUpdate(JTextField txtUpdate) {
        this.txtUpdate = txtUpdate;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JLabel getLblDelete() {
        return lblDelete;
    }

    public void setLblDelete(JLabel lblDelete) {
        this.lblDelete = lblDelete;
    }

    public JTextField getTxtDelete() {
        return txtDelete;
    }

    public void setTxtDelete(JTextField txtDelete) {
        this.txtDelete = txtDelete;
    }

    public JComboBox<String> getCmbUpdate() {
        return cmbUpdate;
    }

    public void setCmbUpdate(JComboBox<String> cmbUpdate) {
        this.cmbUpdate = cmbUpdate;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public void limpiar(){
        txtNombre.setText("");
        txtEdad.setText("");
        txtNacionalidad.setText("");
        txtEspecialidad.setText("");
        txtFotoURL.setText("");
    }
}