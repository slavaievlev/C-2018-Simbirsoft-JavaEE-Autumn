package ru.slavaievlev.file_handlers.html.html_objects;

public class MetaCharset extends HTMLObject {
    public MetaCharset(String encoding) {
        this.htmlText = "<meta " +
                "http-equiv=\"Content-Type\" content=\"text/html; " +
                "charset=" + encoding + "\" />";
        isLineFeed = true;
    }
}
