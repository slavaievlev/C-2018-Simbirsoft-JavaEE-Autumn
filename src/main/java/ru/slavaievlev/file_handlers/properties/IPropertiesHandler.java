package ru.slavaievlev.file_handlers.properties;

import java.util.LinkedList;

// Интерфейс обработчика properties-файлов.
public interface IPropertiesHandler {
    boolean createEmptyPropertiesFile(String path);
    String getValueInString(String key);
    LinkedList<String> getValueInLinkedList(String key);
}
