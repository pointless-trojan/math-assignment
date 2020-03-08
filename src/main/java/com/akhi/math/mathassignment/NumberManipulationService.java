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
        if (lowerRange <= 0 || upperRange <= 0) {
            throw new IllegalArgumentException("Negative numbers or zero not allowed");
        }
        if(lowerRange > upperRange) {
            throw new IllegalArgumentException(String.format("Lower value %d, is less that upper value %d", lowerRange, upperRange));
        }
        return IntStream.rangeClosed(lowerRange, upperRange)
                .mapToObj(x -> x%3 == 0 && x%5 == 0? "FizzBuzz": x%3 == 0? "Fizz": x%5 == 0? "Buzz": ""+x) //TODO - possibly extract in a rule engine if we need additional flexibility and/or there are repetitive use cases
                .collect(Collectors.joining(System.lineSeparator()));

    }
}
