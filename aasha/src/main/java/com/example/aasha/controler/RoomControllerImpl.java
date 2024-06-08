package com.example.aasha.controler;

import com.example.aasha.dto.RoomDTO;
import com.example.aasha.entity.Room;
import com.example.aasha.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RoomControllerImpl implements RoomController{
    private final RoomService roomService;

    @Autowired
    public RoomControllerImpl(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public ResponseEntity<List<RoomDTO>> getAllRooms() {
        List<RoomDTO> roomDTOs = roomService.getAllRooms()
                .stream()
                .map(roomService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(roomDTOs);
    }

    @Override
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
        RoomDTO roomDTO = roomService.convertToDTO(roomService.getRoomById(id));
        return ResponseEntity.status(HttpStatus.OK).body(roomDTO);
    }

    @Override
    public ResponseEntity<RoomDTO> saveRoom(@RequestBody Room room) {
        Room newRoom = roomService.saveRoom(room);
        RoomDTO newRoomDTO = roomService.convertToDTO(newRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoomDTO);
    }

    @Override
    public ResponseEntity<RoomDTO> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(id, room);
        RoomDTO updatedRoomDTO = roomService.convertToDTO(updatedRoom);
        return ResponseEntity.status(HttpStatus.OK).body(updatedRoomDTO);
    }

    @Override
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
