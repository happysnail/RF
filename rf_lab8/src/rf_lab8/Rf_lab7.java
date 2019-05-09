package rf_lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static rf_lab8.DistanceUtils.dCityDistance;
import static rf_lab8.DistanceUtils.euclidianDistance;

public class Rf_lab7 {
	public static void main(String[] args) {
		String[][] learningSet;
		try {
                        learningSet = FileUtils.readLearningSetFromFile("data.txt");
			int numberOfFeatures = learningSet[0].length;
                        String[] classList = { "class-1", "class-2" };
                        int[] classArray = classifySet(learningSet, 2, numberOfFeatures)
                        for (int i = 0; i < classArray.length; i++){
                            System.out.println(classList(classArray[i], " "));
                        }
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}
        static int[] classifySet(String[][] entrySet, int numberOfClasses, int numberOfFeatures){
            String[][] kernels = new String[numberOfClasses][numberOfFeatures];
            int[] iClass = new int[entrySet.length];
            boolean done = false;
            
            for (int i; i<numberOfClasses; i++)
            {
                kerenels[i] = entrySet[i];
            }
            while !(done){
                done = true;
                double[][] centersOfGravity = new double[numberOfClasses][numberOfFeatures];
                int[] patternsCount = new int[numberOfClasses];
                int kMin = 0;
                for (int i = 1; i< entrySet.length; i++){
                    double minDistance = Double.MAX_VALUE;
                    for (int k = 0; k< numberOfClasses; k++){
                        double distanceToKernel = calculateDistance(entrySet[i], kernels[k]);
                        if (distanceToKernel < minDistance){
                            minDistance = distanceToKernel;
                            kMin = k;
                        }
                    }
                patternsCount[kMin]++;
                
                }
            
            
            }
        return ;
        }
}