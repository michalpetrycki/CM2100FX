/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.Random;

/**
 *
 * @author 1707586
 */
public class ArrayUtils {
    
    //Array 
    private int[] array;
    //Random object
    private Random r;
    
    //Constructor
    public ArrayUtils(int size){
        
        //Array initialization
        array = new int[size];
        //Random initialization
        r = new Random();
        
    }
    
    //Fills up array with random generated ints
    public int[] initializeArray(){
    
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt((100 - 0) + 1) + 1;
        }
        
        return array;
    
    }
    
}
