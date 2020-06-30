/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.miniexceljc.view.text;

import edu.upc.etsetb.arqsoft.miniexceljc.util.AlphabeticRadixConverter;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UIRenderer;
import edu.upc.etsetb.arqsoft.miniexceljc.view.UISpreadsheet;

public class TextUIRenderer implements UIRenderer {

    private int rowOffset = 1;
    private int columnOffset = 0;
    private int rowMax = 6;
    private int columnMax = 5;

    @Override
    public void render(UISpreadsheet spreadsheet) {
        StringBuilder builder = new StringBuilder();
        printHeader(builder);
        for (int row=this.rowOffset; row <= this.rowMax; row++) {
            builder.append(row).append(" ");
            printRow(spreadsheet, builder, row);
            System.out.println();
        }
        System.out.println("\n");
    }

    private void printRow(UISpreadsheet spreadsheet, StringBuilder builder, int rowNum) {
        for (int column=this.columnOffset; column <= this.columnMax; column++) {
            builder.append("[");
            builder.append(spreadsheet.getValueAt(rowNum, column));
            builder.append("]").append("\t");
            System.out.print(builder.toString());
            builder.delete(0,builder.length());
        }
    }

    private void printHeader(StringBuilder builder) {
        for (int i = columnOffset; i <= columnMax; i++) {
            builder.append(AlphabeticRadixConverter.toAlphabeticRadix(i)).append("\t");
        }
        System.out.println(builder.toString());
        builder.delete(0,builder.length());
    }

    public void setRowOffset(int rowOffset) {
        this.rowOffset = rowOffset;
    }

    public void setColumnOffset(int columnOffset) {
        this.columnOffset = columnOffset;
    }

    public void setRowMax(int rowMax) {
        this.rowMax = rowMax;
    }

    public void setColumnMax(int columnMax) {
        this.columnMax = columnMax;
    }

    @Override
    public void setOffset(int rowOffset, int columnOffset) {
        this.rowOffset = rowOffset;
        this.columnOffset = columnOffset;
    }
}
