package ru.slavaievlev.file_handlers.html.html_objects;

public class PEnd extends HTMLObject {
    public PEnd() {
        this.htmlText = "</p>";
        isEndBlock = true;
        isLineFeed = true;
    }
}
