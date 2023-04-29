package com.geekster.University.Event.Management.controller;

import com.geekster.University.Event.Management.models.EventModel;
import com.geekster.University.Event.Management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EventController {

    @Autowired
    EventService eventService;
    @PostMapping("/addEvent")
    public String AddEvent(@RequestBody ArrayList<EventModel> eventList){
        return  eventService.eventDetails(eventList);
    }
    @PutMapping("/updateLocation/{id}/{location}")
    public void updateLocation(@PathVariable Integer id , @PathVariable String location ){
        eventService.udateEventDetails(id , location);
    }
    @DeleteMapping("/deleteEvent/{id}")
    public void deleteEvent(@PathVariable int id){
        eventService.deleteEventDetails(id);
    }

    @GetMapping("/getAllEventByDate/{date}")
    public  ArrayList<EventModel> getAllEventByDate(@PathVariable String date){
        return eventService.allEventByDate(date);
    }
}
