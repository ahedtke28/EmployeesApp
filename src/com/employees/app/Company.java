package com.employees.app;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.employees.files.JSONParser;
import com.employees.testcases.TestJunitSalaries;

public class Company {

	public static void main(String[] args) {

		// Main Manager
		Manager ceo = new Manager("Jeff", 100000L);

		// Manager 1
		Manager m1 = new Manager("Dave", 50000L);

		// Manager 2
		Manager m2 = new Manager("Jon", 50000L);

		// Manager 3
		Manager m3 = new Manager("Robert", 50000L);

		// Manager 4
		Manager m4 = new Manager("Manuel", 25000L);

		// Add Manager 1 to Main Manager
		ceo.addEmployee(m1);
		ceo.addEmployee(m2);
		ceo.addEmployee(m3);

		// Add Employees to Manager 1
		m1.addEmployee(new Employee("Rick", 25000L));
		m1.addEmployee(new Employee("Andy", 25000L));
		m1.addEmployee(new Employee("Suzanne", 25000L));
		m1.addEmployee(new Employee("Jason", 25000L));
		m1.addEmployee(new Employee("Dan", 25000L));

		// Add Employees to Manager 2
		m2.addEmployee(new Employee("Flor", 25000L));
		m2.addEmployee(new Employee("Margarita", 25000L));
		m2.addEmployee(new Employee("Maria", 25000L));
		m2.addEmployee(new Employee("Angel", 25000L));
		m2.addEmployee(new Employee("Rosa", 25000L));

		// Add Employees to Manager 3
		m3.addEmployee(new Employee("David", 25000L));
		m3.addEmployee(new Employee("Ross", 25000L));
		m3.addEmployee(new Employee("Rose", 25000L));
		m3.addEmployee(new Employee("Lionel", 25000L));

		// Employees of Manager 4
		m4.addEmployee(new Employee("Juan", 20000L));
		m4.addEmployee(new Employee("Leibniz", 20000L));
		m4.addEmployee(new Employee("Bernard", 20000L));
		m4.addEmployee(new Employee("Leticia", 20000L));
		m4.addEmployee(new Employee("Oscar", 20000L));

		m3.addEmployee(m4);

		// Print Company Tree
		System.out.println(ceo.getNames());

		// Print Total Salary
		System.out.println("\n\nTotal salary: " + ceo.getSalaries());

		// Test case for testing total salary greater than zero
		System.out.println("\n\n");

		// Run Test Suite
		Result result = JUnitCore.runClasses(TestJunitSalaries.class);

		for (Failure failure : result.getFailures()) {
			System.out.println("Test Failed(" + failure.toString() + ")");
		}

		if (result.wasSuccessful()) {
			System.out.println("Test was successful");
		}

		// Print Company Tree
		ceo = JSONParser.getJSONParser().getManager();

		System.out.println("\n\n" + ceo.getNames());

		// Print Total Salary
		System.out.println("\n\nTotal salary: " + ceo.getSalaries());
	}
}
