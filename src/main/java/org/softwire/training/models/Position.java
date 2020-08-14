package org.softwire.training.models;

import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {

  @Id
  @Column(name = "job_id", nullable = false)
  private String position;

  @Column(name = "job_name", nullable = false)
  private int company_rank;

  public Position() {
  }

  public Position(String position, int company_rank) {
    this.position = position;
    this.company_rank = company_rank;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getCompany_rank() {
    return company_rank;
  }

  public void setCompany_rank(int company_rank) {
    this.company_rank = company_rank;
  }
}