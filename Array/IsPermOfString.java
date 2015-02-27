/* Question 1.3: Given two strings, write a method to decide if 
 * one is a permutation of the other.
 */

public class Main {
  public static void main(String[] args) {
      String str1 = "doweepg";
      String str2 = "godweep"; 

      System.out.println(isPerm1(str1, str2));

      str1 = "sdoweepga";
      str2 = "gsodweeps"; 
      
      System.out.println(isPerm2(str1, str2));
  }
  static boolean isPerm1 (String str1, String str2) {
      // sort the string by chars and then compare the sorted strings
      if (str1.length() != str2.length()) {
          return false;
      } else {
          return sort(str1).equals(sort(str2));
      }
  }
  
  static String sort (String str) {
      char[] charAry = str.toCharArray();
      java.util.Arrays.sort(charAry);
      return new String(charAry);
  }
  
  static boolean isPerm2 (String str1, String str2) {
      // sort the string by chars and then compare the sorted strings
      if (str1.length() != str2.length()) {
          return false;
      } else {
          int[] charCounts = new int[256];
          // init the array
          for (int i: charCounts) {
              i = 0;
          }
          
          char[] str1Ary = str1.toCharArray();
          for (char c: str1Ary) {
              ++charCounts[(int)c];
          }
          
          for (int i = 0; i < str2.length(); ++i) {
              int c = (int) str2.charAt(i);
              --charCounts[c];
              if (charCounts[c] < 0) {
                  return false;
              }
          }
          return true;
      }
  }
}

