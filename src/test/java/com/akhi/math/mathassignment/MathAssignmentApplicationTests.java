package com.akhi.math.mathassignment;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class MathAssignmentApplicationTests {
	@Autowired
	NumberManipulationService numberManipulationService;

	@Test
	void type1TestHappyPaths() {
		Assertions.assertThat(numberManipulationService.convertMultiples(1,3))
				.isEqualTo(Stream.of("1", "2", "Fizz").collect(Collectors.joining(System.lineSeparator())));
		Assertions.assertThat(numberManipulationService.convertMultiples(1,5))
				.isEqualTo(Stream.of("1", "2", "Fizz", "4", "Buzz").collect(Collectors.joining(System.lineSeparator())));
		Assertions.assertThat(numberManipulationService.convertMultiples(1,15))
				.isEqualTo(Stream.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz")
						.collect(Collectors.joining(System.lineSeparator())));
	}

	@Test
	void type1EdgeCases() {
		Assertions.assertThat(numberManipulationService.convertMultiples(1,1)).isEqualTo("1");
	}

	@Test
	void type1NegativePaths() {
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(-1,4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(-1,-4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(11,-4));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(4,0));
		Assertions.assertThatIllegalArgumentException()
				.isThrownBy(() -> numberManipulationService.convertMultiples(0,0));
	}

}
