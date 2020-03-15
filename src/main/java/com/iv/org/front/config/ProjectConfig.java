package com.iv.org.front.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.iv.org.biz.config.ServiceConfig;

@Configuration
@ComponentScan("com.iv.org.front.controller")
public class ProjectConfig {

}
