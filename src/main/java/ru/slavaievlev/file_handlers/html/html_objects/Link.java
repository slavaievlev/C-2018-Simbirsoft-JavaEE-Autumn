package ru.slavaievlev.file_handlers.html.html_objects;

public class Link extends HTMLObject {
    public Link(String href, String name) {
        this.htmlText = "<a href=\"" +
                href +
                "\">" + name + "</a>";
    }
}
