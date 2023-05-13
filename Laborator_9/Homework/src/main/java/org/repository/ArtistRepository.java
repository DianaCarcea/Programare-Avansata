package org.repository;

import org.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistRepository extends AbstractRepository<Artist, Long> {

    public ArtistRepository(EntityManager em) {
        super(em);
    }

    public List<Artist> findByName(String name) {

        TypedQuery<Artist> query = em.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
