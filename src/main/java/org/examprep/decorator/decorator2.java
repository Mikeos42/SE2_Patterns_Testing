package org.examprep.decorator;

abstract class Beverage {
    String description = "";

    public String getDescription() {
        return description;
    }

    abstract public int cost();
}

class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public int cost() {
        return 10;
    }
}
class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public int cost() {
        return 8;
    }
}
class Decaf extends Beverage {
    public Decaf() {
        description = "Decaf";
    }

    @Override
    public int cost() {
        return 6;
    }
}
class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public int cost() {
        return 4;
    }
}

abstract class CondimentDecorator extends Beverage {
    public abstract String getDescription();
}
class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }
}
class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 5;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
public class decorator2 {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " €" + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        System.out.println(darkRoast.getDescription() + " €" + darkRoast.cost());

        darkRoast = new Milk(darkRoast);
        darkRoast = new Milk(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() + " €" + darkRoast.cost());

    }
}
