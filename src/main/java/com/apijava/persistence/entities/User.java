package com.apijava.persistence.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(length = 30, nullable = false, unique = true)
  private String username;

  @Column(length = 50, nullable = false, unique = false)
  private String name;

  @Column(length = 50, nullable = false, unique = false)
  private String surname;

  @Column(nullable = true, unique = false)
  private String avatarUrl;

  public User(String newUsername, String newName, String newSurname, String newAvatarUrl) {
    this.username = newUsername;
    this.name = newName;
    this.surname = newSurname;
    this.avatarUrl = newAvatarUrl;
  }

  public UUID getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

}
