package com.example.aasha.controler;

import com.example.aasha.dto.PartnerDTO;
import com.example.aasha.entity.Partner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface PartnerController {

    @GetMapping("/partners")
    ResponseEntity<List<PartnerDTO>> getAllPartners();

    @GetMapping("/partners/{id}")
    ResponseEntity<PartnerDTO> getPartnerById(@PathVariable Long id);

    @PostMapping("/partners")
    ResponseEntity<PartnerDTO> savePartner(@RequestBody Partner partner);

    @PutMapping("/partners/{id}")
    ResponseEntity<PartnerDTO> updatePartner(@PathVariable Long id, @RequestBody Partner partner);

    @DeleteMapping("/partners/{id}")
    ResponseEntity<Void> deletePartner(@PathVariable Long id);
}
