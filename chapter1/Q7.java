import java.util.*;

/**
 * 1-7
 * Write an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column are set to 0.
 */

public class Q7 {
  public static void main(String[] args) {
    int[][] input = {{1,2,3,4,5}, {6,7,0,9,10}, {11,12,13,14,15}};
    printMatrix(input, 3, 5);
    System.out.println();
    printMatrix(setZeros(input), 3, 5);
  }

  public static int[][] setZeros(int[][] matrix) {
    int[] zeroRow = new int[matrix.length];
    int[] zeroColumn = new int[matrix[0].length];

    // marking 1 if 0 value is found
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        if(matrix[i][j] == 0) {
          zeroRow[i] = 1;
          zeroColumn[j] = 1;
        }
      }
    }

    // fill 0s if applicable
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        if(zeroRow[i] == 1 || zeroColumn[j] == 1) {
          matrix[i][j] = 0;
        }
      }
    }
    return matrix;
  }

  public static void printMatrix(int[][] matrix, int m, int n) {
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
