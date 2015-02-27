/*
 * Question 1.6: Given an image represented by an NxN matrix, where each 
 * pixel in the image is 4 bytes, write a method to rotate the image by 
 * 90 degrees. Can you do this in place?
 */

class Main {
  public static void main(String[] args) {
      int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
          };
      int length = 4;
      rotate90(matrix, length);
      printMatrix(matrix, length);
  }
  
  static void rotate90 (int[][] matrix, int n) {
      // start rotating from the outermost layer
      int nbrOfLayers = n / 2;
      for (int layer = 0; layer < nbrOfLayers; ++layer) {
          int firstIndex = layer;
          int lastIndex = n - 1 - layer;
          
          for (int i = firstIndex; i < lastIndex; ++i) {
              int offset = i - firstIndex;
              // save remaining top-left number
              int topLeft = matrix[firstIndex][i];
              // top-left <-- bottom-left
              matrix[firstIndex][i] = matrix[lastIndex - offset][firstIndex];
              // bottom-left <-- bottom-right
              matrix[lastIndex - offset][firstIndex] = matrix[lastIndex][lastIndex - offset];
              // bottom-right <-- top-right
              matrix[lastIndex][lastIndex - offset] = matrix[i][lastIndex];
              // top-right <-- top-left
              matrix[i][lastIndex] = topLeft;
              
          }
      }
  }
  
  static void printMatrix (int[][] matrix, int n) {
      for (int i = 0; i < matrix.length; ++i) {
          for (int j = 0; j < matrix[i].length; ++j) {
              System.out.print(matrix[i][j] + " ");
          }
          System.out.println();
      }
  }
}