package ru.slavaievlev.file_handlers.properties;

import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;

import java.util.Set;

// Объект, начинающий чтение property файлов по определенным ключам и записывающий полученные
// данные в объект html модели (HTMLModel).
public class StarterReadingProperty {

    private PropertiesHandler propertiesHandler;
    private String pathToPropertyFiles;
    private String nameOfPropertyFile;
    private ResumeDto model;

    public StarterReadingProperty(PropertiesHandler propertiesHandler, String pathToPropertyFiles,
                                  String nameOfPropertyFile, ResumeDto model) {
        this.propertiesHandler = propertiesHandler;
        this.pathToPropertyFiles = pathToPropertyFiles;
        this.nameOfPropertyFile = nameOfPropertyFile;
        this.model = model;
    }

    public void start() {
        // Открывам файл properties в обработчике.
        if (!propertiesHandler.open(pathToPropertyFiles + nameOfPropertyFile)) {
            System.out.println("Не удалось открыть файл properties по адресу '" +
                    pathToPropertyFiles + nameOfPropertyFile + "'");
            return;
        }

        // Получаем набор ключей из properties файла.
        Set keys = propertiesHandler.getKeys();

        // Проходимся по всем ключам properties файла, получаем значения и заполняем html модель.
        for(Object key : keys) {
            String sKey = (String)key;

            switch (sKey) {

                case "FIO": {
                    model.setFio(propertiesHandler.getValueInString(sKey));
                    break;
                }

                case "DOB": {
                    model.setDob(propertiesHandler.getValueInString(sKey));
                    break;
                }

                case "email": {
                    model.setEmail(propertiesHandler.getValueInString(sKey));
                    break;
                }

                case "skype": {
                    model.setSkype(propertiesHandler.getValueInString(sKey));
                    break;
                }

                case "avatar": {
                    model.setAvatar(propertiesHandler.getValueInString("avatar"));
                    break;
                }

                case "target": {
                    model.setTarget(propertiesHandler.getValueInLinkedList("target"));
                    break;
                }

                case "phone": {
                    model.setPhone(propertiesHandler.getValueInString("phone"));
                    break;
                }

                case "experiences": {
                    model.setExperiences(propertiesHandler.getValueInLinkedList("experiences"));
                    break;
                }

                case "educations": {
                    model.setEducations(propertiesHandler.getValueInLinkedList("educations"));
                    break;
                }

                case "additional_educations": {
                    model.setAdditional_educations(propertiesHandler.getValueInLinkedList("additional_educations"));
                    break;
                }

                case "skills": {
                    model.setSkills(propertiesHandler.getValueInHashMap("skills"));
                    break;
                }

                case "examples_code": {
                    model.setExamples_code(propertiesHandler.getValueInLinkedList("examples_code"));
                    break;
                }

            }
        }

        // Закрываем файл.
        if (!propertiesHandler.close()) {
            System.out.println("Не удалось закрыть файл properties по адресу '" +
                    pathToPropertyFiles + nameOfPropertyFile + "'");
        }
    }
}
