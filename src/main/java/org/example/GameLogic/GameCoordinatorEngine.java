package org.example.GameLogic;

import org.example.UserInterface.InterfaceEngine;

public class GameCoordinatorEngine {
    private final InterfaceEngine interfaceEngine;

    public GameCoordinatorEngine() {
        interfaceEngine = new InterfaceEngine();
    }
    public void showMap(String map) {
        interfaceEngine.renderMap(map);
    }
}
