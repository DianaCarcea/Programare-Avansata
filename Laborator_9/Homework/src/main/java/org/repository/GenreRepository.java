package org.repository;

import org.entity.Genre;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenreRepository extends AbstractRepository<Genre, Long> {

    public GenreRepository(EntityManager em) {
        super(em);
    }

    public List<Genre> findByName(String name) {
        TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName", Genre.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

}

