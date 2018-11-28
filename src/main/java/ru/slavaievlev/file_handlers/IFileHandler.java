package ru.slavaievlev.file_handlers;

// Интерфейс обработчика файлов.
public interface IFileHandler {
    boolean open(String path);
    boolean close();
}
