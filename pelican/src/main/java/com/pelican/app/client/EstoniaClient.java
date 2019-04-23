package com.pelican.app.client;

import com.pelican.app.client.fallback.EstoniaFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by cetin on 4/18/2019.
 */
@FeignClient(name = "estonia-service", fallback = EstoniaFallbackService.class)
public interface EstoniaClient {
    @GetMapping(path = "/translation/{word}")
    public String translate(@PathVariable("word") String word);
}
