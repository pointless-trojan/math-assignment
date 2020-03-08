package com.akhi.math.mathassignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class NumberManipulationService {
    private static final Logger logger = LoggerFactory.getLogger(NumberManipulationService.class);

    /**
     * Returns a systematic string equivalent output for passed range
     * of numbers (both inclusive) based on the Fizz/Buzz rule.
     * the rule is internal to the class and can be abstracted into a rule
     * engine based on further usages. Current implementation:
     * Multiples of 3: Fizz
     * Multiples of 5: Buzz
     * Multiples of 3 and 5: FizzBuzz
     *
     * The program doesn't allow negative numbers or reversed ranges
     *
     * @param lowerRange
     * @param upperRange
     * @return
     */
    public String convertMultiples(int lowerRange, int upperRange) {
        return convertMultiples(lowerRange, upperRange, false);
    }

    /**
     * Common method that takes care of both aspects of Fizz Buzz based on
     * a discriminator includeContains
     *
     * @param lowerRange
     * @param upperRange
     * @param includeContains
     * @return
     */
    public String convertMultiples(int lowerRange, int upperRange, boolean includeContains) {

        if (lowerRange <= 0 || upperRange <= 0) {
            throw new IllegalArgumentException("Negative numbers or zero not allowed");
        }
        if(lowerRange > upperRange) {
            throw new IllegalArgumentException(String.format("Lower value %d, is less that upper value %d", lowerRange, upperRange));
        }
        return IntStream.rangeClosed(lowerRange, upperRange)
                .mapToObj(x -> fizzCheck(x, includeContains) && buzzCheck(x, includeContains)? "FizzBuzz":
                        fizzCheck(x, includeContains)? "Fizz":
                                buzzCheck(x, includeContains)? "Buzz": ""+x) //TODO - possibly extract in a rule engine if we need additional flexibility and/or there are repetitive use cases
                .collect(Collectors.joining(System.lineSeparator()));

    }

    /**
     * Checks for valid Fizz clause based on passed value and contains clause
     *
     * @param x
     * @param includeContains
     * @return
     */
    private boolean fizzCheck(int x, boolean includeContains) {
        return x%3 == 0 || (includeContains && (""+ x).contains("3"));
    }

    /**
     * Checks for valid Fizz clause based on passed value and contains clause
     *
     * @param x
     * @param includeContains
     * @return
     */
    private boolean buzzCheck(int x, boolean includeContains) {
        return x%5 == 0 || (includeContains && (""+ x).contains("5"));
    }

    /**
     * Works similar to the convertMultiples class, with the variance being that it also checks for
     * occurance of 3 or 5 as Fizz and Buzz respectively too
     *
     * @param lowerRange
     * @param upperRange
     * @return
     */
    public String convertMultiplesAndContainingNumbers(int lowerRange, int upperRange) {
        return convertMultiples(lowerRange, upperRange, true);
    }
}
