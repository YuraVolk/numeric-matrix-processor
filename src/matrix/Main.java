package matrix;

import java.util.*;

public class Main {
  static public int determinantOfMatrix(int A[][],int N) {
        int det=0;
        if(N == 1) {
            det = A[0][0];
        }
        else if (N == 2) {
            det = A[0][0]*A[1][1] - A[1][0]*A[0][1];
        } else {
            det=0;
            for(int j1=0;j1<N;j1++) {
                int[][] m = new int[N-1][];
                for(int k=0;k<(N-1);k++) {
                    m[k] = new int[N-1];
                }
                for(int i=1;i<N;i++) {
                    int j2=0;
                    for(int j=0;j<N;j++) {
                        if(j == j1)
                            continue;
                        m[i-1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0,1.0+j1+1.0)* A[0][j1] * determinantOfMatrix(m,N-1);
            }
        }
        
        
        return (int) det;
        
    }

	public static void sumUpMatrix(int[][] firstMatrix,int[][] secondMatrix,int rows, int columns) {
   
	    int[][] sum = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        // Displaying the result
        printMatrix(sum);
	}
	
	public static void multiplyMatrix(int[][] firstMatrix,int rows, int columns,int c) {
		int[][] pr = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                pr[i][j] = firstMatrix[i][j] * c;
            }
        }
        
        printMatrix(pr);
    }
	
	public static void multiplyMatrices(int[][] a, int[][]b) {
		   int rowsInA = a.length;
	       int columnsInA = a[0].length; 
	       int columnsInB = b[0].length;
	       int[][] c = new int[rowsInA][columnsInB];
	       for (int i = 0; i < rowsInA; i++) {
	           for (int j = -0; j < columnsInB; j++) {
	        	   c[i][j] = 0;
	               for (int k = 0; k < columnsInA; k++) {
	                   c[i][j] = c[i][j] + a[i][k] * b[k][j];
	               }
	           }
	       }
	       printMatrix(c);
	}
	
	public static void transposeMatrix(int[][]a) {
		int n = a.length;
		int m = a[0].length;
		
		int tr[][] = new int[n][m];
	     
	    for (int c = 0; c < m; c++) {
	         for (int d = 0; d < n; d++) {          
	            tr[d][c] = a[c][d];
	         }
	    }
	    
	    printMatrix(tr);
	    
	}
	
	public static int[][] fillMatrix(int rows, int columns) {
		Scanner sc = new Scanner(System.in);
	    
		int[][] firstMatrix = new int[rows][columns];
		
		for(int row=0;row<rows;row++){
			for(int col=0;col<columns;col++){
				firstMatrix[row][col]=sc.nextInt();
		    }
		}
		
		return firstMatrix;
	}
	
	public static void printMatrix(int[][] pr) {
		for(int[] row : pr) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int rows;
		int columns;
		
		while (true) {
			System.out.println("1. Add matrices\r\n" + 
					"2. Multiply matrix to a constant\r\n" + 
					"3. Multiply matrices\r\n" + 
					"4. Transpose matrix\r\n" + 
					"5. Calculate a determinant\r\n" + 
					"0. Exit");
			
			int choice = sc.nextInt();
			
			
			switch(choice) {
				case 1:
					System.out.println("Enter size of first matrix: ");
					rows = sc.nextInt();
					columns = sc.nextInt();
					System.out.println("Enter matrix: ");
					int[][] mat1 = fillMatrix(rows,columns);
					
					System.out.println("Enter size of second matrix: ");
					rows = sc.nextInt();
					columns = sc.nextInt();
					
					System.out.println("Enter second matrix: ");
					int[][] mat2 = fillMatrix(rows,columns);
					
					System.out.println("The result is: ");
					
					sumUpMatrix(mat1,mat2,rows,columns);
					
					break;
				case 2:
					System.out.println("Enter size of the matrix: ");
					rows = sc.nextInt();
					columns = sc.nextInt();
					
					System.out.println("Enter matrix: ");
					
					int[][] matMultiply = fillMatrix(rows,columns);
				
					System.out.println("Enter constonant: ");
					
				    int n = sc.nextInt();
				    
				    System.out.println("The result is: ");
				    
				    multiplyMatrix(matMultiply,rows,columns,n);
				    
				    break;
				case 3:
					System.out.println("Enter size of first matrix: ");
					rows = sc.nextInt();
					columns = sc.nextInt();
					System.out.println("Enter first matrix: ");
					int[][] mat1p = fillMatrix(rows,columns);
					
					System.out.println("Enter size of second matrix: ");
					int rows2 = sc.nextInt();
					int columns2 = sc.nextInt();
					System.out.println("Enter second matrix: ");
					int[][] mat2p = fillMatrix(rows2,columns2);
					
				    System.out.println("The multiplication result is:");
					multiplyMatrices(mat1p,mat2p);
					
					break;
				case 4:
					System.out.println("Enter matrix size: ");
					rows = sc.nextInt();
					columns = sc.nextInt();
					
					System.out.println("Enter matrix: ");
					
					int[][] matTr = fillMatrix(rows,columns);
					
					System.out.println("The result is: ");

				    transposeMatrix(matTr);
				    
				    break;
				case 5:
					System.out.println("Enter matrix size: ");
					rows = sc.nextInt();
					columns = sc.nextInt();
					
					System.out.println("Enter matrix: ");
					
					int[][] matDet = fillMatrix(rows,columns);
					
					System.out.println("The result is: ");
					
					System.out.println(determinantOfMatrix(matDet, rows));
					break;
				default:
					System.exit(0);
			}
			
			
			
		}
	}
}
