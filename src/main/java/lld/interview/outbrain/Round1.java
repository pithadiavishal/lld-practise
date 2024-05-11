package lld.interview.outbrain;

import java.util.*;

public class Round1 {
//Word Frequency
//Consider a list of strings of words separated by comma (called records) and another list of strings of words separated by comma (called queries).
//For each query, find the records that contain all the words of the query and count the number of times each record’s word that is not in the query appears
//records
//red,yellow,green,black
//red,green,blue,black
//yellow,green,blue
//yellow,blue,black
//queries
//blue,yellow
//black,green
//expected output
//"black": 1, "green": 1
//"blue": 1, "red": 2, "yellow": 1


    static List<String> records = Arrays.asList("red,yellow,green,black", "red,green,blue,black","yellow,green,blue", "yellow,blue,black");
    static List<String> queries = Arrays.asList("blue,yellow", "black,green");

    public static void main(String[] args) {
        List<Map<String, Integer>> results = solveIt();
        System.out.println(results);
    }

    private static List<Map<String, Integer>> solveIt(){
        Map<String, Set<String>> recordColorMap = process(records);
        Map<String, Set<String>> queryColorMap = process(queries);
        Set<String> recordColor;
        Set<String> queryColor;
        Map<String, Integer> colorCount;
        List<Map<String, Integer>> res = new ArrayList<>();

        for(Map.Entry<String, Set<String>> queryEntry: queryColorMap.entrySet()){
            colorCount = new HashMap<>();
            queryColor = queryEntry.getValue();
            for(Map.Entry<String, Set<String>> recordEntry: recordColorMap.entrySet()){
                recordColor = recordEntry.getValue();
                processQuery(recordColor, queryColor, colorCount);
            }
            res.add(colorCount);
        }

        return res;
    }


    private static Map<String, Set<String>> process(List<String> data){
        Map<String, Set<String>> colorsMap = new HashMap<>();
        for(String record: data){
            String[] colors = record.split(",");
            colorsMap.put(record, getSet(colors));
        }
        return colorsMap;
    }

    private static Set<String> getSet(String[] strArr){
        Set<String> set = new HashSet<>(Arrays.asList(strArr));
        return set;
    }

    private static void processQuery(Set<String> recordColor, Set<String> queryColor, Map<String, Integer> colorCount) {
        Set<String> extraColor;
        if(recordColor.containsAll(queryColor)){
            extraColor = new HashSet<>(recordColor);
            extraColor.removeAll(queryColor);
            countColor(extraColor, colorCount);
        }
    }

    private static void countColor(Set<String> extraColor, Map<String, Integer> colorCount) {
        for(String color: extraColor){
            int count = colorCount.getOrDefault(color, 0);
            colorCount.put(color, count+1);
        }
    }

}
