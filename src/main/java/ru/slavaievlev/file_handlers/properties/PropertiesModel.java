package ru.slavaievlev.file_handlers.properties;

import java.util.LinkedList;

// Модель properties-файла.
public class PropertiesModel {

    private static final String FIO = "FIO=\n";
    private static final String DOB = "DOB=\n";
    private static final String PHONE = "phone=\n";
    private static final String EMAIL = "email=\n";
    private static final String SKYPE = "skype=\n";
    private static final String AVATAR = "avatar=\n";
    private static final String TARGET = "target=\n";
    private static final String EXPERIENCES = "experiences=\n";
    private static final String EDUCATIONS = "educations=\n";
    private static final String ADDITIONAL_EDUCATIONS = "additional_educations=\n";
    private static final String SKILLS = "skills=\n";
    private static final String EXAMPLES_CODE = "examples_code=\n";

    private LinkedList<String> fieldsList = new LinkedList<String>();

    public PropertiesModel() {
        fieldsList.add(FIO);
        fieldsList.add(DOB);
        fieldsList.add(PHONE);
        fieldsList.add(EMAIL);
        fieldsList.add(SKYPE);
        fieldsList.add(AVATAR);
        fieldsList.add(TARGET);
        fieldsList.add(EXPERIENCES);
        fieldsList.add(EDUCATIONS);
        fieldsList.add(ADDITIONAL_EDUCATIONS);
        fieldsList.add(SKILLS);
        fieldsList.add(EXAMPLES_CODE);
    }

    public LinkedList<String> getFieldsList() {
        return fieldsList;
    }
}
