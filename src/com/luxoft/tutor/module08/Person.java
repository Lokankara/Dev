package com.luxoft.tutor.module08;

import java.util.Date;

public class Person {
    public enum Gender {
        MALE, FEMALE
    }

    private String name;
    private final Date birthday;
    private Gender gender;
    private String email;
    private int age;

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public Person(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
