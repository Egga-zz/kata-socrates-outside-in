package de.egga.classicist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author egga
 */
public class InMemoryConsoleOutput implements ConsoleOutput {

    private List<String> output = new ArrayList<>();

    @Override
    public void printLine(String line) {
        output.add(line);
    }

    public List<String> getOutput() {
        return output;
    }
}
