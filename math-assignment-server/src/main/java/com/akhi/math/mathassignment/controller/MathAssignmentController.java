package com.akhi.math.mathassignment.controller;

import com.akhi.math.mathassignment.model.DataSeries;
import com.akhi.math.mathassignment.service.NumberManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MathAssignmentController {

    @Autowired
    private NumberManipulationService numberManipulationService;

    /**
     * version 1.0 of the Fizz Buzz algorithm. Returns relevant data for passed data range.
     * Multiples of 3: Fizz
     * Multiples of 5: Buzz
     * Multiples of 3 and 5: FizzBuzz
     *
     * @param start - lower range for which number generation is required
     * @param end - higher range upto which number generation is required
     * @return an array of numbers and Fizz Buzz data for the passed range
     */
    @GetMapping("/v1.0/{start}/{end}")
    public DataSeries getFizzBuzzType1(@PathVariable int start,
                                             @PathVariable int end) {
        return  DataSeries.builder().series(numberManipulationService.convertMultiples(start, end)).build();
    }

    /**
     * version 2.0 of the Fizz Buzz algorithm. Returns relevant data for passed data range.
     * Multiples of 3 or contains letter 3: Fizz
     * Multiples of 5 or contains letter 3: Buzz
     * If both of above criteria is satisfied, then: FizzBuzz
     *
     * @param start - lower range for which number generation is required
     * @param end - higher range upto which number generation is required
     * @return an array of numbers and Fizz Buzz data for the passed range
     */
    @GetMapping("/v2.0/{start}/{end}")
    public DataSeries getFizzBuzzType2(@PathVariable int start,
                                         @PathVariable int end) {
        return DataSeries.builder().series(numberManipulationService.convertMultiplesAndContainingNumbers(start, end)).build();
    }
}
