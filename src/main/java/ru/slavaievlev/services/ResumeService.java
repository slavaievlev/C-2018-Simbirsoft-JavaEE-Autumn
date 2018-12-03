package ru.slavaievlev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.slavaievlev.entities.*;
import ru.slavaievlev.file_handlers.html.html_dto.ResumeDto;
import ru.slavaievlev.repositories.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Component
public class ResumeService {

    private EntityManager em = Persistence.createEntityManagerFactory("RESUME").createEntityManager();

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

    public void putSummary(int id, String nameField, int indexField, String valueField) {
        Summary summary = getSummary(id);
        switch(nameField.toLowerCase()) {
            case "fio": {
                summary.setFio(valueField);
                updateSummary(summary);
                break;
            }

            case "dob": {
                summary.setDob(valueField);
                updateSummary(summary);
                break;
            }

            case "email": {
                summary.setEmail(valueField);
                updateSummary(summary);
                break;
            }

            case "skype": {
                summary.setSkype(valueField);
                updateSummary(summary);
                break;
            }

            case "avatar": {
                summary.setAvatar(valueField);
                updateSummary(summary);
                break;
            }

            case "phone": {
                summary.setPhone(valueField);
                updateSummary(summary);
                break;
            }

            case "targets": {
                Targets target = summary.getTargets().get(indexField);
                target.setTarget(valueField);
                updateTargets(target);
                break;
            }

            case "additioneducations": {
                Additioneducations additioneducations = summary.getAdditionEducations().get(indexField);
                additioneducations.setAdditioneducations(valueField);
                updateAdditionEducations(additioneducations);
                break;
            }

            case "educations": {
                Educations educations = summary.getEducations().get(indexField);
                educations.setEducation(valueField);
                updateEducations(educations);
                break;
            }

            case "experiences": {
                Experiences experiences = summary.getExperiences().get(indexField);
                experiences.setExperience(valueField);
                updateExperiences(experiences);
                break;
            }
        }
    }

    private Summary addSummary(Summary summary){
        em.getTransaction().begin();
        Summary summaryFromDB = em.merge(summary);
        em.getTransaction().commit();
        return summaryFromDB;
    }

    private void deleteSummary(int id){
        em.getTransaction().begin();
        em.remove(getSummary(id));
        em.getTransaction().commit();
    }

    private void updateSummary(Summary summary){
        em.getTransaction().begin();
        em.merge(summary);
        em.getTransaction().commit();
    }

    private void updateTargets(Targets targets){
        em.getTransaction().begin();
        em.merge(targets);
        em.getTransaction().commit();
    }

    private void updateAdditionEducations(Additioneducations additioneducations){
        em.getTransaction().begin();
        em.merge(additioneducations);
        em.getTransaction().commit();
    }

    private void updateEducations(Educations educations){
        em.getTransaction().begin();
        em.merge(educations);
        em.getTransaction().commit();
    }

    private void updateExperiences(Experiences experiences){
        em.getTransaction().begin();
        em.merge(experiences);
        em.getTransaction().commit();
    }
}
