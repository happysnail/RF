import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
	
	
	public static void main(String[] args) {
		String[][] learningSet;
		try {
			learningSet = FileUtils.readLearningSetFromFile("in.txt");
            double[] grades = {3.8, 5.75, 6.25, 7.25, 8.5};
			subA(grades, learningSet);

            //b
//            boolean accurate = true;
//            int k = 1;
//            do {
//                if (sa(learningSet, 5.75, k))
//                    k+=2;
//                else
//                    accurate = false;
//            } while(accurate);
//            System.out.println(k-2);


			int numberOfPatterns = learningSet.length;
			int numberOfFeatures = learningSet[0].length;
			System.out.println(String.format("The learning set has %s patters and %s features", numberOfPatterns, numberOfFeatures));
		} catch (USVInputFileCustomException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finished learning set operations");
		}
	}

	static void subA(double[] grades, String[][] learningSet) {
	    for(int i = 0; i < grades.length; i++) {
            System.out.println("Grade = " + grades[i]);

            for(int k  = 1; k < 16; k+=2)
                sa(learningSet, grades[i], k);
            System.out.println("---------------------------------------------------------------------------------");
        }
    }



	static boolean sa(String[][] learningSet, double grade, int k) {
		ArrayList<Tuple<Double, Integer>> difNesortate = new ArrayList<Tuple<Double, Integer>>();
		for(int i = 0; i < learningSet.length; i++) {
			String gradeAsString = learningSet[i][0];
			difNesortate.add(new Tuple(Math.abs(grade - Double.valueOf(gradeAsString)), i));
		}
        ArrayList<Tuple<Double, Integer>> difSorted = sort(difNesortate);


        return printEverything(difSorted, learningSet, k);
	}

    static ArrayList<Tuple<Double, Integer>> sort(ArrayList<Tuple<Double, Integer>> t) {
        ArrayList<Tuple<Double, Integer>> difSorted = t;

        for(int i = 0; i < t.size() - 1; i++) {
            for(int j = 0; j < t.size() - i - 1; j++)
                if(difSorted.get(j).x > difSorted.get(j + 1).x) {
                    Tuple<Double, Integer> temp = difSorted.get(j);
                    difSorted.set(j, difSorted.get(j + 1));
                    difSorted.set(j + 1, temp);
                }
        }
        return difSorted;
    }


    static boolean printEverything(ArrayList<Tuple<Double, Integer>> t, String[][] learningSet, int k) {
        String[] nearestNeighbors = new String[k];
        String[] nearestNeighborClass = new String[k];

        int sufficient = 0;
        int insufficient = 0;

	    for(int i = 0; i < k; i++) {
            int index = t.get(i).y;
            nearestNeighbors[i] = learningSet[index][0];
            nearestNeighborClass[i] = learningSet[index][1];
            if(learningSet[index][1].equals("sufficient"))
                sufficient++;
            else
                insufficient++;
        }
        System.out.println(k + "-NN");
        System.out.println("Nearest neighbors: " + Arrays.toString(nearestNeighbors));
        System.out.println("Nearest neighbor class: " + Arrays.toString(nearestNeighborClass));
        if (sufficient > insufficient)
            System.out.println("Searched grade class: sufficient(" + sufficient + " sufficient and " + insufficient + " insufficient");
        else
            System.out.println("Searched grade class: insufficient(" + sufficient + " sufficient and " + insufficient + " insufficient");
        return sufficient > insufficient;
	}
}


