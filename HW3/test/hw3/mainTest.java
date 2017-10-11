/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

import java.util.ArrayList;
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
public class mainTest {
    
    public mainTest() {
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
     * Test of sort method, of class main.
     */
    @Test
    public void sort1() 
    {
        System.out.println("sort1");
        ArrayList<String> array_ = new ArrayList<String>();
        array_.add("c");
        array_.add("b");
        array_.add("a");
        array_.add("d");
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("a");
        expResult.add("b");
        expResult.add("c");
        expResult.add("d");
        ArrayList<String> result = main.sort(array_);
        assertEquals(expResult, result);
    }
    @Test
    public void sort2() 
    {
        System.out.println("sort12");
        ArrayList<String> array_ = new ArrayList<String>();
        array_.add("h");
        array_.add("g");
        array_.add("f");
        array_.add("e");
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("e");
        expResult.add("f");
        expResult.add("g");
        expResult.add("h");
        ArrayList<String> result = main.sort(array_);
        assertEquals(expResult, result);
    }
    @Test
    public void sort3() 
    {
        System.out.println("sort3");
        ArrayList<String> array_ = new ArrayList<String>();
        array_.add("4");
        array_.add("2");
        array_.add("1");
        array_.add("3");
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("1");
        expResult.add("2");
        expResult.add("3");
        expResult.add("4");
        ArrayList<String> result = main.sort(array_);
        assertEquals(expResult, result);
    }
}
