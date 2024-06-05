package com.example.aasha.service;

import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.dto.RoomDTO;
import com.example.aasha.entity.Room;
import com.example.aasha.repo.RoomRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomService {
    @Autowired
    RoomRepo roomRepo;
    @Autowired
    ModelMapper modelMapper;

    public ResponseDTO saveRoom(RoomDTO roomDTO){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Room room = modelMapper.map(roomDTO, Room.class);

            roomRepo.save(room);
            responseDTO.setContent(roomDTO);
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
    public ResponseDTO getRoom (){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            List<Room> room = roomRepo.findAll();
            List<RoomDTO> roomDTOList = new ArrayList<>();
            for(Room room1: room){
                RoomDTO roomDTO = modelMapper.map(room1, RoomDTO.class);
                roomDTOList.add(roomDTO);
            }
            responseDTO.setContent(roomDTOList);
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

    public ResponseDTO deleteRoom (Long id){
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            roomRepo.deleteById(id);
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
