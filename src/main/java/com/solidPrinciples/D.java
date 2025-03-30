package com.solidPrinciples;

/*
class WiredKeyboard {
    public void connect() {
        System.out.println("Wired keyboard connected.");
    }
}

class Computer {
    private WiredKeyboard keyboard = new WiredKeyboard();

    public void useKeyboard() {
        keyboard.connect();
    }
}
 */

interface Keyboard {
    void connect();
}

class WiredKeyboard implements Keyboard {
    public void connect() {
        System.out.println("Wired keyboard connected.");
    }
}

class WirelessKeyboard implements Keyboard {
    public void connect() {
        System.out.println("Wireless keyboard connected.");
    }
}

class Computer {
    private Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public void useKeyboard() {
        keyboard.connect();
    }
}

// Usage
public class D {
    public static void main(String[] args) {
        Keyboard myKeyboard = new WiredKeyboard(); // Or new WirelessKeyboard()
        Computer myComputer = new Computer(myKeyboard);
        myComputer.useKeyboard();
    }
}
