package com.belgium.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by cetin on 4/19/2019.
 */
@RestController
public class TranslationController {

    @GetMapping(path="/translation/{word}")
    public String translate(@PathVariable("word") String word) {
        HashMap<String,String> dictionary =new HashMap<>();
        dictionary.put("hello","Bonjour");
        return dictionary.get(word.toLowerCase());
    }
}
