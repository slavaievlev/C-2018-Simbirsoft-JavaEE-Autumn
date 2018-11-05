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
        model.setFio(propHandler.GetValue("FIO"));
        model.setDob(propHandler.GetValue("DOB"));
        model.setEmail(propHandler.GetValue("email"));
        model.setSkype(propHandler.GetValue("skype"));
        model.setAvatar(propHandler.GetValue("avatar"));
        model.setTarget(propHandler.GetValue("target"));
        model.setPhone(propHandler.GetValue("phone"));
        model.setExperiences(propHandler.GetValue("experiences"));
        model.setEducations(propHandler.GetValue("educations"));
        model.setAdditional_educations(propHandler.GetValue("additional_educations"));
        model.setSkills(propHandler.GetValue("skills"));
        model.setExamples_code(propHandler.GetValue("examples_code"));

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
