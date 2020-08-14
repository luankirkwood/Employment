package org.softwire.training.app;

import org.flywaydb.core.Flyway;
import org.softwire.training.Properties.Credentials;
import org.softwire.training.models.Employees;
import org.softwire.training.models.Pension;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws SQLException, java.io.IOException {

    Credentials credentials = new Credentials().getCredentials();

    Flyway flyway = Flyway.configure().dataSource(
      credentials.getUrl(),
      credentials.getUser(),
      credentials.getPassword()).load();
    flyway.migrate();

    displayEmployeesDirectFromDatabase();
    displayEmployeesFirstNamesWithHql();
    getEmployeeWithSql();
    getEmployeeWithoutSql();
    updateEmployeeWithSql();
    updateEmployeeWithoutSql();
//    listEmployeesDetailsWithHql();
    updateEmployeePensionWithSql();
  }

  private static void displayEmployeesDirectFromDatabase() throws SQLException, java.io.IOException {
    System.out.println("Direct Access Employees");
    List<String> employeeNames = new DirectAccess().getAllEmployeeNames();
    System.out.println(employeeNames);
    System.out.println();
  }

  private static void displayEmployeesFirstNamesWithHql() {
    System.out.println("ORM Access with HQL");
    List<Employees> employees = new OrmAccess().getAllEmployeesWithHql();
    System.out.println(Arrays.toString(employees.stream().map(Employees::getFirstName).toArray()));
    System.out.println();
  }

  private static void getEmployeeWithSql() {
    System.out.println("ORM access with SQL");
    System.out.println(new OrmAccess().getEmployeeWithSql(4).toArrayString());
    System.out.println();
  }

  private static void getEmployeeWithoutSql() {
    System.out.println("ORM access without SQL");
    Employees employees = new OrmAccess().getEmployeeWithoutSql(4);
    System.out.println(employees.toArrayString());
    System.out.println();
  }

  private static void updateEmployeeWithSql() {
    System.out.println("ORM update with SQL");
    OrmAccess ormAccess = new OrmAccess();
    Employees employees = new OrmAccess().getEmployeeWithoutSql(2);
    System.out.println(employees.toArrayString());
    employees.setAge(employees.getAge() + 1);
    ormAccess.updateEmployeeWithSql(employees);
    System.out.println(employees.toArrayString());
    System.out.println();
  }

  private static void updateEmployeeWithoutSql() {
    System.out.println("ORM update without SQL");
    OrmAccess ormAccess = new OrmAccess();
    Employees employees = new OrmAccess().getEmployeeWithoutSql(3);
    System.out.println(employees.toArrayString());
    employees.setAge(employees.getAge() + 1);
    ormAccess.updateEmployeeWithoutSql(employees);
    System.out.println(ormAccess.getEmployeeWithoutSql(3).toArrayString());
    System.out.println();
  }

  private static void listEmployeesDetailsWithHql() {
    System.out.println("ORM List Details with HQL");

    for (int i = 1; i < 8; i ++) {
      List<Employees> employees = new OrmAccess().listEmployeesWithHql(i);
      System.out.println(Arrays.toString(employees.toArray()));
    }
  }

  private static void updateEmployeePensionWithSql() {
    System.out.println("ORM update with SQL");
    OrmAccess ormAccess = new OrmAccess();
    Pension pension = new OrmAccess().getEmployeePensionWithSql(3);
    System.out.println(pension);
    pension.setAmountContributed(pension.getContributionAmount() + 1000);
    ormAccess.updateEmployeePensionWithSql(pension);
    System.out.println(pension);
    System.out.println();
  }
}