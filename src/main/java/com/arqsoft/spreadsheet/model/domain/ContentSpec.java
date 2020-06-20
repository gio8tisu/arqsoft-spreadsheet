package com.arqsoft.spreadsheet.model.domain;

import com.arqsoft.spreadsheet.model.util.Spec;

public class ContentSpec implements Spec {
    private String content;

    public ContentSpec(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
