import java.util.*;
import java.util.Stack;

public class Q6 {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(2);
    stack.push(5);
    stack.push(9);
    stack.push(7);
    stack.push(6);
    System.out.println(Arrays.toString(stack.toArray()));
    Stack<Integer> sorted = quickSort(stack);
    System.out.println(Arrays.toString(sorted.toArray()));
  }

  public static Stack<Integer> quickSort(Stack<Integer> s){

    if(s.isEmpty()) {
      return s;
    }

    int pivot = s.pop();
    Stack<Integer> low = new Stack<Integer>();
    Stack<Integer> high = new Stack<Integer>();

    while(!s.isEmpty()) {
      int num = s.pop();
      if(num <= pivot) {
        low.push(num);
      } else {
        high.push(num);
      }
    }

    low = quickSort(low);
    high = quickSort(high);

    low.push(pivot);
    Stack<Integer> highBuffer = new Stack<Integer>();
    while(!high.isEmpty()) {
      highBuffer.push(high.pop());
    }

    while(!highBuffer.isEmpty()) {
      low.push(highBuffer.pop());
    }
    return low;
  }

}
