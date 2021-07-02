package com.example.demo.preparation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "custom")
public class ReadConfiguration {
    public String prop;
}
