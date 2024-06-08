package com.example.aasha.service;

import com.example.aasha.dto.RoomDTO;
import com.example.aasha.entity.Room;
import com.example.aasha.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomServiceImpl implements RoomService{
    private RoomRepo roomRepo;

    @Autowired
    public RoomServiceImpl(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Room not found with " + id));
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepo.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Room not found with id " + id));

        existingRoom.setRname(updatedRoom.getRname());
        existingRoom.setCapacity(updatedRoom.getCapacity());

        return roomRepo.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepo.deleteById(id);
    }

    @Override
    public RoomDTO convertToDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRid(room.getRid());
        roomDTO.setRname(room.getRname());
        roomDTO.setCapacity(room.getCapacity());
        return roomDTO;
    }
}
