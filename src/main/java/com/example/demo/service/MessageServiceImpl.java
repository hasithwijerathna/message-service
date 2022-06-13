package com.example.demo.service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MessageServiceImpl implements MessageService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessage() {
        return messageRepository.getAllMessage();
    }

    @Override
    public Message saveMessage(Message message) {
        logger.info("Going to start message saving...");

        if(message.getId() == null){
            message.setId(UUID.randomUUID().toString());
        }

        if(messageRepository.getAllMessage().stream()
                .anyMatch(msg -> msg.getId().equals(message.getId()))){

            logger.error("Cannot add message with duplicate id: {}", message.getId());
            throw new BadRequestException("Cannot add message with duplicate id.");
        }

        logger.info("Your message successfully saved in the DB with id: {}", message.getId());
        return messageRepository.saveMessage(message);
    }
}
