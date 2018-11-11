package ru.slavaievlev.file_handlers.properties;

import ru.slavaievlev.file_handlers.IFileHandler;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Properties;

// Класс, реализующий работу обработчика properties файлов.
public class PropertiesHandler implements IFileHandler, IPropertiesHandler {

    // Создаем модель properties файла.
    private PropertiesModel propertiesModel = new PropertiesModel();

    private FileInputStream fileInputStream = null;
    private Properties prop = null;

    // Создает пустой properties файл.
    public boolean CreateEmptyPropertiesFile(String path) {
        StringBuilder sProperties= new StringBuilder();

        // Создаем пустой шаблон properties файла.
        for(String s : propertiesModel.getFieldsList()) {
            sProperties.append(s);
        }

        // Создаем папку для хранения файла properties.
        String[] folders = path.split("/");
        for (int i = 0; i < folders.length - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(folders[j] + "/");
            }
            sb.append(folders[i]);

            File folder = new File(sb.toString());
            if (!folder.exists()) {
                folder.mkdir();
            }
        }

        // Создаем файл, содержащий код html-страницы.
        try {
            BufferedWriter sb = null;

            try {
                sb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
                sb.write(sProperties.toString());

            } catch (IOException e) {
                return false;
            } finally {
                if (sb != null) {
                    sb.close();
                }
            }

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    // Открывает файл properties.
    public boolean Open(String path) {

        if (path == null) {
            return false;
        }

        // Если файла не существует по указанному пути, то создаем файл.
        if (!new File(path).exists()) {
            if (!CreateEmptyPropertiesFile(path)) {
                return false;
            }
        }

        try {
            fileInputStream = new FileInputStream(path);
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (IOException e) {
            fileInputStream = null;
            prop = null;
            return false;
        }

        return true;
    }

    // Закрывает файл properties.
    public boolean Close() {
        try {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (IOException e) {
            fileInputStream = null;
            prop = null;
            return false;
        }

        fileInputStream = null;
        prop = null;
        return true;
    }

    // Разбивает пришедшую строку на части, если строка это подразумевает.
    private String[] Split(String s) {
        // Разбиваем строку на части.
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

    // Получает значения по указанному ключу из файла properties.
    public String GetValueInString(String key) {
        if (fileInputStream == null) {
            return null;
        }

        String result = null;
        try {
            // Ищем значение по ключу в файле properties.
            String notDecodedResult = prop.getProperty(key);

            // Если ключ не был найден и getProperty возвращает null, то выходим.
            if (notDecodedResult == null) {
                return null;
            }

            // Перекодируем и запишем найденное значение в строку.
            byte[] bytesArray = notDecodedResult.getBytes("ISO-8859-1");
            result = new String(bytesArray);

        } catch (UnsupportedEncodingException e) {
            return null;
        }

        return result;
    }

    // Получает значения по указанному ключу из файла properties.
    public LinkedList<String> GetValueInLinkedList(String key) {
        if (fileInputStream == null) {
            return null;
        }

        String preResult = null;
        LinkedList<String> result = new LinkedList<String>();
        try {
            // Ищем значение по ключу в файле properties.
            String notDecodedResult = prop.getProperty(key);

            // Если ключ не был найден и getProperty возвращает null, то выходим.
            if (notDecodedResult == null) {
                return null;
            }

            // Перекодируем и запишем найденное значение в строку.
            byte[] bytesArray = notDecodedResult.getBytes("ISO-8859-1");
            preResult = new String(bytesArray);

            // Разбиваем строку на части, если значение состоит из нескольких частей.
            String[] sArray = Split(preResult);

            // Записываем полученные строки в список.
            result.addAll(Arrays.asList(sArray));

        } catch (UnsupportedEncodingException e) {
            return null;
        }

        return result;
    }
}