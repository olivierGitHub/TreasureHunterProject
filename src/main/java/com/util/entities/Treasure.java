package com.util.entities;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by olivier on 28/04/2016.
 */
public class Treasure extends Observable implements Observer {

    private String position;
    private int nbTreasures;


    public Treasure (String position, int nbTreasures){
        this.position = position;
        this.nbTreasures = nbTreasures;
    }


    public void update(Observable o, Object arg) {
        if (o instanceof Explorer){
            if (arg instanceof String){
                if (arg.equals(this.position)) {
                    setNbTreasures(getNbTreasures() - 1);
                    System.out.println("Un trésor a été ramassé à la position " + position + ". Il reste " + nbTreasures + " trésors.");

                }
            }
        }
    }

    public int getNbTreasures() {return nbTreasures;}
    public void setNbTreasures(int nbTreasures) {this.nbTreasures = nbTreasures;}

    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}

}
