package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.client.SpreadsheetController;
import com.arqsoft.spreadsheet.client.text.Client;
import com.arqsoft.spreadsheet.client.text.util.CoordinateChecker;
import com.arqsoft.spreadsheet.client.text.util.NumericalContentChecker;
import com.arqsoft.spreadsheet.client.text.util.TextContentChecker;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UIRenderer;
import com.arqsoft.spreadsheet.view.UISpreadSheet;

import java.util.Scanner;

public abstract class AbstractClient {
    protected SpreadsheetController controller;
    protected TextContentChecker textContentChecker;
    protected NumericalContentChecker numericalContentChecker;
    protected CoordinateChecker coordinateChecker;
    protected UIFactory factory;
    protected UISpreadSheet spreadSheet;
    protected UIRenderer renderer;

    public static void main(String[] args) {
        try {
            System.out.println("Starting text client.");
            SpreadsheetController controller = new SpreadsheetController();

            // TODO: main menu, ...
            UIFactory factory = UIFactory.getInstance("text");
            Client client = new Client();
            client.setController(controller);
            client.setFactory(factory);
            client.setTextContentChecker(new TextContentChecker());
            client.setNumericalContentChecker(new NumericalContentChecker());
            client.setCoordinateChecker(new CoordinateChecker());

            client.run();
            System.out.println("Done.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage() + ".");
        }
    }

    public void setController(SpreadsheetController controller) {
        this.controller = controller;
    }

    public void setFactory(UIFactory factory) {
        this.factory = factory;
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

    public abstract void addCell();
    public abstract void run();
}
