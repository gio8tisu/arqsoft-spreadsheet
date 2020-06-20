package com.arqsoft.spreadsheet.model;

import com.arqsoft.spreadsheet.model.domain.Cell;
import com.arqsoft.spreadsheet.model.domain.Content;
import com.arqsoft.spreadsheet.model.domain.Coordinate;
import com.arqsoft.spreadsheet.model.domain.SpreadSheet;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            SpreadSheetFactory factory = new SpreadSheetFactory();

            SpreadSheet ss = factory.createSpreadSheet();
            // Create cell with numerical content.
            Coordinate coordinate1 = factory.createCoordinate("H 10");
            Content content1 = factory.createContent("10");
            ss.setCell(coordinate1, factory.createCell(content1));
            // Create cell with text content.
            Coordinate coordinate2 = factory.createCoordinate("f 1");
            Content content2 = factory.createContent("'hola'");
            ss.setCell(coordinate2, factory.createCell(content2));

            // Print spreadsheet cells.
            for (Map.Entry<Coordinate, Cell> entry : ss.getCells().entrySet()) {
                System.out.println(entry.getValue() + " (" + entry.getKey() + ")");
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
