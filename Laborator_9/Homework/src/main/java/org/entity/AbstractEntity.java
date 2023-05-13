package org.entity;

import javax.persistence.*;


@MappedSuperclass//nu poate exista independent, asigura niste metode comune pt clase derivate care sunt persistente
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
