/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kirby
 */
public class Hw2Test {
    
    public Hw2Test() {
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
     * Tests of reverseavg method, of class Hw2.
     */
    @Test
    public void testReverseavg1() 
    {
        System.out.println("reverseavg");
        int R1_ = 11;
        int avg_ = 15;
        int expResult = 19;
        int result = Hw2.reverseavg(R1_, avg_);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testReverseavg2() 
    {
        System.out.println("reverseavg");
        int R1_ = 4;
        int avg_ = 3;
        int expResult = 2;
        int result = Hw2.reverseavg(R1_, avg_);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testReverseavg3() 
    {
        System.out.println("reverseavg");
        int R1_ = 0;
        int avg_ = 10;
        int expResult = 20;
        int result = Hw2.reverseavg(R1_, avg_);
        assertEquals(expResult, result);
    }
}
