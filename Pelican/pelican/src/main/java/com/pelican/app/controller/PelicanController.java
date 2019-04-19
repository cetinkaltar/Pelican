package com.pelican.app.controller;

import com.pelican.app.client.BelgiumClient;
import com.pelican.app.client.EstoniaClient;
import com.pelican.app.client.LithuaniaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cetin on 4/18/2019.
 */
@RestController
public class PelicanController {

    @Autowired
    EstoniaClient estoniaClient;
    @Autowired
    LithuaniaClient lithuaniaClient;
    @Autowired
    BelgiumClient belgiumClient;

    @GetMapping(path = "/country/{country}/{word}", produces = "application/json")
    public ResponseEntity<String> translate(@PathVariable("country") String country, @PathVariable("word") String word) {
        switch (country) {
            case "Estonia":
                String translation = estoniaClient.translate(word);
                //exception for estonia to make uppercase the first letter
                if (translation != null)
                    translation = translation.substring(0, 1).toUpperCase() + translation.substring(1);
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body("{\"data\": \"" + translation + "\"}");
            case "Lithuania":
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body("{\"data\": \"" + lithuaniaClient.translate(word) + "\"}");
            case "Belgium":
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .body("{\"data\": \"" + belgiumClient.translate(word) + "\"}");
            default:
                return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}
