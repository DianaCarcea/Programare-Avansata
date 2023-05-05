package org.example;

import java.sql.*;

public class AlbumDAO implements ObjectDAO {
    @Override
    public void create(Object object) throws SQLException {
        Album album = (Album) object;
        int idGenre;
        Connection con = Database.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select id from genres where name='" + album.getGenres() + "'");
            if (rs.next()) {
                idGenre = rs.getInt(1);
            } else
                idGenre = -1;

            rs.close();
            stmt.close();

            if(idGenre!=-1) {
                PreparedStatement pstmt = con.prepareStatement("insert into albums (release_year,title,artist,id_genre) values (?,?,?,?)");
                pstmt.setString(1, album.getReleaseYear());
                pstmt.setString(2, album.getTitle());
                pstmt.setString(3, album.getArtist());
                pstmt.setInt(4, idGenre);

                pstmt.executeUpdate();
                pstmt.close();
            }
            else
                throw new NullPointerException("The id is not found in the genres table");

        } catch (SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public Integer findByName(Object object) throws SQLException {
        Album album = (Album) object;
        Connection con = Database.getConnection();

        int result=-1;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select id from albums where title='" + album.getTitle() + "'");
            if( rs.next())
                result= rs.getInt(1);
            else
                result=-1;

            rs.close();
            stmt.close();

        }catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }

    public Object findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        Album album=null;
        String genres;
        try{
            Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select release_year,title,artist,id_genre from albums where id='" + id + "'");

             var rs1=rs.next();

            Statement stmt2 = con.createStatement();
            ResultSet rs2 = stmt2.executeQuery(
                    "select name FROM genres where id='" + rs.getInt(4) + "'");

            if (rs2.next())
                genres = rs2.getString(1);
            else
                genres = null;

            if(genres != null){

                if (rs1)
                    album = new Album(rs.getString(1),rs.getString(2),rs.getString(3),rs2.getString(1));
                else
                    album = null;
            }
            else
                throw new NullPointerException("The id is not found in the genres table");

            rs.close();
            stmt.close();
            rs2.close();
            stmt2.close();


        }catch (SQLException e)
        {
            System.err.println(e);
        }

        return album;
    }
}
