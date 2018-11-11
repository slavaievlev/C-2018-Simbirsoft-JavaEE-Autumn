package ru.slavaievlev.file_handlers.properties;

import java.util.LinkedList;

// Интерфейс обработчика properties-файлов.
public interface IPropertiesHandler {
    boolean CreateEmptyPropertiesFile(String path);
    String GetValueInString(String key);
    LinkedList<String> GetValueInLinkedList(String key);
}
