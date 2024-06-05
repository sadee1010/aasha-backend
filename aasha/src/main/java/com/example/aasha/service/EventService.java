package com.example.aasha.service;

import com.example.aasha.dto.EventDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.entity.Event;
import com.example.aasha.repo.EventRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;
    @Autowired
    ModelMapper modelMapper;

    public ResponseDTO saveEvent(EventDTO eventDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Event event = modelMapper.map(eventDTO, Event.class);

            eventRepo.save(event);
            responseDTO.setContent(eventDTO);
            responseDTO.setResponseMsg("success");
            responseDTO.setResponseCode("00");
            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("Failed");
            responseDTO.setResponseCode("99");
            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
        }

        return responseDTO;
    }

    public ResponseDTO getEvent (){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<Event> event = eventRepo.findAll();
            List<EventDTO> eventDTOList = new ArrayList<>();
            for (Event event1: event) {
                EventDTO eventDTO = modelMapper.map(event1, EventDTO.class);
                eventDTOList.add(eventDTO);
            }
            responseDTO.setContent(eventDTOList);
            responseDTO.setResponseMsg("success");
            responseDTO.setResponseCode("00");
            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("Failed");
            responseDTO.setResponseCode("99");
            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }

    public ResponseDTO deleteEvent (Long id){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            eventRepo.deleteById(id);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("success");
            responseDTO.setResponseCode("00");
            responseDTO.setHttpStatus(HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e);
            responseDTO.setContent(null);
            responseDTO.setResponseMsg("Failed");
            responseDTO.setResponseCode("99");
            responseDTO.setHttpStatus(HttpStatus.CONFLICT);
        }
        return responseDTO;
    }
}
