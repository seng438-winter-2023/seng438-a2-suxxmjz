package org.jfree.data.test;
import org.jfree.data.Range;
import static org.junit.Assert.*;

import org.junit.*;

public class RangeTest {

    private Range negPosInts;
    private Range positiveInts; 
    private Range negativeInts;
    private Range zeroNum;
    private Range zerowithInt;
    private Range zerowithNegInt;
    private Range negPosFloat;
    private Range negFloat;
    private Range posFloat;
 	private static Range exampleRangeEqual, 
    minMaxRange, smallestUBRange, zeroUBRange, floatRange, largestLBRange,zeroLBRange;
    private static double smallestDouble = Double.MIN_VALUE;
    private static double largestDouble = Double.MAX_VALUE;
    private static Range negRange,posRange,duplicateNegRange,
    samePosLBRange,samePosUBRange, equivRange, nullRange1,nullRange2;
    
    
    @BeforeClass 
    public static void setUpBeforeClass() throws Exception {}

    
    @Before
    public void setUp() throws Exception { 
    	negPosInts = new Range(-50, 50);
    	positiveInts = new Range(5, 100);
    	negativeInts = new Range(-100,-5);
    	zeroNum = new Range(0,0);
    	zerowithInt = new Range(0,10);
    	negPosFloat = new Range(-3.457,8.535);
    	negFloat = new Range (-7.442,-5.632);
    	posFloat = new Range (6.424, 9.324);
    	zerowithNegInt = new Range (-10,0);
    	negRange = new Range(-100, -80);
    	exampleRangeEqual = new Range(1,1);
    	posRange = new Range(100, 1000);
    	minMaxRange = new Range(smallestDouble,largestDouble);
    	smallestUBRange = new Range(smallestDouble, smallestDouble);
    	zeroUBRange = new Range(-1000,0);
    	floatRange = new Range(1.234, 7.899);
    	largestLBRange = new Range(largestDouble,largestDouble);
    	zeroLBRange = new Range(0,1000);
    	duplicateNegRange = new Range(-100,-80);
    	samePosLBRange = new Range(100,150);
    	samePosUBRange = new Range(20,1000);
    	equivRange = new Range(80,100);
    	nullRange1 = null;


    }

	  //test length of positive and negative integers input
	    @Test
	    public void negPosIntsTest() {
	        assertEquals(100, negPosInts.getLength(), .000000001d);
	    }
	
	    //test length of negative integers input
	    @Test
	    public void negativeIntsTest() {
	        assertEquals(95, negativeInts.getLength(), .000000001d);
	    }
	
	    //test length of positive integers input
	    @Test
	    public void positiveIntsTest() {
	        assertEquals(95, positiveInts.getLength(), .000000001d);
	    }
	
	    //test length of  zero input
	    @Test
	    public void zeroTest() {
	        assertEquals(0, zeroNum.getLength(), .000000001d);
	    }
	  
	    //test length of  positive and negative floats inputs
		@Test
	   public void negPosFloatTest() {
	        assertEquals(11.992, negPosFloat.getLength(), .000000001d);
	    }
		
	     //test length of  positive floats inputs
		@Test
	   public void posFloatTest() {
	        assertEquals(2.9, posFloat.getLength(), .000000001d);
	    }
	    
	     //test length of  negative floats inputs
		@Test
		   public void negFloatTest() {
		        assertEquals(1.81, negFloat.getLength(), .000000001d);
		   }
	
		 //test length of zero with a positive integer inputs
		@Test
	    public void zeroWithIntTest() {
	        assertEquals(10, zerowithInt.getLength(), .000000001d);
	    }
	     
	    //test length of zero with a negative integer inputs
	    @Test
		public void zerowithNegIntTest(){
	        assertEquals(10, zerowithNegInt.getLength(), .000000001d);
	    }
	    
	    
		
		
	    //test central value of negative and positive integers inputs
	    @Test
	    public void negPosIntsCentralValueTest() {
	        assertEquals(0, negPosInts.getCentralValue(), .000000001d);
	    }
	
	    //test central value of positive integers inputs
	    @Test
	    public void positiveIntCentralValueTest() {
	        assertEquals(52.5, positiveInts.getCentralValue(), .000000001d);
	    }
	    
	    //test central value of zero inputs
	    @Test
	    public void zeroNumCentralValueTest() {
	    	assertEquals(0, zeroNum.getCentralValue(), .000000001d);
	    }
	    
	    //test central value of negative and positive floats inputs
	    @Test
	    public void negPosFloatCentralValueTest() {
	        assertEquals(2.539, negPosFloat.getCentralValue(), .000000001d);
	    }
	
	    //test central value of negative  floats inputs
	    @Test
	    public void negativeFloatCentralValueTest() {
	        assertEquals(-6.537, negFloat.getCentralValue(), .000000001d);
	    }
	    
	     //test central value of negative integers
	    @Test
	    public void negativeIntsCentralValueTest() {
	        assertEquals(-52.5, negativeInts.getCentralValue(), .000000001d);
	    }
	    
	    //test central value of positive floats inputs
	    @Test
	    public void positiveFloatCentralValueTest() {
	        assertEquals(7.874, posFloat.getCentralValue(), .000000001d);
	    }
	    
	    //test central value of zero and positive integer inputs
	    @Test
	    public void zeroWithIntCentralValueTest() {
	        assertEquals(5, zerowithInt.getCentralValue(), .000000001d);
	    }
	    
	    //test central value of zero and negative floats inputs
	    @Test
	    public void zeroWithNegIntCentralValueTest() {
	        assertEquals(-5, zerowithNegInt.getCentralValue(), .000000001d);
	    }
	        
    	
    	@Test
    	  public void negativeUpperBound() { //test for negative numbers
    	    	assertEquals("The upper bound of (-100,-80) should be -80.", -80,
    	    			negRange.getUpperBound(), .000000001d);
    	    }
    	@Test
    	    public void positiveUpperBound() { //test for positive numbers
    	    	assertEquals("The upper bound of (100,1000) should be 1000.", 1000,
    	    			posRange.getUpperBound(), .000000001d);
    	    }
    	 @Test
    	    public void UpperBoundWhenEqualToLowerBound() { //this test passes only because the LB and UB are same, but still gets LB
    	    	assertEquals("The upper bound of (1,1) should be 1.", 1,
    	    			exampleRangeEqual.getUpperBound(), .000000001d);
    	    }
    	 @Test
    	    public void smallestUpperBound() { //this test covers the minimum value for the upper bound
    	    	assertEquals("The upper bound of (smallestDouble, smallestDouble) should be 4.9E-324.", 4.9E-324,
    	    			smallestUBRange.getLowerBound(),000000001d);
    	    }
    	    
    	 @Test
    	    public void largestUpperBound() { //this test covers the maximum value for the upper bound
    	    	assertEquals("The upper bound of (smallestDouble,largestDouble) should be 1.7976931348623157E308.",
    	    			1.7976931348623157E308, minMaxRange.getUpperBound(),000000001d);
    	    }
    	@Test
    	   public void upperBoundisZero() { //test for upper bound when zero
    	    	assertEquals("The upper bound of (-1000,0) should be 0.", 0,
    	    			zeroUBRange.getUpperBound(), .000000001d);
    	    }
    	
    	@Test
    	   public void upperBoundisFloat() { //test for upper bound when it's a float
    	    	assertEquals("The upper bound of (1.234, 7.899) should be 7.899.", 7.899,
    	    			floatRange.getUpperBound(), .000000001d);
    	    }

    	@Test
        public void negativeLowerBound() { //tests when the lower bound is negative
        	assertEquals("The lower bound of (-100,-80) should be -100.", -100,
        			negRange.getLowerBound(), .000000001d);
        }
        
        @Test
        public void positiveLowerBound() { //tests when the lower bound is positive
        	assertEquals("The lower bound of (100,1000) should be 100.", 100,
        			posRange.getLowerBound(), .000000001d);
        }
        @Test
        public void LowerBoundWhenEqualToUpperBound() { //tests when the lower bound and the upper bound are the same
        	assertEquals("The lower bound of (1,1) should be 1.", 1,
        			exampleRangeEqual.getLowerBound(), .000000001d);
        }
        
        @Test
        public void smallestLowerBound() { //tests the smallest possible value for a double in the lower bound
        	assertEquals("The lower bound of (smallestDouble,7) should be 4.9E-324.", 4.9E-324,
        			minMaxRange.getLowerBound(),000000001d);
        }
        
        @Test
        public void largestLowerBound() { //tests the largest possible value for a double in the lower bound
        	assertEquals("The lower bound of (largestDouble,largestDouble) should be 1.7976931348623157E308.",
        			1.7976931348623157E308, largestLBRange.getLowerBound(),000000001d);
        }
        @Test
        public void lowerBoundIsZero() { //tests when the lower bound is a zero
        	assertEquals("The lower bound of (0,1000) should be 0.", 0,
        			zeroLBRange.getLowerBound(), .000000001d);
        }
        
        @Test
        public void lowerBoundIsAFloat() { //tests when the lower bound is a float
        	assertEquals("The lower bound of (1.234, 7.899) should be 1.234", 1.234,
        			floatRange.getLowerBound(),.000000001d );
        }
        
        @Test 
        public void sameRangeTrue() { //when the two ranges have the same upper and lower bound
        	assertEquals("The ranges (-100,-80) and (-100,-80) are equal", true,
        			negRange.equals(duplicateNegRange));
        }
        @Test
        public void sameLBRange() { //tests when the lower bounds are the same
        	assertEquals("The ranges (100,1000) and (100,150) are not equal", false,
        			samePosLBRange.equals(posRange));
        }
        
        @Test
        public void sameUBRange() { //tests when the upper bounds are the same
        	assertEquals("The ranges (100,1000) and (20,1000) are not equal", false,
        			samePosUBRange.equals(posRange));
        }
        @Test
        public void oneNullRange() { //tests when one object is null
        	assertEquals("The ranges (100,1000) and null are not equal", false,
        			posRange.equals(nullRange1));
        }

    
	    @After
	    public void tearDown() throws Exception {}

	    @AfterClass
	    public static void tearDownAfterClass() throws Exception {}
    
}