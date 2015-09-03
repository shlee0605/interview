import java.util.*;

/**
 * 2-2
 * Implement an algorithm to find the k-th to last element
 * of a singly linked list
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

public class Q2 {

  public static void main(String[] args) {
    Node node = new Node(2);
    node.addToEnd(3);
    node.addToEnd(1);
    node.addToEnd(3);
    node.addToEnd(4);
    node.addToEnd(2);
    printList(node);
    Node kth = kthLastElement(3, node);
    System.out.println(kth.data);
  }

  public static void printList(Node head) {
    Node current = head;
    while(current != null) {
      System.out.print(current.data);
      if(current.next != null) {
        System.out.print(" -> ");
      }
      current = current.next;
    }
    System.out.print("\n");
  }

  public static Node kthLastElement(int k, Node head) {
    Node current = head;
    Node runner = head;
    for(int i = 0; i < k-1; i++) {
      //if k > number of elements
      if(runner == null) {
        System.out.println("wrong k");
        return null;
      }
      runner = runner.next;
    }
    while(runner.next != null) {
      runner = runner.next;
      current = current.next;
    }

    return current;
  }
}

