package ru.slavaievlev;

import ru.slavaievlev.file_handlers.html.html_generators.GeneratorOfHTMLFile;
import ru.slavaievlev.file_handlers.html.html_generators.HTMLModel;
import ru.slavaievlev.file_handlers.properties.PropertiesHandler;

public class main {
    // Путь до файла properties.
    private static final String PATH_TO_PROPERTIES_FILE = "resources/settings.properties";
    // Путь до html-файла, который будет генерироваться генератором html-шаблонов.
    private static final String PATH_TO_HTML_FILE = "resources/index.html";

    public static void main(String[] args) {
        // Создаем обработчик properties-файлов.
        PropertiesHandler propHandler = new PropertiesHandler();

        // Создаем модель html-файла.
        HTMLModel model = new HTMLModel();

        // Открывам файл properties в обработчике.
        if (!propHandler.Open(PATH_TO_PROPERTIES_FILE)) {
            System.out.print("Не удалось открыть файл properties по адресу '" + PATH_TO_PROPERTIES_FILE + "'");
            return;
        }

        // Получаем значения по ключам из файла и заполняем модель html-файла.
        model.setFio(propHandler.GetValueInString("FIO"));
        model.setDob(propHandler.GetValueInString("DOB"));
        model.setEmail(propHandler.GetValueInString("email"));
        model.setSkype(propHandler.GetValueInString("skype"));
        model.setAvatar(propHandler.GetValueInString("avatar"));
        model.setTarget(propHandler.GetValueInLinkedList("target"));
        model.setPhone(propHandler.GetValueInString("phone"));
        model.setExperiences(propHandler.GetValueInLinkedList("experiences"));
        model.setEducations(propHandler.GetValueInLinkedList("educations"));
        model.setAdditional_educations(propHandler.GetValueInLinkedList("additional_educations"));
        model.setSkills(propHandler.GetValueInLinkedList("skills"));
        model.setExamples_code(propHandler.GetValueInLinkedList("examples_code"));

        // Закрываем файл.
        if (!propHandler.Close()) {
            System.out.print("Не удалось закрыть файл properties по адресу '" + PATH_TO_PROPERTIES_FILE + "'");
        }

        // Создаем генератор html-файлов.
        GeneratorOfHTMLFile fileGenHTML = new GeneratorOfHTMLFile();

        // Создаем html-файл.
        if (!fileGenHTML.CreateFileHTML(model, PATH_TO_HTML_FILE)) {
            System.out.print("Не удалось записать данные в файл html по адресу '" + PATH_TO_HTML_FILE + "'");
        }

        System.out.print("Finish!");
    }
}
