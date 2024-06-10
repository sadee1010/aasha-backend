package com.example.aasha.service;

import com.example.aasha.dto.NotificationDTO;
import com.example.aasha.entity.Notification;
import com.example.aasha.repo.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NotificationServiceImpl implements NotificationService{

    private NotificationRepo notificationRepo;

    @Autowired
    public NotificationServiceImpl(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }
    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepo.findAll();
    }

    @Override
    public Notification getNotificationById(Long id) {
        return notificationRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Notification not found with id " + id));
    }

    @Override
    public Notification saveNotification(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public Notification updateNotification(Long id, Notification updatedNotification) {
        Notification existingNotification = notificationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found with id " + id));

        existingNotification.setMessage(updatedNotification.getMessage());
        existingNotification.setDate(updatedNotification.getDate());

        return notificationRepo.save(existingNotification);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepo.deleteById(id);
    }

    @Override
    public NotificationDTO convertToDTO(Notification notification) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notification.getId());
        notificationDTO.setMessage(notification.getMessage());
        notificationDTO.setDate(notification.getDate());

        return notificationDTO;
    }


}
