package ru.slavaievlev.file_handlers.html.html_generators;

// Интерфейс генератора html файлов.
public interface IGeneratorOfHTMLFile {
    boolean CreateFileHTML(HTMLModel model, String pathToHTMLFile, String pathToHTMLFileForSpringBoot);
}
