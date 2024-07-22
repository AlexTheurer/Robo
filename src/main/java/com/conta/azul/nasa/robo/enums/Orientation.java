package com.conta.azul.nasa.robo.enums;

public enum Orientation {
    
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String value;

    Orientation(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
