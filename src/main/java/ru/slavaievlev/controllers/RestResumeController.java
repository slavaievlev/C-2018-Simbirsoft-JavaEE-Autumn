package ru.slavaievlev.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.slavaievlev.entities.Summary;
import ru.slavaievlev.services.ResumeService;

@RestController
@RequestMapping("/resume")
public class RestResumeController {

    private ResumeService resumeService;

    @Autowired
    public RestResumeController(@Qualifier("resumeService") ResumeService resumeService) {
        this.resumeService = resumeService;
    }

//    @ApiOperation(value = "Добавить резюме")
//    @PostMapping
//    public Summary saveSummary(@RequestBody Summary summary) {
//
//    }

    @ApiOperation(value = "Загрузить резюме")
    @GetMapping("{id}")
    public Summary getSummary(@PathVariable int id) {
        return resumeService.getSummary(id);
    }
}
