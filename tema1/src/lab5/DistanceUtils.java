package lab5;

public class DistanceUtils {
    public static double euclideanDistance(String[][] learningSet, String[][] searchSet, int inputNumber, int dataNumber){
        String[] firstElement = searchSet[inputNumber];
        String[] secondElement = learningSet[dataNumber];
        double sum = 0;
        for (int i = 0; i < 2; i++){
            sum = sum + Math.pow(Double.valueOf(firstElement[i]) - Double.valueOf(secondElement[i]), 2);
        }
        return Math.sqrt(sum);
    }
}
