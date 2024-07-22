package com.conta.azul.nasa.robo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.conta.azul.nasa.robo.enums.Orientation;
import com.conta.azul.nasa.robo.movementsdto.Position;
import com.conta.azul.nasa.robo.service.MoveRobotService;

@ExtendWith(SpringExtension.class)
public class MoveRobotControllerTest {

    @Mock
    MoveRobotService moveRobotService;

    @InjectMocks
    private MoveRobotController moveRobotController;
    
    @Test
    public void responseOk() throws Exception{
        String commands = "MML";
        when(moveRobotService.moveRobot(commands)).thenReturn(Position.builder().positionX(0).positionY(2).orientation(Orientation.WEST).build());
        ResponseEntity<String> response = moveRobotController.commandsForRobot(commands);
        assertEquals(response,ResponseEntity.ok("(0,2,W)"));
    }
}
