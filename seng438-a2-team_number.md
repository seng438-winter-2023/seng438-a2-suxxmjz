**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:  22    |     |
| -------------- | --- |
| Fanny Lo |     |
|Caroline Basta         |     |
|Sukriti Sharma          |     |
|Dhyey Lalseta            |     |

**Introduction**

In this lab, we familiarized ourselves with the JUnit framework and Javadoc. We applied black-box testing strategies to create several test cases using the JUnit framework. Additionally, mocks were implemented when necessary. These test cases were then executed against the system. 

**Detailed description of unit test strategy**

When we tried to create a test suite for a method, we first examined the documentation for the specific methods in index.html. After understanding the expected inputs, outputs and behaviors, we then create test cases with the standard input to verify the standard output is given. Afterwards, we break down the inputs into equivalence classes and test the boundary cases. If the methods are expected to throw exceptions, we also created test cases to verify that the right type of exception is thrown. 

A benefit of mocking is that you are able to simulate a database without altering an actual database, removing the complexity of writing queries. In addition, mocking removes the issues with dependencies so that one can focus on testing a specific object, rather than the whole method. A drawback would be the extra time to set up in the code, taking up extra memory and space. 

**Test Cases Developed**

<span style="text-decoration:underline;">Range Class Test Suite</span>


<table>
  <tr>
   <td><strong>TC#</strong>
   </td>
   <td><strong>Test Case Name</strong>
   </td>
   <td><strong>Function under</strong>
<p>
<strong>test</strong>
   </td>
   <td><strong>Input(2 Range objects)</strong>
   </td>
   <td><strong>Expected Output</strong>
   </td>
  </tr>
  <tr>
   <td>1
   </td>
   <td>sameRangeTrue
   </td>
   <td>Equals
   </td>
   <td>(-100,-80) and
<p>
(-100,-80)
   </td>
   <td>True
   </td>
  </tr>
  <tr>
   <td>2
   </td>
   <td>sameLBRange
   </td>
   <td>Equals
   </td>
   <td>(100,1000) and
<p>
(100,150)
   </td>
   <td>False
   </td>
  </tr>
  <tr>
   <td>3
   </td>
   <td>sameUBRange
   </td>
   <td>Equals
   </td>
   <td>(100,1000) and
<p>
(20,1000)
   </td>
   <td>False
   </td>
  </tr>
  <tr>
   <td>4
   </td>
   <td>oneNullRange
   </td>
   <td>Equals
   </td>
   <td>(-100,1000) and
<p>
null
   </td>
   <td>False
   </td>
  </tr>
  <tr>
   <td>5
   </td>
   <td>negativeLowerBound
   </td>
   <td>getLowerBound
   </td>
   <td>(-100,-80)
   </td>
   <td>-100
   </td>
  </tr>
  <tr>
   <td>6
   </td>
   <td>positiveLowerBound
   </td>
   <td>getLowerBound
   </td>
   <td>(100,1000)
   </td>
   <td>100
   </td>
  </tr>
  <tr>
   <td>7
   </td>
   <td>LowerBoundWhenEqualToUpperBound
   </td>
   <td>getLowerBound
   </td>
   <td>(1,1)
   </td>
   <td>1
   </td>
  </tr>
  <tr>
   <td>8
   </td>
   <td>smallestLowerBound
   </td>
   <td>getLowerBound
   </td>
   <td>(4.9E-324, 7)
   </td>
   <td>4.9E-324
   </td>
  </tr>
  <tr>
   <td>9
   </td>
   <td>largestLowerBound
   </td>
   <td>getLowerBound
   </td>
   <td>(1.7976931348623157E308, 1.7976931348623157E308)
   </td>
   <td>1.7976931348623157E308
   </td>
  </tr>
  <tr>
   <td>10
   </td>
   <td>lowerBoundIsZero
   </td>
   <td>getLowerBound
   </td>
   <td>(0,1000)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>11
   </td>
   <td>lowerBoundIsAFloat
   </td>
   <td>getLowerBound
   </td>
   <td>(1.234,7.899)
   </td>
   <td>1.234
   </td>
  </tr>
  <tr>
   <td>12
   </td>
   <td>negativeUpperBound
   </td>
   <td>getUpperBound
   </td>
   <td>(-100,-80)
   </td>
   <td>-80
   </td>
  </tr>
  <tr>
   <td>13
   </td>
   <td>positiveUpperBound
   </td>
   <td>getUpperBound
   </td>
   <td>(100,1000)
   </td>
   <td>1000
   </td>
  </tr>
  <tr>
   <td>14
   </td>
   <td>UpperBoundWhenEqualToLowerBound
   </td>
   <td>getUpperBound
   </td>
   <td>(1,1)
   </td>
   <td>1
   </td>
  </tr>
  <tr>
   <td>15
   </td>
   <td>smallestUpperBound
   </td>
   <td>getUpperBound
   </td>
   <td>(4.9E-324,4.9E-32)
   </td>
   <td>4.9E-32
   </td>
  </tr>
  <tr>
   <td>16
   </td>
   <td>largestUpperBound
   </td>
   <td>getUpperBound
   </td>
   <td>(4.9E-324,1.7976931348623157E308)
   </td>
   <td>1.7976931348623157E308
   </td>
  </tr>
  <tr>
   <td>17
   </td>
   <td>upperBoundisZero
   </td>
   <td>getUpperBound
   </td>
   <td>(-1000,0)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>18
   </td>
   <td>upperBoundisFloat
   </td>
   <td>getUpperBound
   </td>
   <td>(1.234,7.899)
   </td>
   <td>7.899
   </td>
  </tr>
  <tr>
   <td>19
   </td>
   <td>negPosIntsTest
   </td>
   <td>getLength
   </td>
   <td>(-50,50)
   </td>
   <td>100
   </td>
  </tr>
  <tr>
   <td>20
   </td>
   <td>positiveIntsTest
   </td>
   <td>getLength
   </td>
   <td>(5, 100)
   </td>
   <td>95
   </td>
  </tr>
  <tr>
   <td>21
   </td>
   <td>negativeIntsTest
   </td>
   <td>getLength
   </td>
   <td>(-100,-5)
   </td>
   <td>95
   </td>
  </tr>
  <tr>
   <td>22
   </td>
   <td>zeroTest
   </td>
   <td>getLength
   </td>
   <td>(0,0)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>23
   </td>
   <td>zeroWithIntTest
   </td>
   <td>getLength
   </td>
   <td>(0,10)
   </td>
   <td>10
   </td>
  </tr>
  <tr>
   <td>24
   </td>
   <td>negPosFloatTest
   </td>
   <td>getLength
   </td>
   <td>(-3.457,8.535)
   </td>
   <td>11.992
   </td>
  </tr>
  <tr>
   <td>25
   </td>
   <td>negFloatTest
   </td>
   <td>getLength
   </td>
   <td>(-7.442,-5.632)
   </td>
   <td>1.81
   </td>
  </tr>
  <tr>
   <td>26
   </td>
   <td>posFloatTest
   </td>
   <td>getLength
   </td>
   <td>(6.424,9.324)
   </td>
   <td>2.9
   </td>
  </tr>
  <tr>
   <td>27
   </td>
   <td>zerowithNegIntTest
   </td>
   <td>getLength
   </td>
   <td>(-10,0)
   </td>
   <td>10
   </td>
  </tr>
  <tr>
   <td>28
   </td>
   <td>negPosIntsCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(-50,50)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>29
   </td>
   <td>positiveIntCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(5, 100)
   </td>
   <td>52.5
   </td>
  </tr>
  <tr>
   <td>30
   </td>
   <td>negativeIntsCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(-100,-5)
   </td>
   <td>-52.5
   </td>
  </tr>
  <tr>
   <td>31
   </td>
   <td>zeroNumCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(0,0)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>32
   </td>
   <td>zeroWithIntCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(0,10)
   </td>
   <td>5
   </td>
  </tr>
  <tr>
   <td>33
   </td>
   <td>negPosFloatCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(-3.457,8.535)
   </td>
   <td>2.539
   </td>
  </tr>
  <tr>
   <td>34
   </td>
   <td>negativeFloatCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(-7.442,-5.632)
   </td>
   <td>-6.537
   </td>
  </tr>
  <tr>
   <td>35
   </td>
   <td>positiveFloatCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(6.424,9.324)
   </td>
   <td>7.874
   </td>
  </tr>
  <tr>
   <td>36
   </td>
   <td>zeroWithNegIntCentralValueTest
   </td>
   <td>getCentralValue
   </td>
   <td>(-10,0)
   </td>
   <td>-5
   </td>
  </tr>
</table>


<span style="text-decoration:underline;">Data Utilites Class Test</span>

Stub for input data (Values2D): values1


<table>
  <tr>
   <td>1
   </td>
   <td>3
   </td>
   <td>3
   </td>
   <td>1
   </td>
  </tr>
  <tr>
   <td>4
   </td>
   <td>-6
   </td>
   <td>2
   </td>
   <td>2
   </td>
  </tr>
  <tr>
   <td>7
   </td>
   <td>1
   </td>
   <td>0
   </td>
   <td>3
   </td>
  </tr>
  <tr>
   <td>4
   </td>
   <td>1
   </td>
   <td>2
   </td>
   <td>3.0
   </td>
  </tr>
</table>


Stub for input data (Values2D): values2


```
2
```



<table>
  <tr>
   <td>TC#
   </td>
   <td>Test Name
   </td>
   <td>Method under test
   </td>
   <td>Input data
   </td>
   <td>Input Column
   </td>
   <td>Expected output
   </td>
  </tr>
  <tr>
   <td>1
   </td>
   <td>posColSum
   </td>
   <td>calculateColumnTotal
   </td>
   <td>values1
   </td>
   <td>0 (contains all positive entries)
   </td>
   <td>16
   </td>
  </tr>
  <tr>
   <td>2
   </td>
   <td>negColSum
   </td>
   <td>calculateColumnTotal
   </td>
   <td>values1
   </td>
   <td>1 (Column contains negative entry)
   </td>
   <td>-1
   </td>
  </tr>
  <tr>
   <td>3
   </td>
   <td>zeroColSum
   </td>
   <td>calculateColumnTotal
   </td>
   <td>values1
   </td>
   <td>2(Column contains zero as entry)
   </td>
   <td>7
   </td>
  </tr>
  <tr>
   <td>4
   </td>
   <td>dblColSum
   </td>
   <td>calculateColumnTotal
   </td>
   <td>values1 
   </td>
   <td>3 (Column contains entry of type zero)
   </td>
   <td>9.0
   </td>
  </tr>
  <tr>
   <td>5
   </td>
   <td>posInvColIndex
   </td>
   <td>calculateColumnTotal
   </td>
   <td>values1
   </td>
   <td>4 (Positive index out of bound)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>6
   </td>
   <td>negInvColIndex
   </td>
   <td>calculateColumnTotal
   </td>
   <td>values1
   </td>
   <td>-1 (Negative index out of bound)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>7
   </td>
   <td>singleColSum
   </td>
   <td>calculateColumnTotal
   </td>
   <td>values2
   </td>
   <td>0 (only 1 column)
   </td>
   <td>2
   </td>
  </tr>
  <tr>
   <td>8
   </td>
   <td>posRowSum
   </td>
   <td>calculateRowTotal
   </td>
   <td>values1
   </td>
   <td>0 (contains all positive entries)
   </td>
   <td>8
   </td>
  </tr>
  <tr>
   <td>9
   </td>
   <td>negRowSum
   </td>
   <td>calculateRowTotal
   </td>
   <td>values1
   </td>
   <td>1 (row contains negative entry)
   </td>
   <td>2
   </td>
  </tr>
  <tr>
   <td>10
   </td>
   <td>zeroRowSum
   </td>
   <td>calculateRowTotal
   </td>
   <td>values1
   </td>
   <td>2(row contains zero as entry)
   </td>
   <td>11
   </td>
  </tr>
  <tr>
   <td>11
   </td>
   <td>dblRowSum
   </td>
   <td>calculateRowTotal
   </td>
   <td>values1 
   </td>
   <td>3 (row contains entry of type zero)
   </td>
   <td>10.0
   </td>
  </tr>
  <tr>
   <td>12
   </td>
   <td>posInvRowIndex
   </td>
   <td>calculateRowTotal
   </td>
   <td>values1
   </td>
   <td>4 (Positive index out of bound)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>13
   </td>
   <td>negInvRowIndex
   </td>
   <td>calculateRowTotal
   </td>
   <td>values1
   </td>
   <td>-1 (Negative index out of bound)
   </td>
   <td>0
   </td>
  </tr>
  <tr>
   <td>14
   </td>
   <td>singleRowSum
   </td>
   <td>calculateRowTotal
   </td>
   <td>values2
   </td>
   <td>0 (only 1 row)
   </td>
   <td>2
   </td>
  </tr>
</table>


Test suite for createNumberArray()


<table>
  <tr>
   <td>TC #
   </td>
   <td>Test Name
   </td>
   <td>Method under test
   </td>
   <td>Input
   </td>
   <td>Expected Output
   </td>
  </tr>
  <tr>
   <td>1
   </td>
   <td>testCreateNumberArray
   </td>
   <td>creatNumberArray
   </td>
   <td>{1.0, 2.0, 3.0}
   </td>
   <td>{1.0, 2.0, 3.0}
   </td>
  </tr>
  <tr>
   <td>2
   </td>
   <td>testCreateNumberArrayWithEmptyArray
   </td>
   <td>creatNumberArray
   </td>
   <td>{}
   </td>
   <td>{}
   </td>
  </tr>
  <tr>
   <td>3
   </td>
   <td>testCreateNumberArray2d
   </td>
   <td>creatNumberArray2D
   </td>
   <td>{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}
   </td>
   <td>{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}
   </td>
  </tr>
  <tr>
   <td>4
   </td>
   <td>testCreateNumberArray2dWithEmptyArray
   </td>
   <td>creatNumberArray2D
   </td>
   <td>{{}}
   </td>
   <td>{{}}
   </td>
  </tr>
</table>


Test suite for getCumulativeAverages()


<table>
  <tr>
   <td>TC #
   </td>
   <td>Test name
   </td>
   <td>Input (KeyedValues mock)
   </td>
   <td>Expected Output
   </td>
  </tr>
  <tr>
   <td>1
   </td>
   <td>testGetCumulativeAverages
   </td>
   <td>{5.0, 9.0, 2.0}
   </td>
   <td>{0.3125, 0.875, 1.0}
   </td>
  </tr>
  <tr>
   <td>2
   </td>
   <td>testGetCumulativeAveragesEmptyKeys
   </td>
   <td>{}
   </td>
   <td>{}
   </td>
  </tr>
</table>


**How the team work/effort was divided and managed**

	The methods to test were split up evenly based on complexity. Internal deadlines were set to ensure the completion of individual tasks. After the team members individually completed their test suites, the team met together to review each othersâ€™ test cases, looking for potentially missed edge cases and ensuring everyone understood all the cases. All the test cases were extruded against the system again to ensure accuracy between the report and written code. This allows all group members to get comfortable with the various classes, methods, and test suites, in preparation for the technical demo.

**Difficulties encountered, challenges overcome, and lessons learned**

The code implementation for the classes are not given, therefore we performed black box testing. Although there are documentations of the classes provided for the methods so we know the expected input and output, there is still ambiguity, especially when the method is "buggy" and doesn't behave like expected. This becomes especially challenging when using mocks. Without knowing the specific implementations, we donâ€™t know what methods and return values should be mocked.

This assignment is very helpful in understanding JUnit and the concept of mocks. Having hands-on experience of writing unit tests and implementing mocks for the tests helped us understand how crucial these tools are in testing.

**Comments/feedback on the lab itself**



* The lab was an exciting approach to black box testing, enabling us to really get our hands on the program and give us the ability to dive deep into the code.
* The lab document was very detailed which helped us follow through with the steps and what is expected to be completed and how. 
* Overall, we found the lab document to be insightful and helped us solidify our knowledge of black box testing and how to incorporate and utilize  mocking into our testing strategies. 
