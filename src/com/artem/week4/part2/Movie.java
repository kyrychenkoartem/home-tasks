package com.artem.week4.part2;

import java.util.Objects;

public class Movie {

    private final int id;
    private final int publicationYear;
    private final int publicationMonth;
    private final Genre genre;
    private final double rating;

    public Movie(int id, int publicationYear, int publicationMonth, Genre genre, double rating) {
        this.id = id;
        this.publicationYear = publicationYear;
        this.publicationMonth = publicationMonth;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPublicationMonth() {
        return publicationMonth;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", publicationYear=" + publicationYear +
                ", publicationMonth=" + publicationMonth +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && publicationYear == movie.publicationYear && publicationMonth == movie.publicationMonth && Double.compare(movie.rating, rating) == 0 && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, publicationYear, publicationMonth, genre, rating);
    }
}
