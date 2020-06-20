package com.arqsoft;

import com.arqsoft.domain.Cell;
import com.arqsoft.domain.Content;
import com.arqsoft.domain.Coordinate;
import com.arqsoft.domain.SpreadSheet;

public class Main {

    public static void main(String[] args) {
        try {
            SpreadSheetFactory factory = new SpreadSheetFactory();

            SpreadSheet ss = new SpreadSheet();
            Coordinate coordinate = new Coordinate(10, "H");
            Content content = factory.createContent("10");
            ss.setCell(coordinate, new Cell(content));
            System.out.println(ss.getCell(coordinate));
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
