package ru.slavaievlev.file_handlers;

public class HandlerOfNullString {
    public String fromNullToEmptyString(String s) {
        if (s == null) {
            return "";
        }
        return s;
    }
}
