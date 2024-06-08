package com.example.aasha.service;

import com.example.aasha.dto.RoomDTO;
import com.example.aasha.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    List<Room> getAllRooms();

    Room getRoomById(Long id);

    Room saveRoom(Room room);

    Room updateRoom(Long id, Room room);

    void deleteRoom(Long id);

    public RoomDTO convertToDTO(Room room);

}
