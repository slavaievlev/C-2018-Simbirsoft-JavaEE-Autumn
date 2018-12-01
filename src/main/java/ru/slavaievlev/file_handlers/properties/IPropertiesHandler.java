package ru.slavaievlev.file_handlers.properties;

// Интерфейс обработчика properties-файлов.
public interface IPropertiesHandler {
    boolean createEmptyPropertiesFile(String path);
    boolean getData();
}
