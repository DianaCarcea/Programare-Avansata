package org.entity;

import javax.persistence.*;

@Entity
@Table(name="Genres")
@NamedQueries({
        @NamedQuery(name="Genre.findByName",
                query = "SELECT genre FROM Genre genre WHERE genre.name LIKE :name")

})
public class Genre extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    public Genre() {
    }
    public Genre(String name) {
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