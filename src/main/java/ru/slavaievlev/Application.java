package ru.slavaievlev;

import org.springframework.context.ApplicationContext;
import ru.slavaievlev.file_handlers.html.html_generators.GeneratorOfHTMLFile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException{

        // Вытягиваем генератор html-файлов.
        ApplicationContext context = SpringApplication.run(Application.class, args);
        GeneratorOfHTMLFile fileGenHTML = context.getBean(GeneratorOfHTMLFile.class);

        // Запускаем генерацию html-файла.
        fileGenHTML.CreateFileHTML();

        System.out.println("HTML files is created!");
    }
}
