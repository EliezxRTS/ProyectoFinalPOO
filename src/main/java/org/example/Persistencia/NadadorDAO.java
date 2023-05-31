package org.example.Persistencia;

import org.example.Modelo.Nadador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NadadorDAO implements NadadorDAOInterface{
    public NadadorDAO() {
    }

    @Override
    public boolean introduce(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Nadadores(Nombre,Edad,Nacionalidad,Especialidad,FotoURL) VALUES(?,?,?,?,?);";
        int rowCount = 0;
        PreparedStatement preparedStatement = DBConnection.getInstance("Nadadores.db").getConnection().prepareStatement(sqlInsert);
        preparedStatement.setString(1,((Nadador)obj).getNombre());
        preparedStatement.setInt(2,((Nadador)obj).getEdad());
        preparedStatement.setString(3,((Nadador)obj).getNacionalidad());
        preparedStatement.setString(4,((Nadador)obj).getEspecialidad());
        preparedStatement.setString(5,((Nadador)obj).getFotoURL());
        rowCount = preparedStatement.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(String id,int campo,String texto) throws SQLException {
        String sqlUpdate;
        int rowCount = 0;
        switch (campo){
            case 1:
                sqlUpdate = "UPDATE Nadadores SET Nombre = ? WHERE Id = ? ;";
                PreparedStatement preparedStatement = DBConnection.getInstance("Nadadores.db").getConnection().prepareStatement(sqlUpdate);
                preparedStatement.setString(1,(texto));
                preparedStatement.setInt(2, Integer.parseInt(id));
                rowCount = preparedStatement.executeUpdate();
                break;
            case 2:
                sqlUpdate = "UPDATE Nadadores SET Edad = ? WHERE Id = ? ;";
                preparedStatement = DBConnection.getInstance("Nadadores.db").getConnection().prepareStatement(sqlUpdate);
                preparedStatement.setInt(1,(Integer.parseInt(texto)));
                preparedStatement.setInt(2, Integer.parseInt(id));
                rowCount = preparedStatement.executeUpdate();
                break;
            case 3:
                sqlUpdate = "UPDATE Nadadores SET Nacionalidad = ? WHERE Id = ? ;";
                preparedStatement = DBConnection.getInstance("Nadadores.db").getConnection().prepareStatement(sqlUpdate);
                preparedStatement.setString(1,(texto));
                preparedStatement.setInt(2, Integer.parseInt(id));
                rowCount = preparedStatement.executeUpdate();
                break;
            case 4:
                sqlUpdate = "UPDATE Nadadores SET Especialidad = ? WHERE Id = ? ;";
                preparedStatement = DBConnection.getInstance("Nadadores.db").getConnection().prepareStatement(sqlUpdate);
                preparedStatement.setString(1,(texto));
                preparedStatement.setInt(2, Integer.parseInt(id));
                rowCount = preparedStatement.executeUpdate();
                break;
            case 5:
                sqlUpdate = "UPDATE Nadadores SET FotoURL = ? WHERE Id = ? ;";
                preparedStatement = DBConnection.getInstance("Nadadores.db").getConnection().prepareStatement(sqlUpdate);
                preparedStatement.setString(1,(texto));
                preparedStatement.setInt(2, Integer.parseInt(id));
                rowCount = preparedStatement.executeUpdate();
                break;
        }
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM Nadadores WHERE Id = ? ;";
        int rowCount = 0;
        PreparedStatement preparedStatement = DBConnection.getInstance("Nadadores.db").getConnection().prepareStatement(sqlDelete);
        preparedStatement.setInt(1,Integer.parseInt(id));
        rowCount = preparedStatement.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList getEverything() throws SQLException {
        String sqlid = "SELECT * FROM Nadadores";
        ArrayList<Nadador> resultado = new ArrayList<>();

        Statement statement = DBConnection.getInstance("Nadadores.db").getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlid);
        while (resultSet.next()){
            resultado.add(new Nadador(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6)));
        }
        return resultado;
    }
}