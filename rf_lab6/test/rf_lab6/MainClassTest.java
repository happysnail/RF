/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rf_lab6;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andrei.tarnauceanu
 */
public class MainClassTest {
    
    public MainClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getClass method, of class MainClass.
     */
    @Test
    public void testGetClass() {
        System.out.println("getClass");
        String[][] learningSet = new String[3][2];
        learningSet[0][0] = "1";
        learningSet[0][1] = "insuficient";
        learningSet[1][0] = "2";
        learningSet[1][1] = "insuficient";
        learningSet[2][0] = "3";
        learningSet[2][1] = "insuficient";
        double grade = 5.0;
        int k = 3;
        boolean expResult = false;
        boolean result = MainClass.getClass(learningSet, grade, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sort method, of class MainClass.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        ArrayList<GradeDiff<Double, Integer>> t = new ArrayList<>();
        t.add(new GradeDiff(3.5, 2));
        t.add(new GradeDiff(1.5, 2));
        t.add(new GradeDiff(2.5, 2));
        ArrayList<GradeDiff<Double, Integer>> expResult = new ArrayList<>();
        expResult.add(new GradeDiff(1.5, 2));
        expResult.add(new GradeDiff(2.5, 2));
        expResult.add(new GradeDiff(3.5, 2));
        ArrayList<GradeDiff<Double, Integer>> result = MainClass.sort(t);
        assertEquals(expResult.toString(), result.toString());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isSufficient method, of class MainClass.
     */
    @Test
    public void testIsSufficient() {
        System.out.println("isSufficient");
        ArrayList<GradeDiff<Double, Integer>> t = new ArrayList<>();
        t.add(new GradeDiff(3.5, 2));
        t.add(new GradeDiff(1.5, 2));
        t.add(new GradeDiff(2.5, 2));
        String[][] learningSet = new String[3][2];
        learningSet[0][0] = "1";
        learningSet[0][1] = "insuficient";
        learningSet[1][0] = "2";
        learningSet[1][1] = "insuficient";
        learningSet[2][0] = "3";
        learningSet[2][1] = "insuficient";
        int k = 3;
        boolean expResult = false;
        boolean result = MainClass.isSufficient(t, learningSet, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
