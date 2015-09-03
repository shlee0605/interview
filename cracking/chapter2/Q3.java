import java.util.*;

/**
 * 2-3
 * Implement an algorithm to delete a node in the middle of a singly liked list,
 * given only access to that node.
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

public class Q3 {

  public static void main(String[] args) {
    Node node = new Node(2);
    node.addToEnd(3);
    node.addToEnd(1);
    node.addToEnd(3);
    node.addToEnd(4);
    node.addToEnd(2);
    Node temp = node;
    Node delete = temp.next.next.next;
    printList(node);
    deleteNode(delete);
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

  public static void deleteNode(Node delete) {
    if(delete.next == null) {
      delete = null;
    }
    else {
      delete.data = delete.next.data;
      delete.next = delete.next.next;
    }
  }
}

