package com.example.aasha.controler;

import com.example.aasha.dto.NotificationDTO;
import com.example.aasha.entity.Notification;
import com.example.aasha.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class NotificationControllerImpl implements NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationControllerImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public ResponseEntity<List<NotificationDTO>> getAllNotifications() {
        List<NotificationDTO> notificationDTOs = notificationService.getAllNotifications()
                .stream()
                .map(notificationService::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(notificationDTOs);
    }

    @Override
    public ResponseEntity<NotificationDTO> getNotificationById(Long id) {
        NotificationDTO notificationDTO = notificationService.convertToDTO(notificationService.getNotificationById(id));
        return ResponseEntity.status(HttpStatus.OK).body(notificationDTO);
    }

    @Override
    public ResponseEntity<NotificationDTO> saveNotification(Notification notification) {
        Notification newNotification = notificationService.saveNotification(notification);
        NotificationDTO newNotificationDTO = notificationService.convertToDTO(newNotification);
        return ResponseEntity.status(HttpStatus.CREATED).body(newNotificationDTO);
    }

    @Override
    public ResponseEntity<NotificationDTO> updateNotification(Long id, Notification notification) {
        Notification updatedNotification = notificationService.updateNotification(id, notification);
        NotificationDTO updatedNotificationDTO = notificationService.convertToDTO(updatedNotification);
        return ResponseEntity.status(HttpStatus.OK).body(updatedNotificationDTO);
    }

    @Override
    public ResponseEntity<Void> deleteNotification(Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
