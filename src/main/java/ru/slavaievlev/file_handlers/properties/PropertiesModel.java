package ru.slavaievlev.file_handlers.properties;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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

    public List<String> getFieldsList() {
        return Arrays.asList(FIO, DOB, PHONE, EMAIL, SKYPE, AVATAR, TARGET,
                EXPERIENCES, EDUCATIONS, ADDITIONAL_EDUCATIONS, SKILLS, EXAMPLES_CODE);
    }
}
