package org.example.StrategyPattern;

public class CoffeeShop {
    interface Flavor {
        String getDescription();
    }

    interface Topping {
        String getDescription();
    }

    static class VanillaFlavor implements Flavor {
        @Override
        public String getDescription() {
            return "Vanilla";
        }
    }

    static class CaramelFlavor implements Flavor {
        @Override
        public String getDescription() {
            return "Caramel";
        }
    }

    static class WhippedCreamTopping implements Topping {
        @Override
        public String getDescription() {
            return "Whipped Cream";
        }
    }

    static class ChocolateChipsTopping implements Topping {
        @Override
        public String getDescription() {
            return "Chocolate Chips";
        }
    }

    static class Coffee {
        private Flavor flavor;
        private Topping topping;

        public Coffee(Flavor flavor, Topping topping) {
            this.flavor = flavor;
            this.topping = topping;
        }

        void serveCoffee() {
            System.out.println("Serving a coffee with " + flavor.getDescription() +
                    " flavor and " + topping.getDescription() + " topping.");
        }

        void changeTopping(Topping topping) {
            this.topping = topping;
        }
    }


    public static void main(String[] args) {
        Coffee coffee1 = new Coffee(new VanillaFlavor(), new WhippedCreamTopping());
        coffee1.serveCoffee();

        coffee1.changeTopping(new ChocolateChipsTopping());
        coffee1.serveCoffee();

        Coffee coffee2 = new Coffee(new CaramelFlavor(), new ChocolateChipsTopping());
        coffee2.serveCoffee();
    }
}
