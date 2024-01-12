package org.examprep.factory;

// Abstract product interfaces
interface Button {
    void render();
}

interface TextBox {
    void render();
}

// Concrete products for Windows
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows button");
    }
}

class WindowsTextBox implements TextBox {
    public void render() {
        System.out.println("Rendering Windows text box");
    }
}

// Concrete products for MacOS
class MacOSButton implements Button {
    public void render() {
        System.out.println("Rendering MacOS button");
    }
}

class MacOSTextBox implements TextBox {
    public void render() {
        System.out.println("Rendering MacOS text box");
    }
}

// Abstract factory
interface WidgetFactory {
    Button createButton();
    TextBox createTextBox();
}

// Concrete factory for Windows
class WindowsWidgetFactory implements WidgetFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public TextBox createTextBox() {
        return new WindowsTextBox();
    }
}

// Concrete factory for MacOS
class MacOSWidgetFactory implements WidgetFactory {
    public Button createButton() {
        return new MacOSButton();
    }

    public TextBox createTextBox() {
        return new MacOSTextBox();
    }
}

public class factoryAbstract {
    public static void main(String[] args) {
        WidgetFactory factory = new WindowsWidgetFactory();
        factory.createButton().render();
    }
}
