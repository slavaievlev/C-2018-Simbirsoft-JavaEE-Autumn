package ru.slavaievlev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;
import ru.slavaievlev.file_handlers.properties.PropertyService;

@Component
public class ResumeService {

    @Autowired
    PropertyService propertyService;

    public ResumeDto getResume() throws InterruptedException {
        return propertyService.getData();
    }
}
