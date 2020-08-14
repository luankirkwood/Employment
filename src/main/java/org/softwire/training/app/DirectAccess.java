package org.softwire.training.app;

import org.softwire.training.Properties.Credentials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectAccess {

  List<String> getAllEmployeeNames() throws SQLException, java.io.IOException {
    Credentials credentials = new Credentials().getCredentials();

    try
    {
      Connection connection = DriverManager.getConnection(credentials.getUrl(),credentials.getUser(),credentials.getPassword());
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT first_name FROM employees");
      List<String> names = new ArrayList<>();
      while (resultSet.next()) {
        names.add(resultSet.getString("first_name"));
      }
      return names;
    }
    catch (Exception e)
    {
      System.err.println("noooooooooooooooooooo");
      System.err.println(e.getMessage());
      throw e;
    }
  }

}