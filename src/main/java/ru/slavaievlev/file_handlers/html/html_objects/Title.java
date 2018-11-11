package ru.slavaievlev.file_handlers.html.html_objects;

public class Title extends HTMLObject {
    public Title(String titleText) {
        this.htmlText = "<title>" + titleText + "</title>";
        isLineFeed = true;
    }
}
