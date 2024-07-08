package com.apijava.persistence.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private UUID id;

  @Column
  private String slug;

  @Column
  private String description;

  public Topic(String newSlug, String newDescription) {
    this.slug = newSlug;
    this.description = newDescription;
  }

  public Topic() {

  }

  public UUID getId() {
    return id;
  }

  public String getSlug() {
    return slug;
  }

  public String getDescription() {
    return description;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
