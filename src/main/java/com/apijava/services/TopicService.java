package com.apijava.services;

import java.util.List;
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
    return topicRepository.findAll();
  }

  public Topic getTopicById(UUID id) throws NotFoundException {

    var maybeTopic = this.topicRepository.findById(id);

    if (maybeTopic.isPresent()) {
      return maybeTopic.get();
    }

    throw new NotFoundException("Topic with id " + id + " not found.");

  }

  public Topic createTopic(Topic topic) {
    var maybeTopic = this.topicRepository.findBySlug(topic.getSlug());

    if (maybeTopic.isPresent()) {
      return maybeTopic.get();
    }

    return this.topicRepository.save(topic);
  }

  public void removeTopicById(UUID id) {

    var maybeTopic = this.topicRepository.findById(id);

    if (maybeTopic.isPresent()) {
      this.topicRepository.deleteById(id);
    } else {
      throw new NotFoundException("Topic with id " + id + " not found.");
    }

  }

  public Topic updateTopicById(UUID id, Topic topic) throws NotFoundException {
    var maybeTopic = this.topicRepository.findById(id);

    if (maybeTopic.isPresent()) {
      maybeTopic.get().copyFrom(topic);
      return this.topicRepository.saveAndFlush(maybeTopic.get());
    }

    throw new NotFoundException("Topic with id " + id + " not found.");

  }
}
