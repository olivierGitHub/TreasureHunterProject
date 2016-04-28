package com.helpers;

import com.util.GameMap;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by olivier on 27/04/2016.
 */
public class FileHandler {

    private String inputFile;
    private String outputFile;
    private String tempFile = "C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\fichierTexteTemp.txt";


    public FileHandler(String inputFile, String outputFile){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }



    public List<String> justRead(){

        BufferedReader br = null;
        List<String> finalList = new ArrayList<String>();

        String sCurrentLine = null;

        try {
            br = new BufferedReader(new FileReader(this.inputFile));
            while ((sCurrentLine = br.readLine()) != null) {
                finalList.add(sCurrentLine);
            }
            br.close();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return finalList;
    }


    public void createBlankOutputFile(GameMap gameMap) {

        try {
            File file = new File(this.tempFile);

            if (!file.exists()) {
                file.createNewFile();
            }

            PrintWriter writer = new PrintWriter(this.tempFile, "UTF-8");
            String position = null;
            for (int i = 1; i <= gameMap.getNbLines(); i++) {
                for (int j = 1; j <= gameMap.getNbColumns(); j++) {
                    position = i + "-" + j;
                    writer.println(position);
                }
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateGridFile(List<String> list){


            BufferedReader br = null;
            String sCurrentLine = null;

            try {
                br = new BufferedReader(new FileReader(this.tempFile));
                //FileOutputStream os = new FileOutputStream(this.outputFile);
                PrintWriter writer = new PrintWriter(this.outputFile, "UTF-8");
                mainloop: while ((sCurrentLine = br.readLine()) != null) {
                    for (String elem : list){
                        String essai = elem.substring(2,5);
                        if (sCurrentLine.equals(essai)){
                            //sCurrentLine = sCurrentLine.replace(essai,elem);
                            writer.println(elem);
                            continue mainloop;
                        }
                    }
                    writer.println(sCurrentLine);
                }
                br.close();
                writer.close();
            }catch (IOException ioe) {
                ioe.printStackTrace();
            }


    }


}
