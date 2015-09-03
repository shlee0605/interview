import java.util.*;

/**
 * 2-1
 * Write code to remove duplicates from an unsorted linked list.
 * (Follow up) How would you solve this problem if a temporary buffer is not allowed?
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

public class Q1 {

  public static void main(String[] args) {
    Node node = new Node(2);
    node.addToEnd(3);
    node.addToEnd(1);
    node.addToEnd(3);
    node.addToEnd(4);
    node.addToEnd(2);
    printList(node);
    Node removed = removeDuplicatesNoBuffer(node);
    printList(removed);
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

  // using a Hashset to check duplicates
  // running time complexity: O(n)
  // space complexity: O(n)
  public static Node removeDuplicates(Node head) {
    Node current = head;
    Node previous = null;
    HashSet<Integer> buffer = new HashSet<Integer>();
    while(current != null) {
      if(buffer.contains(current.data)) {
        previous.next = current.next;
        current = current.next;
      }
      else {
        buffer.add(current.data);
        previous = current;
        current = current.next;
      }
    }
    return head;
  }

  // no buffer
  // running time : O(n^2)
  // space : O(1)
  public static Node removeDuplicatesNoBuffer(Node head) {
    Node current = head;
    Node runner = null;
    while(current.next != null) {
      runner = current;
      while(runner.next != null) {
        if(current.data == runner.next.data) {
          runner.next = runner.next.next;
        }
        else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
    return head;
  }
}

