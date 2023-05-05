package org.example;

import java.sql.*;

public class ArtistDAO implements ObjectDAO{

    @Override
    public void create(Object object) throws SQLException {
        Artist artist= (Artist) object;

        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        }
    }

    @Override
    public Integer findByName(Object object) throws SQLException {
        Artist artist= (Artist) object;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + artist.getName() + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public Object findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        Artist artist;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id='" + id + "'")) {

            if( rs.next())
                artist=new Artist(rs.getString(1));
            else
                artist=null;
        }
        return artist;
    }
}
