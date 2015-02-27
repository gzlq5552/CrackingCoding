/*
 * Question 1.7: Write an algorithm such that if an element in an MxN matrix 
 * is 0, its entire row and column are set to 0
 */

public class Main {
  public static void main(String[] args) {
      int[][] m = {
          {1, 2, 3, 5},
          {0, 2, 3, 4},
          {1, 2, 3, 4}
      };
     
      setZeros(m);
      printMatrix(m);
  }
 
  static void setZeros (int[][] matrix) {
      boolean[] rows = new boolean[matrix.length];
      boolean[] cols = new boolean[matrix[0].length];
     
      for (int i = 0; i < matrix.length; ++i) {
          for (int j = 0; j < matrix[0].length; ++j) {
              if (matrix[i][j] == 0) {
                  rows[i] = true;
                  cols[j] = true;
              }
          }
      }
     
      for (int i = 0; i < matrix.length; ++i) {
          for (int j = 0; j < matrix[0].length; ++j) {
              if (rows[i] || cols[j]) {
                  matrix[i][j] = 0;
              }
          }
      }
  }
 
  static void printMatrix(int[][] matrix) {
      for (int i = 0; i < matrix.length; ++i) {
          for (int j = 0; j < matrix[0].length; ++j) {
              System.out.print(matrix[i][j] +  " ");
          }
          System.out.println();
      }
  }
}