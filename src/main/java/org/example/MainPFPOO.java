package org.example;

import org.example.Controlador.ControladorNadador;
import org.example.Vista.VentanaProyecto;

public class MainPFPOO {
    public static void main(String[] args) {
        VentanaProyecto ventanaProyecto = new VentanaProyecto("Proyecto Natacion");
        ControladorNadador controladorNadador = new ControladorNadador(ventanaProyecto);
    }
}