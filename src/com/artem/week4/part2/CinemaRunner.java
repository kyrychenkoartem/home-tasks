package com.artem.week4.part2;

public class CinemaRunner {
    public static void main(String[] args) {
        Movie movie = new Movie(1, 2012, 3, Genre.ACTION, 3.6);
        Movie movie1 = new Movie(2, 2012, 2, Genre.ADVENTURE, 3.3);
        Movie movie2 = new Movie(3, 2012, 4, Genre.THRILLER, 3.8);
        Movie movie3 = new Movie(4, 2012, 4, Genre.COMEDY, 4.2);
        Movie movie4 = new Movie(4, 2010, 8, Genre.COMEDY, 4.2);
        Movie movie5 = new Movie(5, 2010, 8, Genre.COMEDY, 4.2);
        Movie movie6 = new Movie(6, 2008, 7, Genre.COMEDY, 4.2);
        Movie movie7 = new Movie(8, 2012, 5, Genre.THRILLER, 3.8);
        Movie movie8 = new Movie(9, 2012, 5, Genre.DRAMA, 5.7);
        Movie movie9 = new Movie(11, 2008, 5, Genre.FANTASY, 4.9);
        Movie movie10 = new Movie(25, 2012, 5, Genre.MYSTERY, 7.0);
        Movie movie11 = new Movie(33, 2010, 5, Genre.THRILLER, 2.1);
        Cinema cinema = new Cinema();
        cinema.addMovie(movie);
        cinema.addMovie(movie1);
        cinema.addMovie(movie2);
        cinema.addMovie(movie3);
        cinema.addMovie(movie4);
        cinema.addMovie(movie5);
        cinema.addMovie(movie6);
        cinema.addMovie(movie7);
        cinema.addMovie(movie1);
        cinema.addMovie(movie8);
        cinema.addMovie(movie9);
        cinema.addMovie(movie10);
        cinema.addMovie(movie11);
        System.out.println(cinema.getMovieByYear(1234));
        System.out.println(cinema.getMovieByYear(123));
        System.out.println(cinema.getMovieByYearAndMonth(1234, 4));
        System.out.println(cinema.getMovieByGenre(Genre.COMEDY));
        System.out.println(cinema.getTopTenByRatingInDescending());
    }
}