import java.util.*;

/**
 * 1-3
 * Given two strings, write a method to decide if one is a permutation of the other.
 */

public class Q3 {

  public static boolean isPermutation(String first, String second) {
    //create a map?
    Map<Character, Integer> firstMap = initializeMap(first);
    Map<Character, Integer> secondMap = initializeMap(second);

    for(Character c: firstMap.keySet()) {
      if(firstMap.get(c) != secondMap.get(c)) {
        return false;
      }
    }
    return true;
  }

  public static Map<Character, Integer> initializeMap(String str) {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    for(int i =0; i < str.length(); i++) {
      char c = str.charAt(i);
      if(map.containsKey(c)){
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    return map;
  }

  public static void main (String[] args) {
    String[] input = {"abced","dbace"};
    System.out.println(isPermutation(input[0],input[1]));
  }
}
