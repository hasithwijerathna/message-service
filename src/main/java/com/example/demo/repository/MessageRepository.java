package com.example.demo.repository;

import com.example.demo.model.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    public static List<Message> db = new ArrayList<>();

    public List<Message> getAllMessage() {
        return db;
    }

    public Message saveMessage(Message message) {
        db.add(message);
        return message;
    }

    public Message getMessageById(String id) {
        return db.stream()
                .filter(message -> message.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


}
