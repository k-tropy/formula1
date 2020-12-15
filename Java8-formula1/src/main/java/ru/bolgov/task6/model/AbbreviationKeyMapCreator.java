package ru.bolgov.task6.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AbbreviationKeyMapCreator {
    private final Map<String, String> abbreviationKeyMap;

    public AbbreviationKeyMapCreator() {
        this.abbreviationKeyMap = new HashMap<String, String>();
    }

    public Map<String, String> getAbbreviationKeyMap() {
        return abbreviationKeyMap;
    }

    public Map<String, String> createMap(List<String> inputList) {

        inputList.stream().forEach(x -> abbreviationKeyMap.put(x.substring(0, 3), x.substring(3, x.length())));
        //часть для тестирования
        abbreviationKeyMap.entrySet().stream()
                          .forEach(s ->System.out.println(s.getValue()));
        return abbreviationKeyMap;

    }

}

//принимает 