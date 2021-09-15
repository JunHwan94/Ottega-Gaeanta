package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/api/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/api/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/api/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/dist/")
//                .resourceChain(true)
//                .addResolver(new PathResourceResolver() {
//                    @Override
//                    protected Resource getResource(String resourcePath, Resource location) throws IOException {
//                        Resource requestResource = location.createRelative(resourcePath);
//                        return requestResource.exists() && requestResource.isReadable()
//                                ? requestResource : new ClassPathResource("/dist/index.html");
//                    }
//                });
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/dist/css/");

        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/dist/fonts/");

        registry.addResourceHandler("/icons/**")
                .addResourceLocations("classpath:/dist/icons/");

        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/dist/img/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/dist/js/");


    }
}
