/*
 * Question 1.8: Assume you have a method isSubstring which checks if one word
 * is a substring of another. Given two strings, si and s2, write code to check
 * If s2 is a rotation of si using only onecalltoisSubstring 
 * (e.g., "waterbottLe" is a rotation of "erbottLewat").
 */

public class Main {
  public static void main(String[] args) {
    String s1 = "WaterBottles";
    String s2= "erBottlesWat";
    
    System.out.println(isRotation(s1, s2));
  }
  
  static boolean isRotation (String s1, String s2) {
      if (s1.length() == s2.length() & s1.length() > 0) {
          String s1s1 = s1 + s1;
          return isSubstring(s1s1, s2);
      }
      
      return false;
  }
  
  static boolean isSubstring (String s1, String s2) {
      return s1.indexOf(s2) > -1;
  }
}
