package com.example.aasha.controler;

import com.example.aasha.dto.RoomDTO;
import com.example.aasha.entity.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface RoomController {

    @GetMapping("/room")
    ResponseEntity<List<RoomDTO>> getAllRooms();

    @GetMapping("/room/{id}")
    ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id);

    @PostMapping("/room")
    ResponseEntity<RoomDTO> saveRoom(@RequestBody Room room);

    @PutMapping("/room/{id}")
    ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody Room room);

    @DeleteMapping("/room/{id}")
    ResponseEntity<Void> deleteRoom(@PathVariable Long id);

}
