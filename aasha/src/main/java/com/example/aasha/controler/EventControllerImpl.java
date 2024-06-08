package com.example.aasha.controler;

import com.example.aasha.dto.EventDTO;
import com.example.aasha.entity.Event;
import com.example.aasha.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventControllerImpl implements EventController {

    private final EventService eventService;

    @Autowired
    public EventControllerImpl(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> eventDTOs = eventService.getAllEvents()
                .stream()
                .map(eventService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(eventDTOs);
    }

    @Override
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO eventDTO = eventService.convertToDTO(eventService.getEventById(id));
        return ResponseEntity.status(HttpStatus.OK).body(eventDTO);
    }

    @Override
    public ResponseEntity<EventDTO> saveEvent(@RequestBody Event event) {
        Event newEvent = eventService.saveEvent(event);
        EventDTO newEventDTO = eventService.convertToDTO(newEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEventDTO);
    }

    @Override
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(id, event);
        EventDTO updatedEventDTO = eventService.convertToDTO(updatedEvent);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEventDTO);
    }

    @Override
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
