package com.fastforward.ameffjava.config;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

  private static final Logger LOG = LogManager.getLogger(DatabaseConfig.class);

  @Value("${database.url}")
  private String url;

  @Value("$database.username")
  private String username;

  @Value("$database.password")
  private String password;

  public String getUrl() {
    return url;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
