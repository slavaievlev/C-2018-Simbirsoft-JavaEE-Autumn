package ru.slavaievlev;

import ru.slavaievlev.file_handlers.html.html_generators.GeneratorOfHTMLFile;
import ru.slavaievlev.file_handlers.html.html_generators.HTMLModel;
import ru.slavaievlev.file_handlers.properties.PropertyReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class main {

    // Путь до папки с properties файлами.
    private static final String PATH_TO_PROPERTY_FILES = "resources/";

    // Названия properties файлов.
    private static final String PROPERTY_FILE1 = "settings1.properties";
    private static final String PROPERTY_FILE2 = "settings2.properties";

    // Путь до html-файлов, которые будут генерироваться генератором html-шаблонов.
    private static final String PATH_TO_HTML_FILE = "resources/index.html";
    private static final String PATH_TO_HTML_FILE_FOR_SPRINGBOOT = "src/main/resources/templates/greeting.mustache";

    public static void main(String[] args) throws InterruptedException{

        // Создаем модель html-файла.
        HTMLModel model = new HTMLModel();

        // Создаем читатель property файла и заполняем внутри модель html-файла.
        PropertyReader propertyReader1 = new PropertyReader(model, PATH_TO_PROPERTY_FILES, PROPERTY_FILE1);
        PropertyReader propertyReader2 = new PropertyReader(model, PATH_TO_PROPERTY_FILES, PROPERTY_FILE2);

        // Запускаем потоки.
        propertyReader1.start();
        propertyReader2.start();

        // Ожидаем выполнение всех потоков.
        propertyReader1.join();
        propertyReader2.join();

        // Создаем генератор html-файлов.
        GeneratorOfHTMLFile fileGenHTML = new GeneratorOfHTMLFile();

        // Создаем html-файл.
        if (!fileGenHTML.CreateFileHTML(model, PATH_TO_HTML_FILE, PATH_TO_HTML_FILE_FOR_SPRINGBOOT)) {
            System.out.print("Не удалось записать данные в файл html по адресу '" + PATH_TO_HTML_FILE + "'");
        }

        System.out.println("HTML files is created!");

        // Запускаем SpringBoot.
        SpringApplication.run(main.class, args);
    }
}
