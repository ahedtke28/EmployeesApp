package com.employees.app;

import java.util.ArrayList;
import java.util.Collections;

import javatest.AbstractEmployee;

public class Manager extends AbstractEmployee {

	public Manager(String name, long salary) {
		super(name, salary);
		this._isManager = true;
		this._subordinates = new ArrayList<AbstractEmployee>();
	}

	/**
	 * Get the total salary of the employees hierarchically
	 */
	@Override
	public long getSalaries() {
		return getSalaries(this, getSalary());
	}

	/**
	 * Helper function to get the total salary of the company hierarchically &
	 * recursively
	 */
	private long getSalaries(Manager manager, long iniSalary) {
		long salary = iniSalary;

		for (AbstractEmployee m : manager._subordinates) {
			salary += m.getSalary();
		}

		for (AbstractEmployee m : manager._subordinates) {
			if (m instanceof Manager) {
				salary += getSalaries((Manager) m, 0);
			}
		}

		return salary;
	}

	/**
	 * Build the tree of the names of the employees hierarchically
	 */
	@Override
	public String getNames() {
		return getNames(this, getName());
	}

	/**
	 * Helper function to build the tree of the names of the employees
	 * hierarchically & recursively
	 */
	private String getNames(Manager manager, String iniName) {
		String names = iniName
				+ (manager._subordinates.size() > 0 ? "\nEmployees of: "
						+ manager.getName() : "");

		for (AbstractEmployee m : manager._subordinates) {
			names += "\n" + m.getName();
		}

		for (AbstractEmployee m : manager._subordinates) {
			if (m instanceof Manager) {
				names += getNames((Manager) m, "");
			}
		}

		return names;
	}

	/**
	 * Add a new employee to this manager & order them automatically
	 */
	@Override
	public void addEmployee(AbstractEmployee employee)
			throws UnsupportedOperationException {
		this._subordinates.add(employee);
		Collections.sort(this._subordinates);
	}
}
