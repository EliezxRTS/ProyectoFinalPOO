package org.example.Controlador;

import org.example.Modelo.ModeloTablaNadador;
import org.example.Modelo.Nadador;
import org.example.Vista.VentanaProyecto;

import javax.swing.*;
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
            nadador.setId(0);
            nadador.setNombre(this.ventanaProyecto.getTxtNombre().getText());
            nadador.setEdad(Integer.parseInt(this.ventanaProyecto.getTxtEdad().getText()));
            nadador.setNacionalidad(this.ventanaProyecto.getTxtNacionalidad().getText());
            nadador.setEspecialidad(this.ventanaProyecto.getTxtEspecialidad().getText());
            nadador.setFotoURL(this.ventanaProyecto.getTxtFotoURL().getText());
            if (modeloTablaNadador.agregarNadador(nadador)){
                JOptionPane.showMessageDialog(ventanaProyecto,"Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.ventanaProyecto.getTblNadador().updateUI();
            } else {
                JOptionPane.showMessageDialog(ventanaProyecto,"No se pudo agregar a la base de datos","Aviso",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.ventanaProyecto.getBtnDelete()){
            String id = this.ventanaProyecto.getTxtDelete().getText();
            int resultado = JOptionPane.showConfirmDialog(ventanaProyecto,"Borrar registro?", "Confirmacion",JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_NO_OPTION){
                modeloTablaNadador.borrarNadador(id);
                this.ventanaProyecto.getTblNadador().updateUI();
            }
        }
        if (e.getSource() == this.ventanaProyecto.getBtnUpdate()){
            String id = this.ventanaProyecto.getTxtUpdate01().getText();
            int campo = this.ventanaProyecto.getCmbUpdate().getSelectedIndex();
            String texto = this.ventanaProyecto.getTxtUpdate02().getText();
            modeloTablaNadador.actualizarNadador(id,campo,texto);
            this.ventanaProyecto.getTblNadador().updateUI();
        }
        if (e.getSource() == this.ventanaProyecto.getTblNadador()){
            System.out.println("evento en tabla");
            int index = this.ventanaProyecto.getTblNadador().getSelectedRow();
            Nadador tmp = modeloTablaNadador.getNadadorAtIndex(index);
            try{
                this.ventanaProyecto.getLblImagenNadador().setIcon(tmp.getImagen());
                this.ventanaProyecto.getLblImagenNadador().setText("");
            } catch (MalformedURLException malformedURLException){
                malformedURLException.getStackTrace();
            }
        }
        this.ventanaProyecto.getTblNadador().updateUI();
        this.ventanaProyecto.limpiar();
        this.ventanaProyecto.pack();
    }
}