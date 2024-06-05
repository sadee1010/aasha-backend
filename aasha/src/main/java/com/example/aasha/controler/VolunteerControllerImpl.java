package com.example.aasha.controler;

import com.example.aasha.dto.ResponseDTO;
import com.example.aasha.dto.VolunteerDTO;
import com.example.aasha.entity.Volunteer;
import com.example.aasha.service.VolunteerService;
import com.example.aasha.service.VolunteerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VolunteerControllerImpl implements VolunteerController{

    private final VolunteerService volunteerService;

    @Autowired
    public VolunteerControllerImpl(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    @Override
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        return ResponseEntity.status(HttpStatus.OK).body(volunteerService.getAllVolunteers());
    }

    @Override
    public ResponseEntity<Volunteer> getVolunteerById(@PathVariable Long id) {
        Volunteer volunteer = volunteerService.getVolunteerById(id);
        return ResponseEntity.status(HttpStatus.OK).body(volunteer);
    }

    @Override
    public ResponseEntity<Volunteer> saveVolunteer(@RequestBody Volunteer volunteer) {
        Volunteer newVolunteer = volunteerService.addVolunteer(volunteer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVolunteer);
    }

    @Override
    public ResponseEntity<Volunteer> updateVolunteer(@PathVariable Long id, @RequestBody Volunteer volunteer) {
        Volunteer updatedVolunteer = volunteerService.updateVolunteer(id, volunteer);
        return ResponseEntity.status(HttpStatus.OK).body(updatedVolunteer);
    }

//    @Override
//    public ResponseEntity<Void> deleteVolunteer(@PathVariable Long id) {
//        volunteerService.deleteVolunteer(id);
//        return ResponseEntity.status(HttpStatus.OK).body(null);
//     }

}
//    @Autowired
//    VolunteerServiceImpl volunteerService;
//
//
//    @PostMapping("/save")
//    public ResponseEntity saveVolunteer(@RequestBody VolunteerDTO volunteerDTO){
//        ResponseDTO responseDTO =  volunteerService.saveVolunteer(volunteerDTO);
//        System.out.println(responseDTO.getContent());
//        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
//    }
//
//    @GetMapping ( "/getVolunteer")
//    public ResponseEntity getVolunteer (){
//        ResponseDTO responseDTO = volunteerService.getVolunteer();
//        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity deleteVolunteer(@PathVariable Long id){
//        ResponseDTO responseDTO = volunteerService.deleteVolunteer(id);
//        return new ResponseEntity(responseDTO,responseDTO.getHttpStatus());
//    }


