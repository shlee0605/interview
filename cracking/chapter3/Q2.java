import java.util.*;

/**
 * 3-2
 * How would you design a stack which, in addition to push and pop, also has a function
 * min which returns the minimum element? Push, pop and min should all operate in O(1)
 * time
 */

class Node {
  Node next;
  int data;

  public Node(int d) {
    next = null;
    data = d;
  }

  public void addToEnd(int num) {
    Node end = new Node(num);
    Node current = this;
    while(current.next != null) {
      current = current.next;
    }
    current.next = end;
  }
}

class Stack{
  Node head = null;
  int min = Integer.MAX_VALUE;

  public int pop() {
    if(head == null) {
      System.out.println("trying to pop an empty stack");
      return -1;
    }
    int result = head.data;
    head = head.next;
    if(result == min()) {
      newMin();
    }
    return result;
  }

  public void push(int data) {
    Node newHead = new Node(data);
    if(head == null) {
      head = newHead;
      updateMin(data);
    }
    else {
      newHead.next = head;
      head = newHead;
      if(min() > data) {
        updateMin(data);
      }
    }
  }

  public int peek() {
    if(head == null) {
      System.out.println("trying to peek an empty stack");
      return -1;
    }
    return head.data;
  }

  public int min() {
    return min;
  }

  public void updateMin(int data) {
    min = data;
  }

  // this makes O(n) when min is popped.
  public void newMin() {
    min = Integer.MAX_VALUE;
    Node current = head;
    while(current != null) {
      if(min > current.data) {
        min = current.data;
      }
      current = current.next;
    }
  }
}

class MinStack extends Stack {
  Stack minStack = new Stack();

  public void updateMin(int data) {
    minStack.push(data);
  }

  public void newMin() {
    minStack.pop();
  }

  public int min() {
    return minStack.peek();
  }

}

public class Q2 {

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(1);
    stack.push(4);
    System.out.println("Peek : " + stack.peek() + "  Min : " + stack.min());
    stack.pop();
    System.out.println("Peek : " + stack.peek() + "  Min : " + stack.min());
    stack.pop();
    System.out.println("Peek : " + stack.peek() + "  Min : " + stack.min());

    MinStack stack2 = new MinStack();
    stack2.push(3);
    stack2.push(2);
    stack2.push(5);
    stack2.push(1);
    stack2.push(4);
    System.out.println("Peek : " + stack2.peek() + "  Min : " + stack2.min());
    stack2.pop();
    System.out.println("Peek : " + stack2.peek() + "  Min : " + stack2.min());
    stack2.pop();
    System.out.println("Peek : " + stack2.peek() + "  Min : " + stack2.min());

  }
}

