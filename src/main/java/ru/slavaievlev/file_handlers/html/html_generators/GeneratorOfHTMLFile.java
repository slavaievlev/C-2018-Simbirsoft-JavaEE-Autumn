package ru.slavaievlev.file_handlers.html.html_generators;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.slavaievlev.file_handlers.HandlerOfNullString;
import ru.slavaievlev.file_handlers.html.html_dto.ResumeDto;
import ru.slavaievlev.file_handlers.html.html_objects.*;
import ru.slavaievlev.services.PropertyService;

// Класс, генерирующий html-файлы.
@Component
public class GeneratorOfHTMLFile implements IGeneratorOfHTMLFile {

    // Сервис, занимающийся управлением работой обработчиков property файлов.
    private PropertyService propertyService;

    private ResumeDto model;

    @Value("${PATH_TO_HTML_FILE}")
    private String pathToHTMLFile;

    @Autowired
    public GeneratorOfHTMLFile(@Qualifier ("propertyService") PropertyService propertyService) {
        this.propertyService = propertyService;
        this.model = new ResumeDto();
    }

    public boolean CreateFileHTML() throws InterruptedException {

        propertyService.getData();

        // Создаем обработчик null строк.
        HandlerOfNullString nullHandler = new HandlerOfNullString();

        // Создаем строку, которая будет принимать html-код.
        StringBuilder sbHtml= new StringBuilder();

        // Создаем необходимые для html-документа объекты.
        P p = new P();
        B b = new B();
        PEnd pEnd = new PEnd();
        BEnd bEnd = new BEnd();
        Ul ul = new Ul();
        UlEnd ulEnd = new UlEnd();
        Li li = new Li();
        LiEnd liEnd = new LiEnd();
        Image image = new Image(nullHandler.fromNullToEmptyString(model.getAvatar()), 340);
        Tab tab = new Tab();

        // Создаем список, который будет формировать html-код.
        LinkedList<HTMLObject> listOfHtmlObjects = new LinkedList<HTMLObject>();

        // Вносим данные в список.
        listOfHtmlObjects.add(new Doctype());
        listOfHtmlObjects.add(new Html());
        listOfHtmlObjects.add(new Head());
        listOfHtmlObjects.add(new MetaCharset("utf-8"));
        listOfHtmlObjects.add(new Title("Резюме"));
        listOfHtmlObjects.add(new HeadEnd());
        listOfHtmlObjects.add(new Body());
        listOfHtmlObjects.add(p);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("РЕЗЮМЕ. На должность Java-стажер."));
        listOfHtmlObjects.add(bEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("ФИО: "));
        listOfHtmlObjects.add(new Text(nullHandler.fromNullToEmptyString(model.getFio())));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Дата рождения: "));
        listOfHtmlObjects.add(new Text(nullHandler.fromNullToEmptyString(model.getDob())));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Номер телефона: "));
        listOfHtmlObjects.add(new Text(nullHandler.fromNullToEmptyString(model.getPhone())));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Email: "));
        listOfHtmlObjects.add(new Text(nullHandler.fromNullToEmptyString(model.getEmail())));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(new Text("Skype: "));
        listOfHtmlObjects.add(new Text(nullHandler.fromNullToEmptyString(model.getSkype())));
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Цель: "));
        listOfHtmlObjects.add(bEnd);
        if (model.getTarget() != null) {
            for(String s : model.getTarget()) {
                listOfHtmlObjects.add(li);
                listOfHtmlObjects.add(new Text(s));
                listOfHtmlObjects.add(liEnd);
            }
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Опыт работы: "));
        listOfHtmlObjects.add(bEnd);
        if (model.getExperiences() != null) {
            for(String s : model.getExperiences()) {
                listOfHtmlObjects.add(li);
                listOfHtmlObjects.add(new Text(s));
                listOfHtmlObjects.add(liEnd);
            }
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Образование: "));
        listOfHtmlObjects.add(bEnd);
        if (model.getEducations() != null) {
            for(String s : model.getEducations()) {
                listOfHtmlObjects.add(li);
                listOfHtmlObjects.add(new Text(s));
                listOfHtmlObjects.add(liEnd);
            }
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Дополнительное образование: "));
        listOfHtmlObjects.add(bEnd);
        if (model.getAdditional_educations() != null) {
            for(String s : model.getAdditional_educations()) {
                listOfHtmlObjects.add(li);
                listOfHtmlObjects.add(new Text(s));
                listOfHtmlObjects.add(liEnd);
            }
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Навыки: "));
        listOfHtmlObjects.add(bEnd);
        if (model.getSkills() != null) {
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
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(b);
        listOfHtmlObjects.add(new Text("Примеры кода: "));
        listOfHtmlObjects.add(bEnd);
        if (model.getExamples_code() != null) {
            for(String s : model.getExamples_code()) {
                listOfHtmlObjects.add(li);
                listOfHtmlObjects.add(new Link(s, s));
                listOfHtmlObjects.add(liEnd);
            }
        }
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(ul);
        listOfHtmlObjects.add(image);
        listOfHtmlObjects.add(ulEnd);

        listOfHtmlObjects.add(pEnd);
        listOfHtmlObjects.add(new BodyEnd());
        listOfHtmlObjects.add(new HtmlEnd());

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

        try {
            BufferedWriter bwHtml = null;

            try {
                bwHtml = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathToHTMLFile),
                        "UTF-8"));
                bwHtml.write(sbHtml.toString());

            } catch (IOException e) {
                return false;
            } finally {
                if (bwHtml != null) {
                    bwHtml.close();
                }
            }

        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
