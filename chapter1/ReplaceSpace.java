import java.util.*;

/**
 * 1-4
 * Write a method to replace all spaces in a string with '%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string.
 *
 */


public class ReplaceSpace {
  // using a string directly.
  public static String replace(String input) {
    char[] arr = input.toCharArray();
    String result = ""; 
    for(int i = 0; i < arr.length; i ++) {
      if (arr[i] == ' ') {
        result += "%20";
      }
      else {
        result += arr[i];
      }
    }
    return result;
  }

  //using a char array.
  public static char[] replace(char[] input, int length) {
    int spaceNum = countSpace(input);
    int index = length + spaceNum * 2;
    input[index] = '\0';
    index -= 1;
    for(int i = length - 1; i >= 0; i--) {
      if(input[i] == ' ') {
        input[index] = '0';
        input[index-1] = '2';
        input[index-2] = '%';
        index -= 3;
      }
      else {
        input[index] = input[i];
        index -= 1;
      }
    }
    return input;  
  }

  public static int countSpace(char[] input) {
    int count = 0;
    for(int i = 0; i < input.length; i++) {
      if(input[i] == ' ') {
        count += 1;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    String[] test = { "ab cd e", "hello, world! " };
    for(String s: test) {
      System.out.println(s);
      System.out.println(replace(s));
    }
    
    for(String s: test) {
      int spaceNum = countSpace(s.toCharArray());
      char[] newArr = new char[s.length() + spaceNum * 2 + 1];
      for(int i = 0; i < s.length(); i++) {
        newArr[i] = s.charAt(i);
      }
      System.out.println(s);
      System.out.println(replace(newArr, s.length()));
    }

  }
}
