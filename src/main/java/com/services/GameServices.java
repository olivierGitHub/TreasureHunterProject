package com.services;

import com.helpers.FileHandler;
import com.helpers.JsonBuilder;
import com.util.dto.GridDto;
import com.util.entities.Explorer;
import com.util.entities.GameMap;
import com.util.entities.Mountain;
import com.util.entities.Treasure;
import com.util.enums.ExplorerOrientation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by olivier on 27/04/2016.
 */
@Path("/game")
public class GameServices {

    private String inputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexte.txt";
    private String outputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexteOutput.txt";
    private String updateFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexteUpdate.txt";


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

    @Path("/play")
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GridDto> playSequence(@FormParam("sequence") String sequence){

        List<Mountain> mountainList = new ArrayList<Mountain>();
        List<Treasure> treasureList = new ArrayList<Treasure>();

        //initialization
        Explorer explorer = new Explorer(ExplorerOrientation.EAST,"3-4");
        GameMap gameMap = new GameMap(5,6);

        Map<Character,List<String>> resultMap = this.fh.transform();

        //Explorer creation
        StringTokenizer st = new StringTokenizer(sequence);
        try {
            String name = st.nextToken();
            String position = st.nextToken();
            explorer = new Explorer(explorer.transformOrientation(st.nextToken()), position);
            explorer.setSequenceGame(st.nextToken());
            explorer.setName(name);

        } catch (Exception e) {
            e.printStackTrace();
        }


        for (Map.Entry<Character,List<String>> entry : resultMap.entrySet())
            if (entry.getKey().equals('M'))
                for (String elem : entry.getValue()) {
                    Mountain mountain = new Mountain(elem);
                    mountainList.add(mountain);
                }
            else if (entry.getKey().equals('T'))
                for (String elem : entry.getValue()) {
                    int nbTreasures = Integer.parseInt(elem.substring(4, 5));
                    Treasure treasure = new Treasure(elem.substring(0, 3), nbTreasures);
                    treasureList.add(treasure);
                }
            /*else if (entry.getKey().equals('P'))
                for (String elem : entry.getValue()) {
                    StringTokenizer st = new StringTokenizer(elem);
                    try {
                        String name = st.nextToken();
                        String position = st.nextToken();
                        explorer = new Explorer(explorer.transformOrientation(st.nextToken()), position);
                        explorer.setSequenceGame(st.nextToken());
                        explorer.setName(name);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }*/
            else if (entry.getKey().equals('C'))
                for (String elem : entry.getValue()) {
                    int nbColumns = Integer.parseInt(elem.substring(0, 1));
                    int nbLines = Integer.parseInt(elem.substring(2, 3));
                    gameMap = new GameMap(nbLines, nbColumns);
                }

        this.fh.setInputFile(this.inputFile);
        this.fh.createBlankOutputFile(gameMap);
        this.fh.generateGridFile(this.fh.justRead());

        explorer.addObserver(gameMap);
        gameMap.addObserver(explorer);

        for (Mountain mountain : mountainList){
            explorer.addObserver(mountain);
            mountain.addObserver(explorer);
        }

        for (Treasure treasure : treasureList){
            explorer.addObserver(treasure);
            treasure.addObserver(explorer);
        }

        System.out.println(explorer.countObservers());

        String sequenceGame = explorer.getSequenceGame();
        char [] chars = sequenceGame.toCharArray();

        for(char str:chars ){
            switch (str){
                case 'A':{
                    explorer.changePosition(explorer.getPosition());
                    System.out.println("-----------------------------------------");
                    break;
                }
                case 'D':{
                    explorer.changeOrientation("D");
                    System.out.println("-----------------------------------------");
                    break;
                }
                case 'G':{
                    explorer.changeOrientation("G");
                    System.out.println("-----------------------------------------");
                    break;
                }
            }
        }

        this.fh.updateExplorerPositionInFile(explorer.getPosition(),sequence,this.updateFile);

        JsonBuilder jsonBuilder = new JsonBuilder(this.updateFile);
        this.fh.setInputFile(this.updateFile);

        return jsonBuilder.generate(fh.justRead());

    }

}
