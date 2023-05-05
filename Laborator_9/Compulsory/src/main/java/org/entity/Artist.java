package org.entity;

import javax.persistence.*;

@Entity
@Table(name="Artists")
@NamedQueries({
        @NamedQuery(name="Artist.findByName",
        query = "SELECT artist FROM Artist artist WHERE artist.name LIKE :name")
})
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}