package com.apijava.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.apijava.persistence.entities.Topic;
import com.apijava.persistence.repositories.TopicRepository;

@Service
public class TopicService {

  private final TopicRepository topicRepository;

  public TopicService(TopicRepository topicRepository) {
    this.topicRepository = topicRepository;
  }

  public List<Topic> getAllTopics() {
    return List.of(new Topic("Dogs", "We all like them"));
  }

  public Topic createTopic(Topic topic) {
    var maybeTopic = this.topicRepository.getTopicBySlug(topic.getSlug());

    if (Objects.isNull(maybeTopic)) {
      return this.topicRepository.addTopic(topic);
    }

    return topic;
  }
}