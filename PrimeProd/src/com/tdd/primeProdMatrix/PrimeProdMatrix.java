package com.tdd.primeProdMatrix;

//import java.util.Scanner;

public class PrimeProdMatrix {

	public boolean isPrime(int num) {
		if (num == 0 || num == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num%i == 0) {
				return false;
			}
		}
            
		return true;
	}

	public int[][] primeArrayRowAndCol(int n) {
		if (n == 0) {
			return null;
		}
		
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
		
		return primeRowColArray;
	}
	
	public static void main(String args[]) {
		
		int n;
		/*Scanner in = new Scanner(System.in);
	    System.out.println("Enter the value of n:");
	    n = in.nextInt();*/
	      
		n = 10;
		PrimeProdMatrix p = new PrimeProdMatrix();
		int[][] primeRowCol2DArray = p.primeArrayRowAndCol(n);
		int[][] primeProdMatrix = p.multiplyPrime(primeRowCol2DArray);
		p.displayMatrix(primeProdMatrix);			
	}

	public void displayMatrix(int[][] primeProdMatrix) {
		if (primeProdMatrix == null) {
			System.out.print("No elements to be displayed");
		}
		for(int[] row : primeProdMatrix) {
            for (int i : row) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }		
	}	
}
