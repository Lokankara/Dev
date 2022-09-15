package com.luxoft.tutor.module08;

import com.luxoft.tutor.Logger;
import com.luxoft.tutor.module08.defaultInterfaces.*;
import com.luxoft.tutor.module08.defaultInterfaces.Comparator;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.Runnable;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static com.luxoft.tutor.module08.LambdaTest.transferElements;
import static org.junit.jupiter.api.Assertions.*;

class FuncInterfaceTutorTest {
    private static int max = 5;
    private static final String suffix = ".java";
    private static Person[] rosterAsArray;
    private static Collection<Person> roster;

    @Before
    public void init() {
        Calendar cal = Calendar.getInstance();

        cal.set(2013, 0, 1);
        Person january = new Person(cal.getTime());

        cal.set(2013, 4, 1);
        Person may = new Person(cal.getTime());

        cal.set(2013, 5, 1);
        Person june = new Person(cal.getTime());

        rosterAsArray = new Person[]{june, may, january};
        roster = List.of(rosterAsArray);
    }

    Runnable runnable = () -> System.out.println("Hello World!");

    @Test
    @DisplayName("runnable instance as lambda expression")
    public void shouldKnowValidateRunnableInstance() {
        assertTrue(runnable instanceof Runnable);
    }

    @Test
    @DisplayName(" as lambda expression")
    public void peek() {
        List<String> result = new ArrayList<>();
//        Stream.of(roster).stream()
//                .peek(System.out::println)
//                .filter(person -> person.getAge() > 20)
//                .peek(result::add);
    }

    @Test
    @DisplayName("how to get a string using supplier")
    public void shouldSupplyAnString() {
        Supplier<String> supplier = () -> "supplier";
        assertEquals("supplier", supplier.get());
    }

    @Test
    @DisplayName("how to get string length")
    public void shouldGetStringLength() {
        Integer expectedResult = 6;
        Function<String, Integer> function = String::length;
        assertEquals(expectedResult, function.apply("length"));
    }

    @Test
    @DisplayName("how to get length length and if it is even")
    public void shouldKnowIfNicknameLengthIsEven() {
        Function<String, Integer> lengthFunction = String::length;
        Function<Integer, Boolean> evenFunction = i -> i % 2 == 0;
        assertTrue(lengthFunction.andThen(evenFunction).apply("length"));
    }

    @Test
    @DisplayName("how to get function identity")
    public void shouldGetFunctionIdentity() {
        Function<String, String> function = Function.identity();
        assertEquals("length", function.apply("length"));
    }


    @Test
    @DisplayName("how to get persons high ranked and starts with A")
    public void shouldGetPersonsHighRankedAndStartsWithJ() {
        Predicate<Person> isHighRanked = person -> person.getAge() >= 18;
        Predicate<Person> startsWith = person -> person.getName().startsWith("A");
//        assertEquals(2, roster.stream().filter(isHighRanked).filter(startsWith).count());
    }


    @Test
    @DisplayName("how to get persons with four in ranking or more")
    public void shouldGetPersonsWithFourInRankingOrMore() {
        Predicate<Person> isHighRanked = person -> person.getAge() >= 18;
//        assertEquals(4, roster.stream().filter(isHighRanked).count());
    }

    @Test
    void testImplStatic() {
        List<String> result = new ArrayList<>();

        Consumer<String> consumer = Logger::log;
        consumer.accept("String");

        Arrays.sort(rosterAsArray, Person::compareByAge);

        Arrays.stream(rosterAsArray).map(Person::getName).forEach(consumer::accept);

        String[] stringArray = {"Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"};

        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Arrays.stream(stringArray).forEach(consumer::accept);

        Set<Person> rosterSetLambda = transferElements(roster, HashSet::new);

        for (Person person : rosterSetLambda) {
            consumer.accept(person.getBirthday().toString());
        }

    }

    @Test
    void testInterfaces() {

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
    }

    @Test
    void testFileFilter() {
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

    }

    @Test
    void printAll() {
    }

    @Test
    void createInfo() {
    }

    @Test
    void testCreateInfo() {
    }
}