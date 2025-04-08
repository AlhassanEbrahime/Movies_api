package org.project.movieapi.Configurations;

import org.project.movieapi.Services.Impl.OMDbClientService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    private final OMDbApiConfig omDbApiConfig;

    public AppConfig(OMDbApiConfig omDbApiConfig) {
        this.omDbApiConfig = omDbApiConfig;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder()
                .rootUri(omDbApiConfig.getApiUrl())
                .build();
    }

    @Bean
    public OMDbClientService omDbClientService(RestTemplate restTemplate){
        return new OMDbClientService(restTemplate, omDbApiConfig.getApiKey());
    }


}
