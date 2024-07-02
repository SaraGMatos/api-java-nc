package com.apijava.services;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.apijava.exceptions.NotFoundException;
import com.apijava.persistence.entities.Topic;
import com.apijava.persistence.repositories.TopicRepository;

@Service
public class TopicService {

  private final TopicRepository topicRepository;

  public TopicService(TopicRepository topicRepository) {
    this.topicRepository = topicRepository;
  }

  public List<Topic> getAllTopics() {
    return this.topicRepository.getAllTopics();
  }

  public Topic getTopicById(UUID id) throws NotFoundException {

    var maybeTopic = this.topicRepository.getTopicById(id);

    if (maybeTopic.isPresent()) {
      return maybeTopic.get();
    }

    throw new NotFoundException("Topic with id " + id + " not found.");

  }

  public Topic createTopic(Topic topic) {
    var maybeTopic = this.topicRepository.getTopicBySlug(topic.getSlug());

    if (Objects.isNull(maybeTopic)) {
      return this.topicRepository.addTopic(topic);
    }

    return topic;
  }
}
