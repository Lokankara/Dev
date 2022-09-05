package com.luxoft.jva008.module01;

import org.junit.Test;

import java.util.*;

import static com.luxoft.jva008.Logger.log;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Implement the hashSet() and equals() methods in the Employee class,
 * To compare the full name, but not the age of the employee.
 */
public class ObjectEqualsTutor {
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Ivan", "Ivanov", 35));
        employees.add(new Employee("Ivan", "Ivanov", 30));
        employees.add(new Employee("Ivan", "Petrov", 25));
        employees.add(new Employee("Ivan", "Sidorov", 25));
        return employees;
    }

    public Set<Employee> getEmployeesSet(ObjectMethodsTutor1.EmployeeType type) {
        Set<Employee> employeesSet = new HashSet<Employee>();
        employeesSet.addAll(getEmployees());
        return employeesSet;
    }

    @Test
    public void testEmployees() {
        List<Employee> employees = getEmployees();
        int index = 0;
        for (Employee employee : employees) {
            log("emp" + index++ + "=" + employee);
        }

        log("***Testing equals: ***");
        employees = getEmployees();
        for (int i = 0; i < 3; i++) {
            log("emp" + i + ".equals(emp" + (i + 1) + ")=" +
                    employees.get(i).equals(employees.get(i + 1)));
        }
        assertEquals(employees.get(0), employees.get(1));
        assertNotSame(employees.get(1), employees.get(2));
        assertNotSame(employees.get(2), employees.get(3));
    }

    @Test
    public void testEmployeesSet() {
        Set<Employee> employeesSet;
        log("***Testing HashSet: Employee");
        employeesSet = getEmployeesSet(ObjectMethodsTutor1.EmployeeType.ByName);
        for (Employee employee : employeesSet) {
            log(employee);
        }
        assertEquals(employeesSet.size(), 3);
    }

    class Employee {
        public String name;
        public String surname;
        public int age;

        public Employee(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public String getFullName() {
            return this.name + " " + this.surname;
        }

        public String toString() {
            return this.name + " " + this.surname + ", Age:" + age;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Employee)) {
                return false;
            }
            return ((Employee) o).getFullName().equals(this.getFullName());
        }

        @Override
        public int hashCode() {
            return getFullName().hashCode();
        }
    }
}
