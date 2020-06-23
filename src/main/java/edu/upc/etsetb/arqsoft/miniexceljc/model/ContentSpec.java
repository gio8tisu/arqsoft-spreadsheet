package edu.upc.etsetb.arqsoft.miniexceljc.model;

import edu.upc.etsetb.arqsoft.miniexceljc.model.domain.CellType;

public class ContentSpec implements Spec {
    private String content;

    private CellType type;

    public ContentSpec(String content, CellType type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public CellType getType() {
        return type;
    }

}
