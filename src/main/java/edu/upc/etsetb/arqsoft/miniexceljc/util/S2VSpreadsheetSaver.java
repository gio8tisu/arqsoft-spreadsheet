package edu.upc.etsetb.arqsoft.miniexceljc.util;

import edu.upc.etsetb.arqsoft.miniexceljc.model.CoordinateSpec;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Cell;
import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.Coordinate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class S2VSpreadsheetSaver extends SpreadsheetSaver {

    private void writeContent(FileWriter writer) throws IOException {
        SpreadsheetLimit<Integer> limit = findLimit();
        CoordinateSpec coordinateSpec;
        Coordinate coordinate;
        Cell cell;
        for (int i = 1; i <= limit.getMaxRow(); i++) {
            for (int j = 0; j <= limit.getMaxColumn(); j++) {
                coordinateSpec = new CoordinateSpec(
                        i, AlphabeticRadixConverter.toAlphabeticRadix(j));
                coordinate = factory.createCoordinate(coordinateSpec);
                cell = this.spreadsheet.getCell(coordinate);
                if (cell != null)
                    writer.write(cell.getContent().toString());
                if (j != limit.getMaxColumn())
                    writer.write(";");
            }
            if (i != limit.getMaxRow())
                writer.write("\n");
        }
        writer.close();
    }

    @Override
    public void save() {
        try {
            File file = new File(this.filename);
            if (file.createNewFile()) {
                logger.info("Creating new file (" + this.filename + ").");
            } else {
                logger.info("Overwriting file contents(" + this.filename + ").");
            }
            FileWriter writer = new FileWriter(file);
            writeContent(writer);
        } catch (IOException e) {
            logger.severe("Error while trying to save");
        }
    }

    @Override
    public void saveAs(String filename) {
        this.filename = filename;
        this.save();
    }

    private SpreadsheetLimit<Integer> findLimit() {
        int maxColumn = 0, maxRow = 0;
        for (Coordinate coordinate: this.spreadsheet.getCells().keySet()) {
            if (maxRow < coordinate.getRow())
                maxRow = coordinate.getRow();

            int col = AlphabeticRadixConverter.fromAlphabeticRadix(coordinate.getColumn());
            if (maxColumn < col)
                maxColumn = col;
        }
        return new SpreadsheetLimit<>(maxColumn, maxRow);
    }

}

class SpreadsheetLimit<T> {
    private final T maxColumn;
    private final T maxRow;

    SpreadsheetLimit(T maxColumn, T maxRow) {
        this.maxColumn = maxColumn;
        this.maxRow = maxRow;
    }

    public T getMaxColumn() {
        return maxColumn;
    }

    public T getMaxRow() {
        return maxRow;
    }
}
