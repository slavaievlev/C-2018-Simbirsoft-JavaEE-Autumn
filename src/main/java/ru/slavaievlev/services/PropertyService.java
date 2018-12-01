package ru.slavaievlev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.slavaievlev.file_handlers.html.html_dto.ResumeDto;
import ru.slavaievlev.file_handlers.properties.IPropertyReader;

@Component
public class PropertyService {

    // Объекты, которые могут в своем потоке читать данные из property-файлов.
    IPropertyReader propertyReaderOne;
    IPropertyReader propertyReaderTwo;

    // html-модель.
    private ResumeDto resumeDto;

    @Autowired
    public PropertyService(@Qualifier ("propertyReaderForPropertyOne") IPropertyReader propertyReaderOne,
                           @Qualifier ("propertyReaderForPropertyTwo") IPropertyReader propertyReaderTwo) {
        this.propertyReaderOne = propertyReaderOne;
        this.propertyReaderTwo = propertyReaderTwo;
        this.resumeDto = new ResumeDto();
    }

    public ResumeDto getData() throws InterruptedException{

        // Создаем потоки.
        Thread oneThread = new Thread(propertyReaderOne);
        Thread twoThread = new Thread(propertyReaderTwo);

        //Запускаем потоки.
        oneThread.start();
        twoThread.start();

        // Ждем выполнения обоих потоков.
        oneThread.join();
        twoThread.join();

        return this.resumeDto;
    }
}
