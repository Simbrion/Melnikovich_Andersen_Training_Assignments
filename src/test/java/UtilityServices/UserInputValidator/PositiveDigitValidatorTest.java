package UtilityServices.UserInputValidator;

import UtilityServices.UserInputValidators.PositiveDigitValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class PositiveDigitValidatorTest {

    public PositiveDigitValidator positiveDigitValidator;

    @BeforeEach
    void initTest() {
        positiveDigitValidator = new PositiveDigitValidator();
    }

    @Nested
    class WhenIntInput {

        @ParameterizedTest
        @ValueSource(ints = {1, 20, 32, 49})
        void shouldReturnTrueWhenSmallInt(int input) {
            assertTrue(positiveDigitValidator.validate(Integer.toString(input)));
        }

        @ParameterizedTest
        @ValueSource(ints = {10000000, 222222222, 33333333})
        void shouldReturnTrueWhenBigInt(int input) {
            assertTrue(positiveDigitValidator.validate(Integer.toString(input)));
        }

        @ParameterizedTest
        @ValueSource (ints = {-1, -22222222, -33333333})
        void shouldReturnFalseWhenNegativeInt(int input) {
            assertFalse(positiveDigitValidator.validate(Integer.toString(input)));
        }

        @Test
        void shouldReturnTrueWhenZeroInt() {
            assertTrue(positiveDigitValidator.validate("0"));
        }

    }

    @Nested
    class WhenDecimalInput {

        @ParameterizedTest
        @ValueSource (doubles = {0.1, 0.34, 2.442442, 123234.22345})
        void shouldReturnFalseWhenPositiveDecimal(double input) {
            assertFalse(positiveDigitValidator.validate(Double.toString(input)));
        }

        @ParameterizedTest
        @ValueSource (doubles = {-0.1, -0.34, -2.442442, -123234.22345})
        void shouldReturnFalseWhenNegativeDecimal(double input) {
            assertFalse(positiveDigitValidator.validate(Double.toString(input)));
        }

        @Test
        void shouldReturnFalseWhenZeroDecimal() {
            assertFalse(positiveDigitValidator.validate("0.0"));
        }

    }

    @Nested
    class  WhenNonDigitInput {

        static Stream<String> nonDigitInput() {
            return Stream.of( "!", "?", ".", "/", "abc", "a");
        }

        @ParameterizedTest
        @MethodSource("nonDigitInput")
        void shouldReturnFalseWhenNonDigit(String input) {
        assertFalse(positiveDigitValidator.validate(input));
        }

        @Test
        void shouldReturnFalseWhenEmpty() {
            assertFalse(positiveDigitValidator.validate(""));
        }

    }

}
