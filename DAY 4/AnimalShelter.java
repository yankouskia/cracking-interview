import java.util.LinkedList;

/*
  Let's just keep 2 queues for dogs and cats. It will allow to implement dequeueDog and dequeueCat automatically for O(1).
  We will also extend Animal class with "order" field, where we will set the order of adding to queue.
  On each call of dequeueAny method - we will just check where the order is more: on top of dogs queue or cats queue
*/
public class AnimalShelter {
  public static void main(String[] args) {
    Animal[] animals = {
      new Dog("a"),
      new Dog("b"),
      new Cat("c"),
      new Dog("d"),
      new Dog("e"),
      new Cat("f"),
      new Cat("g"),
      new Cat("h"),
      new Dog("i"),
      new Cat("j"),
      new Dog("k"),
      new Dog("l"),
      new Dog("m"),
      new Cat("n"),
      new Cat("o"),
    };

    ShelterQueue q = new ShelterQueue();

    for (Animal animal: animals) {
      q.enqueue(animal);
    }

    System.out.println("Initial shelter:");
    q.print();

    System.out.println("Taking dog");
    q.dequeueDog();
    System.out.println("Taking dog");
    q.dequeueDog();

    q.print();

    System.out.println("Taking cat");
    q.dequeueCat();
    System.out.println("Taking cat");
    q.dequeueCat();

    q.print();

    System.out.println("Taking any");
    q.dequeueAny();
    System.out.println("Taking any");
    q.dequeueAny();
    System.out.println("Taking any");
    q.dequeueAny();
    System.out.println("Taking any");
    q.dequeueAny();

    q.print();
    /*
      Initial shelter:
      SHELTER:
      ---------------------------------------
      Dogs queue:
      Order: 0. Name: a.
      Order: 1. Name: b.
      Order: 3. Name: d.
      Order: 4. Name: e.
      Order: 8. Name: i.
      Order: 10. Name: k.
      Order: 11. Name: l.
      Order: 12. Name: m.
      Cats queue:
      Order: 2. Name: c.
      Order: 5. Name: f.
      Order: 6. Name: g.
      Order: 7. Name: h.
      Order: 9. Name: j.
      Order: 13. Name: n.
      Order: 14. Name: o.
      ---------------------------------------
      Taking dog
      Taking dog
      SHELTER:
      ---------------------------------------
      Dogs queue:
      Order: 3. Name: d.
      Order: 4. Name: e.
      Order: 8. Name: i.
      Order: 10. Name: k.
      Order: 11. Name: l.
      Order: 12. Name: m.
      Cats queue:
      Order: 2. Name: c.
      Order: 5. Name: f.
      Order: 6. Name: g.
      Order: 7. Name: h.
      Order: 9. Name: j.
      Order: 13. Name: n.
      Order: 14. Name: o.
      ---------------------------------------
      Taking cat
      Taking cat
      SHELTER:
      ---------------------------------------
      Dogs queue:
      Order: 3. Name: d.
      Order: 4. Name: e.
      Order: 8. Name: i.
      Order: 10. Name: k.
      Order: 11. Name: l.
      Order: 12. Name: m.
      Cats queue:
      Order: 6. Name: g.
      Order: 7. Name: h.
      Order: 9. Name: j.
      Order: 13. Name: n.
      Order: 14. Name: o.
      ---------------------------------------
      Taking any
      Taking any
      Taking any
      Taking any
      SHELTER:
      ---------------------------------------
      Dogs queue:
      Order: 8. Name: i.
      Order: 10. Name: k.
      Order: 11. Name: l.
      Order: 12. Name: m.
      Cats queue:
      Order: 9. Name: j.
      Order: 13. Name: n.
      Order: 14. Name: o.
      ---------------------------------------
    */
  }
}

enum AnimalType {
  DOG,
  CAT
}

class Animal {
  private AnimalType type;
  private int order = 0;
  private String name;

  Animal(AnimalType type, String name) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public int getOrder() {
    return this.order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public AnimalType getType() {
    return this.type;
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(AnimalType.DOG, name);
  }
}

class Cat extends Animal {
  public Cat(String name) {
    super(AnimalType.CAT, name);
  }
}

class ShelterQueue {
  private static int CURRENT_ORDER = 0;
  private LinkedList<Animal> catsQueue;
  private LinkedList<Animal> dogsQueue;

  public ShelterQueue() {
    this.dogsQueue = new LinkedList<Animal>();
    this.catsQueue = new LinkedList<Animal>();
  }

  public void enqueue(Animal animal) {
    animal.setOrder(CURRENT_ORDER++);

    if (animal.getType() == AnimalType.DOG) {
      this.dogsQueue.add(animal);
    } else {
      this.catsQueue.add(animal);
    }
  }

  public Animal dequeueDog() {
    return this.dogsQueue.remove();
  }

  public Animal dequeueCat() {
    return this.catsQueue.remove();
  }

  public Animal dequeueAny() {
    if (this.dogsQueue.peek().getOrder() < this.catsQueue.peek().getOrder()) {
      return this.dogsQueue.remove();
    } else {
      return this.catsQueue.remove();
    }
  }

  public void print() {
    System.out.println("SHELTER:");
    System.out.println("---------------------------------------");
    System.out.println("Dogs queue:");
    for (int i = 0; i < this.dogsQueue.size(); i++) {
      System.out.println("Order: " + this.dogsQueue.get(i).getOrder() + ". Name: " + this.dogsQueue.get(i).getName() + ".");
    }
    System.out.println("Cats queue:");
    for (int i = 0; i < this.catsQueue.size(); i++) {
      System.out.println("Order: " + this.catsQueue.get(i).getOrder() + ". Name: " + this.catsQueue.get(i).getName() + ".");
    }
    System.out.println("---------------------------------------");
  }
}
