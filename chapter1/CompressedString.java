import java.util.*;

/**
 * 1-5
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string.
 */
 
public class CompressedString {
 
  public static void main (String[] args){
    String test = "aabcccccaaa";
    String test2 = "a";
    new CompressedString().compress(test);
    new CompressedString().compress(test2);
  }
  
  public void compress(String compress) {
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
    System.out.println(result);
  }
}
