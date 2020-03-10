package com.akhi.math.mathassignment.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class NumberManipulationServiceTest {
	@Autowired
	NumberManipulationService numberManipulationService;

	@Test
	void type1TestHappyPaths() {
		Assertions.assertThat(numberManipulationService.convertMultiples(1, 3))
				.isEqualTo(Arrays.asList("1", "2", "Fizz"));
		Assertions.assertThat(numberManipulationService.convertMultiples(1, 5))
				.isEqualTo(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
		Assertions.assertThat(numberManipulationService.convertMultiples(1, 15))
				.isEqualTo(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"));
	}

	@Test
	void type1And2EdgeCases() {
		Assertions.assertThat(numberManipulationService.convertMultiples(1, 1)).isEqualTo(Arrays.asList("1"));
		Assertions.assertThat(numberManipulationService.convertMultiplesAndContainingNumbers(1, 1)).isEqualTo(Arrays.asList("1"));
	}

	@Test
	void type1NegativePaths() {
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(-1, 4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(-1, -4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(11, -4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(4, 0));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(0, 0));
	}

	@Test
	void type2TestHappyPaths() {
		Assertions.assertThat(numberManipulationService.convertMultiplesAndContainingNumbers(1, 3))
				.isEqualTo(Arrays.asList("1", "2", "Fizz"));
		Assertions.assertThat(numberManipulationService.convertMultiplesAndContainingNumbers(1, 5))
				.isEqualTo(Arrays.asList("1", "2", "Fizz", "4", "Buzz"));
		Assertions.assertThat(numberManipulationService.convertMultiplesAndContainingNumbers(1, 15))
				.isEqualTo(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "Fizz", "14", "FizzBuzz"));
		Assertions.assertThat(numberManipulationService.convertMultiplesAndContainingNumbers(25, 27))
				.isEqualTo(Arrays.asList("Buzz", "26", "Fizz"));
		Assertions.assertThat(numberManipulationService.convertMultiplesAndContainingNumbers(28, 35))
				.isEqualTo(Arrays.asList("28", "29", "FizzBuzz", "Fizz", "Fizz", "Fizz", "Fizz", "FizzBuzz"));
		Assertions.assertThat(numberManipulationService.convertMultiplesAndContainingNumbers(47, 55))
				.isEqualTo(Arrays.asList("47", "Fizz", "49", "Buzz", "FizzBuzz", "Buzz", "FizzBuzz", "FizzBuzz", "Buzz"));
	}
	@Test
	void type2NegativePaths() {
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiplesAndContainingNumbers(-1, 4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiplesAndContainingNumbers(-1, -4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiplesAndContainingNumbers(11, -4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiplesAndContainingNumbers(4, 0));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiplesAndContainingNumbers(0, 0));
	}
}
