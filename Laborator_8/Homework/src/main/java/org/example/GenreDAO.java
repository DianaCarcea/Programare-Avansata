package org.example;

import java.sql.*;

public class GenreDAO implements ObjectDAO{
    @Override
    public void create(Object object) throws SQLException {
        Genre genre= (Genre) object;

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Integer findByName(Object object) throws SQLException {
        Genre genre= (Genre) object;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + genre.getName() + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Object findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        Genre genre;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {

            if( rs.next())
            {
                genre=new Genre(rs.getString(1));
            }
            else
                genre=null;
        }
        return genre;
    }
}
