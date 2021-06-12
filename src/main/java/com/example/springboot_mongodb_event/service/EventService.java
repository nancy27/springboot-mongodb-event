package com.example.springboot_mongodb_event.service;


import com.example.springboot_mongodb_event.model.Event;
import com.example.springboot_mongodb_event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }


    public Event getEvent(Integer eventId){

        Event optionalEvent= eventRepository.findByEventId(eventId);
//            Event event =optionalEvent.get(); Event event =optionalEvent.get();
        return optionalEvent;
    }


    public Event saveNewEvent(Event event) throws Exception {
        Event resultevent;
        if(checkEventAvailable(event.getEventId())){
            throw new Exception("Event Already exist");
        }else{
            resultevent= eventRepository.save(event);

        }
        return resultevent;
    }

    public boolean checkEventAvailable(Integer eventId){

        Optional<Event> optionalEvent= Optional.ofNullable(eventRepository.findByEventId(eventId));
        if (optionalEvent.isPresent()) {
            Event event= optionalEvent.get();
            return true;
        }
        return false;

    }
    public String deleteEvent(Integer eventId){
        Event deletedEvent=eventRepository.deleteByEventId(eventId);
        return "deleted Successfully";
    }
}
