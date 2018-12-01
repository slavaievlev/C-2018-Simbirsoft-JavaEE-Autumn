package ru.slavaievlev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.slavaievlev.entities.*;
import ru.slavaievlev.file_handlers.html.html_dto.ResumeDto;
import ru.slavaievlev.repositories.*;

import java.util.List;

@Component
public class ResumeService {

    private PropertyService propertyService;

    @Autowired
    private SummaryRepository summaryRepository;

    @Autowired
    private ExamplesCodeRepository examplesCodeRepository;

    public ResumeService(@Qualifier("propertyService") PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    public ResumeDto getResume() throws InterruptedException {
        return propertyService.getData();
    }

    public List<Summary> getAllSummary() {
        return summaryRepository.findAll();
    }

    public Summary getSummary(int id) {
        return summaryRepository.getSummaryById(id);
    }
}
