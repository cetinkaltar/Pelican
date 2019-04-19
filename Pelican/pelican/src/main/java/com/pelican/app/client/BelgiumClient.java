package com.pelican.app.client;

import com.pelican.app.client.fallback.BelgiumFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by cetin on 4/19/2019.
 */
@FeignClient(name = "belgium-service", fallback = BelgiumFallbackService.class)
public interface BelgiumClient {
    @GetMapping(path = "/translation/{word}")
    public String translate(@PathVariable("word") String word);
}
