import com.helpers.FileHandler;
import com.helpers.JsonBuilder;
import com.util.GameMap;
import com.util.GridDto;

import java.util.List;

/**
 * Created by olivier on 28/04/2016.
 */
public class Main {

    public static void main (String[] args ){

        String inputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\fichierTexte.txt";
        String outputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\fichierTexteOutput.txt";

        FileHandler fh = new FileHandler(inputFile,outputFile);


        GameMap gameMap = new GameMap(5,6);
        fh.createBlankOutputFile(gameMap);

        fh.generateGridFile(fh.justRead());

        JsonBuilder jsonBuilder = new JsonBuilder(outputFile);

        fh.setInputFile(outputFile);
        List<GridDto> list = jsonBuilder.generate(fh.justRead());



    }
}
