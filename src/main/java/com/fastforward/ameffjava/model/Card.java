package com.fastforward.ameffjava.model;

import java.time.LocalDateTime;

public class Card {

  private long id;

  private String name;

  private String description;

  private String imageUrl;

  private int strength;

  private int speed;

  private int skill;

  private int gear;

  private int intellect;

  private LocalDateTime createdAt;

  private LocalDateTime updateAt;

  private CardOrigin origin;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getSkill() {
    return skill;
  }

  public void setSkill(int skill) {
    this.skill = skill;
  }

  public int getGear() {
    return gear;
  }

  public void setGear(int gear) {
    this.gear = gear;
  }

  public int getIntellect() {
    return intellect;
  }

  public void setIntellect(int intellect) {
    this.intellect = intellect;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(LocalDateTime updateAt) {
    this.updateAt = updateAt;
  }

  public CardOrigin getOrigin() {
    return origin;
  }

  public void setOrigin(CardOrigin origin) {
    this.origin = origin;
  }

  @Override
  public String toString() {
    return "Card{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", imageUrl='" + imageUrl + '\'' +
        ", strength=" + strength +
        ", speed=" + speed +
        ", skill=" + skill +
        ", gear=" + gear +
        ", intellect=" + intellect +
        ", createdAt=" + createdAt +
        ", updateAt=" + updateAt +
        ", origin=" + origin +
        '}';
  }
}
