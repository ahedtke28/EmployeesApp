package com.employees.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.employees.app.Employee;
import com.employees.app.Manager;

public class TestJunitSalaries {
	Manager m1, m2;

	// Mock Employees
	@Before
	public void setUp() {
		// Manager 1
		m1 = new Manager("Jeff", 100000L);

		// Manager 2
		m2 = new Manager("Dave", 50000L);

		m1.addEmployee(m2);

		// Add Employees to Manager 2
		m2.addEmployee(new Employee("Rick", 25000L));
		m2.addEmployee(new Employee("Andy", 25000L));
		m2.addEmployee(new Employee("Suzanne", 25000L));
		m2.addEmployee(new Employee("Jason", 25000L));
		m2.addEmployee(new Employee("Dan", 25000L));
	}

	// test total salary is greater than zero
	@Test
	public void testVerifyIfSalariesGreaterThanCero() {
		assertTrue(m1.getSalaries() > 0);
	}
}
