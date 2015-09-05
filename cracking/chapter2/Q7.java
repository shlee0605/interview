import java.util.*;

/**
 * 2-7
 * Implement a function to check if a linked list is a palindrome.
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

public class Q7 {

  public static void main(String[] args) {
    Node node = new Node(2);
    node.addToEnd(3);
    node.addToEnd(1);
    node.addToEnd(1);
    node.addToEnd(3);
    node.addToEnd(2);
    System.out.println(isPalindrome(node));

    Node node2 = new Node(2);
    node2.addToEnd(4);
    node2.addToEnd(5);
    node2.addToEnd(1);
    node2.addToEnd(3);
    node2.addToEnd(4);
    node2.addToEnd(2);
    System.out.println(isPalindrome(node2));
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

  public static boolean isPalindrome(Node head) {

    if(head == null) {
      return false;
    }
    if(head.next == null) {
      return true;
    }

    Node fast = head;
    Node slow = head;

    LinkedList<Node> stack = new LinkedList<Node>();
    while(fast != null && fast.next != null) {
      stack.push(slow);
      slow = slow.next;
      fast = fast.next.next;
    }

    // if the length is odd, ignore the middle node.
    if(fast != null) {
      slow = slow.next;
    }

    while(slow != null) {
      Node compare = stack.pop();
      if(compare.data != slow.data) {
        return false;
      }
      slow = slow.next;
    }

    return true;
  }
}

