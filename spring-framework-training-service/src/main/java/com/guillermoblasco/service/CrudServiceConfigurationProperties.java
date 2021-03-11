package com.guillermoblasco.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(value = "com.guillermoblasco.crud")
public class CrudServiceConfigurationProperties {

    private int maxSize = 5000;

}
