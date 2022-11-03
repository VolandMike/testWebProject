package com.example.producerclient.config;

import com.example.producerclient.utils.RequestType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "service")
@Getter
@Setter
public class ServiceConfig {
    private Map<RequestType, List<String>> serviceUrls;

}
