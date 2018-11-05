import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GeneratorOfHTMLFile {
    public boolean CreateFileHTML(String fio, String dob, String email, String skype,
            String avatar, String target, String phone, String experiences,
            String educations, String additional_educations, String skills, String examples_code, String path) {
        StringBuilder sHtml= new StringBuilder();

        // Создаем html-код страницы.
        sHtml.append(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "   <head>\n" +
                        "      <meta charset=\"utf-8\" />\n" +
                        "      <title>Резюме</title>\n" +
                        "   </head>\n" +
                        "   <body>\n" +
                        "      <p>\n" +
                        "         <b>\n" +
                        "            РЕЗЮМЕ. На должность Java-стажер.\n" +
                        "         </b>\n" +
                        "         <ul>ФИО: " + fio + "</ul>\n" +
                        "         <ul>Дата рождения: " + dob + "</ul>\n" +
                        "         <ul>email: " + phone + "</ul>\n" +
                        "         <ul>email: " + email + "</ul>\n" +
                        "         <ul>skype: " + skype + "</ul>\n" +
                        "         <ul><b>Цель: </b>" + target + "</ul>\n" +
                        "         <ul><b>Опыт работы: </b>" + experiences + "</ul>\n" +
                        "         <ul><b>Образование: </b>" + educations + "</ul>\n" +
                        "         <ul><b>Дополнительное образование: </b>" + additional_educations + "</ul>\n" +
                        "         <ul><b>Навыки: </b>" + skills + "</ul>\n" +
                        "         <ul><b>Примеры моего кода: </b>" + examples_code + "</ul>\n" +
                        "         <ul><image src=\"" + avatar + "\"" +
                        " width=\"340\"></ul>\n" +
                        "      </p>\n" +
                        "   </body>\n" +
                        "</html>"
        );

        // Создаем файл, содержащий код html-страницы.
        try {
            BufferedWriter sb = null;

            try {
                sb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
                sb.write(sHtml.toString());

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
}
