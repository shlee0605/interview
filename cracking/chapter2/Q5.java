import java.util.*;

/**
 * 2-5
 * You have two numbers represented by a linked list, where each node contains
 * a single digit. The digits are stored in reverse order, such that the 1's
 * digit is at the head of the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
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

class Sum {
  Node sum = null;
  int carry = 0;
}

public class Q5 {

  public static void main(String[] args) {
    Node node = new Node(9);
    node.addToEnd(1);
    node.addToEnd(6);

    Node node2 = new Node(5);
    node2.addToEnd(9);
    node2.addToEnd(5);

    printList(node);
    printList(node2);

    // 137 + 67 = 204
    Node result = addNumber(node, node2);
    //4->0->2 expected
    printList(result);

    Node result2 = addNumberRecursion(node, node2);
    printList(result2);

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

  public static Node addNumber(Node number1, Node number2) {
    Node num1 = number1;
    Node num2 = number2;
    Node total = null;

    if(number1 == null && number2 == null) {
      return null;
    }
    else if(number1 == null) {
      return number2;
    }
    else if(number2 == null) {
      return number1;
    }

    int carry = 0;
    int sum = 0;

    while(num1 != null || num2 != null) {
      sum = carry + (num1 == null ? 0 : num1.data) + (num2 == null ? 0 : num2.data);

      if(sum >= 10) {
        carry = 1;
        sum -= 10;
      }
      else {
        carry = 0;
      }

      if(total == null) {
        total = new Node(sum);
      }
      else{
        total.addToEnd(sum);
      }

      num1 = (num1 == null ? null : num1.next);
      num2 = (num2 == null ? null : num2.next);
    }

    // don't forget to add 1
    if(carry > 0) {
      total.addToEnd(carry);
    }

    return total;
  }

  // part b!
  public static Node addNumberRecursion(Node number1, Node number2) {
    int numLength1 = countLength(number1);
    int numLength2 = countLength(number2);

    int diff = numLength1 - numLength2;
    if(diff > 0) {
      number2 = paddNumber(number2, diff);
    }
    else {
      number1 = paddNumber(number1, diff);
    }

    printList(number1);
    printList(number2);
    Sum total = addNumberHelp(number1, number2);

    Node result = total.sum;

    if(total.carry > 0) {
      result = addToFront(result, total.carry);
    }

    return result;
  }

  public static Sum addNumberHelp(Node num1, Node num2) {
    // base case

    if(num1.next == null & num2.next == null) {
      int sum = num1.data + num2.data;
      int carry = 0;

      if(sum >= 10) {
        sum -=10;
        carry = 1;
      }
      Node digit = new Node(sum);
      Sum result = new Sum();
      result.sum = digit;
      result.carry = carry;

      return result;
    }

    Sum prevSum = addNumberHelp(num1.next, num2.next);
    Sum resultSum = new Sum();

    int sumCurrent = num1.data + num2.data + prevSum.carry;
    int carryCurrent = 0;

    if(sumCurrent >= 10) {
      sumCurrent -= 10;
      carryCurrent = 1;
    }

    Node resultCurrent = addToFront(prevSum.sum, sumCurrent);

    resultSum.sum = resultCurrent;
    resultSum.carry = carryCurrent;

    return resultSum;
  }

  public static Node paddNumber(Node head, int num) {
    if(num == 0) {
      return head;
    }
    Node newHead = null;
    Node tail = null;
    while(num > 0) {
      Node add = new Node(0);
      if(tail == null) {
        tail = add;
        newHead = add;
      }
      else {
        tail.next = add;
        tail = add;
      }
      num--;
    }

    tail.next = head;
    return newHead;
  }

  public static int countLength(Node head) {
    int count = 0;
    while(head != null) {
      head = head.next;
      count ++;
    }
    return count;
  }

  public static Node addToFront(Node head, int num) {
    Node add = new Node(num);
    add.next = head;
    head = add;
    return head;
  }
}

