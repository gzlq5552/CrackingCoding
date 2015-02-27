/*
 * Questions 1.4: Write a method to replace all spaces in a string with 
 * '%20'. You may assume that the string has sufficient space at the 
 * end of the string to hold the additional characters, and that you 
 * are given the "true" length of the string.
 */

public class Main {
  public static void main(String[] args) {
      char[] input = "My name is Emily".toCharArray();
      char[] str = new char[100];
      
      for (int i = 0; i < input.length; ++i) {
          str[i] = input[i];
      }
      
      replaceSpace(str, input.length);
      
      System.out.println(new String(str));
  }
  
  // use char array to represent string because char array is mutable so in-place replacement is possible
  static void replaceSpace (char[] str, int length) {
      int spaceLength = 0, newLength, curIndex, i;
      for (i = 0; i < length; ++i) {
          if (str[i] == ' ') {
              ++spaceLength;
          } 
      }
      newLength = length + 2 * spaceLength;
      curIndex = newLength - 1;
      for (i = length - 1; i >= 0; --i) {
          if (str[i] == ' ') {
              str[curIndex--] = '0';
              str[curIndex--] = '2';
              str[curIndex--] = '%';
          } else {
              str[curIndex--] = str[i];
          }
      }
  }
}