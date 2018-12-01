package ru.slavaievlev.file_handlers.properties;

import ru.slavaievlev.file_handlers.html.html_dto.ResumeDto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

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

    // Синхронно сортирует два входящих массива по значениям массива values и записывает в hashMap, который учитывает порядок
    // добавления элементов.
    private LinkedHashMap<String, Integer> sortToHashMap(String[] keys, int[] values) {

        // Сортируем по значениям.
        for (int i = 0; i < keys.length - 1; i++) {
            if (values[i + 1] > values[i]) {
                int intX = values[i];
                String sX = keys[i];

                values[i] = values[i + 1];
                keys[i] = keys[i + 1];

                values[i + 1] = intX;
                keys[i + 1] = sX;
                i -= 2;
            }
        }

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            result.put(keys[i], values[i]);
        }
        return result;
    }

    // Делим полученные строки на ключи и значения (должны быть записаны в формате - ключ : "значение", ...)
    private LinkedHashMap<String, Integer> addKeyAndValue(String[] sArray) {

        // Создаем два массива в целях реализации сортировки по значениям.
        String[] keys = new String[sArray.length];
        int[] values = new int[sArray.length];

        // Идем по всем значениям одного ключа из property.
        for (int i = 0; i < sArray.length; i++) {
            // Пытаемся Разбить текущую строку на ключ и значение.
            String[] sKeyAndValue = sArray[i].split(": \"");

            // Если получилось разбить строку, то удаляем с правого конца знак " и
            // записываем ключ и значение в два массива для последующей синхронной сортировки.
            if (sKeyAndValue.length > 1) {
                // Удаляем оставшиеся справа знаки.
                sKeyAndValue[1] = sKeyAndValue[1].replaceAll("[\".*]$", "");

                // Записываем найденные значения.
                keys[i] = sKeyAndValue[0];
                values[i] = Integer.parseInt(sKeyAndValue[1]);
            } else {
                // Записываем значение = 0, если строку разделить не удалось.
                keys[i] = sKeyAndValue[0];
                values[i] = 0;
            }
        }

        // Сортируем синхронно оба массива по значениям из второго массива (values).
        return sortToHashMap(keys, values);
    }

    private LinkedHashMap<String, Integer> getValueInHashMap(Properties property, String key) {

        String preResult = getValue(property, key);
        if (preResult == null) {
            return null;
        }

        String[] sArray = split(preResult);

        return addKeyAndValue(sArray);
    }
}