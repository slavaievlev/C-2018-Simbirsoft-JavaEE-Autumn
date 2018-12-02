package ru.slavaievlev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.slavaievlev.entities.*;
import ru.slavaievlev.services.ResumeService;
import ru.slavaievlev.file_handlers.html.html_dto.ResumeDto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Controller
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(@Qualifier ("resumeService") ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping(value = "/greeting/prop")
    public String greeting(Model model) throws InterruptedException {
        ResumeDto resumeDto = resumeService.getResume();

        model.addAttribute("fio", resumeDto.getFio());
        model.addAttribute("dob", resumeDto.getDob());
        model.addAttribute("email", resumeDto.getEmail());
        model.addAttribute("skype", resumeDto.getSkype());
        model.addAttribute("avatar", resumeDto.getAvatar());
        model.addAttribute("targets", resumeDto.getTarget());
        model.addAttribute("phone", resumeDto.getPhone());
        model.addAttribute("experiences", resumeDto.getExperiences());
        model.addAttribute("educations", resumeDto.getEducations());
        model.addAttribute("additional_educations", resumeDto.getAdditional_educations());
        model.addAttribute("skills", resumeDto.getSkills());
        model.addAttribute("examples_code", resumeDto.getExamples_code());

        return "resume";
    }

    @RequestMapping(value = "/greeting/db")
    public String getAll(@RequestParam(value="id") int id, Model model) {
        Summary summary = resumeService.getSummary(id);

        model.addAttribute("fio", summary.getFio());
        model.addAttribute("dob", summary.getDob());
        model.addAttribute("email", summary.getEmail());
        model.addAttribute("skype", summary.getSkype());
        model.addAttribute("avatar", summary.getAvatar());
        model.addAttribute("phone", summary.getPhone());
        model.addAttribute("targets", summary.getTargets());
        model.addAttribute("experiences", summary.getExperiences());
        model.addAttribute("educations", summary.getEducations());
        model.addAttribute("additionalEducations", summary.getAdditionEducations());
        model.addAttribute("skills", summary.getSkills());
        model.addAttribute("examplesCode", summary.getExamplesCodes());

        return "resumeForDB";
    }
}