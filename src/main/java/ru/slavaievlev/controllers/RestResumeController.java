package ru.slavaievlev.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.slavaievlev.controllers.request_models.RequestModelForPutSummary;
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

    @ApiOperation(value = "Загрузить резюме")
    @GetMapping("{id}")
    public Summary getSummary(@PathVariable int id) {
        return resumeService.getSummary(id);
    }

    @ApiOperation(value = "Изменить резюме")
    @PutMapping(path = "{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Summary putSummary(@PathVariable int id, @RequestBody RequestModelForPutSummary requestModelForPutSummary) {
        resumeService.putSummary(id, requestModelForPutSummary.getNameField(), requestModelForPutSummary.getIndexField(),
                requestModelForPutSummary.getValueField());
        return getSummary(id);
    }
}
