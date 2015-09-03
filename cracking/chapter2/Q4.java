import java.util.*;

/**
 * 2-4
 * Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than
 * or equal to x.
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

public class Q4 {

  public static void main(String[] args) {
    Node node = new Node(2);
    node.addToEnd(3);
    node.addToEnd(6);
    node.addToEnd(1);
    node.addToEnd(8);
    node.addToEnd(3);
    node.addToEnd(5);
    node.addToEnd(2);
    node.addToEnd(1);
    node.addToEnd(9);
    printList(node);
    partition(node, 5);
    printList(node);
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

  public static void partition(Node head, int x) {
    Node smallHead = null;
    Node smallFoot = null;
    Node largeHead = null;
    Node largeFoot = null;

    if(head == null || head.next == null) {
      return;
    }

    Node current = head;

    while(current != null) {
      // trick to retrieve next earlier
      Node next = current.next;
      current.next = null;

      if(current.data < x) {
        if(smallHead == null) {
          smallHead = current;
          smallFoot = current;
        }
        else {
          smallFoot.next = current;
          smallFoot = current;
        }
      }
      else {
        if(largeHead == null) {
          largeHead = current;
          largeFoot = current;
        }
        else {
          largeFoot.next = current;
          largeFoot = current;
        }
      }
      current = next;
    }

    /* merge */
    smallFoot.next = largeHead;
    head = smallHead;
  }
}

