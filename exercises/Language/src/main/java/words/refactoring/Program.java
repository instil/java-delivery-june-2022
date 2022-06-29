package words.refactoring;

import util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static final String FILE_NAME = "./data/uniqueWords.txt";

    public static void main(String[] args) throws IOException {
        readLinesFromFile().ifPresentOrElse(
                Program::printWordsByFrequency,
                Program::handleError
        );
    }

    private static void handleError() {
        System.out.println("Cannot read from " + FILE_NAME);
    }

    private static void printWordsByFrequency(Stream<String> lines) {
        Map<String, List<String>> tableOfWords = tabulateWords(lines);

        List<Pair<String, Integer>> wordPairs = buildWordPairs(tableOfWords);

        printWordPairs(wordPairs);
    }

    private static void printWordPairs(List<Pair<String, Integer>> wordPairs) {
        wordPairs.stream()
                .map(pair -> String.format("%s %d", pair.getFirst(), pair.getSecond()))
                .forEach(System.out::println);
    }

    private static List<Pair<String, Integer>> buildWordPairs(Map<String, List<String>> tabularResults) {
        List<Pair<String, Integer>> results = tabularResults
                .entrySet()
                .stream()
                .map(entry -> new Pair<>(entry.getKey(), entry.getValue().size()))
                .filter(pair -> pair.getSecond() > 1)
                .sorted(Comparator.comparingInt(Pair::getSecond))
                .collect(Collectors.toList());

        Collections.reverse(results);
        return results;
    }

    private static Map<String, List<String>> tabulateWords(Stream<String> lines) {
        return lines
                .flatMap(Program::lineToWords)
                .map(Program::normaliseWord)
                .filter(Program::isNotNumber)
                .collect(Collectors.groupingBy(word -> word));
    }

    private static boolean isNotNumber(String word) {
        return !word.matches("^[0-9]+$");
    }

    private static String normaliseWord(String word) {
        return word.toLowerCase().replaceAll("\\W", "");
    }

    private static Stream<String> lineToWords(String line) {
        return Stream.of(line.split("\\s+"));
    }

    private static Optional<Stream<String>> readLinesFromFile() {
        Path path = new File(FILE_NAME).toPath();
        try {
            return Optional.of(Files.lines(path));
        } catch (IOException ex) {
            return Optional.empty();
        }
    }
}
