package com.DesignPatterns;

interface Prototype extends Cloneable {
    Prototype shallowClone();  // Shallow copy method
}

class Address {
    String city, country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class Employee implements Prototype {
    String name;
    int age;
    Address address;  // Referenced object

    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public Employee shallowClone() {
        try {
            return (Employee) super.clone();  // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported");
        }
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", Age: " + age + ", Address: " + address;
    }
}

public class ShallowCopyProtypePatternDemo {
    public static void main(String[] args) {
        // Create an Address and Employee
        Address address = new Address("New York", "USA");
        Employee original = new Employee("John Doe", 30, address);

        // Clone the Employee (Shallow Copy)
        Employee cloned = original.shallowClone();

        // Print before modification
        System.out.println("Before Modification:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // Modify the cloned object's address
        cloned.address.city = "Los Angeles";
        cloned.name = "Jane Doe";  // Changing only the cloned employee name

        System.out.println("\nAfter Modification:");
        System.out.println("Original: " + original); // Address will change in original (Shallow Copy)
        System.out.println("Cloned: " + cloned);
    }
}

