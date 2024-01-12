package org.examprep.factory;

import java.beans.DefaultPersistenceDelegate;

class Document {
    String content;

    public Document(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Document{" +
                "content='" + content + '\'' +
                '}';
    }
}

class TextDoc extends Document {
    public TextDoc(String content) {
        super(content);
    }
}

class ImgDoc extends Document {
    public ImgDoc(String content) {
        super(content);
    }
}

class DocumentFactory {
    public static Document createDocument(String type) {
        if("big".equals(type)) {
            return new TextDoc("Text Document");
        }
        return new ImgDoc("Image Document");
    }
}

public class factoryNormal {
    public static void main(String[] args) {
        Document doc = DocumentFactory.createDocument("small");
        System.out.println("doc = " + doc);
    }
}
