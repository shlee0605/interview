class Stack{
  Node head = null;

  public int pop() {
    if(head == null) {
      System.out.println("trying to pop an empty stack");
      return -1;
    }
    int result = head.data;
    head = head.next;
    return result;
  }

  public void push(int data) {
    Node newHead = new Node(data);
    if(head == null) {
      head = newHead;
    }
    else {
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
}
