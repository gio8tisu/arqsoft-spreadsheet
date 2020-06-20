package com.arqsoft.spreadsheet.client.text;

import com.arqsoft.spreadsheet.client.AbstractClient;
import com.arqsoft.spreadsheet.client.text.util.CommandParser;
import com.arqsoft.spreadsheet.client.text.util.IllegalCommandException;
import com.arqsoft.spreadsheet.model.ContentSpec;
import com.arqsoft.spreadsheet.model.CoordinateSpec;

import java.util.Scanner;

public class Client extends AbstractClient {

    private final Scanner scanner;
    private final CommandParser parser;

    public Client() {
        this.scanner = new Scanner(System.in);
        this.parser = new CommandParser();
    }

    public void addCell(String coordinateInput, String contentInput) throws InvalidInputException {
        // Create coordinate spec.
        CoordinateSpec coordinateSpec = (CoordinateSpec) coordinateChecker.checkInput(coordinateInput);
        // Create content spec.
        if (contentInput.startsWith("\"") | contentInput.startsWith("'")) {
            ContentSpec contentSpec = (ContentSpec) textContentChecker.checkInput(contentInput);
            controller.addCell(coordinateSpec, contentSpec);
        } else if (contentInput.startsWith("=")) {
            throw new UnsupportedOperationException("Cannot create formula content");
        } else {
            // Assume numerical content.
            ContentSpec contentSpec = (ContentSpec) numericalContentChecker.checkInput(contentInput);
            controller.addCell(coordinateSpec, contentSpec);
        }
    }

    @Override
    public void run() {
        controller.buildFrameWork();
        boolean end = false;
        String command;
        while (!end) {
            System.out.println("Write command (a, s, l, h, q)");
            command = this.scanner.nextLine();
            end = this.processCommand(command);
            // TODO: display spreadsheet.
        }
    }

    private boolean processCommand(String commandInput) {
        try {
            Command command = parser.parseCommand(commandInput);
            switch (command) {
                case ADD_CELL:
                    addCell();
                case HELP:
                    help();
                case SAVE:
                case LOAD:
                    return false;
                case QUIT:
                    return true;
            }
        } catch (IllegalCommandException e) {
            // TODO: handle exception.
            e.printStackTrace();
        }
        return false;
    }

    private void help() {
        // TODO: print options.
    }

    @Override
    public void addCell() {
        try {
            System.out.println("Introduce coordinate (<column> <row>)");
            String coordinate = scanner.nextLine();
            System.out.println("Introduce content");
            String content = scanner.nextLine();
            addCell(coordinate, content);
        } catch (InvalidInputException e) {
            System.out.println("Input is not valid: " + e.getMessage());
        }
    }

}
