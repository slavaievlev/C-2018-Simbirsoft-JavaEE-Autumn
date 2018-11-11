package ru.slavaievlev.file_handlers.html.html_objects;

public class Text extends HTMLObject {
    public Text(String text) {
        this.htmlText = text;
    }

    public Text(String text, boolean isLineFeed) {
        this.htmlText = text;
        this.isLineFeed = isLineFeed;
    }
}
