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
        Map<Integer, Double> merge_space_map = new HashMap<>();
        Map<Integer, Double> quick_map = new HashMap<>();
        
        for(int i = 10; i < 1000; i += 10){
        
            MergeSort[] ms = new MergeSort[100];
            QuickSort[] qs = new QuickSort[100];
            
            int time = 0;
            int space = 0;
            
            for(MergeSort m: ms){
            
                m = new MergeSort(i);
                m.sort(0, i - 1);
                time += m.getTime();
                space += m.getSpace();
                
            }
            merge_time_map.put(i, (double)(time / 100));
            merge_space_map.put(i, (double) (space / 100));
            
            time = 0;
            space = 0;
            for(QuickSort q: qs){

                q = new QuickSort(i);
                q.sort(0, i - 1);
                time += q.getTime();

            }
            quick_map.put(i, (double) (time / 100));
            
        }
        
        maps.add(merge_time_map);
        maps.add(merge_space_map);
        maps.add(quick_map);
        
        return maps;
        
    }
    
}
