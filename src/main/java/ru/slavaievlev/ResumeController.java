package ru.slavaievlev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;

@Controller
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(@Qualifier ("resumeService") ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @RequestMapping(value = "/greeting")
    public String greeting(Model model) {
        ResumeDto resumeDto = resumeService.getResume();

        model.addAttribute("fio", resumeDto.getFio());
        model.addAttribute("dob", resumeDto.getDob());
        model.addAttribute("email", resumeDto.getEmail());
        model.addAttribute("skype", resumeDto.getSkype());
        model.addAttribute("avatar", resumeDto.getAvatar());
        model.addAttribute("target", resumeDto.getTarget());
        model.addAttribute("phone", resumeDto.getPhone());
        model.addAttribute("experiences", resumeDto.getExperiences());
        model.addAttribute("educations", resumeDto.getEducations());
        model.addAttribute("additional_educations", resumeDto.getAdditional_educations());
        model.addAttribute("skills", resumeDto.getSkills());
        model.addAttribute("examples_code", resumeDto.getExamples_code());

        return "resume";
    }

}