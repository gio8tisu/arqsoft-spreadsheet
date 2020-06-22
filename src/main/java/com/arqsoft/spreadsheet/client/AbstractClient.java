package com.arqsoft.spreadsheet.client;

import com.arqsoft.spreadsheet.client.text.Client;
import com.arqsoft.spreadsheet.model.SpreadsheetFactory;
import com.arqsoft.spreadsheet.util.CoordinateChecker;
import com.arqsoft.spreadsheet.util.NumericalContentChecker;
import com.arqsoft.spreadsheet.util.TextContentChecker;
import com.arqsoft.spreadsheet.view.UIFactory;
import com.arqsoft.spreadsheet.view.UIRenderer;
import com.arqsoft.spreadsheet.view.UISpreadsheet;

public abstract class AbstractClient {
    protected SpreadsheetController controller;
    protected TextContentChecker textContentChecker;
    protected NumericalContentChecker numericalContentChecker;
    protected CoordinateChecker coordinateChecker;
    protected UIRenderer renderer;
    protected UISpreadsheet spreadsheet;

    public static void main(String[] args) {
        try {
            System.out.println("Starting text client.");
            SpreadsheetFactory factory = new SpreadsheetFactory();
            UIFactory uiFactory = UIFactory.getInstance("text");
            UISpreadsheet spreadsheet = uiFactory.createUISpreadSheet();
            spreadsheet.setFactory(factory);
            SpreadsheetController controller = new SpreadsheetController();
            controller.setUIFactory(uiFactory);
            controller.setFactory(factory);
            controller.setUISpreadsheet(spreadsheet);

            Client client = new Client();
            client.setRenderer(uiFactory.createUIRenderer());
            client.setController(controller);
            client.setSpreadsheet(spreadsheet);
            client.setTextContentChecker(new TextContentChecker());
            client.setNumericalContentChecker(new NumericalContentChecker());
            client.setCoordinateChecker(new CoordinateChecker());

            controller.buildFrameWork(client.textContentChecker, client.numericalContentChecker);
            client.run();
            System.out.println("Done.");
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage() + ".");
        }
    }

    public void setRenderer(UIRenderer uiRenderer) {
        this.renderer = uiRenderer;
    }

    public void setSpreadsheet(UISpreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public void setController(SpreadsheetController controller) {
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

    public abstract void addCell();
    public abstract void run();
}
