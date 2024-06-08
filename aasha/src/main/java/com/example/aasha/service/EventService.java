package com.example.aasha.service;

import com.example.aasha.dto.EventDTO;
import com.example.aasha.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    List<Event> getAllEvents();
    Event getEventById(Long id);
    Event saveEvent(Event event);
    Event updateEvent(Long id, Event event);
    void deleteEvent(Long id);
    public EventDTO convertToDTO(Event event);

}
