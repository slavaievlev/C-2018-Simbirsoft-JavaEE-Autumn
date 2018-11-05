// Интерфейс обработчика файлов.
public interface IFileHandler {
    boolean Open(String path);
    boolean Close();
}
