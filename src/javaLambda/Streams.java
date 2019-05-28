package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<String> someNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G50", "G60",
                "I26", "I17", "I29",
                "O71"
        );

        List<String> gNumbers = new ArrayList<>();

        /* Normal

        someNumbers.forEach(number -> {
            if(number.startsWith("G")) {
                //System.out.println(number);
            }
        });

        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
        gNumbers.forEach((String s) -> System.out.println(s));

         */

        // Using Streams

        someNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> idNumberStream = Stream.of("I26", "I17", "I29", "071");
        Stream<String> inNumberStream = Stream.of("N48", "N36", "I26", "I17", "I29", "071");
        Stream<String> concatStream = Stream.concat(idNumberStream, inNumberStream);
        System.out.println("-------------------------");
        System.out.println(concatStream
                  .distinct()
                  .peek(System.out::println)
                  .count());
    }
}
