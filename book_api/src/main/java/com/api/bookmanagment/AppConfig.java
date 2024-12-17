package com.api.bookmanagment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.api.bookmanagment.controllers","com.api.bookmanagment.bookEntitiesAndMethods"})
public class AppConfig {
    //Auto scan all the beans
}
