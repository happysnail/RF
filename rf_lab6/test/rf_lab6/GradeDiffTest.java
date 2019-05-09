/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rf_lab6;

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
public class GradeDiffTest {
    
    public GradeDiffTest() {
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
     * Test of toString method, of class GradeDiff.
     */
    @Test
    public void testToString() {
        System.out.println("ToString");
        GradeDiff instance = new GradeDiff(1.5, 2);
        String expResult = "1.5 2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
