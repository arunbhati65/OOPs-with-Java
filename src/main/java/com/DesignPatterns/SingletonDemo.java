package com.DesignPatterns;

public class SingletonDemo {
    private static volatile SingletonDemo instance;
    private SingletonDemo() {}
    public static synchronized SingletonDemo getInstance() {
       if(instance == null) {//first check without loocking
          synchronized (SingletonDemo.class) {//class level lock
              if (instance == null) {//2nd check insude synchronize block.
                  instance = new SingletonDemo();
              }
          }
       }
        return instance;
    }
}

//In Spring Boot, the Singleton pattern is implemented by default for beans managed by the Spring ApplicationContext.
// Spring ensures that only one instance of a bean is created and shared across the application.
