package com.helpers;

import com.util.GridDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by olivier on 27/04/2016.
 */
@XmlRootElement
public class JsonBuilder {

    private String inputFile;

    public JsonBuilder(String inputFile){
        this.inputFile = inputFile;
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
                }else{
                    finalMap.get('P').add(sCurrentLine);
                }
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return finalMap;
    }


    public List<GridDto> generate(List<String> entryList){

        List<GridDto> finalList = new ArrayList<GridDto>();
        /*Map<Character,List<String>> resultMap = transform();

        List<String> mountainList = new ArrayList<String>();
        List<String> treasureList = new ArrayList<String>();
        List<String> blankList = new ArrayList<String>();

        for (Map.Entry<Character, List<String>> entry : resultMap.entrySet()){
            if (entry.getKey().equals('M')) {
                for (String elem : entry.getValue()) {
                    GridDto gridDto = new GridDto();
                        gridDto.setPosition(elem.substring(2,5));
                        gridDto.setTypeUnitGrid("mountainUnit");

                    //finalMap.put('M',)
                }
            }
        }*/


        return  finalList;
    }

}
