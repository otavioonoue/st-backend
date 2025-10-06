package com.softtek.backend.src.presentation.controller;

import java.util.Map;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class PathConfig implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();
        mapping.setPathPrefixes(Map.of(
            "/admin", clazz -> clazz.getPackageName().startsWith("com.softtek.backend.src.presentation.controller.admin"),
            "/user", clazz -> clazz.getPackageName().startsWith("com.softtek.backend.src.presentation.controller.user")
        ));
        return mapping;
    }
}
