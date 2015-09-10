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
  int size = 0;

  public int pop() {
    if(head == null) {
      System.out.println("trying to pop an empty stack");
      return -1;
    }
    int result = head.data;
    head = head.next;
    size--;
    return result;
  }

  public void push(int data) {
    Node newHead = new Node(data);
    if(head == null) {
      size++;
      head = newHead;
    }
    else {
      size++;
      newHead.next = head;
      head = newHead;
    }
  }

  public int peek() {
    if(head == null) {
      System.out.println("trying to peek an empty stack");
      return -1;
    }
    return head.data;
  }

  public int size() {
    return size;
  }
}

class SetOfStacks{
  ArrayList<Stack> stacks = new ArrayList<Stack>();
  // make it small for testing
  int stackSize = 3;

  public int pop() {
    Stack s = getLastStack();
    int result = s.pop();
    if(s.size() == 0) {
      stacks.remove(s);
    }
    return result;
  }

  public void push(int x) {
    Stack s = getLastStack();
    if(s.size() < stackSize) {
      s.push(x);
    }
    else {
      addLastStack();
      s = getLastStack();
      s.push(x);
    }
  }

  public int peek() {
    Stack s = getLastStack();
    return s.peek();
  }

  public Stack getLastStack() {
    if(stacks.size() == 0) {
      Stack newStack = new Stack();
      stacks.add(newStack);
      return newStack;
    }
    return stacks.get(stacks.size() - 1);
  }

  public void addLastStack() {
    stacks.add(new Stack());
  }
}

public class Q3 {

  public static void main(String[] args) {
    SetOfStacks stack = new SetOfStacks();
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(1);
    stack.push(4);
    System.out.println("Peek : " + stack.peek());
    stack.pop();
    System.out.println("Peek : " + stack.peek());
    stack.pop();
    System.out.println("Peek : " + stack.peek());
    stack.pop();
    System.out.println("Peek : " + stack.peek());
    stack.pop();
    System.out.println("Peek : " + stack.peek());
  }
}

