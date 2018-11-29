package ru.slavaievlev.file_handlers.properties;

import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;

import java.util.LinkedList;

// Интерфейс обработчика properties-файлов.
public interface IPropertiesHandler {
    boolean createEmptyPropertiesFile(String path);
    boolean getData();
}
