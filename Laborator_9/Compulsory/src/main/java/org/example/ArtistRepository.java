package org.example;
import org.entity.Artist;
import javax.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    private EntityManager em;

    public ArtistRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Artist artist) {//salvez in baza de date Artistul
        em.getTransaction().begin();
        em.persist(artist);//ORM-ul memoreaza
        em.getTransaction().commit();
    }

    public Artist findById(Long id) {
        return em.find(Artist.class, id);
    }

    public List<Artist> findByName(String namePattern) {
        return em.createNamedQuery("Artist.findByName").setParameter("name", namePattern).getResultList();
    }
}
