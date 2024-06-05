package com.example.aasha.controler;

import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.dto.RoomDTO;
import com.example.aasha.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin
public class RoomController {
    @Autowired
    RoomService roomService;


    @PostMapping("/save")
    public ResponseEntity saveRoom(@RequestBody RoomDTO roomDTO){
        ResponseDTO responseDTO =  roomService.saveRoom(roomDTO);
        System.out.println(responseDTO.getContent());
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @GetMapping( "/get")
    public ResponseEntity getRoom (){
        ResponseDTO responseDTO = roomService.getRoom();
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRoom(@PathVariable Long id){
        ResponseDTO responseDTO = roomService.deleteRoom(id);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }
}
