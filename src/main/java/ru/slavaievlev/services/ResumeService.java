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
    private TargetsRepository targetsRepository;

    @Autowired
    private ExperiencesRepository experiencesRepository;

    @Autowired
    private EducationsRepository educationsRepository;

    @Autowired
    private AdditionEducationsRepository additionEducationsRepository;

    @Autowired
    private SkillsRepository skillsRepository;

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

    public List<Targets> getTargets(int summaryid) {
        return targetsRepository.findBySummaryid(summaryid);
    }

    public List<Experiences> getExperiences(int summaryid) {
        return experiencesRepository.findBySummaryid(summaryid);
    }

    public List<Educations> getEducations(int summaryid) {
        return educationsRepository.findBySummaryid(summaryid);
    }

    public List<Additioneducations> getAdditionEducations(int summaryid) {
        return additionEducationsRepository.findBySummaryid(summaryid);
    }

    public List<Skills> getSkills(int summaryid) {
        return skillsRepository.findBySummaryid(summaryid);
    }

    public List<Examplescode> getExamplesCode(int summaryid) {
        return examplesCodeRepository.findBySummaryid(summaryid);
    }
}
