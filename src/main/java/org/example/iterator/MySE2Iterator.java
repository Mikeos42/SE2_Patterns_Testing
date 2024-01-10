package org.example.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class RadioChannel {
    private String type;
    private double frequency;

    public RadioChannel(String type, double frequency) {
        this.type = type;
        this.frequency = frequency;
    }
}

class RadioChannelCollection implements Iterable<RadioChannel> {
    private List<RadioChannel> channels = new ArrayList<>();

    public void addChannel(RadioChannel channel) {
        channels.add(channel);
    }

    @Override
    public Iterator<RadioChannel> iterator() {
        return new RadioChannelIterator();
    }

    private class RadioChannelIterator implements Iterator<RadioChannel> {
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < channels.size();
        }

        @Override
        public RadioChannel next() {
            if(!hasNext()) {
                throw new NoSuchElementException("User went out of bounds >:(");
            }
            return channels.get(currentIndex++);
        }
    }
}



public class MySE2Iterator {
    public static void main(String[] args) {
        RadioChannelCollection collection = new RadioChannelCollection();
        collection.addChannel(new RadioChannel("English", 98.5));
        collection.addChannel(new RadioChannel("German", 104.3));
        collection.addChannel(new RadioChannel("French", 88.7));

        for (RadioChannel channel : collection) {
            System.out.println(channel);
        }
    }
}
