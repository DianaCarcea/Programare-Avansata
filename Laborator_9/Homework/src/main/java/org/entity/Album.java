package org.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Albums")
@NamedQueries({
        @NamedQuery(name="Album.findByTitle",
                query = "SELECT album FROM Album album WHERE album.title LIKE :title")
})
public class Album extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name = "release_year")
    private String releaseYear;

    @ManyToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")
    private Artist artist;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "album_genres",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Album(){}
    public Album(String releaseYear, String title, Artist artist, Set<Genre> genres) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres=genres;
    }


    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }
}
