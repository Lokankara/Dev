package com.luxoft.jva008.module01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.luxoft.jva008.Logger.log;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RegExpTutor {
    private String charRegEx = "a-zA-Z";

    public Email getEmail(String emailString) {
        Email email = new Email();

        String regEx = "a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-";

        String regexPattern = "^([" + regEx + "]{1,64})@([" + regEx + "]{1,64})\\.([" + charRegEx + "]{2,4})$";

        Pattern pattern = Pattern.compile(regexPattern);

        Matcher matcher = pattern.matcher(emailString);

        if (matcher.find()) {
            email.name = matcher.group(1);
            email.domainName = matcher.group(2);
            email.domainZone = matcher.group(3);
        }

        return email;

    }

    /**
     * Returns a list of strings according to the text representation of strings:
     * Takes a string
     * "List of animals: Cow, Goose, Cat, Dog, Elephant, Hare, Snake, Hen, Horse, Man."
     * And returns an array of individual animals
     */
    public String[] getAnimalsArray(String animalsString) {

        ArrayCopyTutor tutor = new ArrayCopyTutor();

        Pattern pattern = Pattern.compile(" ([" + charRegEx + "]{1,64})([\\.,])");
        Matcher matcher = pattern.matcher(animalsString);

        while (matcher.find()) {
            String found = matcher.group(1);
            tutor.addAnimal(found);
            log(found);
        }
        return tutor.animals;

    }

    @Test
    public void testGetEmail() {
        Email email = getEmail("ivanov@mail.ru");
        assertEquals("ivanov", email.name);
        assertEquals("mail", email.domainName);
        assertEquals("ru", email.domainZone);

    }

    @Test
    public void testGetAnimalsArray() {
        String[] animals = {"Cow", "Goose", "Cat", "Dog", "Elephant", "Hare", "Snake", "Chicken", "Horse", "Man"};
        String animalsString = "List of animals: Cow, Goose, Cat, Dog, Elephant, Hare, Snake, Chicken, Horse, Man.";
        assertArrayEquals(animals, getAnimalsArray(animalsString));
    }

    class Email {
        String name;
        String domainName;
        String domainZone;
    }

}
