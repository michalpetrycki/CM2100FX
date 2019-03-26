/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Arrays;

/**
 *
 * @author 1707586
 */
public class MergeSort {
    
    private int[] array;
    private int time;
    private int space;
    
    public MergeSort(int size){
        
        array = new ArrayUtils(size).initializeArray();
        time = 0;
        space = 0;
        
    }
    
    public void merge(int left, int right){
    
        int middle = (left + right) / 2;
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        int[] a1 = new int[n1];
        int[] a2 = new int[n2];
                
        for(int i = 0; i < n1; i++){
            
            a1[i] = array[left + i];
            space++;
            
        }
        
        for(int i = 0; i < n2; i++){        
            
            a2[i] = array[middle + 1 + i];
            space++;
            
        }
            
        int i = 0;
        int j = 0;
        int k = left;
        
        while(i < n1 && j < n2){
        
            if(a1[i] <= a2[j]){
            
                array[k] = a1[i];
                i++;
            
            }else{
            
                array[k] = a2[j];
                j++;
            
            }
            
            k++;
            time++;
        
        }
        
        while(i < n1){
        
            array[k] = a1[i];
            i++;
            k++;
            time++;
        
        }
        while(j < n2){
        
            array[k] = a2[j];
            j++;
            k++;
            time++;
            
        }
        
    }
    
    public void sort(int left, int right){
    
        if(left < right){
        
            int m = (left + right) / 2;
            sort(left, m);
            sort(m + 1, right);
            merge(left, right);
        
        }
        
    }
    
    //Returns time taken
    public int getTime(){
        return time;
    }
    
    //Returns space taken
    public int getSpace(){
        return space;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(array);
    }
    
}
