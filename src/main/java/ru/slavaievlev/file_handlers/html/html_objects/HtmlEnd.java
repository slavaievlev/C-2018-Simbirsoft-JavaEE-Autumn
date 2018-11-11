package ru.slavaievlev.file_handlers.html.html_objects;

public class HtmlEnd extends HTMLObject {
    public HtmlEnd() {
        this.htmlText = "</html>";
        isEndBlock = true;
        isLineFeed = true;
    }
}