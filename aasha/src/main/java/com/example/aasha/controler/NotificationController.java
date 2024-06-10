package com.example.aasha.controler;

import com.example.aasha.dto.NotificationDTO;
import com.example.aasha.entity.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public interface NotificationController {

    @GetMapping("/notifications")
    ResponseEntity<List<NotificationDTO>> getAllNotifications();

    @GetMapping("/notifications/{id}")
    ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id);

    @PostMapping("/notifications")
    ResponseEntity<NotificationDTO> saveNotification(@RequestBody Notification notification);

    @PutMapping("/notifications/{id}")
    ResponseEntity<NotificationDTO> updateNotification(@PathVariable Long id,@RequestBody Notification notification);

    @DeleteMapping("/notifications/{id}")
    ResponseEntity<Void> deleteNotification(@PathVariable Long id);

}
