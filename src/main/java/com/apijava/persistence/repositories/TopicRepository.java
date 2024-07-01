package com.apijava.persistence.repositories;

import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import com.apijava.persistence.entities.Topic;

@Repository
public final class TopicRepository {

  private final List<Topic> inMemoryTopics = List.of();

  @Nullable
  public Topic getTopicBySlug(String slug) {
    for (var topic : inMemoryTopics) {
      if (topic.getSlug() == slug) {
        return topic;
      }
    }
    return null;
  }

  public Topic addTopic(Topic topic) {
    inMemoryTopics.add(topic);
    return topic;
  }
}
