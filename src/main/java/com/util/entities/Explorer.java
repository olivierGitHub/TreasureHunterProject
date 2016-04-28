package com.util.entities;

import com.util.enums.ExplorerOrientation;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by olivier on 28/04/2016.
 */
public class Explorer extends Observable implements Observer{

    private ExplorerOrientation orientation;
    private String position;
    private ExplorerOrientation enumOrientation;

    public Explorer (ExplorerOrientation orientation, String position){
        this.orientation = orientation;
        this.position = position;
    }


    public void update(Observable o, Object arg) {
        if (o instanceof Mountain) {
            //prcess
        } else if (o instanceof Treasure) {
            //process
        }

    }

    public String changePosition(String position){

        String newPosition="";
        int xCoordinate=0;
        int yCoordinate=0;
        ExplorerOrientation eo = getOrientation();

        switch (eo){
            case NORTH: {
                yCoordinate = Integer.parseInt(position.substring(0,1))-1;
                newPosition = yCoordinate + position.substring(1);
                return newPosition;
            }case EAST: {
                xCoordinate = Integer.parseInt(position.substring(2,3))+1;
                newPosition = position.substring(0,2) + xCoordinate;
                return newPosition;
            }case SOUTH: {
                yCoordinate = Integer.parseInt(position.substring(0,1))+1;
                newPosition = yCoordinate + position.substring(1);
                return newPosition;
            }case WEST : {
                xCoordinate = Integer.parseInt(position.substring(2,3))-1;
                newPosition = position.substring(0,2) + xCoordinate;
                return newPosition;
            }default:
                return position;
        }
    }



    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}

    public ExplorerOrientation getOrientation() {return orientation;}
    public void setOrientation(ExplorerOrientation orientation) {this.orientation = orientation;}

}
