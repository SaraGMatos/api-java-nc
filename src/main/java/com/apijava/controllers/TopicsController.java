package com.apijava.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.apijava.persistence.entities.Topic;
import com.apijava.services.TopicService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("topics")
public class TopicsController {

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
  public ResponseEntity<Topic> postTopic(@RequestBody Topic topic) {

    Topic newTopic = topicService.createTopic(topic);

    return ResponseEntity
        .created(URI.create("/topics/%s".formatted(newTopic.getId())))
        .body(newTopic);
  }

  @DeleteMapping(path = "/{id}", produces = "application/json")
  public ResponseEntity<Void> deleteTopicById(@PathVariable UUID id) {
    topicService.removeTopicById(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Topic> patchTopicById(@PathVariable UUID id, @RequestBody Topic topic) {

    return ResponseEntity.ok(topicService.updateTopicById(id, topic));
  }

}
