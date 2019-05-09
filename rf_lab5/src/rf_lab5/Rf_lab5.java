package rf_lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static rf_lab5.DistanceUtils.dCityDistance;
import static rf_lab5.DistanceUtils.euclidianDistance;

public class Rf_lab5 {
	public static void main(String[] args) {
		String[][] learningSet;
                String[][] searchSet;
		try {
                        learningSet = FileUtils.readLearningSetFromFile("data.csv");
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
                        searchSet = FileUtils.readLearningSetFromFile("in.csv");
                        for (int i = 0; i < searchSet.length; i++){
                            int accuracy = 100;
                            int k = 1;
                            List<Integer> closestIndex = new ArrayList<Integer>();
                            List<String> closestClass = new ArrayList<String>();
                            do{
                            double[] distance = new double[learningSet.length];
                            for (int j = 0; j < learningSet.length; j++){
                                distance[j] = euclidianDistance(learningSet, searchSet, i, j);
                            }
                            double[] last_distance = distance;
                            closestIndex.clear();
                            closestClass.clear();
                            // System.out.print(String.format("Searched class for %s %s is: ", searchSet[i][0], searchSet[i][1]));
                            for(int o = 0; o < k; o++ ){
                                int closestPattern = 0;
                                double minDistance = last_distance[closestPattern];
                                for (int y = 0; y < last_distance.length; y++){
                                    if (last_distance[y]<minDistance && !closestIndex.contains(y)){
                                        minDistance = last_distance[y];
                                        closestPattern = y;
                                    }
                                }
                                closestIndex.add(closestPattern);
                                int classColumn = learningSet[closestPattern].length-1;
                                closestClass.add(learningSet[closestPattern][classColumn]);
                                //System.out.print(String.format(" (%s/%s) %s,", learningSet[closestPattern][0], learningSet[closestPattern][1], learningSet[closestPattern][classColumn]));
                            }
                            accuracy = Collections.frequency(closestClass, closestClass.get(0))*100/(closestClass.size());
                            k+=2;
                            } while (accuracy > 90);
                            System.out.println(String.format("Searched class for %s, %s is: %s - accouracy %s, k = %s (%s)", searchSet[i][0], searchSet[i][1],
                                                        closestClass.get(0), accuracy, k , Collections.frequency(closestClass, closestClass.get(0))));
                        }
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}
}