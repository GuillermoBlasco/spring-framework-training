package com.guillermoblasco.web;

import com.guillermoblasco.data.Course;
import com.guillermoblasco.data.CourseRepository;
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

    @PostMapping(path = "/randomize")
    public RandomizeResponse randomize(@RequestBody RandomizeRequest request) {
        Random random = new Random(request.getSeed());
        List<String> terms = new ArrayList<>(request.getTerms());
        Collections.shuffle(terms, random);
        return new RandomizeResponse(terms);
    }


    @Data
    @RequiredArgsConstructor
    public static class RandomizeResponse {
        private final List<String> terms;
    }

    @Data
    public static class RandomizeRequest {
        List<String> terms;
        long seed = System.currentTimeMillis();
    }

}
