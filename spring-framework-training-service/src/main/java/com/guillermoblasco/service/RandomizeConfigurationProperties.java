package com.guillermoblasco.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(value = "com.guillermoblasco.randomize")
public class RandomizeConfigurationProperties {

    private long defaultSeed = 5000;

}
