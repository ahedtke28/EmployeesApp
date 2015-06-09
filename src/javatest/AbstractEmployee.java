package javatest;
import java.util.ArrayList;

/**
 * Title: AbstractEmployee
 * Description: Abstract base class for both Managers and Employees
 * Copyright:    Copyright (c) 2002
 *
 * @version 1.0
 */

public abstract class AbstractEmployee implements Comparable<AbstractEmployee>{

  // -- state variables for all employees --

  /**
   * The employee's name
   */
  protected String _name = null;

  /**
   * The employee's salary
   */
  protected long _salary = 0;

  /**
   * Is the employee a Manager ?
   */
  protected boolean _isManager = false;

  /**
   * If a Manager, then this points to a list of subordinates
   */
  protected ArrayList<AbstractEmployee> _subordinates = null;

  /**
   * Convenience constructor which takes a name and salary
   *
   * @param name Employee's name
   * @param salary Employee's salary
   */
  public AbstractEmployee(String name, long salary)
  {
    this._name = name;
    this._salary = salary;
  }

  // -- base class implementations --
  /**
   * Return's the employee's salary
   *
   * @return salary
   */
  public long getSalary()
  {
    return this._salary;
  }

  /**
   * Set the employee's salary
   *
   * @param salary salary
   */
  public void setSalary(long salary)
  {
    this._salary = salary;
  }

  /**
   * Return the employee's name
   *
   * @return name
   */
  public String getName()
  {
    return this._name;
  }

  /**
   * Set the employee's name
   *
   * @param name name
   */
  public void setName(String name)
  {
    this._name = name;
  }

  /**
   * Is the employee a Manager ?
   *
   * @return Managerial state
   */
  public boolean isManager()
  {
    return this._isManager;
  }

  /**
   * Sort by employee name
   *
   * @param o Object to compare to
   * @return a negative integer, zero, or a positive integer as this object is
   *      less than, equal to, or greater than the specified object.
   */
  public int compareTo(AbstractEmployee e)
  {
      return -1*(e.getName().compareTo(this.getName()));
  }

  // -- subclasses must provide their own implementations of these methods --

  /**
   * Subclass and provide implementations for Manager and Employee
   * Managers should return their salary + the salary of everyone underneath then
   * Employees should just return their own salary
   *
   * @return Sum of salaries
   */
  public abstract long getSalaries();

  /**
   * Subclass and provide implementations for Manager and Employee
   * Managers should return their name + the names of everyone below them
   * Employees should return their name
   *
   * @return String containing list of employees
   */
  public abstract String getNames();

  /**
   * Subclass and provide implementations for Manager and Employee
   * Employees should not allow subordinates to be added
   *
   * @param employee The employee to add as a subordinate
   */
  public abstract void addEmployee(AbstractEmployee employee) throws UnsupportedOperationException;

}
