package com.arqsoft.domain;

import com.arqsoft.util.Spec;

public class ContentSpec implements Spec {
    private String content;

    public ContentSpec(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
