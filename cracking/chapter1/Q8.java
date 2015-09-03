import java.util.*;

/**
 * 1-8
 * Assume you have a method "isSubstring" which checks if one word
 * is a substring of another. Given two strings s1 and s2, write code
 * to check if s2 is a rotation of s1 using only one call to "isSubstring"
 * (e.g. "waterbottle" is a rotation of "erbottlewat")
 */

public class Q8 {
  public static void main(String[] args) {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";
    String s3 = "erbottlewae";
    System.out.println(isRotation(s1, s2));
    System.out.println(isRotation(s1, s3));
  }

  public static boolean isRotation(String s1, String s2) {
    // *** note that s2 will always be the substring of s1+s1 if it's rotated.
    if(s1.length() == s2.length() && s1.length() > 0) {
      String s1s1 = s1 + s1;
      return isSubstring(s1s1, s2);
    }
    return false;
  }

  public static boolean isSubstring(String s1, String s2) {
    // java implementation of isSubstring is "contains"
    return s1.contains(s2);
  }
}
