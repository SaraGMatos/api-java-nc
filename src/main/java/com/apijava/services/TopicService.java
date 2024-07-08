package com.apijava.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.apijava.exceptions.NotFoundException;
import com.apijava.persistence.entities.Topic;
import com.apijava.persistence.repositories.NewTopicRepository;

@Service
public class TopicService {

  private final NewTopicRepository newTopicRepository;

  public TopicService(NewTopicRepository newTopicRepository) {
    this.newTopicRepository = newTopicRepository;
  }

  public List<Topic> getAllTopics() {
    return newTopicRepository.findAll();
  }

  public Topic getTopicById(UUID id) throws NotFoundException {

    var maybeTopic = this.newTopicRepository.findById(id);

    if (maybeTopic.isPresent()) {
      return maybeTopic.get();
    }

    throw new NotFoundException("Topic with id " + id + " not found.");

  }

  public Topic createTopic(Topic topic) {
    var maybeTopic = this.newTopicRepository.findBySlug(topic.getSlug());

    if (maybeTopic.isPresent()) {
      return maybeTopic.get();
    }

    return this.newTopicRepository.save(topic);
  }
}
