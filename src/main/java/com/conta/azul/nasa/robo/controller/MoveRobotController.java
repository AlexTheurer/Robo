package com.conta.azul.nasa.robo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conta.azul.nasa.robo.service.MoveRobotService;

@RestController
public class MoveRobotController {

    @Autowired
    private MoveRobotService moveRobotService;
    
    @PostMapping("/rest/mars/{commands}")
    public ResponseEntity<String> commandsForRobot(@PathVariable  String commands) {
        try {
            return ResponseEntity.ok(moveRobotService.moveRobot(commands).toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        }
        
    }
}
