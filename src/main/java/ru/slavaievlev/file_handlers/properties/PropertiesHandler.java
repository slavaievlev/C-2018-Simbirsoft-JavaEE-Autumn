package ru.slavaievlev.file_handlers.properties;

import ru.slavaievlev.file_handlers.html.html_dto.ResumeDto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

// Класс, реализующий работу обработчика properties файлов.
public class PropertiesHandler implements IPropertiesHandler {

    private String path;
    private ResumeDto model;

    public PropertiesHandler(String path, ResumeDto model) {
        this.path = path;
        this.model = model;
    }

    // Получает набор данных из property файла.
    public boolean getData() {

        if (!new File(path).exists()) {
            if (!createEmptyPropertiesFile(path)) {
                return false;
            }
        }

        try (FileInputStream propertyStream = new FileInputStream(path)) {

            Properties property = new Properties();
            property.load(propertyStream);

            FillModel(property);

        } catch (FileNotFoundException e) {
            System.out.println("Property файл по адресу " + path + "не существует или заблокирован");
            return false;
        } catch (IOException e) {
            System.out.println("Не удалось открыть property файл по адресу " + path);
            return false;
        }

        return true;
    }

    // Заполняет модель.
    private void FillModel(Properties property) {

        for(Object key : property.keySet()) {

            switch ((String)key) {

                case "FIO": {
                    model.setFio(getValueInString(property, (String)key));
                    break;
                }

                case "DOB": {
                    model.setDob(getValueInString(property, (String)key));
                    break;
                }

                case "email": {
                    model.setEmail(getValueInString(property, (String)key));
                    break;
                }

                case "skype": {
                    model.setSkype(getValueInString(property, (String)key));
                    break;
                }

                case "avatar": {
                    model.setAvatar(getValueInString(property, (String)key));
                    break;
                }

                case "target": {
                    model.setTarget(getValueInLinkedList(property, (String)key));
                    break;
                }

                case "phone": {
                    model.setPhone(getValueInString(property, (String)key));
                    break;
                }

                case "experiences": {
                    model.setExperiences(getValueInLinkedList(property, (String)key));
                    break;
                }

                case "educations": {
                    model.setEducations(getValueInLinkedList(property, (String)key));
                    break;
                }

                case "additional_educations": {
                    model.setAdditional_educations(getValueInLinkedList(property, (String)key));
                    break;
                }

                case "skills": {
                    model.setSkills(getValueInHashMap(property, (String)key));
                    break;
                }

                case "examples_code": {
                    model.setExamples_code(getValueInLinkedList(property, (String)key));
                    break;
                }

            }
        }
    }

    // Создает пустой properties файл.
    public boolean createEmptyPropertiesFile(String path) {

        StringBuilder sProperties= new StringBuilder();
        for(String s : new PropertyModel().getFieldsList()) {
            sProperties.append(s);
        }

        try (BufferedWriter sb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))){
            sb.write(sProperties.toString());

        } catch (IOException e) {
            System.out.println("Не удалось открыть файл по пути: " + path);
            return false;
        }

        return true;
    }

    // Общий метод для получения строки из property.
    private String getValue(Properties property, String key) {

        String notDecodedResult = property.getProperty(key);
        if (notDecodedResult == null) {
            return null;
        }
        return new String(notDecodedResult.getBytes(StandardCharsets.ISO_8859_1));

    }

    private String getValueInString(Properties property, String key) {
        return getValue(property, key);
    }

    private LinkedList<String> getValueInLinkedList(Properties property, String key) {

        String preResult = getValue(property, key);
        if (preResult == null) {
            return null;
        }

        return new LinkedList<>(Arrays.asList(split(preResult)));
    }

    // Разбивает пришедшую строку на части.
    private String[] split(String s) {

        String[] sArray = s.split("\", ?\"");

        if (sArray.length > 1) {
            for (int i = 0; i < sArray.length; i++) {

                // Удаляем оставшиеся знаки '"' на концах бывшей строки.
                sArray[i] = sArray[i].replaceAll("^[\"]", "");
                sArray[i] = sArray[i].replaceAll("[\".*]$", "");

            }
        }

        return sArray;
    }

    // Делим полученные строки на ключи и значения (должны быть записаны в формате - ключ : "значение", ...)
    private LinkedHashMap<String, String> addKeyAndValue(String[] sArray) {

        String[][] keysValues = new String[sArray.length][2];

        int index = 0;
        for (String s : sArray) {
            // Разбиваем строку на ключ-значение.
            String[] sKeyAndValue = s.split(": \"");

            if (sKeyAndValue.length > 1) {
                // Удаляем оставшиеся справа знаки.
                sKeyAndValue[1] = sKeyAndValue[1].replaceAll("[\".*]$", "");

                keysValues[index][0] = sKeyAndValue[0];
                keysValues[index][1] = sKeyAndValue[1];
            } else {
                keysValues[index][0] = sKeyAndValue[0];
                keysValues[index][1] = null;
            }
            index++;
        }

        Arrays.sort(keysValues, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int x1 = Integer.parseInt(o1[1]);
                int x2;
                if (o2[1] == null) {
                    return 1;
                }
                x2 = Integer.parseInt(o2[1]);
                return Integer.compare(x2, x1);
            }
        });

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (String[] keyValue : keysValues) {
            result.put(keyValue[0], keyValue[1]);
        }
        return result;
    }

    private LinkedHashMap<String, String> getValueInHashMap(Properties property, String key) {

        String preResult = getValue(property, key);
        if (preResult == null) {
            return null;
        }

        String[] sArray = split(preResult);

        return addKeyAndValue(sArray);
    }
}