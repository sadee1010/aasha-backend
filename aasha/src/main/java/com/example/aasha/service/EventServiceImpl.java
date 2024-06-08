package com.example.aasha.service;

import com.example.aasha.dto.EventDTO;
import com.example.aasha.entity.Event;
import com.example.aasha.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EventServiceImpl implements EventService {

    private EventRepo eventRepo;

    @Autowired
    public EventServiceImpl(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Event not found with " + id));
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = eventRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Event not found with id " + id));

        existingEvent.setEventTitle(updatedEvent.getEventTitle());
        existingEvent.setDate(updatedEvent.getDate());
        existingEvent.setCategory(updatedEvent.getCategory());
        existingEvent.setStartTime(updatedEvent.getStartTime());
        existingEvent.setEndTime(updatedEvent.getEndTime());

        return eventRepo.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);
    }

    @Override
    public EventDTO convertToDTO(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEid(event.getEid());
        eventDTO.setEventTitle(event.getEventTitle());
        eventDTO.setDate(event.getDate());
        eventDTO.setCategory(event.getCategory());
        eventDTO.setStartTime(event.getStartTime());
        eventDTO.setEndTime(event.getEndTime());

        return eventDTO;
    }

}
