package ru.slavaievlev.file_handlers.properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;
import ru.slavaievlev.main;

@Component
public class PropertyReaderForPropertyOne extends Thread implements IPropertyReader{

    // Модель html-файла.
    private ResumeDto model;

    // Обработчик properties файла.
    private PropertiesHandler propertiesHandler;

    // Путь до папки с property файлами.
    private String pathToPropertyFiles;

    // Название property файла.
    private String nameOfPropertyFile;

    public PropertyReaderForPropertyOne() {
        this.propertiesHandler = new PropertiesHandler();
        this.pathToPropertyFiles = main.getPathToPropertyFiles();
        this.nameOfPropertyFile = main.getPropertyFile1();
        this.model = new ResumeDto();
    }

    // Старт потока.
    public void run() {
        StarterReadingProperty starterReadingProperty = new StarterReadingProperty(propertiesHandler,
                pathToPropertyFiles, nameOfPropertyFile, model);
        starterReadingProperty.start();
    }
}
