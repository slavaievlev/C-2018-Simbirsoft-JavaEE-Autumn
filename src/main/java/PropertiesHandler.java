import java.io.*;
import java.util.Properties;

public class PropertiesHandler {

    private FileInputStream fileInputStream = null;
    private Properties prop = null;

    // Создает пустой properties файл.
    private boolean CreateEmptyPropertiesFile(String path) {
        StringBuilder sProperties= new StringBuilder();

        // Создаем шаблон пустого properties файла.
        sProperties.append(
                "FIO=\n" +
                "DOB=\n" +
                "phone=\n" +
                "email=\n" +
                "skype=\n" +
                "avatar=\n" +
                "target=\n" +
                "experiences=\n" +
                "educations=\n" +
                "additional_educations=\n" +
                "skills=\n" +
                "examples_code="
        );

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

    // Получает значения по указанному ключу из файла properties.
    public String GetValue(String key) {
        if (fileInputStream == null) {
            return null;
        }

        String result = null;
        try {
            // Ищем значение по ключу в файле properties.
            String notDecodedResult = prop.getProperty(key);

            // Если ключ не был найден и getProperty везвращает null, то выходим.
            if (notDecodedResult == null) {
                return null;
            }

            // Иначе перекодируем и записываем найденное значение в строку.
            byte[] bytesArray = notDecodedResult.getBytes("ISO-8859-1");
            result = new String(bytesArray);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }
}