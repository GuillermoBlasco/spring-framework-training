package com.guillermoblasco.web;

import com.guillermoblasco.service.RandomizeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RandomizeController {

    private final RandomizeService randomizeService;

    @PostMapping(path = "/randomize")
    public RandomizeResponse randomize(@RequestBody RandomizeRequest request) {
        List<String> randomize = randomizeService.randomize(request.getTerms(), request.getSeed());
        return new RandomizeResponse(randomize);
    }


    @Data
    @RequiredArgsConstructor
    public static class RandomizeResponse {
        private final List<String> terms;
    }

    @Data
    public static class RandomizeRequest {
        List<String> terms;
        Long seed;
    }

}
