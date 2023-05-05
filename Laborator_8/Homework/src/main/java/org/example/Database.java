package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static HikariConfig config=null;
    private static HikariDataSource dataSource = null;


    private static final String URL = "jdbc:postgresql://localhost:5432/albums";
    private static final String USER = "postgres";
    private static final String PASSWORD = "MANAGER";
    private static Connection connection = null;
    public Database() {
        createConnection();
    };
    public static Connection getConnection() {
        return connection;
    }
    private static void createConnection() {
        try {

            config=new HikariConfig();
            config.setJdbcUrl("jdbc:postgresql://localhost:5432/albums");
            config.setUsername(USER);
            config.setPassword(PASSWORD);
            config.setMaximumPoolSize(5);

            dataSource =new HikariDataSource(config);


            connection= dataSource.getConnection();
            connection.setAutoCommit(false);



            if(connection==null)
                System.out.println("Connection FAILED");
            else
                System.out.println("Connection SUCCEED");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection()
    {
        try{
            connection.close();
        }catch (SQLException e){
            System.err.println(e);
        }
    }

    public void createTables(){
        Statement stm;
        try {
            stm=connection.createStatement();
            String sql="";

            sql="DROP TABLE IF EXISTS albums_genres";
            stm.executeUpdate(sql);

            sql="DROP TABLE IF EXISTS albums";
            stm.executeUpdate(sql);

            sql="DROP TABLE IF EXISTS artists";
            stm.executeUpdate(sql);

            sql="DROP TABLE IF EXISTS genres";
            stm.executeUpdate(sql);

            sql="CREATE TABLE artists(id SERIAL NOT NULL PRIMARY KEY, name VARCHAR(100) NOT NULL)";
            stm.executeUpdate(sql);

            sql="CREATE TABLE genres(id SERIAL NOT NULL PRIMARY KEY, name VARCHAR(100) NOT NULL)";
            stm.executeUpdate(sql);

            sql="CREATE TABLE albums(id SERIAL NOT NULL PRIMARY KEY, release_year VARCHAR(100) NOT NULL, title VARCHAR(100) NOT NULL, artist VARCHAR(100) NOT NULL, id_genre INTEGER NOT NULL references genres(id))";
            stm.executeUpdate(sql);

            sql="CREATE TABLE albums_genres(id_albums INTEGER NOT NULL references albums(id), id_genres INTEGER NOT NULL references genres(id), PRIMARY KEY (id_albums,id_genres))";
            stm.executeUpdate(sql);

            stm.close();


        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public void createTableAlbumsGenres()
    {
        try {
            Statement statement = connection.createStatement();
            String sql = "";

            sql="INSERT INTO albums_genres (id_albums, id_genres) SELECT a.id, g.id FROM albums a CROSS JOIN genres g WHERE g.id= a.id_genre;";
            statement.executeUpdate(sql);

            statement.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }



}
