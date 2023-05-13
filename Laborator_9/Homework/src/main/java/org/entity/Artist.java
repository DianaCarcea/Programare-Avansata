package org.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Artists")
@NamedQueries({
        @NamedQuery(name="Artist.findByName",
                query = "SELECT artist FROM Artist artist WHERE artist.name LIKE :name")

})
public class Artist extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

    private String name;
    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

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