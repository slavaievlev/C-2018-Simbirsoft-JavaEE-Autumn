package ru.slavaievlev.file_handlers.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;

@Component
public class PropertyReaderForPropertyOne extends Thread implements IPropertyReader{

    // Модель html-файла.
    private ResumeDto model;

    // Обработчик properties файла.
    private PropertiesHandler propertiesHandler;

    // Путь до папки с property файлами.
    @Value("${PATH_TO_PROPERTY_FILES}")
    private String pathToPropertyFiles;

    // Название property файла.
    @Value("${PROPERTY_FILE1}")
    private String nameOfPropertyFile;

    public PropertyReaderForPropertyOne() {
        this.propertiesHandler = new PropertiesHandler();
        this.model = new ResumeDto();
    }

    // Старт потока.
    public void run() {
        StarterReadingProperty starterReadingProperty = new StarterReadingProperty(propertiesHandler,
                pathToPropertyFiles, nameOfPropertyFile, model);
        starterReadingProperty.start();
    }
}
