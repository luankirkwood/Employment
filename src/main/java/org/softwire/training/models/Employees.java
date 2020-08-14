package org.softwire.training.models;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {

  @Id
  @Column(name = "employee_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int employeeId;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "job_id", nullable = false)
  private String job_id;

  @Column(name = "age", nullable = false)
  private int age;

  @Column(name = "salary", nullable = false)
  private int salary;

  public Employees() {
  }

  public Employees(int employeeId, String firstName, String lastName, String job_id, int age, int salary) {
    this.employeeId = employeeId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.job_id = job_id;
    this.age = age;
    this.salary = salary;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getJob_id() {
    return job_id;
  }

  public void setJob_id(String job_id) {
    this.job_id = job_id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public String toArrayString() {
    return "[" + getFirstName() + ", " + getLastName() + ", " + getJob_id() + ", " + getAge() + ", " + getSalary() + "]";
  }

  @Override
  public String toString() {
    return "[" + getFirstName() + ", " + getLastName() + ", " + getJob_id() + ", " + getAge() + ", " + getSalary() + "]";
  }
}