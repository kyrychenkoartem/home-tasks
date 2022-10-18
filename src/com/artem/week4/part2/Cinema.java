package com.artem.week4.part2;

import com.artem.week4.part2.comparator.MovieRatingComparator;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class Cinema {

    public static final int TOP_CAPACITY = 10;

    private final Map<Integer, Set<Movie>> movies = new LinkedHashMap<>();

    public void addMovie(Movie movie) {
        Set<Movie> existMovies = getAllMoviesByYear(movie.publicationYear());
        existMovies.add(movie);
        movies.put(movie.publicationYear(), existMovies);
    }

    public Set<Movie> getAllMoviesByYear(int year) {
        return movies.getOrDefault(year, new LinkedHashSet<>());
    }

    public Set<Movie> getMoviesByYearAndMonth(int year, int month) {
        Set<Movie> allMoviesByYear = getAllMoviesByYear(year);
        return allMoviesByYear.stream()
                .filter(movie -> movie.publicationMonth() == month)
                .collect(Collectors.toSet());
    }

    public Set<Movie> getMovieByGenre(Genre genre) {
        Set<Movie> result = new LinkedHashSet<>();
        for (Map.Entry<Integer, Set<Movie>> entry : movies.entrySet()) {
            for (Movie movie : entry.getValue()) {
                if (movie.genre() == genre) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    public List<Movie> getTopMovies() {
        var topMovies = new ArrayList<Movie>();
        for (Set<Movie> moviesByYear : movies.values()) {
            topMovies.addAll(moviesByYear);
        }
        topMovies.sort(new MovieRatingComparator());

        var topMoviesSize = Math.min(TOP_CAPACITY, topMovies.size());
        return topMovies.subList(0, topMoviesSize);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "movies=" + movies +
                '}';
    }
}

