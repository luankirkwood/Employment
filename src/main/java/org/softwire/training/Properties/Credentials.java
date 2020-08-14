package org.softwire.training.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class Credentials {

  String url;
  String user;
  String password;

  public Credentials() {
  }

  public Credentials(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Credentials getCredentials() throws IOException {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    return mapper.readValue(new File("src/main/resources/credentials.yml"), Credentials.class);
  }
}