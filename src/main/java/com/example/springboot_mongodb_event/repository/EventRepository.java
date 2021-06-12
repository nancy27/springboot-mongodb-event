package com.example.springboot_mongodb_event.repository;


import com.example.springboot_mongodb_event.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends MongoRepository<Event,Integer> {


    Event findByEventId(Integer eventId);

    Event deleteByEventId(Integer eventId);
}
