package com.apijava.persistence.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apijava.persistence.entities.Topic;

@Repository
public interface NewTopicRepository extends JpaRepository<Topic, UUID> {
  Optional<Topic> findBySlug(String slug);
}
