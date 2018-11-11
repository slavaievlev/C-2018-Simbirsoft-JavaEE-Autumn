package ru.slavaievlev.file_handlers.html.html_objects;

public class MetaCharset extends HTMLObject {
    public MetaCharset(String encoding) {
        this.htmlText = "<meta charset=\"" + encoding + "\" />";
        isLineFeed = true;
    }
}
