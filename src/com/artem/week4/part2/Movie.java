package com.artem.week4.part2;

public record Movie(int id, int publicationYear, int publicationMonth, Genre genre, double rating) {

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

}
