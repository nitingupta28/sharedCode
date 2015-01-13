package com.tdd.primeProdMatrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeProdMatrixTest {

	PrimeProdMatrix testObj = new PrimeProdMatrix();

	@Test
	public void testCreatePrimeMatrixTestObj() throws Exception {
		assertNotNull(testObj);
	}
	
	@Test
	public void testOneIsNotPrime() throws Exception {
		assertFalse(testObj.isPrime(1));
	}
	
	@Test
	public void testIsPrime() throws Exception {
		assertTrue(testObj.isPrime(3));
	}
	
	@Test
	public void testIsNotPrime() throws Exception {
		assertFalse(testObj.isPrime(4));
	}
	
	@Test
	public void testGenerateNoPrimeArrayBasedOnNumZero() throws Exception {
		int[][] expectedArray = null;
		int[][] actualArray = testObj.primeArrayRowAndCol(0);
		assertArrayEquals(expectedArray,actualArray);
	}
	
	@Test
	public void testGenerateOnePrimeBasedOnNumAndStoreItIn2DArrayRowAndColumn() throws Exception {
		int[][] expectedArray = {{2}};
		int[][] actualArray = testObj.primeArrayRowAndCol(1);
		assertArrayEquals(expectedArray,actualArray);
	}
	
	@Test
	public void testGenerateTwoPrimeBasedOnNumAndStoreItIn2DArrayRowAndColumn() throws Exception {
		int[][] expectedArray = {{2,3},{3,0}};
		int[][] actualArray = testObj.primeArrayRowAndCol(2);
		assertArrayEquals(expectedArray,actualArray);
	}
	
	@Test
	public void testMultiplyPrimeNumInRowAndColWithOneElement() throws Exception {
		int[][] primeRowColArray = {{2}};
		int[][] expectedArray = {{2}};
		int[][] actualArray = testObj.multiplyPrime(primeRowColArray);
		assertArrayEquals(expectedArray,actualArray);
	}
	
	@Test
	public void testMultiplyPrimeNumInRowAndCol() throws Exception {
		int[][] primeRowColArray = {{2,3},{3,0}};
		int[][] expectedArray = {{2,3},{3,9}};
		int[][] actualArray = testObj.multiplyPrime(primeRowColArray);
		assertArrayEquals(expectedArray,actualArray);
	}
}
