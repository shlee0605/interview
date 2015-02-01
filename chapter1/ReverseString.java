import java.util.*;

/**
 * 1-2
 * Implement a function which reverses a string.
 */

public class ReverseString{

  public static String reverse(String input) {
    char[] arr = input.toCharArray();
    int left = 0;
    int right = arr.length-1;
    while(left < right) {
      char c = arr[left];
      arr[left] = arr[right];
      arr[right] = c;
      left++;
      right--;
    }
    return new String(arr);
  }

  public static void main(String[] args){
    String[] test = { "abcde", "djksafjlas", "seunghyun" };
    for(String s: test) {
      System.out.println(s);
      System.out.println(reverse(s));
    }
  }
}
