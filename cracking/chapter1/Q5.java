import java.util.*;

/**
 * 1-5
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string.
 */

public class Q5 {

  public static void main (String[] args){
    String test = "aabcccccaaa";
    String test2 = "a";
    System.out.println(compress(test));
    System.out.println(compress(test2));
  }

  public static String compress(String compress) {
    char target = compress.charAt(0);
    int count = 1;
    String result = "";
    for(int i = 1; i < compress.length(); i ++) {
      if(target == compress.charAt(i)) {
        count += 1;
      }
      else {
        result = result + target + String.valueOf(count);
        target = compress.charAt(i);
        count = 1;
      }
    }
    result = result + target + String.valueOf(count);
    if(result.length() >= compress.length()) {
      result = compress;
    }
    return result;
  }
}
