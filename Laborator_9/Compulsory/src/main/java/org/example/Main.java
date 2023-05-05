package org.example;

import org.entity.Artist;

import javax.persistence.EntityManagerFactory;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = EntityManager.getInstance();
        javax.persistence.EntityManager em = emf.createEntityManager();
        ArtistRepository artistRepository = new ArtistRepository(em);

        Artist artistOne = new Artist();
        artistOne.setName("Michael James");
        artistRepository.create(artistOne);

        Artist artistTwo = new Artist();
        artistTwo.setName("Elvis Presley");
        artistRepository.create(artistTwo);

        Artist foundArtistOne = artistRepository.findById(artistOne.getId());
        System.out.println("First artist: " + foundArtistOne.getName());

        List<Artist> similarNameArtist = artistRepository.findByName("Michael%");

        for (Artist artist : similarNameArtist) {
            System.out.println(artist.getName());
        }

        em.close();
        emf.close();
    }
}