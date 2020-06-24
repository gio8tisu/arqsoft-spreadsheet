package edu.upc.etsetb.arqsoft.miniexceljc.client;

import edu.upc.etsetb.arqsoft.miniexceljc.client.text.TextClient;
import edu.upc.etsetb.arqsoft.miniexceljc.factories.SpreadsheetFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.util.CoordinateChecker;
import edu.upc.etsetb.arqsoft.miniexceljc.util.NumericalContentChecker;
import edu.upc.etsetb.arqsoft.miniexceljc.util.TextContentChecker;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UIFactory;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UIRenderer;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UISpreadsheet;

public abstract class Client {
    protected SpreadsheetController controller;
    protected TextContentChecker textContentChecker;
    protected NumericalContentChecker numericalContentChecker;
    protected CoordinateChecker coordinateChecker;
    protected UIRenderer renderer;
    protected UISpreadsheet spreadsheet;

    public static void main(String[] args) {
        try {
            System.out.println("Starting text client.");
            SpreadsheetFactory factory = SpreadsheetFactory.getInstance("DEFAULT");
            UIFactory uiFactory = UIFactory.getInstance("text");
            UISpreadsheet spreadsheet = uiFactory.createUISpreadSheet();
            spreadsheet.setFactory(factory);
            SpreadsheetController controller = new SpreadsheetController();
            controller.setUIFactory(uiFactory);
            controller.setFactory(factory);
            controller.setUISpreadsheet(spreadsheet);

            Client client = factory.createClient();
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
    public abstract void removeCell();
    public abstract void run();
}
