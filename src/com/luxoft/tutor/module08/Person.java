package com.luxoft.tutor.module08;

import java.util.Date;

public class Person {
    public enum Gender {
        MALE, FEMALE
    }

    private String name;
    Date birthday;
    Gender gender;
    String email;

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public Person(Date birthday) {
        this.birthday = birthday;
    }
}
