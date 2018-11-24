package ru.slavaievlev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.slavaievlev.file_handlers.html.html_generators.ResumeDto;

@Component
public class ResumeService {

    private ResumeDto resumeDto;

    @Autowired
    public ResumeService(@Qualifier ("resumeDto") ResumeDto resumeDto) {
        this.resumeDto = resumeDto;
    }

    public ResumeDto getResume() {
        return resumeDto;
    }
}
