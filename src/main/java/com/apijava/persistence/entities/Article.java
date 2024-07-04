package com.apijava.persistence.entities;

import java.net.URI;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Articles")
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false, unique = true)
  private String title;

  private Topic topic;

  private User user;

  private String body;

  private Timestamp date;

  private int votes = 0;

  private URI articleImage;

}
