import java.util.Stack;
import java.util.*;

public class Q7 {
  public static void main(String[] args) {
    Shelter shelter = new Shelter();


  }
}

class Animal {
  private int order;
  protected String name;

  public Animal(String n) {
    name = n;
  }

  public void setOrder(int o) {
    order = o;
  }

  public int getOrder() {
    return order;
  }

  public boolean isOlderThan(Animal a) {
    return this.order < a.getOrder();
  }
}

class Dog extends Animal {
  public Dog(String n) {
    super(n);
  }
}

class Cat extends Animal {
  public Cat(String n) {
    super(n);
  }
}

class AnimalQueue {
  LinkedList<Dog> dogs = new LinkedList<Dog>();
  LinkedList<Cat> cats = new LinkedList<Cat>();
  private int order = 0;

  public void enqueue(Animal animal) {
    animal.setOrder(order);
    order ++;

    if(animal.isInstanceOf(Dog)) {
      dogs.addLast(Dog);
    }
    else {
      cats.addLast(Cat);
    }
  }

  public AnimalNode dequeueAny() {
    if(dogs.isEmpty() && cats.isEmpty()) {
      return null;
    }

    if(dogs.isEmpty()) {
      return cats.removeFirst();
    }

    if(cats.isEmpty()) {
      return dogs.removeFirst();
    }


    Dog dogFirst = dogs.peek();
    Cat catFirst = cats.peek();

    if(dogFirst.isOlderThan(catFirst)) {
      return dogs.poll();
    }
    else {
      return cats.poll();
    }
  }

  public AnimalNode dequeueDog() {
    return dogs.poll();
  }

  public AnimalNode dequeueCat() {
    return cats.poll();
  }

}

