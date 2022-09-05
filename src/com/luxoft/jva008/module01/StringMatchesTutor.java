package com.luxoft.jva008.module01;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringMatchesTutor {

	/**
	 * Checks the correctness of the email address
	 */
	public boolean checkIsEmail(String email) {
		// TODO your code goes here;
		return false;
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
		// TODO your code goes here;
		return false;
	}

	@Test
	public void testCheckGreeting() {
		assertTrue(checkGreeting("Hello, Ivan Ivanov!"));
		assertTrue(checkGreeting("Hello,Peter Pan!"));
		assertTrue(checkGreeting("Hello, Peter Pan!"));
		assertTrue(checkGreeting("Hello, Peter Pan !"));

		assertFalse("In the beginning there should be a word Hello and a comma", checkGreeting("Hi, Peter Pan!"));
		assertFalse("In the end there must be an exclamation mark", checkGreeting("Hello, Peter Pan"));
		assertFalse("Name is too short", checkGreeting("Hello, Li Song!"));
		assertFalse("Last name is too short", checkGreeting("Hello, Kui Le!"));
		assertFalse("The name and surname must be indicated", checkGreeting("Hello, Peter!"));
		assertFalse("The first letter of the name must be the capital letter", checkGreeting("Hello, peter Pan!"));
		assertFalse("The first letter of the surname must be the capital letter", checkGreeting("Hi, Peter is the first!"));
	}

	@Test
	public void testCheckIsEmail() {
		assertTrue(checkIsEmail("ivanov@mail.ru"));
		assertTrue(checkIsEmail("ivanov@mail.com.uk"));
		assertFalse(checkIsEmail("ivan ivanov@mail.com.uk"));
		assertFalse(checkIsEmail("ivanov@mailcom"));
	}
}
