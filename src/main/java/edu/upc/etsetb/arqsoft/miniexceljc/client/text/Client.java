package edu.upc.etsetb.arqsoft.miniexceljc.client.text;

import edu.upc.etsetb.arqsoft.miniexceljc.client.AbstractClient;
import edu.upc.etsetb.arqsoft.miniexceljc.client.FilenameNotSetException;
import edu.upc.etsetb.arqsoft.miniexceljc.client.text.util.CommandParser;
import edu.upc.etsetb.arqsoft.miniexceljc.client.text.util.IllegalCommandException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;

import java.io.IOException;
import java.util.Scanner;

public class Client extends AbstractClient {

    private final Scanner scanner;
    private final CommandParser parser;

    public Client() {
        this.scanner = new Scanner(System.in);
        this.parser = new CommandParser();
    }

    @Override
    public void run() {
        controller.buildFrameWork(this.textContentChecker, this.numericalContentChecker);
        // First, display spreadsheet and help message.
        renderer.render(this.spreadsheet);
        help();
        boolean end = false;
        String command;
        while (!end) {
            System.out.println("Write command (a, s, sa, l, h, q)");
            command = this.scanner.nextLine();
            end = this.processCommand(command);
            renderer.render(this.spreadsheet);
        }
    }

    private boolean processCommand(String commandInput) {
        try {
            Command command = parser.parseCommand(commandInput);
            switch (command) {
                case ADD_CELL:
                    addCell();
                    return false;
                case REMOVE_CELL:
                    removeCell();
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
        System.out.println("Enter filename: ");
        String filename = this.scanner.nextLine();
        controller.saveSpreadsheetAs(filename);
    }

    private void load() {
        System.out.println("Enter filename: ");
        String filename = this.scanner.nextLine();
        try {
            controller.loadSpreadsheet(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void help() {
        System.out.println("add (a): Add content to cell.");
        System.out.println("remove (r): Remove content from cell.");
        System.out.println("save (s): Save spreadsheet to file.");
        System.out.println("saveas (sa): Save spreadsheet to file as given filename.");
        System.out.println("load (l): Load spreadsheet from file.");
        System.out.println("quit (q): Quit program.");
        System.out.println("help (h): Show this message.");
    }

    @Override
    public void addCell() {
        CoordinateSpec coordinateSpec = getCoordinateFromUser();
        ContentSpec contentSpec = getCellContentFromUser();
        addCell(coordinateSpec, contentSpec);
    }

    @Override
    public void removeCell() {
        CoordinateSpec coordinateSpec = getCoordinateFromUser();
        controller.removeCell(coordinateSpec);
    }

    private void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        try {
            controller.addCell(coordinateSpec, contentSpec);
        } catch (NumberFormatException e) {
            System.out.println("Input is not valid: Invalid number (use quotes for text content)");
            contentSpec = getCellContentFromUser();
            addCell(coordinateSpec, contentSpec);
        }
    }

    private CoordinateSpec getCoordinateFromUser() {
        System.out.println("Introduce coordinate (<column> <row>)");
        String coordinate = scanner.nextLine();
        try {
            return (CoordinateSpec) coordinateChecker.checkInput(coordinate);
        } catch (InvalidInputException e) {
            System.out.println("Input is not valid: " + e.getMessage());
            return getCoordinateFromUser();
        }
    }

    private ContentSpec getCellContentFromUser() {
        System.out.println("Introduce content");
        String content = scanner.nextLine();
        try {
            if (content.startsWith("\"") | content.startsWith("'")) {
                return  (ContentSpec) textContentChecker.checkInput(content);
            } else if (content.startsWith("=")) {
                throw new UnsupportedOperationException("Cannot create formula content");
            } else {  // Assume numerical content.
                return (ContentSpec) numericalContentChecker.checkInput(content);
            }
        } catch (InvalidInputException e) {
            System.out.println("Input is not valid: " + e.getMessage());
        }
        return getCellContentFromUser();
    }

}
