package com.util.entities;

/**
 * Created by olivier on 28/04/2016.
 */
public class GameMap {

    private int nbLines;
    private int nbColumns;

    public GameMap (int nbLines, int nbColumns){
        this.nbLines = nbLines;
        this.nbColumns = nbColumns;
    }

    public int getNbLines() {return nbLines;}
    public void setNbLines(int nbLines) {this.nbLines = nbLines;}

    public int getNbColumns() {return nbColumns;}
    public void setNbColumns(int nbColumns) {this.nbColumns = nbColumns;}

}
