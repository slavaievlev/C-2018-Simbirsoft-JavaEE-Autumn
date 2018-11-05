import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Класс, реализующий работы генератора html файлов.
public class GeneratorOfHTMLFile implements IGeneratorOfHTMLFile {
    public boolean CreateFileHTML(HTMLModel model, String path) {
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
                        "         </b>\n");



        String fio = model.getFio();
        if (fio == null) {
            fio = "";
        }
        sHtml.append("         <ul>ФИО: " + fio + "</ul>\n");

        String dob = model.getDob();
        if (dob == null) {
            dob = "";
        }
        sHtml.append("         <ul>Дата рождения: " + dob + "</ul>\n");

        String phone = model.getPhone();
        if (phone == null) {
            phone = "";
        }
        sHtml.append("         <ul>Телефон: " + phone + "</ul>\n");

        String email = model.getEmail();
        if (email == null) {
            email = "";
        }
        sHtml.append("         <ul>email: " + email + "</ul>\n");

        String skype = model.getSkype();
        if (skype == null) {
            skype = "";
        }
        sHtml.append("         <ul>skype: " + skype + "</ul>\n");

        String target = model.getTarget();
        if (target == null) {
            target = "";
        }
        sHtml.append("         <ul><b>Цель: </b>" + target + "</ul>\n");

        String experiences = model.getExperiences();
        if (experiences == null) {
            experiences = "";
        }
        sHtml.append("         <ul><b>Опыт работы: </b>" + experiences + "</ul>\n");

        String educations = model.getEducations();
        if (educations == null) {
            educations = "";
        }
        sHtml.append("         <ul><b>Образование: </b>" + educations + "</ul>\n");

        String additional_educations = model.getAdditional_educations();
        if (additional_educations == null) {
            additional_educations = "";
        }
        sHtml.append("         <ul><b>Дополнительное образование: </b>" + additional_educations + "</ul>\n");

        String skills = model.getSkills();
        if (skills == null) {
            skills = "";
        }
        sHtml.append("         <ul><b>Навыки: </b>" + skills + "</ul>\n");

        String examples_code = model.getExamples_code();
        if (examples_code == null) {
            examples_code = "";
        }
        sHtml.append("         <ul><b>Примеры моего кода: </b>" + examples_code + "</ul>\n");

        String avatar = model.getAvatar();
        if (avatar == null) {
            avatar = "";
        }
        sHtml.append("         <ul><image src=\"" + avatar + "\"");



        sHtml.append(   " width=\"340\"></ul>\n" +
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
