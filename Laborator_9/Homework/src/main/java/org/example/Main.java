package org.example;
import com.github.javafaker.Faker;
import java.util.Random;

import org.entity.Album;
import org.entity.Artist;
import org.entity.Genre;
import org.repository.AlbumRepository;
import org.repository.ArtistRepository;
import org.repository.GenreRepository;

import javax.persistence.EntityManager;
//import javax.persistence.ArtistRepository;

import javax.persistence.EntityManagerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManagerFactorySingleton.getInstance();
        EntityManager em = emf.createEntityManager();

        ArtistRepository artistRepository = new ArtistRepository(em);
        AlbumRepository albumRepository = new AlbumRepository(em);
        GenreRepository genreRepository=new GenreRepository(em);

        Faker faker=new Faker();
        int nrArtists=20;
        int nrGenres=5;
        int nrAlbums=100;

        albumRepository.deleteAll();
        artistRepository.deleteAll();
        genreRepository.deleteAll();


        for(int i=0;i<nrArtists;i++) {
            String name = faker.artist().name();
            Artist artist = new Artist(name);
            artistRepository.create(artist);
        }

        for(int i=0;i<nrGenres;i++) {
            String name = faker.music().genre();
            Genre genre = new Genre(name);
            genreRepository.create(genre);
        }



        List<Artist> listArtists;
        listArtists=artistRepository.findByName("Manet");
        for(Artist artist:listArtists){
            System.out.println(artist.getName());
        }

        List<Album> listAlbums;
        listAlbums=albumRepository.findByTitle("O Pioneers!");
        for(Album album:listAlbums){
            System.out.println(album.getTitle());
        }

        List<Artist> listOfArtists=artistRepository.findAll();
        List<Genre> listOfGenres=genreRepository.findAll();

        for(int i=0;i<nrAlbums;i++){

            Random random = new Random();
            int indexArtist=random.nextInt(listOfArtists.size());
            Artist artist=listOfArtists.get(indexArtist);

            int indexGenre=random.nextInt(listOfGenres.size());
            Set<Genre> genres=new HashSet<>();
            genres.add(listOfGenres.get(indexGenre));


            int year = faker.number().numberBetween(1900, 2000);
            String releaseYear=String.valueOf(year);
            String title=faker.book().title();

            Album album=new Album(releaseYear,title,artist,genres);
            albumRepository.create(album);

        }


        // Cleanup
        em.close();
        emf.close();
    }
}