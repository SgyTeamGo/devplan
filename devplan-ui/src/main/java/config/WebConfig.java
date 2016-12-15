package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by zaven.chilingaryan on 12/2/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "controller")
@Import({UserConfig.class, EventConfig.class})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    @RequestScope
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/events/**").allowedOrigins("http://localhost:4200");
            }
        };
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
