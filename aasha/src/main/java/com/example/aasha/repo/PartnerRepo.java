package com.example.aasha.repo;

import com.example.aasha.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepo extends JpaRepository <Partner, Long> {
}
