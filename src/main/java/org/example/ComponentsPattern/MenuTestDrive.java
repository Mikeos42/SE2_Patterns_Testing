package org.example.ComponentsPattern;

import java.util.*;

// Component Interface
interface MenuComponent {
    void print();
    void add(MenuComponent menuComponent);
}

// Leaf
class MenuItem implements MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.println(" " + name + ", " + price + " -- " + description + (vegetarian ? " (Veggy)" : ""));
    }

    @Override
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException("Sorry, but you can only add Elements to a Menu, not to an Item");
    }
}

// Composite
class Menu implements MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public void print() {
        System.out.println("\n" + name + ", " + description + "\n---------------------");
        for (MenuComponent menuComponent : menuComponents) {
            // there is a drawback, as we want to treat leaves and composites differently, but it's hard
            menuComponent.print();
        }
    }
}

// Example Usage
public class MenuTestDrive {
    public static void main(String[] args) {
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        allMenus.add(dinerMenu);
        allMenus.add(dessertMenu);

        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce", true, 3.89));
        dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust", true, 1.59));

        dinerMenu.add(dessertMenu);


        allMenus.print();
    }
}

