package com.util.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by olivier on 27/04/2016.
 */
@XmlRootElement
public class GridDto {

    private String position;
    private String typeUnitGrid;

    public String getPosition() {return position;}
    public void setPosition(String position) {this.position = position;}

    public String getTypeUnitGrid() {return typeUnitGrid;}
    public void setTypeUnitGrid(String typeUnitGrid) {this.typeUnitGrid = typeUnitGrid;}

}
