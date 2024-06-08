package com.example.aasha.controler;

import com.example.aasha.dto.EventDTO;
import com.example.aasha.entity.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface EventController {

    @GetMapping("/events")
    ResponseEntity<List<EventDTO>> getAllEvents();

    @GetMapping("/events/{id}")
    ResponseEntity<EventDTO> getEventById(@PathVariable Long id);

    @PostMapping("/events")
    ResponseEntity<EventDTO> saveEvent(@RequestBody Event event);

    @PutMapping("/events/{id}")
    ResponseEntity<EventDTO> updateEvent(@PathVariable Long id, @RequestBody Event event);

    @DeleteMapping("/events/{id}")
    ResponseEntity<Void> deleteEvent(@PathVariable Long id);

}
