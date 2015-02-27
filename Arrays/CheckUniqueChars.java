/*
 * Question 1.1: Implement an algorithm to determine if a string has all 
 * unique characters.
 */
public class Main {
	
  public static void main(String[] args) {
    boolean unique = hasAllUniqueChars("Helo Ward");
    System.out.println(unique);
    
    unique = hasUniqueCharsLessSpace("abcdefghijklmnopqrstuvwxyza");
    System.out.println(unique);
  }
  
  static boolean hasAllUniqueChars (String inputStr) {
      // assuming ASCII chars
      boolean hasUnique = true;
      // using a helper look up data structure to store chars already existing
      boolean[] chars = new boolean[256];
      for (int i = 0; i < inputStr.length(); ++i) {
          char c = inputStr.charAt(i);
          if (chars[c]) {
              hasUnique = false;
          }
          chars[c] = true;
      }
      
      return hasUnique;
  }
  
  // assume characters are between a and z
  static boolean hasUniqueCharsLessSpace (String inputStr) {
      int checker = 0;
      for (int i = 0; i < inputStr.length(); ++i) {
          int val = inputStr.charAt(i) - 'a';
          if ((checker & (1 << val)) > 0) {
              return false;
          }
          checker |= 1 << val;
      }
      return true;
  }
}
