/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arqsoft.spreadsheet.view.text;

import com.arqsoft.spreadsheet.view.UIRenderer;

/**
 *
 * @author raquel
 */
public class TextUIRenderer implements UIRenderer {

    private TextUISpreadsheet spreadsheet;
    private int rowOffset = 0;
    private int columnOffset = 0;
    private int rowMax = 5;
    private int columnMax = 5;

    public void setSpreadsheet(TextUISpreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }
    
    @Override
    public void render() {
        StringBuilder builder = new StringBuilder();
        for (int i=this.rowOffset; i <= this.rowMax; i++) {
            System.out.println();
            for (int j=this.columnOffset ;j <= this.columnMax; j++) {
                
            }
        }
    }
  
}
