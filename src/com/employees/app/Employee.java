package com.employees.app;

import javatest.AbstractEmployee;

public class Employee extends AbstractEmployee {

	public Employee(String name, long salary) {
		super(name, salary);
	}

	/**
	 * Get employee's salary
	 */
	@Override
	public long getSalaries() {
		return getSalary();
	}

	/**
	 * Get employee's name
	 */
	@Override
	public String getNames() {
		return getName();
	}

	/**
	 * Non-manager employees don't have employee(s)
	 */
	@Override
	public void addEmployee(AbstractEmployee employee)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"Non-manager employees don't have employee(s)");
	}
}
