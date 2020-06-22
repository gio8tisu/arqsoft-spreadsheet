package com.arqsoft.spreadsheet.client.text;

import com.arqsoft.spreadsheet.client.AbstractClient;
import com.arqsoft.spreadsheet.client.FilenameNotSetException;
import com.arqsoft.spreadsheet.client.text.util.CommandParser;
import com.arqsoft.spreadsheet.client.text.util.IllegalCommandException;
import com.arqsoft.spreadsheet.model.ContentSpec;
import com.arqsoft.spreadsheet.model.CoordinateSpec;

import java.io.IOException;
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
            try {
                ContentSpec contentSpec = (ContentSpec) numericalContentChecker.checkInput(contentInput);
                controller.addCell(coordinateSpec, contentSpec);
            } catch (NumberFormatException e) {
                throw new InvalidInputException("Invalid number (use quotes for text content)");
            }
        }
    }

    @Override
    public void run() {
        controller.buildFrameWork(this.textContentChecker, this.numericalContentChecker);
        boolean end = false;
        String command;
        while (!end) {
            System.out.println("Write command (a, s, sa, l, h, q)");
            command = this.scanner.nextLine();
            end = this.processCommand(command);
        }
    }

    private boolean processCommand(String commandInput) {
        try {
            Command command = parser.parseCommand(commandInput);
            switch (command) {
                case ADD_CELL:
                    addCell();
                    return false;
                case HELP:
                    help();
                    return false;
                case SAVE:
                    save();
                    return false;
                case SAVE_AS:
                    saveAs();
                    return false;
                case LOAD:
                    load();
                    return false;
                case QUIT:
                    return true;
            }
        } catch (IllegalCommandException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
            return true;
        }
        return false;
    }

    private void save() {
        try {
            controller.saveSpreadsheet();
        } catch (FilenameNotSetException e) {
            System.out.println("No filename associated with this spread sheet.");
            saveAs();
        }
    }

    private void saveAs() {
        System.out.print("Enter filename: ");
        String filename = this.scanner.nextLine();
        controller.saveSpreadsheetAs(filename);
    }

    private void load() {
        System.out.print("Enter filename: ");
        String filename = this.scanner.nextLine();
        try {
            controller.loadSpreadsheet(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void help() {
        System.out.println("add (a): Add content to cell.");
        System.out.println("save (s): Save spreadsheet to file.");
        System.out.println("saveas (sa): Save spreadsheet to file as given filename.");
        System.out.println("load (l): Load spreadsheet from file.");
        System.out.println("quit (q): Quit program.");
        System.out.println("help (h): Show this message.");
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
            addCell();
        }
    }

}
