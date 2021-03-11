package com.guillermoblasco.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@EnableConfigurationProperties(RandomizeConfigurationProperties.class)
public class RandomizeService {

    private final RandomizeConfigurationProperties properties;

    public RandomizeService(RandomizeConfigurationProperties properties) {
        this.properties = properties;
    }

    public List<String> randomize(List<String> terms, Long seed) {
        if (seed == null) {
            seed = properties.getDefaultSeed();
        }
        Random random = new Random(seed);
        List<String> out = new ArrayList<>(terms);
        Collections.shuffle(out, random);
        return out;
    }

}
