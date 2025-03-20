package UtilityServices.UserInputValidator;

import UtilityServices.UserInputValidators.TimeInputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TimeInputValidatorTest {

    public TimeInputValidator timeInputValidator;

    @BeforeEach
    void initTest() {
        timeInputValidator = new TimeInputValidator();
    }

    @Test
    void validate_whenExpectedTimeFormat_thenReturnTrue () {
        assertTrue(timeInputValidator.validate("12:15"));
    }

    @Nested
    class WhenNonTimeInput {

        static Stream<String> nonTimeInput() {
            return Stream.of( "!", "?", ".", "/", "abc", "a");
        }

        @ParameterizedTest
        @MethodSource("nonTimeInput")
        void shouldReturnFalseForNonTimeInput(String input) {
            assertFalse(timeInputValidator.validate(input));
        }

        @Test
        void shouldReturnFalseForEmptyInput() {
            assertFalse(timeInputValidator.validate(""));
        }

    }

    @Nested
    class WhenWrongTimeFormat {

        static Stream<String> provideWrongDateFormats() {
            return Stream.of("12-15", "12.15", "12/15");
        }

        @ParameterizedTest
        @MethodSource("provideWrongDateFormats")
        void shouldReturnFalseWhenWrongTimeFormat(String input) {
            assertFalse(timeInputValidator.validate(input));
        }
    }

}



