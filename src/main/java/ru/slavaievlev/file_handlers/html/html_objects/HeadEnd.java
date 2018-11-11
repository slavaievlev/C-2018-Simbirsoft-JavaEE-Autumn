package ru.slavaievlev.file_handlers.html.html_objects;

public class HeadEnd extends HTMLObject {
    public HeadEnd() {
        this.htmlText = "</head>";
        isEndBlock = true;
        isLineFeed = true;
    }
}
