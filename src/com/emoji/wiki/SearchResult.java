package com.emoji.wiki;

public class SearchResult {
    private String title;
    private Integer pageId;
    private Integer wordCount;
    private String snippet;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    @Override
    public String toString() {
        return title + ": " + snippet;
    }
}
