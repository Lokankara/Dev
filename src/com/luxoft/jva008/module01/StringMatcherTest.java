package com.luxoft.jva008.module01;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringMatcherTest {

	// Returns true if the string matches exactly "true"
	public boolean isTrue(String s) {
		// TODO cour code goes here
		return false;
	}

	// Returns true if the string matches exactly "true" or "True"
	public boolean isTrueVersion2(String s) {
		// TODO cour code goes here
		return false;
	}

	// Returns true if the string matches exactly "true" or "True"
	// or "yes" or "Yes"
	public boolean isTrueOrYes(String s) {
		// TODO cour code goes here
		return false;
	}

	// Returns true if the string contains exactly "true"
	public boolean containsTrue(String s) {
		// TODO cour code goes here
		return false;
	}


	// Returns true if the string contains of three letters
	public boolean isThreeLetters(String s) {
		// TODO cour code goes here
		return false;
	}

	// Returns true if the string does not have a number at the beginning
	public boolean isNoNumberAtBeginning(String s) {
		// TODO cour code goes here
		return false;
	}

	// Returns true if the string contains a arbitrary number of characters except b
	public boolean isIntersection(String s) {
		// TODO cour code goes here
		return false;
	}

	// Returns true if the string contains a number less then 300
	public boolean isLessThenThreeHundred(String s) {
		// TODO cour code goes here
		return false;
	}

	@Test
	public void testIsTrue() {
		assertTrue(isTrue("true"));
		assertFalse(isTrue("true2"));
		assertFalse(isTrue("True"));
	}

	@Test
	public void testIsTrueVersion2() {
		assertTrue(isTrueVersion2("true"));
		assertFalse(isTrueVersion2("true2"));
		assertTrue(isTrueVersion2("True"));
	}

	@Test
	public void testIsTrueOrYes() {
		assertTrue(isTrueOrYes("true"));
		assertTrue(isTrueOrYes("yes"));
		assertTrue(isTrueOrYes("Yes"));
		assertFalse(isTrueOrYes("no"));
	}

	@Test
	public void testContainsTrue() {
		assertTrue(containsTrue("thetruewithin"));
	}

	@Test
	public void testIsThreeLetters() {
		assertTrue(isThreeLetters("abc"));
		assertFalse(isThreeLetters("abcd"));
	}

	@Test
	public void testisNoNumberAtBeginning() {
		assertTrue(isNoNumberAtBeginning("abc"));
		assertFalse(isNoNumberAtBeginning("1abcd"));
		assertTrue(isNoNumberAtBeginning("a1bcd"));
		assertTrue(isNoNumberAtBeginning("asdfdsf"));
	}

	@Test
	public void testisIntersection() {
		assertTrue(isIntersection("1"));
		assertFalse(isIntersection("abcksdfkdskfsdfdsf"));
		assertTrue(isIntersection("skdskfjsnxjwque484242"));
	}


	@Test
	public void testLessThenThreeHundret() {
		assertTrue(isLessThenThreeHundred("288"));
		assertFalse(isLessThenThreeHundred("3288"));
		assertFalse(isLessThenThreeHundred("328 8"));
		assertTrue(isLessThenThreeHundred("1"));
		assertTrue(isLessThenThreeHundred("99"));
		assertFalse(isLessThenThreeHundred("300"));
	}


}
