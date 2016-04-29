import com.helpers.FileHandler;
import com.helpers.JsonBuilder;
import com.util.entities.Explorer;
import com.util.entities.GameMap;
import com.util.dto.GridDto;
import com.util.entities.Mountain;
import com.util.entities.Treasure;
import com.util.enums.ExplorerOrientation;

import java.util.*;

/**
 * Created by olivier on 28/04/2016.
 */
public class Main {

    public static void main (String[] args ){

        String inputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexte.txt";
        String outputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexteOutput.txt";

        FileHandler fh = new FileHandler(inputFile,outputFile);

        /*JsonBuilder jsonBuilder = new JsonBuilder(outputFile);

        fh.setInputFile(outputFile);
        List<GridDto> list = jsonBuilder.generate(fh.justRead());*/


        // Test of observer pattern
        //Explorer explorer = new Explorer(ExplorerOrientation.WEST,"3-4");

        /*Mountain mountain1 = new Mountain("3-2");
        Treasure treasure1 = new Treasure("3-3", 3);

        explorer.addObserver(mountain1);
        explorer.addObserver(treasure1);
        mountain1.addObserver(explorer);
        treasure1.addObserver(explorer);*/

        List<Mountain> mountainList = new ArrayList<Mountain>();
        List<Treasure> treasureList = new ArrayList<Treasure>();
        //List<Explorer> explorerList = new ArrayList<Explorer>();

        //initialization
        Explorer explorer = new Explorer(ExplorerOrientation.EAST,"3-4");
        GameMap gameMap = new GameMap(5,6);

        Map<Character,List<String>> resultMap = fh.transform();

        for (Map.Entry<Character,List<String>> entry : resultMap.entrySet()) {
            if (entry.getKey().equals('M') ) {
                for (String elem : entry.getValue()) {
                    Mountain mountain = new Mountain(elem);
                    mountainList.add(mountain);
                }
            }else if (entry.getKey().equals('T') ) {
                for (String elem : entry.getValue()) {
                    int nbTreasures = Integer.parseInt(elem.substring(4, 5));
                    Treasure treasure = new Treasure(elem.substring(0, 3), nbTreasures);
                    treasureList.add(treasure);
                }
            }else if (entry.getKey().equals('P') ) {
                for (String elem : entry.getValue()) {
                    StringTokenizer st = new StringTokenizer(elem);
                    try{
                        String name = st.nextToken();
                        String position = st.nextToken();

                        explorer = new Explorer(explorer.transformOrientation(st.nextToken()),position);

                        explorer.setName(name);
                        explorer.setSequenceGame(st.nextToken());

                    }catch (Exception e){e.printStackTrace();}
                }
            }else if (entry.getKey().equals('C') ) {
                for (String elem : entry.getValue()) {
                    int nbColumns = Integer.parseInt(elem.substring(0,1));
                    int nbLines = Integer.parseInt(elem.substring(2,3));
                    gameMap = new GameMap(nbLines,nbColumns);
                }
            }
        }

        fh.createBlankOutputFile(gameMap);
        fh.generateGridFile(fh.justRead());

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
                    System.out.println("-----------------------------------------");
                    explorer.changePosition(explorer.getPosition());
                    break;
                }
                case 'D':{
                    System.out.println("-----------------------------------------");
                    explorer.changeOrientation("D");
                    break;
                }
                case 'G':{
                    System.out.println("-----------------------------------------");
                    explorer.changeOrientation("G");
                    break;
                }
            }
        }

    }
}
