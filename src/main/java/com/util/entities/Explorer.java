package com.util.entities;

import com.util.enums.ExplorerOrientation;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by olivier on 28/04/2016.
 */
public class Explorer extends Observable implements Observer {

    private ExplorerOrientation orientation;
    private String position;
    private Integer nbTreasures;

    public Explorer(ExplorerOrientation orientation, String position) {
        this.orientation = orientation;
        this.position = position;
    }


    public void update(Observable o, Object arg) {
        if (o instanceof Mountain) {
            if (arg instanceof Boolean) {
                if (arg.equals(true))
                    goBackToInitialPosition(this.position);
            }
        }else if (o instanceof Treasure) {
            if (arg instanceof Boolean) {
                if (arg.equals(true))
                    pickTreasure();
            }
        }

    }


    public void pickTreasure(){
        try {
            setNbTreasures(getNbTreasures() + 1);
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public void changePosition(String position) {

        int xCoordinate = 0;
        int yCoordinate = 0;
        ExplorerOrientation eo = getOrientation();

        try{
            switch (eo) {
                case NORTH: {
                    Thread.sleep(1000);
                    yCoordinate = Integer.parseInt(position.substring(0, 1)) - 1;
                    setPosition(yCoordinate + position.substring(1));
                    notifyObservers(this.position);
                    break ;
                }
                case EAST: {
                    Thread.sleep(1000);
                    xCoordinate = Integer.parseInt(position.substring(2, 3)) + 1;
                    setPosition(position.substring(0, 2) + xCoordinate);
                    notifyObservers(this.position);
                    break ;
                }
                case SOUTH: {
                    Thread.sleep(1000);
                    yCoordinate = Integer.parseInt(position.substring(0, 1)) + 1;
                    setPosition(yCoordinate + position.substring(1));
                    notifyObservers(this.position);
                    break ;
                }
                case WEST: {
                    Thread.sleep(1000);
                    xCoordinate = Integer.parseInt(position.substring(2, 3)) - 1;
                    setPosition(position.substring(0, 2) + xCoordinate);
                    notifyObservers(this.position);
                    break ;
                }
                default:
                    System.out.println("ERROR: L'explorateur n'a pas changer de position ");
                    break ;
            }
        } catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("L'explorateur se trouve à la position "+getPosition()+".");
    }


    public void goBackToInitialPosition(String position){

        int xCoordinate = 0;
        int yCoordinate = 0;
        ExplorerOrientation eo = getOrientation();

        switch (eo) {
            case NORTH: {
                yCoordinate = Integer.parseInt(position.substring(0, 1)) + 1;
                setPosition(yCoordinate + position.substring(1));
                break ;
            }
            case EAST: {
                xCoordinate = Integer.parseInt(position.substring(2, 3)) - 1;
                setPosition(position.substring(0, 2) + xCoordinate);
                break ;
            }
            case SOUTH: {
                yCoordinate = Integer.parseInt(position.substring(0, 1)) - 1;
                setPosition(yCoordinate + position.substring(1));
                break ;
            }
            case WEST: {
                xCoordinate = Integer.parseInt(position.substring(2, 3)) + 1;
                setPosition(position.substring(0, 2) + xCoordinate);
                break ;
            }
            default:
                System.out.println("ERROR: L'explorateur n'a pas changer de position ");
                break ;
        }
        System.out.println("L'explorateur est de retour à la position "+getPosition()+".");
    }


    public void changeOrientation(String direction){
        ExplorerOrientation eo = getOrientation();
        try {
            switch (eo) {
                case NORTH: {
                    Thread.sleep(1000);
                    setOrientation(direction.equals("D") ? ExplorerOrientation.EAST : ExplorerOrientation.WEST);
                    break ;
                }
                case EAST: {
                    Thread.sleep(1000);
                    setOrientation(direction.equals("D") ? ExplorerOrientation.SOUTH : ExplorerOrientation.NORTH);
                    break ;
                }
                case SOUTH: {
                    Thread.sleep(1000);
                    setOrientation(direction.equals("D") ? ExplorerOrientation.WEST : ExplorerOrientation.EAST);
                    break ;
                }
                case WEST: {
                    Thread.sleep(1000);
                    setOrientation(direction.equals("D") ? ExplorerOrientation.NORTH : ExplorerOrientation.SOUTH);
                    break ;
                }
                default:
                    System.out.println("ERROR: L'explorateur n'a pas changer d'orientation ");
                    break ;
            }
        } catch (InterruptedException e) {e.printStackTrace();}

        System.out.println("L'explorateur fait face "+getOrientation()+".");
    }


    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}

    public ExplorerOrientation getOrientation() {return orientation;}
    public void setOrientation(ExplorerOrientation orientation) {this.orientation = orientation;}

    public Integer getNbTreasures() {return nbTreasures;}
    public void setNbTreasures(Integer nbTreasures) {this.nbTreasures = nbTreasures;}

}
