package com.pelican.app.client.fallback;

import com.pelican.app.client.EstoniaClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by cetin on 4/19/2019.
 */
@Component
public class EstoniaFallbackService implements EstoniaClient {

    @Override
    public String translate(@PathVariable("word") String word) {
        return "The word cannot be translated now!) ";
    }
}
