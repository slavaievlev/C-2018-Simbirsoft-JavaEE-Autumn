package ru.slavaievlev.file_handlers.html.html_objects;

public class Image extends HTMLObject {
    public Image(String src, int width) {
        this.htmlText = "<image src=\"" + src + "\"" +
            "width=\"" + width + "\"" +
            ">";
    }

    public Image(String src) {
        this.htmlText = "<image src=\"" + src + "\">";
    }
}
