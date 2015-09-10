import java.util.Stack;
import java.util.*;

/**
 * 3-4
 * Solve the classic problem of the Towers of Hanoi with 3 stacks
 * (Move first stack -> third stack)
 */


public class Q4 {
  public static void main(String[] args) {
    // Set up code.
    int n = 5;
    Tower[] towers = new Tower[3];
    for (int i = 0; i < 3; i++) {
        towers[i] = new Tower(i);
    }
    for (int i = n - 1; i >= 0; i--) {
        towers[0].add(i);
    }

    // Copy and paste output into a .XML file and open it with internet explorer.
    System.out.println(Arrays.toString(towers[0].stack.toArray()));
    towers[0].moveDisks(n, towers[2], towers[1]);
    System.out.println(Arrays.toString(towers[2].stack.toArray()));
  }
}

class Tower {
    int index;
    Stack<Integer> stack;
    public Tower(int i) {
        index = i;
        stack = new Stack<Integer>();
    }

    public int index() {
        return index;
    }

    public void add(int x) {
        if(!stack.isEmpty() && stack.peek() <= x) {
            System.out.println("error");
        } else {
            stack.push(x);
        }
    }

    public void moveDisks(int n, Tower destination, Tower buffer) {
        if(n <= 0) {
            return;
        }
        else {
            this.moveDisks(n-1, buffer, destination);
            int top = stack.pop();
            destination.stack.push(top);
            buffer.moveDisks(n-1, destination, this);
        }
    }
}
