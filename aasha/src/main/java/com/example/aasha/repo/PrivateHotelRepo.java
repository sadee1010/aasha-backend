package com.example.aasha.repo;

import com.example.aasha.entity.PrivateHotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateHotelRepo extends JpaRepository<PrivateHotel, Long> {
}
