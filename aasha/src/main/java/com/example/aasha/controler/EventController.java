package com.example.aasha.controler;

import com.example.aasha.dto.EventDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.dto.RoomDTO;
import com.example.aasha.service.EventService;
import com.example.aasha.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/events")
@CrossOrigin
public class EventController {
    @Autowired
    EventService eventService;


    @PostMapping("/save")
    public ResponseEntity saveEvent(@RequestBody EventDTO eventDTO){
        ResponseDTO responseDTO =  eventService.saveEvent(eventDTO);
        System.out.println(responseDTO.getContent());
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @GetMapping( "/get")
    public ResponseEntity getEvent (){
        ResponseDTO responseDTO = eventService.getEvent();
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEvent(@PathVariable Long id){
        ResponseDTO responseDTO = eventService.deleteEvent(id);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }
}
