package com.apijava.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.apijava.persistence.entities.Topic;
import com.apijava.services.TopicService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("topics")
public final class TopicsController {

  private final TopicService topicService;

  public TopicsController(TopicService topicService) {
    this.topicService = topicService;
  }

  @GetMapping(produces = "application/json")
  public List<Topic> getAllTopics() {
    var topics = topicService.getAllTopics();
    return topics;
  }

  @GetMapping(path = "/{id}", produces = "application/json")
  public Topic getTopicById(@PathVariable UUID id) {
    return topicService.getTopicById(id);
  }

  @PostMapping(produces = "application/json")
  public Topic postTopic(@RequestBody Topic topic) {
    return topicService.createTopic(topic);
  }

}
