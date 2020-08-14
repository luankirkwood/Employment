package org.softwire.training.app;

import org.softwire.training.models.Employees;
import org.softwire.training.models.Pension;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

class OrmAccess {

  private final EntityManagerFactory entityManagerFactory;

  OrmAccess() {
    this.entityManagerFactory = Persistence.createEntityManagerFactory(
      "org.softwire.training");
  }

  List<Employees> getAllEmployeesWithHql() {
    EntityManager em = entityManagerFactory.createEntityManager();

    List<Employees> employees = em.createQuery("FROM Employees", Employees.class).getResultList();

    em.close();

    return employees;
  }

  Employees getEmployeeWithSql(int employee_id) {
    EntityManager em = entityManagerFactory.createEntityManager();

    List<Employees> results = em.createNativeQuery("SELECT * FROM employees WHERE employee_id=?1", Employees.class)
      .setParameter(1, employee_id)
      .getResultList();
    em.close();

    return results.isEmpty() ? null : results.get(0);
  }

  Employees getEmployeeWithoutSql(int id) {
    EntityManager em = entityManagerFactory.createEntityManager();

    Employees employees = em.find(Employees.class, id);

    em.close();

    return employees;
  }

  void updateEmployeeWithSql(Employees employees) {
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();

    em.createNativeQuery("UPDATE employees SET first_name=?1, last_name=?2, job_id=?3, age=?4, salary=?5 WHERE employee_id=?6")
      .setParameter(1, employees.getFirstName())
      .setParameter(2, employees.getLastName())
      .setParameter(3, employees.getJob_id())
      .setParameter(4, employees.getAge())
      .setParameter(5, employees.getSalary())
      .setParameter(6, employees.getEmployeeId())
      .executeUpdate();

    transaction.commit();
    em.close();
  }

  void updateEmployeeWithoutSql(Employees employees) {
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();

    em.merge(employees);

    transaction.commit();
    em.close();
  }

//  List<Employees> listEmployeesWithHql() {
//    EntityManager em = entityManagerFactory.createEntityManager();
//
////    List<Employees> employees = em.createNativeQuery("SELECT employees.first_name, employees.last_name, employees.age, employees.job_id, employees.salary, pensions.contribution_amount FROM employees JOIN pensions USING(employee_id)")
////      .getResultList();
//    List<Employees> employees = em.createQuery("FROM Employees", Employees.class).getResultList();
//
//    em.close();
//
//    return employees;
//  }

  List<Employees> listEmployeesWithHql(int employee_id) {
    EntityManager em = entityManagerFactory.createEntityManager();

    List<Employees> results = em.createNativeQuery("SELECT employees.first_name, employees.last_name, employees.age, employees.job_id, employees.salary, pensions.contribution_amount, pensions.provider FROM employments.employees JOIN employments.pensions ON (employee_id) WHERE employees.employee_id=?1 ", Employees.class)
      .setParameter(1, employee_id)
      .getResultList();
    em.close();

    return results;
  }

  Pension getEmployeePensionWithSql(int employee_id) {
    EntityManager em = entityManagerFactory.createEntityManager();

    List<Pension> pensions = em.createNativeQuery("SELECT * FROM pensions WHERE employee_id=?2", Pension.class)
      .setParameter(2, employee_id)
      .getResultList();
    em.close();

    return pensions.isEmpty() ? null : pensions.get(0);
  }

  void updateEmployeePensionWithSql(Pension pension) {
    EntityManager em = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();

    em.createNativeQuery("UPDATE pensions SET employee_id=?1, contribution_amount=?2, pension_provider=?3 WHERE employee_id=?1")
      .setParameter(1, pension.getEmployeeId())
      .setParameter(2, pension.getContributionAmount())
      .setParameter(3, pension.getPensionProvider())
      .executeUpdate();

    transaction.commit();
    em.close();
  }
}

