package com.conta.azul.nasa.robo.movementsdto;

import com.conta.azul.nasa.robo.enums.Orientation;
import com.conta.azul.nasa.robo.exception.ManyMovementsException;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {

    private Integer positionX;
    
    private Integer positionY;

    private Orientation orientation;


    public void setPositionX(Integer value) throws Exception{
        if (value > 5)
             throw new ManyMovementsException("Too many movements, action not permitted!");
        this.positionX = value;
    }

    public void setPositionY(Integer value) throws Exception{
        if (value > 5)
             throw new ManyMovementsException("Too many movements, action not permitted!");
        this.positionY = value;
    }

    @Override
    public String toString(){
        return "("+positionX+","+positionY+","+orientation.getValue()+")";
    }
}
