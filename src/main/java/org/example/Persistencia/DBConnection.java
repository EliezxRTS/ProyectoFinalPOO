package org.example.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private String baseDatos;
    public static DBConnection _instance;
    private Connection connection;

    private DBConnection(String database) {
        this.baseDatos = database;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance(String baseDatos) {
        if(_instance == null){
            _instance = new DBConnection(baseDatos);
        }
        return _instance;
    }

    public Connection getConnection() {
        return connection;
    }
}