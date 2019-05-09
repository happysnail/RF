/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rf_lab8;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrei.tarnauceanu
 */
public class DistanceUtils {
    public static double euclidianDistance(String[][] learningSet,String[][] searchSet, int f, int j){
        String[] firstElement = searchSet[f];
        String[] secondElement = learningSet[j];
        double suma=0;
        for (int i = 0; i< 2 ; i++){
            suma = suma + Math.pow(Double.valueOf(firstElement[i])-Double.valueOf(secondElement[i]), 2);
        }
        return Math.sqrt(suma);     
    }
    public static void dCebDistance(double[][] learningSet){
        //todo
    }
     public static void dManDistance(double[][] learningSet){
        //todo
    }
      public static void dCityDistance(double[][] learningSet){
        //todo
    }
}
