package org.example.Persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

public interface NadadorDAOInterface {
    public abstract boolean introduce(Object obj) throws SQLException;
    public abstract boolean update(String id,int campo,String texto) throws SQLException;
    public abstract boolean delete(String id) throws SQLException;
    public abstract ArrayList getEverything() throws SQLException;
}