package UtilityServices.UserInputValidator;

import UtilityServices.UserInputValidators.DateInputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DateInputValidatorTest {

    public DateInputValidator dateInputValidator;

    @BeforeEach
    void initTest() {
        dateInputValidator = new DateInputValidator();
    }

    @Test
    void validate_whenCorrectDateInput_thenReturnTrue() {
        assertTrue(dateInputValidator.validate("2025-03-19"));
    }

    @Nested
    class WhenWrongDateFormat {

        static Stream<String> wrongDateFormatInput() {
            return Stream.of( "12-02-2023", "12/02/2023", "12 February 2024", "12 Feb 2023");
        }

        @ParameterizedTest
        @MethodSource ("wrongDateFormatInput")
        void shouldReturnFalseWhenWrongFormat(String input) {
            assertFalse(dateInputValidator.validate(input));
        }
    }

    @Nested
    class WhenNonDateInput{

        static Stream<String> nonDateInput() {
            return Stream.of( "!", "?", ".", "/", "abc", "a");
        }

        @ParameterizedTest
        @MethodSource("nonDateInput")
        void shouldReturnFalseWhenNonDate(String input) {
            assertFalse(dateInputValidator.validate(input));
        }

        @Test
        void shouldReturnFalseWhenEmpty() {
            assertFalse(dateInputValidator.validate(""));
        }

    }

}
