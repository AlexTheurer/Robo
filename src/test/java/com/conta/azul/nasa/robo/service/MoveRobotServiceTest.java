package com.conta.azul.nasa.robo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.conta.azul.nasa.robo.enums.Orientation;
import com.conta.azul.nasa.robo.exception.CommandNotFoundException;
import com.conta.azul.nasa.robo.exception.ManyMovementsException;
import com.conta.azul.nasa.robo.movementsdto.Position;

public class MoveRobotServiceTest {


    private final MoveRobotService moveRobotService = new MoveRobotService();


    @Test
    public void moveFowardAndTurnLeft() throws Exception {
        String coordinate = "MML";
        Position position = moveRobotService.moveRobot(coordinate);
        assertEquals(createObj("1"), position);
    }

    @Test
    public void moveFowardToSouth() throws Exception {
        String coordinate = "MMRMMRMM";
        Position position = moveRobotService.moveRobot(coordinate);
        assertEquals(createObj("2"), position);
    }

    @Test
    public void moveFoward() throws Exception {
        String coordinate = "MM";
        Position position = moveRobotService.moveRobot(coordinate);
        assertEquals(createObj("3").toString(), position.toString());
    }

    @Test
    public void moveFowardAndTurnRight() throws Exception {
        String coordinate = "MMR";
        Position position = moveRobotService.moveRobot(coordinate);
        assertEquals(createObj("4"), position);
    }

    @Test
    public void moveFowardToNorth() throws Exception {
        String coordinate = "MMRMMLMM";
        Position position = moveRobotService.moveRobot(coordinate);
        assertEquals(createObj("5"), position);
    }
    
    @Test
    public void moveFowardToWest() throws Exception {
        String coordinate = "MLMM";
        Position position = moveRobotService.moveRobot(coordinate);
        assertEquals(createObj("6"), position);
    }

    @Test
    public void compass() throws Exception {
        String coordinate = "LMRMRMLMLMRMLM";
        Position position = moveRobotService.moveRobot(coordinate);
        assertEquals(createObj("7"), position);
    }

    @Test
    public void comandoNotFoundException() throws Exception {
        String coordinate = "DDDDDD";
        assertThrows(CommandNotFoundException.class, () -> moveRobotService.moveRobot(coordinate));
    }

    @Test
    public void ManyMovementsException() throws Exception {
        String coordinate = "MMMMMMMMMMM";
        assertThrows(ManyMovementsException.class, () -> moveRobotService.moveRobot(coordinate));
    }

    private Position createObj(String test){
        return switch (test) {
            case "1" -> Position.builder().positionX(0).positionY(2).orientation(Orientation.WEST).build();
            case "2" -> Position.builder().positionX(2).positionY(0).orientation(Orientation.SOUTH).build();
            case "3" -> Position.builder().positionX(0).positionY(2).orientation(Orientation.NORTH).build();
            case "4" -> Position.builder().positionX(0).positionY(2).orientation(Orientation.EAST).build();
            case "5" -> Position.builder().positionX(2).positionY(4).orientation(Orientation.NORTH).build();
            case "6" -> Position.builder().positionX(-2).positionY(1).orientation(Orientation.WEST).build();
            case "7" -> Position.builder().positionX(-2).positionY(3).orientation(Orientation.WEST).build();
            default -> Position.builder().positionX(0).positionY(0).orientation(Orientation.NORTH).build();
        };
        
    }
}
