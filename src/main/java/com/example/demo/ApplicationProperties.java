package com.example.demo;

import java.util.HashMap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@EnableConfigurationProperties()
@ConfigurationProperties(prefix = "app")
@Component
public class ApplicationProperties {

	private HashMap<String,String> messages;
}
