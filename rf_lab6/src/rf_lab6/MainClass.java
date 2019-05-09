package rf_lab6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class MainClass {
	public static void main(String[] args) {
		String[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.csv");
                        double[] grades = {3.8, 5.75, 6.25, 7.25, 8.5, 9.2, 10};
			printGrades(grades, learningSet);
			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}
	static void printGrades(double[] grades, String[][] learningSet) {
	    for(int i = 0; i < grades.length; i++) {
            System.out.println("Grade = " + grades[i]);

            for(int k  = 1; k < 18; k+=2)
                getClass(learningSet, grades[i], k);
            System.out.println("---------------------------------------------------------------------------------");
            }
        }
	static boolean getClass(String[][] learningSet, double grade, int k) {
		ArrayList<GradeDiff<Double, Integer>> difNesortate = new ArrayList<GradeDiff<Double, Integer>>();
		for(int i = 0; i < learningSet.length; i++) {
			String gradeAsString = learningSet[i][0];
			difNesortate.add(new GradeDiff(Math.abs(grade - Double.valueOf(gradeAsString)), i));
		}
        ArrayList<GradeDiff<Double, Integer>> difSorted = sort(difNesortate);
        return isSufficient(difSorted, learningSet, k);
	}
    static ArrayList<GradeDiff<Double, Integer>> sort(ArrayList<GradeDiff<Double, Integer>> t) {
        ArrayList<GradeDiff<Double, Integer>> difSorted = t;

        for(int i = 0; i < t.size() - 1; i++) {
            for(int j = 0; j < t.size() - i - 1; j++)
                if(difSorted.get(j).x > difSorted.get(j + 1).x) {
                    GradeDiff<Double, Integer> temp = difSorted.get(j);
                    difSorted.set(j, difSorted.get(j + 1));
                    difSorted.set(j + 1, temp);
                }
        }
        return difSorted;
    }
    static boolean isSufficient(ArrayList<GradeDiff<Double, Integer>> t, String[][] learningSet, int k) {
        String[] nearestNeighbors = new String[k];
        String[] nearestNeighborClass = new String[k];

        int veryGood = 0;
        int good = 0;
        int sufficient = 0;
        int insufficient = 0;
	for(int i = 0; i < k; i++) {
            int index = t.get(i).y;
            nearestNeighbors[i] = learningSet[index][0];
            nearestNeighborClass[i] = learningSet[index][1];
            if (learningSet[index][1].equals("very good"))
                veryGood++;
            else if (learningSet[index][1].equals("good"))
                good++;
            else if(learningSet[index][1].equals("sufficient"))
                sufficient++;
            else 
                insufficient++;
        }
        List<Integer> classes = Arrays.asList(veryGood, good, sufficient, insufficient);
        System.out.println(k + "-NN");
        System.out.println("Nearest neighbors: " + Arrays.toString(nearestNeighbors));
        System.out.println("Nearest neighbor class: " + Arrays.toString(nearestNeighborClass));
        if (veryGood == Collections.max(classes)){
            System.out.println("Searched grade class: very good(" + veryGood + " very good, " + good + " good, " + sufficient + " sufficient and " + insufficient + " insufficient)");
            return true;
        }
        else if (good == Collections.max(classes)){
            System.out.println("Searched grade class: good(" + veryGood + " very good, " + good + " good, " + sufficient + " sufficient and " + insufficient + " insufficient)");
            return true;
        }
        else if (sufficient == Collections.max(classes)){
            System.out.println("Searched grade class: sufficient(" + veryGood + " very good, " + good + " good, " + sufficient + " sufficient and " + insufficient + " insufficient)");
            return true;
        }
        else{
            System.out.println("Searched grade class: insufficient(" + veryGood + " very good, " + good + " good, " + sufficient + " sufficient and " + insufficient + " insufficient)");
            return false;
        }
    }
}


