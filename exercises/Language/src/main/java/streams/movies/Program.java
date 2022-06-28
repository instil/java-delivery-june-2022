package streams.movies;

import util.Pair;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static streams.movies.Provider.greatActionMovies;

public class Program {
    public static void main(String[] args) {
        List<Movie> movies = greatActionMovies();
        allTheMovieTitles(movies);
        allTheGreatMovieTitles(movies);
        titleAndRatingOfMoviesFrom1984(movies);
        allTheQuotes(movies);
        averageQuoteLength(movies);
        moviesListedByDecade(movies);
        moviesGroupedByRating(movies);
    }

    private static void allTheMovieTitles(List<Movie> movies) {
        System.out.println("The titles of all the movies");
        movies.stream()
                .map(Movie::getTitle)
                .forEach(Program::printTabbed);
    }

    private static void allTheGreatMovieTitles(List<Movie> movies) {
        System.out.println("Titles of all the movies with a rating of GREAT");
        movies.stream()
                .filter(m -> m.getRating() == Rating.GREAT)
                .map(Movie::getTitle)
                .forEach(Program::printTabbed);
    }

    private static void titleAndRatingOfMoviesFrom1984(List<Movie> movies) {
        System.out.println("Title and rating of movies released in 1984");
        movies.stream()
                .filter(m -> m.getReleaseDate().getYear() == 1984)
                .map(m -> new Pair<>(m.getTitle(), m.getRating()))
                .forEach(Program::printTabbed);
    }

    private static void allTheQuotes(List<Movie> movies) {
        System.out.println("All the quotes");
        movies.stream()
                .flatMap(m -> m.getQuotes().stream())
                .forEach(Program::printTabbed);
    }

    private static void averageQuoteLength(List<Movie> movies) {
        System.out.println("The average length of a quote is");
        double result = movies
                .stream()
                .flatMap(m -> m.getQuotes().stream())
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        printTabbed(result);

    }

    private static void moviesListedByDecade(List<Movie> movies) {
        var result = movies.stream()
                .collect(Collectors.partitioningBy(m -> m.getReleaseDate().getYear() < 1990));

        System.out.println("The titles of all the movies from the 1980s");
        result.get(true)
                .stream()
                .map(Movie::getTitle)
                .forEach(Program::printTabbed);

        System.out.println("The titles of all the movies from the 1990s");
        result.get(false)
                .stream()
                .map(Movie::getTitle)
                .forEach(Program::printTabbed);
    }

    private static void moviesGroupedByRating(List<Movie> movies) {
        System.out.println("The movies grouped by their rating:");

        var result = movies.stream()
                .collect(Collectors.groupingBy(Movie::getRating));

        result.forEach((rating, moviesWithRating) -> {
            printTabbed("Movies rated: " + rating);
            moviesWithRating.stream()
                    .map(Movie::getTitle)
                    .forEach(Program::printTabbed);
        });
    }

    private static void printTabbed(Object input) {
        System.out.println("\t" + input);
    }

}
