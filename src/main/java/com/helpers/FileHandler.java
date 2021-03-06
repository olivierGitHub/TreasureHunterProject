package com.helpers;

import com.util.entities.GameMap;

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
    private String tempFile = "C:\\Users\\olivier\\IdeaProjects\\TreasureHunterProject\\src\\main\\java\\com\\util\\files\\fichierTexteTemp.txt";


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
                PrintWriter writer = new PrintWriter(this.outputFile, "UTF-8");
                mainloop: while ((sCurrentLine = br.readLine()) != null) {
                    for (String elem : list){
                        String positionBlankFile = elem.substring(2,5);
                        if (sCurrentLine.equals(positionBlankFile)){
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


    public Map<Character,List<String>> transform() {

        BufferedReader br = null;
        Map<Character,List<String>> finalMap = new HashMap<Character, List<String>>();
        finalMap.put('C', new ArrayList<String>());
        finalMap.put('T', new ArrayList<String>());
        finalMap.put('M', new ArrayList<String>());
        finalMap.put('P', new ArrayList<String>());
        String sCurrentLine = null;

        try {
            br = new BufferedReader(new FileReader(this.inputFile));
            Character mapKey;
            while ((sCurrentLine = br.readLine()) != null) {
                char elem = sCurrentLine.charAt(1);
                if (elem==' ') {
                    mapKey = sCurrentLine.charAt(0);
                    finalMap.get(mapKey).add(sCurrentLine.substring(2));
                }else if (elem != '-'){
                    finalMap.get('P').add(sCurrentLine);
                }
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return finalMap;
    }


    public void updateExplorerPositionInFile(String position, String sequence, String updateFile){

        BufferedReader br = null;
        String sCurrentLine = null;

        String sequenceUpdated = sequence.substring(0,5) + position + sequence.substring(8);

        try {
            br = new BufferedReader(new FileReader(this.outputFile));
            PrintWriter writer = new PrintWriter(updateFile, "UTF-8");
            mainloop: while ((sCurrentLine = br.readLine()) != null) {
                if (sCurrentLine.equals(position)){
                    writer.println(sequenceUpdated);
                    continue mainloop;
                }
                writer.println(sCurrentLine);
            }
            br.close();
            writer.close();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public String getOutputFile() {return outputFile;}
    public void setOutputFile(String outputFile) {this.outputFile = outputFile;}

    public String getInputFile() {return inputFile;}
    public void setInputFile(String inputFile) {this.inputFile = inputFile;}


}
