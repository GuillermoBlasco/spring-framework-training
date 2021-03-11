package com.guillermoblasco.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(CrudServiceConfigurationProperties.class)
public class CrudServiceConfiguration {

    private final CrudServiceConfigurationProperties properties;

    /*
    Bean factory
     */
    @Bean
    public CrudService<Course> crudService() {
        return new CrudService<>(properties.getMaxSize(), Course.class);
    }

    @Bean
    @Primary
    public CrudService<Student> studentService() {
        return new CrudService<>(properties.getMaxSize(), Student.class);
    }



}
