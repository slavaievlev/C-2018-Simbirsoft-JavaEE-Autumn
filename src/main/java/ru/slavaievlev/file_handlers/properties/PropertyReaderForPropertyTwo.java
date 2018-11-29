package ru.slavaievlev.file_handlers.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;

@Component
public class PropertyReaderForPropertyTwo extends Thread implements IPropertyReader {

    // Путь до папки с property файлами.
    @Value("${PATH_TO_PROPERTY_FILES}")
    private String pathToPropertyFiles;

    // Название property файла.
    @Value("${PROPERTY_FILE2}")
    private String nameOfPropertyFile;

    // Старт потока.
    public void run() {
        new PropertiesHandler(pathToPropertyFiles + nameOfPropertyFile, new ResumeDto()).getData();
    }
}
