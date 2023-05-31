package org.example.Modelo;

import org.example.Persistencia.NadadorDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaNadador implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Nadador> datos;
    private NadadorDAO nadadorDAO;

    public ModeloTablaNadador() {
        nadadorDAO = new NadadorDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaNadador(ArrayList<Nadador> datos) {
        this.datos = datos;
        datos = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Edad";
            case 3:
                return "Nacionalidad";
            case 4:
                return "Especialidad";
            case 5:
                return "FotoURL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0 , 2:
                return Integer.class;
            case 1 , 3 , 4 , 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nadador tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getEdad();
            case 3:
                return tmp.getNacionalidad();
            case 4:
                return tmp.getEspecialidad();
            case 5:
                return tmp.getFotoURL();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setEdad((Integer) aValue);
                break;
            case 3:
                datos.get(rowIndex).setNacionalidad((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setEspecialidad((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setFotoURL((String) aValue);
                break;
        }
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargarDatos(){
        try{
            datos = nadadorDAO.getEverything();
        } catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
    }
    public boolean actualizarNadador(String id,int campo,String texto){
        boolean resultado = false;
        try {
            if (nadadorDAO.update(id,campo,texto)){
                resultado = true;
            }
        } catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultado;
    }
    public boolean agregarNadador(Nadador nadador){
        boolean resultado = false;
        try{
            if (nadadorDAO.introduce(nadador)){
                datos.add(nadador);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultado;
    }
    public boolean borrarNadador(String id){
        boolean resultado = false;
        try {
            if (nadadorDAO.delete(id)){
                datos.remove(id);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }
        return resultado;
    }
    public Nadador getNadadorAtIndex(int idx){
        return datos.get(idx);
    }
}