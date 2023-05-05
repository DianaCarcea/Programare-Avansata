package org.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class ToolCsvFile {
    public void importFromCsvFile()
    {
        String csvFilePath = "C:\\intelij test\\Laborator\\Lab8\\Homework\\albums.csv";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));


            ArtistDAO artists=new ArtistDAO();
            GenreDAO genres=new GenreDAO();
            AlbumDAO albums=new AlbumDAO();

            String myLine=null;
            myLine=reader.readLine();
            while ((myLine=reader.readLine())!=null)
            {
                String[] fields = myLine.split(",");

                String year=fields[1].trim();

                String title=fields[2].trim();

                String artistName=fields[3].replace("'","`" ) .trim();

                String genreName=fields[4].trim();
                Genre genre=new Genre(genreName);

                Artist artist=new Artist(artistName);

                if(artists.findByName(artist)==null)
                    artists.create(artist);



                if(genres.findByName(genre)==null)
                    genres.create(genre);


                Album album=new Album(year,title,artistName,genreName);
                albums.create(album);
            }

        }catch (Exception e) {
            System.err.println(e);
        }
    }
}
