package org.example;

import java.sql.SQLException;

public interface ObjectDAO {
    public void create(String name) throws SQLException;
    public Integer findByName(String name)throws SQLException;
    public String findById(int id) throws SQLException;
}
