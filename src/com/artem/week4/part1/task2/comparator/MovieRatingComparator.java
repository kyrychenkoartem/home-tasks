package com.artem.week4.part1.task2.comparator;

import com.artem.week4.part2.Movie;
import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o2.getRating(), o1.getRating());
    }
}
