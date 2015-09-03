import java.util.*;

/**
 * 1-6
 * Given an image represented by an NxN matrix, where each pixel in the image is
 * 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
 * place?
 */


public class Q6 {
  public static void main(String[] args) {
    int[][] input = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    printMatrix(rotate(input, 4), 4);
  }

  public static int[][] rotate(int[][] matrix, int n) {
    for(int i = 0; i < n/2; i++) {
      //n rotations are needed for n^n matrix
      int start = i; // 0
      int end = n - 1 - i; // 3
      for(int j = start; j < end; j++) {
        // offset for different layers
        int offset = j - start;
        //keep left-top
        int temp = matrix[start][j];
        //move left-bottom to left-top
        matrix[start][j] = matrix[end - offset][start];
        //move right-bottom to left-bottom
        matrix[end - offset][start] = matrix[end][end - offset];
        //move right-top to right-bottom
        matrix[end][end - offset] = matrix[j][end];
        //move left-top to right-top
        matrix[j][end] = temp;
      }
    }
    return matrix;
  }

  public static void printMatrix(int[][] matrix, int n) {
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + "\t");
      }
      System.out.println();
    }
  }
}
