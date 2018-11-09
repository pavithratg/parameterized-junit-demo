package com.eviac.blog.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * step 5: mark the class with the annotation @RunWith to run with Parameterized
 * JUnit runner instead of default JUnit runner.
 *
 */
@RunWith(Parameterized.class)
public class CalculatorImplTest {

	/**
	 * step 1: identifying different inputs and results, and create global variables
	 * for them.
	 */
	// input
	private int x;
	// input
	private int y;
	// result
	private int expectedResult;

	private Calculator c;

	/**
	 * step 2: creating a constructor which takes inputs and results as the
	 * parameters.
	 * 
	 * @param x
	 * @param y
	 * @param result
	 */
	public CalculatorImplTest(int x, int y, int result) {
		super();
		this.x = x;
		this.y = y;
		this.expectedResult = result;
	}

	@Before
	public void setup() {
		c = new CalculatorImpl();
	}

	/**
	 * step 3: create a static method which will feed all the combinations of data,
	 * and mark it with the Junit annotation @Parameters.
	 * 
	 * @return
	 */
	@Parameters
	public static Collection<Integer[]> data() {
		return Arrays.asList(new Integer[][] { { -1, 2, 1 }, { 2, 3, 5 }, { 6, 7, 13 } });
	}

	@Test
	public void add_method_should_return_result() {
		int result = c.add(x, y);
		assertEquals(expectedResult, result);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getResult() {
		return expectedResult;
	}

	public void setResult(int result) {
		this.expectedResult = result;
	}

	public Calculator getC() {
		return c;
	}

	public void setC(Calculator c) {
		this.c = c;
	}

}
