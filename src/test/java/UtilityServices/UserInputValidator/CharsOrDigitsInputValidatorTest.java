package UtilityServices.UserInputValidator;

import UtilityServices.UserInputValidators.CharsOrDigitsInputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharsOrDigitsInputValidatorTest {

    public CharsOrDigitsInputValidator charsOrDigitsInputValidator;

    @BeforeEach
    void initTest() {
        charsOrDigitsInputValidator = new CharsOrDigitsInputValidator();
    }

    @Test
    void validate_WhenCharsInput_thenReturnTrue() {
        assertTrue(charsOrDigitsInputValidator.validate("abc"));
    }

    @Test
    void validate_WhenDigitsInput_thenReturnTrue() {
        assertTrue(charsOrDigitsInputValidator.validate("123"));
    }

    @Nested
    class WhenNonCharsOrDigitsInput{

        @Test
        void shouldReturnFalseWhenNonCharsOrDigits() {
            assertFalse(charsOrDigitsInputValidator.validate("."));
            assertFalse(charsOrDigitsInputValidator.validate("/"));
            assertFalse(charsOrDigitsInputValidator.validate("-"));
        }

        @Test
        void shouldReturnFalseWhenEmpty() {
            assertFalse(charsOrDigitsInputValidator.validate(""));
        }

    }


}
