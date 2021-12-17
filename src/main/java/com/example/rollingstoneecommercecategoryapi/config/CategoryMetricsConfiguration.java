package com.example.rollingstoneecommercecategoryapi.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class CategoryMetricsConfiguration {

    @Bean
    public Counter createCategoryCreationCounter(MeterRegistry registry){
        return Counter.builder("com.example.rollingstoneecommercecategoryapi.category.created")
                .description("Number of Categories created")
                .tags("environment", "production")
                .register(registry);
    }

    @Bean
    public Counter http400ExceptionCounter(MeterRegistry registry){
        return Counter.builder("com.example.rollingstoneecommercecategoryapi.CategoryController.HTTP400")
                .description("How many Http Bad Request Http400 Requests have been received since start time of this instance.")
                .tags("environment", "production")
                .register(registry);
    }

    @Bean
    public Counter http404ExceptionCounter(MeterRegistry registry){
        return Counter.builder("com.example.rollingstoneecommercecategoryapi.CategoryController.HTTP404")
                .description("How many Http Resource Not Found Http404 Requests have been received since start time of this instance.")
                .tags("environment", "production")
                .register(registry);
    }

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }
}
