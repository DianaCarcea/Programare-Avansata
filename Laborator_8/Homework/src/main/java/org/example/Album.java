package org.example;

public class Album {
    private String artist;
    private String releaseYear;
    private String title;
    private String genres;

    public Album(String releaseYear, String title, String artist, String genres) {
        this.releaseYear = releaseYear;
        this.title = title;
        this.artist = artist;
        this.genres=genres;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
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

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
