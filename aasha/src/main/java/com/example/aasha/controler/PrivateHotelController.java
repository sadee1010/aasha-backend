package com.example.aasha.controler;

import com.example.aasha.dto.PrivateHotelDTO;
import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.service.PrivateHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ( "/api/privatehotels")
@CrossOrigin
public class PrivateHotelController {
    @Autowired
    PrivateHotelService privateHotelService;


    @PostMapping("/save")
    public ResponseEntity savePrivateHotel(@RequestBody PrivateHotelDTO privateHotelDTO){
        ResponseDTO responseDTO =  privateHotelService.savePrivateHotel(privateHotelDTO);
        System.out.println(responseDTO.getContent());
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @GetMapping( "/get")
    public ResponseEntity getPrivateHotel (){
        ResponseDTO responseDTO = privateHotelService.getPrivateHotel();
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePrivateHotel(@PathVariable Long id){
        ResponseDTO responseDTO = privateHotelService.deletePrivateHotel(id);
        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
    }
}
