package com.tdd.primeProdMatrix;

public class PrimeProdMatrix {

	public boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num%i == 0) {
				return false;
			}
		}
            
		return true;
	}

	public int[][] primeArrayRowAndCol(int n) {
		int num = 3, k = 0;
		
        int[][] primeRowCol = new int[n][n];
        primeRowCol[0][0] = 2; 
        
        for (int i = 2; i <=n; ) {
        	if (isPrime(num)) {
        		primeRowCol[0][++k] = num;
                primeRowCol[k][0] = num;
                i++;
        	}
            num++;           
        } 
		return primeRowCol;        	
	}

	public int[][] multiplyPrime(int[][] primeRowColArray) {
		int row, col, l = 1, n;
		n = primeRowColArray.length;
		if (n == 1){
		}
		else {
			for(row = 1; row < n; row++) {
	            for(col = l; col < n; col++) {
	                if (row == col){
	                	primeRowColArray[row][col] = primeRowColArray[row][0]*primeRowColArray[0][col];
	                }
	                else {
	                	primeRowColArray[row][col] = primeRowColArray[col][row] = primeRowColArray[row][0]*primeRowColArray[0][col];
	                }
	            }
	            l++;
	        }
		}
		
		return primeRowColArray;
	}
	
	public static void main(String args[]) {
		int n = 10;
		PrimeProdMatrix p = new PrimeProdMatrix();
		int[][] primeRowCol2DArray = p.primeArrayRowAndCol(n);
		int[][] primeProdMatrix = p.multiplyPrime(primeRowCol2DArray);
		p.displayMatrix(primeProdMatrix);		
		
	}

	private void displayMatrix(int[][] primeProdMatrix) {
		for(int[] row : primeProdMatrix) {
            for (int i : row) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }		
	}	
}
