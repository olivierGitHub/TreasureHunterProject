import com.helpers.FileHandler;
import com.helpers.JsonBuilder;
import com.util.entities.Explorer;
import com.util.entities.GameMap;
import com.util.dto.GridDto;
import com.util.entities.Mountain;
import com.util.entities.Treasure;
import com.util.enums.ExplorerOrientation;

import java.util.List;

/**
 * Created by olivier on 28/04/2016.
 */
public class Main {

    public static void main (String[] args ){

        String inputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexte.txt";
        String outputFile ="C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexteOutput.txt";

        FileHandler fh = new FileHandler(inputFile,outputFile);


        GameMap gameMap = new GameMap(5,6);
        fh.createBlankOutputFile(gameMap);

        fh.generateGridFile(fh.justRead());

        JsonBuilder jsonBuilder = new JsonBuilder(outputFile);

        fh.setInputFile(outputFile);
        List<GridDto> list = jsonBuilder.generate(fh.justRead());


        // Test of observer pattern
        Explorer explorer = new Explorer(ExplorerOrientation.WEST,"3-4");

        Mountain mountain1 = new Mountain("3-2");
        Treasure treasure1 = new Treasure("3-3", 3);

        explorer.addObserver(mountain1);
        explorer.addObserver(treasure1);
        mountain1.addObserver(explorer);
        treasure1.addObserver(explorer);

        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("D");
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("D");
        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("D");
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("D");
        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");

        if (treasure1.getNbTreasures()==0) explorer.deleteObserver(treasure1);

        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changeOrientation("G");
        System.out.println("-----------------------------------------");
        explorer.changePosition(explorer.getPosition());
        System.out.println("-----------------------------------------");

    }
}
