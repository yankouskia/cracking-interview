#include <iostream>
#include <string>

using namespace std;

class Animal {
  public:
  virtual void say() {
    cout << "I am an animal" << endl;
  }
};

class Dog: public Animal {
  public:
  void say() {
    cout << "I am a dog" << endl;
  }
};

class Cat: public Animal {
  public:
  void say() {
    cout << "I am a cat" << endl;
  }
};

int main() {
  Animal* animal = new Animal();
  Animal* dog = new Dog();
  Animal* cat = new Cat();

  animal->say();
  dog->say();
  cat->say();
}
