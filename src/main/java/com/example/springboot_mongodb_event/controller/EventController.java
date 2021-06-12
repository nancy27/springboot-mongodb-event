package com.example.springboot_mongodb_event.controller;

import com.example.springboot_mongodb_event.model.Event;
import com.example.springboot_mongodb_event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class EventController {
    @Autowired
    EventService eventService;

    @RequestMapping("/events")
    public List<Event>  getAllEvents(){
        List<Event>  allEvent= eventService.getAllEvents();
        System.out.println(allEvent);
        return allEvent;
    }


    @RequestMapping("/events/{eventId}")
    public Event getEvent(@PathVariable Integer eventId){
        Event event=  eventService.getEvent(eventId);
        System.out.println(event);
        return event;
    }
    /*
    @RequestMapping(method = RequestMethod.PUT,value="/product/{productId}")
    public Product updateProductDetails(@RequestBody Product product, @PathVariable Integer productId) throws Exception{
        return productService.updateProductDetails(product,productId);
    }
     */

    @RequestMapping(method= RequestMethod.POST,value="/events")
    public Event saveNewEvent(@RequestBody Event event) throws Exception {

        Date createdDate= new Date();
        event.setCreatedDate(createdDate);
        long eventDate=new Date().getTime()+8*24*60*60*1000;
        Date ResultEvent=new Date(eventDate);
        event.setEventDate(ResultEvent);
        return eventService.saveNewEvent(event);
    }

    @RequestMapping(method= RequestMethod.PUT,value="/events")
    public Event UpdateNewEvent(@RequestBody Event event) throws Exception {

        Date createdDate= new Date();
        event.setCreatedDate(createdDate);
        if(event.getEventDate().equals("")){
            long eventDate=new Date().getTime()+8*24*60*60*1000;
            Date ResultEvent=new Date(eventDate);
            event.setEventDate(ResultEvent);
        }
        return eventService.saveNewEvent(event);
    }



    @RequestMapping(method=RequestMethod.DELETE,value="/events/{eventId}")
    public String deleteEvent(@PathVariable Integer eventId){
        return eventService.deleteEvent(eventId);

    }



}

