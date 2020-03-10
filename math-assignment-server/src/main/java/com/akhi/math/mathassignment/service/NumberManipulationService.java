package com.akhi.math.mathassignment.service;

import com.akhi.math.mathassignment.ruleengine.RuleEngine;
import com.akhi.math.mathassignment.ruleengine.RuleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class NumberManipulationService {
    private static final Logger logger = LoggerFactory.getLogger(NumberManipulationService.class);

    @Autowired
    private RuleEngine ruleEngine;
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
    public List<String> convertMultiples(int lowerRange, int upperRange) {
        return convertMultiples(lowerRange, upperRange, RuleType.TYPE_1);
    }

    /**
     * Common method that takes care of both aspects of Fizz Buzz based on
     * a discriminator includeContains
     *
     * @param lowerRange
     * @param upperRange
     * @param ruleType
     * @return
     */
    private List<String> convertMultiples(int lowerRange, int upperRange, RuleType ruleType) {

        if (lowerRange <= 0 || upperRange <= 0) {
            throw new IllegalArgumentException("Negative numbers or zero not allowed");
        }
        if(lowerRange > upperRange) {
            throw new IllegalArgumentException(String.format("Lower value %d, is less that upper value %d", lowerRange, upperRange));
        }
        return IntStream.rangeClosed(lowerRange, upperRange)
                .mapToObj((x) -> {
                    StringJoiner j = new StringJoiner("").setEmptyValue(""+x);

                    if(ruleEngine.isFizz(x, ruleType)) j.add("Fizz");
                    if(ruleEngine.isBuzz(x, ruleType)) j.add("Buzz");

                    return j.toString();
                })
                .collect(Collectors.toList());

    }

    /**
     * Works similar to the convertMultiples class, with the variance being that it also checks for
     * occurance of 3 or 5 as Fizz and Buzz respectively too
     *
     * @param lowerRange
     * @param upperRange
     * @return
     */
    public List<String> convertMultiplesAndContainingNumbers(int lowerRange, int upperRange) {
        return convertMultiples(lowerRange, upperRange, RuleType.TYPE_2);
    }
}
