package ru.slavaievlev.file_handlers.html.html_generators;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

import ru.slavaievlev.file_handlers.html.html_objects.*;

// Класс, реализующий работу генератора html файлов.
public class GeneratorOfHTMLFile implements IGeneratorOfHTMLFile {

    public boolean CreateFileHTML(HTMLModel model, String path) {

        // Создаем строку, которая будет принимать html-код.
        StringBuilder sbHtml= new StringBuilder();

        // Создаем необходимые для html-документа объекты.
        Doctype doctype = new Doctype();
        Html html = new Html();
        HtmlEnd htmlEnd = new HtmlEnd();
        Head head = new Head();
        HeadEnd headEnd = new HeadEnd();
        MetaCharset metaCharset = new MetaCharset("utf-8");
        Title title = new Title("Резюме");
        Body body = new Body();
        BodyEnd bodyEnd = new BodyEnd();
        P p = new P();
        B b = new B();
        PEnd pEnd = new PEnd();
        BEnd bEnd = new BEnd();
        Ul ul = new Ul();
        UlEnd ulEnd = new UlEnd();
        Li li = new Li();
        LiEnd liEnd = new LiEnd();
        Image image = new Image(model.getAvatar(), 340);
        Tab tab = new Tab();

        // Создаем список, который будет формировать html-код.
        LinkedList<HTMLObject> listOfHtmlObjects = new LinkedList<HTMLObject>();

        // Вносим данные в список.
        listOfHtmlObjects.add(doctype);
        listOfHtmlObjects.add(html);
        listOfHtmlObjects.add(head);
        listOfHtmlObjects.add(metaCharset);
        listOfHtmlObjects.add(title);
        listOfHtmlObjects.add(headEnd);
        listOfHtmlObjects.add(body);
        listOfHtmlObjects.add(p);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("РЕЗЮМЕ. На должность Java-стажер."));
        listOfHtmlObjects.add(bEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("ФИО: "));
        listOfHtmlObjects.add(new Text(model.getFio()));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Дата рождения: "));
        listOfHtmlObjects.add(new Text(model.getDob()));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Номер телефона: "));
        listOfHtmlObjects.add(new Text(model.getPhone()));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Email: "));
        listOfHtmlObjects.add(new Text(model.getEmail()));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Skype: "));
        listOfHtmlObjects.add(new Text(model.getSkype()));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Цель: "));
        listOfHtmlObjects.add(bEnd);
        for(String s : model.getTarget()) {
            listOfHtmlObjects.add(li);
            listOfHtmlObjects.add(new Text(s));
            listOfHtmlObjects.add(liEnd);
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Опыт работы: "));
        listOfHtmlObjects.add(bEnd);
        for(String s : model.getExperiences()) {
            listOfHtmlObjects.add(li);
            listOfHtmlObjects.add(new Text(s));
            listOfHtmlObjects.add(liEnd);
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Образование: "));
        listOfHtmlObjects.add(bEnd);
        for(String s : model.getEducations()) {
            listOfHtmlObjects.add(li);
            listOfHtmlObjects.add(new Text(s));
            listOfHtmlObjects.add(liEnd);
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Дополнительное образование: "));
        listOfHtmlObjects.add(bEnd);
        for(String s : model.getAdditional_educations()) {
            listOfHtmlObjects.add(li);
            listOfHtmlObjects.add(new Text(s));
            listOfHtmlObjects.add(liEnd);
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Навыки: "));
        listOfHtmlObjects.add(bEnd);
        LinkedHashMap<String, Integer> hashMap = model.getSkills();
        Set<String> keys = hashMap.keySet();
        for(String s : keys) {
            listOfHtmlObjects.add(li);
            int value;
            if ((value = hashMap.get(s)) != 0) {
                listOfHtmlObjects.add(new Text(s + " (" + value + " мес.)"));
            } else {
                listOfHtmlObjects.add(new Text(s));
            }
            listOfHtmlObjects.add(liEnd);
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Примеры кода: "));
        listOfHtmlObjects.add(bEnd);
        for(String s : model.getExamples_code()) {
            listOfHtmlObjects.add(li);
            listOfHtmlObjects.add(new Link(s, s));
            listOfHtmlObjects.add(liEnd);
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(image);
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(pEnd);
        listOfHtmlObjects.add(bodyEnd);
        listOfHtmlObjects.add(htmlEnd);

        // Собираем код в строке.
        int numberTabs = 0;                 // Количество отступов в строке перед кодом.
        boolean isAddedLineFeed = false;    // Нужно ли вставлять табы? (нужно тогда, когда вставлен перенос строки)
        boolean isAddDopTab = false;        // Увеличить ли отступ на следующей итерации?
        for (HTMLObject obj : listOfHtmlObjects) {
            if (isAddDopTab) {
                numberTabs++;
                isAddDopTab = false;
            }

            // Если текущий объект открывает блок кода, то увеличиваем отступ на следующей итерации.
            if (obj.isBeginBlock()) {
                isAddDopTab = true;
            }

            // Если текущий объект закрывает блок кода, то уменьшаем отступ.
            if (obj.isEndBlock()) {
                numberTabs--;
            }

            if (isAddedLineFeed) {
                // Вставляем табы (делаем отступ).
                if (numberTabs > 0) {
                    for (int i = 0; i < numberTabs; i++) {
                        sbHtml.append(tab.getTab());
                    }
                }
                isAddedLineFeed = false;
            }

            // Вставляем код.
            sbHtml.append(obj.getHtmlText());

            // Вставляем знак перехода на новую строку, если требуется.
            if (obj.isLineFeed()) {
                sbHtml.append("\n");
                isAddedLineFeed = true;
            }
        }

        // Создаем html-файл и вставляем в него html-код.
        try {
            BufferedWriter sb = null;

            try {
                sb = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
                sb.write(sbHtml.toString());

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
