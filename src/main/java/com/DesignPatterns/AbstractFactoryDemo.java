package com.DesignPatterns;

// Product Interface for Buttons
interface Button {
    void render();
}

// Product Interface for Checkboxes
interface Checkbox {
    void render();
}

// Windows Button Implementation
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

// MacOS Button Implementation
class MacOSButton implements Button {
    public void render() {
        System.out.println("Rendering MacOS Button");
    }
}

// Windows Checkbox Implementation
class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

// MacOS Checkbox Implementation
class MacOSCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering MacOS Checkbox");
    }
}

interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Windows Factory
class WindowsFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// MacOS Factory
class MacOSFactory implements UIFactory {
    public Button createButton() {
        return new MacOSButton();
    }

    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Simulate getting the OS type dynamically
        UIFactory factory;

        String osType = "Windows"; // Change to "MacOS" to test MacOSFactory

        if (osType.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }

        // Creating UI elements
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Rendering UI elements
        button.render();
        checkbox.render();
    }
}

//Spring’s BeanFactory is an implementation of the Factory Design Pattern and Abstract Factory Pattern for managing beans.
//	•	ApplicationContext (Abstract Factory) → BeanFactory (Concrete Factory) → Different Beans (Products)
//	•	Concrete implementations like AnnotationConfigApplicationContext provide different factories for different object types.
//Spring Boot’s auto-configuration mechanism uses the Abstract Factory Pattern to create different configurations based on classpath dependencies.

//Yes, in the Abstract Factory Pattern, all the items (products) must implement the same interface to ensure consistency.
//✅ Encapsulation: Clients only interact with the interface (Part), not the concrete classes.
//✅ Flexibility: New Part types (e.g., ElectricEngine, MichelinTyre) can be added without modifying the factory logic.
//✅ Polymorphism: The same method (getItem()) can return different objects while keeping the same behavior.
