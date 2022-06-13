package com.example.demo.controllers;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping()
    public List<Message> getMessage() {
        return messageService.getAllMessage();
    }

    @PostMapping()
    public ResponseEntity<Message> createMessage(@RequestBody Message message){
        return ResponseEntity.ok(messageService.saveMessage(message));
    }


}
