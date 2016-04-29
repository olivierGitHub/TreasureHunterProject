package com.util.entities;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by olivier on 28/04/2016.
 */
public class GameMap extends Observable implements Observer{

    private int nbLines;
    private int nbColumns;

    public GameMap (int nbLines, int nbColumns){
        this.nbLines = nbLines;
        this.nbColumns = nbColumns;
    }

    public void update(Observable o, Object arg) {
        if (o instanceof Explorer) {
            if (arg instanceof String) {
                String xCoordinate = ((String) arg).substring(0,1);
                String yCoordinate = ((String) arg).substring(2,3);
                if (Integer.parseInt(xCoordinate) > nbColumns || Integer.parseInt(xCoordinate) == 0) {
                    System.out.println("LIMITE ABSCISSES ATTEINTES");
                    setChanged();
                    notifyObservers(true);
                } else if (Integer.parseInt(yCoordinate) > nbLines || Integer.parseInt(yCoordinate) == 0) {
                    System.out.println("LIMITE ORDONNEES ATTEINTES");
                    setChanged();
                    notifyObservers(true);
                }

            }
        }
    }




    public int getNbLines() {return nbLines;}
    public void setNbLines(int nbLines) {this.nbLines = nbLines;}

    public int getNbColumns() {return nbColumns;}
    public void setNbColumns(int nbColumns) {this.nbColumns = nbColumns;}


}
