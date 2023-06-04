package org.example.Controlador;

import org.example.Modelo.ModeloTablaNadador;
import org.example.Modelo.Nadador;
import org.example.Vista.VentanaProyecto;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorNadador extends MouseAdapter {
    private VentanaProyecto ventanaProyecto;
    private ModeloTablaNadador modeloTablaNadador;

    public ControladorNadador(VentanaProyecto ventanaProyecto) {
        this.ventanaProyecto = ventanaProyecto;
        modeloTablaNadador = new ModeloTablaNadador();
        this.ventanaProyecto.getTblNadador().setModel(modeloTablaNadador);
        this.ventanaProyecto.getBtnCargarDatos().addMouseListener(this);
        this.ventanaProyecto.getBtnAgregar().addMouseListener(this);
        this.ventanaProyecto.getBtnDelete().addMouseListener(this);
        this.ventanaProyecto.getBtnUpdate().addMouseListener(this);
        this.ventanaProyecto.getTblNadador().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.ventanaProyecto.getBtnCargarDatos()){
            modeloTablaNadador.cargarDatos();
            this.ventanaProyecto.getTblNadador().setModel(modeloTablaNadador);
            this.ventanaProyecto.getTblNadador().updateUI();
        }
        if (e.getSource() == this.ventanaProyecto.getBtnAgregar()){
            Nadador nadador = new Nadador();
            if (this.ventanaProyecto.getTxtNombre().getText().isEmpty() ||
                    this.ventanaProyecto.getTxtEdad().getText().isEmpty() ||
                    this.ventanaProyecto.getTxtNacionalidad().getText().isEmpty() ||
                    this.ventanaProyecto.getTxtEspecialidad().getText().isEmpty() ||
                    this.ventanaProyecto.getTxtFotoURL().getText().isEmpty()){
                JOptionPane.showMessageDialog(ventanaProyecto,"Hay campos sin completar, verifica el formulario","Aviso",JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    nadador.setNombre(this.ventanaProyecto.getTxtNombre().getText());
                    nadador.setEdad(Integer.parseInt(this.ventanaProyecto.getTxtEdad().getText()));
                    nadador.setNacionalidad(this.ventanaProyecto.getTxtNacionalidad().getText());
                    nadador.setEspecialidad(this.ventanaProyecto.getTxtEspecialidad().getText());
                    nadador.setFotoURL(this.ventanaProyecto.getTxtFotoURL().getText());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(ventanaProyecto, "Los datos del formulario no son correctos, favor de verificar", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
                if (modeloTablaNadador.agregarNadador(nadador)) {
                    JOptionPane.showMessageDialog(ventanaProyecto, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    modeloTablaNadador.cargarDatos();
                    this.ventanaProyecto.getTblNadador().updateUI();
                } else {
                    JOptionPane.showMessageDialog(ventanaProyecto, "No se pudo agregar a la base de datos", "Aviso", JOptionPane.ERROR_MESSAGE);
                }
                this.ventanaProyecto.limpiar();
            }
        }
        if (e.getSource() == this.ventanaProyecto.getBtnDelete()){
            if (this.ventanaProyecto.getTxtDelete().getText().isEmpty()){
                JOptionPane.showMessageDialog(ventanaProyecto,"Hay campos sin completar, verifica el formulario","Aviso",JOptionPane.ERROR_MESSAGE);
            } else {
                String id = this.ventanaProyecto.getTxtDelete().getText();
                int resultado = JOptionPane.showConfirmDialog(ventanaProyecto, "Borrar registro?", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (resultado == JOptionPane.YES_NO_OPTION) {
                    modeloTablaNadador.borrarNadador(id);
                    modeloTablaNadador.cargarDatos();
                    this.ventanaProyecto.getTblNadador().updateUI();
                }
                this.ventanaProyecto.limpiar();
            }
        }
        if (e.getSource() == this.ventanaProyecto.getBtnUpdate()){
            if (this.ventanaProyecto.getTxtUpdate01().getText().isEmpty() ||
                    this.ventanaProyecto.getTxtUpdate02().getText().isEmpty() ||
                    this.ventanaProyecto.getCmbUpdate().getSelectedIndex() == 0){
                JOptionPane.showMessageDialog(ventanaProyecto,"Hay campos sin completar, verifica el formulario","Aviso",JOptionPane.ERROR_MESSAGE);
            } else {
                String id = this.ventanaProyecto.getTxtUpdate01().getText();
                int campo = this.ventanaProyecto.getCmbUpdate().getSelectedIndex();
                String texto = this.ventanaProyecto.getTxtUpdate02().getText();
                int resultado = JOptionPane.showConfirmDialog(ventanaProyecto,"Actualizar registro?","Confirmación",JOptionPane.YES_NO_OPTION);
                if (resultado == JOptionPane.YES_NO_OPTION) {
                    modeloTablaNadador.actualizarNadador(id, campo, texto);
                    modeloTablaNadador.cargarDatos();
                    this.ventanaProyecto.getTblNadador().updateUI();
                }
                this.ventanaProyecto.limpiar();
            }
        }
        if (e.getSource() == this.ventanaProyecto.getTblNadador()){
            int index = this.ventanaProyecto.getTblNadador().getSelectedRow();
            Nadador tmp = modeloTablaNadador.getNadadorAtIndex(index);
            try{
                ImageIcon imagenOriginal = tmp.getImagen();
                int anchoImagen = 400;
                int altoImagen = 300;
                Image imageCambioTamano = imagenOriginal.getImage().getScaledInstance(anchoImagen,altoImagen,Image.SCALE_SMOOTH);
                ImageIcon imageCambioIcon = new ImageIcon(imageCambioTamano);
                this.ventanaProyecto.getLblImagenNadador().setIcon(imageCambioIcon);
                this.ventanaProyecto.getLblImagenNadador().setText("");
            } catch (MalformedURLException malformedURLException){
                malformedURLException.getStackTrace();
            }
        }
        TableColumnModel tableColumnModel = this.ventanaProyecto.getTblNadador().getColumnModel();
        TableColumn columnaId = tableColumnModel.getColumn(0);
        TableColumn columnaEdad = tableColumnModel.getColumn(2);
        columnaId.setPreferredWidth(0);
        columnaEdad.setPreferredWidth(0);
        this.ventanaProyecto.getTblNadador().updateUI();
        this.ventanaProyecto.pack();
    }
}