package org.softwire.training.models;

import javax.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {

  @Id
  @Column(name = "provider", nullable = false)
  private String provider;

  public Provider() {
  }

  public Provider(String provider) {
    this.provider = provider;
  }

  public String getProvider() {
    return provider;
  }

  public void setProvider(String provider) {
    this.provider = provider;
  }
}