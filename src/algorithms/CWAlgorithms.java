/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 1707586
 */
public class CWAlgorithms {

    public ArrayList<Map> getMaps(){
    
        ArrayList<Map> maps = new ArrayList<>();
        
        Map<Integer, Double> merge_time_map = new HashMap<>();
        ArrayList<Double> merge_times;
        Map<Integer, Double> merge_space_map = new HashMap<>();
        ArrayList<Double> merge_spaces;
        Map<Integer, Double> quick_map = new HashMap<>();
        ArrayList<Double> quick_times;
        
        for(int i = 10; i < 1000; i += 10){
        
            MergeSort[] ms = new MergeSort[100];
            QuickSort[] qs = new QuickSort[100];
            
            merge_times = new ArrayList<>();
            merge_spaces = new ArrayList<>();
            quick_times = new ArrayList<>();
            
            for(MergeSort m: ms){
            
                int time = 0;
                int space = 0;
                
                m = new MergeSort(i);
                m.sort(0, i - 1);
                time += m.getTime();
                space += m.getSpace();
                System.out.println(time);
                merge_times.add((double) time);
                merge_spaces.add((double) space);
                
            }
            merge_time_map.put(i, calculateMean(merge_times));
            System.out.println(i + ": " + calculateMean(merge_times));
            merge_space_map.put(i, calculateMean(merge_spaces));
            
            for(QuickSort q: qs){

                int time = 0;
                int space = 0;
                
                q = new QuickSort(i);
                q.sort(0, i - 1);
                time += q.getTime();
                quick_times.add((double) time);

            }
            
            quick_map.put(i, calculateMean(quick_times));
            
        }
        
        maps.add(merge_time_map);
        maps.add(merge_space_map);
        maps.add(quick_map);
        
        return maps;
        
    }
    
    private double calculateMean(ArrayList<Double> list){
    
        double mean = 0.0;
        
        for(Double d: list)
            mean += d;
        
        return mean / 100.0;
    
    }
    
}
