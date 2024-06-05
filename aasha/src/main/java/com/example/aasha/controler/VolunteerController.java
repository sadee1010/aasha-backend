package com.example.aasha.controler;

import com.example.aasha.entity.Volunteer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface VolunteerController {

    @GetMapping("/volunteers")
    ResponseEntity<List<Volunteer>> getAllVolunteers();

    @GetMapping("/volunteers/{id}")
    ResponseEntity<Volunteer> getVolunteerById(@PathVariable Long id);

    @PostMapping("/volunteers")
    ResponseEntity<Volunteer> saveVolunteer(@RequestBody Volunteer volunteers);

    @PutMapping("volunteers/{id}")
    ResponseEntity<Volunteer> updateVolunteer(@PathVariable Long id,@RequestBody Volunteer volunteers);

//    @DeleteMapping("volunteers/{id}")
//    ResponseEntity<Void> deleteVolunteer(Long id);

}
