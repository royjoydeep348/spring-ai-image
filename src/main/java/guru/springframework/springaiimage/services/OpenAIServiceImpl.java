package guru.springframework.springaiimage.services;

import guru.springframework.springaiimage.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 * Created by jt, Spring Framework Guru.
 */
@RequiredArgsConstructor
@Service
public class OpenAIServiceImpl implements OpenAIService {

    final ImageClient imageClient;


    /**
     * Retrieves an image based on the provided question.
     *
     * @param question The question object containing the query details.
     * @return A byte array representing the image data.
     */
    @Override
    public byte[] getImage(Question question) {

        // Set image options
        var options = ImageOptionsBuilder.builder()
                .withHeight(1024)
                .withWidth(1024)
                .withModel("image-alpha-001")
                .withResponseFormat("b64_json")
                .build();

        // Create an image prompt
        ImagePrompt imagePrompt = new ImagePrompt(question.question(), options);

        // Call the image client to get the image response
        var imageResponse = imageClient.call(imagePrompt);

        // Decode and return the image data
        return Base64.getDecoder().decode(imageResponse.getResult().getOutput().getB64Json());
    }

}

















