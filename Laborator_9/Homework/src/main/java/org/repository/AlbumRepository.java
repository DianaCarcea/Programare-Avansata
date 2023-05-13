package org.repository;

import org.entity.Album;
import org.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository extends AbstractRepository<Album, Long>{
    public AlbumRepository(EntityManager em) {
        super(em);
    }

    public List<Album> findByTitle(String name) {

        TypedQuery<Album> query = em.createNamedQuery("Album.findByTitle", Album.class);
        query.setParameter("title", name);
        return query.getResultList();
    }
}
