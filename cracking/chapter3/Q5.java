import java.util.*;
import java.util.Stack;

/**
 * 3-5
 * Implement a MyQueue class which implements a queue using two stacks.
 */

class MyQueue<T> {
  Stack<T> first; // enqueue
  Stack<T> second; // dequeue

  public MyQueue() {
    first = new Stack<T>();
    second = new Stack<T>();
  }

  public void dequeue() {
    shift();
    second.pop();
  }

  public void enqueue(T x) {
    first.push(x);
  }

  public T peek() {
    shift();
    return second.peek();
  }

  public void shift() {
    if(second.size() == 0) {
      while(!first.isEmpty()) {
        second.push(first.pop());
      }
    }
  }
}

public class Q5 {

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();
    queue.enqueue(3);
    queue.enqueue(2);
    queue.enqueue(5);
    queue.enqueue(1);
    queue.enqueue(4);
    System.out.println(Arrays.asList(queue.first));
    System.out.println("Peek : " + queue.peek());
    queue.dequeue();
    System.out.println("Peek : " + queue.peek());
    queue.dequeue();
    System.out.println("Peek : " + queue.peek());
    queue.dequeue();
    System.out.println("Peek : " + queue.peek());
    queue.dequeue();
    System.out.println("Peek : " + queue.peek());
  }
}

