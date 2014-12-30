import java.util.*;

/**
 * 1-1
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structure?
 */

public class UniqueCharacter {

  public static boolean isUnique(String input) {
    Set<Character> characterSet = new HashSet<Character>();
    for(int i = 0; i < input.length(); i++) {
      if(characterSet.contains(input.charAt(i))) {
        return false;
      }
      else{
        characterSet.add(input.charAt(i));
      }
    }
    return true;
  }

  public static boolean isUniqueNoDS(String input) {
    char[] sorted = input.toCharArray();
    Arrays.sort(sorted);
    for(int i = 0; i < sorted.length-1; i++) {
      if(sorted[i] == sorted[i+1]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] test = { "hikld", "abcdef", "abcceds", "abceda" };
    
    System.out.println("Using a data structure");
    for(String s: test) {
      System.out.println(isUnique(s));
    }

    System.out.println("No Data structure");
    for(String s: test) {
      System.out.println(isUniqueNoDS(s));
    }
  }
}

