package com.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

interface Prototype2 extends Cloneable {
    Prototype2 deepClone();  // Deep copy method
}


class Category implements Cloneable {
    List<String> categories;

    public Category() {
        this.categories = new ArrayList<>();
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Category cloned = new Category();
        for (String category : this.categories) {
            cloned.addCategory(category);  // Deep copy of list elements
        }
        return cloned;
    }

    @Override
    public String toString() {
        return categories.toString();
    }
}

class Product implements Prototype2 {
    String name;
    double price;
    Category category;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public Product deepClone() {
        try {
            Product cloned = (Product) super.clone();
            cloned.category = (Category) category.clone();  // Deep copy of Category
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported");
        }
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: " + price + ", Categories: " + category;
    }
}

public class DeepCopyPrototypePatternDemo {
    public static void main(String[] args) {
        // Create Category and Product
        Category category = new Category();
        category.addCategory("Electronics");
        category.addCategory("Gadgets");

        Product original = new Product("Smartphone", 699.99, category);

        // Clone the Product
        Product cloned = original.deepClone();

        // Print before modification
        System.out.println("Before Modification:");
        System.out.println("Original: " + original);
        System.out.println("Cloned: " + cloned);

        // Modify cloned object's category
        cloned.category.addCategory("Mobile");
        cloned.name = "Tablet";
        cloned.price = 499.99;

        System.out.println("\nAfter Modification:");
        System.out.println("Original: " + original);  // Original should remain unchanged
        System.out.println("Cloned: " + cloned);
    }
}

