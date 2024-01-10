package org.example.UserInterface;

public class InterfaceEngine {

    private CLIRenderer cliRenderer;
    public InterfaceEngine() {
        cliRenderer = new CLIRenderer();
    }

    public void renderMap(String map) {
        cliRenderer.renderMap(map);
    }
}
