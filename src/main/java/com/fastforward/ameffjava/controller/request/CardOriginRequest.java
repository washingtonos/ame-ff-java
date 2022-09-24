package com.fastforward.ameffjava.controller.request;

public class CardOriginRequest {

  private String name;

  private String description;

  private String creator;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  @Override
  public String toString() {
    return "CreateCardOriginRequest{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", create='" + creator + '\'' +
        '}';
  }
}
