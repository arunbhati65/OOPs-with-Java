package com.DesignPatterns;

interface Car{
    void PrintCompanyName();
}

class BMW implements Car{
    @Override
    public void PrintCompanyName() {
        System.out.println("BMW");
    }
}
class KIA implements Car{
    @Override
    public void PrintCompanyName() {
        System.out.println("KIA");
    }
}
 class CarFactory {

    public static Car getCar(String companyName) {
        if(companyName.equals("BMW")) {
            return new BMW();
        }else if(companyName.equals("KIA")) {
            return new KIA();
        }else {
            throw new IllegalArgumentException("Invalid company name: " + companyName);
        }
    }
}

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Car car=CarFactory.getCar("BMW");
        car.PrintCompanyName();
        car=CarFactory.getCar("KIA");
        car.PrintCompanyName();
    }
}

//The Factory Pattern is used to create objects without exposing the instantiation logic to the client.
//Spring internally creates and manages beans using BeanFactory, which follows the Factory Pattern.
/*
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanFactoryExample {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Car car = context.getBean(Car.class);
        car.printCompanyName();
    }
}
 */