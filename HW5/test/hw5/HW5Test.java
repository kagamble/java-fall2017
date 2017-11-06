/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import static hw5.HW5.run;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HW5Test {
    
    public HW5Test() {
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
     * Test of run method, of class HW5.
     */
    @Test
    public void testRun1() 
    {
        System.out.println("run1");
        String[] string1 = {"1", "2", "3"};
        int sum1 = 6;
        int sum = run(Arrays.stream(string1).sequential());
        assertEquals(sum1, sum);
    }
    
    @Test
    public void testRun2() 
    {
        System.out.println("run2");
        String[] string1 = {"1", "2", "3"};
        int sum1 = 6;
        int sum = run(Arrays.stream(string1).parallel());
        assertEquals(sum1, sum);
    }
}
