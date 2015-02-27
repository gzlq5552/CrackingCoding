/*
 * Question 1.5: Implement a method to perform basic string compression 
 * using the counts of repeated characters. For example, the string 
 * aabcccccaaa would become a2blc5a3. If the "compressed" string would 
 * not become smaller than the original string, your method should return 
 * the original string.
 */

public class Main {
  public static void main(String[] args) {
    String input = "Hellllllllllllooooo"; // H1e1l12o5
    String output = compressString(input);
    System.out.println(output);
  }
  
  static String compressString (String str) {
      if (compressionSize(str) >= str.length()) {
          return str;
      }
      
      int count = 1;
      StringBuffer newStr = new StringBuffer();
      char last = str.charAt(0);
      
      
      for (int i = 1; i < str.length(); ++i) {
          if (last == str.charAt(i)) {
              ++count;
          } else {
              newStr.append(last);
              newStr.append(count);
              count = 1; 
              last = str.charAt(i);
          }
      }
      
      newStr.append(last);
      newStr.append(count);
      return newStr.toString();
  }
  
  static int compressionSize (String str) {

      if (str == null || str.isEmpty()) {
          return 0;
      }
      
      int size = 0, count = 1;
      char last = str.charAt(0);
      for (int i = 1; i < str.length(); ++i) {
          if (last == str.charAt(i)) {
              ++count;
          } else {
              size += 1 + String.valueOf(count).length();
              last = str.charAt(i);
              count = 1;
          }
      }
      size += 1 + String.valueOf(count).length();
      return size;
  }
}
