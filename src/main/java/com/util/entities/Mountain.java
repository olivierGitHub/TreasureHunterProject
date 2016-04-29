package com.util.entities;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by olivier on 28/04/2016.
 */
public class Mountain extends Observable implements Observer {

    private String position;
    private boolean unitOccupied;

    public Mountain (String position){
        this.position = position;
    }


    public void update(Observable o, Object arg) {
        if (o instanceof Explorer) {
            if (arg instanceof String) {
                if (arg.equals(this.position)) {
                    System.out.println("Une MONTAGNE se trouve à la position " + this.position + ".");
                    setChanged();
                    notifyObservers(true);
                }
            }
        }
    }

    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}

    public boolean isUnitOccupied() {return unitOccupied;}
    public void setUnitOccupied(boolean unitOccupied) {this.unitOccupied = unitOccupied;}

}
