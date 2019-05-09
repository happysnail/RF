package rf_lab3;

import java.util.Arrays;
import static rf_lab3.DistanceUtils.dCityDistance;
import static rf_lab3.DistanceUtils.euclidianDistance;

public class Rf_lab3 {
	public static void main(String[] args) {
		double[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
                        double[][] distance = new double[learningSet.length][learningSet.length];
                        for (int i = 0; i < learningSet.length; i++){
                            for (int j = i+1; j < learningSet.length; j++){
                                distance[i][j] = euclidianDistance(learningSet, i, j);
                                distance[j][i] = distance[i][j];
                            }
                            System.out.println(" ");
                        }
                        for(double[] element: distance){
                            for(double item: element){
                                System.out.print(String.format("%f ", item));
                            }
                            System.out.println();
                        }
                        double[] last_distance = distance[distance.length - 1];
                        int searchPattern = learningSet.length -1;
                        int closestPattern = 0;
                        double minDistance = last_distance[closestPattern];
                        for (int i = 0; i < last_distance.length; i++){
                            if (last_distance[i]<minDistance && searchPattern!= i){
                                minDistance = last_distance[i];
                                closestPattern = i;       
                            }
                        }
                        int classColumn = learningSet[closestPattern].length-1;
                        System.out.println(String.format("Searched class is %s", learningSet[closestPattern][classColumn]));
                        //dCityDistance(learningSet);
			//System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}
}