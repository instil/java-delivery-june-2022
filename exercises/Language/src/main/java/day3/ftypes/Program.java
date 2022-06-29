package day3.ftypes;

import java.util.function.*;

public class Program {
    public static void main(String[] args) {
        Supplier<Double> f1 = () -> 12.3;
        Function<Integer, Double> f2 = input -> input * 2.0;
        BiFunction<Integer, Integer, Double> f3 = (input1, input2) -> input1 * input2 * 1.0;
        Predicate<String> f4 = input -> input.length() == 6;
        IntToDoubleFunction f5 = input -> input * 1.0;

        System.out.println(f1.get());
        System.out.println(f2.apply(123));
        System.out.println(f3.apply(12, 34));
        System.out.println(f4.test("abcde"));
        System.out.println(f4.test("abcdef"));
        System.out.println(f5.applyAsDouble(345));
    }
}
