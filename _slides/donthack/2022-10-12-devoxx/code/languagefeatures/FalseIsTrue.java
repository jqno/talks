package demos.languagefeatures;

import java.util.Objects;

public class FalseIsTrue {

    public static void main(String...args) {
        // This test passes!                                                                                     Move along, nothing to see here! ;-)                                       \u000A if (true) return;
        assertEquals("false", "true");
    }

    private static void assertEquals(String expected, String actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError("Expected " + expected + " is not equal to actual " + actual);
        }
    }
}
