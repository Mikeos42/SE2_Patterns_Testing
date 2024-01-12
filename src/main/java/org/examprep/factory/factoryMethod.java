package org.examprep.factory;

interface MyDocument {
    void open();
    void close();
}

class TextDocument implements MyDocument {
    @Override
    public void open() {
        System.out.println("Opening Text Document");
    }

    @Override
    public void close() {
        System.out.println("Closing Text Document");
    }
}

class FlowerDocument implements MyDocument {
    @Override
    public void open() {
        System.out.println("Opening Flower Document");
    }

    @Override
    public void close() {
        System.out.println("Closing Flower Document");
    }
}

interface MyDocumentFactory {
    MyDocument createDocument();
}

class TextDocumentFactory implements MyDocumentFactory {

    @Override
    public MyDocument createDocument() {
        return new TextDocument();
    }
}

class FlowerDocumentFactory implements MyDocumentFactory {

    @Override
    public MyDocument createDocument() {
        return new FlowerDocument();
    }
}
public class factoryMethod {
    public static void main(String[] args) {
        MyDocumentFactory factory = new TextDocumentFactory();
        MyDocument document = factory.createDocument();
        document.open();
        document.close();
        new FlowerDocumentFactory().createDocument().open();
    }
}
