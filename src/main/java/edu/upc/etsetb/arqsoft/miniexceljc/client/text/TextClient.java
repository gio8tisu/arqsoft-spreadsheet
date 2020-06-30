package edu.upc.etsetb.arqsoft.miniexceljc.client.text;

import edu.upc.etsetb.arqsoft.miniexceljc.client.Client;
import edu.upc.etsetb.arqsoft.miniexceljc.client.FilenameNotSetException;
import edu.upc.etsetb.arqsoft.miniexceljc.client.text.util.CommandParser;
import edu.upc.etsetb.arqsoft.miniexceljc.client.text.util.IllegalCommandException;
import edu.upc.etsetb.arqsoft.miniexceljc.model.ContentSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.postfix.ExpressionException;
import edu.upc.etsetb.arqsoft.miniexceljc.util.AlphabeticRadixConverter;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.CircularReferenceException;
import edu.upc.etsetb.arqsoft.miniexceljc.visitors.NotComputableException;

import java.io.IOException;
import java.util.Scanner;

public class TextClient extends Client {

    private final Scanner scanner;
    private final CommandParser parser;

    public TextClient() {
        this.scanner = new Scanner(System.in);
        this.parser = new CommandParser();
    }

    @Override
    public void run() {
        controller.buildFrameWork(this.textContentChecker, this.numericalContentChecker,
                this.formulaContentChecker);
        // First, display spreadsheet and help message.
        renderer.render(this.spreadsheet);
        help();
        boolean end = false;
        String command;
        while (!end) {
            System.out.println("Write command (a, r, s, sa, l, mv, h, q)");
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
                case MOVE_VIEW:
                    moveView();
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
            System.out.println("No filename associated with this spreadsheet.");
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
        } catch (IOException | CircularReferenceException | NotComputableException e) {
            e.printStackTrace();
        }
    }

    private void help() {
        System.out.println("add (a): Add content to cell.");
        System.out.println("remove (r): Remove content from cell.");
        System.out.println("save (s): Save spreadsheet to file.");
        System.out.println("saveas (sa): Save spreadsheet to file as given filename.");
        System.out.println("load (l): Load spreadsheet from file.");
        System.out.println("move view (mv): Set top left coordinate to move the view.");
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
        try {
            controller.removeCell(coordinateSpec);
        } catch (CircularReferenceException | NotComputableException e) {
            e.printStackTrace();
        }
    }

    private void addCell(CoordinateSpec coordinateSpec, ContentSpec contentSpec) {
        try {
            controller.addCell(coordinateSpec, contentSpec);
        } catch (NumberFormatException e) {
            System.out.println("Input is not valid: Invalid number (use quotes for text content)");
            contentSpec = getCellContentFromUser();
            addCell(coordinateSpec, contentSpec);
        } catch (CircularReferenceException e) {
            System.out.println("Your formula has a circular dependency. Cannot compute.");
        } catch (NotComputableException e) {
            System.out.println("Cannot compute.");
        } catch (ExpressionException e) {
            System.out.println("Expression is not valid.");
        }
    }

    private CoordinateSpec getCoordinateFromUser() {
        System.out.println("Introduce coordinate (<column> <row>)");
        String coordinate = scanner.nextLine();
        try {
            return coordinateChecker.checkInput(coordinate);
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
                return  textContentChecker.checkInput(content);
            } else if (content.startsWith("=")) {
                return formulaContentChecker.checkInput(content);
            } else {  // Assume numerical content.
                return numericalContentChecker.checkInput(content);
            }
        } catch (InvalidInputException e) {
            System.out.println("Input is not valid: " + e.getMessage());
        }
        return getCellContentFromUser();
    }

    private void moveView() {
        CoordinateSpec coordinate = this.getCoordinateFromUser();
        int column = AlphabeticRadixConverter.fromAlphabeticRadix(coordinate.getColumn());
        int row = coordinate.getRow();
        this.renderer.moveView(row, column);
    }

}
