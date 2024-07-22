package com.conta.azul.nasa.robo.service;

import org.springframework.stereotype.Service;

import com.conta.azul.nasa.robo.enums.Orientation;
import com.conta.azul.nasa.robo.exception.CommandNotFoundException;
import com.conta.azul.nasa.robo.movementsdto.Position;

@Service
public class MoveRobotService {

    public Position moveRobot(String commands) throws Exception {
        
        Position currentPosition = Position.builder().positionX(0).positionY(0).orientation(Orientation.NORTH).build();

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> currentPosition.setOrientation(rotate(currentPosition.getOrientation(), "L" ));
                case 'R' -> currentPosition.setOrientation(rotate(currentPosition.getOrientation(), "R"));
                case 'M' -> currentPosition = moveForward(currentPosition);
                default -> {
                    throw new CommandNotFoundException("Command not found!");
                }
            }
        }
        return currentPosition;
    }


    private static Orientation rotate(Orientation orientation, String rotate) {
        return switch (orientation) {
            case NORTH -> "L".equals(rotate) ? Orientation.WEST : Orientation.EAST;
            case SOUTH -> "L".equals(rotate) ? Orientation.EAST : Orientation.WEST;
            case EAST -> "L".equals(rotate) ? Orientation.NORTH : Orientation.SOUTH;
            case WEST -> "L".equals(rotate) ? Orientation.SOUTH : Orientation.NORTH;
            default -> orientation;
        };
    }

    private static Position moveForward(Position position) throws Exception {
        switch (position.getOrientation()) {
            case NORTH -> {
                position.setPositionY(position.getPositionY() + 1);
                return position;
            }
            case SOUTH -> {
                position.setPositionY(position.getPositionY() - 1);
                return position;
            }
            case EAST -> {
                position.setPositionX(position.getPositionX() + 1);
                return position;
            }
            case WEST -> {
                position.setPositionX(position.getPositionX() - 1);
                return position;
            }
            default -> {
                return position;
            }
        }
    }
}
