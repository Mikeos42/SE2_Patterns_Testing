package org.examprep.decorator;

abstract class Coffee {
    String description = "";

    abstract double cost();
}

class IcedCoffee extends Coffee {

    public IcedCoffee() {
        description = "Iced Coffee";
    }

    @Override
    double cost() {
        return 10;
    }
}

abstract class CoffeeDecorator extends Coffee {
    Coffee decoratee;
}

class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        decoratee = coffee;
        description = decoratee.description + " + Sugar";
    }

    @Override
    double cost() {
        return decoratee.cost() + 0.5;
    }
}
public class decoratorSelf {
    public static void main(String[] args) {
        Coffee coffee = new IcedCoffee();
        System.out.println("coffee = " + coffee.description + ": " + coffee.cost());
        coffee = new Sugar(coffee);
        System.out.println("coffee = " + coffee.description + ": " + coffee.cost());
        coffee = new Sugar(coffee);
        System.out.println("coffee = " + coffee.description + ": " + coffee.cost());
    }
}
