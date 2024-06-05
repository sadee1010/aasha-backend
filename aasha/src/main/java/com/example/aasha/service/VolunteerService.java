package com.example.aasha.service;

import com.example.aasha.entity.Volunteer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VolunteerService {

    List<Volunteer> getAllVolunteers();

    Volunteer getVolunteerById(Long id);

    Volunteer addVolunteer(Volunteer volunteer);

    Volunteer updateVolunteer(Long id, Volunteer volunteer);

    Volunteer deleteVolunteer(Long id);
}
