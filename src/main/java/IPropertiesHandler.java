// Интерфейс обработчика properties-файлов.
public interface IPropertiesHandler {
    boolean CreateEmptyPropertiesFile(String path);
    String GetValue(String key);
}
