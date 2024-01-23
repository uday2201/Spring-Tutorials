package com.myspringbootlearning.Spring.Tutorials.config;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

@Configuration
@PropertySource("classpath:sample.properties")
@ConfigurationProperties(prefix = "dev")
@Validated
public class AppConfig {

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getUsername() {
        return username;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @NotNull
    @Size(min=5, max = 10)
    private String username;

    @NotNull
    private String welcomeMessage;

}
