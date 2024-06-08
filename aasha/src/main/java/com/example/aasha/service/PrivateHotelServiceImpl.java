package com.example.aasha.service;

import com.example.aasha.dto.PrivateHotelDTO;
import com.example.aasha.entity.PrivateHotel;
import com.example.aasha.repo.PrivateHotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PrivateHotelServiceImpl implements PrivateHotelService{
    private PrivateHotelRepo privateHotelRepo;

    @Autowired
    public PrivateHotelServiceImpl(PrivateHotelRepo privateHotelRepo) {
        this.privateHotelRepo = privateHotelRepo;
    }

    @Override
    public List<PrivateHotel> getAllPrivateHotels() {
        return privateHotelRepo.findAll();
    }

    @Override
    public PrivateHotel getPrivateHotelById(Long id) {
        return privateHotelRepo.findById(id).orElseThrow(() -> new NoSuchElementException("PrivateHotel not found with " + id));
    }

    @Override
    public PrivateHotel savePrivateHotel(PrivateHotel privateHotel) {
        return privateHotelRepo.save(privateHotel);
    }

    @Override
    public PrivateHotel updatePrivateHotel(Long id, PrivateHotel updatedPrivateHotel) {
        PrivateHotel existingPrivateHotel = privateHotelRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("PrivateHotel not found with id " + id));

        existingPrivateHotel.setPhName(updatedPrivateHotel.getPhName());
        return privateHotelRepo.save(existingPrivateHotel);
    }

    @Override
    public void deletePrivateHotel(Long id) {
        privateHotelRepo.deleteById(id);
    }

    @Override
    public PrivateHotelDTO convertToDTO(PrivateHotel privateHotel) {
        PrivateHotelDTO privateHotelDTO = new PrivateHotelDTO();
        privateHotelDTO.setPhId(privateHotel.getPhId());
        privateHotelDTO.setPhName(privateHotel.getPhName());
        return privateHotelDTO;
    }

}
