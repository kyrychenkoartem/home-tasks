package com.artem.week4.part2;

import com.artem.week4.part1.task2.comparator.MovieRatingComparator;
import java.util.*;

public class Cinema {

    public static final int TOP_TEN = 10;

    private final Map<Integer, List<Movie>> movies = new LinkedHashMap<>();

    public void addMovie(Movie movie) {
        int publicationYear = movie.getPublicationYear();
        List<Movie> movieList = movies.getOrDefault(publicationYear, new LinkedList<>());
        if (!movieList.contains(movie)) {
            movieList.add(movie);
        }
        movies.put(publicationYear, movieList);
    }

    public List<Movie> getMovieByYear(int year) {
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : movies.entrySet()) {
            if (entry.getKey() == year) {
                result.addAll(entry.getValue());
            }
        }
        return result;
    }

    public List<Movie> getMovieByYearAndMonth(int year, int month) {
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : movies.entrySet()) {
            if (entry.getKey() == year) {
                for (Movie movie : entry.getValue()) {
                    if (movie.getPublicationMonth() == month) {
                        result.add(movie);
                    }
                }
            }
        }
        return result;
    }

    public List<Movie> getMovieByGenre(Genre genre) {
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : movies.entrySet()) {
            for (Movie movie : entry.getValue()) {
                if (movie.getGenre() == genre) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    public List<Movie> getTopTenByRatingInDescending() {
        int moviesCount = 0;
        List<Movie> allMovies = new ArrayList<>();
        List<Movie> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : movies.entrySet()) {
            allMovies.addAll(entry.getValue());
        }
        allMovies.sort(new MovieRatingComparator());
        for (Movie movie : allMovies) {
            if (moviesCount < TOP_TEN) {
                result.add(movie);
                moviesCount++;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "movies=" + movies +
                '}';
    }
}

