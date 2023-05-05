package org.example;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
            var dataBase=new Database();
            dataBase.createTables();

            dataBase.getConnection().commit();


            dataBase.createTableAlbumsGenres();

            ToolCsvFile toolCsvFile=new ToolCsvFile();
            toolCsvFile.importFromCsvFile();

            dataBase.getConnection().commit();
            dataBase.closeConnection();
    }
}