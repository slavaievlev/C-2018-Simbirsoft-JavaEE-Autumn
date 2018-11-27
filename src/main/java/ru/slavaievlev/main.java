package ru.slavaievlev;

import org.springframework.context.ApplicationContext;
import ru.slavaievlev.file_handlers.html.html_generators.GeneratorOfHTMLFile;
import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;

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
    private static final String PATH_TO_HTML_FILE_FOR_SPRINGBOOT = "src/main/resources/templates/resume.html";

    // Геттеры/сеттеры
    public static String getPathToPropertyFiles() {
        return PATH_TO_PROPERTY_FILES;
    }

    public static String getPropertyFile1() {
        return PROPERTY_FILE1;
    }

    public static String getPropertyFile2() {
        return PROPERTY_FILE2;
    }

    public static String getPathToHtmlFile() {
        return PATH_TO_HTML_FILE;
    }

    public static String getPathToHtmlFileForSpringboot() {
        return PATH_TO_HTML_FILE_FOR_SPRINGBOOT;
    }

    public static void main(String[] args) throws InterruptedException{

        // Вытягиваем генератор html-файлов.
        ApplicationContext context = SpringApplication.run(main.class, args);
        GeneratorOfHTMLFile fileGenHTML = context.getBean(GeneratorOfHTMLFile.class);

        // Запускаем генерацию html-файла.
        fileGenHTML.CreateFileHTML();

        System.out.println("HTML files is created!");
    }
}
