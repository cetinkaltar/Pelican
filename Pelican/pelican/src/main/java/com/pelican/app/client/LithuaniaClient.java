package com.pelican.app.client;

import com.pelican.app.client.fallback.LithuaniaFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by cetin on 4/19/2019.
 */
@FeignClient(name = "lithuania-service", fallback = LithuaniaFallbackService.class)
public interface LithuaniaClient {
    @GetMapping(path = "/translation/{word}")
    public String translate(@PathVariable("word") String word);
}
