package day2.fp;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<String> sampleData = List.of(
                "ab", "cde", "fghi", "jklmn",
                "op", "qrs", "tuvw", "xyz"
        );

        showForEach(sampleData);
        showFilter(sampleData);
        showMap(sampleData);
        showMapToInt(sampleData);
        showReduce(sampleData);
        showReduceWithInitialValue(sampleData);
        showTesting(sampleData);
        showCollectForPartition(sampleData);
        showCollectForGrouping(sampleData);
    }

    private static void showCollectForPartition(List<String> sampleData) {
        printTitle("Show Partitioning");

        Map<Boolean, List<String>> result = sampleData.stream()
                .collect(Collectors.partitioningBy(str -> str.length() == 3));

        printTabbed("Strings of length three");
        result.get(true)
                .forEach(Program::printTabbed);

        printTabbed("Strings NOT of length three");
        result.get(false)
                .forEach(Program::printTabbed);
    }

    private static void showCollectForGrouping(List<String> sampleData) {
        printTitle("Show Partitioning");

        Map<Integer, List<String>> result = sampleData.stream()
                .collect(Collectors.groupingBy(String::length));

        result.forEach((key, values) -> {
            printTabbed("Strings of length " + key);
            values.forEach(Program::printTabbed);
        });
    }

    private static void showTesting(List<String> sampleData) {
        boolean result1 = sampleData.stream().allMatch(str -> str.length() == 3);
        boolean result2 = sampleData.stream().anyMatch(str -> str.length() == 3);
        boolean result3 = sampleData.stream().noneMatch(str -> str.length() == 3);

        printTitle("Testing");
        printTabbed(result1);
        printTabbed(result2);
        printTabbed(result3);
    }

    private static void showFilter(List<String> sampleData) {
        printTitle("Filter");
        sampleData.stream()
                .filter(str -> str.length() == 3) //Predicate
                .forEach(Program::printTabbed);
    }

    private static void showMap(List<String> sampleData) {
        printTitle("Map");
        //Mapping function is more properly called a Functor
        sampleData.stream()
                .map(String::length)
                .forEach(Program::printTabbed);
    }

    private static void showMapToInt(List<String> sampleData) {
        printTitle("MapToInt");
        int result = sampleData.stream()
                .mapToInt(String::length)
                .sum();
        printTabbed(result);
    }

    private static void showReduce(List<String> sampleData) {
        printTitle("Reduce");
        int result = sampleData.stream()
                .mapToInt(String::length)
                .reduce((a, b) -> {
                    printTabbed("Adding " + a + " and " + b);
                    return a + b;
                })
                .orElse(0);
        printTabbed(result);
    }

    private static void showReduceWithInitialValue(List<String> sampleData) {
        printTitle("Reduce");
        int result = sampleData.stream()
                .mapToInt(String::length)
                .reduce(1000, (a, b) -> {
                    printTabbed("Adding " + a + " and " + b);
                    return a + b;
                });
        printTabbed(result);
    }

    private static void showForEach(List<String> sampleData) {
        printTitle("Foreach Done Wrong");
        sampleData.stream()
                .forEach(str -> printTabbed(str));

        printTitle("Foreach Done Right");
        sampleData.forEach(Program::printTabbed);
    }

    private static void printTabbed(Object thing) {
        System.out.println("\t" + thing);
    }

    private static void printTitle(String title) {
        System.out.printf("------ %s -----\n", title);
    }
}
