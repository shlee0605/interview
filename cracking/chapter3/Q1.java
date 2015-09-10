import java.util.*;

/**
 * 3-1
 * Write code to remove duplicates from an unsorted linked list.
 * (Follow up) How would you solve this problem if a temporary buffer is not allowed?
 */

public class Q1 {
  static int stackSize = 10;
  static int[] stackArray = new int[3*stackSize];
  static int[] stackPointer = {-1, -1, -1};

  public static void main(String[] args) {
    push(2, 4);
    System.out.println("Peek 2: " + peek(2));
    push(0, 3);
    push(0, 7);
    push(0, 5);
    System.out.println("Peek 0: " + peek(0));
    pop(0);
    System.out.println("Peek 0: " + peek(0));
    pop(0);
    System.out.println("Peek 0: " + peek(0));
  }

  public static int pop(int stackNum) {
    if(stackPointer[stackNum] == -1) {
      System.out.println("trying to pop an empty stack");
      return -1;
    }
    int returnData = stackArray[stackNum*stackSize + stackPointer[stackNum]];
    stackPointer[stackNum]--;
    return returnData;
  }

  public static void push(int stackNum, int data) {
    if(stackPointer[stackNum] + 1 >= stackSize) {
      System.out.println("stack is full!");
    }
    stackPointer[stackNum]++;
    stackArray[stackNum*stackSize + stackPointer[stackNum]] = data;
  }

  public static int peek(int stackNum) {
    if(stackPointer[stackNum] == -1) {
      System.out.println("trying to peek to an empty stack");
      return -1;
    }
    return stackArray[stackNum*stackSize + stackPointer[stackNum]];
  }
}

