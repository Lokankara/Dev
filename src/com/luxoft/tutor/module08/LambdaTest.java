package com.luxoft.tutor.module08;

import com.luxoft.tutor.Logger;
import com.luxoft.tutor.module08.defaultmethods.Comparator;
import com.luxoft.tutor.module08.defaultmethods.FileFilter;
import com.luxoft.tutor.module08.defaultmethods.Function;
import com.luxoft.tutor.module08.defaultmethods.Predicate;

import java.io.File;
import java.util.*;

public class LambdaTest {

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        result.addAll(sourceCollection);
        return result;
    }

    private static int max = 5;
    private static final String suffix = ".java";
    private static String value = "hi";

    public String process(String s, Function<String, String> f) {
        return f.apply(s);
    }

    public String process2(LambdaTest t, Function<LambdaTest, String> f) {
        return f.apply(t);
    }

    public String addExclamation(String s) {
        return String.format("%s!", s);
    }

    public String addExclamation2() {
        return String.format("%s!", value);
    }

    public static String addQuestion(String s) {
        return String.format("%s?", s);
    }

    public static void main(String[] args) {

        Predicate<Integer> isAdult = age -> age >= 18;

        Logger.log(isAdult.test(10));

        Supplier<String> hi = () -> "hi";

        Logger.log(hi.get());

        Consumer<String> printer = p -> Logger.log(String.format("Printed %s", p));

        printer.accept(hi.get());

        Comparator<String> comparator = (String a, String b) -> Integer.compare(a.length(), b.length());
        Comparator<String> compare = (a, b) -> Integer.compare(a.length(), b.length());

        Logger.log(compare.compare("compare.comparator.compare", "comparator.compare"));
        Logger.log(comparator.compare("comparator.compare", "comparator.compare.comparator"));

        Function<String, String> function = String::toLowerCase;
        function.apply(hi.get());

        Comparator<Integer> integerComparator = Integer::compare;
        Logger.log(integerComparator.compare(30, 50));

        Consumer<String> consumer = Logger::log;
        consumer.accept("String");

        Calendar cal = Calendar.getInstance();

        cal.set(2013, 0, 1);
        Person january = new Person(cal.getTime());

        cal.set(2013, 4, 1);
        Person may = new Person(cal.getTime());

        cal.set(2013, 5, 1);
        Person june = new Person(cal.getTime());

        Person[] rosterAsArray = {june, may, january};

        Arrays.sort(rosterAsArray, Person::compareByAge);

        Arrays.stream(rosterAsArray).map(person -> person.birthday.toString()).forEach(consumer::accept);

        String[] stringArray = {"Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Arrays.stream(stringArray).forEach(consumer::accept);

        Collection<Person> roster = List.of(rosterAsArray);

        Set<Person> rosterSetLambda = transferElements(roster, HashSet::new);

        for (Person person : rosterSetLambda) {
            consumer.accept(person.birthday.toString());
        }

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {

                return pathname.getName().endsWith(suffix);
            }
        };


        FileFilter filter = (File file) -> file.getName().endsWith(suffix);


        Runnable r = () -> {
            for (int i = 0; i < max; i++) {
                System.out.println(suffix);
            }
        };

        r.run();

        LambdaTest lambdaTest = new LambdaTest();
        String s = lambdaTest.process("hello", LambdaTest::addQuestion);
        Logger.log(lambdaTest.process2(lambdaTest, LambdaTest::addExclamation2));
        Logger.log(s);
        Logger.log(lambdaTest.process("hello", x -> x + "?"));
    }
}
