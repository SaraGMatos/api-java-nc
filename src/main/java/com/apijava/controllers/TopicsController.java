package com.apijava.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.apijava.persistence.entities.Topic;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("topics")
public final class TopicsController {

  @GetMapping(produces = "application/json")
  public List<Topic> getAllTopics() {
    return List.of(new Topic("Dogs", "We all like them"));
  }

  @GetMapping(path = "/{id}", produces = "application/json")
  public Topic getTopicById(@PathVariable UUID id) {
    return new Topic("Mocha", "The best sausage");
  }
}
