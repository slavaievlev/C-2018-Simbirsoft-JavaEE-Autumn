package ru.slavaievlev.file_handlers.html.html_objects;

public class BodyEnd extends HTMLObject {
    public BodyEnd() {
        this.htmlText = "</body>";
        isEndBlock = true;
        isLineFeed = true;
    }
}
