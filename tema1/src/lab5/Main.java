package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[][] dataSet;
        String[][] inputSet;
        try {
            dataSet = FileUtils.readBiDimensionalStringFromFile("data.csv");
            inputSet = FileUtils.readBiDimensionalStringFromFile("in.csv");
            for (int i = 0; i < inputSet.length; i++){
                List<Integer> closestIndex = new ArrayList<>();
                List<String> closestCities = new ArrayList<>();
                int accuracy;
                int k = 1;
                do{
                    double[] distances = new double[dataSet.length];
                    for (int j = 0; j < dataSet.length; j++){
                        distances[j] = DistanceUtils.euclideanDistance(dataSet, inputSet, i, j);
                    }
                    closestIndex.clear();
                    closestCities.clear();
                    for(int o = 0; o < k; o++ ){
                        int closestCityIndex = 0;
                        double minDistance = distances[closestCityIndex];
                        for (int y = 1; y < distances.length; y++){
                            if (distances[y] < minDistance && !closestIndex.contains(y)){
                                minDistance = distances[y];
                                closestCityIndex = y;
                            }
                        }
                        closestIndex.add(closestCityIndex);
                        int cityColumn = dataSet[closestCityIndex].length-1;
                        closestCities.add(dataSet[closestCityIndex][cityColumn]);
                    }
                    accuracy = Collections.frequency(closestCities, closestCities.get(0))*100/(closestCities.size());
                    k+=2;
                } while (accuracy > 90);
                System.out.println(String.format("Closest city with %s, %s is: %s - accuracy %s, k = %s", inputSet[i][0], inputSet[i][1],
                        closestCities.get(0), accuracy, k));
            }
        } catch (USVInputFileCustomException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finished learning set operations");
        }
    }
}

