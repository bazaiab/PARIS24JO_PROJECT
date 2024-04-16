package com.paris.jo.web;

import com.paris.jo.entities.Event;
import com.paris.jo.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EventController {

    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public List<Event> eventList(){
        return eventRepository.findAll();
    }


    @GetMapping("/events/{id}")
    public Event eventById(@PathVariable(name = "id") Long id){
        return eventRepository.findById(id).orElse(null);
    }
}
