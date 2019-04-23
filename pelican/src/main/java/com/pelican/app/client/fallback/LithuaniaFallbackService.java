package com.pelican.app.client.fallback;

import com.pelican.app.client.EstoniaClient;
import com.pelican.app.client.LithuaniaClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by cetin on 4/19/2019.
 */
@Component
public class LithuaniaFallbackService implements LithuaniaClient {

    @Override
    public String translate(@PathVariable("word") String word) {
        return "The word cannot be translated now!)";
    }
}
