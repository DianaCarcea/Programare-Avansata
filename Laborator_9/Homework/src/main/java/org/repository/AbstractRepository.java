package org.repository;

import org.entity.AbstractEntity;
import org.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

//Obiectele serializabile pot fi salvate în fișiere, transmise prin rețea sau stocate într-o bază de date,
//permițând persistența datelor între sesiuni de execuție ale unei aplicații.
public class AbstractRepository <T extends AbstractEntity, ID extends Serializable> {

    protected EntityManager em;
    private Class<T> entityType;

    public AbstractRepository(EntityManager em) {
        this.em = em;
        this.entityType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public AbstractRepository() {
    }

    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

    }

    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public T findById(ID id) {
        T entity = em.find(entityType, id);
        if (entity == null) {
            throw new EntityNotFoundException("Entity with id " + id + " not found.");
        }
        return entity;
    }

    public List<T> findAll() {
        return em.createQuery("SELECT e FROM " + entityType.getSimpleName() + " e", entityType)
                .getResultList();
    }

    public void deleteAll() {
        List<T> entities=findAll();
        for(T entity:entities )
        {
            delete(entity);
        }
    }
}
