package com.solidPrinciples;

/*BAD EXAMPLE
class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}
*/
//GOOD EXAMPLE
abstract class Bird { }

interface FlyingBird {
    void fly();
}

class Sparrow extends Bird implements FlyingBird {
    public void fly() {
        System.out.println("Sparrow flying...");
    }
}

class Penguin extends Bird {
    public void swim() {
        System.out.println("Penguin swimming...");
    }
}
public class L {
}
