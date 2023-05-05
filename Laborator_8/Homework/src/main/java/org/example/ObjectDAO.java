package org.example;

import java.sql.SQLException;

public interface ObjectDAO {
    public void create(Object object) throws SQLException;
    public Integer findByName(Object object)throws SQLException;
    public Object findById(int id) throws SQLException;
}
