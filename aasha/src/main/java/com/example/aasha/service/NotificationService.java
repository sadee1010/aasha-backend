package com.example.aasha.service;

import com.example.aasha.dto.NotificationDTO;
import com.example.aasha.entity.Notification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {
    List<Notification> getAllNotifications();

    Notification getNotificationById(Long id);

    Notification saveNotification(Notification notification);

    Notification updateNotification(Long id, Notification notification);

    void deleteNotification(Long id);

    public NotificationDTO convertToDTO(Notification notification);
}
