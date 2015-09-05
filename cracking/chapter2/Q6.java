import java.util.*;

/**
 * 2-6
 * Given a circular linked list, implement an algorithm which returns the node at
 * the beginning of the loop.
 * ex) A -> B -> C -> D -> E -> C
 *     return C
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

public class Q6 {

  public static void main(String[] args) {
    Node node = new Node(1);
    node.addToEnd(2);
    node.addToEnd(3);
    node.addToEnd(4);
    node.addToEnd(5);

    Node last = node.next.next.next.next;
    Node three = node.next.next;
    last.next = three;


    Node start = findLoop(node);
    if(start == null) {
      System.out.println("no loop");
    }
    else {
      System.out.println(start.data);
    }

    Node startTwo = findLoopNoBuffer(node);
    if(startTwo == null) {
      System.out.println("no loop");
    }
    else {
      System.out.println(startTwo.data);
    }
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

  public static Node findLoop(Node head) {
    Set<Integer> buffer = new HashSet<Integer>();
    while(head != null) {
      if(buffer.contains(head.data)) {
        return head;
      }
      buffer.add(head.data);
      head = head.next;
    }
    return null;
  }

  public static Node findLoopNoBuffer(Node head) {
    Node slow = head;
    Node fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if(slow.data == fast.data) {
        break;
      }
    }

    if(fast == null || fast.next == null) {
      return null;
    }

    slow = head;
    while(slow.data != fast.data) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}

