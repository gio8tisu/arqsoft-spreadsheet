/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arqsoft.spreadsheet.view.text;

import com.arqsoft.spreadsheet.view.UIRenderer;
import com.arqsoft.spreadsheet.view.UISpreadsheet;

public class TextUIRenderer implements UIRenderer {

    private int rowOffset = 0;
    private int columnOffset = 0;
    private int rowMax = 5;
    private int columnMax = 5;

    @Override
    public void render(UISpreadsheet spreadsheet) {
        StringBuilder builder = new StringBuilder();
        for (int i=this.rowOffset; i <= this.rowMax; i++) {
            System.out.println();
            for (int j=this.columnOffset ;j <= this.columnMax; j++) {
                builder.delete(0, builder.length());
                builder.append(i).append(",").append(j);
                TextUICell cell = (TextUICell) spreadsheet.getCell(i, j);
                if(cell != null) {
                    builder.delete(0,builder.length());
                    builder.append("[").append(cell.getValue()).append("]");
                    System.out.print(builder.toString());
                } else {
                    System.out.print("[  ]");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
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
}
