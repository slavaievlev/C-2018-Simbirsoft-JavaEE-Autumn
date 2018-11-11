package ru.slavaievlev.file_handlers.html.html_objects;

public class Body extends HTMLObject {
    public Body() {
        this.htmlText = "<body>";
        isBeginBlock = true;
        isLineFeed = true;
    }
}
