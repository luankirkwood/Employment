package org.softwire.training.models;

import javax.persistence.*;

@Entity
@Table(name = "pensions")

public class Pension {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "employee_id", nullable = false)
  private int employeeId;

  @Column(name = "contribution_amount", nullable = false)
  private int contributionAmount;

  @Column(name = "pension_provider", nullable = false)
  private String pensionProvider;

  public Pension() {
  }

  public Pension(int employeeId, int contributionAmount, String pensionProvider) {
    this.employeeId = employeeId;
    this.contributionAmount = contributionAmount;
    this.pensionProvider = pensionProvider;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employee_id) {
    this.employeeId = employee_id;
  }

  public int getContributionAmount() {
    return contributionAmount;
  }

  public void setAmountContributed(int contributionAmount) {
    this.contributionAmount = contributionAmount;
  }

  public String getPensionProvider() {
    return pensionProvider;
  }

  public void setPensionProvider(String pensionProvider) {
    this.pensionProvider = pensionProvider;
  }
}
