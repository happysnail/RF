/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rf_lab3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andrei.tarnauceanu
 */
public class DistanceUtils {
    public static double euclidianDistance(double[][] learningSet, int f, int j){
        double[] firstElement = learningSet[f];
        double[] secondElement = learningSet[j];
        double suma=0;
        for (int i = 0; i<firstElement.length -1 ; i++){
            suma = suma + Math.pow(firstElement[i]-secondElement[i], 2);
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
