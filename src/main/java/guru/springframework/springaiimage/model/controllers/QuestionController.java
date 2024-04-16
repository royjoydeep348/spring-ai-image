package guru.springframework.springaiimage.model.controllers;

import guru.springframework.springaiimage.model.Question;
import guru.springframework.springaiimage.model.services.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jt, Spring Framework Guru.
 */
@RequiredArgsConstructor
@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    @PostMapping("/image")
    public Object getImage(@RequestBody Question question) {
        return openAIService.getImage(question);
    }

}
