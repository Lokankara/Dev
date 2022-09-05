package com.luxoft.jva008.module01;

import org.junit.Test;

import static com.luxoft.jva008.Logger.log;
import static org.junit.Assert.*;

public class StringTutor {

    /**
     * Replace all null in assertEquals to true or false
     */
    @Test
    public void testStringEquals() {
        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        log("Address of the object s1: " + System.identityHashCode(s1));
        log("Address of the object s2: " + System.identityHashCode(s2));
        assertEquals(s1 == s2, true);
        assertEquals(s1.equals(s2), true);
        log("Address of the object s3: " + System.identityHashCode(s3));
        assertEquals(s1 == s3, false);
        // The intern () method allows you to get a string from a row pool
        String s4 = s3.intern();
        log("Address of the object s4: " + System.identityHashCode(s4));
        assertEquals(s1 == s4, true);
        // We test the re-creation of the object every time the
        s3 = s3 + "bbb";
        log("Address of the object s3: " + System.identityHashCode(s3));
        s3 = s3.substring(0, 3); // s3 again "aaa"
        assertEquals(s3 == s1, false);
        assertEquals(s3.equals(s1), true);
        assertEquals(s3.intern() == s1, true);
    }

    /**
     * Make sure greeting greetings look like
     * Hello, Ivan Ivanov!
     * or
     * Hello, Peter Pan!
     * I.e. Begins on Hello, ends on!
     * And contains 2 words for the name and surname,
     * And the name and surname are not shorter than 3 letters
     * And start with a capital letter
     */
    public boolean checkGreeting(String greeting) {
        String[] words = greeting.split(" ");

        if (words.length < 3) {
            return false;
        }

        String start = words[0];
        String end = words[words.length - 1];
        if (!start.equals("Hello,") || !end.endsWith("!")) {
            return false;
        }

        String firstName = words[1];
        String surname = words[2];

        if (4 > firstName.length() || (surname.length() < 3)) {
            return false;
        }

        if (!Character.isUpperCase(firstName.charAt(0)) || !Character.isUpperCase(surname.charAt(0))) {
            return false;
        }
        return true;
    }

    @Test
    public void testCheckGreeting() {
        assertTrue(checkGreeting("Hello, Ivan Ivanov!"));
        assertTrue(checkGreeting("Hello, Peter Pan!"));
        assertTrue(checkGreeting("Hello, Peter Pan!"));
        assertTrue(checkGreeting("Hello, Peter Pan !"));

        assertFalse("In the end there must be an exclamation mark",
                checkGreeting("Hello, Peter Pan"));
        assertFalse("Name is too short", checkGreeting("Hello, Li Song!"));
        assertFalse("Last name is too short", checkGreeting("Hello, Kui Le!"));
        assertFalse("The name and surname must be indicated",
                checkGreeting("Hello, Peter!"));
        assertFalse("The first letter of the name must be the capital letter",
                checkGreeting("Hello, peter Pan!"));
        assertFalse("The first letter of the surname must be the capital letter",
                checkGreeting("Hi, Peter is the first!"));
        assertFalse("In the beginning there should be a word Hello and a comma",
                checkGreeting("Hello Peter Pan!"));
    }
}