package com.services;

import com.helpers.FileHandler;
import com.helpers.JsonBuilder;
import com.util.dto.GridDto;
import com.util.entities.GameMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivier on 27/04/2016.
 */
@Path("/game")
public class GameServices {

    private String inputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexte.txt";
    private String outputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexteOutput.txt";

    private FileHandler fh = new FileHandler(inputFile,outputFile);
    private GameMap gameMap = new GameMap(5,6);

    @Path("/grid")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<GridDto> findGridInformation(){

        this.fh.createBlankOutputFile(this.gameMap);
        this.fh.generateGridFile(this.fh.justRead());

        JsonBuilder jsonBuilder = new JsonBuilder(this.outputFile);
        this.fh.setInputFile(this.outputFile);

        return jsonBuilder.generate(fh.justRead());
    }

}
