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
        if (!propertiesHandler.Open(pathToPropertyFiles + nameOfPropertyFile)) {
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
                    model.setFio(propertiesHandler.GetValueInString(sKey));
                    break;
                }

                case "DOB": {
                    model.setDob(propertiesHandler.GetValueInString(sKey));
                    break;
                }

                case "email": {
                    model.setEmail(propertiesHandler.GetValueInString(sKey));
                    break;
                }

                case "skype": {
                    model.setSkype(propertiesHandler.GetValueInString(sKey));
                    break;
                }

                case "avatar": {
                    model.setAvatar(propertiesHandler.GetValueInString("avatar"));
                    break;
                }

                case "target": {
                    model.setTarget(propertiesHandler.GetValueInLinkedList("target"));
                    break;
                }

                case "phone": {
                    model.setPhone(propertiesHandler.GetValueInString("phone"));
                    break;
                }

                case "experiences": {
                    model.setExperiences(propertiesHandler.GetValueInLinkedList("experiences"));
                    break;
                }

                case "educations": {
                    model.setEducations(propertiesHandler.GetValueInLinkedList("educations"));
                    break;
                }

                case "additional_educations": {
                    model.setAdditional_educations(propertiesHandler.GetValueInLinkedList("additional_educations"));
                    break;
                }

                case "skills": {
                    model.setSkills(propertiesHandler.GetValueInHashMap("skills"));
                    break;
                }

                case "examples_code": {
                    model.setExamples_code(propertiesHandler.GetValueInLinkedList("examples_code"));
                    break;
                }

            }
        }

        // Закрываем файл.
        if (!propertiesHandler.Close()) {
            System.out.println("Не удалось закрыть файл properties по адресу '" +
                    pathToPropertyFiles + nameOfPropertyFile + "'");
        }
    }
}
