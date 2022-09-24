package com.fastforward.ameffjava.repository.impl;

import com.fastforward.ameffjava.config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {

  private final DatabaseConfig databaseConfig;

  @Autowired
  public ConnectionFactory(DatabaseConfig databaseConfig) {
    this.databaseConfig = databaseConfig;
  }

  public Connection getConnection() throws SQLException {
    var connection = DriverManager.getConnection(databaseConfig.getUrl(), databaseConfig.getUsername(), databaseConfig.getPassword());

    connection.setAutoCommit(true);
    return connection;
  }
}
