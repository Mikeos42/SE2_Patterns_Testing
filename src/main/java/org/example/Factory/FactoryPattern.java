package org.example.Factory;

enum MapType {
    COUNTRY,
    CAPITAL
}

interface Map {
    String getMap();
}

class CapitalMap implements Map {
    @Override
    public String getMap() {
        return "Capital Map String";
    }
}

class CountryMap implements Map {
    @Override
    public String getMap() {
        return "Country Map String";
    }
}

class MapFactory {
    public Map getMap(MapType mapType) {
        if (mapType == MapType.CAPITAL) {
            return new CapitalMap();
        } else if (mapType == MapType.COUNTRY) {
            return new CountryMap();
        }
        return null;
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        MapFactory mapFactory = new MapFactory();

        // Get an object of CapitalMap
        Map capital = mapFactory.getMap(MapType.CAPITAL);
        System.out.println(capital.getMap());
    }

}
