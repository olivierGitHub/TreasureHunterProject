package com.helpers;

import com.util.dto.GridDto;

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

public class JsonBuilder {

    private String inputFile;

    public JsonBuilder(String inputFile){
        this.inputFile = inputFile;
    }

    public List<GridDto> generate(List<String> entryList) {

        List<GridDto> finalList = new ArrayList<GridDto>();

        for (String elem : entryList) {
            GridDto gridDto = new GridDto();
            if (elem.charAt(0) == 'M') {
                gridDto.setPosition(elem.substring(2, 5));
                gridDto.setTypeUnitGrid("mountainUnit");
            } else if (elem.charAt(0) == 'T') {
                gridDto.setPosition(elem.substring(2, 5));
                gridDto.setTypeUnitGrid("treasureUnit");
            } else {
                gridDto.setPosition(elem.substring(0, 3));
                gridDto.setTypeUnitGrid("blankUnit");
            }
            finalList.add(gridDto);
        }
        return finalList;
    }


    // DEPRECATED
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

}
