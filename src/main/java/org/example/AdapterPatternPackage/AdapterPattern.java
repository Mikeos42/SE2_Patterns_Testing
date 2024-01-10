package org.example.AdapterPatternPackage;

import java.util.*;

class EnumerationAdapter<T> implements Iterator<T> {
    private Enumeration<T> enumeration;

    public EnumerationAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }
}

public class AdapterPattern {

    public static void main(String[] args) {
        Vector<Integer> integerVector = new Vector<>();
        integerVector.addAll(List.of(1,3,2,41,12,42));

        EnumerationAdapter<Integer> enumerationAdapter = new EnumerationAdapter<>(integerVector.elements());

        while(enumerationAdapter.hasNext()) {
            System.out.println("enumerationAdapter.next() = " + enumerationAdapter.next());
        }
    }
}