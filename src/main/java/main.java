public class main {
    // Путь до файла properties.
    private static final String PATH_TO_PROPERTIES_FILE = "resources/settings.properties";
    // Путь до html-файла, который будет генерироваться генератором html-шаблонов.
    private static final String PATH_TO_HTML_FILE = "resources/index.html";

    public static void main(String[] args) {
        // Создаем обработчик properties-файлов.
        PropertiesHandler propHandler = new PropertiesHandler();

        // Открывам файл properties в обработчике.
        if (!propHandler.Open(PATH_TO_PROPERTIES_FILE)) {
            System.out.print("Не удалось открыть файл properties по адресу '" + PATH_TO_PROPERTIES_FILE + "'");
            return;
        }

        // Получаем значения по ключам из файла.
        String FIO = propHandler.Get("FIO");
        String DOB = propHandler.Get("DOB");
        String Email = propHandler.Get("email");
        String Skype = propHandler.Get("skype");
        String Avatar = propHandler.Get("avatar");
        String Target = propHandler.Get("target");
        String phone = propHandler.Get("phone");
        String experiences = propHandler.Get("experiences");
        String educations = propHandler.Get("educations");
        String additional_educations = propHandler.Get("additional_educations");
        String skills = propHandler.Get("skills");
        String examples_code = propHandler.Get("examples_code");

        // Закрываем файл.
        if (!propHandler.Close()) {
            System.out.print("Не удалось закрыть файл properties по адресу '" + PATH_TO_PROPERTIES_FILE + "'");
        }

        // Проверяем полученные строки на null.
        if (FIO == null) {
            FIO = "-";
        }
        if (DOB == null) {
            DOB = "-";
        }
        if (Email == null) {
            Email = "-";
        }
        if (Skype == null) {
            Skype = "-";
        }
        if (Avatar == null) {
            Avatar = "-";
        }
        if (Target == null) {
            Target = "-";
        }

        // Создаем генератор html-файлов.
        FileGeneratorOfHTML fileGenHTML = new FileGeneratorOfHTML();

        // Создаем html-файл.
        if (!fileGenHTML.CreateFileHTML(FIO, DOB, Email, Skype, Avatar, Target, phone, experiences,
                educations, additional_educations, skills, examples_code, PATH_TO_HTML_FILE)) {
            System.out.print("Не удалось записать данные в файл html по адресу '" + PATH_TO_HTML_FILE + "'");
        }

        System.out.print("Finish!");
    }
}
