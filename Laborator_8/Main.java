package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
            var dataBase=new Database();
            dataBase.createTables();

            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");


            dataBase.getConnection().commit();

            System.out.println(artists.findById(2));
            System.out.println(artists.findByName("Pink Floyd"));

            dataBase.closeConnection();
    }
}