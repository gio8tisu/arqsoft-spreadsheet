package com.arqsoft.spreadsheet.client.text;

import com.arqsoft.spreadsheet.client.SpreadSheetController;
import com.arqsoft.spreadsheet.client.text.util.CoordinateChecker;
import com.arqsoft.spreadsheet.client.text.util.NumericalContentChecker;
import com.arqsoft.spreadsheet.client.text.util.TextContentChecker;
import com.arqsoft.spreadsheet.model.ContentSpec;
import com.arqsoft.spreadsheet.model.CoordinateSpec;

public class Client {

    private SpreadSheetController controller;
    private TextContentChecker textContentChecker;
    private NumericalContentChecker numericalContentChecker;
    private CoordinateChecker coordinateChecker;

    public Client() {}

    public void setController(SpreadSheetController controller) {
        this.controller = controller;
    }

    public void setTextContentChecker(TextContentChecker textContentChecker) {
        this.textContentChecker = textContentChecker;
    }

    public void setNumericalContentChecker(NumericalContentChecker numericalContentChecker) {
        this.numericalContentChecker = numericalContentChecker;
    }

    public void setCoordinateChecker(CoordinateChecker coordinateChecker) {
        this.coordinateChecker = coordinateChecker;
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

    public static void main(String[] args) {
        try {
            System.out.println("Start.");
            SpreadSheetController controller = new SpreadSheetController();
            controller.buildFrameWork();

            Client client = new Client();
            client.setController(controller);
            client.setTextContentChecker(new TextContentChecker());
            client.setNumericalContentChecker(new NumericalContentChecker());
            client.setCoordinateChecker(new CoordinateChecker());
            // TODO.
            client.addCell("H 10", "10");
            client.addCell("f 10", "'Hola'");
            System.out.println("Done.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage() + ".");
        }
    }
}
