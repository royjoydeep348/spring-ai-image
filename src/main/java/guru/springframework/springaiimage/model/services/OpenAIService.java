package guru.springframework.springaiimage.model.services;


import guru.springframework.springaiimage.model.Question;


/**
 * Created by jt, Spring Framework Guru.
 */
public interface OpenAIService {

    Object getImage(Question question);
}
