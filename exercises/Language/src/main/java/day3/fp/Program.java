package day3.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
interface Wibble {
    boolean wobble(String str);
    default int timeout() { return 30; }
}

public class Program {
    private static List<String> myFilter1(List<String> input, Wibble predicate)  {
        var output = new ArrayList<String>();
        for(String str : input) {
            if(predicate.wobble(str)) {
                output.add(str);
            }
        }
        return output;
    }

    private static List<String> myFilter2(List<String> input, Predicate<String> predicate)  {
        var output = new ArrayList<String>();
        for(String str : input) {
            if(predicate.test(str)) {
                output.add(str);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        var sampleData = List.of("ac", "cde", "fg", "hij", "kl", "mno");

        var results1 = myFilter1(sampleData, str -> str.length() == 3);
        var results2 = myFilter2(sampleData, str -> str.length() == 2);

        System.out.println(results1);
        System.out.println(results2);
    }
}
