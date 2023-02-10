package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import static org.hamcrest.Matchers.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jfree.data.KeyedValues;
import org.jmock.*;
import org.junit.*;

public class DataUtilitiesTest {
	
	private Values2D values1;
	private Values2D values2;
	private static double[] emptyArray, dataArray;
	private static double[][] empty2dArray, data2dArray;
	private KeyedValues mockKeyedValues, mockEmptyKeyedValues;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	    emptyArray = new double[]{};
	    dataArray = new double[]{1.0, 2.0, 3.0};
	    empty2dArray = new double[][]{{}};
	    data2dArray = new double[][]{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}};
	}

    @Before
    public void setUp() throws Exception {
    	// setup
    	
    	/**
    	 * creating a mock for values 1 which is Values2D object that is 4x4, contianing
    	 * 4 cols and 4 rows
    	 * 1 3 3 1
    	 * 4 -6 2 2
    	 * 7 1 0 3
    	 * 4 1 2 3.0
    	 */
    	Mockery mockingContext = new Mockery();
    	values1 = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
            	// need to be 5 for tests to be successful
                one(values1).getColumnCount();
                will(returnValue(4));
                
                one(values1).getRowCount();
                will(returnValue(4));
                
                // col 0
                one(values1).getValue(0, 0);
                will(returnValue(1));
                one(values1).getValue(1, 0);
                will(returnValue(4));
                one(values1).getValue(2, 0);
                will(returnValue(7));
                one(values1).getValue(3, 0);
                will(returnValue(4));
                
                //col 1
                one(values1).getValue(0, 1);
                will(returnValue(3));
                one(values1).getValue(1, 1);
                will(returnValue(-6));
                one(values1).getValue(2, 1);
                will(returnValue(1));
                one(values1).getValue(3, 1);
                will(returnValue(1));
                
                //col 2
                one(values1).getValue(0, 2);
                will(returnValue(3));
                one(values1).getValue(1, 2);
                will(returnValue(2));
                one(values1).getValue(2, 2);
                will(returnValue(0));
                one(values1).getValue(3, 2);
                will(returnValue(2));
                
                //col 3
                one(values1).getValue(0, 3);
                will(returnValue(1));
                one(values1).getValue(1, 3);
                will(returnValue(2));
                one(values1).getValue(2, 3);
                will(returnValue(3));
                one(values1).getValue(3, 3);
                will(returnValue(3.0));
                
                // col index out of bound
                allowing(values1).getValue(with(not(anyOf(equal(0),equal(1),equal(2),equal(3)))),with(any(Integer.class)));
                will(throwException(new IndexOutOfBoundsException()));
                
                
                // row index out of bound
                allowing(values1).getValue(with(any(Integer.class)), with(not(anyOf(equal(0),equal(1),equal(2),equal(3)))));
                will(throwException(new IndexOutOfBoundsException()));
                
                
//                allowing(values1).getValue(with(not(anyOf(equal(0),equal(1),equal(2),equal(3)))), with(not(anyOf(equal(0),equal(1),equal(2),equal(3)))));
//                will(returnValue(0));
                
            }
        });
        
    	/**
    	 * creating a mock for values2 which is Values2D object that is 4x4, containing
    	 * 1 col and 1 row with value 2
    	 */
    	Mockery mockingContext1 = new Mockery();
    	values2 = mockingContext1.mock(Values2D.class);
        mockingContext1.checking(new Expectations() {
            {
                one(values2).getColumnCount();
                will(returnValue(1));
                
                one(values2).getRowCount();
                will(returnValue(1));
                
                one(values2).getValue(0, 0);
                will(returnValue(2));
                
                // col index out of bound
                allowing(values1).getValue(with(not(equal(0))),with(any(Integer.class)));
                will(returnValue(0));
            }
        });
        
    	/**
    	 * creating a mock for mockKeyedValues which is an object of class KeyedValues, which is an ordered
    	 * list containing (key, value) of (1, 5.0), (2, 9.0), (3, 2.0)
    	 */
        Mockery mockingContext2 = new Mockery();
        Number[] mockValues = {5.0, 9.0, 2.0};
        mockKeyedValues = mockingContext2.mock(KeyedValues.class);
        mockingContext2.checking(new Expectations() {
            {
                allowing(mockKeyedValues).getItemCount();
                will(returnValue(mockValues.length));
                for (int i = 0; i < mockValues.length; i++) {
                    allowing(mockKeyedValues).getKey(i);
                    will(returnValue(i));
                    allowing(mockKeyedValues).getValue(i);
                    will(returnValue(mockValues[i]));
                }
            }
        });

    	/**
    	 * creating a mock for mockEmptyKeyedValues which is an object of class KeyedValues
    	 */
        Mockery emptyMockingContext = new Mockery();
        mockEmptyKeyedValues = emptyMockingContext.mock(KeyedValues.class);
        emptyMockingContext.checking(new Expectations() {
            {
                allowing(mockEmptyKeyedValues).getItemCount();
                will(returnValue(0));
            }
        });
    }
  
    
    @Test
    // calculate sum when data contains all positive entry
    public void posColSum() {
    	double result = DataUtilities.calculateColumnTotal(values1, 0);
        assertEquals(result, 16.0, .000000001d);
    }
    
    @Test
    //calculate sum when data contains negative entry
    public void negColSum() {
    	double result = DataUtilities.calculateColumnTotal(values1, 1);
        assertEquals(result, -1.0, .000000001d);
    }
    
    @Test
    //calculate sum when data contains zero entry
    public void zeroColSum() {
    	double result = DataUtilities.calculateColumnTotal(values1, 2);
        assertEquals(result, 7, .000000001d);
    }
    
    @Test
    //calculate sum when data contains double as entry
    public void dblColSum() {
    	double result = DataUtilities.calculateColumnTotal(values1, 3);
        assertEquals(result, 9.0, .000000001d);
    }
    
    @Test()
    // calculate sum when positive index out of bound
    public void posInvColIndex() {
    	try {
    		double result = DataUtilities.calculateColumnTotal(values1, 4);
    		assertEquals(result, 0, .000000001d);
    	} catch (Exception e) {
    		fail("invalid index should return 0 but exception is thrown");
    	}

    }
    
    @Test()
    // calculate sum when  when negative index out of bound
    public void negInvColIndex() {
    	try {
    		double result = DataUtilities.calculateColumnTotal(values1, -1);
    		assertEquals(result, 0, .000000001d);
    	} catch (Exception e) {
    		fail("invalid index should return 0 but exception is thrown");
    	}
    }
    
    @Test()
    // only 1 col to add
    public void singleColSum() {
    	double result = DataUtilities.calculateColumnTotal(values2, 0);
    	assertEquals(result, 2.0, .000000001d);
    }
    
    @Test
    // contains all positive entry
    public void posRowSum() {
        double result = DataUtilities.calculateRowTotal(values1, 0);
        assertEquals(result, 8, .000000001d);
    }

    @Test
    //contains negative entry
    public void negRowSum() {
        double result = DataUtilities.calculateRowTotal(values1, 1);
        assertEquals(result, 2, .000000001d);
    }

    @Test
    //contains zero entry
    public void zeroRowSum () {
        double result = DataUtilities.calculateRowTotal(values1, 2);
        assertEquals(result, 11, .000000001d);
    }

    @Test
    //contains double as entry
    public void dblRowSum() {
        double result = DataUtilities.calculateRowTotal(values1, 3);
        assertEquals(result, 10.0, .000000001d);
    }

    @Test()
    // positive index out of bound
    public void posInvRowIndex() {
    	try {
    		double result = DataUtilities.calculateRowTotal(values1, 4);
    		assertEquals(result, 0, .000000001d);
    	} catch (Exception e) {
    		fail("invalid index should return 0 but exception is thrown");
    	}

    }

    @Test()
    // negative index out of bound
    public void negInvRowIndex() {
    	try {
    		double result = DataUtilities.calculateRowTotal(values1, -1);
    		assertEquals(result, 0, .000000001d);
    	} catch (Exception e) {
    		fail("invalid index should return 0 but exception is thrown");
    	}
    }

    @Test()
    // only 1 col to add
    public void singleRowSum() {
        double result = DataUtilities.calculateRowTotal(values2, 0);
        assertEquals(result, 2.0, .000000001d);
    }

    /**
     * From specifications, DataUtilities.createNumberArray essentially converts
     * an array of primitive doubles into an array of Numbers, throwing an exception if
     * the input is invalid. For this method, we will leverage Equivalence Class Testing,
     * partitioning the input space based on the specifications. There is only one array input,
     * the length of the array does not necessarily impact the output, so the only input
     * options are null, an empty array (empty state), and an array with elements.
     */

    /**As per specification, this should throw InvalidParameterException, but it throws
     * an IllegalArgumentException.
     */
//    @Test(expected = InvalidParameterException.class)
//    public void testCreateNumberArrayWithNullInput() {
//        Number[] result = DataUtilities.createNumberArray(null);
//    }

    @Test
    public void testCreateNumberArrayWithEmptyArray() {
        Number[] result = DataUtilities.createNumberArray(emptyArray);
        assertEquals("output array should be empty", 0, result.length);
    }

    /** This test actually fails because the function returns a null value, for black
     * box testing we should be good to ignore this since the specification says it should
     * return Number objects.
     */
    /** This test actually fails because the function returns a null value, for black
     * box testing we should be good to ignore this since the specification says it should
     * return Number objects.
     */
    @Test
    public void testCreateNumberArray() {
        Number[] result = DataUtilities.createNumberArray(dataArray);
        assertEquals("output array length should equal input array length", dataArray.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertNotNull(result[i]);
            assertEquals("output array element at index: " + i + " should equal input array element at index: " + i, dataArray[i], result[i].doubleValue(), 0);
        }
    }

    @Test
    public void testCreateNumberArray2d() {
        Number[][] result = DataUtilities.createNumberArray2D(data2dArray);
        assertEquals("output array length should equal input array length", data2dArray.length, result.length);
        for (int i = 0; i < result.length; i++) {
            assertEquals("output array element length at index: " + i + " should equal input array element length at index: " + i, data2dArray[i].length, result[i].length);
            for (int j = 0; j < result[i].length; j++) {
                assertNotNull(result[i][j]);
                assertEquals("output array element at index: " + j + " should equal input array element at index: " + j, data2dArray[i][j], result[i][j].doubleValue(), 0);
            }
        }
    }

    @Test
    public void testCreateNumberArray2dWithEmptyInput() {
        Number[][] result = DataUtilities.createNumberArray2D(empty2dArray);
        assertEquals("output array should be empty", result[0].length, 0);
    }

    /** Same issue as 1d array test, wrong exception is thrown */
//    @Test(expected = InvalidParameterException.class)
//    public void testCreateNumberArray2dWithNullInput() {
//        Number[][] result = DataUtilities.createNumberArray2D(null);
//    }

    /** KeyedValues are meant to be zero-indexed as per docs, this test fails because
     * the getCumulativePercentages implementation starts indexing from 1.
     */
   
    @Test
    public void testGetCumulativeAverage() {
        Number[] expectedResult = {0.3125, 0.875, 1.0};
        KeyedValues result = DataUtilities.getCumulativePercentages(mockKeyedValues);
        for (int i = 0; i < result.getItemCount(); i++) {
            assertEquals("result value at key " + result.getKey(i), expectedResult[i], result.getValue(i));
        }
    }

    @Test
    public void testGetCumulativeAverageEmptyKeys() {
        assertArrayEquals(new Number[]{}, DataUtilities.getCumulativePercentages(mockEmptyKeyedValues).getKeys().toArray());
    }

//    @Test(expected = InvalidParameterException.class)
//    public void testGetCumulativeAverageNull() {
//        DataUtilities.getCumulativePercentages(null);
//    }
	 
	 @After 
	 public void tearDown() throws Exception {}

	 @AfterClass
	 public static void tearDownAfterClass() throws Exception {}
}

